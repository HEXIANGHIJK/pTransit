package com.zd.zhx.service.impl;

import com.zd.zhx.mapper.UserMapper;
import com.zd.zhx.pojo.User;
import com.zd.zhx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
