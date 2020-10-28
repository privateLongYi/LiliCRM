package com.linxi.service;

import com.linxi.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @Author LongYi
 * @create 2020/8/2 13:55
 */
public interface ICustomerService {

    //高级筛选加分页查询客户
    List<Customer> queryCScreen(@Param("uId") Integer uId,
                                @Param("rName") String rName,
                                @Param("page") Integer page,
                                @Param("limit") Integer limit,
                                @Param("cName") String cName,
                                @Param("cTel") String cTel,
                                @Param("clProject") String clProject,
                                @Param("clEarnest") Integer clEarnest,
                                @Param("beginTime") String beginTime,
                                @Param("endTime") String endTime,
                                @Param("clUId") Integer clUId,
                                @Param("clSource") String clSource,
                                @Param("clTypeId") Integer clTypeId);

    //获得客户总数量
    Integer getTotalByScreen(@Param("uId") Integer uId,
                             @Param("rName") String rName,
                             @Param("cName") String cName,
                             @Param("cTel") String cTel,
                             @Param("clProject") String clProject,
                             @Param("clEarnest") Integer clEarnest,
                             @Param("beginTime") String beginTime,
                             @Param("endTime") String endTime,
                             @Param("clUId") Integer clUId,
                             @Param("clSource") String clSource,
                             @Param("clTypeId") Integer clTypeId);

    //高级筛选加分页查询客户
    List<Customer> queryAACScreen(@Param("uId") Integer uId,
                                @Param("rName") String rName,
                                @Param("page") Integer page,
                                @Param("limit") Integer limit,
                                @Param("cName") String cName,
                                @Param("cTel") String cTel,
                                @Param("clProject") String clProject,
                                @Param("clEarnest") Integer clEarnest,
                                @Param("beginTime") String beginTime,
                                @Param("endTime") String endTime,
                                @Param("clUId") Integer clUId,
                                @Param("clSource") String clSource,
                                @Param("clTypeId") Integer clTypeId);

    //获得客户总数量
    Integer getAACTotalByScreen(@Param("uId") Integer uId,
                             @Param("rName") String rName,
                             @Param("cName") String cName,
                             @Param("cTel") String cTel,
                             @Param("clProject") String clProject,
                             @Param("clEarnest") Integer clEarnest,
                             @Param("beginTime") String beginTime,
                             @Param("endTime") String endTime,
                             @Param("clUId") Integer clUId,
                             @Param("clSource") String clSource,
                             @Param("clTypeId") Integer clTypeId);

    //新增客户
    void saveCustomer(Customer c);

    //查询最大的编号（新增客户的编号）
    Integer queryMaxCId();

    //根据编号删除线索
    void delCByCId(Integer cId);

    //根据编号查询客户
    Customer queryCByCId(Integer cId);

    //根据线索编号查询客户
    Customer queryCByClId(Integer clId);

    //根据编号修改客户
    void editCByCId(Customer c);

    //根据用户编号和状态查询客户总条数
    Integer getTotalCByUIdAndCTypeId(@Param("uId") Integer uId,
                                     @Param("clTypeId") Integer clTypeId);

    //根据客户名称或者客户电话查询客户
    List<Customer> queryCByCNameOrCTel(@Param("rName") String rName,
                                       @Param("uId") Integer uId,
                                       @Param("key") String key);

    //根据用户编号和客户名称查询可成交客户
    List<Customer> queryCSCByUIdAndCName(@Param("rName") String rName,
                                         @Param("uId") Integer uId,
                                         @Param("cName") String cName);

    //根据用户编号和客户名称查询可成交客户
    List<Customer> queryCACByUIdAndCName(@Param("rName") String rName,
                                         @Param("uId") Integer uId,
                                         @Param("cName") String cName);

    //根据用户编号和起始时间和客户状态查询客户数量
    Integer queryCByUIdAndTimeAndCTypeId(@Param("uId") Integer uId,
                                         @Param("clTypeId") Integer clTypeId,
                                         @Param("beginTime") String beginTime,
                                         @Param("endTime") String endTime);

}
