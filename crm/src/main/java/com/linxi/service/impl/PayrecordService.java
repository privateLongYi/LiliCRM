package com.linxi.service.impl;

import com.linxi.entity.Payrecord;
import com.linxi.mapper.PayrecordMapper;
import com.linxi.service.IPayrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/5 14:24
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PayrecordService implements IPayrecordService{

    @Autowired
    private PayrecordMapper payrecordMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Payrecord> queryPByPaySId(Integer paySId) {
        return payrecordMapper.queryPByPaySId(paySId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByPaySId(Integer paySId) {
        return payrecordMapper.getTotalByPaySId(paySId);
    }
}
