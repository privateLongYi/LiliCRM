package com.linxi.mapper;

import com.linxi.entity.Reroute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RerouteMapper {

    //新增改约纪录
    void saveReroute(Reroute reroute);

    //根据客户名称查询改约记录
    List<Reroute> queryRByCName(@Param("page") Integer page,
                                @Param("limit") Integer limit,
                                @Param("uId") Integer uId,
                                @Param("rName") String rName,
                                @Param("cName") String cName);

    //根据客户名称查询改约记录总数
    Integer getTotalByCName(@Param("uId") Integer uId,
                            @Param("rName") String rName,
                            @Param("cName") String cName);

}