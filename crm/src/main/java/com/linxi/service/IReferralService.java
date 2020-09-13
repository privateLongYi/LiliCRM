package com.linxi.service;

import com.linxi.entity.Referral;

/**
 * @Author LongYi
 * @create 2020/9/13 17:43
 */
public interface IReferralService {

    //新增转诊记录
    void saveReferral(Referral referral);

}
