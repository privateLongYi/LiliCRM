package com.linxi.service;

import com.linxi.entity.Appointment;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author Arthas
 * @date 2020/8/25 17:15
 */
public interface IAppointmentService {

    /**
     * 新增预约客户
     * @param appointment
     * @return
     */
    Integer addAppoint(Appointment appointment);

    //根据客户编号查询客户预约
    List<Appointment> queryAByACId(Integer aCId);

    //根据客户编号查询客户预约总数
    Integer getTotalAByACId(Integer aCId);

    //根据编号查询客户预约
    Appointment queryAByAId(Integer aId);

    //根据编号编辑客户预约
    void editAByAId(Appointment appointment);

    //根据编号删除客户预约
    void delAByAId(Integer aId);

}
