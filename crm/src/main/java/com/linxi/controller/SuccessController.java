package com.linxi.controller;

import com.linxi.entity.Success;
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
        Success success = new Success(sId, sHId, sMessage, sSum, sPaysum, sRemark);
        iSuccessService.editSBySId(success);
        return new DataResult(0, "编辑成功");
    }

}
