package com.linxi.service;

import com.linxi.entity.Success;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/3 20:08
 */
public interface ISuccessService {

    //根据客户编号查询成交客户
    List<Success> querySBySCId(Integer sCId);

    //根据客户编号查询成交客户总条数
    Integer getTotalBySCId(Integer sCId);

    //根据成交客户编号删除成交客户
    void delSBySId(Integer sId);

    //根据成交客户编号查询成交客户
    Success querySBySId(Integer sId);

    //根据成交客户编号编辑成交客户
    void editSBySId(Success success);

    //新增成交客户
    void saveSuccess(Success success);

}
