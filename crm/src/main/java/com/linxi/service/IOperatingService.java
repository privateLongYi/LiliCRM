package com.linxi.service;

import com.linxi.entity.Operating;

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
}
