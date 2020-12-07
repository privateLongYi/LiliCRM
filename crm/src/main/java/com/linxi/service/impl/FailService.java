package com.linxi.service.impl;

import com.linxi.entity.Fail;
import com.linxi.mapper.FailMapper;
import com.linxi.service.IFailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/12 21:11
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FailService implements IFailService{

    @Autowired
    private FailMapper failMapper;

    @Override
    public void saveFail(Fail fail) {
        failMapper.saveFail(fail);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Fail> queryFailByCName(Integer page, Integer limit, Integer uId, String rName, String cName, Integer export) {
        return failMapper.queryFailByCName(page, limit, uId, rName, cName, export);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByCName(Integer uId, String rName, String cName) {
        return failMapper.getTotalByCName(uId, rName, cName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Fail> queryFlByFlAId(Integer flAId) {
        return failMapper.queryFlByFlAId(flAId);
    }

    @Override
    public void delFlByFlId(Integer flId) {
        failMapper.delFlByFlId(flId);
    }

}
