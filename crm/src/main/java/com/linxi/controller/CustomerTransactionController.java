package com.linxi.controller;

import com.linxi.entity.Customertransaction;
import com.linxi.entity.Customertransfer;
import com.linxi.service.ICustomerTransactionService;
import com.linxi.service.ICustomersuccessService;
import com.linxi.service.ICustomertransferService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/7/31 21:21
 */
@Controller
@RequestMapping("transaction")
@Api(value = "预约客户控制类", tags = "预约客户控制类")
public class CustomerTransactionController {

    @Autowired
    private ICustomerTransactionService iCustomerTransactionService;

    @Autowired
    private ICustomertransferService iCustomertransferService;

    @GetMapping("customerlist")
    @ApiOperation(value = "查询预约客户")
    @ResponseBody
    public DataResult customerlist(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                              @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                              @ApiParam(name = "cName", value = "搜索id") String cName,
                              @ApiParam(name = "cUsp", value = "搜索名称") String cUsp){
        List<Customertransaction> customeres = iCustomerTransactionService.queryCTByCNameOrCusp((page-1)*limit, limit, cName, cUsp);
        //获取总条数
        Integer total = iCustomerTransactionService.getTotal();
        return new DataResult(0, "", total, customeres);
    }

    @PostMapping("saveCustomer")
    @ApiOperation(value = "新增预约客户")
    @ResponseBody
    public DataResult saveCustomer(@RequestBody @ApiParam(value = "预约客户对象", required = true) Customertransaction ct){
        iCustomerTransactionService.saveCustomer(ct);
        return new DataResult(0, "新增成功", 0, null);
    }

    @GetMapping("queryCustomerByCid")
    @ApiOperation(value = "根据编号查询预约客户")
    public String queryCustomerByCid(@ApiParam(name = "cid", value = "预约客户编号", required = true) Integer cid, ModelMap map){
        Customertransaction ct = iCustomerTransactionService.queryCustomerByCid(cid);
        map.addAttribute("ct",ct);
        return "customeredit";
    }

    @GetMapping("goDetail")
    @ApiOperation(value = "根据编号查询预约客户")
    public String goDetail(@ApiParam(name = "cid", value = "预约客户编号", required = true) Integer cid, ModelMap map){
        Customertransaction ct = iCustomerTransactionService.queryCustomerByCid(cid);
        map.addAttribute("ct",ct);
        return "customerdetail";
    }

    @PostMapping("editCustomerByCid")
    @ApiOperation(value = "编辑预约客户信息")
    @ResponseBody
    public DataResult editCustomerByCid(@RequestBody @ApiParam(value = "预约客户对象", required = true) Customertransaction ct){
        iCustomerTransactionService.editCustomerByCid(ct);
        return new DataResult(0, "编辑成功", 0, null);
    }

    /**
     * 带着数据去新增成交客户界面
     * @param cid
     * @return
     */
    @GetMapping("editTransaction")
    @ApiOperation(value = "成交")
    public String editTransaction(@ApiParam(value = "预约客户编号", required = true) Integer cid,
                                  ModelMap map){
        Customertransaction ct = iCustomerTransactionService.queryCustomerByCid(cid);
        map.addAttribute("ct", ct);
        return "successsave";
    }

    @GetMapping("delCustomerByCid")
    @ApiOperation(value = "删除预约客户")
    public String delCustomerByCid(@ApiParam(value = "预约客户编号", required = true) Integer cid){
        iCustomerTransactionService.delCustomerByCid(cid);
        return "redirect:../customerlist";
    }

    @GetMapping("goTransfer")
    @ApiOperation(value = "去转诊界面")
    public String goTransfer(@ApiParam(value = "预约客户编号", required = true) Integer cid, ModelMap map){
        Customertransfer ct = iCustomertransferService.queryTransferByCtcid(cid);
        map.addAttribute("ct", ct);
        if (ct != null){
            return "transferedit";
        } else {
            Customertransaction c = iCustomerTransactionService.queryCustomerByCid(cid);
            map.addAttribute("c", c);
            return "transfersave";
        }
    }

}
