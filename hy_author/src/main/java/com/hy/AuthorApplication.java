package com.hy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author赐的程序
 * @site www.xiaomage.com
 * @company xxx公司
 * @create  2020-01-06 21:37
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class AuthorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorApplication.class,args);
    }
}
