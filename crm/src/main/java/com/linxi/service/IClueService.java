package com.linxi.service;

import com.linxi.entity.Clue;
import com.linxi.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/10/21 21:39
 */
public interface IClueService {

    //根据类型编号获得有效线索总数量
    Integer getTotalByType(Integer clTypeId);

    //新增线索
    Integer saveClue(Clue cl);

    //根据编号删除线索
    void delClByClCId(Integer clCId);

    //根据编号查询线索
    Clue queryClByClId(Integer clId);

    //根据编号修改线索
    void editClByCId(Clue cl);

    //根据编号修改状态
    void editClTypeIdByClId(@Param("clId") Integer clId,
                            @Param("clTypeId") Integer clTypeId);

    //根据客户编号查询线索
    List<Clue> queryClByClCId(Integer clCId);

    //根据编号更改线索为无效
    void editInvalidByClId(Integer clId);

    //查询最大的线索编号
    Integer queryMaxClId();

    //根据线索编号编辑定金和定金详情
    void editClByClId(@Param("clId") Integer clId,
                      @Param("clEarnest") Integer clEarnest,
                      @Param("clEarnestDetail") String clEarnestDetail);

}
