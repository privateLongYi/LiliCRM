package com.linxi.service.impl;

import com.linxi.entity.Stype;
import com.linxi.mapper.StypeMapper;
import com.linxi.service.IStypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/10 22:25
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StypeService implements IStypeService{

    @Autowired
    private StypeMapper stypeMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Stype> queryStypePage(Integer page, Integer limit) {
        return stypeMapper.queryStypePage(page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return stypeMapper.getTotal();
    }

    @Override
    public void saveStype(String stType) {
        stypeMapper.saveStype(stType);
    }

    @Override
    public void delStypeByStId(Integer stId) {
        stypeMapper.delStypeByStId(stId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Stype queryStypeByStId(Integer stId) {
        return stypeMapper.queryStypeByStId(stId);
    }

    @Override
    public void editStypeByStId(Stype stype) {
        stypeMapper.editStypeByStId(stype);
    }
}
