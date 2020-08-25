package com.linxi.service.impl;

import com.linxi.entity.Appointment;
import com.linxi.mapper.AppointmentMapper;
import com.linxi.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arthas
 * @date 2020/8/25 17:17
 */
@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    AppointmentMapper appointmentMapper;

    @Override
    public Integer addAppoint(Appointment appointment) {
        return appointmentMapper.addAppoint(appointment);
    }
}
