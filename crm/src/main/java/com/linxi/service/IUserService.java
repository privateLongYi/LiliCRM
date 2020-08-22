package com.linxi.service;

import com.linxi.entity.User;
import com.linxi.util.Result;
import org.apache.ibatis.annotations.Param;

/**
 * @Author LongYi
 * @create 2020/7/31 19:54
 */
public interface IUserService {

    //登录
    User login(@Param("uName") String uName,
                       @Param("uPassword") String uPassword);

}
