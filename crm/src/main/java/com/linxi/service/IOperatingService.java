package com.linxi.service;

import com.linxi.entity.Operating;

import java.util.List;

/**
 * @author Arthas
 * @date 2020/8/23 20:46
 */
public interface IOperatingService {

    /***
     * 添加操作记录
     * @param op 操作记录对象
     * @return
     */
    Integer addOperatingRecord(Operating op);

    //根据客户编号查询操作记录
    List<Operating> queryOpByOpCId(Integer opCId);

}
