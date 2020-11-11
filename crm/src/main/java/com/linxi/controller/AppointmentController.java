package com.linxi.controller;

import com.linxi.entity.Appointment;
import com.linxi.service.*;
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
    private ISuccessService iSuccessService;

    @Autowired
    private IClueService iClueService;

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
    public DataResult editAByAId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                 @ApiParam(value = "编号", required = true) Integer aId,
                                 @ApiParam(value = "线索编号", required = true) Integer aClId,
                                 @ApiParam(value = "预约时间", required = true) String aTime,
                                 @ApiParam(value = "门诊编号", required = true) Integer aHId,
                                 @ApiParam(value = "预约类型编号", required = true) Integer aTypeId,
                                 @ApiParam(value = "预约状态", required = true) Integer aStatus){
        Appointment appointment = new Appointment(aId, aClId, Timestamp.valueOf(aTime), aHId, aTypeId, aStatus, null);
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
    public DataResult saveAppointment(@ApiParam(value = "用户编号", required = true) Integer uId,
                                      @ApiParam(value = "线索编号", required = true) Integer aClId,
                                      @ApiParam(value = "预约时间", required = true) String aTime,
                                      @ApiParam(value = "门诊编号", required = true) Integer aHId,
                                      @ApiParam(value = "预约类型", required = true) String atType){
        //根据客户状态查询编号
        Integer clTypeId = iCtypeService.queryCtypeByCtType("待到店");
        //改变客户状态为待到店状态
        iClueService.editClTypeIdByClId(aClId, clTypeId);
        //根据预约类型查询编号
        Integer aTypeId = iAtypeService.queryAByAType(atType);
        //新增预约客户
        Appointment appointment = new Appointment(null, aClId, Timestamp.valueOf(aTime), aHId, aTypeId, 0, null);
        iAppointmentService.saveAppointment(appointment);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("queryAToDetail")
    @ApiOperation(value = "根据线索编号查询预约记录（详情）")
    @ResponseBody
    public DataResult queryAToDetail(@ApiParam(value = "线索编号", required = true) Integer clId){
        //根据线索编号查询预约
        List<Appointment> appointments = iAppointmentService.queryAToDetail(clId);
        return new DataResult(0, "操作成功", 0, appointments);
    }

    @GetMapping("queryNewAppoint")
    @ApiOperation(value = "获取最新的预约")
    @ResponseBody
    public DataResult queryNewAppoint(){
        //获取最大的预约编号
        Integer aId = iAppointmentService.queryMaxAId();
        //根据预约编号查询预约
        Appointment appointment = iAppointmentService.queryAByAId(aId);
        return new DataResult(0, "操作成功", 0, appointment);
    }

}
