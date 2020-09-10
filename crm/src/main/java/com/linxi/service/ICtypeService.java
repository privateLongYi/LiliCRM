package com.linxi.service;

import com.linxi.entity.Ctype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/22 14:44
 */
public interface ICtypeService {

    //查询所有客户状态
    List<Ctype> queryCtype();

    //查询所有客户状态
    List<Ctype> queryCtypePage(@Param("page") Integer page,
                               @Param("limit") Integer limit);

    //查询客户状态总条数
    Integer getTotal();

    //新增客户状态
    void saveCtype(String ctType);

    //根据编号删除客户状态
    void delCtypeByCtId(Integer ctId);

    //根据编号查询客户状态
    Ctype queryCtypeByCtId(Integer ctId);

    //根据编号编辑客户状态
    void editCtypeByCtId(Ctype ctype);

}
