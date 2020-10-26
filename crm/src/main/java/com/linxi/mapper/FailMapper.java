package com.linxi.mapper;

import com.linxi.entity.Fail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FailMapper {

    //新增未成交客户
    void saveFail(Fail fail);

    //根据客户名称查询未成交客户
    List<Fail> queryFailByCName(@Param("page") Integer page,
                                @Param("limit") Integer limit,
                                @Param("uId") Integer uId,
                                @Param("rName") String rName,
                                @Param("cName") String cName);

    //根据客户名称查询未成交客户总数
    Integer getTotalByCName(@Param("uId") Integer uId,
                            @Param("rName") String rName,
                            @Param("cName") String cName);

    //根据未成交编号编辑为失效
    void editFlInvalidByFlId(Integer flId);

}