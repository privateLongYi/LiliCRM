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