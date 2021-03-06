package com.linxi.service.impl;

import com.linxi.entity.Hospital;
import com.linxi.mapper.HospitalMapper;
import com.linxi.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/22 14:39
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class HospitalService implements IHospitalService {

    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Hospital> queryHospital() {
        return hospitalMapper.queryHospital();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Hospital> queryHPage(Integer page, Integer limit) {
        return hospitalMapper.queryHPage(page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return hospitalMapper.getTotal();
    }

    @Override
    public void saveHospital(String hName) {
        hospitalMapper.saveHospital(hName);
    }

    @Override
    public void delHByHId(Integer hId) {
        hospitalMapper.delHByHId(hId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Hospital queryHByHId(Integer hId) {
        return hospitalMapper.queryHByHId(hId);
    }

    @Override
    public void editHByHId(Hospital hospital) {
        hospitalMapper.editHByHId(hospital);
    }
}
