package com.linxi.mapper;

import com.linxi.entity.CSuccess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CSuccessMapper {

    List<CSuccess> queryCS(@Param("page") Integer page,
                               @Param("limit") Integer limit);

    Integer getTotal();

    void saveCSuccess(CSuccess cs);

    void delCSByCsId(Integer csId);

    CSuccess queryCSByCsId(Integer csId);

    void editCSByCsId(CSuccess cs);

    List<CSuccess> queryCSByCsCId(@Param("csCId") Integer csCId,
                                      @Param("page") Integer page,
                                      @Param("limit") Integer limit);

    Integer getTotalByCsCId(Integer csCId);

}