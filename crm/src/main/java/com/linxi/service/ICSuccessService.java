package com.linxi.service;

import com.linxi.entity.CSuccess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:09
 */
public interface ICSuccessService {

    //高级筛选加分页查询成交
    List<CSuccess> queryCSScreen(@Param("page") Integer page,
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

    void saveCSuccess(CSuccess cs);

    void delCSByCsId(Integer csId);

    CSuccess queryCSByCsId(Integer csId);

    void editCSByCsId(CSuccess cs);

    List<CSuccess> queryCSByCsCtId(@Param("csCtId") Integer csCtId,
                                      @Param("page") Integer page,
                                      @Param("limit") Integer limit);

    Integer getTotalByCsCtId(Integer csCtId);

}
