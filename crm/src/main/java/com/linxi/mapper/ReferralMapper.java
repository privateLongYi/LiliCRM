package com.linxi.mapper;

import com.linxi.entity.Referral;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReferralMapper {

    //新增转诊记录
    void saveReferral(Referral referral);

    //根据客户名称查询转诊记录
    List<Referral> queryRByCName(@Param("page") Integer page,
                                 @Param("limit") Integer limit,
                                 @Param("uId") Integer uId,
                                 @Param("rName") String rName,
                                 @Param("cName") String cName,
                                 @Param("export") Integer export);

    //根据客户名称查询转诊记录总数
    Integer getTotalByCName(@Param("uId") Integer uId,
                            @Param("rName") String rName,
                            @Param("cName") String cName);

    //根据预约编号查询转诊
    List<Referral> queryRByRAId(Integer rAId);

}