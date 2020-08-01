package com.linxi.service.impl;

import com.linxi.entity.User;
import com.linxi.mapper.UserMapper;
import com.linxi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author LongYi
 * @create 2020/7/31 19:57
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private UserMapper userMapper;

    public User login(User user) {
        return userMapper.login(user);
    }
}
