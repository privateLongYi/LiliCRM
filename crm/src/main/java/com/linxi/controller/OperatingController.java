package com.linxi.controller;

import com.linxi.entity.Operating;
import com.linxi.service.IOperatingService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/5 16:39
 */
@Controller
@RequestMapping("operating")
@Api(value = "操作记录控制类", tags = "操作记录控制类")
public class OperatingController {

    @Autowired
    private IOperatingService iOperatingService;

    @GetMapping("queryOpByOpCId")
    @ApiOperation(value = "根据客户编号查询操作记录")
    @ResponseBody
    public DataResult queryOpByOpCId(@ApiParam(value = "客户编号", required = true) Integer opCId){
        List<Operating> operatings = iOperatingService.queryOpByOpCId(opCId);
        return new DataResult(0, "操作成功", 0, operatings);
    }

}
