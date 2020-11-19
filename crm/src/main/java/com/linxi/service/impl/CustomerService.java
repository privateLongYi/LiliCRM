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
    public List<Customer> queryCScreen(Integer uId, String rName, Integer page, Integer limit, String cName, String cTel, String clProject, String clEntryFee, String beginTime, String endTime, Integer clUId, String clSource, Integer clTypeId, Integer export) {
        return customerMapper.queryCScreen(uId, rName, page, limit, cName, cTel, clProject, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId, export);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByScreen(Integer uId, String rName, String cName, String cTel, String clProject, String clEntryFee, String beginTime, String endTime, Integer cUId, String clSource, Integer clTypeId) {
        return customerMapper.getTotalByScreen(uId, rName, cName, cTel, clProject, clEntryFee, beginTime, endTime, cUId, clSource, clTypeId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryAACScreen(Integer uId, String rName, Integer page, Integer limit, String cName, String cTel, String clProject, String clEntryFee, String beginTime, String endTime, Integer clUId, String clSource, Integer clTypeId, Integer export) {
        return customerMapper.queryAACScreen(uId, rName, page, limit, cName, cTel, clProject, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId, export);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getAACTotalByScreen(Integer uId, String rName, String cName, String cTel, String clProject, String clEntryFee, String beginTime, String endTime, Integer cUId, String clSource, Integer clTypeId) {
        return customerMapper.getAACTotalByScreen(uId, rName, cName, cTel, clProject, clEntryFee, beginTime, endTime, cUId, clSource, clTypeId);
    }

    @Override
    public void saveCustomer(Customer c) {
        customerMapper.saveCustomer(c);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryMaxCId() {
        return customerMapper.queryMaxCId();
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
    @Transactional(propagation = Propagation.SUPPORTS)
    public Customer queryCByClId(Integer clId) {
        return customerMapper.queryCByClId(clId);
    }

    @Override
    public void editCByCId(Customer c) {
        customerMapper.editCByCId(c);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalCByUIdAndCTypeId(Integer uId, Integer clTypeId) {
        return customerMapper.getTotalCByUIdAndCTypeId(uId, clTypeId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryCByCNameOrCTel(String rName, Integer uId, String key, Integer page) {
        return customerMapper.queryCByCNameOrCTel(rName, uId, key, page);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByCNameOrCTel(String rName, Integer uId, String key) {
        return customerMapper.getTotalByCNameOrCTel(rName, uId, key);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryCSCByUIdAndCName(String rName, Integer uId, String cName, Integer page) {
        return customerMapper.queryCSCByUIdAndCName(rName, uId, cName, page);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalCSCByUIdAndCName(String rName, Integer uId, String cName) {
        return customerMapper.getTotalCSCByUIdAndCName(rName, uId, cName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryCACByUIdAndCName(String rName, Integer uId, String cName, Integer page) {
        return customerMapper.queryCACByUIdAndCName(rName, uId, cName, page);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalCACByUIdAndCName(String rName, Integer uId, String cName) {
        return customerMapper.getTotalCACByUIdAndCName(rName, uId, cName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryCByUIdAndTimeAndCTypeId(Integer uId, String rName, Integer cTypeId, String beginTime, String endTime) {
        return customerMapper.queryCByUIdAndTimeAndCTypeId(uId, rName, cTypeId, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryCByTime(Integer page, Integer limit, Integer uId, String rName, String beginTime, String endTime) {
        return customerMapper.queryCByTime(page, limit, uId, rName, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByTime(Integer uId, String rName, String beginTime, String endTime) {
        return customerMapper.getTotalByTime(uId, rName, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryAByTime(Integer page, Integer limit, Integer uId, String rName, String beginTime, String endTime) {
        return customerMapper.queryAByTime(page, limit, uId, rName, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalAByTime(Integer uId, String rName, String beginTime, String endTime) {
        return customerMapper.getTotalByTime(uId, rName, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryArriveByTime(Integer page, Integer limit, Integer uId, String rName, String beginTime, String endTime) {
        return customerMapper.queryArriveByTime(page, limit, uId, rName, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalArriveByTime(Integer uId, String rName, String beginTime, String endTime) {
        return customerMapper.getTotalArriveByTime(uId, rName, beginTime, endTime);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryCByCNameAndCTel(String cName, String cTel) {
        return customerMapper.queryCByCNameAndCTel(cName, cTel);
    }

}
