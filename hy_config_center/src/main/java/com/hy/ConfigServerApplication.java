package com.hy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author赐的程序
 * @site www.xiaomage.com
 * @company xxx公司
 * @create  2020-01-06 18:48
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}
