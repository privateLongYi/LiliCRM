package com.linxi.controller;

import com.linxi.entity.Customer;
import com.linxi.entity.Fail;
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
 * @create 2020/9/12 21:15
 */
@Controller
@RequestMapping("fail")
@Api(value = "未成交客户控制类", tags = "未成交客户控制类")
public class FailController {

    @Autowired
    private IFailService iFailService;

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private IAppointmentService iAppointmentService;

    @Autowired
    private IClueService iClueService;

    @PostMapping("saveFail")
    @ApiOperation(value = "新增未成交客户")
    @ResponseBody
    public DataResult saveFail(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                               @ApiParam(name = "cId", value = "客户编号", required = true) Integer cId,
                               @ApiParam(name = "clId", value = "线索编号", required = true) Integer clId,
                               @ApiParam(name = "flAId", value = "预约编号", required = true) Integer flAId,
                               @ApiParam(name = "flHId", value = "门诊编号", required = true) Integer flHId,
                               @ApiParam(name = "flCause", value = "未成交原因", required = true) String flCause){
        //添加操作记录
        Operating operating = new Operating(cId, uId, "添加了未成交客户");
        iOperatingService.saveOperating(operating);
        //根据客户状态查询编号
        Integer clTypeId = iCtypeService.queryCtypeByCtType("未成交");
        //改变客户状态为未成交状态
        iClueService.editClTypeIdByClId(clId, clTypeId);
        //新增未成交客户
        Fail fail = new Fail(null, flAId, flHId, flCause);
        iFailService.saveFail(fail);
        //根据预约编号编辑预约状态
        iAppointmentService.editAStatusByAIdAndAStatus(flAId, 3);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("queryFailByCName")
    @ApiOperation(value = "根据客户名称查询未成交客户")
    @ResponseBody
    public DataResult queryFailByCName(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                       @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                       @ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                       @ApiParam(name = "rName", value = "角色名称", required = true) String rName,
                                       @ApiParam(name = "cName", value = "客户名称", required = true) String cName,
                                       @ApiParam(name = "export", value = "是否导出", required = true) Integer export){
        List<Fail> fails = iFailService.queryFailByCName((page-1)*limit, limit, uId, rName, cName, export);
        Integer total = iFailService.getTotalByCName(uId, rName, cName);
        return new DataResult(0, "操作成功", total, fails);
    }

}
