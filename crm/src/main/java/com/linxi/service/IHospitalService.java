package com.linxi.service;

import com.linxi.entity.Hospital;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/22 14:38
 */
public interface IHospitalService {

    //获取所有门诊
    List<Hospital> queryHospital();

}
