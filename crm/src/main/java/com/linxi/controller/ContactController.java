package com.linxi.controller;


import com.linxi.entity.Appointment;
import com.linxi.entity.Customer;
import com.linxi.entity.Operating;
import com.linxi.entity.User;
import com.linxi.service.IAppointmentService;
import com.linxi.service.ICustomerService;
import com.linxi.service.IOperatingService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("contact")
@Api(value = "待联系人控制类", tags = "待联系人控制类")
public class ContactController {


    /**
     * 客户信息表
     */
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private IAppointmentService iAppointmentService;

    //获取HttpServletRequest对象
    @Autowired HttpServletRequest request;



    @GetMapping("goAppointment")
    @ApiOperation(value = "去往预约页面")
    public String goAppointment(String message){


        request.setAttribute("message",message);

       return "customer/contactappoint";
    }
    /**
     * 新增预约用户
     * @param appoin
     * @param cmessage
     * @return
     */
    @GetMapping("addContactAppoint")
    @ApiOperation(value = "新增预约用户")
    @ResponseBody
    public  DataResult  addContactAppoint(@ApiParam(name = "appoin", value = "客户预约类", required = true) Appointment appoin,
                                        @ApiParam(name = "cmessage", value = "症状信息", required = true) String cmessage){


        try {
            appoin.getaCId();
            appoin.getaHId();
            appoin.getaTime();
            appoin.getaTypeId();
        } catch (Exception e) {
            return new DataResult(400, "参数错误");
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            user.getuId();
        } catch (Exception e) {
            return new DataResult(400, "请重新登陆");
        }
            //操作记录表
            Operating operating = new Operating();
            operating.setOpUId(user.getuId());
            operating.setPoCId(appoin.getaCId());

            operating.setOpName("待联系更改为已预约");
            //新增预约客户
            iAppointmentService.addAppoint(appoin);
            //根据编号修改客户状态
            iCustomerService.editCStatuByCId(appoin.getaCId(),4);
            //添加操作记录
            Integer integer = iOperatingService.addOperatingRecord(operating);

            return new DataResult(integer, "操作成功");

    }


    @GetMapping("dateContactStatu")
    @ApiOperation(value = "修改客户状态")
    @ResponseBody
    public  DataResult dateContactStatu(@ApiParam(name = "cid", value = "客户id", required = true) Integer cid,
                                        @ApiParam(name = "cstatu", value = "客户状态Id", required = true) Integer cstatu){
        HttpSession session = request.getSession();

        if (session==null) return new DataResult(400, "请重新登陆");
        User user = (User) session.getAttribute("user");
        if (user!=null){
            //操作记录表
            Operating operating = new Operating();
            operating.setOpUId(user.getuId());
            operating.setPoCId(cid);
            if (cstatu==3){
                operating.setOpName("待联系更改为待预约");
            }else if(cstatu==4){
                operating.setOpName("待联系更改为已预约");
            }
            //根据编号修改客户状态
            iCustomerService.editCStatuByCId(cid,cstatu);
            //添加操作记录
            Integer integer = iOperatingService.addOperatingRecord(operating);

            return new DataResult(integer, "操作成功");

        }else{
            return new DataResult(400, "请重新登陆");
        }
    }

    @GetMapping("queryContactAll")
    @ApiOperation(value = "查询全部待联系客户信息")
    @ResponseBody
    public  DataResult queryContactAll(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                       @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
//
         List<Customer> customers = iCustomerService.queryCScreen(0, "", (page - 1) * limit, limit, null, null, null, null, null, null, null, null, null, 2);

        //获取总条数
        Integer total = iCustomerService.getTotalByType(2);
        return new DataResult(0, "操作成功", total, customers);
    }


    @GetMapping("queryContactWhere")
    @ApiOperation(value = "条件查询查询客户信息")
    @ResponseBody
    public DataResult queryContactWhere(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                   @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
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
        //状态
        Integer cTypeId = null;
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
                } else if (screen[0].trim().equals("cTypeId")) {
                    cTypeId = Integer.parseInt(screen[1].trim());
                } else if (screen[0].trim().equals("beginTime")) {
                    beginTime = screen[1].trim();
                } else if (screen[0].trim().equals("endTime")) {
                    endTime = screen[1].trim();
                }
            }
        }

        //根据筛选条件查询客户
        List<Customer> customeres = iCustomerService.queryCScreen(0, "", (page-1)*limit, limit, cName, cTel, cProject, hId, cEarnest, beginTime, endTime, cUId, cSource, 2);
        //获取总条数

        Integer total = iCustomerService.getTotalByScreen(0, "", cName, cTel, cProject, hId, cEarnest, beginTime, endTime, cUId, cSource, 2);
        return new DataResult(0, "操作成功", total, customeres);
    }




}
