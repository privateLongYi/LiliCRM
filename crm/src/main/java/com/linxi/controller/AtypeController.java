package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.Atype;
import com.linxi.service.IAtypeService;
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
 * @create 2020/9/2 19:24
 */
@Controller
@RequestMapping("atype")
@Api(value = "预约类型控制类", tags = "预约类型控制类")
public class AtypeController {

    @Autowired
    private IAtypeService iAtypeService;

    @GetMapping("queryAtype")
    @ApiOperation(value = "查询所有预约类型")
    @ResponseBody
    public DataResult queryAtype(){
        List<Atype> atypes = iAtypeService.queryAtype();
        return DataResult.success(atypes);
    }

    @GetMapping("queryAtypePage")
    @ApiOperation(value = "查询预约类型")
    @ResponseBody
    public DataResult queryAtypePage(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                     @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
        List<Atype> atypes = iAtypeService.queryAtypePage((page - 1) * limit, limit);
        Integer total = iAtypeService.getTotal();
        return DataResult.success(total, atypes);
    }

    @NoRepeatSubmit
    @PostMapping("saveAtype")
    @ApiOperation(value = "新增预约类型")
    @ResponseBody
    public DataResult saveAtype(@ApiParam(value = "预约类型", required = true) String atType){
        iAtypeService.saveAtype(atType);
        return DataResult.success();
    }

    @NoRepeatSubmit
    @GetMapping("delAtypeByAtId")
    @ApiOperation(value = "根据编号删除预约类型")
    @ResponseBody
    public DataResult delAtypeByAtId(@ApiParam(value = "编号", required = true) Integer atId){
        iAtypeService.delAtypeByAtId(atId);
        return DataResult.success();
    }

    @GetMapping("queryAtypeByAtId")
    @ApiOperation(value = "根据编号查询预约类型")
    public String queryAtypeByAtId(@ApiParam(value = "编号", required = true) Integer atId, ModelMap map){
        Atype atype = iAtypeService.queryAtypeByAtId(atId);
        map.addAttribute("atype", atype);
        return "atype/atypeedit";
    }

    @NoRepeatSubmit
    @PostMapping("editAtypeByAtId")
    @ApiOperation(value = "根据编号编辑预约类型")
    @ResponseBody
    public DataResult editAtypeByAtId(@ApiParam(value = "编号", required = true) Integer atId,
                                      @ApiParam(value = "预约类型", required = true) String atType){
        Atype atype = new Atype(atId, atType);
        iAtypeService.editAtypeByAtId(atype);
        return DataResult.success();
    }

    @PostMapping("queryAByAType")
    @ApiOperation(value = "根据预约类型查询编号")
    @ResponseBody
    public DataResult queryAByAType(@ApiParam(value = "预约类型", required = true) String atType){
        Integer atId = iAtypeService.queryAByAType(atType);
        return DataResult.success(atId);
    }

}
