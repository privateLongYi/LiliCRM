package com.linxi.service;

import com.linxi.entity.Follow;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/5 15:42
 */
public interface IFollowService {

    //新增客户跟进
    void saveFollow(Follow follow);

    //根据线索编号查询所拥有的跟进类型
    List<Follow> queryFtypeByFClId(Integer fClId);

    //根据跟进类型和线索编号查询最后一次跟进时间
    String queryLastFTimeByFtypeAndFClId(@Param("clId") Integer clId,
                                         @Param("ftType") String ftType);

    //根据线索编号和跟进类型查询客户跟进
    List<Follow> queryFByFtypeAndFClId(@Param("clId") Integer clId,
                                       @Param("ftType") String ftType);

}
