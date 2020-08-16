package com.linxi.controller;

import com.linxi.entity.CTransaction;
import com.linxi.service.ICTransactionService;
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
 * @create 2020/8/2 19:08
 */
@Controller
@RequestMapping("transaction")
@Api(value = "客户预约控制类", tags = "客户预约控制类")
public class CTransactionController {

    @Autowired
    private ICTransactionService iCTransactionService;

    @GetMapping("queryCTScreen")
    @ApiOperation(value = "查询客户预约")
    @ResponseBody
    public DataResult queryCTScreen(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                  @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                  @ApiParam(name = "cName", value = "客户姓名", required = true) String cName,
                                  @ApiParam(name = "cTel", value = "客户电话", required = true) String cTel,
                                  @ApiParam(name = "cProject", value = "报名项目", required = true) String cProject,
                                  @ApiParam(name = "ctHospital", value = "预约门诊", required = true) String ctHospital,
                                  @ApiParam(name = "cEarnest", value = "是否交定金", required = true) Integer cEarnest,
                                  @ApiParam(name = "beginTime", value = "开始时间", required = true) String beginTime,
                                  @ApiParam(name = "endTime", value = "结束时间", required = true) String endTime,
                                  @ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                  @ApiParam(name = "cSource", value = "客户来源", required = true) String cSource,
                                  @ApiParam(name = "cStatu", value = "客户状态", required = true) String cStatu){
        List<CTransaction> CTransactiones = iCTransactionService.queryCTScreen((page-1)*limit, limit, cName, cTel, cProject, ctHospital, cEarnest, beginTime, endTime, uId, cSource, cStatu);
        //获取总条数
        Integer total = iCTransactionService.getTotal();
        return new DataResult(0, "操作成功", total, CTransactiones);
    }

    @PostMapping("saveCTransaction")
    @ApiOperation(value = "新增客户预约")
    @ResponseBody
    public DataResult saveCTransaction(@RequestBody @ApiParam(value = "客户预约对象", required = true) CTransaction ct){
        iCTransactionService.saveCTransaction(ct);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("delCTByCtId")
    @ApiOperation(value = "删除客户预约")
    @ResponseBody
    public DataResult delCTByCtId(@ApiParam(value = "客户编号", required = true) Integer cId){
        iCTransactionService.delCTByCtId(cId);
        return new DataResult(0, "删除成功");
    }

    @GetMapping("queryCTByCtId")
    @ApiOperation(value = "查询客户预约")
    public String queryCTByCtId(@ApiParam(value = "客户编号", required = true) Integer cId, ModelMap map){
        CTransaction ct = iCTransactionService.queryCTByCtId(cId);
        map.addAttribute("ct", ct);
        return "CTransaction/CTransactionedit";
    }

    @PostMapping("editCTByCtId")
    @ApiOperation(value = "编辑客户预约")
    @ResponseBody
    public DataResult editCTByCtId(@RequestBody @ApiParam(value = "客户编号", required = true) CTransaction ct){
        iCTransactionService.editCTByCtId(ct);
        return new DataResult(0, "编辑成功");
    }

    @GetMapping("goTransfer")
    @ApiOperation(value = "成交，去新增客户成交页面")
    public String suceess(@ApiParam(value = "客户编号", required = true) Integer ctCId,
                          @ApiParam(value = "预约门诊", required = true) String ctHospital,
                          ModelMap map){
        map.addAttribute("ctCId", ctCId);
        map.addAttribute("ctHospital", ctHospital);
        return "transaction/transfer";
    }

    @GetMapping("goReferral")
    @ApiOperation(value = "转诊，去新增转诊记录页面")
    public String referral(@ApiParam(value = "客户编号", required = true) Integer ctCId,
                          @ApiParam(value = "预约门诊", required = true) String ctHospital,
                          ModelMap map){
        map.addAttribute("ctCId", ctCId);
        map.addAttribute("ctHospital", ctHospital);
        return "transaction/referral";
    }

    @GetMapping("queryCTByCtCId")
    @ApiOperation(value = "查询客户预约")
    @ResponseBody
    public DataResult queryCTByCtCId(@ApiParam(value = "客户编号", required = true) Integer ctCId,
                                     @ApiParam(value = "页码", required = true) Integer page,
                                     @ApiParam(value = "显示条数", required = true) Integer limit){
        List<CTransaction> cTransactions = iCTransactionService.queryCTByCtCId(ctCId, (page-1)*limit, limit);
        Integer total = iCTransactionService.getTotalByCtCId(ctCId);
        return new DataResult(0, "操作成功", total, cTransactions);
    }

}
