package com.linxi.service.impl;

import com.linxi.entity.CFail;
import com.linxi.mapper.CFailMapper;
import com.linxi.service.ICFailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:17
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CFailService implements ICFailService {

    @Autowired
    private CFailMapper CFailMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CFail> queryCF(Integer page, Integer limit) {
        return CFailMapper.queryCF(page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return CFailMapper.getTotal();
    }

    @Override
    public void saveCFail(CFail cf) {
        CFailMapper.saveCFail(cf);
    }

    @Override
    public void delCFByCfId(Integer cfId) {
        CFailMapper.delCFByCfId(cfId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CFail queryCFByCfId(Integer cfId) {
        return CFailMapper.queryCFByCfId(cfId);
    }

    @Override
    public void editCFByCfId(CFail cf) {
        CFailMapper.editCFByCfId(cf);
    }
}
