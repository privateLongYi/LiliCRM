package com.linxi.service;

import com.linxi.entity.Payrecord;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/5 14:24
 */
public interface IPayrecordService {

    //根据成交客户编号查询支付记录
    List<Payrecord> queryPByPaySId(Integer paySId);

    //根据成交客户编号查询支付记录总数
    Integer getTotalByPaySId(Integer paySId);

    //新增支付记录
    void savePayrecord(Payrecord payrecord);

}
