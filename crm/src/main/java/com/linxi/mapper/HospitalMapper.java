package com.linxi.mapper;

import com.linxi.entity.Hospital;

import java.util.List;

public interface HospitalMapper {

    //获取所有门诊
    List<Hospital> queryHospital();

}