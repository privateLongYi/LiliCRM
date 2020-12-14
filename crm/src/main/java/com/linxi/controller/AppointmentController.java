package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.*;
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
    private IOperatingService iOperatingService;

    @Autowired
    private IClueService iClueService;

    @Autowired
    private IAtypeService iAtypeService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IHospitalService iHospitalService;

    @GetMapping("queryAByACId")
    @ApiOperation(value = "根据客户编号查询预约客户")
    @ResponseBody
    public DataResult queryAByACId(@ApiParam(value = "客户编号", required = true) Integer aCId){
        List<Appointment> appointments = iAppointmentService.queryAByACId(aCId);
        Integer total = iAppointmentService.getTotalAByACId(aCId);
        return DataResult.success(total, appointments);
    }

    @GetMapping("queryAByAId")
    @ApiOperation(value = "根据编号查询预约客户")
    public String queryAByAId(@ApiParam(value = "编号", required = true) Integer aId, ModelMap map){
        Appointment appointment = iAppointmentService.queryAByAId(aId);
        map.addAttribute("a", appointment);
        return "appointment/appointmentedit";
    }

    @NoRepeatSubmit
    @PostMapping("saveAppointment")
    @ApiOperation(value = "新增预约客户")
    @ResponseBody
    public DataResult saveAppointment(@ApiParam(value = "用户编号", required = true) Integer uId,
                                      @ApiParam(value = "用户姓名", required = true) String uName,
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
        //根据线索编号查询客户
        Customer customer = iCustomerService.queryCByClId(aClId);
        //根据门诊编号查询门诊
        Hospital hospital = iHospitalService.queryHByHId(aHId);
        //新增操作记录
        Operating operating = new Operating(customer.getcId(), uId, "预约", uName + "为" + customer.getcName() + "预约了" + hospital.gethName());
        iOperatingService.saveOperating(operating);
        return DataResult.success();
    }

    @GetMapping("queryAToDetail")
    @ApiOperation(value = "根据线索编号查询预约记录（详情）")
    @ResponseBody
    public DataResult queryAToDetail(@ApiParam(value = "线索编号", required = true) Integer clId){
        //根据线索编号查询预约
        List<Appointment> appointments = iAppointmentService.queryAToDetail(clId);
        return DataResult.success(appointments);
    }

    @GetMapping("queryNewAppoint")
    @ApiOperation(value = "获取最新的预约")
    @ResponseBody
    public DataResult queryNewAppoint(){
        //获取最大的预约编号
        Integer aId = iAppointmentService.queryMaxAId();
        //根据预约编号查询预约
        Appointment appointment = iAppointmentService.queryAByAId(aId);
        return DataResult.success(appointment);
    }

    @NoRepeatSubmit
    @PostMapping("saveCAndA")
    @ApiOperation(value = "新增客户信息和预约信息")
    @ResponseBody
    public DataResult saveCustomer(@ApiParam(name = "uId", value = "操作用户编号", required = true) Integer uId,
                                   @ApiParam(name = "uName", value = "操作用户姓名", required = true) String uName,
                                   @ApiParam(name = "cName", value = "姓名", required = true) String cName,
                                   @ApiParam(name = "cSex", value = "性别", required = true) String cSex,
                                   @ApiParam(name = "cAge", value = "年龄", required = false) Integer cAge,
                                   @ApiParam(name = "cTel", value = "电话", required = true) String cTel,
                                   @ApiParam(name = "cWx", value = "微信号", required = true) String cWx,
                                   @ApiParam(name = "clProject", value = "报名项目", required = true) String clProject,
                                   @ApiParam(name = "clPlaceTime", value = "报名时间", required = true) String clPlaceTime,
                                   @ApiParam(name = "clEntryFee", value = "报名费", required = false) String clEntryFee,
                                   @ApiParam(name = "clUId", value = "用户编号", required = true) Integer clUId,
                                   @ApiParam(name = "clSource", value = "来源", required = false) String clSource,
                                   @ApiParam(name = "clTypeId", value = "状态编号", required = true) Integer clTypeId,
                                   @ApiParam(name = "clRemark", value = "备注", required = false) String clRemark,
                                   @ApiParam(name = "clMessage", value = "症状信息", required = false) String clMessage,
                                   @ApiParam(name = "aTime", value = "预约时间", required = false) String aTime,
                                   @ApiParam(name = "aHId", value = "预约门诊编号", required = false) Integer aHId,
                                   @ApiParam(name = "atType", value = "预约类型", required = false) String atType) {
        //创建客户
        Customer c = new Customer(null, cName, cSex, cAge, cTel, cWx, null);
        //根据姓名查询客户
        List<Customer> customers1 = iCustomerService.queryCByCName(cName);
        if (customers1.size() != 0) {
            String s = customers1.get(0).getcName();
            if (s.contains("(")){
                String substring = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
                Integer num = Integer.parseInt(substring) + 1;
                String number = "(" + num + ")";
                c.setcName(c.getcName() + number);
            } else {
                String number = "(1)";
                c.setcName(c.getcName() + number);
            }
        }
        //新增客户
        iCustomerService.saveCustomer(c);
        //新增线索
        Clue clue = new Clue(null, c.getcId(), clProject, Timestamp.valueOf(clPlaceTime), clRemark, clEntryFee, clUId, clSource, clMessage, clTypeId, 0);
        iClueService.saveClue(clue);
        //新增操作记录
        Operating operating = new Operating(c.getcId(), uId, "新增", uName + "添加了客户" + cName);
        iOperatingService.saveOperating(operating);
        //根据客户状态查询编号
        Integer clTypeId2 = iCtypeService.queryCtypeByCtType("待到店");
        //改变客户状态为待到店状态
        iClueService.editClTypeIdByClId(clue.getClId(), clTypeId2);
        //根据预约类型查询编号
        Integer aTypeId = iAtypeService.queryAByAType(atType);
        //新增预约客户
        Appointment appointment = new Appointment(null, clue.getClId(), Timestamp.valueOf(aTime), aHId, aTypeId, 0, null);
        iAppointmentService.saveAppointment(appointment);
        //根据线索编号查询客户
        Customer customer = iCustomerService.queryCByClId(clue.getClId());
        //根据门诊编号查询门诊
        Hospital hospital = iHospitalService.queryHByHId(aHId);
        //新增操作记录
        Operating operating2 = new Operating(customer.getcId(), uId, "预约", uName + "为" + customer.getcName() + "预约了" + hospital.gethName());
        iOperatingService.saveOperating(operating2);
        return DataResult.success();
    }

}
