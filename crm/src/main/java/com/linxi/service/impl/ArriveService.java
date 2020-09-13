package com.linxi.service.impl;

import com.linxi.entity.Arrive;
import com.linxi.mapper.ArriveMapper;
import com.linxi.service.IArriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author LongYi
 * @create 2020/9/12 18:22
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ArriveService implements IArriveService{

    @Autowired
    private ArriveMapper arriveMapper;

    @Override
    public void saveArrive(Arrive arrive) {
        arriveMapper.saveArrive(arrive);
    }
}
