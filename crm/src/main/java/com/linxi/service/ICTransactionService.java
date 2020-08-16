package com.linxi.service;

import com.linxi.entity.CTransaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:09
 */
public interface ICTransactionService {

    //高级筛选加分页查询预约
    List<CTransaction> queryCTScreen(@Param("page") Integer page,
                               @Param("limit") Integer limit,
                               @Param("cName") String cName,
                               @Param("cTel") String cTel,
                               @Param("cProject") String cProject,
                               @Param("ctHospital") String ctHospital,
                               @Param("cEarnest") Integer cEarnest,
                               @Param("beginTime") String beginTime,
                               @Param("endTime") String endTime,
                               @Param("uId") Integer uId,
                               @Param("cSource") String cSource,
                               @Param("cStatu") String cStatu);

    Integer getTotal();

    void saveCTransaction(CTransaction ct);

    void delCTByCtId(Integer ctId);

    CTransaction queryCTByCtId(Integer ctId);

    void editCTByCtId(CTransaction ct);

    List<CTransaction> queryCTByCtCId(@Param("ctCId") Integer ctCId,
                                      @Param("page") Integer page,
                                      @Param("limit") Integer limit);

    Integer getTotalByCtCId(Integer ctCId);

}
