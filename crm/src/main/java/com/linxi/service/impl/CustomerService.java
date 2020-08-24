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
    public List<Customer> queryCScreen(Integer page, Integer limit, String cName, String cTel, String cProject, Integer hId, Integer cEarnest, String beginTime, String endTime, Integer cUId, String cSource, Integer cTypeId) {
        return customerMapper.queryCScreen(page, limit, cName, cTel, cProject, hId, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
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

    @Override
    public void editCStatuByCId(Integer ctCId, Integer cStatu) {
        customerMapper.editCStatuByCId(ctCId, cStatu);
    }

    /**
     * 根据客户类型 获得客户总数量
     * @param cTypeId
     * @return
     */
    @Override
    public Integer getTotalByType(Integer cTypeId) {
        return customerMapper.getTotalByType(cTypeId);
    }
}
