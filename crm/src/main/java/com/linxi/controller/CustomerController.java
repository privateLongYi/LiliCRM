package com.linxi.controller;

import com.linxi.entity.Customer;
import com.linxi.service.ICustomerService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("queryCByCNameAndCUId")
    @ApiOperation(value = "查询客户信息")
    @ResponseBody
    public DataResult customerlist(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                   @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                   @ApiParam(name = "cName", value = "客户姓名") String cName,
                                   @ApiParam(name = "cUId", value = "负责人编号") Integer cUId){
        List<Customer> customeres = iCustomerService.queryCByCNameAndCUId((page-1)*limit, limit, cName, cUId);
        //获取总条数
        Integer total = iCustomerService.getTotal();
        return new DataResult(0, "操作成功", total, customeres);
    }

    @PostMapping("saveCustomer")
    @ApiOperation(value = "新增客户信息")
    @ResponseBody
    public DataResult saveCustomer(@RequestBody @ApiParam(value = "客户信息对象", required = true) Customer c){
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
    public DataResult editCByCId(@RequestBody @ApiParam(value = "客户编号", required = true) Customer c){
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
