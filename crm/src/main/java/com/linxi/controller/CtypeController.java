package com.linxi.controller;

import com.linxi.entity.Ctype;
import com.linxi.entity.Hospital;
import com.linxi.mapper.CtypeMapper;
import com.linxi.service.ICtypeService;
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
 * @create 2020/8/22 14:47
 */
@Controller
@RequestMapping("ctype")
@Api(value = "客户状态控制类", tags = "客户状态控制类")
public class CtypeController {

    @Autowired
    private ICtypeService iCtypeService;

    @GetMapping("queryCtype")
    @ApiOperation(value = "查询客户状态")
    @ResponseBody
    public DataResult queryCtype(){
        List<Ctype> ctypes = iCtypeService.queryCtype();
        return new DataResult(0, "操作成功", 0, ctypes);
    }

}
