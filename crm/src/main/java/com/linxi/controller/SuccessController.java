package com.linxi.controller;

import com.linxi.entity.*;
import com.linxi.service.*;
import com.linxi.util.DataResult;
import com.linxi.vo.SuccessStatisticsVo;
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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private IAppointmentService iAppointmentService;

    @Autowired
    private IClueService iClueService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IHospitalService iHospitalService;

    @Autowired
    private IPayrecordService iPayrecordService;

    @Autowired
    private IPaytypeService iPaytypeService;

    @Autowired
    private IFollowService iFollowService;

    @Autowired
    private IAtypeService iAtypeService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("querySByClId")
    @ApiOperation(value = "根据线索编号查询成交客户")
    @ResponseBody
    public DataResult querySByClId(@ApiParam(value = "线索编号", required = true) Integer clId,
                                   @ApiParam(value = "页码", required = true) Integer page,
                                   @ApiParam(value = "显示条数", required = true) Integer limit){
        List<Success> successes = iSuccessService.querySByClId(clId, (page - 1) * limit, limit);
        Integer total = iSuccessService.getTotalByClId(clId);
        return new DataResult(0, "操作成功", total, successes);
    }

    @GetMapping("delSBySId")
    @ApiOperation(value = "根据成交客户编号删除成交客户")
    @ResponseBody
    public DataResult delSBySId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                @ApiParam(value = "成交客户编号", required = true) Integer sId){
        //新增操作记录
        Operating operating = new Operating(sId, uId, "删除了成交客户", "");
        iOperatingService.saveOperating(operating);
        //删除成交客户
        iSuccessService.delSBySId(sId);
        return new DataResult(0, "操作成功");
    }

    @GetMapping("querySBySId")
    @ApiOperation(value = "根据成交客户编号查询成交客户")
    public String querySBySCId(@ApiParam(value = "成交客户编号", required = true) Integer sId,
                               @ApiParam(value = "客户编号", required = true) Integer cId,
                               ModelMap map){
        Success success = iSuccessService.querySBySId(sId);
        map.addAttribute("s", success);
        map.addAttribute("cId", cId);
        return "success/successedit";
    }

    @PostMapping("editSBySId")
    @ApiOperation(value = "根据成交客户编号编辑成交客户")
    @ResponseBody
    public DataResult editSBySId(@ApiParam(value = "用户编号", required = true) Integer uId,
                                 @ApiParam(value = "用户姓名", required = true) String uName,
                                 @ApiParam(value = "客户姓名", required = true) String cName,
                                 @ApiParam(value = "客户编号", required = true) Integer cId,
                                 @ApiParam(value = "成交编号", required = true) Integer sId,
                                 @ApiParam(value = "成交客户编号", required = true) Integer sAId,
                                 @ApiParam(value = "门诊编号", required = true) Integer sHId,
                                 @ApiParam(value = "成交信息", required = true) String sMessage,
                                 @ApiParam(value = "总成交金额", required = true) Integer sSum,
                                 @ApiParam(value = "成交备注", required = true) String sRemark){
        //新增操作记录
        Operating operating = new Operating(cId, uId, "编辑成交", uName + "更新了客户" + cName + "的成交信息");
        iOperatingService.saveOperating(operating);
        //编辑成交客户
        Success success = new Success(sId, sAId, sHId, sMessage, sSum, null, sRemark, 0);
        iSuccessService.editSBySId(success);
        return new DataResult(0, "编辑成功");
    }

    @PostMapping("saveSuccess")
    @ApiOperation(value = "新增成交客户")
    @ResponseBody
    public DataResult saveSuccess(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                  @ApiParam(name = "uName", value = "用户姓名", required = true) String uName,
                                  @ApiParam(name = "cName", value = "客户姓名", required = true) String cName,
                                  @ApiParam(name = "cId", value = "客户编号", required = true) Integer cId,
                                  @ApiParam(name = "clId", value = "线索编号", required = true) Integer clId,
                                  @ApiParam(name = "sAId", value = "预约编号", required = true) Integer sAId,
                                  @ApiParam(name = "sHId", value = "门诊编号", required = true) Integer sHId,
                                  @ApiParam(name = "sMessage", value = "成交信息", required = true) String sMessage,
                                  @ApiParam(name = "isDeduction", value = "抵扣报名费", required = true) String isDeduction,
                                  @ApiParam(name = "sSum", value = "成交金额", required = true) Integer sSum,
                                  @ApiParam(name = "sPaysum", value = "支付金额", required = true) Integer sPaysum,
                                  @ApiParam(name = "sRemark", value = "备注", required = true) String sRemark){
        //添加操作记录
        Operating operating = new Operating(cId, uId, "新增成交项目", uName + "给" + cName + "添加了一条新成交");
        iOperatingService.saveOperating(operating);
        //新增跟进记录
        Follow follow = new Follow(null, clId, 1, new Timestamp(System.currentTimeMillis()), sMessage, uId);
        iFollowService.saveFollow(follow);
        //根据客户状态查询编号
        Integer clTypeId = iCtypeService.queryCtypeByCtType("成交");
        //改变客户状态为成交状态
        iClueService.editClTypeIdByClId(clId, clTypeId);
        //编辑报名费为已抵扣
        if (isDeduction.equals("1")){
            //根据线索编号查询线索
            Clue clue = iClueService.queryClByClId(clId);
            iClueService.editClByClId(clId, clue.getClEntryFee() + "(已抵扣)");
        }
        //新增成交客户
        Success success = new Success(null, sAId, sHId, sMessage, sSum, sPaysum, sRemark, 0);
        iSuccessService.saveSuccess(success);
        //根据预约编号编辑预约状态
        iAppointmentService.editAStatusByAIdAndAStatus(sAId, 2);
        if (sPaysum != 0){
            //查询最大的成交编号
            Integer sId = iSuccessService.queryMaxSId();
            //查询支付类型为退款的编号
            Integer payId = iPaytypeService.queryPByPayType("首次缴费");
            //新增支付记录
            Payrecord payrecord = new Payrecord(null, sId, sPaysum, null, null, payId);
            iPayrecordService.savePayrecord(payrecord);
        }
        return new DataResult(0, "新增成功");
    }

    @GetMapping("querySByScreen")
    @ApiOperation(value = "根据筛选条件查询成交客户")
    @ResponseBody
    public DataResult querySByScreen(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                     @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                     @ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                     @ApiParam(name = "rName", value = "角色名称", required = true) String rName,
                                     @ApiParam(name = "cName", value = "客户名字", required = true) String cName,
                                     @ApiParam(name = "cTel", value = "客户电话", required = true) String cTel,
                                     @ApiParam(name = "sHId", value = "成交门诊编号", required = true) Integer sHId,
                                     @ApiParam(name = "queryUId", value = "用户编号", required = true) Integer queryUId,
                                     @ApiParam(name = "beginTime", value = "开始时间", required = true) String beginTime,
                                     @ApiParam(name = "endTime", value = "结束时间", required = true) String endTime,
                                     @ApiParam(name = "export", value = "是否导出", required = true) Integer export){
        List<Success> fails = iSuccessService.querySByScreen((page-1)*limit, limit, uId, rName, cName, cTel, sHId, queryUId, beginTime, endTime, export);
        Integer total = iSuccessService.getTotalByScreen(uId, rName, cName, cTel, sHId, queryUId, beginTime, endTime);
        return new DataResult(0, "操作成功", total, fails);
    }

    @PostMapping("querySCByUIdAndCName")
    @ApiOperation(value = "根据用户编号和客户名称查询成交客户")
    @ResponseBody
    public Map<String, Object> querySCByUIdAndCName(@ApiParam(value = "角色名称", required = true) String rName,
                                                    @ApiParam(value = "用户编号", required = true) Integer uId,
                                                    @ApiParam(value = "客户名称", required = true) String cName,
                                                    @ApiParam(value = "当前页码", required = true) Integer page){
        Map<String, Object> map = new HashMap<>();
        List<Success> successes = iSuccessService.querySCByUIdAndCName(rName, uId, cName, (page - 1) * 4);
        Integer total = iSuccessService.getTotalSCByUIdAndCName(rName, uId, cName);
        if (total == null){
            total = 0;
        } else {
            if (total%4 != 0){
                total = (total/4) + 1;
            } else {
                total = total/4;
            }
        }
        map.put("data", successes);
        map.put("count", total);
        return map;
    }

    @GetMapping("getGruopByUNameSSum")
    @ApiOperation(value = "获取分组成交总金额")
    @ResponseBody
    public DataResult getGruopByUNameSSum(@ApiParam(value = "页码", required = true) Integer page,
                                          @ApiParam(value = "显示条数", required = true) Integer limit,
                                          @ApiParam(value = "统计单位", required = true) String unit,
                                          @ApiParam(value = "开始时间", required = true) String beginTime,
                                          @ApiParam(value = "结束时间", required = true) String endTime){
        //创建列表
        List<SuccessStatisticsVo> list = new ArrayList<>();
        if (unit.equals("负责人")){
            //查询所有销售员
            List<User> users = iUserService.queryUserByRName();
            //分组获取在起止时间内有成交额的用户
            List<Success> successes = iSuccessService.querySSumGruopByUId(beginTime, endTime);
            for (User user : users){
                Boolean b = false;
                for (Success success : successes){
                    if (user.getuName().equals(success.getuName())){
                        list.add(new SuccessStatisticsVo(user.getuName(), success.getTotalSum()));
                        b = true;
                        break;
                    }
                }
                if (b == false){
                    list.add(new SuccessStatisticsVo(user.getuName(), 0));
                }
            }
        } else if(unit.equals("门诊")){
            //获取所有门诊
            List<Hospital> hospitals = iHospitalService.queryHospital();
            //分组获取在起止时间内有成交额的门诊
            List<Success> successes = iSuccessService.querySSumGruopByHId(beginTime, endTime);
            for (Hospital hospital : hospitals){
                Boolean b = false;
                for (Success success : successes){
                    if (hospital.gethName().equals(success.gethName())){
                        list.add(new SuccessStatisticsVo(hospital.gethName(), success.getTotalSum()));
                        b = true;
                        break;
                    }
                }
                if (b == false){
                    list.add(new SuccessStatisticsVo(hospital.gethName(), 0));
                }
            }
        } else {
            //所有报名项目
            List<String> projectes = new ArrayList<>();
            projectes.add("种植牙");
            projectes.add("隐形矫正");
            projectes.add("其他");
            //分组获取在起止时间内有成交额的报名项目
            List<Success> successes = iSuccessService.querySSumGruopByCProject(beginTime, endTime);
            for (String project : projectes){
                Boolean b = false;
                for (Success success : successes){
                    if (project.equals(success.getProject())){
                        list.add(new SuccessStatisticsVo(project, success.getTotalSum()));
                        b = true;
                        break;
                    }
                }
                if (b == false){
                    list.add(new SuccessStatisticsVo(project, 0));
                }
            }
        }
        if (page == null && limit == null){
            return new DataResult(0, "操作成功", list.size(), list);
        } else {
            //分页获取数据
            List<SuccessStatisticsVo> newList = new ArrayList<>();
            for (int i = (page-1)*limit; i < (page-1)*limit+limit; i++){
                if (i < list.size()){
                    newList.add(list.get(i));
                }
            }
            return new DataResult(0, "操作成功", list.size(), newList);
        }
    }

    @GetMapping("refundMoney")
    @ApiOperation(value = "退款")
    @ResponseBody
    public DataResult refundMoney(@ApiParam(value = "用户编号", required = true) Integer uId,
                                  @ApiParam(value = "用户姓名", required = true) String uName,
                                  @ApiParam(value = "客户编号", required = true) Integer cId,
                                  @ApiParam(value = "客户姓名", required = true) String cName,
                                  @ApiParam(value = "成交客户编号", required = true) Integer paySId,
                                  @ApiParam(value = "成交退款金额", required = true) Integer refundsSum,
                                  @ApiParam(value = "支付退款金额", required = true) Integer refundsPaysum,
                                  @ApiParam(value = "备注", required = false) String payRemark,
                                  @ApiParam(value = "支付类型", required = true) Integer payTypeId,
                                  @ApiParam(value = "退款金额", required = true) Integer paySum){
        //根据成交编号编辑成交金额和支付金额
        iSuccessService.editMoneyBySId(paySId, refundsSum, refundsPaysum);
        if (refundsSum != 0){
            //拼接备注
            payRemark = payRemark + "(扣除成交金额" + paySum + ")";
        }
        //新增支付记录
        Payrecord payrecord = new Payrecord(null, paySId, paySum, null, payRemark, payTypeId);
        iPayrecordService.savePayrecord(payrecord);
        //新增操作记录
        Operating operating = new Operating(cId, uId, "退款", uName + "处理了客户" + cName + "的退款");
        iOperatingService.saveOperating(operating);
        return new DataResult(0, "操作成功");
    }

    @GetMapping("querySDetailByScreen")
    @ApiOperation(value = "根据筛选条件查询成交明细")
    @ResponseBody
    public Map<String, Object> querySDetailByScreen(@ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                           @ApiParam(name = "rName", value = "角色名称", required = true) String rName,
                                           @ApiParam(name = "cName", value = "客户名字", required = true) String cName,
                                           @ApiParam(name = "cTel", value = "客户电话", required = true) String cTel,
                                           @ApiParam(name = "sHId", value = "成交门诊编号", required = true) Integer sHId,
                                           @ApiParam(name = "queryUId", value = "用户编号", required = true) Integer queryUId,
                                           @ApiParam(name = "beginTime", value = "开始时间", required = true) String beginTime,
                                           @ApiParam(name = "endTime", value = "结束时间", required = true) String endTime){
        Map<String, Object> map = new HashMap<>();
        //根据筛选条件查询成交总数
        Integer total = iSuccessService.getTotalByScreen(uId, rName, cName, cTel, sHId, queryUId, beginTime, endTime);
        if (total == null){
            total = 0;
        }
        map.put("count", total);
        //根据筛选条件查询成交金额
        Integer sSum = iSuccessService.queryMoneyByScreen(uId, rName, cName, cTel, sHId, queryUId, beginTime, endTime, 0);
        if (sSum == null){
            sSum = 0;
        }
        map.put("sSum", sSum);
        //根据筛选条件查询支付金额
        Integer sPaysum = iSuccessService.queryMoneyByScreen(uId, rName, cName, cTel, sHId, queryUId, beginTime, endTime, 1);
        if (sPaysum == null){
            sPaysum = 0;
        }
        map.put("sPaysum", sPaysum);
        //待收金额
        Integer awaitMoney = sSum - sPaysum;
        map.put("awaitMoney", awaitMoney);
        //根据筛选条件分组查询退款总金额
        List<Success> successes = iSuccessService.queryRefundByScreen(uId, rName, cName, cTel, sHId, queryUId, beginTime, endTime);
        //退款总数
        Integer refundCount = 0;
        //退款总金额
        Integer refundMoney = 0;
        if (successes != null){
            refundCount = successes.size();
            for (Success success : successes){
                refundMoney += success.getRefund();
            }
        }
        map.put("refundCount", refundCount);
        map.put("refundMoney", refundMoney);
        return map;
    }

    @GetMapping("querySByTime")
    @ApiOperation(value = "根据起止时间查询成交")
    @ResponseBody
    public DataResult queryAByTime(@ApiParam(value = "页码", required = true) Integer page,
                                   @ApiParam(value = "显示条数", required = true) Integer limit,
                                   @ApiParam(value = "用户编号", required = true) Integer uId,
                                   @ApiParam(value = "角色名称", required = true) String rName,
                                   @ApiParam(value = "开始时间", required = true) String beginTime,
                                   @ApiParam(value = "结束时间", required = true) String endTime) {
        List<Success> successes = iSuccessService.querySByTime((page - 1) * limit, limit, uId, rName, beginTime, endTime);
        Integer total = iSuccessService.getTotalByTime(uId, rName, beginTime, endTime);
        return new DataResult(0, "操作成功", total, successes);
    }

    @PostMapping("saveCAndAAndS")
    @ApiOperation(value = "新增客户信息和预约信息和成交信息")
    @ResponseBody
    public DataResult saveCAndAAndS(@ApiParam(name = "uId", value = "操作用户编号", required = true) Integer uId,
                                    @ApiParam(name = "uName", value = "操作用户姓名", required = true) String uName,
                                    @ApiParam(name = "cName", value = "姓名", required = true) String cName,
                                    @ApiParam(name = "cSex", value = "性别", required = true) String cSex,
                                    @ApiParam(name = "cAge", value = "年龄", required = false) Integer cAge,
                                    @ApiParam(name = "cTel", value = "电话", required = true) String cTel,
                                    @ApiParam(name = "cWx", value = "微信号", required = true) String cWx,
                                    @ApiParam(name = "clProject", value = "报名项目", required = true) String clProject,
                                    @ApiParam(name = "clPlaceTime", value = "报名时间", required = true) String clPlaceTime,
                                    @ApiParam(name = "clEntryFee", value = "报名费", required = false) String clEntryFee,
                                    @ApiParam(name = "clUId", value = "用户编号", required = true) Integer clUId,
                                    @ApiParam(name = "clSource", value = "来源", required = false) String clSource,
                                    @ApiParam(name = "clTypeId", value = "状态编号", required = true) Integer clTypeId,
                                    @ApiParam(name = "clRemark", value = "备注", required = false) String clRemark,
                                    @ApiParam(name = "clMessage", value = "症状信息", required = false) String clMessage,
                                    @ApiParam(name = "aTime", value = "预约时间", required = false) String aTime,
                                    @ApiParam(name = "aHId", value = "预约门诊编号", required = false) Integer aHId,
                                    @ApiParam(name = "atType", value = "预约类型", required = false) String atType,
                                    @ApiParam(name = "sHId", value = "成交门诊编号", required = true) Integer sHId,
                                    @ApiParam(name = "sMessage", value = "成交信息", required = true) String sMessage,
                                    @ApiParam(name = "isDeduction", value = "抵扣报名费", required = true) String isDeduction,
                                    @ApiParam(name = "sSum", value = "成交金额", required = true) Integer sSum,
                                    @ApiParam(name = "sPaysum", value = "支付金额", required = true) Integer sPaysum,
                                    @ApiParam(name = "sRemark", value = "备注", required = true) String sRemark) {
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
        Clue clue = new Clue(null, c.getcId(), clProject, Timestamp.valueOf(clPlaceTime), clRemark, clEntryFee, clUId, clSource, clMessage, clTypeId, 0);
        iClueService.saveClue(clue);
        //新增操作记录
        Operating operating = new Operating(c.getcId(), uId, "新增", uName + "添加了客户" + cName);
        iOperatingService.saveOperating(operating);
        //根据客户状态查询编号
        Integer clTypeId2 = iCtypeService.queryCtypeByCtType("待到店");
        //改变客户状态为待到店状态
        iClueService.editClTypeIdByClId(clue.getClId(), clTypeId2);
        //根据预约类型查询编号
        Integer aTypeId = iAtypeService.queryAByAType(atType);
        //新增预约客户
        Appointment appointment = new Appointment(null, clue.getClId(), Timestamp.valueOf(aTime), aHId, aTypeId, 0, null);
        iAppointmentService.saveAppointment(appointment);
        //根据线索编号查询客户
        Customer customer = iCustomerService.queryCByClId(clue.getClId());
        //根据门诊编号查询门诊
        Hospital hospital = iHospitalService.queryHByHId(aHId);
        //新增操作记录
        Operating operating1 = new Operating(customer.getcId(), uId, "预约", uName + "为" + customer.getcName() + "预约了" + hospital.gethName());
        iOperatingService.saveOperating(operating1);
        //添加操作记录
        Operating operating2 = new Operating(customer.getcId(), uId, "新增成交项目", uName + "给" + cName + "添加了一条新成交");
        iOperatingService.saveOperating(operating2);
        //新增跟进记录
        Follow follow = new Follow(null, clue.getClId(), 1, new Timestamp(System.currentTimeMillis()), sMessage, uId);
        iFollowService.saveFollow(follow);
        //根据客户状态查询编号
        Integer clTypeId3 = iCtypeService.queryCtypeByCtType("成交");
        //改变客户状态为成交状态
        iClueService.editClTypeIdByClId(clue.getClId(), clTypeId3);
        //编辑报名费为已抵扣
        if (isDeduction.equals("1")){
            //根据线索编号查询线索
            Clue clue2 = iClueService.queryClByClId(clue.getClId());
            iClueService.editClByClId(clue.getClId(), clue2.getClEntryFee() + "(已抵扣)");
        }
        //新增成交客户
        Success success = new Success(null, appointment.getaId(), sHId, sMessage, sSum, sPaysum, sRemark, 0);
        iSuccessService.saveSuccess(success);
        //根据预约编号编辑预约状态
        iAppointmentService.editAStatusByAIdAndAStatus(appointment.getaId(), 2);
        if (sPaysum != 0){
            //查询最大的成交编号
            Integer sId = iSuccessService.queryMaxSId();
            //查询支付类型为退款的编号
            Integer payId = iPaytypeService.queryPByPayType("首次缴费");
            //新增支付记录
            Payrecord payrecord = new Payrecord(null, sId, sPaysum, null, null, payId);
            iPayrecordService.savePayrecord(payrecord);
        }
        return new DataResult(0, "新增成功");
    }

    @PostMapping("saveAAndS")
    @ApiOperation(value = "新增预约信息和成交信息")
    @ResponseBody
    public DataResult saveAAndS(@ApiParam(name = "uId", value = "操作用户编号", required = true) Integer uId,
                                @ApiParam(name = "uName", value = "操作用户姓名", required = true) String uName,
                                @ApiParam(name = "aClId", value = "线索编号", required = true) Integer aClId,
                                @ApiParam(name = "aTime", value = "预约时间", required = false) String aTime,
                                @ApiParam(name = "aHId", value = "预约门诊编号", required = false) Integer aHId,
                                @ApiParam(name = "atType", value = "预约类型", required = false) String atType,
                                @ApiParam(name = "sHId", value = "成交门诊编号", required = true) Integer sHId,
                                @ApiParam(name = "sMessage", value = "成交信息", required = true) String sMessage,
                                @ApiParam(name = "isDeduction", value = "抵扣报名费", required = true) String isDeduction,
                                @ApiParam(name = "sSum", value = "成交金额", required = true) Integer sSum,
                                @ApiParam(name = "sPaysum", value = "支付金额", required = true) Integer sPaysum,
                                @ApiParam(name = "sRemark", value = "备注", required = true) String sRemark) {
        //根据客户状态查询编号
        Integer clTypeId = iCtypeService.queryCtypeByCtType("待到店");
        //改变客户状态为待到店状态
        iClueService.editClTypeIdByClId(aClId, clTypeId);
        //根据预约类型查询编号
        Integer aTypeId = iAtypeService.queryAByAType(atType);
        //新增预约客户
        Appointment appointment = new Appointment(null, aClId, Timestamp.valueOf(aTime), aHId, aTypeId, 0, null);
        iAppointmentService.saveAppointment(appointment);
        //根据线索编号查询客户
        Customer customer = iCustomerService.queryCByClId(aClId);
        //根据门诊编号查询门诊
        Hospital hospital = iHospitalService.queryHByHId(aHId);
        //新增操作记录
        Operating operating1 = new Operating(customer.getcId(), uId, "预约", uName + "为" + customer.getcName() + "预约了" + hospital.gethName());
        iOperatingService.saveOperating(operating1);
        //添加操作记录
        Operating operating2 = new Operating(customer.getcId(), uId, "新增成交项目", uName + "给" + customer.getcName() + "添加了一条新成交");
        iOperatingService.saveOperating(operating2);
        //新增跟进记录
        Follow follow = new Follow(null, aClId, 1, new Timestamp(System.currentTimeMillis()), sMessage, uId);
        iFollowService.saveFollow(follow);
        //根据客户状态查询编号
        Integer clTypeId3 = iCtypeService.queryCtypeByCtType("成交");
        //改变客户状态为成交状态
        iClueService.editClTypeIdByClId(aClId, clTypeId3);
        //编辑报名费为已抵扣
        if (isDeduction.equals("1")){
            //根据线索编号查询线索
            Clue clue2 = iClueService.queryClByClId(aClId);
            iClueService.editClByClId(aClId, clue2.getClEntryFee() + "(已抵扣)");
        }
        //新增成交客户
        Success success = new Success(null, appointment.getaId(), sHId, sMessage, sSum, sPaysum, sRemark, 0);
        iSuccessService.saveSuccess(success);
        //根据预约编号编辑预约状态
        iAppointmentService.editAStatusByAIdAndAStatus(appointment.getaId(), 2);
        if (sPaysum != 0){
            //查询最大的成交编号
            Integer sId = iSuccessService.queryMaxSId();
            //查询支付类型为退款的编号
            Integer payId = iPaytypeService.queryPByPayType("首次缴费");
            //新增支付记录
            Payrecord payrecord = new Payrecord(null, sId, sPaysum, null, null, payId);
            iPayrecordService.savePayrecord(payrecord);
        }
        return new DataResult(0, "新增成功");
    }

}
