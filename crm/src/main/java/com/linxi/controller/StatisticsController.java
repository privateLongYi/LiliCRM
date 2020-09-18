package com.linxi.controller;

import com.linxi.service.ICtypeService;
import com.linxi.service.ICustomerService;
import com.linxi.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * @Author LongYi
 * @create 2020/9/17 21:40
 */
@Controller
@RequestMapping("statistics")
@Api(value = "统计控制类", tags = "统计控制类")
public class StatisticsController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private IUserService iUserService;

    @GetMapping("arrivePercent")
    @ApiOperation(value = "获取客户到店率")
    @ResponseBody
    public String arrivePercent(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId){
        //根据客户状态查询编号
        Integer awaitarriveId = iCtypeService.queryCtypeByCtType("待到店");
        Integer failId = iCtypeService.queryCtypeByCtType("未成交");
        Integer successId = iCtypeService.queryCtypeByCtType("成交");
        //根据用户编号和客户状态查询客户
        double awaitarrive = iCustomerService.getTotalCByUIdAndCTypeId(uId, awaitarriveId);
        double fail = iCustomerService.getTotalCByUIdAndCTypeId(uId, failId);
        double success = iCustomerService.getTotalCByUIdAndCTypeId(uId, successId);
        double percent = (fail + success) / (awaitarrive + fail + success) * 100;
        BigDecimal b = new BigDecimal(percent);
        percent = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("客户到店率："+percent+"%");
        return percent+"%";
    }

    @GetMapping("successPercent")
    @ApiOperation(value = "获取到店成交率")
    @ResponseBody
    public String successPercent(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId){
        //根据客户状态查询编号
        Integer failId = iCtypeService.queryCtypeByCtType("未成交");
        Integer successId = iCtypeService.queryCtypeByCtType("成交");
        //根据用户编号和客户状态查询客户
        double fail = iCustomerService.getTotalCByUIdAndCTypeId(uId, failId);
        double success = iCustomerService.getTotalCByUIdAndCTypeId(uId, successId);
        double percent = success / (fail + success) * 100;
        BigDecimal b = new BigDecimal(percent);
        percent = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("到店成交率："+percent+"%");
        return percent+"%";
    }

    @GetMapping("performance")
    @ApiOperation(value = "获取目标业绩完成度")
    @ResponseBody
    public String performance(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId){
        //根据用户编号查询客户支付总额（即业绩）
        Integer performance = iUserService.getPerformanceByUId(uId);
        System.out.println("目标业绩完成度："+performance+"/1000000");
        return performance+"/1000000";
    }

}
