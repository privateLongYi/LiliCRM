package com.linxi.controller;

import com.linxi.entity.Arrive;
import com.linxi.entity.Customer;
import com.linxi.entity.Operating;
import com.linxi.service.IArriveService;
import com.linxi.service.ICtypeService;
import com.linxi.service.ICustomerService;
import com.linxi.service.IOperatingService;
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
@RequestMapping("arrive")
@Api(value = "未到店客户控制类", tags = "未到店客户控制类")
public class ArriveController {

    @Autowired
    private IArriveService iArriveService;

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping("saveArrive")
    @ApiOperation(value = "新增未到店客户")
    @ResponseBody
    public DataResult saveArrive(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                 @ApiParam(name = "arCId", value = "客户编号", required = true) Integer arCId,
                                 @ApiParam(name = "arHId", value = "门诊编号", required = true) Integer arHId,
                                 @ApiParam(name = "arCause", value = "未到店原因", required = true) String arCause){
        //添加操作记录
        Operating operating = new Operating(arCId, uId, "添加了未到店客户");
        iOperatingService.addOperatingRecord(operating);
        //根据客户状态查询编号
        Integer cTypeId = iCtypeService.queryCtypeByCtType("未到店");
        //改变客户状态为未到店状态
        iCustomerService.editCTypeIdByCId(arCId, cTypeId);
        //新增未到店客户
        Arrive arrive = new Arrive(null, arCId, arHId, arCause);
        iArriveService.saveArrive(arrive);
        return new DataResult(0, "新增成功");
    }

}
