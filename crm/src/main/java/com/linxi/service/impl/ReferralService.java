package com.linxi.service.impl;

import com.linxi.entity.Referral;
import com.linxi.mapper.ReferralMapper;
import com.linxi.service.IReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author LongYi
 * @create 2020/9/13 17:43
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ReferralService implements IReferralService{

    @Autowired
    private ReferralMapper referralMapper;

    @Override
    public void saveReferral(Referral referral) {
        referralMapper.saveReferral(referral);
    }
}
