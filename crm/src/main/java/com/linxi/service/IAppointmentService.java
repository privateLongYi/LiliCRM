package com.linxi.service;

import com.linxi.entity.Appointment;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

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

    //根据编号和状态编辑预约状态
    void editAStatusByAIdAndAStatus(@Param("aId") Integer aId,
                                    @Param("aStatus") Integer aStatus);

    //根据线索编号查询预约
    List<Appointment> queryAByAClId(Integer aClId);

    //查询最大的预约编号
    Integer queryMaxAId();

}
