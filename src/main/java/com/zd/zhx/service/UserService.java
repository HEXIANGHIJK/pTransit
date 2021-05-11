package com.zd.zhx.service;

import com.zd.zhx.pojo.User;

public interface UserService {

    User findByUsername(String username);

    User insertUser(User user);

    Double getUserSpeed(User user);
    Double getUserSpeed(String username);

    User userUpdate(String username, String password, String type, String img, String speed);

    void userDel(String username);
}
