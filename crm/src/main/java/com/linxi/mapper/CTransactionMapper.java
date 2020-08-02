package com.linxi.mapper;

import com.linxi.entity.CTransaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CTransactionMapper {

    List<CTransaction> queryCT(@Param("page") Integer page,
                               @Param("limit") Integer limit);

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