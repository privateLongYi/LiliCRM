package com.linxi.controller;

import com.linxi.entity.*;
import com.linxi.service.*;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LongYi
 * @create 2020/8/2 14:19
 */
@Controller
@RequestMapping("customer")
@Api(value = "客户信息控制类", tags = "客户信息控制类")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private IAppointmentService iAppointmentService;

    @Autowired
    private ISuccessService iSuccessService;

    @Autowired
    private IFollowService iFollowService;

    @GetMapping("queryCScreen")
    @ApiOperation(value = "查询客户信息")
    @ResponseBody
    public DataResult queryCScreen(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                   @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                   @ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                   @ApiParam(name = "rName", value = "角色名称", required = true) String rName,
                                   @ApiParam(name = "cName", value = "姓名", required = false) String cName,
                                   @ApiParam(name = "cTel", value = "电话", required = false) String cTel,
                                   @ApiParam(name = "cProject", value = "报名项目", required = false) String cProject,
                                   @ApiParam(name = "cEarnest", value = "是否交定金", required = false) Integer cEarnest,
                                   @ApiParam(name = "cUId", value = "负责人编号", required = false) Integer cUId,
                                   @ApiParam(name = "cSource", value = "来源", required = false) String cSource,
                                   @ApiParam(name = "cTypeId", value = "客户状态编号", required = false) Integer cTypeId,
                                   @ApiParam(name = "ctType", value = "客户状态", required = false) String ctType,
                                   @ApiParam(name = "beginTime", value = "开始时间", required = false) String beginTime,
                                   @ApiParam(name = "endTime", value = "结束时间", required = false) String endTime){
        if (cTypeId == null && ctType != null){
            //根据客户状态查询编号
            cTypeId = iCtypeService.queryCtypeByCtType(ctType);
        }
        //根据筛选条件查询客户
        List<Customer> customeres = iCustomerService.queryCScreen(uId, rName, (page - 1) * limit, limit, cName, cTel, cProject, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
        //获取总条数
        Integer total = iCustomerService.getTotalByScreen(uId, rName, cName, cTel, cProject, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
        return new DataResult(0, "操作成功", total, customeres);
    }

    @PostMapping("saveCustomer")
    @ApiOperation(value = "新增客户信息")
    @ResponseBody
    public DataResult saveCustomer(@ApiParam(name = "uId", value = "操作用户编号", required = true) Integer uId,
                                   @ApiParam(name = "cName", value = "姓名", required = true) String cName,
                                   @ApiParam(name = "cSex", value = "性别", required = true) String cSex,
                                   @ApiParam(name = "cAge", value = "年龄", required = false) Integer cAge,
                                   @ApiParam(name = "cTel", value = "电话", required = true) String cTel,
                                   @ApiParam(name = "cProject", value = "项目", required = true) String cProject,
                                   @ApiParam(name = "cEarnest", value = "定金", required = false) Integer cEarnest,
                                   @ApiParam(name = "cUId", value = "用户编号", required = true) Integer cUId,
                                   @ApiParam(name = "cSource", value = "来源", required = false) String cSource,
                                   @ApiParam(name = "cTypeId", value = "状态编号", required = true) Integer cTypeId,
                                   @ApiParam(name = "cRemark", value = "备注", required = false) String cRemark){
        Customer c = new Customer(null, cName, cSex, cAge, cTel, cProject, null, cRemark, cEarnest, cUId, cSource, null, cTypeId);
        iCustomerService.saveCustomer(c);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("delCByCId")
    @ApiOperation(value = "删除客户信息")
    @ResponseBody
    public DataResult delCByCId(@ApiParam(value = "客户编号", required = true) Integer cId,
                                @ApiParam(value = "客户名称", required = true) String cName,
                                @ApiParam(value = "用户编号", required = true) Integer uId){
        //删除
        iCustomerService.delCByCId(cId);
        //新增操作记录
        Operating operating = new Operating(cId, uId, cName);
        iOperatingService.addOperatingRecord(operating);
        return new DataResult(0, "删除成功");
    }

    @GetMapping("queryCByCId")
    @ApiOperation(value = "查询客户信息")
    public String queryCByCId(@ApiParam(value = "客户编号", required = true) Integer cId,
                              @ApiParam(value = "页面", required = true) String page,
                              ModelMap map){
        Customer c = iCustomerService.queryCByCId(cId);
        map.addAttribute("c", c);
        map.addAttribute("page", page);
        return "customer/customeredit";
    }

    @PostMapping("editCByCId")
    @ApiOperation(value = "编辑客户信息")
    @ResponseBody
    public DataResult editCByCId(@ApiParam(name = "uId", value = "操作用户编号", required = true) Integer uId,
                                 @ApiParam(name = "cId", value = "编号", required = true) Integer cId,
                                 @ApiParam(name = "cName", value = "姓名", required = true) String cName,
                                 @ApiParam(name = "cSex", value = "性别", required = true) String cSex,
                                 @ApiParam(name = "cAge", value = "年龄", required = false) Integer cAge,
                                 @ApiParam(name = "cTel", value = "电话", required = true) String cTel,
                                 @ApiParam(name = "cProject", value = "项目", required = true) String cProject,
                                 @ApiParam(name = "cEarnest", value = "定金", required = false) Integer cEarnest,
                                 @ApiParam(name = "cUId", value = "用户编号", required = false) Integer cUId,
                                 @ApiParam(name = "cSource", value = "来源", required = false) String cSource,
                                 @ApiParam(name = "cTypeId", value = "状态", required = true) Integer cTypeId,
                                 @ApiParam(name = "cRemark", value = "备注", required = false) String cRemark,
                                 @ApiParam(name = "cMessage", value = "症状信息", required = false) String cMessage){
        //创建客户
        Customer c = new Customer(cId, cName, cSex, cAge, cTel, cProject, null, cRemark, cEarnest, cUId, cSource, cMessage, cTypeId);
        //编辑客户
        iCustomerService.editCByCId(c);
        //新增操作记录
        Operating operating = new Operating(cId, uId, cName);
        iOperatingService.addOperatingRecord(operating);
        return new DataResult(0, "编辑成功");
    }

    @GetMapping("detail")
    @ApiOperation(value = "查询客户详情")
    @ResponseBody
    public Map<String, Object> detail(@ApiParam(value = "客户编号", required = true) Integer cId){
        //声明集合
        Map<String, Object> map = new HashMap<String, Object>();
        //根据客户编号查询客户并加入集合
        Customer c = iCustomerService.queryCByCId(cId);
        map.put("customer", c);
        //根据客户编号查询最近预约门诊
        String hName = iAppointmentService.queryLastHNameByCId(cId);
        if (hName == null){
            map.put("hName", "");
        } else {
            map.put("hName", hName);
        }
        //根据客户编号查询成交金额
        Integer successMoney = iSuccessService.queryTotalMoneyByCId(cId, 0);
        if (successMoney == null){
            map.put("successMoney", 0);
        } else {
            map.put("successMoney", successMoney);
        }
        //根据客户编号查询已交金额
        Integer payMoney = iSuccessService.queryTotalMoneyByCId(cId, 1);
        if (successMoney == null){
            map.put("payMoney", 0);
        } else {
            map.put("payMoney", payMoney);
        }
        //待交金额
        if (successMoney != null && payMoney != null){
            map.put("waitMoney", successMoney-payMoney);
        } else {
            map.put("waitMoney", 0);
        }
        //最后修改时间
        String s = iOperatingService.queryOpTimeByOpCId(cId);
        if (s == null){
            map.put("updateTime", "");
        } else {
            map.put("updateTime", s);
        }
        return map;
    }

    @GetMapping("editCTypeIdByCId")
    @ApiOperation(value = "编辑客户状态")
    @ResponseBody
    public DataResult editCTypeIdByCId(@ApiParam(value = "编号", required = true) Integer cId,
                                       @ApiParam(value = "客户状态", required = true) String cType){
        //根据客户状态查询编号
        Integer cTypeId = iCtypeService.queryCtypeByCtType(cType);
        //编辑客户状态
        iCustomerService.editCTypeIdByCId(cId, cTypeId);
        return new DataResult(0, "操作成功");
    }

    @GetMapping("getTotalCByUIdAndCTypeId")
    @ApiOperation(value = "根据用户编号和客户状态查询客户总条数")
    @ResponseBody
    public Integer getTotalCByUIdAndCTypeId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                            @ApiParam(value = "客户状态", required = true) String ctType){
        //根据客户状态查询编号
        Integer cTypeId = iCtypeService.queryCtypeByCtType(ctType);
        //根据用户编号和客户状态查询客户总条数
        Integer total = iCustomerService.getTotalCByUIdAndCTypeId(uId, cTypeId);
        return total;
    }

    @PostMapping("queryCByCNameOrCTel")
    @ApiOperation(value = "根据客户名称或者客户电话查询客户")
    @ResponseBody
    public DataResult queryCByCNameOrCTel(@ApiParam(value = "角色名称", required = true) String rName,
                                          @ApiParam(value = "用户编号", required = true) Integer uId,
                                          @ApiParam(value = "关键字", required = true) String key){
        List<Customer> customers = iCustomerService.queryCByCNameOrCTel(rName, uId, key);
        return new DataResult(0, "操作成功", 0, customers);
    }

    @GetMapping("queryCAndHNameScreen")
    @ApiOperation(value = "查询客户信息")
    @ResponseBody
    public DataResult queryCAndHNameScreen(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                   @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                   @ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                   @ApiParam(name = "rName", value = "角色名称", required = true) String rName,
                                   @ApiParam(name = "cName", value = "姓名", required = false) String cName,
                                   @ApiParam(name = "cTel", value = "电话", required = false) String cTel,
                                   @ApiParam(name = "cProject", value = "报名项目", required = false) String cProject,
                                   @ApiParam(name = "cEarnest", value = "是否交定金", required = false) Integer cEarnest,
                                   @ApiParam(name = "cUId", value = "负责人编号", required = false) Integer cUId,
                                   @ApiParam(name = "cSource", value = "来源", required = false) String cSource,
                                   @ApiParam(name = "cTypeId", value = "客户状态编号", required = false) Integer cTypeId,
                                   @ApiParam(name = "ctType", value = "客户状态", required = false) String ctType,
                                   @ApiParam(name = "beginTime", value = "开始时间", required = false) String beginTime,
                                   @ApiParam(name = "endTime", value = "结束时间", required = false) String endTime){
        if (cTypeId == null && ctType != null){
            //根据客户状态查询编号
            cTypeId = iCtypeService.queryCtypeByCtType(ctType);
        }
        //根据筛选条件查询客户
        List<Customer> customeres = iCustomerService.queryCAndHNameScreen(uId, rName, (page - 1) * limit, limit, cName, cTel, cProject, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
        //获取总条数
        Integer total = iCustomerService.getTotalAndHNameByScreen(uId, rName, cName, cTel, cProject, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
        return new DataResult(0, "操作成功", total, customeres);
    }

    @PostMapping("queryCSCByUIdAndCName")
    @ApiOperation(value = "根据用户编号和客户名称查询可成交客户")
    @ResponseBody
    public DataResult queryCSCByUIdAndCName(@ApiParam(value = "角色名称", required = true) String rName,
                                           @ApiParam(value = "用户编号", required = true) Integer uId,
                                           @ApiParam(value = "客户名称", required = true) String cName){
        List<Customer> customers = iCustomerService.queryCSCByUIdAndCName(rName, uId, cName);
        return new DataResult(0, "操作成功", 0, customers);
    }

    @PostMapping("queryCACByUIdAndCName")
    @ApiOperation(value = "根据用户编号和客户名称查询可成交客户")
    @ResponseBody
    public DataResult queryCACByUIdAndCName(@ApiParam(value = "角色名称", required = true) String rName,
                                            @ApiParam(value = "用户编号", required = true) Integer uId,
                                            @ApiParam(value = "客户名称", required = true) String cName){
        List<Customer> customers = iCustomerService.queryCACByUIdAndCName(rName, uId, cName);
        return new DataResult(0, "操作成功", 0, customers);
    }

}
