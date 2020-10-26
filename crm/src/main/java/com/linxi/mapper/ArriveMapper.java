package com.linxi.mapper;

import com.linxi.entity.Arrive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArriveMapper {

    //根据客户名称查询未到店客户
    List<Arrive> queryAByCName(@Param("page") Integer page,
                               @Param("limit") Integer limit,
                               @Param("uId") Integer uId,
                               @Param("rName") String rName,
                               @Param("cName") String cName);

    //根据客户名称查询未到店客户总条数
    Integer getTotalByCName(@Param("uId") Integer uId,
                            @Param("rName") String rName,
                            @Param("cName") String cName);

    //新增未到店客户
    void saveArrive(Arrive arrive);

    //根据预约编号编辑未到店客户为失效状态
    void editArInvalidByAId(Integer aId);

    //根据未到店编号编辑未到店客户为失效状态
    void editArInvalidByArId(Integer arId);

}