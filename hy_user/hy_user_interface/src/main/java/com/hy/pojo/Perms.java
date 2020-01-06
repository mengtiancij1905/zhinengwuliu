package com.hy.pojo;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "tb_perms")
public class Perms {

    private Integer id;
    private String perms;
    private String remark;

}
