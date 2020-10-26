package com.linxi.service;

import com.linxi.entity.Operating;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Arthas
 * @date 2020/8/23 20:46
 */
public interface IOperatingService {

    //新增操作记录
    Integer saveOperating(Operating op);

    //根据线索编号查询操作记录
    List<Operating> queryOpByClId(Integer clId);

    //根据线索编号查询最近的操作时间
    String queryOpTimeByClId(Integer clId);

}
