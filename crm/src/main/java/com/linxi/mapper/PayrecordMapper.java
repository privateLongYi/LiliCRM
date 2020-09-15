package com.linxi.mapper;

import com.linxi.entity.Payrecord;

import java.util.List;

public interface PayrecordMapper {

    //根据成交客户编号查询支付记录
    List<Payrecord> queryPByPaySId(Integer paySId);

    //根据成交客户编号查询支付记录总数
    Integer getTotalByPaySId(Integer paySId);

    //新增支付记录
    void savePayrecord(Payrecord payrecord);

    //根据成交客户编号查询支付总金额
    Integer queryPPaysumBySId(Integer sId);

}