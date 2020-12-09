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
    public List<Success> querySByClId(Integer clId, Integer page, Integer limit) {
        return successMapper.querySByClId(clId, page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByClId(Integer clId) {
        return successMapper.getTotalByClId(clId);
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
    public List<Success> querySByScreen(Integer page, Integer limit, Integer uId, String rName, String cName, String cTel, Integer sHId, Integer queryUId, String beginTime, String endTime, Integer export) {
        return successMapper.querySByScreen(page, limit, uId, rName, cName, cTel, sHId, queryUId, beginTime, endTime, export);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByScreen(Integer uId, String rName, String cName, String cTel, Integer sHId, Integer queryUId, String beginTime, String endTime) {
        return successMapper.getTotalByScreen(uId, rName, cName, cTel, sHId, queryUId, beginTime, endTime);
    }

    @Override
    public void editMoneyBySId(Integer sId, Integer sSum, Integer sPaySum) {
        successMapper.editMoneyBySId(sId, sSum, sPaySum);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryTotalMoneyByClId(Integer clId, Integer type) {
        return successMapper.queryTotalMoneyByClId(clId, type);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Success> querySCByUIdAndCName(String rName, Integer uId, String cName, Integer page) {
        return successMapper.querySCByUIdAndCName(rName, uId, cName, page);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalSCByUIdAndCName(String rName, Integer uId, String cName) {
        return successMapper.getTotalSCByUIdAndCName(rName, uId, cName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Success> querySByTime(Integer page, Integer limit, Integer uId, String rName, String beginTime, String endTime) {
        return successMapper.querySByTime(page, limit, uId, rName, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByTime(Integer uId, String rName, String beginTime, String endTime) {
        return successMapper.getTotalByTime(uId, rName, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryMoneyByTime(Integer uId, String rName, String beginTime, String endTime, Integer type) {
        return successMapper.queryMoneyByTime(uId, rName, beginTime, endTime, type);
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

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Success> querySBySAId(Integer sAId) {
        return successMapper.querySBySAId(sAId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer querySSumBySAId(Integer sAId) {
        return successMapper.querySSumBySAId(sAId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryMaxSId() {
        return successMapper.queryMaxSId();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryMoneyByScreen(Integer uId, String rName, String cName, String cTel, Integer sHId, Integer queryUId, String beginTime, String endTime, Integer type) {
        return successMapper.queryMoneyByScreen(uId, rName, cName, cTel, sHId, queryUId, beginTime, endTime, type);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Success> queryRefundByScreen(Integer uId, String rName, String cName, String cTel, Integer sHId, Integer queryUId, String beginTime, String endTime) {
        return successMapper.queryRefundByScreen(uId, rName, cName, cTel, sHId, queryUId, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryRefundByClId(Integer clId) {
        return successMapper.queryRefundByClId(clId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Success queryFirstSByClId(Integer clId) {
        return successMapper.queryFirstSByClId(clId);
    }

}
