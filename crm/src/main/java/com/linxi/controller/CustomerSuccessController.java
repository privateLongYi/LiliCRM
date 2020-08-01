package com.linxi.controller;

import com.linxi.entity.Customersuccess;
import com.linxi.entity.Customertransaction;
import com.linxi.service.ICustomerTransactionService;
import com.linxi.service.ICustomersuccessService;
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
 * @create 2020/8/1 15:20
 */
@Controller
@RequestMapping("success")
@Api(value = "成交客户控制类", tags = "成交客户控制类")
public class CustomerSuccessController {

    @Autowired
    private ICustomerTransactionService iCustomerTransactionService;

    @Autowired
    private ICustomersuccessService iCustomersuccessService;

    @PostMapping("transaction")
    @ApiOperation(value = "成交")
    @ResponseBody
    public DataResult transaction(@RequestBody @ApiParam(value = "成交客户对象", required = true)Customersuccess csu){
        iCustomerTransactionService.editTransaction(csu.getCsucid());
        iCustomersuccessService.saveSuccess(csu);
        return new DataResult(0, "成交成功", 0, null);
    }


}
