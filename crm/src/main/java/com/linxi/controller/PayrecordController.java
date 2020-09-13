package com.linxi.controller;

import com.linxi.entity.Operating;
import com.linxi.entity.Payrecord;
import com.linxi.service.IOperatingService;
import com.linxi.service.IPayrecordService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/5 14:34
 */
@Controller
@RequestMapping("payrecord")
@Api(value = "支付记录控制类", tags = "支付记录控制类")
public class PayrecordController {

    @Autowired
    private IPayrecordService iPayrecordService;

    @Autowired
    private IOperatingService iOperatingService;

    @GetMapping("queryPByPaySId")
    @ApiOperation(value = "根据成交客户编号查询支付记录")
    @ResponseBody
    public DataResult queryPByPaySId(@ApiParam(value = "成交客户编号", required = true) Integer paySId){
        List<Payrecord> payrecords = iPayrecordService.queryPByPaySId(paySId);
        Integer total = iPayrecordService.getTotalByPaySId(paySId);
        return new DataResult(0, "操作成功", total, payrecords);
    }

    @PostMapping("savePayrecord")
    @ApiOperation(value = "新增支付记录")
    @ResponseBody
    public DataResult savePayrecord(@ApiParam(value = "用户编号", required = true) Integer uId,
                                    @ApiParam(value = "成交客户编号", required = true) Integer paySId,
                                    @ApiParam(value = "支付金额", required = true) Integer paySum,
                                    @ApiParam(value = "支付类型编号", required = true) Integer payTypeId){
        //新增操作记录
        Operating operating = new Operating(paySId, uId, "新增了支付记录");
        iOperatingService.addOperatingRecord(operating);
        //新增支付记录
        Payrecord payrecord = new Payrecord(null, paySId, paySum, null, payTypeId);
        iPayrecordService.savePayrecord(payrecord);
        return new DataResult(0, "新增成功");
    }

}
