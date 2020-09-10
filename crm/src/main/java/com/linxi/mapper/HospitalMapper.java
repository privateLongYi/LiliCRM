package com.linxi.mapper;

import com.linxi.entity.Hospital;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HospitalMapper {

    //获取所有门诊
    List<Hospital> queryHospital();

    //查询门诊
    List<Hospital> queryHPage(@Param("page") Integer page,
                              @Param("limit") Integer limit);

    //查询门诊总条数
    Integer getTotal();

    //新增门诊
    void saveHospital(String hName);

    //根据编号删除门诊
    void delHByHId(Integer hId);

    //根据编号查询门诊
    Hospital queryHByHId(Integer hId);

    //根据编号编辑门诊
    void editHByHId(Hospital hospital);

}