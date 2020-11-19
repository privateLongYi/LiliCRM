package com.linxi.controller;

import com.linxi.entity.*;
import com.linxi.service.*;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author LongYi
 * @create 2020/8/2 14:19
 */
@Controller
@RequestMapping("customer")
@Api(value = "客户信息控制类", tags = "客户信息控制类")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IClueService iClueService;

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private IAppointmentService iAppointmentService;

    @Autowired
    private ISuccessService iSuccessService;

    @Autowired
    private IFollowService iFollowService;

    @GetMapping("queryCScreen")
    @ApiOperation(value = "查询客户信息")
    @ResponseBody
    public DataResult queryCScreen(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                   @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                   @ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                   @ApiParam(name = "rName", value = "角色名称", required = true) String rName,
                                   @ApiParam(name = "cName", value = "姓名", required = false) String cName,
                                   @ApiParam(name = "cTel", value = "电话", required = false) String cTel,
                                   @ApiParam(name = "clProject", value = "报名项目", required = false) String clProject,
                                   @ApiParam(name = "clEntryFee", value = "是否交报名费", required = false) String clEntryFee,
                                   @ApiParam(name = "clUId", value = "负责人编号", required = false) Integer clUId,
                                   @ApiParam(name = "clSource", value = "来源", required = false) String clSource,
                                   @ApiParam(name = "clTypeId", value = "客户状态编号", required = false) Integer clTypeId,
                                   @ApiParam(name = "ctType", value = "客户状态", required = false) String ctType,
                                   @ApiParam(name = "beginTime", value = "开始时间", required = false) String beginTime,
                                   @ApiParam(name = "endTime", value = "结束时间", required = false) String endTime,
                                   @ApiParam(name = "export", value = "是否导出", required = false) Integer export) {
        if (clTypeId == null && ctType != null) {
            //根据客户状态查询编号
            clTypeId = iCtypeService.queryCtypeByCtType(ctType);
            if (!ctType.equals("待到店")) {
                //根据筛选条件查询客户
                List<Customer> customeres = iCustomerService.queryCScreen(uId, rName, (page - 1) * limit, limit, cName, cTel, clProject, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId, export);
                //获取总条数
                Integer total = iCustomerService.getTotalByScreen(uId, rName, cName, cTel, clProject, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId);
                return new DataResult(0, "操作成功", total, customeres);
            } else {
                //根据筛选条件查询客户
                List<Customer> customeres = iCustomerService.queryAACScreen(uId, rName, (page - 1) * limit, limit, cName, cTel, clProject, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId, export);
                //赋值预约状态（预约已过，预约未过）
                for (Customer customer : customeres) {
                    if (new Timestamp(System.currentTimeMillis()).after(customer.getaTime())) {
                        customer.setIsDue("预约已过");
                    } else {
                        customer.setIsDue("预约未过");
                    }
                }
                //获取总条数
                Integer total = iCustomerService.getAACTotalByScreen(uId, rName, cName, cTel, clProject, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId);
                return new DataResult(0, "操作成功", total, customeres);
            }
        } else {
            //根据筛选条件查询客户
            List<Customer> customeres = iCustomerService.queryCScreen(uId, rName, (page - 1) * limit, limit, cName, cTel, clProject, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId, export);
            //获取总条数
            Integer total = iCustomerService.getTotalByScreen(uId, rName, cName, cTel, clProject, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId);
            return new DataResult(0, "操作成功", total, customeres);
        }
    }

    @PostMapping("saveCustomer")
    @ApiOperation(value = "新增客户信息")
    @ResponseBody
    public DataResult saveCustomer(@ApiParam(name = "cName", value = "姓名", required = true) String cName,
                                   @ApiParam(name = "cSex", value = "性别", required = true) String cSex,
                                   @ApiParam(name = "cAge", value = "年龄", required = false) Integer cAge,
                                   @ApiParam(name = "cTel", value = "电话", required = true) String cTel,
                                   @ApiParam(name = "clProject", value = "报名项目", required = true) String clProject,
                                   @ApiParam(name = "clPlaceTime", value = "报名时间", required = true) String clPlaceTime,
                                   @ApiParam(name = "clEntryFee", value = "报名费", required = false) String clEntryFee,
                                   @ApiParam(name = "clUId", value = "用户编号", required = true) Integer clUId,
                                   @ApiParam(name = "clSource", value = "来源", required = false) String clSource,
                                   @ApiParam(name = "clTypeId", value = "状态编号", required = true) Integer clTypeId,
                                   @ApiParam(name = "clRemark", value = "备注", required = false) String clRemark,
                                   @ApiParam(name = "clMessage", value = "症状信息", required = false) String clMessage) {
        //根据姓名和电话查询客户
        List<Customer> customers = iCustomerService.queryCByCNameAndCTel(cName, cTel);
        if (customers.size() != 0) {
            return new DataResult(1, "新增失败，姓名和电话号码重复！");
        } else {
            //新增客户
            Customer c = new Customer(null, cName, cSex, cAge, cTel, null);
            iCustomerService.saveCustomer(c);
            //查询新增客户的编号
            Integer cId = iCustomerService.queryMaxCId();
            //新增线索
            Clue clue = new Clue(null, cId, clProject, Timestamp.valueOf(clPlaceTime), clRemark, clEntryFee, clUId, clSource, clMessage, clTypeId, 0);
            iClueService.saveClue(clue);
            return new DataResult(0, "新增成功");
        }
    }

    @GetMapping("delCByCId")
    @ApiOperation(value = "删除客户信息")
    @ResponseBody
    public DataResult delCByCId(@ApiParam(value = "客户编号", required = true) Integer cId,
                                @ApiParam(value = "客户名称", required = true) String cName,
                                @ApiParam(value = "用户编号", required = true) Integer uId) {
        //删除客户
        iCustomerService.delCByCId(cId);
        //删除线索
        iClueService.delClByClCId(cId);
        //新增操作记录
        Operating operating = new Operating(cId, uId, "删除了客户");
        iOperatingService.saveOperating(operating);
        return new DataResult(0, "删除成功");
    }

    @GetMapping("queryCByCId")
    @ApiOperation(value = "查询客户信息")
    public String queryCByCId(@ApiParam(value = "客户编号", required = true) Integer cId,
                              @ApiParam(value = "页面", required = true) String page,
                              ModelMap map) {
        Customer c = iCustomerService.queryCByCId(cId);
        map.addAttribute("c", c);
        map.addAttribute("page", page);
        return "customer/customeredit";
    }

    @PostMapping("editCByCId")
    @ApiOperation(value = "编辑客户信息")
    @ResponseBody
    public DataResult editCByCId(@ApiParam(name = "uId", value = "操作用户编号", required = true) Integer uId,
                                 @ApiParam(name = "cId", value = "编号", required = true) Integer cId,
                                 @ApiParam(name = "cName", value = "姓名", required = true) String cName,
                                 @ApiParam(name = "cSex", value = "性别", required = true) String cSex,
                                 @ApiParam(name = "cAge", value = "年龄", required = false) Integer cAge,
                                 @ApiParam(name = "cTel", value = "电话", required = true) String cTel,
                                 @ApiParam(name = "clProject", value = "项目", required = true) String clProject,
                                 @ApiParam(name = "clEntryFee", value = "报名费", required = false) String clEntryFee,
                                 @ApiParam(name = "clUId", value = "用户编号", required = false) Integer clUId,
                                 @ApiParam(name = "clSource", value = "来源", required = false) String clSource,
                                 @ApiParam(name = "clTypeId", value = "状态", required = true) Integer clTypeId,
                                 @ApiParam(name = "clRemark", value = "备注", required = false) String clRemark,
                                 @ApiParam(name = "clMessage", value = "症状信息", required = false) String clMessage) {
        //创建客户
        Customer c = new Customer(cId, cName, cSex, cAge, cTel, null);
        //编辑客户
        iCustomerService.editCByCId(c);
        //创建线索
        Clue clue = new Clue(null, cId, clProject, null, clRemark, clEntryFee, clUId, clSource, clMessage, clTypeId, 0);
        //编辑线索
        iClueService.editClByCId(clue);
        //新增操作记录
        Operating operating = new Operating(cId, uId, "编辑了客户");
        iOperatingService.saveOperating(operating);
        return new DataResult(0, "编辑成功");
    }

    @GetMapping("getTotalCByUIdAndCTypeId")
    @ApiOperation(value = "根据用户编号和客户状态查询客户总条数")
    @ResponseBody
    public Integer getTotalCByUIdAndCTypeId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                            @ApiParam(value = "客户状态", required = true) String ctType) {
        //根据客户状态查询编号
        Integer cTypeId = iCtypeService.queryCtypeByCtType(ctType);
        //根据用户编号和客户状态查询客户总条数
        Integer total = iCustomerService.getTotalCByUIdAndCTypeId(uId, cTypeId);
        return total;
    }

    @PostMapping("queryCByCNameOrCTel")
    @ApiOperation(value = "根据客户名称或者客户电话查询客户")
    @ResponseBody
    public Map<String, Object> queryCByCNameOrCTel(@ApiParam(value = "角色名称", required = true) String rName,
                                                   @ApiParam(value = "用户编号", required = true) Integer uId,
                                                   @ApiParam(value = "关键字", required = true) String key,
                                                   @ApiParam(value = "当前页码", required = true) Integer page) {
        Map<String, Object> map = new HashMap<>();
        List<Customer> customers = iCustomerService.queryCByCNameOrCTel(rName, uId, key, (page - 1) * 4);
        Integer total = iCustomerService.getTotalByCNameOrCTel(rName, uId, key);
        if (total == null) {
            total = 0;
        } else {
            if (total % 4 != 0) {
                total = (total / 4) + 1;
            } else {
                total = total / 4;
            }
        }
        map.put("data", customers);
        map.put("count", total);
        return map;
    }

    @PostMapping("queryCSCByUIdAndCName")
    @ApiOperation(value = "根据用户编号和客户名称查询可成交客户")
    @ResponseBody
    public Map<String, Object> queryCSCByUIdAndCName(@ApiParam(value = "角色名称", required = true) String rName,
                                                     @ApiParam(value = "用户编号", required = true) Integer uId,
                                                     @ApiParam(value = "客户名称", required = true) String cName,
                                                     @ApiParam(value = "当前页码", required = true) Integer page) {
        Map<String, Object> map = new HashMap<>();
        List<Customer> customers = iCustomerService.queryCSCByUIdAndCName(rName, uId, cName, (page - 1) * 4);
        Integer total = iCustomerService.getTotalCSCByUIdAndCName(rName, uId, cName);
        if (total == null) {
            total = 0;
        } else {
            if (total % 4 != 0) {
                total = (total / 4) + 1;
            } else {
                total = total / 4;
            }
        }
        map.put("data", customers);
        map.put("count", total);
        return map;
    }

    @PostMapping("queryCACByUIdAndCName")
    @ApiOperation(value = "根据用户编号和客户名称查询可成交客户")
    @ResponseBody
    public Map<String, Object> queryCACByUIdAndCName(@ApiParam(value = "角色名称", required = true) String rName,
                                                     @ApiParam(value = "用户编号", required = true) Integer uId,
                                                     @ApiParam(value = "客户名称", required = true) String cName,
                                                     @ApiParam(value = "当前页码", required = true) Integer page) {
        Map<String, Object> map = new HashMap<>();
        List<Customer> customers = iCustomerService.queryCACByUIdAndCName(rName, uId, cName, (page - 1) * 4);
        Integer total = iCustomerService.getTotalCACByUIdAndCName(rName, uId, cName);
        if (total == null) {
            total = 0;
        } else {
            if (total % 4 != 0) {
                total = (total / 4) + 1;
            } else {
                total = total / 4;
            }
        }
        map.put("data", customers);
        map.put("count", total);
        return map;
    }

    @GetMapping("detail")
    @ApiOperation(value = "查询客户详情")
    @ResponseBody
    public Map<String, Object> detail(@ApiParam(value = "客户编号", required = true) Integer clId) {
        //声明集合
        Map<String, Object> map = new HashMap<String, Object>();
        //根据客户编号查询客户并加入集合
        Customer c = iCustomerService.queryCByClId(clId);
        map.put("customer", c);
        //根据客户编号查询最近预约门诊
        String hName = iAppointmentService.queryLastHNameByClId(clId);
        if (hName == null) {
            map.put("hName", "");
        } else {
            map.put("hName", hName);
        }
        //根据线索编号查询成交金额
        Integer successMoney = iSuccessService.queryTotalMoneyByClId(clId, 0);
        if (successMoney == null) {
            map.put("successMoney", 0);
        } else {
            map.put("successMoney", successMoney);
        }
        //根据线索编号查询已交金额
        Integer payMoney = iSuccessService.queryTotalMoneyByClId(clId, 1);
        if (successMoney == null) {
            map.put("payMoney", 0);
        } else {
            map.put("payMoney", payMoney);
        }
        //待交金额
        if (successMoney != null && payMoney != null) {
            map.put("waitMoney", successMoney - payMoney);
        } else {
            map.put("waitMoney", 0);
        }
        //最后修改时间
        String s = iOperatingService.queryOpTimeByClId(clId);
        if (s == null) {
            map.put("updateTime", "");
        } else {
            map.put("updateTime", s);
        }
        return map;
    }

    @GetMapping("bulletin")
    @ApiOperation(value = "根据起止时间查询销售简报")
    @ResponseBody
    public Map<String, Object> bulletin(@ApiParam(value = "用户编号", required = true) Integer uId,
                                        @ApiParam(value = "角色名称", required = true) String rName,
                                        @ApiParam(value = "开始时间", required = true) String beginTime,
                                        @ApiParam(value = "结束时间", required = true) String endTime) {
        //声明集合
        Map<String, Object> map = new HashMap<String, Object>();
        //新增客户数
        Integer insert = iCustomerService.getTotalByTime(uId, rName, beginTime, endTime);
        if (insert == null){
            insert = 0;
        }
        map.put("insert", insert);
        //预约客户数
        Integer appoint = iCustomerService.getTotalAByTime(uId, rName, beginTime, endTime);
        if (appoint == null){
            appoint = 0;
        }
        map.put("appoint", appoint);
        //成交客户数
        Integer success = iSuccessService.getTotalByTime(uId, rName, beginTime, endTime);
        if (success == null){
            success = 0;
        }
        map.put("success", success);
        //客户成交率
        String percent;
        if (insert != 0){
            DecimalFormat df = new DecimalFormat("0.00");//格式化小数
            String num = df.format((float)success/(float)insert*100);
            percent = num + "%";
        } else {
            percent = "0%";
        }
        map.put("percent", percent);
        //客户成交金额
        Integer successMoney = iSuccessService.queryMoneyByTime(uId, rName, beginTime, endTime, 0);
        if (successMoney == null){
            successMoney = 0;
        }
        map.put("successMoney", successMoney);
        //平均客单价
        Double acup;
        if (appoint != 0){
            acup = Double.valueOf(successMoney/success);
        } else {
            acup = 0.0;
        }
        map.put("acup", acup);
        //客户实收金额
        Integer payMoney = iSuccessService.queryMoneyByTime(uId, rName, beginTime, endTime, 1);
        if (payMoney == null){
            payMoney = 0;
        }
        map.put("payMoney", payMoney);
        //客户待收金额
        Integer awaitMoney = successMoney - payMoney;
        map.put("awaitMoney", awaitMoney);
        return map;
    }

    @GetMapping("await")
    @ApiOperation(value = "根据起止时间查询待办客资")
    @ResponseBody
    public Map<String, Object> await(@ApiParam(value = "用户编号", required = true) Integer uId,
                                     @ApiParam(value = "角色名称", required = true) String rName,
                                     @ApiParam(value = "开始时间", required = true) String beginTime,
                                     @ApiParam(value = "结束时间", required = true) String endTime) {
        //声明集合
        Map<String, Object> map = new HashMap<String, Object>();
        //根据客户状态查询编号
        Integer awaitContactId = iCtypeService.queryCtypeByCtType("待联系");
        Integer awaitAppointId = iCtypeService.queryCtypeByCtType("待预约");
        Integer awaitArriveId = iCtypeService.queryCtypeByCtType("待到店");
        //待联系客户
        Integer awaitContact = iCustomerService.queryCByUIdAndTimeAndCTypeId(uId, rName, awaitContactId, beginTime, endTime);
        if (awaitContact == null){
            awaitContact = 0;
        }
        map.put("awaitContact", awaitContact);
        //待预约客户
        Integer awaitAppoint = iCustomerService.queryCByUIdAndTimeAndCTypeId(uId, rName, awaitAppointId, beginTime, endTime);
        if (awaitAppoint == null){
            awaitAppoint = 0;
        }
        map.put("awaitAppoint", awaitAppoint);
        //待到店客户
        Integer awaitArrive = iCustomerService.queryCByUIdAndTimeAndCTypeId(uId, rName, awaitArriveId, beginTime, endTime);
        if (awaitArrive == null){
            awaitArrive = 0;
        }
        map.put("awaitArrive", awaitArrive);
        return map;
    }

    @GetMapping("queryCByTime")
    @ApiOperation(value = "根据起止时间查询客户")
    @ResponseBody
    public DataResult queryCByTime(@ApiParam(value = "页码", required = true) Integer page,
                                   @ApiParam(value = "显示条数", required = true) Integer limit,
                                   @ApiParam(value = "用户编号", required = true) Integer uId,
                                   @ApiParam(value = "角色名称", required = true) String rName,
                                   @ApiParam(value = "开始时间", required = true) String beginTime,
                                   @ApiParam(value = "结束时间", required = true) String endTime) {
        List<Customer> customers = iCustomerService.queryCByTime((page - 1) * limit, limit, uId, rName, beginTime, endTime);
        Integer total = iCustomerService.getTotalByTime(uId, rName, beginTime, endTime);
        return new DataResult(0, "操作成功", total, customers);
    }

    @GetMapping("queryAByTime")
    @ApiOperation(value = "根据起止时间查询预约客户")
    @ResponseBody
    public DataResult queryAByTime(@ApiParam(value = "页码", required = true) Integer page,
                                   @ApiParam(value = "显示条数", required = true) Integer limit,
                                   @ApiParam(value = "用户编号", required = true) Integer uId,
                                   @ApiParam(value = "角色名称", required = true) String rName,
                                   @ApiParam(value = "开始时间", required = true) String beginTime,
                                   @ApiParam(value = "结束时间", required = true) String endTime) {
        List<Customer> customers = iCustomerService.queryAByTime((page - 1) * limit, limit, uId, rName, beginTime, endTime);
        Integer total = iCustomerService.getTotalAByTime(uId, rName, beginTime, endTime);
        return new DataResult(0, "操作成功", total, customers);
    }

    @GetMapping("queryArriveByTime")
    @ApiOperation(value = "根据起止时间查询已到店客户")
    @ResponseBody
    public DataResult queryArriveByTime(@ApiParam(value = "页码", required = true) Integer page,
                                        @ApiParam(value = "显示条数", required = true) Integer limit,
                                        @ApiParam(value = "用户编号", required = true) Integer uId,
                                        @ApiParam(value = "角色名称", required = true) String rName,
                                        @ApiParam(value = "开始时间", required = true) String beginTime,
                                        @ApiParam(value = "结束时间", required = true) String endTime) {
        List<Customer> customers = iCustomerService.queryArriveByTime((page - 1) * limit, limit, uId, rName, beginTime, endTime);
        Integer total = iCustomerService.getTotalArriveByTime(uId, rName, beginTime, endTime);
        return new DataResult(0, "操作成功", total, customers);
    }

}
