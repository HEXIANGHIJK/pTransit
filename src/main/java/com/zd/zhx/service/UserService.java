package com.zd.zhx.service;

import com.zd.zhx.pojo.User;

public interface UserService {

    public User findByUsername(String username);

    public User insertUser(User user);

    public Double getUserSpeed(User user);
    public Double getUserSpeed(String username);

}
