package com.linxi.service;

import com.linxi.entity.CReferral;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:10
 */
public interface ICReferralService {

    List<CReferral> queryCR(@Param("page") Integer page,
                            @Param("limit") Integer limit);

    Integer getTotal();

    void saveCReferral(CReferral cr);

    void delCRByCrId(Integer crId);

    CReferral queryCRByCrId(Integer crId);

    void editCRByCrId(CReferral cr);

    List<CReferral> queryCRByCrCtId(@Param("crCtId") Integer crCtId,
                                  @Param("page") Integer page,
                                  @Param("limit") Integer limit);

    Integer getTotalByCrCtId(Integer crCtId);

}
