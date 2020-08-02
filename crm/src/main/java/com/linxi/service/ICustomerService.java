package com.linxi.service;

import com.linxi.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 13:55
 */
public interface ICustomerService {

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
