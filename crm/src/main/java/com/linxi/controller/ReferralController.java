package com.linxi.controller;

import com.linxi.entity.Operating;
import com.linxi.entity.Referral;
import com.linxi.service.IOperatingService;
import com.linxi.service.IReferralService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LongYi
 * @create 2020/9/13 17:46
 */
@Controller
@RequestMapping("referral")
@Api(value = "转诊记录控制类", tags = "转诊记录控制类")
public class ReferralController {

    @Autowired
    private IReferralService iReferralService;

    @Autowired
    private IOperatingService iOperatingService;

    @PostMapping("saveReferral")
    @ApiOperation(value = "新增转诊记录")
    @ResponseBody
    public DataResult saveReferral(@ApiParam(value = "用户编号", required = true) Integer uId,
                                   @ApiParam(value = "客户编号", required = true) Integer rCId,
                                   @ApiParam(value = "未成交门诊编号", required = true) Integer rFailHId,
                                   @ApiParam(value = "新预约门诊编号", required = true) Integer rHId,
                                   @ApiParam(value = "未成交信息", required = true) String rMessage,
                                   @ApiParam(value = "转诊原因", required = true) String rCause){
        //新增操作记录
        Operating operating = new Operating(rCId, uId, "新增了转诊记录");
        iOperatingService.addOperatingRecord(operating);
        //新增转诊记录
        Referral referral = new Referral(null, rCId, rFailHId, rHId, rMessage, rCause);
        iReferralService.saveReferral(referral);
        return new DataResult(0, "新增成功");
    }

}