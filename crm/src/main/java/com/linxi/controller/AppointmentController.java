package com.linxi.controller;

import com.linxi.entity.Appointment;
import com.linxi.service.IAppointmentService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/31 21:08
 */
@Controller
@RequestMapping("appointment")
@Api(value = "客户预约控制类", tags = "客户预约控制类")
public class AppointmentController {

    @Autowired
    private IAppointmentService iAppointmentService;

    @GetMapping("queryAByACId")
    @ApiOperation(value = "根据客户编号查询客户预约")
    @ResponseBody
    public DataResult queryAByACId(@ApiParam(value = "客户编号", required = true) Integer aCId){
        List<Appointment> appointments = iAppointmentService.queryAByACId(aCId);
        Integer total = iAppointmentService.getTotalAByACId(aCId);
        return new DataResult(0, "操作成功", total, appointments);
    }

    @GetMapping("queryAByAId")
    @ApiOperation(value = "根据编号查询客户预约")
    public String queryAByAId(@ApiParam(value = "编号", required = true) Integer aId, ModelMap map){
        Appointment appointment = iAppointmentService.queryAByAId(aId);
        map.addAttribute("a", appointment);
        return "appointment/appointmentedit";
    }

    @PostMapping("editAByAId")
    @ApiOperation(value = "根据编号编辑客户预约")
    @ResponseBody
    public DataResult editAByAId(@ApiParam(value = "编号", required = true) Integer aId,
                                 @ApiParam(value = "客户编号", required = true) Integer aCId,
                                 @ApiParam(value = "预约时间", required = true) String aTime,
                                 @ApiParam(value = "门诊编号", required = true) Integer aHId,
                                 @ApiParam(value = "预约类型编号", required = true) Integer aTypeId){
        Appointment appointment = new Appointment(aId, aCId, Timestamp.valueOf(aTime), aHId, aTypeId);
        iAppointmentService.editAByAId(appointment);
        return new DataResult(0, "编辑成功");
    }

    @GetMapping("delAByAId")
    @ApiOperation(value = "根据编号编辑客户预约")
    @ResponseBody
    public DataResult delAByAId(@ApiParam(value = "编号", required = true) Integer aId){
        iAppointmentService.delAByAId(aId);
        return new DataResult(0, "删除成功");
    }

}
