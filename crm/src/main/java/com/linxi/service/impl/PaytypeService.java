package com.linxi.service.impl;

import com.linxi.entity.Paytype;
import com.linxi.mapper.PaytypeMapper;
import com.linxi.service.IPaytypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/10 22:53
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PaytypeService implements IPaytypeService{

    @Autowired
    private PaytypeMapper paytypeMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Paytype> queryPaytypePage(Integer page, Integer limit) {
        return paytypeMapper.queryPaytypePage(page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return paytypeMapper.getTotal();
    }

    @Override
    public void savePaytype(String payType) {
        paytypeMapper.savePaytype(payType);
    }

    @Override
    public void delPaytypeByPayId(Integer payId) {
        paytypeMapper.delPaytypeByPayId(payId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Paytype queryPaytypeByPayId(Integer payId) {
        return paytypeMapper.queryPaytypeByPayId(payId);
    }

    @Override
    public void editPaytypeByPayId(Paytype paytype) {
        paytypeMapper.editPaytypeByPayId(paytype);
    }
}
