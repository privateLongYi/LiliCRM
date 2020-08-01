package com.linxi.controller;

import com.linxi.entity.Customertransaction;
import com.linxi.entity.Customertransfer;
import com.linxi.service.ICustomerTransactionService;
import com.linxi.service.ICustomertransferService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LongYi
 * @create 2020/8/1 16:29
 */
@Controller
@RequestMapping("transfer")
@Api(value = "转诊记录控制类", tags = "转诊记录控制类")
public class CustomerTransferController {

    @Autowired
    private ICustomertransferService iCustomertransferService;

    @Autowired
    private ICustomerTransactionService iCustomerTransactionService;

    @PostMapping("saveTransfer")
    @ApiOperation(value = "新增转诊记录")
    @ResponseBody
    public DataResult saveTransfer(@RequestBody @ApiParam(value = "转诊记录对象", required = true) Customertransfer ct){
        //新增转诊记录
        iCustomertransferService.saveTransfer(ct);
        //创建空对象并给预约门诊赋值
        Customertransaction c = new Customertransaction();
        c.setChospital(ct.getCtnewhospital());
        c.setCid(ct.getCtcid());
        System.out.println(c.getCid()+"====="+c.getChospital());
        //修改预约客户对象的预约门诊
        iCustomerTransactionService.editCustomerByCid(c);
        return new DataResult(0, "新增成功", 0, null);
    }

    @PostMapping("editTransferByCtid")
    @ApiOperation(value = "编辑转诊记录")
    @ResponseBody
    public DataResult editTransferByCtid(@RequestBody @ApiParam(value = "转诊记录对象", required = true) Customertransfer ct){
        //创建空对象并给预约门诊赋值
        Customertransaction c = new Customertransaction();
        c.setChospital(ct.getCtnewhospital());
        c.setCid(ct.getCtcid());
        System.out.println(c.getCid()+"====="+c.getChospital());
        //修改预约客户对象的预约门诊
        iCustomerTransactionService.editCustomerByCid(c);
        //修改客户转诊表
        iCustomertransferService.editTransferByCtid(ct);
        return new DataResult(0, "编辑成功", 0, null);
    }

}
