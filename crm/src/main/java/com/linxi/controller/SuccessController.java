package com.linxi.controller;

import com.linxi.entity.Operating;
import com.linxi.entity.Success;
import com.linxi.service.ICtypeService;
import com.linxi.service.ICustomerService;
import com.linxi.service.IOperatingService;
import com.linxi.service.ISuccessService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/3 20:14
 */
@Controller
@RequestMapping("success")
@Api(value = "成交客户控制类", tags = "成交客户控制类")
public class SuccessController {

    @Autowired
    private ISuccessService iSuccessService;

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("querySBySCId")
    @ApiOperation(value = "根据客户编号查询成交客户")
    @ResponseBody
    public DataResult querySBySCId(@ApiParam(value = "客户编号", required = true) Integer sCId){
        List<Success> successes = iSuccessService.querySBySCId(sCId);
        Integer total = iSuccessService.getTotalBySCId(sCId);
        return new DataResult(0, "操作成功", total, successes);
    }

    @GetMapping("delSBySId")
    @ApiOperation(value = "根据成交客户编号删除成交客户")
    @ResponseBody
    public DataResult delSBySId(@ApiParam(value = "成交客户编号", required = true) Integer sId){
        iSuccessService.delSBySId(sId);
        return new DataResult(0, "操作成功");
    }

    @GetMapping("querySBySId")
    @ApiOperation(value = "根据成交客户编号查询成交客户")
    public String querySBySCId(@ApiParam(value = "成交客户编号", required = true) Integer sId, ModelMap map){
        Success success = iSuccessService.querySBySId(sId);
        map.addAttribute("s", success);
        return "success/successedit";
    }

    @PostMapping("editSBySId")
    @ApiOperation(value = "根据成交客户编号编辑成交客户")
    @ResponseBody
    public DataResult querySBySCId(@ApiParam(value = "成交客户编号", required = true) Integer sId,
                                   @ApiParam(value = "门诊编号", required = true) Integer sHId,
                                   @ApiParam(value = "成交信息", required = true) String sMessage,
                                   @ApiParam(value = "总成交金额", required = true) Integer sSum,
                                   @ApiParam(value = "总付款金额", required = true) Integer sPaysum,
                                   @ApiParam(value = "成交备注", required = true) String sRemark){
        Success success = new Success(sId, null, sHId, sMessage, sSum, sPaysum, sRemark);
        iSuccessService.editSBySId(success);
        return new DataResult(0, "编辑成功");
    }

    @PostMapping("saveSuccess")
    @ApiOperation(value = "新增成交客户")
    @ResponseBody
    public DataResult saveSuccess(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                  @ApiParam(name = "sCId", value = "客户编号", required = true) Integer sCId,
                                  @ApiParam(name = "sHId", value = "门诊编号", required = true) Integer sHId,
                                  @ApiParam(name = "sMessage", value = "成交信息", required = true) String sMessage,
                                  @ApiParam(name = "sSum", value = "成交金额", required = true) Integer sSum,
                                  @ApiParam(name = "sPaysum", value = "支付金额", required = true) Integer sPaysum,
                                  @ApiParam(name = "sRemark", value = "备注", required = true) String sRemark){
        //添加操作记录
        Operating operating = new Operating(sCId, uId, "添加了成交客户");
        iOperatingService.addOperatingRecord(operating);
        //根据客户状态查询编号
        Integer cTypeId = iCtypeService.queryCtypeByCtType("成交");
        //改变客户状态为成交状态
        iCustomerService.editCTypeIdByCId(sCId, cTypeId);
        //新增成交客户
        Success success = new Success(null, sCId, sHId, sMessage, sSum, sPaysum, sRemark);
        iSuccessService.saveSuccess(success);
        return new DataResult(0, "新增成功");
    }

}
