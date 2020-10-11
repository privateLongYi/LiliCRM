package com.linxi.controller;

import com.linxi.entity.Follow;
import com.linxi.entity.Operating;
import com.linxi.service.IFollowService;
import com.linxi.service.IOperatingService;
import com.linxi.util.DataResult;
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

    @Autowired
    private IOperatingService iOperatingService;

    @PostMapping("saveFollow")
    @ApiOperation(value = "新增客户跟进")
    @ResponseBody
    public DataResult queryFByFCId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                   @ApiParam(value = "客户编号", required = true) Integer fCId,
                                   @ApiParam(value = "回访类型编号", required = true) Integer fTypeId,
                                   @ApiParam(value = "回访类型", required = true) String ftType,
                                   @ApiParam(value = "回访内容", required = true) String fContent){
        //新增操作记录
        Operating operating = new Operating(fCId, uId, "新增了"+ftType);
        iOperatingService.addOperatingRecord(operating);
        Follow follow = new Follow(null, fCId, fTypeId, null, fContent);
        iFollowService.saveFollow(follow);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("queryFtypeByFCId")
    @ApiOperation(value = "根据客户编号查询所拥有的跟进类型")
    @ResponseBody
    public List<String> queryFtypeByFCId(@ApiParam(value = "客户编号", required = true) Integer cId){
        ArrayList<String> strings = new ArrayList<>();
        List<Follow> follows = iFollowService.queryFtypeByFCId(cId);
        for (Follow f : follows){
            strings.add(f.getfType());
        }
        return strings;
    }

    @GetMapping("queryLastFTimeByFtypeAndFCId")
    @ApiOperation(value = "根据跟进类型和客户编号查询最后一次跟进时间")
    @ResponseBody
    public String queryLastFTimeByFtype(@ApiParam(value = "客户编号", required = true) Integer cId,
                                           @ApiParam(value = "跟进类型", required = true) String ftType){
        return iFollowService.queryLastFTimeByFtypeAndFCId(cId, ftType);
    }

    @GetMapping("queryFByFtypeAndFCId")
    @ApiOperation(value = "根据客户编号查询客户跟进")
    @ResponseBody
    public DataResult queryFByFCId(@ApiParam(value = "客户编号", required = true) Integer fCId,
                                   @ApiParam(value = "跟进类型", required = true) String ftType){
        List<Follow> follows = iFollowService.queryFByFtypeAndFCId(fCId, ftType);
        return new DataResult(0, "操作成功", 0, follows);
    }

}
