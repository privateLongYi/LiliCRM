package com.linxi.service.impl;

import com.linxi.entity.CTransaction;
import com.linxi.mapper.CTransactionMapper;
import com.linxi.service.ICTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:12
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CTransactionService implements ICTransactionService {

    @Autowired
    private CTransactionMapper cTransactionMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CTransaction> queryCT(Integer page, Integer limit) {
        return cTransactionMapper.queryCT(page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return cTransactionMapper.getTotal();
    }

    @Override
    public void saveCTransaction(CTransaction ct) {
        cTransactionMapper.saveCTransaction(ct);
    }

    @Override
    public void delCTByCtId(Integer ctId) {
        cTransactionMapper.delCTByCtId(ctId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CTransaction queryCTByCtId(Integer ctId) {
        return cTransactionMapper.queryCTByCtId(ctId);
    }

    @Override
    public void editCTByCtId(CTransaction ct) {
        cTransactionMapper.editCTByCtId(ct);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CTransaction> queryCTByCtCId(Integer ctCId, Integer page, Integer limit) {
        return cTransactionMapper.queryCTByCtCId(ctCId, page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByCtCId(Integer ctCId) {
        return cTransactionMapper.getTotalByCtCId(ctCId);
    }
}
