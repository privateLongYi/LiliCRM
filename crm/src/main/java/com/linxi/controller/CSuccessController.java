package com.linxi.controller;

import com.linxi.entity.CSuccess;
import com.linxi.service.ICSuccessService;
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
 * @create 2020/8/2 19:59
 */
@Controller
@RequestMapping("success")
@Api(value = "客户成交控制类", tags = "客户成交控制类")
public class CSuccessController {

    @Autowired
    private ICSuccessService iCSuccessService;

    @GetMapping("queryCS")
    @ApiOperation(value = "查询客户成交")
    @ResponseBody
    public DataResult queryCS(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                   @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
        List<CSuccess> CSuccesses = iCSuccessService.queryCS((page-1)*limit, limit);
        //获取总条数
        Integer total = iCSuccessService.getTotal();
        return new DataResult(0, "操作成功", total, CSuccesses);
    }

    @PostMapping("saveCSuccess")
    @ApiOperation(value = "新增客户成交")
    @ResponseBody
    public DataResult saveCSuccess(@RequestBody @ApiParam(value = "客户成交对象", required = true) CSuccess cs){
        iCSuccessService.saveCSuccess(cs);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("delCSByCsId")
    @ApiOperation(value = "删除客户成交")
    @ResponseBody
    public DataResult delCSByCsId(@ApiParam(value = "客户编号", required = true) Integer csId){
        iCSuccessService.delCSByCsId(csId);
        return new DataResult(0, "删除成功");
    }

    @GetMapping("queryCSByCsId")
    @ApiOperation(value = "查询客户成交")
    public String queryCSByCsId(@ApiParam(value = "客户编号", required = true) Integer csId, ModelMap map){
        CSuccess cs = iCSuccessService.queryCSByCsId(csId);
        map.addAttribute("cs", cs);
        return "CSuccess/CSuccessedit";
    }

    @PostMapping("editCSByCsId")
    @ApiOperation(value = "编辑客户成交")
    @ResponseBody
    public DataResult editCSByCsId(@RequestBody @ApiParam(value = "客户编号", required = true) CSuccess cs){
        iCSuccessService.editCSByCsId(cs);
        return new DataResult(0, "编辑成功");
    }

    @GetMapping("queryCSByCsCId")
    @ApiOperation(value = "查询客户成交")
    @ResponseBody
    public DataResult queryCSByCsCId(@ApiParam(value = "客户编号", required = true) Integer csCId,
                                     @ApiParam(value = "页码", required = true) Integer page,
                                     @ApiParam(value = "显示条数", required = true) Integer limit){
        List<CSuccess> cSuccesses = iCSuccessService.queryCSByCsCId(csCId, (page - 1) * limit, limit);
        Integer total = iCSuccessService.getTotalByCsCId(csCId);
        return new DataResult(0, "操作成功", total, cSuccesses);
    }

}
