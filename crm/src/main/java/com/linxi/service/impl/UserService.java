package com.linxi.service.impl;

import com.linxi.entity.User;
import com.linxi.mapper.UserMapper;
import com.linxi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author LongYi
 * @create 2020/7/31 19:57
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queyrUserByURoleId(Integer uRoleId) {
        return userMapper.queyrUserByURoleId(uRoleId);
    }
}
