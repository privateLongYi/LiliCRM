package com.linxi.service;

import com.linxi.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/7 19:55
 */
public interface IMenuService {

    //根据菜单名称查询菜单
    List<Menu> queryMByMName(@Param("mName") String mName,
                             @Param("page") Integer page,
                             @Param("limit") Integer limit);

    //根据菜单名称查询菜单总条数
    Integer getTotalByMName(@Param("mName") String mName);

    //查询父级菜单
    List<Menu> queryMParent();

    //新增菜单
    void saveMenu(Menu menu);

    //根据编号删除菜单
    void delMByMId(@Param("mId") Integer mId);

    //根据编号查询菜单
    Menu queryMByMId(@Param("mId") Integer mId);

    //根据编号编辑菜单
    void editMByMId(Menu menu);

    //查询所有菜单
    List<Menu> queryMenuAll();

    //根据父级编号查询所有子级菜单
    List<Menu> queryMByMPId(Integer pId);

}
