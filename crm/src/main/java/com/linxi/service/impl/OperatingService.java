package com.linxi.service.impl;

import com.linxi.entity.Operating;
import com.linxi.mapper.OperatingMapper;
import com.linxi.service.IOperatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Arthas
 * @date 2020/8/23 20:45
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OperatingService implements IOperatingService {

    @Autowired
    private OperatingMapper operatingMapper;

    @Override
    public Integer addOperatingRecord(Operating op) {
        return operatingMapper.addOperatingRecord(op);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Operating> queryOpByOpCId(Integer opCId) {
        return operatingMapper.queryOpByOpCId(opCId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public String queryOpTimeByOpCId(Integer opCId) {
        return operatingMapper.queryOpTimeByOpCId(opCId);
    }
}
