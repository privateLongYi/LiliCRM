package com.linxi.controller;

import com.linxi.entity.Customer;
import com.linxi.entity.Operating;
import com.linxi.entity.Success;
import com.linxi.service.ICtypeService;
import com.linxi.service.ICustomerService;
import com.linxi.service.IOperatingService;
import com.linxi.service.ISuccessService;
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
 * @create 2020/9/3 20:14
 */
@Controller
@RequestMapping("success")
@Api(value = "成交客户控制类", tags = "成交客户控制类")
public class SuccessController {

    @Autowired
    private ISuccessService iSuccessService;

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("querySBySCId")
    @ApiOperation(value = "根据客户编号查询成交客户")
    @ResponseBody
    public DataResult querySBySCId(@ApiParam(value = "客户编号", required = true) Integer sCId){
        List<Success> successes = iSuccessService.querySBySCId(sCId);
        Integer total = iSuccessService.getTotalBySCId(sCId);
        return new DataResult(0, "操作成功", total, successes);
    }

    @GetMapping("delSBySId")
    @ApiOperation(value = "根据成交客户编号删除成交客户")
    @ResponseBody
    public DataResult delSBySId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                @ApiParam(value = "成交客户编号", required = true) Integer sId){
        //新增操作记录
        Operating operating = new Operating(sId, uId, "删除了成交客户");
        iOperatingService.addOperatingRecord(operating);
        //删除成交客户
        iSuccessService.delSBySId(sId);
        return new DataResult(0, "操作成功");
    }

    @GetMapping("querySBySId")
    @ApiOperation(value = "根据成交客户编号查询成交客户")
    public String querySBySCId(@ApiParam(value = "成交客户编号", required = true) Integer sId, ModelMap map){
        Success success = iSuccessService.querySBySId(sId);
        map.addAttribute("s", success);
        return "success/successedit";
    }

    @PostMapping("editSBySId")
    @ApiOperation(value = "根据成交客户编号编辑成交客户")
    @ResponseBody
    public DataResult querySBySCId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                   @ApiParam(value = "成交编号", required = true) Integer sId,
                                   @ApiParam(value = "成交客户编号", required = true) Integer sCId,
                                   @ApiParam(value = "门诊编号", required = true) Integer sHId,
                                   @ApiParam(value = "成交信息", required = true) String sMessage,
                                   @ApiParam(value = "总成交金额", required = true) Integer sSum,
                                   @ApiParam(value = "总付款金额", required = true) Integer sPaysum,
                                   @ApiParam(value = "成交备注", required = true) String sRemark){
        //新增操作记录
        Operating operating = new Operating(sCId, uId, "编辑了成交客户");
        iOperatingService.addOperatingRecord(operating);
        //编辑成交客户
        Success success = new Success(sId, sCId, sHId, sMessage, sSum, sPaysum, sRemark);
        iSuccessService.editSBySId(success);
        return new DataResult(0, "编辑成功");
    }

    @PostMapping("saveSuccess")
    @ApiOperation(value = "新增成交客户")
    @ResponseBody
    public DataResult saveSuccess(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                  @ApiParam(name = "sCId", value = "客户编号", required = true) Integer sCId,
                                  @ApiParam(name = "sHId", value = "门诊编号", required = true) Integer sHId,
                                  @ApiParam(name = "sMessage", value = "成交信息", required = true) String sMessage,
                                  @ApiParam(name = "sSum", value = "成交金额", required = true) Integer sSum,
                                  @ApiParam(name = "sPaysum", value = "支付金额", required = true) Integer sPaysum,
                                  @ApiParam(name = "sRemark", value = "备注", required = true) String sRemark){
        //添加操作记录
        Operating operating = new Operating(sCId, uId, "添加了成交客户");
        iOperatingService.addOperatingRecord(operating);
        //根据客户状态查询编号
        Integer cTypeId = iCtypeService.queryCtypeByCtType("成交");
        //改变客户状态为成交状态
        iCustomerService.editCTypeIdByCId(sCId, cTypeId);
        //新增成交客户
        Success success = new Success(null, sCId, sHId, sMessage, sSum, sPaysum, sRemark);
        iSuccessService.saveSuccess(success);
        return new DataResult(0, "新增成功");
    }

    @GetMapping("queryCScreen")
    @ApiOperation(value = "查询客户信息")
    @ResponseBody
    public DataResult queryCScreen(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                   @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                   @ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                   @ApiParam(name = "rName", value = "角色名称", required = true) String rName,
                                   @ApiParam(name = "param", value = "筛选条件", required = false) String param){
        //姓名
        String cName = null;
        //电话
        String cTel = null;
        //报名项目
        String cProject = null;
        //预约门诊
        Integer hId = null;
        //是否交定金
        Integer cEarnest = null;
        //负责人编号
        Integer cUId = null;
        //来源
        String cSource = null;
        //根据客户状态查询编号
        Integer cTypeId = iCtypeService.queryCtypeByCtType("成交");
        //开始时间
        String beginTime = null;
        //结束时间
        String endTime = null;
        if (param != null && !param.equals("")) {
            //去掉参数中最后一个字符并且按逗号分隔
            param = param.substring(0, param.length() - 1);
            String[] split = param.split(",");
            //为参数赋值
            for (int i = 0; i < split.length; i++) {
                String[] screen = split[i].split(":");
                if (screen[0].trim().equals("cName")) {
                    cName = screen[1].trim();
                } else if (screen[0].trim().equals("cTel")) {
                    cTel = screen[1].trim();
                } else if (screen[0].trim().equals("cProject")) {
                    cProject = screen[1].trim();
                } else if (screen[0].trim().equals("hId")) {
                    hId = Integer.parseInt(screen[1].trim());
                } else if (screen[0].trim().equals("cEarnest")) {
                    cEarnest = Integer.parseInt(screen[1].trim());
                } else if (screen[0].trim().equals("cUId")) {
                    cUId = Integer.parseInt(screen[1].trim());
                } else if (screen[0].trim().equals("cSource")) {
                    cSource = screen[1].trim();
                } else if (screen[0].trim().equals("beginTime")) {
                    beginTime = screen[1].trim();
                } else if (screen[0].trim().equals("endTime")) {
                    endTime = screen[1].trim();
                }
            }
        }
        //根据筛选条件查询客户
        List<Customer> customeres = iCustomerService.queryCScreen(uId, rName, (page - 1) * limit, limit, cName, cTel, cProject, hId, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
        //获取总条数
        Integer total = iCustomerService.getTotalByScreen(uId, rName, cName, cTel, cProject, hId, cEarnest, beginTime, endTime, cUId, cSource, cTypeId);
        return new DataResult(0, "操作成功", total, customeres);
    }

}
