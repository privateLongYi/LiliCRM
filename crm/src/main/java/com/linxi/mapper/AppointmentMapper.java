package com.linxi.mapper;

import com.linxi.entity.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentMapper {

    /***
     * 新增预约客户
     * @param appointment
     * @return
     */
    Integer addAppoint(@Param("appointment") Appointment appointment);

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

    //新增预约客户
    void saveAppointment(Appointment appointment);

}