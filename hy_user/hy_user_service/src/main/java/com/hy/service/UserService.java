package com.hy.service;

import com.hy.dto.HyException;
import com.hy.jopo.ExceptionEnums;
import com.hy.mapper.UserMapper;
import com.hy.pojo.User;
import com.hy.utils.CodecUtils;
import com.hy.utils.NumberUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 齐桢
 * @site www.qz.com
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private AmqpTemplate amqpTemplate;
    static final String KEY_PREFIX = "user:code:phone:";

    static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public Boolean sendVerifyCode(String phone) {
        try {
            String code = NumberUtils.generateCode(6);
            Map<String, String> msg = new HashMap<String, String>();
            msg.put("phone", phone);
            msg.put("code", code);
            amqpTemplate.convertAndSend("wlkg.sms.exchange", "sms.verify.code", msg);
            this.redisTemplate.opsForValue().set(KEY_PREFIX + phone, code, 5, TimeUnit.MINUTES);
            return true;
        } catch (AmqpException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void register(User user, String code) {
        String key = KEY_PREFIX + user.getPhone();
        String codeCache = this.redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(code) || !code.equals(codeCache)) {
            throw new HyException(ExceptionEnums.INVALID_VERFIY_CODE);
        }
        try {
            user.setCreateTime(new Date());
            String salt = CodecUtils.generateSalt();
            user.setSalt(salt);
            user.setPassword(CodecUtils.md5Hex(user.getPassword(), salt));
            this.userMapper.insertSelective(user);
        } catch (Exception e) {
            throw new HyException(ExceptionEnums.INSERT_ERROR);
        }

    }

    public User query(String username, String password, String code) {
        User user = new User();
        System.out.println(username);
        user.setUsername(username);
        User user1 = userMapper.selectOne(user);
        if (user1 == null) {
            System.out.println("用户不存在");
            throw new HyException(ExceptionEnums.USER_NULL);
        }
        String key = KEY_PREFIX + user1.getPhone();
        String codeCache = this.redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(code) || !code.equals(codeCache)) {
            throw new HyException(ExceptionEnums.INVALID_VERFIY_CODE);
        }
        if (StringUtils.isBlank(password) || !(CodecUtils.md5Hex(password, user1.getSalt()).equals(user1.getPassword()))) {
            System.out.println(user1.getPassword());
            throw new HyException(ExceptionEnums.USER_PASS_ERROR);
        }
        return user1;
    }
}