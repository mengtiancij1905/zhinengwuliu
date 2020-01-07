package com.hy.controller;

import com.hy.dto.HyException;
import com.hy.jopo.ExceptionEnums;
import com.hy.pojo.User;
import com.hy.service.UserService;
import com.hy.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private static final String s = NumberUtils.generateCode(4);

    @GetMapping("/user/login")
    public ResponseEntity<User> login(@RequestParam("username")String username ,@RequestParam("password")String password,@RequestParam("code") String code){
        User query = userService.query(username, password, code);
        if (query==null){
            throw new HyException(ExceptionEnums.USER_PASS_ERROR);
        }
        return ResponseEntity.ok(query);
    }
    @PostMapping("/code")
    public ResponseEntity<Void> sendVerifyCode(String phone){
        Boolean bool = userService.sendVerifyCode(phone);
        if (bool) {
            return ResponseEntity.ok(null);
        }else {
            throw new HyException(ExceptionEnums.INSERT_ERROR);
        }

    }
}
