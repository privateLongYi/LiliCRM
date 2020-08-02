package com.linxi.controller;

import com.linxi.entity.CReferral;
import com.linxi.service.ICReferralService;
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
 * @create 2020/8/2 20:34
 */
@Controller
@RequestMapping("referral")
@Api(value = "转诊记录控制类", tags = "转诊记录控制类")
public class CReferralController {

    @Autowired
    private ICReferralService iCReferralService;

    @GetMapping("queryCR")
    @ApiOperation(value = "查询转诊记录")
    @ResponseBody
    public DataResult queryCR(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                              @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
        List<CReferral> CReferrales = iCReferralService.queryCR((page-1)*limit, limit);
        //获取总条数
        Integer total = iCReferralService.getTotal();
        return new DataResult(0, "操作成功", total, CReferrales);
    }

    @PostMapping("saveCReferral")
    @ApiOperation(value = "新增转诊记录")
    @ResponseBody
    public DataResult saveCReferral(@RequestBody @ApiParam(value = "转诊记录对象", required = true) CReferral cr){
        iCReferralService.saveCReferral(cr);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("delCRByCrId")
    @ApiOperation(value = "删除转诊记录")
    @ResponseBody
    public DataResult delCRByCrId(@ApiParam(value = "客户编号", required = true) Integer csId){
        iCReferralService.delCRByCrId(csId);
        return new DataResult(0, "删除成功");
    }

    @GetMapping("queryCRByCrId")
    @ApiOperation(value = "查询转诊记录")
    public String queryCRByCrId(@ApiParam(value = "客户编号", required = true) Integer crId, ModelMap map){
        CReferral cr = iCReferralService.queryCRByCrId(crId);
        map.addAttribute("cr", cr);
        return "CReferral/CReferraledit";
    }

    @PostMapping("editCRByCrId")
    @ApiOperation(value = "编辑转诊记录")
    @ResponseBody
    public DataResult editCRByCrId(@RequestBody @ApiParam(value = "客户编号", required = true) CReferral cr){
        iCReferralService.editCRByCrId(cr);
        return new DataResult(0, "编辑成功");
    }

    @GetMapping("queryCRByCrCId")
    @ApiOperation(value = "查询客户成交")
    @ResponseBody
    public DataResult queryCRByCrCId(@ApiParam(value = "客户编号", required = true) Integer crCId,
                                     @ApiParam(value = "页码", required = true) Integer page,
                                     @ApiParam(value = "显示条数", required = true) Integer limit){
        List<CReferral> cReferrals = iCReferralService.queryCRByCrCId(crCId, (page - 1) * limit, limit);
        Integer total = iCReferralService.getTotalByCrCId(crCId);
        return new DataResult(0, "操作成功", total, cReferrals);
    }

}

