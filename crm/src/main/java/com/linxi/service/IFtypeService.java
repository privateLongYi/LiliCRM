package com.linxi.service;

import com.linxi.entity.Ftype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/10 22:00
 */
public interface IFtypeService {

    //查询回访类型
    List<Ftype> queryFtypePage(@Param("page") Integer page,
                               @Param("limit") Integer limit);

    //查询回访类型总条数
    Integer getTotal();

    //新增回访类型
    void saveFtype(String ftType);

    //根据编号删除回访类型
    void delFtypeByFtId(Integer ftId);

    //根据编号查询回访类型
    Ftype queryFtypeByFtId(Integer ftId);

    //根据编号编辑回访类型
    void editFtypeByFtId(Ftype ftype);

    //根据回访类型查询编号
    Integer queryFtIdByFtType(String ftType);

    //查询所有回访类型
    List<Ftype> queryFtype();

}
