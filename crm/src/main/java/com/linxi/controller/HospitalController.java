package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.Customer;
import com.linxi.entity.Hospital;
import com.linxi.service.IHospitalService;
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
 * @create 2020/8/22 14:40
 */
@Controller
@RequestMapping("hospital")
@Api(value = "门诊控制类", tags = "门诊控制类")
public class HospitalController {

    @Autowired
    private IHospitalService iHospitalService;

    @GetMapping("queryHospital")
    @ApiOperation(value = "查询门诊")
    @ResponseBody
    public DataResult queryHospital(){
        List<Hospital> hospitals = iHospitalService.queryHospital();
        return DataResult.success(hospitals);
    }

    @GetMapping("queryHPage")
    @ApiOperation(value = "查询门诊")
    @ResponseBody
    public DataResult queryHPage(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                     @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
        List<Hospital> hospitals = iHospitalService.queryHPage((page - 1) * limit, limit);
        Integer total = iHospitalService.getTotal();
        return DataResult.success(total, hospitals);
    }

    @NoRepeatSubmit
    @PostMapping("saveHospital")
    @ApiOperation(value = "新增门诊")
    @ResponseBody
    public DataResult saveHospital(@ApiParam(value = "门诊名称", required = true) String hName){
        iHospitalService.saveHospital(hName);
        return DataResult.success();
    }

    @NoRepeatSubmit
    @GetMapping("delHByHId")
    @ApiOperation(value = "根据编号删除门诊")
    @ResponseBody
    public DataResult delHByHId(@ApiParam(value = "编号", required = true) Integer hId){
        iHospitalService.delHByHId(hId);
        return DataResult.success();
    }

    @GetMapping("queryHByHId")
    @ApiOperation(value = "根据编号查询门诊")
    public String queryHByHId(@ApiParam(value = "编号", required = true) Integer hId, ModelMap map){
        Hospital hospital = iHospitalService.queryHByHId(hId);
        map.addAttribute("hospital", hospital);
        return "hospital/hospitaledit";
    }

    @NoRepeatSubmit
    @PostMapping("editHByHId")
    @ApiOperation(value = "根据编号编辑门诊")
    @ResponseBody
    public DataResult editHByHId(@ApiParam(value = "编号", required = true) Integer hId,
                                      @ApiParam(value = "门诊名称", required = true) String hName){
        Hospital hospital = new Hospital(hId, hName);
        iHospitalService.editHByHId(hospital);
        return DataResult.success();
    }

}
