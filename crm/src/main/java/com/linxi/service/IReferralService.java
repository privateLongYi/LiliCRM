package com.linxi.service;

import com.linxi.entity.Referral;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/13 17:43
 */
public interface IReferralService {

    //新增转诊记录
    void saveReferral(Referral referral);

    //根据客户名称查询转诊记录
    List<Referral> queryRByCName(@Param("page") Integer page,
                                 @Param("limit") Integer limit,
                                 @Param("uId") Integer uId,
                                 @Param("rName") String rName,
                                 @Param("cName") String cName);

    //根据客户名称查询转诊记录总数
    Integer getTotalByCName(@Param("uId") Integer uId,
                            @Param("rName") String rName,
                            @Param("cName") String cName);

}
