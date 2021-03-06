package com.linxi.service;

import com.linxi.entity.Payrecord;
import org.apache.ibatis.annotations.Param;

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

    //根据成交客户编号查询支付总金额
    Double queryPPaysumBySId(Integer sId);

    //根据成交客户编号查询退款总金额
    Double queryRefundBySId(Integer sId);

    //根据筛选条件查询支付记录
    List<Payrecord> queryPByScreen(@Param("page") Integer page,
                                   @Param("limit") Integer limit,
                                   @Param("uId") Integer uId,
                                   @Param("hId") Integer hId,
                                   @Param("payId") Integer payId,
                                   @Param("beginTime") String beginTime,
                                   @Param("endTime") String endTime);

    //根据筛选条件查询支付记录总条数
    Integer getTotalByScreen(@Param("uId") Integer uId,
                             @Param("hId") Integer hId,
                             @Param("payId") Integer payId,
                             @Param("beginTime") String beginTime,
                             @Param("endTime") String endTime);

}
