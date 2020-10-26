package com.linxi.service.impl;

import com.linxi.entity.Appointment;
import com.linxi.mapper.AppointmentMapper;
import com.linxi.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Arthas
 * @date 2020/8/25 17:17
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AppointmentService implements IAppointmentService {

    @Autowired
    AppointmentMapper appointmentMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Appointment> queryAByACId(Integer aCId) {
        return appointmentMapper.queryAByACId(aCId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalAByACId(Integer aCId) {
        return appointmentMapper.getTotalAByACId(aCId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Appointment queryAByAId(Integer aId) {
        return appointmentMapper.queryAByAId(aId);
    }

    @Override
    public void editAByAId(Appointment appointment) {
        appointmentMapper.editAByAId(appointment);
    }

    @Override
    public void delAByAId(Integer aId) {
        appointmentMapper.delAByAId(aId);
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentMapper.saveAppointment(appointment);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public String queryLastHNameByClId(Integer clId) {
        return appointmentMapper.queryLastHNameByClId(clId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Appointment> queryAToDetail(Integer clId) {
        return appointmentMapper.queryAToDetail(clId);
    }

    @Override
    public void editAInvalidByAId(Integer aId) {
        appointmentMapper.editAInvalidByAId(aId);
    }
}
