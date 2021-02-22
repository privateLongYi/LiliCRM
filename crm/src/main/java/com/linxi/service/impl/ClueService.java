package com.linxi.service.impl;

import com.linxi.entity.Clue;
import com.linxi.entity.Customer;
import com.linxi.mapper.ClueMapper;
import com.linxi.service.IClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/10/21 21:39
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ClueService implements IClueService{

    @Autowired
    private ClueMapper clueMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByType(Integer clTypeId) {
        return clueMapper.getTotalByType(clTypeId);
    }

    @Override
    public Integer saveClue(Clue cl) {
        return clueMapper.saveClue(cl);
    }

    @Override
    public void delClByClCId(Integer clCId) {
        clueMapper.delClByClCId(clCId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Clue queryClByClId(Integer clId) {
        return clueMapper.queryClByClId(clId);
    }

    @Override
    public void editClByCId(Clue cl) {
        clueMapper.editClByCId(cl);
    }

    @Override
    public void editClTypeIdByClId(Integer clId, Integer clTypeId) {
        clueMapper.editClTypeIdByClId(clId, clTypeId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Clue> queryClByClCId(Integer clCId) {
        return clueMapper.queryClByClCId(clCId);
    }

    @Override
    public void editInvalidByClId(Integer clId) {
        clueMapper.editInvalidByClId(clId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryMaxClId() {
        return clueMapper.queryMaxClId();
    }

    @Override
    public void editClByClId(Integer clId, String clEntryFee) {
        clueMapper.editClByClId(clId, clEntryFee);
    }

    @Override
    public void editClUIdByClId(Integer clId, Integer clUId) {
        clueMapper.editClUIdByClId(clId, clUId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Clue queryValidClByClCId(Integer cId) {
        return clueMapper.queryValidClByClCId(cId);
    }

}
