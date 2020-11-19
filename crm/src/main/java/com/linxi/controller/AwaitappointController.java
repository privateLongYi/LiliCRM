package com.linxi.controller;

import com.linxi.entity.Customer;
import com.linxi.service.ICtypeService;
import com.linxi.service.ICustomerService;
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
 * @create 2020/9/15 21:01
 */
@Controller
@RequestMapping("awaitappoint")
@Api(value = "待预约客户控制类", tags = "待预约客户控制类")
public class AwaitappointController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICtypeService iCtypeService;

}
