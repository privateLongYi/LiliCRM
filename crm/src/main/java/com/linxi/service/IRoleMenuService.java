package com.linxi.service;

import com.linxi.entity.RoleMenu;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/24 19:49
 */
public interface IRoleMenuService {

    //根据角色编号查询权限
    List<RoleMenu> queryRoleMenuByRoleId(Integer roleId);

    //查询所有权限
    List<RoleMenu> queryRoleMenu();

}
