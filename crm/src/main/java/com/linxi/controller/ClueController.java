package com.linxi.controller;

import com.linxi.service.*;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LongYi
 * @create 2020/8/2 14:19
 */
@Controller
@RequestMapping("clue")
@Api(value = "线索控制类", tags = "线索控制类")
public class ClueController {

    @Autowired
    private IClueService iClueService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private IArriveService iArriveService;

    @GetMapping("getTotalByType")
    @ApiOperation(value = "根据客户类型获得有效线索总数量")
    @ResponseBody
    public DataResult getTotalByType(@ApiParam(value = "客户类型", required = true) String ctType){
        Integer clTypeId = iCtypeService.queryCtypeByCtType(ctType);
        Integer total = iClueService.getTotalByType(clTypeId);
        return new DataResult(0, "操作成功", 0, total);
    }

    @GetMapping("editClTypeIdByClId")
    @ApiOperation(value = "编辑客户状态(改为待预约)")
    @ResponseBody
    public DataResult editClTypeIdByClId(@ApiParam(value = "编号", required = true) Integer clId,
                                         @ApiParam(value = "预约编号", required = true) Integer aId){
        //根据客户状态查询编号
        Integer clTypeId = iCtypeService.queryCtypeByCtType("待预约");
        //编辑客户状态
        iClueService.editClTypeIdByClId(clId, clTypeId);
        //编辑未到店客户为失效状态
        iArriveService.editArInvalidByAId(aId);
        return new DataResult(0, "操作成功");
    }

}
