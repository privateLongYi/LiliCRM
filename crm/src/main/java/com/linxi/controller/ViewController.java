package com.linxi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "视图", description = "负责返回视图")
@Controller
public class ViewController {

    @GetMapping("workbench")
    @ApiOperation(value = "工作台")
    public String workbench(){
        return "workbench";
    }

    @GetMapping("customer")
    @ApiOperation(value = "客户信息列表")
    public String customerlist(){
        return "customer/customerlist";
    }

    @GetMapping("screen")
    @ApiOperation(value = "高级筛选")
    public String screen(){return "screen/screen";}

    @GetMapping("customer/customersave")
    @ApiOperation(value = "新增客户信息")
    public String customersave(){return "customer/customersave";}

    @GetMapping("user")
    @ApiOperation(value = "用户列表")
    public String userlist(){
        return "user/userlist";
    }

    @GetMapping("user/usersave")
    @ApiOperation(value = "新增用户")
    public String usersave(){return "user/usersave";}

}
