package com.linxi.service;

import com.linxi.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/24 19:49
 */
public interface IRoleMenuService {

    //根据角色编号查询权限
    List<RoleMenu> queryRMByRId(@Param("rId") Integer rId);

    //根据角色编号删除角色菜单
    void delRMByRId(@Param("rId") Integer rId);

    //新增角色菜单
    void saveRoleMenu(@Param("rId") Integer rId,
                      @Param("mId") Integer mId);

}
