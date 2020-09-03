package com.linxi.service.impl;

import com.linxi.entity.Atype;
import com.linxi.mapper.AtypeMapper;
import com.linxi.service.IAtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/2 19:22
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AtypeService implements IAtypeService{

    @Autowired
    private AtypeMapper atypeMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Atype> queryAtype() {
        return atypeMapper.queryAtype();
    }
}
