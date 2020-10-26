package com.linxi.controller;

import com.linxi.entity.Follow;
import com.linxi.entity.Operating;
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

    @PostMapping("saveFollow")
    @ApiOperation(value = "新增客户跟进")
    @ResponseBody
    public DataResult queryFByFCId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                   @ApiParam(value = "客户编号", required = true) Integer cId,
                                   @ApiParam(value = "线索编号", required = true) Integer fClId,
                                   @ApiParam(value = "负责人编号", required = true) Integer clUId,
                                   @ApiParam(value = "回访类型编号", required = true) Integer fTypeId,
                                   @ApiParam(value = "回访类型", required = true) String ftType,
                                   @ApiParam(value = "回访内容", required = true) String fContent){
        //新增操作记录
        Operating operating = new Operating(cId, uId, "新增了"+ftType);
        iOperatingService.saveOperating(operating);
        //新增跟进记录
        Follow follow = new Follow(null, fClId, fTypeId, null, fContent, clUId);
        iFollowService.saveFollow(follow);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("queryFollowByFClId")
    @ApiOperation(value = "根据线索编号查询跟进记录")
    @ResponseBody
    public List<Object> queryFollowByFClId(@ApiParam(value = "线索编号", required = true) Integer clId){
        List<Object> list = new ArrayList<>();
        //根据线索编号查询所拥有的根据记录
        List<Follow> ftTypes = iFollowService.queryFtypeByFClId(clId);
        for (Follow f : ftTypes){
            //根据跟进类型和线索编号查询最后一次跟进时间
            String lastTime = iFollowService.queryLastFTimeByFtypeAndFClId(clId, f.getfType());
            //根据线索编号查询客户跟进
            List<Follow> follows = iFollowService.queryFByFtypeAndFClId(clId, f.getfType());
            //声明跟进信息列表
            List<String> objects = new ArrayList<>();
            for (Follow follow : follows){
                objects.add(follow.getfContent());
            }
            list.add(new FollowVo(Timestamp.valueOf(lastTime), f.getfType(), objects));
        }
        return list;
    }

}
