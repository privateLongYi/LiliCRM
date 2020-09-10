package com.linxi.service.impl;

import com.linxi.entity.Ctype;
import com.linxi.mapper.CtypeMapper;
import com.linxi.service.ICtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/22 14:45
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CtypeService implements ICtypeService{

    @Autowired
    private CtypeMapper ctypeMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Ctype> queryCtype() {
        return ctypeMapper.queryCtype();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Ctype> queryCtypePage(Integer page, Integer limit) {
        return ctypeMapper.queryCtypePage(page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return ctypeMapper.getTotal();
    }

    @Override
    public void saveCtype(String ctType) {
        ctypeMapper.saveCtype(ctType);
    }

    @Override
    public void delCtypeByCtId(Integer ctId) {
        ctypeMapper.delCtypeByCtId(ctId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Ctype queryCtypeByCtId(Integer ctId) {
        return ctypeMapper.queryCtypeByCtId(ctId);
    }

    @Override
    public void editCtypeByCtId(Ctype ctype) {
        ctypeMapper.editCtypeByCtId(ctype);
    }
}
