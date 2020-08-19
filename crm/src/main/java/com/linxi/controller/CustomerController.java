package com.linxi.controller;

import com.linxi.entity.Customer;
import com.linxi.service.ICustomerService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.standard.expression.Each;

import javax.jws.WebParam;
import java.util.List;

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

    @GetMapping("queryCScreen")
    @ApiOperation(value = "查询客户信息")
    @ResponseBody
    public DataResult queryCScreen(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                   @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                   @ApiParam(name = "param", value = "筛选条件", required = false) String param){
        //姓名
        String cName = null;
        //电话
        String cTel = null;
        //报名项目
        String cProject = null;
        //预约门诊
        String ctHospital = null;
        //是否交定金
        Integer cEarnest = null;
        //负责人编号
        Integer cUId = null;
        //来源
        String cSource = null;
        //状态
        String cStatu = null;
        //开始时间
        String beginTime = null;
        //结束时间
        String endTime = null;
        if (param != null && !param.equals("")) {
            //去掉参数中最后一个字符并且按逗号分隔
            param = param.substring(0, param.length() - 1);
            String[] split = param.split(",");
            //为参数赋值
            for (int i = 0; i < split.length; i++) {
                String[] screen = split[i].split(":");
                if (screen[0].trim().equals("cName")) {
                    cName = screen[1].trim();
                } else if (screen[0].trim().equals("cTel")) {
                    cTel = screen[1].trim();
                } else if (screen[0].trim().equals("cProject")) {
                    cProject = screen[1].trim();
                } else if (screen[0].trim().equals("ctHospital")) {
                    ctHospital = screen[1].trim();
                } else if (screen[0].trim().equals("cEarnest")) {
                    cEarnest = Integer.parseInt(screen[1].trim());
                } else if (screen[0].trim().equals("cUId")) {
                    cUId = Integer.parseInt(screen[1].trim());
                } else if (screen[0].trim().equals("cSource")) {
                    cSource = screen[1].trim();
                } else if (screen[0].trim().equals("cStatu")) {
                    cStatu = screen[1].trim();
                } else if (screen[0].trim().equals("beginTime")) {
                    beginTime = screen[1].trim();
                } else if (screen[0].trim().equals("endTime")) {
                    endTime = screen[1].trim();
                }
            }
        }
        //根据筛选条件查询客户
        List<Customer> customeres = iCustomerService.queryCScreen((page-1)*limit, limit, cName, cTel, cProject, ctHospital, cEarnest, beginTime, endTime, cUId, cSource, cStatu);
        //获取总条数
        Integer total = iCustomerService.getTotal();
        return new DataResult(0, "操作成功", total, customeres);
    }

    @PostMapping("saveCustomer")
    @ApiOperation(value = "新增客户信息")
    @ResponseBody
    public DataResult saveCustomer(@ApiParam(name = "cName", value = "姓名", required = true) String cName,
                                   @ApiParam(name = "cSex", value = "性别", required = true) String cSex,
                                   @ApiParam(name = "cAge", value = "年龄", required = false) Integer cAge,
                                   @ApiParam(name = "cTel", value = "电话", required = true) String cTel,
                                   @ApiParam(name = "cProject", value = "项目", required = true) String cProject,
                                   @ApiParam(name = "cEarnest", value = "定金", required = false) Integer cEarnest,
                                   @ApiParam(name = "cUId", value = "用户编号", required = true) Integer cUId,
                                   @ApiParam(name = "cSource", value = "来源", required = false) String cSource,
                                   @ApiParam(name = "cStatu", value = "状态", required = true) String cStatu,
                                   @ApiParam(name = "cRemark", value = "备注", required = false) String cRemark){
        Customer c = new Customer(null, cName, cSex, cAge, cTel, cProject, null, cRemark, cEarnest, cUId, cSource, null, null, cStatu);
        iCustomerService.saveCustomer(c);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("delCByCId")
    @ApiOperation(value = "删除客户信息")
    @ResponseBody
    public DataResult delCByCId(@ApiParam(value = "客户编号", required = true) Integer cId){
        iCustomerService.delCByCId(cId);
        return new DataResult(0, "删除成功");
    }

    @GetMapping("queryCByCId")
    @ApiOperation(value = "查询客户信息")
    public String queryCByCId(@ApiParam(value = "客户编号", required = true) Integer cId, ModelMap map){
        Customer c = iCustomerService.queryCByCId(cId);
        map.addAttribute("c", c);
        return "customer/customeredit";
    }

    @PostMapping("editCByCId")
    @ApiOperation(value = "编辑客户信息")
    @ResponseBody
    public DataResult editCByCId(@ApiParam(name = "cId", value = "编号", required = true) Integer cId,
                                 @ApiParam(name = "cName", value = "姓名", required = true) String cName,
                                 @ApiParam(name = "cSex", value = "性别", required = true) String cSex,
                                 @ApiParam(name = "cAge", value = "年龄", required = false) Integer cAge,
                                 @ApiParam(name = "cTel", value = "电话", required = true) String cTel,
                                 @ApiParam(name = "cProject", value = "项目", required = true) String cProject,
                                 @ApiParam(name = "cEarnest", value = "定金", required = false) Integer cEarnest,
                                 @ApiParam(name = "cUId", value = "用户编号", required = false) Integer cUId,
                                 @ApiParam(name = "cSource", value = "来源", required = false) String cSource,
                                 @ApiParam(name = "cStatu", value = "状态", required = true) String cStatu,
                                 @ApiParam(name = "cRemark", value = "备注", required = false) String cRemark,
                                 @ApiParam(name = "cMessage", value = "症状信息", required = false) String cMessage,
                                 @ApiParam(name = "cCallback", value = "回访", required = false) String cCallback){
        Customer c = new Customer(cId, cName, cSex, cAge, cTel, cProject, null, cRemark, cEarnest, cUId, cSource, cMessage, cCallback, cStatu);
        iCustomerService.editCByCId(c);
        return new DataResult(0, "编辑成功");
    }

    @GetMapping("goDetail")
    @ApiOperation(value = "去客户信息详情页面")
    public String editCByCId(@ApiParam(value = "客户编号", required = true) Integer cId, ModelMap map){
        Customer c = iCustomerService.queryCByCId(cId);
        map.addAttribute("c", c);
        return "customer/customerdetail";
    }

}
