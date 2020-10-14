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
    public List<Customer> queryCScreen(Integer uId, String rName, Integer page, Integer limit, String cName, String cTel, String cProject, Integer cEarnest, String beginTime, String endTime, Integer cUId, String cSource, Integer cTypeId) {
        return customerMapper.queryCScreen(uId, rName, page, limit, cName, cTel, cProject, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByScreen(Integer uId, String rName, String cName, String cTel, String cProject, Integer cEarnest, String beginTime, String endTime, Integer cUId, String cSource, Integer cTypeId) {
        return customerMapper.getTotalByScreen(uId, rName, cName, cTel, cProject, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
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
    public void editCTypeIdByCId(Integer cId, Integer cTypeId) {
        customerMapper.editCTypeIdByCId(cId, cTypeId);
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

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalCByUIdAndCTypeId(Integer uId, Integer cTypeId) {
        return customerMapper.getTotalCByUIdAndCTypeId(uId, cTypeId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryCByCNameOrCTel(String rName, Integer uId, String key) {
        return customerMapper.queryCByCNameOrCTel(rName, uId, key);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> queryCAndHNameScreen(Integer uId, String rName, Integer page, Integer limit, String cName, String cTel, String cProject, Integer cEarnest, String beginTime, String endTime, Integer cUId, String cSource, Integer cTypeId) {
        return customerMapper.queryCAndHNameScreen(uId, rName, page, limit, cName, cTel, cProject, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalAndHNameByScreen(Integer uId, String rName, String cName, String cTel, String cProject, Integer cEarnest, String beginTime, String endTime, Integer cUId, String cSource, Integer cTypeId) {
        return customerMapper.getTotalAndHNameByScreen(uId, rName, cName, cTel, cProject, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> querySCByUIdAndCName(String rName, Integer uId, String cName) {
        return customerMapper.querySCByUIdAndCName(rName, uId, cName);
    }

}
