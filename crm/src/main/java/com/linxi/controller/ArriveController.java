package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.Arrive;
import com.linxi.entity.Customer;
import com.linxi.entity.Operating;
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

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/12 18:25
 */
@Controller
@RequestMapping("crm/arrive")
@Api(value = "未到店客户控制类", tags = "未到店客户控制类")
public class ArriveController {

    @Autowired
    private IArriveService iArriveService;

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private IAppointmentService iAppointmentService;

    @Autowired
    private IClueService iClueService;

    @GetMapping("queryAByCName")
    @ApiOperation(value = "根据客户名称查询未到店客户")
    @ResponseBody
    public DataResult queryAByCName(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                    @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                    @ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                    @ApiParam(name = "rName", value = "角色名称", required = true) String rName,
                                    @ApiParam(name = "cName", value = "客户名称", required = true) String cName){
        List<Arrive> arrives = iArriveService.queryAByCName((page - 1) * limit, limit, uId, rName, cName);
        Integer total = iArriveService.getTotalByCName(uId, rName, cName);
        return DataResult.success(total, arrives);
    }

    @NoRepeatSubmit
    @PostMapping("saveArrive")
    @ApiOperation(value = "新增未到店客户")
    @ResponseBody
    public DataResult saveArrive(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                 @ApiParam(name = "cId", value = "客户编号", required = true) Integer cId,
                                 @ApiParam(name = "clId", value = "线索编号", required = true) Integer clId,
                                 @ApiParam(name = "arAId", value = "预约编号", required = true) Integer arAId,
                                 @ApiParam(name = "arHId", value = "门诊编号", required = true) Integer arHId,
                                 @ApiParam(name = "arCause", value = "未到店原因", required = true) String arCause){
        //添加操作记录
        Operating operating = new Operating(cId, uId, "添加了未到店客户", "");
        iOperatingService.saveOperating(operating);
        //根据客户状态查询编号
        Integer clTypeId = iCtypeService.queryCtypeByCtType("未到店");
        //改变客户状态为未到店状态
        iClueService.editClTypeIdByClId(clId, clTypeId);
        //新增未到店客户
        Arrive arrive = new Arrive(null, arAId, arHId, arCause, 0);
        iArriveService.saveArrive(arrive);
        //根据预约编号编辑预约状态
        iAppointmentService.editAStatusByAIdAndAStatus(arAId, 1);
        return DataResult.success();
    }

}
