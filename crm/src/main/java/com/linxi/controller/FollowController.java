package com.linxi.controller;

import com.linxi.entity.Follow;
import com.linxi.service.IFollowService;
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
 * @create 2020/9/5 15:48
 */
@Controller
@RequestMapping("follow")
@Api(value = "客户跟进控制类", tags = "客户跟进控制类")
public class FollowController {

    @Autowired
    private IFollowService iFollowService;

    @GetMapping("queryFByFCId")
    @ApiOperation(value = "根据客户编号查询客户跟进记录")
    @ResponseBody
    public DataResult queryFByFCId(@ApiParam(value = "客户编号", required = true) Integer fCId){
        List<Follow> follows = iFollowService.queryFByFCId(fCId);
        return new DataResult(0, "操作成功", 0, follows);
    }

}
