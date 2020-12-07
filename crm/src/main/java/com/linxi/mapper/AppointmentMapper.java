package com.linxi.mapper;

import com.linxi.entity.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentMapper {

    //新增预约客户
    Integer saveAppointment(Appointment appointment);

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

    //根据线索编号查询最近预约
    Appointment queryLastAByClId(Integer clId);

    //根据线索编号查询预约记录（详情）
    List<Appointment> queryAToDetail(Integer clId);

    //根据编号和状态编辑预约状态
    void editAStatusByAIdAndAStatus(@Param("aId") Integer aId,
                                    @Param("aStatus") Integer aStatus);

    //根据线索编号查询预约
    List<Appointment> queryAByAClId(Integer aClId);

    //查询最大的预约编号
    Integer queryMaxAId();

    //根据线索编号查询预约
    Appointment queryAByClId(Integer clId);

}