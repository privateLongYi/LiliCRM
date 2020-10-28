package com.linxi.mapper;

import com.linxi.entity.Operating;

import java.sql.Timestamp;
import java.util.List;

public interface OperatingMapper {

    //新增操作记录
    Integer saveOperating(Operating op);

    //根据客户编号查询操作记录
    List<Operating> queryOpByCId(Integer cId);

    //根据线索编号查询最近的操作时间
    String queryOpTimeByClId(Integer clId);

}