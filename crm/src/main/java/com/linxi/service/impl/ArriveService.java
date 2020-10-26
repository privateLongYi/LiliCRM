package com.linxi.service.impl;

import com.linxi.entity.Arrive;
import com.linxi.mapper.ArriveMapper;
import com.linxi.service.IArriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Arrive> queryAByCName(Integer page, Integer limit, Integer uId, String rName, String cName) {
        return arriveMapper.queryAByCName(page, limit, uId, rName, cName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByCName(Integer uId, String rName, String cName) {
        return arriveMapper.getTotalByCName(uId, rName, cName);
    }

    @Override
    public void saveArrive(Arrive arrive) {
        arriveMapper.saveArrive(arrive);
    }

    @Override
    public void editArInvalidByAId(Integer aId) {
        arriveMapper.editArInvalidByAId(aId);
    }

    @Override
    public void editArInvalidByArId(Integer arId) {
        arriveMapper.editArInvalidByArId(arId);
    }

}
