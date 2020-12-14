package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.Customer;
import com.linxi.entity.Follow;
import com.linxi.entity.Operating;
import com.linxi.service.ICustomerService;
import com.linxi.service.IFollowService;
import com.linxi.service.IOperatingService;
import com.linxi.util.DataResult;
import com.linxi.vo.FollowVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private ICustomerService iCustomerService;

    @NoRepeatSubmit
    @PostMapping("saveFollow")
    @ApiOperation(value = "新增客户跟进")
    @ResponseBody
    public DataResult queryFByFCId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                   @ApiParam(value = "用户姓名", required = true) String uName,
                                   @ApiParam(value = "客户编号", required = true) Integer cId,
                                   @ApiParam(value = "线索编号", required = true) Integer fClId,
                                   @ApiParam(value = "负责人编号", required = true) Integer clUId,
                                   @ApiParam(value = "回访类型编号", required = true) Integer fTypeId,
                                   @ApiParam(value = "回访类型", required = true) String ftType,
                                   @ApiParam(value = "回访内容", required = true) String fContent,
                                   @ApiParam(value = "回访时间", required = true) String fTime){
        //根据客户编号查询客户
        Customer customer = iCustomerService.queryCByCId(cId);
        //新增操作记录
        Operating operating = new Operating(cId, uId, ftType, uName + "添加了" + customer.getcName() + "的" + ftType);
        iOperatingService.saveOperating(operating);
        //新增跟进记录
        Follow follow = new Follow(null, fClId, fTypeId, Timestamp.valueOf(fTime), fContent, clUId);
        iFollowService.saveFollow(follow);
        return DataResult.success();
    }

    @GetMapping("queryFollowByFClId")
    @ApiOperation(value = "根据线索编号查询跟进记录")
    @ResponseBody
    public DataResult queryFollowByFClId(@ApiParam(value = "线索编号", required = true) Integer clId){
        List<Follow> follows = iFollowService.queryFByFClId(clId);
        return DataResult.success(follows);
    }

}
