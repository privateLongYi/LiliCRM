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
    public Integer saveAppointment(Appointment appointment) {
        return appointmentMapper.saveAppointment(appointment);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Appointment queryLastAByClId(Integer clId) {
        return appointmentMapper.queryLastAByClId(clId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Appointment> queryAToDetail(Integer clId) {
        return appointmentMapper.queryAToDetail(clId);
    }

    @Override
    public void editAStatusByAIdAndAStatus(Integer aId, Integer aStatus) {
        appointmentMapper.editAStatusByAIdAndAStatus(aId, aStatus);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Appointment> queryAByAClId(Integer aClId) {
        return appointmentMapper.queryAByAClId(aClId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryMaxAId() {
        return appointmentMapper.queryMaxAId();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Appointment queryAByClId(Integer clId) {
        return appointmentMapper.queryAByClId(clId);
    }
}
