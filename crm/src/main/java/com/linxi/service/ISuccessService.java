package com.linxi.service;

import com.linxi.entity.Success;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/3 20:08
 */
public interface ISuccessService {

    //根据线索编号查询成交客户
    List<Success> querySByClId(@Param("clId") Integer clId,
                               @Param("page") Integer page,
                               @Param("limit") Integer limit);

    //根据线索编号查询成交客户总条数
    Integer getTotalByClId(Integer clId);

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

    //根据线索编号查询总成交金额
    Integer queryTotalMoneyByClId(@Param("clId") Integer clId,
                                  @Param("type") Integer type);

    //根据用户编号和客户名称查询成交客户
    List<Success> querySCByUIdAndCName(@Param("rName") String rName,
                                       @Param("uId") Integer uId,
                                       @Param("cName") String cName);

    //根据用户编号和起止时间查询成交总数
    Integer querySByUIdAndTime(@Param("uId") Integer uId,
                               @Param("beginTime") String beginTime,
                               @Param("endTime") String endTime);

    //根据用户编号和起止时间查询成交总金额
    Integer querySSumByUIdAndTime(@Param("uId") Integer uId,
                                  @Param("beginTime") String beginTime,
                                  @Param("endTime") String endTime);

    //根据用户编号和起止时间查询收款总金额
    Integer querySPaysumByUIdAndTime(@Param("uId") Integer uId,
                                     @Param("beginTime") String beginTime,
                                     @Param("endTime") String endTime);

    //根据门诊分组查询总成交额
    List<Success> querySSumGruopByHId(@Param("beginTime") String beginTime,
                                      @Param("endTime") String endTime);

    //根据用户分组查询总成交额
    List<Success> querySSumGruopByUId(@Param("beginTime") String beginTime,
                                      @Param("endTime") String endTime);

    //根据报名项目分组查询总成交额
    List<Success> querySSumGruopByCProject(@Param("beginTime") String beginTime,
                                           @Param("endTime") String endTime);

}
