package com.linxi.mapper;

import com.linxi.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    //高级筛选加分页查询客户
    List<Customer> queryCScreen(@Param("uId") Integer uId,
                                @Param("rName") String rName,
                                @Param("page") Integer page,
                                @Param("limit") Integer limit,
                                @Param("cName") String cName,
                                @Param("cTel") String cTel,
                                @Param("cProject") String cProject,
                                @Param("hId") Integer hId,
                                @Param("cEarnest") Integer cEarnest,
                                @Param("beginTime") String beginTime,
                                @Param("endTime") String endTime,
                                @Param("cUId") Integer cUId,
                                @Param("cSource") String cSource,
                                @Param("cTypeId") Integer cTypeId);

    //获得客户总数量
    Integer getTotalByScreen(@Param("uId") Integer uId,
                             @Param("rName") String rName,
                             @Param("cName") String cName,
                             @Param("cTel") String cTel,
                             @Param("cProject") String cProject,
                             @Param("hId") Integer hId,
                             @Param("cEarnest") Integer cEarnest,
                             @Param("beginTime") String beginTime,
                             @Param("endTime") String endTime,
                             @Param("cUId") Integer cUId,
                             @Param("cSource") String cSource,
                             @Param("cTypeId") Integer cTypeId);

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