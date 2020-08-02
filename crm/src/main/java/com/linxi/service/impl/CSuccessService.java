package com.linxi.service.impl;

import com.linxi.entity.CSuccess;
import com.linxi.mapper.CSuccessMapper;
import com.linxi.service.ICSuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:14
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CSuccessService implements ICSuccessService {

    @Autowired
    private CSuccessMapper CSuccessMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CSuccess> queryCS(Integer page, Integer limit) {
        return CSuccessMapper.queryCS(page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return CSuccessMapper.getTotal();
    }

    @Override
    public void saveCSuccess(CSuccess cs) {
        CSuccessMapper.saveCSuccess(cs);
    }

    @Override
    public void delCSByCsId(Integer csId) {
        CSuccessMapper.delCSByCsId(csId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CSuccess queryCSByCsId(Integer csId) {
        return CSuccessMapper.queryCSByCsId(csId);
    }

    @Override
    public void editCSByCsId(CSuccess cs) {
        CSuccessMapper.editCSByCsId(cs);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CSuccess> queryCSByCsCId(Integer csCId, Integer page, Integer limit) {
        return CSuccessMapper.queryCSByCsCId(csCId, page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByCsCId(Integer csCId) {
        return CSuccessMapper.getTotalByCsCId(csCId);
    }
}
