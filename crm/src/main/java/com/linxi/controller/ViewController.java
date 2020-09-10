package com.linxi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    @GetMapping("role")
    @ApiOperation(value = "角色列表")
    public String rolelist(){
        return "role/rolelist";
    }

    @GetMapping("role/rolesave")
    @ApiOperation(value = "新增角色")
    public String rolesave(){return "role/rolesave";}

    @GetMapping("role/rolesetting")
    @ApiOperation(value = "角色设定")
    public String rolesetting(@ApiParam(name = "rId", value = "编号", required = true) Integer rId, ModelMap map){
        map.addAttribute("rId", rId);
        return "role/rolesetting";
    }

    @GetMapping("menu")
    @ApiOperation(value = "菜单列表")
    public String menulist(){
        return "menu/menulist";
    }

    @GetMapping("menu/menusave")
    @ApiOperation(value = "新增菜单")
    public String menusave(){return "menu/menusave";}

    @GetMapping("ctype")
    @ApiOperation(value = "客户状态列表")
    public String ctypelist(){
        return "ctype/ctypelist";
    }

    @GetMapping("ctype/ctypesave")
    @ApiOperation(value = "新增客户状态")
    public String ctypesave(){return "ctype/ctypesave";}

    @GetMapping("atype")
    @ApiOperation(value = "预约类型列表")
    public String atypelist(){
        return "atype/atypelist";
    }

    @GetMapping("atype/atypesave")
    @ApiOperation(value = "新增预约类型")
    public String atypesave(){return "atype/atypesave";}

    @GetMapping("ftype")
    @ApiOperation(value = "回访类型列表")
    public String ftypelist(){
        return "ftype/ftypelist";
    }

    @GetMapping("ftype/ftypesave")
    @ApiOperation(value = "新增回访类型")
    public String ftypesave(){return "ftype/ftypesave";}

    @GetMapping("stype")
    @ApiOperation(value = "成交类型列表")
    public String stypelist(){
        return "stype/stypelist";
    }

    @GetMapping("stype/stypesave")
    @ApiOperation(value = "新增成交类型")
    public String stypesave(){return "stype/stypesave";}

    @GetMapping("paytype")
    @ApiOperation(value = "支付类型列表")
    public String paytypelist(){
        return "paytype/paytypelist";
    }

    @GetMapping("paytype/paytypesave")
    @ApiOperation(value = "新增支付类型")
    public String paytypesave(){return "paytype/paytypesave";}

    @GetMapping("hospital")
    @ApiOperation(value = "门诊列表")
    public String hospitallist(){
        return "hospital/hospitallist";
    }

    @GetMapping("hospital/hospitalsave")
    @ApiOperation(value = "新增门诊")
    public String hospitalsave(){return "hospital/hospitalsave";}

    @GetMapping("contact")
    @ApiOperation(value = "待联系客户管理")
    public String contact(){return "customer/contact";}

}
