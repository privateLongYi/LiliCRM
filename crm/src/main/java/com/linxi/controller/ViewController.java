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

    @GetMapping("customerlist")
    @ApiOperation(value = "预约客户列表")
    public String customerlist(){return "customerlist";}

    @GetMapping("customersave")
    @ApiOperation(value = "新增预约客户")
    public String customersave(){return "customersave";}

    @GetMapping("successsave")
    @ApiOperation(value = "新增成交客户")
    public String successsave(){return "successsave";}

    @GetMapping("transferedit")
    @ApiOperation(value = "编辑转诊记录")
    public String transferedit(){return "transferedit";}

    @GetMapping("transfersave")
    @ApiOperation(value = "新增转诊记录")
    public String transfersave(){return "transfersave";}
}
