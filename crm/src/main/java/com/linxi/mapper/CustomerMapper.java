package com.linxi.mapper;

import com.linxi.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    //高级筛选加分页查询客户
    List<Customer> queryCScreen(@Param("page") Integer page,
                                @Param("limit") Integer limit,
                                @Param("cName") String cName,
                                @Param("cTel") String cTel,
                                @Param("cProject") String cProject,
                                @Param("ctHospital") String ctHospital,
                                @Param("cEarnest") Integer cEarnest,
                                @Param("beginTime") String beginTime,
                                @Param("endTime") String endTime,
                                @Param("cUId") Integer cUId,
                                @Param("cSource") String cSource,
                                @Param("cStatu") String cStatu);

    //获得客户总数量
    Integer getTotal();

    //新增客户
    void saveCustomer(Customer c);

    //根据编号删除客户
    void delCByCId(Integer cId);

    //根据编号查询客户
    Customer queryCByCId(Integer cId);

    //根据编号修改客户
    void editCByCId(Customer c);

    //根据编号修改客户状态
    void editCStatuByCId(Integer ctCId, Integer cStatu);

}