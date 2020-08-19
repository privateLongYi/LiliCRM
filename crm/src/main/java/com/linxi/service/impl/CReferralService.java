package com.linxi.service.impl;

import com.linxi.entity.CReferral;
import com.linxi.mapper.CReferralMapper;
import com.linxi.service.ICReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:18
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CReferralService implements ICReferralService {

    @Autowired
    private CReferralMapper CReferralMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CReferral> queryCR(Integer page, Integer limit) {
        return CReferralMapper.queryCR(page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return CReferralMapper.getTotal();
    }

    @Override
    public void saveCReferral(CReferral cr) {
        CReferralMapper.saveCReferral(cr);
    }

    @Override
    public void delCRByCrId(Integer crId) {
        CReferralMapper.delCRByCrId(crId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CReferral queryCRByCrId(Integer crId) {
        return CReferralMapper.queryCRByCrId(crId);
    }

    @Override
    public void editCRByCrId(CReferral cr) {
        CReferralMapper.editCRByCrId(cr);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CReferral> queryCRByCrCtId(Integer crCtId, Integer page, Integer limit) {
        return CReferralMapper.queryCRByCrCtId(crCtId, page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByCrCtId(Integer crCtId) {
        return CReferralMapper.getTotalByCrCtId(crCtId);
    }
}
