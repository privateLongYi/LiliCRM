package com.linxi.mapper;

import com.linxi.entity.CPayrecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CPayrecordMapper {

    List<CPayrecord> queryCP(@Param("page") Integer page,
                             @Param("limit") Integer limit);

    Integer getTotal();

    void saveCPayrecord(CPayrecord cp);

    void delCPByCpId(Integer cpId);

    CPayrecord queryCPByCpId(Integer cpId);

    void editCPByCpId(CPayrecord cp);

}