package com.linxi.controller;

import com.linxi.entity.Atype;
import com.linxi.service.IAtypeService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/2 19:24
 */
@Controller
@RequestMapping("atype")
@Api(value = "预约类型控制类", tags = "预约类型控制类")
public class AtypeController {

    @Autowired
    private IAtypeService iAtypeService;

    @GetMapping("queryAtype")
    @ApiOperation(value = "根据客户编号查询客户预约")
    @ResponseBody
    public DataResult queryAtype(){
        List<Atype> atypes = iAtypeService.queryAtype();
        return new DataResult(0, "操作成功", 0, atypes);
    }

}
