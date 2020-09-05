package com.linxi.mapper;

import com.linxi.entity.Operating;

import java.util.List;

public interface OperatingMapper {

    /***
     * 添加操作记录
     * @param op 操作记录对象
     * @return
     */
    Integer addOperatingRecord(Operating op);

    //根据客户编号查询操作记录
    List<Operating> queryOpByOpCId(Integer opCId);

}