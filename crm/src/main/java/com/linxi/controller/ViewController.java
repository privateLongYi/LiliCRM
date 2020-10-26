package com.linxi.controller;

import com.linxi.service.ICtypeService;
import com.linxi.service.IFtypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "视图", description = "负责返回视图")
@Controller
public class ViewController {

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private IFtypeService iFtypeService;

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
    public String screen(@ApiParam(name = "cType", value = "客户状态", required = true) String cType, ModelMap map){
        if (cType != null) {
            //根据客户状态查询编号
            Integer cTypeId = iCtypeService.queryCtypeByCtType(cType);
            map.addAttribute("cTypeId", cTypeId);
            map.addAttribute("cType", cType);
        } else {
            map.addAttribute("cTypeId", 0);
            map.addAttribute("cType", "");
        }
        return "screen/screen";
    }

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

    @GetMapping("awaitarrive")
    @ApiOperation(value = "待到店客户列表")
    public String awaitarrive(){return "customer/awaitarrivelist";}

    @GetMapping("arrivesave")
    @ApiOperation(value = "新增未到店客户")
    public String arrivesave(@ApiParam(name = "cId", value = "客户编号", required = true) Integer cId,
                             @ApiParam(name = "clId", value = "线索编号", required = true) Integer clId,
                             @ApiParam(name = "aId", value = "预约编号", required = true) Integer aId,
                             @ApiParam(name = "cName", value = "客户名称", required = true) String cName,
                             @ApiParam(name = "hId", value = "门诊编号", required = true) Integer hId,
                             @ApiParam(name = "hName", value = "门诊名称", required = true) String hName,
                             ModelMap map){
        map.addAttribute("cId", cId);
        map.addAttribute("clId", clId);
        map.addAttribute("aId", aId);
        map.addAttribute("cName", cName);
        map.addAttribute("hId", hId);
        map.addAttribute("hName", hName);
        return "customer/arrivesave";
    }

    @GetMapping("reroutesave")
    @ApiOperation(value = "新增改约记录")
    public String reroutesave(@ApiParam(name = "cId", value = "客户编号", required = true) Integer cId,
                              @ApiParam(name = "clId", value = "线索编号", required = true) Integer clId,
                              @ApiParam(name = "reUId", value = "负责人编号", required = true) Integer reUId,
                              @ApiParam(name = "arId", value = "未到店编号", required = true) Integer arId,
                              @ApiParam(name = "aId", value = "预约编号", required = true) Integer aId,
                              @ApiParam(name = "cName", value = "客户名称", required = true) String cName,
                              @ApiParam(name = "hId", value = "门诊编号", required = true) Integer hId,
                              @ApiParam(name = "hName", value = "门诊名称", required = true) String hName,
                              @ApiParam(name = "aTime", value = "上次预约时间", required = true) String aTime,
                              ModelMap map){
        map.addAttribute("cId", cId);
        map.addAttribute("clId", clId);
        map.addAttribute("reUId", reUId);
        map.addAttribute("arId", arId);
        map.addAttribute("aId", aId);
        map.addAttribute("cName", cName);
        map.addAttribute("hId", hId);
        map.addAttribute("hName", hName);
        map.addAttribute("aTime", aTime);
        return "customer/reroutesave";
    }

    @GetMapping("failsave")
    @ApiOperation(value = "新增未成交客户")
    public String failsave(@ApiParam(name = "cId", value = "客户编号", required = true) Integer cId,
                           @ApiParam(name = "clId", value = "线索编号", required = true) Integer clId,
                           @ApiParam(name = "aId", value = "预约编号", required = true) Integer aId,
                           @ApiParam(name = "cName", value = "客户名称", required = true) String cName,
                           @ApiParam(name = "hId", value = "门诊编号", required = true) Integer hId,
                           @ApiParam(name = "hName", value = "门诊名称", required = true) String hName,
                           ModelMap map){
        map.addAttribute("cId", cId);
        map.addAttribute("clId", clId);
        map.addAttribute("aId", aId);
        map.addAttribute("cName", cName);
        map.addAttribute("hId", hId);
        map.addAttribute("hName", hName);
        return "fail/failsave";
    }

    @GetMapping("successsave")
    @ApiOperation(value = "新增成交客户")
    public String successsave(@ApiParam(name = "cId", value = "客户编号", required = true) Integer cId,
                              @ApiParam(name = "clId", value = "线索编号", required = true) Integer clId,
                              @ApiParam(name = "sAId", value = "预约编号", required = true) Integer sAId,
                              @ApiParam(name = "cName", value = "客户名称", required = true) String cName,
                              @ApiParam(name = "hId", value = "门诊编号", required = true) Integer hId,
                              @ApiParam(name = "hName", value = "门诊名称", required = true) String hName,
                              ModelMap map){
        map.addAttribute("cId", cId);
        map.addAttribute("clId", clId);
        map.addAttribute("sAId", sAId);
        map.addAttribute("cName", cName);
        map.addAttribute("hId", hId);
        map.addAttribute("hName", hName);
        return "success/successsave";
    }

