package com.zd.zhx.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer type;
    private String img;
    private Double speed;

    public User(){}

    public User(String username, String password, Integer type, String img, Double speed) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.img = img;
        this.speed = speed;
    }

    public User(String username, String password, String type, String img, String speed) {
        this.username = username;
        this.password = password;
        this.img = img;

        if (type!=null && !type.equals("")){
            this.type=Integer.parseInt(type);
        }

        if (speed!=null && !type.equals("")){
            this.speed=Double.parseDouble(speed);
        }
    }
}
