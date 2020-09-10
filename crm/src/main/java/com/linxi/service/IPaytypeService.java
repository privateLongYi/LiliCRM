package com.linxi.service;

import com.linxi.entity.Paytype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/10 22:52
 */
public interface IPaytypeService {

    //查询支付类型
    List<Paytype> queryPaytypePage(@Param("page") Integer page,
                                   @Param("limit") Integer limit);

    //查询支付类型总条数
    Integer getTotal();

    //新增支付类型
    void savePaytype(String payType);

    //根据编号删除支付类型
    void delPaytypeByPayId(Integer payId);

    //根据编号查询支付类型
    Paytype queryPaytypeByPayId(Integer payId);

    //根据编号编辑支付类型
    void editPaytypeByPayId(Paytype paytype);

}
