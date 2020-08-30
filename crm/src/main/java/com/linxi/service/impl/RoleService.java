package com.linxi.service.impl;

import com.linxi.entity.Role;
import com.linxi.mapper.RoleMapper;
import com.linxi.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/30 15:15
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RoleService implements IRoleService{

    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Role> queryRole() {
        return roleMapper.queryRole();
    }
}
