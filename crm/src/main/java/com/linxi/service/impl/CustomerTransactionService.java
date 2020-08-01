package com.linxi.service.impl;

import com.linxi.entity.Customertransaction;
import com.linxi.mapper.CustomertransactionMapper;
import com.linxi.service.ICustomerTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/7/31 21:27
 */
@Service
public class CustomerTransactionService implements ICustomerTransactionService{

    @Autowired
    private CustomertransactionMapper customertransactionMapper;

    @Override
    public List<Customertransaction> queryCTByCNameOrCusp(Integer page, Integer limit, String cName, String cUsp) {
        return customertransactionMapper.queryCTByCNameOrCusp(page, limit, cName, cUsp);
    }

    @Override
    public Integer getTotal() {
        return customertransactionMapper.getTotal();
    }

    @Override
    public void saveCustomer(Customertransaction ct) {
        customertransactionMapper.saveCustomer(ct);
    }

    @Override
    public Customertransaction queryCustomerByCid(Integer cid) {
        return customertransactionMapper.queryCustomerByCid(cid);
    }

    @Override
    public void editCustomerByCid(Customertransaction ct) {
        customertransactionMapper.editCustomerByCid(ct);
    }

    @Override
    public void editTransaction(Integer cid) {
        customertransactionMapper.editTransaction(cid);
    }

    @Override
    public void delCustomerByCid(Integer cid) {
        customertransactionMapper.delCustomerByCid(cid);
    }
}
