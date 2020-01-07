package com.hy.mapper;

import com.hy.pojo.User;
import org.springframework.stereotype.Controller;
import tk.mybatis.mapper.common.Mapper;
@Controller
public interface UserMapper extends Mapper<User> {
}
