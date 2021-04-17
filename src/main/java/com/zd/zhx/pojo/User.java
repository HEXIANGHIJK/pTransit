package com.zd.zhx.pojo;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private Integer type;
    private String img;
    private Double speed;
}
