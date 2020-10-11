package com.linxi.service;

import com.linxi.entity.Success;
import org.apache.ibatis.annotations.Param;

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

    //根据客户名称查询未成交客户
    List<Success> querySByCName(@Param("page") Integer page,
                                @Param("limit") Integer limit,
                                @Param("uId") Integer uId,
                                @Param("rName") String rName,
                                @Param("cName") String cName);

    //根据客户名称查询未成交客户总数
    Integer getTotalByCName(@Param("uId") Integer uId,
                            @Param("rName") String rName,
                            @Param("cName") String cName);

    //根据成交客户编号编辑支付金额
    void editSPaysumBySId(@Param("sId") Integer sId, @Param("paySum") Integer paySum);

    //根据客户编号查询总成交金额
    Integer queryTotalMoneyByCId(@Param("cId") Integer cId, @Param("type") Integer type);

}
