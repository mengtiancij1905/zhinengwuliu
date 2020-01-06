package com.hy.service;

import com.hy.mapper.UserMapper;
import com.hy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSercvice {
    @Autowired
    private UserMapper userMapper;
    public Boolean queryUserId(User user) {
        User myUser = userMapper.selectByPrimaryKey(user.getId());
        if (myUser.getPassword()==null){
            return false;
    }
        return myUser.getPassword().equals(user.getPassword());
    }
}
