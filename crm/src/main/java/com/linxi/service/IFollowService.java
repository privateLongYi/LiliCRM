package com.linxi.service;

import com.linxi.entity.Follow;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/5 15:42
 */
public interface IFollowService {

    //根据客户编号查询客户跟进
    List<Follow> queryFByFCId(Integer fCId);

}
