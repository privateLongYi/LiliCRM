package com.linxi.mapper;

import com.linxi.entity.Follow;

import java.util.List;

public interface FollowMapper {

    //根据客户编号查询客户跟进
    List<Follow> queryFByFCId(Integer fCId);

    //新增客户跟进
    void saveFollow(Follow follow);

}