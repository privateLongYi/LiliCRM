package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.Ftype;
import com.linxi.service.IFtypeService;
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
 * @create 2020/9/10 22:11
 */
@Controller
@RequestMapping("crm/ftype")
@Api(value = "回访类型控制类", tags = "回访类型控制类")
public class FtypeController {

    @Autowired
    private IFtypeService iFtypeService;

    @GetMapping("queryFtypePage")
    @ApiOperation(value = "查询回访类型")
    @ResponseBody
    public DataResult queryFtypePage(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                     @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
        List<Ftype> ftypes = iFtypeService.queryFtypePage((page - 1) * limit, limit);
        Integer total = iFtypeService.getTotal();
        return DataResult.success(total, ftypes);
    }

    @NoRepeatSubmit
    @PostMapping("saveFtype")
    @ApiOperation(value = "新增回访类型")
    @ResponseBody
    public DataResult saveFtype(@ApiParam(value = "回访类型", required = true) String ftType){
        iFtypeService.saveFtype(ftType);
        return DataResult.success();
    }

    @NoRepeatSubmit
    @GetMapping("delFtypeByFtId")
    @ApiOperation(value = "根据编号删除回访类型")
    @ResponseBody
    public DataResult delFtypeByFtId(@ApiParam(value = "编号", required = true) Integer ftId){
        iFtypeService.delFtypeByFtId(ftId);
        return DataResult.success();
    }

    @GetMapping("queryFtypeByFtId")
    @ApiOperation(value = "根据编号查询回访类型")
    public String queryFtypeByFtId(@ApiParam(value = "编号", required = true) Integer ftId, ModelMap map){
        Ftype ftype = iFtypeService.queryFtypeByFtId(ftId);
        map.addAttribute("ftype", ftype);
        return "ftype/ftypeedit";
    }

    @NoRepeatSubmit
    @PostMapping("editFtypeByFtId")
    @ApiOperation(value = "根据编号编辑回访类型")
    @ResponseBody
    public DataResult editFtypeByFtId(@ApiParam(value = "编号", required = true) Integer ftId,
                                      @ApiParam(value = "回访类型", required = true) String ftType){
        Ftype ftype = new Ftype(ftId, ftType);
        iFtypeService.editFtypeByFtId(ftype);
        return DataResult.success();
    }

    @GetMapping("queryFtype")
    @ApiOperation(value = "查询所有回访类型")
    @ResponseBody
    public DataResult queryFtype(){
        List<Ftype> follows = iFtypeService.queryFtype();
        return DataResult.success(follows);
    }

}
