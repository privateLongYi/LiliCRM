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
    public List<CSuccess> queryCSScreen(Integer page, Integer limit, String cName, String cTel, String cProject, String ctHospital, Integer cEarnest, String beginTime, String endTime, Integer uId, String cSource, String cStatu) {
        return CSuccessMapper.queryCSScreen(page, limit, cName, cTel, cProject, ctHospital, cEarnest, beginTime, endTime, uId, cSource, cStatu);
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
    public List<CSuccess> queryCSByCsCtId(Integer csCtId, Integer page, Integer limit) {
        return CSuccessMapper.queryCSByCsCtId(csCtId, page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByCsCtId(Integer csCtId) {
        return CSuccessMapper.getTotalByCsCtId(csCtId);
    }
}
