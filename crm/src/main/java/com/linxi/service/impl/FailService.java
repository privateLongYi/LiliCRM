package com.linxi.service.impl;

import com.linxi.entity.Fail;
import com.linxi.mapper.FailMapper;
import com.linxi.service.IFailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
}
