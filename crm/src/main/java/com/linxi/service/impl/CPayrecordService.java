package com.linxi.service.impl;

import com.linxi.entity.CPayrecord;
import com.linxi.mapper.CPayrecordMapper;
import com.linxi.service.ICPayrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:22
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CPayrecordService implements ICPayrecordService {

    @Autowired
    private com.linxi.mapper.CPayrecordMapper CPayrecordMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CPayrecord> queryCP(Integer page, Integer limit) {
        return CPayrecordMapper.queryCP(page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return CPayrecordMapper.getTotal();
    }

    @Override
    public void saveCPayrecord(CPayrecord cp) {
        CPayrecordMapper.saveCPayrecord(cp);
    }

    @Override
    public void delCPByCpId(Integer cpId) {
        CPayrecordMapper.delCPByCpId(cpId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CPayrecord queryCPByCpId(Integer cpId) {
        return CPayrecordMapper.queryCPByCpId(cpId);
    }

    @Override
    public void editCPByCpId(CPayrecord cp) {
        CPayrecordMapper.editCPByCpId(cp);
    }
}
