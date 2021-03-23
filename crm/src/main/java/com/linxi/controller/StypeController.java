package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.Stype;
import com.linxi.service.IStypeService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/10 22:21
 */
@Controller
@RequestMapping("crm/stype")
@Api(value = "成交类型控制类", tags = "成交类型控制类")
public class StypeController {

    @Autowired
    private IStypeService iStypeService;

    @GetMapping("queryStypePage")
    @ApiOperation(value = "查询成交类型")
    @ResponseBody
    public DataResult queryStypePage(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                     @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
        List<Stype> stypes = iStypeService.queryStypePage((page - 1) * limit, limit);
        Integer total = iStypeService.getTotal();
        return DataResult.success(total, stypes);
    }

    @NoRepeatSubmit
    @PostMapping("saveStype")
    @ApiOperation(value = "新增成交类型")
    @ResponseBody
    public DataResult saveStype(@ApiParam(value = "成交类型", required = true) String stType){
        iStypeService.saveStype(stType);
        return DataResult.success();
    }

    @NoRepeatSubmit
    @GetMapping("delStypeByStId")
    @ApiOperation(value = "根据编号删除成交类型")
    @ResponseBody
    public DataResult delStypeByStId(@ApiParam(value = "编号", required = true) Integer stId){
        iStypeService.delStypeByStId(stId);
        return DataResult.success();
    }

    @GetMapping("queryStypeByStId")
    @ApiOperation(value = "根据编号查询成交类型")
    public String queryStypeByStId(@ApiParam(value = "编号", required = true) Integer stId, ModelMap map){
        Stype stype = iStypeService.queryStypeByStId(stId);
        map.addAttribute("stype", stype);
        return "stype/stypeedit";
    }

    @NoRepeatSubmit
    @PostMapping("editStypeByStId")
    @ApiOperation(value = "根据编号编辑成交类型")
    @ResponseBody
    public DataResult editStypeByStId(@ApiParam(value = "编号", required = true) Integer stId,
                                      @ApiParam(value = "成交类型", required = true) String stType){
        Stype stype = new Stype(stId, stType);
        iStypeService.editStypeByStId(stype);
        return DataResult.success();
    }

}