    @GetMapping("arrive")
    @ApiOperation(value = "未到店客户列表")
    public String arrive(){return "customer/arrivelist";}

    @GetMapping("fail")
    @ApiOperation(value = "未成交客户列表")
    public String fail(){return "fail/faillist";}

    @GetMapping("followsave")
    @ApiOperation(value = "新增客户跟进")
    public String followssave(@ApiParam(name = "cId", value = "客户编号", required = true) Integer cId,
                              @ApiParam(name = "clId", value = "线索编号", required = true) Integer clId,
                              @ApiParam(name = "clUId", value = "负责人编号", required = true) Integer clUId,
                              @ApiParam(name = "cName", value = "客户名称", required = true) String cName,
                              @ApiParam(name = "ftType", value = "回访类型", required = true) String ftType,
                              ModelMap map){
        //跟进回访类型查询编号
        Integer ftId = iFtypeService.queryFtIdByFtType(ftType);
        map.addAttribute("cId", cId);
        map.addAttribute("clId", clId);
        map.addAttribute("clUId", clUId);
        map.addAttribute("cName", cName);
        map.addAttribute("ftId", ftId);
        map.addAttribute("ftType", ftType);
        return "customer/followsave";
    }

    @GetMapping("referralsave")
    @ApiOperation(value = "新增转诊记录")
    public String referralsave(@ApiParam(name = "cId", value = "客户编号", required = true) Integer cId,
                               @ApiParam(name = "clId", value = "下午编号", required = true) Integer clId,
                               @ApiParam(name = "rAId", value = "预约编号", required = true) Integer rAId,
                               @ApiParam(name = "clUId", value = "负责人编号", required = true) Integer clUId,
                               @ApiParam(name = "flId", value = "未成交编号", required = true) Integer flId,
                               @ApiParam(name = "cName", value = "客户名称", required = true) String cName,
                               @ApiParam(name = "hId", value = "门诊编号", required = true) Integer hId,
                               @ApiParam(name = "hName", value = "客户名称", required = true) String hName,
                               ModelMap map){
        map.addAttribute("cId", cId);
        map.addAttribute("clId", clId);
        map.addAttribute("rAId", rAId);
        map.addAttribute("clUId", clUId);
        map.addAttribute("flId", flId);
        map.addAttribute("cName", cName);
        map.addAttribute("hId", hId);
        map.addAttribute("hName", hName);
        return "customer/referralsave";
    }

    @GetMapping("success")
    @ApiOperation(value = "成交客户列表")
    public String success(){return "success/successlist";}

    @GetMapping("payrecordsave")
    @ApiOperation(value = "新增支付记录")
    public String payrecordsave(@ApiParam(name = "cId", value = "成交客户编号", required = true) Integer cId,
                                @ApiParam(name = "cName", value = "成交客户名称", required = true) String cName,
                                ModelMap map){
        map.addAttribute("cId", cId);
        map.addAttribute("cName", cName);
        return "customer/payrecordsave";
    }

    @GetMapping("appointment")
    @ApiOperation(value = "待预约客户列表")
    public String appointment(){return "customer/awaitappointlist";}

    @GetMapping("appointmentsave")
    @ApiOperation(value = "新增预约客户")
    public String appointmentsave(@ApiParam(name = "clId", value = "线索编号", required = true) Integer clId,
                                  @ApiParam(name = "cName", value = "客户名称", required = true) String cName,
                                  @ApiParam(name = "atType", value = "预约类型", required = true) String atType,
                                  ModelMap map){
        map.addAttribute("clId", clId);
        map.addAttribute("cName", cName);
        map.addAttribute("atType", atType);
        return "appointment/appointmentsave";
    }

    @GetMapping("contact")
    @ApiOperation(value = "待联系客户列表")
    public String contact(){return "customer/awaitcontactlist";}

    @GetMapping("reroute")
    @ApiOperation(value = "改约客户列表")
    public String reroute(){return "customer/reroutelist";}

    @GetMapping("referral")
    @ApiOperation(value = "转诊客户列表")
    public String referral(){return "customer/referrallist";}

    @GetMapping("goEditPwd")
    @ApiOperation(value = "修改密码")
    public String goEditPwd(){return "user/editPassword";}

    @GetMapping("indexGoSuccessSave")
    @ApiOperation(value = "从首页去新增成交页面")
    public String indexGoSuccessSave(){return "success/indexGoSuccessSave";}

    @GetMapping("indexGoPayrecordSave")
    @ApiOperation(value = "从首页去客户退款页面")
    public String indexGoPayrecordSave(){return "customer/indexGoPayrecordSave";}

    @GetMapping("indexGoAppointSave")
    @ApiOperation(value = "从首页去新增预约页面")
    public String indexGoAppointSave(){return "appointment/indexGoAppointSave";}

    @GetMapping("business")
    @ApiOperation(value = "业务概览")
    public String business(){
        return "dataStatistics/business";
    }

    @GetMapping("paydetail")
    @ApiOperation(value = "付款详情")
    public String paydetail(){
        return "dataStatistics/paydetail";
    }

}
