package com.linxi.mapper;

import com.linxi.entity.Operating;

public interface OperatingMapper {

    /***
     * 添加操作记录
     * @param op 操作记录对象
     * @return
     */
    Integer addOperatingRecord(Operating op);

}