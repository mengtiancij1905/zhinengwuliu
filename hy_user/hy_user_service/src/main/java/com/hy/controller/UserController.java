package com.hy.controller;

import com.hy.pojo.User;
import com.hy.service.UserSercvice;
import com.hy.dto.HyException;
import com.hy.jopo.ExceptionEnums;
import com.hy.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserSercvice userSercvice;

    @Autowired
    private static final String s = NumberUtils.generateCode(4);

    @GetMapping("/user/login")
    public ResponseEntity<User> login(User user ,String num){
        if (num==null){
            return null;
        }
        num.equals(s);
        userSercvice.queryUserId(user);
        return ResponseEntity.ok(null);
    }
    @GetMapping("/user/num")
    public ResponseEntity<String> login(){
        try {
           return ResponseEntity.ok(s);
        }catch (Exception e){
            throw new HyException(ExceptionEnums.GOODS_NOT_FOUND);
        }

    }
}
