package com.linxi.service.impl;

import com.linxi.entity.Customer;
import com.linxi.mapper.CustomerMapper;
import com.linxi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 14:15
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryCByCNameAndCUId(Integer page, Integer limit, String cName, Integer cUId) {
        return customerMapper.queryCByCNameAndCUId(page, limit, cName, cUId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotal() {
        return customerMapper.getTotal();
    }

    @Override
    public void saveCustomer(Customer c) {
        customerMapper.saveCustomer(c);
    }

    @Override
    public void delCByCId(Integer cId) {
        customerMapper.delCByCId(cId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Customer queryCByCId(Integer cId) {
        return customerMapper.queryCByCId(cId);
    }

    @Override
    public void editCByCId(Customer c) {
        customerMapper.editCByCId(c);
    }
}
