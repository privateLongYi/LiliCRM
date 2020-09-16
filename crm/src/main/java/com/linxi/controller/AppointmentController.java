package com.linxi.controller;

import com.linxi.entity.Appointment;
import com.linxi.service.IAppointmentService;
import com.linxi.service.IAtypeService;
import com.linxi.service.ICtypeService;
import com.linxi.service.ICustomerService;
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
@Api(value = "预约客户控制类", tags = "预约客户控制类")
public class AppointmentController {

    @Autowired
    private IAppointmentService iAppointmentService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IAtypeService iAtypeService;

    @GetMapping("queryAByACId")
    @ApiOperation(value = "根据客户编号查询预约客户")
    @ResponseBody
    public DataResult queryAByACId(@ApiParam(value = "客户编号", required = true) Integer aCId){
        List<Appointment> appointments = iAppointmentService.queryAByACId(aCId);
        Integer total = iAppointmentService.getTotalAByACId(aCId);
        return new DataResult(0, "操作成功", total, appointments);
    }

    @GetMapping("queryAByAId")
    @ApiOperation(value = "根据编号查询预约客户")
    public String queryAByAId(@ApiParam(value = "编号", required = true) Integer aId, ModelMap map){
        Appointment appointment = iAppointmentService.queryAByAId(aId);
        map.addAttribute("a", appointment);
        return "appointment/appointmentedit";
    }

    @PostMapping("editAByAId")
    @ApiOperation(value = "根据编号编辑预约客户")
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
    @ApiOperation(value = "根据编号编辑预约客户")
    @ResponseBody
    public DataResult delAByAId(@ApiParam(value = "编号", required = true) Integer aId){
        iAppointmentService.delAByAId(aId);
        return new DataResult(0, "删除成功");
    }

    @PostMapping("saveAppointment")
    @ApiOperation(value = "新增预约客户")
    @ResponseBody
    public DataResult saveAppointment(@ApiParam(value = "客户编号", required = true) Integer aCId,
                                      @ApiParam(value = "预约时间", required = true) String aTime,
                                      @ApiParam(value = "门诊编号", required = true) Integer aHId,
                                      @ApiParam(value = "预约类型", required = true) String atType){
        //根据客户状态查询编号
        Integer cTypeId = iCtypeService.queryCtypeByCtType("待到店");
        //改变客户状态为未到店状态
        iCustomerService.editCTypeIdByCId(aCId, cTypeId);
        //根据预约类型查询编号
        Integer aTypeId = iAtypeService.queryAByAType(atType);
        //新增预约客户
        Appointment appointment = new Appointment(null, aCId, Timestamp.valueOf(aTime), aHId, aTypeId);
        iAppointmentService.saveAppointment(appointment);
        return new DataResult(0, "新增成功");
    }

}
