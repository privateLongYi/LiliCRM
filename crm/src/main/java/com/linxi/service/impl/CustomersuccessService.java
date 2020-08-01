package com.linxi.service.impl;

import com.linxi.entity.Customersuccess;
import com.linxi.mapper.CustomersuccessMapper;
import com.linxi.service.ICustomerTransactionService;
import com.linxi.service.ICustomersuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author LongYi
 * @create 2020/8/1 14:55
 */
@Service
public class CustomersuccessService implements ICustomersuccessService{

    @Autowired
    private CustomersuccessMapper customersuccessMapper;

    @Override
    public void saveSuccess(Customersuccess csu) {
        customersuccessMapper.saveSuccess(csu);
    }
}
