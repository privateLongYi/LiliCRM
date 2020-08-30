package com.linxi.service.impl;

import com.linxi.entity.RoleMenu;
import com.linxi.mapper.RoleMenuMapper;
import com.linxi.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/24 19:50
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RoleMenuService implements IRoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<RoleMenu> queryRoleMenuByRoleId(Integer roleId) {
        return roleMenuMapper.queryRoleMenuByRoleId(roleId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<RoleMenu> queryRoleMenu() {
        return roleMenuMapper.queryRoleMenu();
    }
}
