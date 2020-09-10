package com.linxi.mapper;

import com.linxi.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuMapper {

    //根据角色编号查询权限
    List<RoleMenu> queryRMByRId(@Param("rId") Integer rId);

    //根据角色编号删除角色菜单
    void delRMByRId(@Param("rId") Integer rId);

    //新增角色菜单
    void saveRoleMenu(@Param("rId") Integer rId,
                      @Param("mId") Integer mId);

}