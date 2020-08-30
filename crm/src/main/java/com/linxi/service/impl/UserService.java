package com.linxi.service.impl;

import com.linxi.entity.User;
import com.linxi.mapper.UserMapper;
import com.linxi.service.IUserService;
import com.linxi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/7/31 19:57
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findByLoginName(String username) {
        return userMapper.findByLoginName(username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryUserByRName() {
        return userMapper.queryUserByRName();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public String queryRNameByRId(Integer uRoleId) {
        return userMapper.queryRNameByRId(uRoleId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryUserByUNameAndRId(Integer page, Integer limit, String uName, Integer uRoleId) {
        return userMapper.queryUserByUNameAndRId(page, limit, uName, uRoleId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByUNameAndRId(String uName, Integer uRoleId) {
        return userMapper.getTotalByUNameAndRId(uName, uRoleId);
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }
}
