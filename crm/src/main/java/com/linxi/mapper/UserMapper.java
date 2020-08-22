package com.linxi.mapper;

import com.linxi.entity.User;
import com.linxi.util.Result;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //登录
    User login(@Param("uName") String uName,
                       @Param("uPassword") String uPassword);

}