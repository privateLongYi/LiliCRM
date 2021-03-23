package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.Ctype;
import com.linxi.entity.Hospital;
import com.linxi.mapper.CtypeMapper;
import com.linxi.service.ICtypeService;
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
 * @create 2020/8/22 14:47
 */
@Controller
@RequestMapping("crm/ctype")
@Api(value = "客户状态控制类", tags = "客户状态控制类")
public class CtypeController {

    @Autowired
    private ICtypeService iCtypeService;

    @GetMapping("queryCtype")
    @ApiOperation(value = "查询所有客户状态")
    @ResponseBody
    public DataResult queryCtype(){
        List<Ctype> ctypes = iCtypeService.queryCtype();
        return DataResult.success(ctypes);
    }

    @GetMapping("queryCtypePage")
    @ApiOperation(value = "查询客户状态")
    @ResponseBody
    public DataResult queryCtypePage(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                     @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
        List<Ctype> ctypes = iCtypeService.queryCtypePage((page - 1) * limit, limit);
        Integer total = iCtypeService.getTotal();
        return DataResult.success(total, ctypes);
    }

    @NoRepeatSubmit
    @PostMapping("saveCtype")
    @ApiOperation(value = "新增客户状态")
    @ResponseBody
    public DataResult saveCtype(@ApiParam(value = "客户状态", required = true) String ctType){
        iCtypeService.saveCtype(ctType);
        return DataResult.success();
    }

    @NoRepeatSubmit
    @GetMapping("delCtypeByCtId")
    @ApiOperation(value = "根据编号删除客户状态")
    @ResponseBody
    public DataResult delCtypeByCtId(@ApiParam(value = "编号", required = true) Integer ctId){
        iCtypeService.delCtypeByCtId(ctId);
        return DataResult.success();
    }

    @GetMapping("queryCtypeByCtId")
    @ApiOperation(value = "根据编号查询客户状态")
    public String queryCtypeByCtId(@ApiParam(value = "编号", required = true) Integer ctId, ModelMap map){
        Ctype ctype = iCtypeService.queryCtypeByCtId(ctId);
        map.addAttribute("ctype", ctype);
        return "ctype/ctypeedit";
    }

    @NoRepeatSubmit
    @PostMapping("editCtypeByCtId")
    @ApiOperation(value = "根据编号编辑客户状态")
    @ResponseBody
    public DataResult editCtypeByCtId(@ApiParam(value = "编号", required = true) Integer ctId,
                                     @ApiParam(value = "客户状态", required = true) String ctType){
        Ctype ctype = new Ctype(ctId, ctType);
        iCtypeService.editCtypeByCtId(ctype);
        return DataResult.success();
    }

}
