package com.linxi.controller;

import com.linxi.entity.Appointment;
import com.linxi.entity.Operating;
import com.linxi.entity.Reroute;
import com.linxi.service.IAppointmentService;
import com.linxi.service.IAtypeService;
import com.linxi.service.IOperatingService;
import com.linxi.service.IRerouteService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * @Author LongYi
 * @create 2020/9/12 20:09
 */
@Controller
@RequestMapping("reroute")
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

    @PostMapping("saveReroute")
    @ApiOperation(value = "新增改约记录")
    @ResponseBody
    public DataResult saveReroute(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                  @ApiParam(name = "reCId", value = "客户编号", required = true) Integer reCId,
                                  @ApiParam(name = "reHId", value = "门诊编号", required = true) Integer reHId,
                                  @ApiParam(name = "reLastTime", value = "上次预约时间", required = true) Timestamp reLastTime,
                                  @ApiParam(name = "reTime", value = "本次预约时间", required = true) Timestamp reTime,
                                  @ApiParam(name = "reCause", value = "改约原因", required = true) String reCause){
        //新增操作记录
        Operating operating = new Operating(reCId, uId, "改约了客户");
        iOperatingService.addOperatingRecord(operating);
        //根据预约类型查询编号
        Integer atId = iAtypeService.queryAByAType("改约");
        //新增预约记录
        Appointment appointment = new Appointment(null, reCId, reTime, reHId, atId);
        iAppointmentService.addAppoint(appointment);
        //新增改约记录
        Reroute reroute = new Reroute(reCId, reHId, reLastTime, reTime, reCause);
        iRerouteService.saveReroute(reroute);
        return new DataResult(0, "新增成功");
    }

}
