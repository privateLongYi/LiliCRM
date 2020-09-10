package com.linxi.service.impl;

import com.linxi.entity.Ftype;
import com.linxi.mapper.FtypeMapper;
import com.linxi.service.IFtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/10 22:01
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FtypeService implements IFtypeService{

    @Autowired
    private FtypeMapper ftypeMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Ftype> queryFtypePage(Integer page, Integer limit) {
        return ftypeMapper.queryFtypePage(page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return ftypeMapper.getTotal();
    }

    @Override
    public void saveFtype(String ftType) {
        ftypeMapper.saveFtype(ftType);
    }

    @Override
    public void delFtypeByFtId(Integer ftId) {
        ftypeMapper.delFtypeByFtId(ftId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Ftype queryFtypeByFtId(Integer ftId) {
        return ftypeMapper.queryFtypeByFtId(ftId);
    }

    @Override
    public void editFtypeByFtId(Ftype ftype) {
        ftypeMapper.editFtypeByFtId(ftype);
    }
}
