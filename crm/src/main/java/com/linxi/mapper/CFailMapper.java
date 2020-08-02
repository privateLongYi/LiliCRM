package com.linxi.mapper;

import com.linxi.entity.CFail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CFailMapper {

    List<CFail> queryCF(@Param("page") Integer page,
                             @Param("limit") Integer limit);

    Integer getTotal();

    void saveCFail(CFail cf);

    void delCFByCfId(Integer cfId);

    CFail queryCFByCfId(Integer cfId);

    void editCFByCfId(CFail cf);

}