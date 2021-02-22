package com.linxi.mapper;

import com.linxi.entity.Success;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuccessMapper {

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

    //根据筛选条件查询成交客户
    List<Success> querySByScreen(@Param("page") Integer page,
                                 @Param("limit") Integer limit,
                                 @Param("uId") Integer uId,
                                 @Param("rName") String rName,
                                 @Param("cName") String cName,
                                 @Param("cTel") String cTel,
                                 @Param("sHId") Integer sHId,
                                 @Param("queryUId") Integer queryUId,
                                 @Param("beginTime") String beginTime,
                                 @Param("endTime") String endTime,
                                 @Param("export") Integer export);

    //根据筛选条件查询成交客户总数
    Integer getTotalByScreen(@Param("uId") Integer uId,
                             @Param("rName") String rName,
                             @Param("cName") String cName,
                             @Param("cTel") String cTel,
                             @Param("sHId") Integer sHId,
                             @Param("queryUId") Integer queryUId,
                             @Param("beginTime") String beginTime,
                             @Param("endTime") String endTime);

    //根据成交客户编号编辑成交金额和支付金额
    void editMoneyBySId(@Param("sId") Integer sId,
                        @Param("sSum") Double sSum,
                        @Param("sPaysum") Double sPaysum);

    //根据线索编号查询总成交金额
    Double queryTotalMoneyByClId(@Param("clId") Integer cId,
                                  @Param("type") Integer type);

    //根据用户编号和客户名称查询成交客户
    List<Success> querySCByUIdAndCName(@Param("rName") String rName,
                                       @Param("uId") Integer uId,
                                       @Param("cName") String cName,
                                       @Param("page") Integer page);

    //根据用户编号和客户名称查询成交客户总条数
    Integer getTotalSCByUIdAndCName(@Param("rName") String rName,
                                    @Param("uId") Integer uId,
                                    @Param("cName") String cName);

    //根据用户编号和起止时间查询成交
    List<Success> querySByTime(@Param("page") Integer page,
                               @Param("limit") Integer limit,
                               @Param("uId") Integer uId,
                               @Param("rName") String rName,
                               @Param("beginTime") String beginTime,
                               @Param("endTime") String endTime);

    //根据用户编号和起止时间查询成交数量
    Integer getTotalByTime(@Param("uId") Integer uId,
                           @Param("rName") String rName,
                           @Param("beginTime") String beginTime,
                           @Param("endTime") String endTime);

    //根据用户编号和起止时间查询成交总金额/支付总金额
    Double queryMoneyByTime(@Param("uId") Integer uId,
                             @Param("rName") String rName,
                             @Param("beginTime") String beginTime,
                             @Param("endTime") String endTime,
                             @Param("type") Integer type);

    //根据门诊分组查询总成交额
    List<Success> querySSumGruopByHId(@Param("beginTime") String beginTime,
                                      @Param("endTime") String endTime);

    //根据用户分组查询总成交额
    List<Success> querySSumGruopByUId(@Param("beginTime") String beginTime,
                                      @Param("endTime") String endTime);

    //根据报名项目分组查询总成交额
    List<Success> querySSumGruopByCProject(@Param("beginTime") String beginTime,
                                           @Param("endTime") String endTime);

    //根据预约编号查询成交
    List<Success> querySBySAId(Integer sAId);

    //根据预约编号查询成交总金额
    Double querySSumBySAId(Integer sAId);

    //查询最大的成交编号
    Integer queryMaxSId();

    //根据筛选条件查询成交金额或支付金额
    Double queryMoneyByScreen(@Param("uId") Integer uId,
                               @Param("rName") String rName,
                               @Param("cName") String cName,
                               @Param("cTel") String cTel,
                               @Param("sHId") Integer sHId,
                               @Param("queryUId") Integer queryUId,
                               @Param("beginTime") String beginTime,
                               @Param("endTime") String endTime,
                               @Param("type") Integer type);

    //根据筛选条件分组查询退款总金额
    List<Success> queryRefundByScreen(@Param("uId") Integer uId,
                                      @Param("rName") String rName,
                                      @Param("cName") String cName,
                                      @Param("cTel") String cTel,
                                      @Param("sHId") Integer sHId,
                                      @Param("queryUId") Integer queryUId,
                                      @Param("beginTime") String beginTime,
                                      @Param("endTime") String endTime);

    //根据线索编号查询退款总金额
    Double queryRefundByClId(@Param("clId") Integer clId);

    //根据线索编号查询最早成交
    Success queryFirstSByClId(Integer clId);

}