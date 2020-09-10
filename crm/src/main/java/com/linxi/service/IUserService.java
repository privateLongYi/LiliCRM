package com.linxi.service;

import com.linxi.entity.User;
import com.linxi.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/7/31 19:54
 */
public interface IUserService {

    //根据用户名查询用户
    User findByLoginName(String userame);

    //查询角色为销售员的所有用户
    List<User> queryUserByRName();

    //根据角色编号查询角色名称
    String queryRNameByRId(Integer uRoleId);

    //根据用户名和角色编号查询用户
    List<User> queryUserByUNameAndRId(@Param("page") Integer page,
                                      @Param("limit") Integer limit,
                                      @Param("uName") String uName,
                                      @Param("uRoleId") Integer uRoleId);

    //根据用户名和角色查询总条数
    Integer getTotalByUNameAndRId(@Param("uName") String uName,
                                  @Param("uRoleId") Integer uRoleId);

    //新增用户
    void saveUser(User user);

    //根据编号删除用户
    void delUByUId(Integer uId);

    //根据编号查询用户
    User queryUByUId(Integer uId);

    //根据编号编辑用户
    void editUByUId(User user);

}
