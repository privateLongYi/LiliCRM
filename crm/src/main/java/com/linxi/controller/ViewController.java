package com.linxi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "视图", description = "负责返回视图")
@Controller
public class ViewController {

    @GetMapping("index")
    @ApiOperation(value = "首页")
    public String index(){return "index";}

    @GetMapping("workbench")
    @ApiOperation(value = "工作台")
    public String workbench(){return "workbench";}

    @GetMapping("customerlist")
    @ApiOperation(value = "客户信息列表")
    public String customerlist(){return "customer/customerlist";}

    @GetMapping("screen")
    @ApiOperation(value = "高级筛选")
    public String screen(){return "screen/screen";}

    @GetMapping("customersave")
    @ApiOperation(value = "新增客户信息")
    public String customersave(){return "customer/customersave";}

    @GetMapping("transactionlist")
    @ApiOperation(value = "客户预约列表")
    public String transactionlist(){return "transaction/transactionlist";}

    @GetMapping("transactionsave")
    @ApiOperation(value = "新增客户预约")
    public String transactionsave(){return "transaction/transactionsave";}

    @GetMapping("transactionedit")
    @ApiOperation(value = "编辑客户预约")
    public String transactionedit(){return "transaction/transactionedit";}

    @GetMapping("successlist")
    @ApiOperation(value = "客户信息列表")
    public String successlist(){return "success/successlist";}

    @GetMapping("successsave")
    @ApiOperation(value = "新增客户信息")
    public String successsave(){return "transfer";}

    @GetMapping("successedit")
    @ApiOperation(value = "编辑客户信息")
    public String successedit(){return "success/successedit";}

    @GetMapping("contact")
    @ApiOperation(value = "待联系客户管理")
    public String contact(){return "customer/contact";}

}
