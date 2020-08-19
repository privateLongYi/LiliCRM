package com.linxi.controller;

import com.linxi.entity.CFail;
import com.linxi.service.ICFailService;
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
 * @create 2020/8/8 11:06
 */
@Controller
@RequestMapping("fail")
@Api(value = "客户未成交控制类", tags = "客户未成交控制类")
public class CFailController {

    @Autowired
    private ICFailService iCFailService;

    @GetMapping("queryCFScreen")
    @ApiOperation(value = "查询客户未成交")
    @ResponseBody
    public DataResult queryCFScreen(@ApiParam(name = "page", value = "页码", required = true) Integer page,
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
        List<CFail> CFailes = iCFailService.queryCFScreen((page-1)*limit, limit, cName, cTel, cProject, ctHospital, cEarnest, beginTime, endTime, uId, cSource, cStatu);
        //获取总条数
        Integer total = iCFailService.getTotal();
        return new DataResult(0, "操作成功", total, CFailes);
    }

    @PostMapping("saveCFail")
    @ApiOperation(value = "新增客户未成交")
    @ResponseBody
    public DataResult saveCFail(@RequestBody @ApiParam(value = "客户未成交对象", required = true) CFail cf){
        iCFailService.saveCFail(cf);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("delCFByCfId")
    @ApiOperation(value = "删除客户未成交")
    @ResponseBody
    public DataResult delCFByCfId(@ApiParam(value = "未成交编号", required = true) Integer cfId){
        iCFailService.delCFByCfId(cfId);
        return new DataResult(0, "删除成功");
    }

    @GetMapping("queryCFByCfId")
    @ApiOperation(value = "查询客户未成交")
    public String queryCFByCfId(@ApiParam(value = "未成交编号", required = true) Integer cfId, ModelMap map){
        CFail cf = iCFailService.queryCFByCfId(cfId);
        map.addAttribute("cf", cf);
        return "CFail/CFailedit";
    }

    @PostMapping("editCFByCfId")
    @ApiOperation(value = "编辑客户未成交")
    @ResponseBody
    public DataResult editCFByCfId(@RequestBody @ApiParam(value = "未成交编号", required = true) CFail cf){
        iCFailService.editCFByCfId(cf);
        return new DataResult(0, "编辑成功");
    }

}
