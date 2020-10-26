package com.linxi.service;

import com.linxi.entity.Appointment;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author Arthas
 * @date 2020/8/25 17:15
 */
public interface IAppointmentService {

    //新增预约客户
    void saveAppointment(Appointment appointment);

    //根据客户编号查询预约客户
    List<Appointment> queryAByACId(Integer aCId);

    //根据客户编号查询预约客户总数
    Integer getTotalAByACId(Integer aCId);

    //根据编号查询预约客户
    Appointment queryAByAId(Integer aId);

    //根据编号编辑预约客户
    void editAByAId(Appointment appointment);

    //根据编号删除预约客户
    void delAByAId(Integer aId);

    //根据线索编号查询最近预约门诊
    String queryLastHNameByClId(Integer clId);

    //根据线索编号查询预约记录（详情）
    List<Appointment> queryAToDetail(Integer clId);

    //根据预约编号编辑预约记录为失效
    void editAInvalidByAId(Integer aId);

}
