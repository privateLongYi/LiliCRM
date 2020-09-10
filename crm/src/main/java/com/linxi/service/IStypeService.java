package com.linxi.service;

import com.linxi.entity.Stype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/10 22:25
 */
public interface IStypeService {

    //查询成交类型
    List<Stype> queryStypePage(@Param("page") Integer page,
                               @Param("limit") Integer limit);

    //查询成交类型总条数
    Integer getTotal();

    //新增成交类型
    void saveStype(String stType);

    //根据编号删除成交类型
    void delStypeByStId(Integer stId);

    //根据编号查询成交类型
    Stype queryStypeByStId(Integer stId);

    //根据编号编辑成交类型
    void editStypeByStId(Stype stype);

}
