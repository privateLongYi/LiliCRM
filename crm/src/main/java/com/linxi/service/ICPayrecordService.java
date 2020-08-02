package com.linxi.service;

import com.linxi.entity.CPayrecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:11
 */
public interface ICPayrecordService {

    List<CPayrecord> queryCP(@Param("page") Integer page,
                             @Param("limit") Integer limit);

    Integer getTotal();

    void saveCPayrecord(CPayrecord cp);

    void delCPByCpId(Integer cpId);

    CPayrecord queryCPByCpId(Integer cpId);

    void editCPByCpId(CPayrecord cp);

}
