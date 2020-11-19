package com.linxi.service.impl;

import com.linxi.entity.Reroute;
import com.linxi.mapper.RerouteMapper;
import com.linxi.service.IRerouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/12 20:06
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RerouteService implements IRerouteService{

    @Autowired
    private RerouteMapper rerouteMapper;

    @Override
    public void saveReroute(Reroute reroute) {
        rerouteMapper.saveReroute(reroute);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Reroute> queryRByCName(Integer page, Integer limit, Integer uId, String rName, String cName, Integer export) {
        return rerouteMapper.queryRByCName(page, limit, uId, rName, cName, export);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByCName(Integer uId, String rName, String cName) {
        return rerouteMapper.getTotalByCName(uId, rName, cName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Reroute> queryReByReClId(Integer reClId) {
        return rerouteMapper.queryReByReClId(reClId);
    }
}
