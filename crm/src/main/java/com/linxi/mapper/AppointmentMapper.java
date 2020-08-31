package com.linxi.mapper;

import com.linxi.entity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentMapper {

    /***
     * 新增预约客户
     * @param appointment
     * @return
     */
    Integer addAppoint(@Param("appointment") Appointment appointment);
}