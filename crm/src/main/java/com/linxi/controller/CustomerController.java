package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.*;
import com.linxi.service.*;
import com.linxi.util.CommonEnum;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author LongYi
 * @create 2020/8/2 14:19
 */
@Controller
@RequestMapping("crm/customer")
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
                                   @ApiParam(name = "clCity", value = "所在城市", required = false) String clCity,
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
                List<Customer> customeres = iCustomerService.queryCScreen(uId, rName, (page - 1) * limit, limit, cName, cTel, clProject, clCity, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId, export);
                //获取总条数
                Integer total = iCustomerService.getTotalByScreen(uId, rName, cName, cTel, clProject, clCity, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId);
                for (Customer customer : customeres){
                    //根据线索编号查询最近预约门诊
                    Appointment appointment = iAppointmentService.queryLastAByClId(customer.getClId());
                    if (appointment != null && appointment.gethName() != null){
                        customer.sethName(appointment.gethName());
                    }
                    //根据线索编号查询总成交金额
                    Double successMoney = iSuccessService.queryTotalMoneyByClId(customer.getClId(), 0);
                    if (successMoney != null){
                        customer.setsSum(successMoney);
                    }
                    //根据线索编号查询总支付金额
                    Double payMoney = iSuccessService.queryTotalMoneyByClId(customer.getClId(), 1);
                    if (payMoney != null){
                        customer.setsPaysum(payMoney);
                    }
                    //根据线索编号查询最早成交时间
                    Success success = iSuccessService.queryFirstSByClId(customer.getClId());
                    if (success != null && success.getsTime() != null){
                        customer.setsTime(success.getsTime());
                    }
                }
                return DataResult.success(total, customeres);
            } else {
                //根据筛选条件查询客户
                List<Customer> customeres = iCustomerService.queryAACScreen(uId, rName, (page - 1) * limit, limit, cName, cTel, clProject, clCity, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId, export);
                //赋值预约状态（预约已过，预约未过）
                for (Customer customer : customeres) {
                    if (new Timestamp(System.currentTimeMillis()).after(customer.getaTime())) {
                        customer.setIsDue("预约已过");
                    } else {
                        customer.setIsDue("预约未过");
                    }
                }
                //获取总条数
                Integer total = iCustomerService.getAACTotalByScreen(uId, rName, cName, cTel, clProject, clCity, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId);
                return DataResult.success(total, customeres);
            }
        } else {
            //根据筛选条件查询客户
            List<Customer> customeres = iCustomerService.queryCScreen(uId, rName, (page - 1) * limit, limit, cName, cTel, clProject, clCity, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId, export);
            //获取总条数
            Integer total = iCustomerService.getTotalByScreen(uId, rName, cName, cTel, clProject, clCity, clEntryFee, beginTime, endTime, clUId, clSource, clTypeId);
            for (Customer customer : customeres){
                //根据线索编号查询最近预约门诊
                Appointment appointment = iAppointmentService.queryLastAByClId(customer.getClId());
                if (appointment != null && appointment.gethName() != null){
                    customer.sethName(appointment.gethName());
                }
                //根据线索编号查询总成交金额
                Double successMoney = iSuccessService.queryTotalMoneyByClId(customer.getClId(), 0);
                if (successMoney != null){
                    customer.setsSum(successMoney);
                }
                //根据线索编号查询总支付金额
                Double payMoney = iSuccessService.queryTotalMoneyByClId(customer.getClId(), 1);
                if (payMoney != null){
                    customer.setsPaysum(payMoney);
                }
                //根据线索编号查询最早成交时间
                Success success = iSuccessService.queryFirstSByClId(customer.getClId());
                if (success != null && success.getsTime() != null){
                    customer.setsTime(success.getsTime());
                }
            }
            return DataResult.success(total, customeres);
        }
    }

    @NoRepeatSubmit
    @PostMapping("saveCustomer")
    @ApiOperation(value = "新增客户信息")
    @ResponseBody
    public DataResult saveCustomer(@ApiParam(name = "uId", value = "操作用户编号", required = true) Integer uId,
                                   @ApiParam(name = "uName", value = "操作用户姓名", required = true) String uName,
                                   @ApiParam(name = "cName", value = "姓名", required = true) String cName,
                                   @ApiParam(name = "cSex", value = "性别", required = true) String cSex,
                                   @ApiParam(name = "cAge", value = "年龄", required = false) Integer cAge,
                                   @ApiParam(name = "cTel", value = "电话", required = true) String cTel,
                                   @ApiParam(name = "cWx", value = "微信号", required = true) String cWx,
                                   @ApiParam(name = "clProject", value = "报名项目", required = true) String clProject,
                                   @ApiParam(name = "clPlaceTime", value = "报名时间", required = true) String clPlaceTime,
                                   @ApiParam(name = "clCity", value = "所在城市", required = true) String clCity,
                                   @ApiParam(name = "clEntryFee", value = "报名费", required = false) String clEntryFee,
                                   @ApiParam(name = "clUId", value = "用户编号", required = true) Integer clUId,
                                   @ApiParam(name = "clSource", value = "来源", required = false) String clSource,
                                   @ApiParam(name = "clTypeId", value = "状态编号", required = true) Integer clTypeId,
                                   @ApiParam(name = "clRemark", value = "备注", required = false) String clRemark,
                                   @ApiParam(name = "clMessage", value = "症状信息", required = false) String clMessage) {
        //根据姓名和电话查询客户
        List<Customer> customers = iCustomerService.queryCByCNameAndCTel(cName, cTel);
        if (customers.size() != 0) {
            return DataResult.error(403, "新增失败，姓名和电话号码重复！");
        } else {
            //创建客户
            Customer c = new Customer(null, cName, cSex, cAge, cTel, cWx, null);
            //根据姓名查询客户
            List<Customer> customers1 = iCustomerService.queryCByCName(cName);
            if (customers1.size() != 0) {
                String s = customers1.get(0).getcName();
                if (s.contains("(")){
                    String substring = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
                    Integer num = Integer.parseInt(substring) + 1;
                    String number = "(" + num + ")";
                    c.setcName(c.getcName() + number);
                } else {
                    String number = "(1)";
                    c.setcName(c.getcName() + number);
                }
            }
            //新增客户
            iCustomerService.saveCustomer(c);
            //新增线索
            Clue clue = new Clue(null, c.getcId(), clProject, Timestamp.valueOf(clPlaceTime), clCity, clRemark, clEntryFee, clUId, clSource, clMessage, clTypeId, 0);
            iClueService.saveClue(clue);
            //新增操作记录
            Operating operating = new Operating(c.getcId(), uId, "新增", uName + "添加了客户" + cName);
            iOperatingService.saveOperating(operating);
            return DataResult.success();
        }
    }

    @NoRepeatSubmit
    @GetMapping("delCByCId")
    @ApiOperation(value = "删除客户信息")
    @ResponseBody
    public DataResult delCByCId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                @ApiParam(value = "用户姓名", required = true) String uName,
                                @ApiParam(value = "客户编号", required = true) Integer cId,
                                @ApiParam(value = "客户名称", required = true) String cName) {
        //删除客户
        iCustomerService.delCByCId(cId);
        //删除线索
        iClueService.delClByClCId(cId);
        //新增操作记录
        Operating operating = new Operating(cId, uId, "删除", uName + "删除了客户" + cName);
        iOperatingService.saveOperating(operating);
        return DataResult.success();
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

    @NoRepeatSubmit
    @PostMapping("editCByCId")
    @ApiOperation(value = "编辑客户信息")
    @ResponseBody
    public DataResult editCByCId(@ApiParam(name = "uId", value = "操作用户编号", required = true) Integer uId,
                                 @ApiParam(name = "uName", value = "操作用户姓名", required = true) String uName,
                                 @ApiParam(name = "cId", value = "编号", required = true) Integer cId,
                                 @ApiParam(name = "cName", value = "姓名", required = true) String cName,
                                 @ApiParam(name = "cSex", value = "性别", required = true) String cSex,
                                 @ApiParam(name = "cAge", value = "年龄", required = false) Integer cAge,
                                 @ApiParam(name = "cTel", value = "电话", required = true) String cTel,
                                 @ApiParam(name = "cWx", value = "微信号", required = true) String cWx,
                                 @ApiParam(name = "clProject", value = "项目", required = true) String clProject,
                                 @ApiParam(name = "clCity", value = "所在城市", required = true) String clCity,
                                 @ApiParam(name = "clEntryFee", value = "报名费", required = false) String clEntryFee,
                                 @ApiParam(name = "clSource", value = "来源", required = false) String clSource,
                                 @ApiParam(name = "clTypeId", value = "状态", required = true) Integer clTypeId,
                                 @ApiParam(name = "clRemark", value = "备注", required = false) String clRemark,
                                 @ApiParam(name = "clMessage", value = "症状信息", required = false) String clMessage) {
        //创建客户
        Customer c = new Customer(cId, cName, cSex, cAge, cTel, cWx, null);
        //编辑客户
        iCustomerService.editCByCId(c);
        //创建线索
        Clue clue = new Clue(null, cId, clProject, null, clCity, clRemark, clEntryFee, null, clSource, clMessage, clTypeId, 0);
        //编辑线索
        iClueService.editClByCId(clue);
        //新增操作记录
        Operating operating = new Operating(cId, uId, "编辑信息", uName + "更新了" + cName + "的信息");
        iOperatingService.saveOperating(operating);
        return DataResult.success();
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
    @ApiOperation(value = "根据用户编号和客户名称查询可预约客户")
    @ResponseBody
    public Map<String, Object> queryCACByUIdAndCName(@ApiParam(value = "角色名称", required = true) String rName,
                                                     @ApiParam(value = "用户编号", required = true) Integer uId,
                                                     @ApiParam(value = "客户名称", required = true) String cName,
                                                     @ApiParam(value = "当前页码", required = true) Integer page) {
        Map<String, Object> map = new HashMap<>();
        List<Customer> customers = iCustomerService.queryCACByUIdAndCName(rName, uId, cName, (page - 1) * 4);
        for (Customer customer : customers){
            //根据线索编号查询预约
            List<Appointment> appointments = iAppointmentService.queryAByAClId(customer.getClId());
            if (appointments.size() == 0){
                customer.setAtType("初次预约");
            } else {
                customer.setAtType("普通预约");
            }
        }
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
        //根据客户编号查询最近预约
        Appointment appointment = iAppointmentService.queryLastAByClId(clId);
        if (appointment == null) {
            map.put("hId", "");
            map.put("hName", "");
            map.put("date", "");
        } else {
            map.put("hId", appointment.getaHId());
            map.put("hName", appointment.gethName());
            map.put("date", appointment.getaTime());
        }
        //根据线索编号查询成交金额
        Double successMoney = iSuccessService.queryTotalMoneyByClId(clId, 0);
        if (successMoney == null) {
            map.put("successMoney", 0);
        } else {
            BigDecimal b = new BigDecimal(successMoney);
            successMoney = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            map.put("successMoney", successMoney);
        }
        //根据线索编号查询已交金额
        Double payMoney = iSuccessService.queryTotalMoneyByClId(clId, 1);
        if (successMoney == null) {
            map.put("payMoney", 0);
        } else {
            BigDecimal b = new BigDecimal(payMoney);
            payMoney = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            map.put("payMoney", payMoney);
        }
        //待交金额
        if (successMoney != null && payMoney != null) {
            Double waitMoney = successMoney - payMoney;
            BigDecimal b = new BigDecimal(waitMoney);
            waitMoney = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            map.put("waitMoney", waitMoney);
        } else {
            map.put("waitMoney", 0);
        }
        //抵扣状态
        String status = "";
        if (c.getClEntryFee() != null){
            if (c.getClEntryFee().contains("已抵扣")){
                status = "已抵扣";
            } else if(c.getClEntryFee().contains("已退还")){
                status = "已退还";
            } else {
                status = "未抵扣";
            }
        }
        map.put("status", status);
        //退款金额
        Double refund = iSuccessService.queryRefundByClId(clId);
        if (refund == null){
            refund = 0.0;
        }
        map.put("refund", refund);
        //最后修改时间
        String s = iOperatingService.queryOpTimeByClId(clId);
        if (s == null) {
            map.put("editTime", "");
        } else {
            map.put("editTime", s);
        }
        //根据线索编号查询预约
        Integer maxAId = iAppointmentService.queryMaxAIdByClId(clId);
        if (maxAId != null){
            map.put("sAId", maxAId);
        } else {
            map.put("sAId", "");
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
        //未成交客户数量
        Integer failTotal = iCustomerService.getTotalFCByTime(uId, rName, beginTime, endTime);
        if (failTotal + success > 0){
            DecimalFormat df = new DecimalFormat("0.00");//格式化小数
            String num = df.format((float)success/(float)(failTotal+success)*100);
            percent = num + "%";
        } else {
            percent = "0%";
        }
        map.put("percent", percent);
        //客户成交金额
        Double successMoney = iSuccessService.queryMoneyByTime(uId, rName, beginTime, endTime, 0);
        if (successMoney != null){
            BigDecimal b = new BigDecimal(successMoney);
            successMoney = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        } else {
            successMoney = 0.0;
        }
        map.put("successMoney", successMoney);
        //平均客单价
        Double acup;
        if (success != 0){
            acup = Double.valueOf(successMoney/success);
            BigDecimal b = new BigDecimal(acup);
            acup = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        } else {
            acup = 0.0;
        }
        map.put("acup", acup);
        //客户实收金额
        Double payMoney = iSuccessService.queryMoneyByTime(uId, rName, beginTime, endTime, 1);
        if (payMoney != null){
            BigDecimal b = new BigDecimal(payMoney);
            payMoney = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        } else {
            payMoney = 0.0;
        }
        map.put("payMoney", payMoney);
        //客户待收金额
        Double awaitMoney = successMoney - payMoney;
        if (awaitMoney != 0){
            BigDecimal b = new BigDecimal(awaitMoney);
            awaitMoney = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
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
        return DataResult.success(total, customers);
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
        return DataResult.success(total, customers);
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
        return DataResult.success(total, customers);
    }

    @NoRepeatSubmit
    @PostMapping("arrive")
    @ApiOperation(value = "未到店")
    @ResponseBody
    public DataResult arrive(@ApiParam(value = "用户编号", required = true) Integer uId,
                             @ApiParam(value = "用户姓名", required = true) String uName,
                             @ApiParam(value = "客户编号", required = true) Integer cId,
                             @ApiParam(value = "客户姓名", required = true) String cName,
                             @ApiParam(value = "线索编号", required = true) Integer clId,
                             @ApiParam(value = "预约编号", required = true) Integer aId,
                             @ApiParam(value = "未到店原因", required = true) String cause) {
        //新增操作记录
        Operating operating = new Operating(cId, uId, "更新状态", uName + "更新了客户状态----" + cName + "(未到店）");
        iOperatingService.saveOperating(operating);
        //新增跟进记录
        Follow follow = new Follow(null, clId, 2, new Timestamp(System.currentTimeMillis()), cause, uId);
        iFollowService.saveFollow(follow);
        //根据客户状态查询编号
        Integer clTypeId = iCtypeService.queryCtypeByCtType("待预约");
        //改变客户状态为未到店状态
        iClueService.editClTypeIdByClId(clId, clTypeId);
        //根据预约编号编辑预约状态
        iAppointmentService.editAStatusByAIdAndAStatus(aId, 1);
        return DataResult.success();
    }

    @GetMapping("queryCByCNameAndCTel")
    @ApiOperation(value = "根据姓名和电话查询客户")
    @ResponseBody
    public DataResult queryCByCNameAndCTel(@ApiParam(value = "姓名", required = true) String cName,
                                           @ApiParam(value = "电话", required = true) String cTel) {
        List<Customer> customers = iCustomerService.queryCByCNameAndCTel(cName, cTel);
        if (customers.size() != 0) {
            return DataResult.error(403, "姓名和电话号码重复！");
        } else {
            return DataResult.success();
        }
    }

}
