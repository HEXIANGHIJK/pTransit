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

    @Override
    public User insertUser(User user) {
        try {
            userMapper.insertUser(user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Double getUserSpeed(User user) {
        return userMapper.getUserSpeed(user.getUsername());
    }

    @Override
    public Double getUserSpeed(String username) {
        return userMapper.getUserSpeed(username);
    }

    @Override
    public User userUpdate(String username, String password, String type, String img, String speed) {
        userMapper.userUpdate(username, password, type, img, speed);//
        return userMapper.findByUsername(username);
    }

    @Override
    public void userDel(String username) {
        userMapper.userDel(username);
    }
}
