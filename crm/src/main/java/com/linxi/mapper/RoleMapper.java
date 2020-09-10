package com.linxi.mapper;

import com.linxi.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    //查询所有角色
    List<Role> queryRole();

    //根据角色名查询角色
    List<Role> queryRByRName(@Param("rName") String rName,
                             @Param("page") Integer page,
                             @Param("limit") Integer limit);

    //根据角色名查询角色总条数
    Integer getTotalByRName(@Param("rName") String rName);

    //新增角色
    void saveRole(Role role);

    //根据编号删除角色
    void delRByRId(Integer rId);

    //根据编号查询角色
    Role queryRByRId(Integer rId);

    //根据编号编辑角色
    void editRByRId(Role role);

}