package com.linxi.service.impl;

import com.linxi.entity.CArrive;
import com.linxi.mapper.CArriveMapper;
import com.linxi.service.ICArriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/8 10:35
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CArriveService implements ICArriveService {

    @Autowired
    private CArriveMapper cArriveMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CArrive> queryCAScreen(Integer page, Integer limit, String cName, String cTel, String cProject, String ctHospital, Integer cEarnest, String beginTime, String endTime, Integer uId, String cSource, String cStatu) {
        return cArriveMapper.queryCAScreen(page, limit, cName, cTel, cProject, ctHospital, cEarnest, beginTime, endTime, uId, cSource, cStatu);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return cArriveMapper.getTotal();
    }

    @Override
    public void saveCArrive(CArrive ca) {
        cArriveMapper.saveCArrive(ca);
    }

    @Override
    public void delCAByCaId(Integer caId) {
        cArriveMapper.delCAByCaId(caId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CArrive queryCAByCaId(Integer caId) {
        return cArriveMapper.queryCAByCaId(caId);
    }

    @Override
    public void editCAByCaId(CArrive ca) {
        cArriveMapper.editCAByCaId(ca);
    }
}
