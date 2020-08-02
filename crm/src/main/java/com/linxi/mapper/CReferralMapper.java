package com.linxi.mapper;

import com.linxi.entity.CReferral;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CReferralMapper {

    List<CReferral> queryCR(@Param("page") Integer page,
                           @Param("limit") Integer limit);

    Integer getTotal();

    void saveCReferral(CReferral cr);

    void delCRByCrId(Integer crId);

    CReferral queryCRByCrId(Integer crId);

    void editCRByCrId(CReferral cr);

    List<CReferral> queryCRByCrCId(@Param("crCId") Integer crCId,
                                      @Param("page") Integer page,
                                      @Param("limit") Integer limit);

    Integer getTotalByCrCId(Integer crCId);

}