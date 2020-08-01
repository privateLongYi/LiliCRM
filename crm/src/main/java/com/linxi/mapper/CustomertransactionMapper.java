package com.linxi.mapper;

import com.linxi.entity.Customertransaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomertransactionMapper {

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