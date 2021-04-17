package com.zd.zhx.service;

import com.zd.zhx.pojo.User;

public interface UserService {

    public User findByUsername(String username);
}
