package com.linxi.controller;

import com.linxi.entity.Paytype;
import com.linxi.service.IPaytypeService;
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
 * @create 2020/9/10 22:55
 */
@Controller
@RequestMapping("paytype")
@Api(value = "支付类型控制类", tags = "支付类型控制类")
public class PaytypeController {

    @Autowired
    private IPaytypeService iPaytypeService;

    @GetMapping("queryPaytypePage")
    @ApiOperation(value = "查询支付类型")
    @ResponseBody
    public DataResult queryPaytypePage(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                     @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
        List<Paytype> paytypes = iPaytypeService.queryPaytypePage((page - 1) * limit, limit);
        Integer total = iPaytypeService.getTotal();
        return new DataResult(0, "操作成功", total, paytypes);
    }

    @PostMapping("savePaytype")
    @ApiOperation(value = "新增支付类型")
    @ResponseBody
    public DataResult savePaytype(@ApiParam(value = "支付类型", required = true) String payType){
        iPaytypeService.savePaytype(payType);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("delPaytypeByPayId")
    @ApiOperation(value = "根据编号删除支付类型")
    @ResponseBody
    public DataResult delPaytypeByPayId(@ApiParam(value = "编号", required = true) Integer payId){
        iPaytypeService.delPaytypeByPayId(payId);
        return new DataResult(0, "删除成功");
    }

    @GetMapping("queryPaytypeByPayId")
    @ApiOperation(value = "根据编号查询支付类型")
    public String queryPaytypeByPayId(@ApiParam(value = "编号", required = true) Integer payId, ModelMap map){
        Paytype paytype = iPaytypeService.queryPaytypeByPayId(payId);
        map.addAttribute("paytype", paytype);
        return "paytype/paytypeedit";
    }

    @PostMapping("editPaytypeByPayId")
    @ApiOperation(value = "根据编号编辑支付类型")
    @ResponseBody
    public DataResult editPaytypeByPayId(@ApiParam(value = "编号", required = true) Integer payId,
                                      @ApiParam(value = "支付类型", required = true) String payType){
        Paytype paytype = new Paytype(payId, payType);
        iPaytypeService.editPaytypeByPayId(paytype);
        return new DataResult(0, "编辑成功");
    }

    @GetMapping("queryAllPaytype")
    @ApiOperation(value = "查询所有支付类型")
    @ResponseBody
    public DataResult queryAllPaytype(){
        List<Paytype> paytypes = iPaytypeService.queryAllPaytype();
        return new DataResult(0, "操作成功", 0, paytypes);
    }

}
