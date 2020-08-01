package com.linxi.service;

import com.linxi.entity.Customertransaction;
import com.linxi.mapper.CustomertransactionMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/7/31 21:25
 */
public interface ICustomerTransactionService {

    List<Customertransaction> queryCTByCNameOrCusp(@Param("page") Integer page,
                                                   @Param("limit") Integer limit,
                                                   @Param("cName") String cName,
                                                   @Param("cUsp") String cUsp);

    Integer getTotal();

    void saveCustomer(Customertransaction ct);

    Customertransaction queryCustomerByCid(Integer cid);

    void editCustomerByCid(Customertransaction ct);

    void editTransaction(Integer cid);

    void delCustomerByCid(Integer cid);
}
