package com.linxi.service;

import com.linxi.entity.CTransaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:09
 */
public interface ICTransactionService {

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
