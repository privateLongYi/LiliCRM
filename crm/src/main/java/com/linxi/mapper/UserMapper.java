package com.linxi.mapper;

import com.linxi.entity.User;

public interface UserMapper {

    //登录
    User login(User user);

    //查询所有销售员
    User queyrUserByURoleId(Integer uRoleId);

}