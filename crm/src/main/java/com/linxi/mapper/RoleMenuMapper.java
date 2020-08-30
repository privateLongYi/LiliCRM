package com.linxi.mapper;

import com.linxi.entity.RoleMenu;

import java.util.List;

public interface RoleMenuMapper {

    //根据角色编号查询权限
    List<RoleMenu> queryRoleMenuByRoleId(Integer roleId);

    //查询所有权限
    List<RoleMenu> queryRoleMenu();

}