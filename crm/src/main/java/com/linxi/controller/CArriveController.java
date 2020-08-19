package com.linxi.controller;

import com.linxi.entity.CArrive;
import com.linxi.service.ICArriveService;
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
 * @create 2020/8/8 11:12
 */
@Controller
@RequestMapping("arrive")
@Api(value = "客户未到店控制类", tags = "客户未到店控制类")
public class CArriveController {

    @Autowired
    private ICArriveService iCArriveService;

    @GetMapping("queryCAScreen")
    @ApiOperation(value = "查询客户未到店")
    @ResponseBody
    public DataResult queryCAScreen(@ApiParam(name = "page", value = "页码", required = true) Integer page,
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
        List<CArrive> CArrivees = iCArriveService.queryCAScreen((page-1)*limit, limit, cName, cTel, cProject, ctHospital, cEarnest, beginTime, endTime, uId, cSource, cStatu);
        //获取总条数
        Integer total = iCArriveService.getTotal();
        return new DataResult(0, "操作成功", total, CArrivees);
    }

    @PostMapping("saveCArrive")
    @ApiOperation(value = "新增客户未到店")
    @ResponseBody
    public DataResult saveCArrive(@RequestBody @ApiParam(value = "客户未到店对象", required = true) CArrive ca){
        iCArriveService.saveCArrive(ca);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("delCAByCaId")
    @ApiOperation(value = "删除客户未到店")
    @ResponseBody
    public DataResult delCAByCaId(@ApiParam(value = "未到店编号", required = true) Integer caId){
        iCArriveService.delCAByCaId(caId);
        return new DataResult(0, "删除成功");
    }

    @GetMapping("queryCAByCaId")
    @ApiOperation(value = "查询客户未到店")
    public String queryCAByCaId(@ApiParam(value = "未到店编号", required = true) Integer caId, ModelMap map){
        CArrive ca = iCArriveService.queryCAByCaId(caId);
        map.addAttribute("ca", ca);
        return "CArrive/CArriveedit";
    }

    @PostMapping("editCAByCaId")
    @ApiOperation(value = "编辑客户未到店")
    @ResponseBody
    public DataResult editCAByCaId(@RequestBody @ApiParam(value = "未到店编号", required = true) CArrive ca){
        iCArriveService.editCAByCaId(ca);
        return new DataResult(0, "编辑成功");
    }

}
