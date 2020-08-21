package com.linxi.service;

import com.linxi.entity.CFail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:11
 */
public interface ICFailService {

    //高级筛选加分页查询成交
    List<CFail> queryCFScreen(@Param("page") Integer page,
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

    void saveCFail(CFail cf);

    void delCFByCfId(Integer cfId);

    CFail queryCFByCfId(Integer cfId);

    void editCFByCfId(CFail cf);

}