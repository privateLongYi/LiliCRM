package com.linxi.mapper;

import com.linxi.entity.User;
import com.linxi.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //登录
    User login(@Param("uName") String uName,
                       @Param("uPassword") String uPassword);

    //查询角色为销售员的所有用户
    List<User> queryUserByRName();

}