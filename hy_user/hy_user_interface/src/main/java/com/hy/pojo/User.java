package com.hy.pojo;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User {


    private Integer id;
    private String phone;
    private String password;
    private String username;
    private String email;
    private String company;
    private String  referrerPhone;
    private Integer companyId;
    private String salt;
    private Integer roleId;
    private Date createTime;

}
