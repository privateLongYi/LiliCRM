package com.linxi.service;

import com.linxi.entity.Reroute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/12 20:05
 */
public interface IRerouteService {

    //新增改约纪录
    void saveReroute(Reroute reroute);

    //根据客户名称查询改约记录
    List<Reroute> queryRByCName(@Param("page") Integer page,
                                @Param("limit") Integer limit,
                                @Param("uId") Integer uId,
                                @Param("rName") String rName,
                                @Param("cName") String cName,
                                @Param("export") Integer export);

    //根据客户名称查询改约记录总数
    Integer getTotalByCName(@Param("uId") Integer uId,
                            @Param("rName") String rName,
                            @Param("cName") String cName);

    //根据线索编号查询改约
    List<Reroute> queryReByReClId(Integer reClId);

}
