package com.linxi.controller;

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
    public DataResult queryCByCId(){
        List<Hospital> hospitals = iHospitalService.queryHospital();
        return new DataResult(0, "操作成功", 0, hospitals);
    }

}
