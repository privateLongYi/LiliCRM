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
                                @Param("cProject") String cProject,
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
                             @Param("cEarnest") Integer cEarnest,
                             @Param("beginTime") String beginTime,
                             @Param("endTime") String endTime,
                             @Param("cUId") Integer cUId,
                             @Param("cSource") String cSource,
                             @Param("cTypeId") Integer cTypeId);

    /**
     * 根据客户类型 获得客户总数量
     * @param cTypeId
     * @return
     */
    Integer getTotalByType(@Param("cTypeId")Integer cTypeId);

    //新增客户
    void saveCustomer(Customer c);

    //根据编号删除客户
    void delCByCId(Integer cId);

    //根据编号查询客户
    Customer queryCByCId(Integer cId);

    //根据编号修改客户
    void editCByCId(Customer c);

    //根据编号修改客户状态
    void editCTypeIdByCId(@Param("cId") Integer cId, @Param("cTypeId") Integer cTypeId);

    //根据用户编号和状态查询客户总条数
    Integer getTotalCByUIdAndCTypeId(@Param("uId") Integer uId,
                                     @Param("cTypeId") Integer cTypeId);

    //根据客户名称或者客户电话查询客户
    List<Customer> queryCByCNameOrCTel(@Param("key") String key);

    //高级筛选加分页查询客户
    List<Customer> queryCAndHNameScreen(@Param("uId") Integer uId,
                                        @Param("rName") String rName,
                                        @Param("page") Integer page,
                                        @Param("limit") Integer limit,
                                        @Param("cName") String cName,
                                        @Param("cTel") String cTel,
                                        @Param("cProject") String cProject,
                                        @Param("cEarnest") Integer cEarnest,
                                        @Param("beginTime") String beginTime,
                                        @Param("endTime") String endTime,
                                        @Param("cUId") Integer cUId,
                                        @Param("cSource") String cSource,
                                        @Param("cTypeId") Integer cTypeId);

    //获得客户总数量
    Integer getTotalAndHNameByScreen(@Param("uId") Integer uId,
                                     @Param("rName") String rName,
                                     @Param("cName") String cName,
                                     @Param("cTel") String cTel,
                                     @Param("cProject") String cProject,
                                     @Param("cEarnest") Integer cEarnest,
                                     @Param("beginTime") String beginTime,
                                     @Param("endTime") String endTime,
                                     @Param("cUId") Integer cUId,
                                     @Param("cSource") String cSource,
                                     @Param("cTypeId") Integer cTypeId);

}
