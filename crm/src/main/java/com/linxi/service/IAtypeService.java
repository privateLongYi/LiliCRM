package com.linxi.service;

import com.linxi.entity.Atype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/2 19:21
 */
public interface IAtypeService {

    //查询所有预约类型
    List<Atype> queryAtype();

    //查询预约类型
    List<Atype> queryAtypePage(@Param("page") Integer page,
                               @Param("limit") Integer limit);

    //查询预约类型总条数
    Integer getTotal();

    //新增预约类型
    void saveAtype(String atType);

    //根据编号删除预约类型
    void delAtypeByAtId(Integer atId);

    //根据编号查询预约类型
    Atype queryAtypeByAtId(Integer atId);

    //根据编号编辑预约类型
    void editAtypeByAtId(Atype atype);

    //根据预约类型查询编号
    Integer queryAByAType(String atType);

}
