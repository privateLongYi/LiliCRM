package com.linxi.mapper;

import com.linxi.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    List<Customer> queryCByCNameAndCUId(@Param("page") Integer page,
                                        @Param("limit") Integer limit,
                                        @Param("cName") String cName,
                                        @Param("cUId") Integer cUId);

    Integer getTotal();

    void saveCustomer(Customer c);

    void delCByCId(Integer cId);

    Customer queryCByCId(Integer cId);

    void editCByCId(Customer c);

}