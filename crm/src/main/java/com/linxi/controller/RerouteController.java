package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.Appointment;
import com.linxi.entity.Hospital;
import com.linxi.entity.Operating;
import com.linxi.entity.Reroute;
import com.linxi.service.*;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/12 20:09
 */
@Controller
@RequestMapping("crm/reroute")
@Api(value = "改约记录控制类", tags = "改约记录控制类")
public class RerouteController {

    @Autowired
    private IRerouteService iRerouteService;

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private IAtypeService iAtypeService;

    @Autowired
    private IAppointmentService iAppointmentService;

    @Autowired
    private IClueService iClueService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private IHospitalService iHospitalService;

    @Autowired
    private IFailService iFailService;

    @NoRepeatSubmit
    @PostMapping("saveReroute")
    @ApiOperation(value = "新增改约记录")
    @ResponseBody
    public DataResult saveReroute(@ApiParam(name = "uId", value = "操作用户编号", required = true) Integer uId,
                                  @ApiParam(name = "uName", value = "操作用户姓名", required = true) String uName,
                                  @ApiParam(name = "cName", value = "客户姓名", required = true) String cName,
                                  @ApiParam(name = "reUId", value = "负责人编号", required = true) Integer reUId,
                                  @ApiParam(name = "cId", value = "客户编号", required = true) Integer cId,
                                  @ApiParam(name = "aId", value = "预约编号", required = true) Integer aId,
                                  @ApiParam(name = "reClId", value = "线索编号", required = true) Integer reClId,
                                  @ApiParam(name = "reHId", value = "门诊编号", required = true) Integer reHId,
                                  @ApiParam(name = "reLastTime", value = "上次预约时间", required = true) Timestamp reLastTime,
                                  @ApiParam(name = "reTime", value = "本次预约时间", required = true) Timestamp reTime,
                                  @ApiParam(name = "reCause", value = "改约原因", required = true) String reCause,
                                  @ApiParam(name = "flId", value = "未成交编号", required = true) Integer flId){
        //根据门诊编号查询门诊
        Hospital hospital = iHospitalService.queryHByHId(reHId);
        //新增操作记录
        Operating operating = new Operating(cId, uId, "改约", uName + "重新为客户" + cName + "预约了门诊（" + hospital.gethName() + "/" + reTime + "）");
        iOperatingService.saveOperating(operating);
        //根据预约类型查询编号
        Integer atId = iAtypeService.queryAByAType("改约");
        //编辑预约状态为失效
        iAppointmentService.editAStatusByAIdAndAStatus(aId, -1);
        //新增预约记录
        Appointment appointment = new Appointment(null, reClId, reTime, reHId, atId, 0, null);
        iAppointmentService.saveAppointment(appointment);
        //查询待到店编号
        Integer ctId = iCtypeService.queryCtypeByCtType("待到店");
        //编辑客户状态
        iClueService.editClTypeIdByClId(reClId, ctId);
        //根据预约编号编辑预约状态
        iAppointmentService.editAStatusByAIdAndAStatus(aId, 1);
        //新增改约记录
        Reroute reroute = new Reroute(reClId, reHId, reLastTime, reTime, reCause, reUId);
        iRerouteService.saveReroute(reroute);
        //根据编号删除未成交记录
        if (flId != null){
            iFailService.delFlByFlId(flId);
        }
        return DataResult.success();
    }

    @GetMapping("queryRByCName")
    @ApiOperation(value = "根据客户名称查询改约客户")
    @ResponseBody
    public DataResult queryRByCName(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                    @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                    @ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                    @ApiParam(name = "rName", value = "角色名称", required = true) String rName,
                                    @ApiParam(name = "cName", value = "客户名称", required = true) String cName,
                                    @ApiParam(name = "export", value = "是否导出", required = true) Integer export){
        List<Reroute> reroutes = iRerouteService.queryRByCName((page-1)*limit, limit, uId, rName, cName, export);
        Integer total = iRerouteService.getTotalByCName(uId, rName, cName);
        return DataResult.success(total, reroutes);
    }

}
