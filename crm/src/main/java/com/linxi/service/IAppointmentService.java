package com.linxi.service;

import com.linxi.entity.Appointment;

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
}
