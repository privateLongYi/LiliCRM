package com.linxi.service;

import com.linxi.entity.CArrive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/8 10:34
 */
public interface ICArriveService {

    //高级筛选加分页查询未到店
    List<CArrive> queryCAScreen(@Param("page") Integer page,
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

    void saveCArrive(CArrive ca);

    void delCAByCaId(Integer caId);

    CArrive queryCAByCaId(Integer caId);

    void editCAByCaId(CArrive ca);

}
