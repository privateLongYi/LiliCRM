package com.linxi.service.impl;

import com.linxi.entity.Success;
import com.linxi.mapper.SuccessMapper;
import com.linxi.service.ISuccessService;
import com.linxi.vo.SuccessStatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/3 20:09
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SuccessService implements ISuccessService{

    @Autowired
    private SuccessMapper successMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Success> querySBySCId(Integer sCId) {
        return successMapper.querySBySCId(sCId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalBySCId(Integer sCId) {
        return successMapper.getTotalBySCId(sCId);
    }

    @Override
    public void delSBySId(Integer sId) {
        successMapper.delSBySId(sId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Success querySBySId(Integer sId) {
        return successMapper.querySBySId(sId);
    }

    @Override
    public void editSBySId(Success success) {
        successMapper.editSBySId(success);
    }

    @Override
    public void saveSuccess(Success success) {
        successMapper.saveSuccess(success);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Success> querySByCName(Integer page, Integer limit, Integer uId, String rName, String cName) {
        return successMapper.querySByCName(page, limit, uId, rName, cName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByCName(Integer uId, String rName, String cName) {
        return successMapper.getTotalByCName(uId, rName, cName);
    }

    @Override
    public void editSPaysumBySId(Integer sId, Integer paySum) {
        successMapper.editSPaysumBySId(sId, paySum);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryTotalMoneyByCId(Integer cId, Integer type) {
        return successMapper.queryTotalMoneyByCId(cId, type);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Success> querySCByUIdAndCName(String rName, Integer uId, String cName) {
        return successMapper.querySCByUIdAndCName(rName, uId, cName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer querySByUIdAndTime(Integer uId, String beginTime, String endTime) {
        return successMapper.querySByUIdAndTime(uId, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer querySSumByUIdAndTime(Integer uId, String beginTime, String endTime) {
        return successMapper.querySSumByUIdAndTime(uId, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer querySPaysumByUIdAndTime(Integer uId, String beginTime, String endTime) {
        return successMapper.querySPaysumByUIdAndTime(uId, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Success> querySSumGruopByHId(String beginTime, String endTime) {
        return successMapper.querySSumGruopByHId(beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Success> querySSumGruopByUId(String beginTime, String endTime) {
        return successMapper.querySSumGruopByUId(beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Success> querySSumGruopByCProject(String beginTime, String endTime) {
        return successMapper.querySSumGruopByCProject(beginTime, endTime);
    }

}
