package com.linxi.mapper;

import com.linxi.entity.Payrecord;
import org.apache.ibatis.annotations.Param;

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