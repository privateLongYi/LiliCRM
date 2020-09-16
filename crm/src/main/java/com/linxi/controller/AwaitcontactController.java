package com.linxi.controller;

import com.linxi.entity.Customer;
import com.linxi.service.ICtypeService;
import com.linxi.service.ICustomerService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/15 21:01
 */
@Controller
@RequestMapping("awaitcontact")
@Api(value = "待联系客户控制类", tags = "待联系客户控制类")
public class AwaitcontactController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICtypeService iCtypeService;

    @GetMapping("queryCScreen")
    @ApiOperation(value = "查询客户信息")
    @ResponseBody
    public DataResult queryCScreenByCTypeId(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                            @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                            @ApiParam(name = "uId", value = "用户编号", required = true) Integer uId,
                                            @ApiParam(name = "rName", value = "角色名称", required = true) String rName,
                                            @ApiParam(name = "ctType", value = "客户状态", required = true) String ctType,
                                            @ApiParam(name = "param", value = "筛选条件", required = false) String param){
        //姓名
        String cName = null;
        //电话
        String cTel = null;
        //报名项目
        String cProject = null;
        //是否交定金
        Integer cEarnest = null;
        //负责人编号
        Integer cUId = null;
        //来源
        String cSource = null;
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
        //根据客户状态查询编号
        Integer ctId = iCtypeService.queryCtypeByCtType(ctType);
        //根据筛选条件查询客户
        List<Customer> customeres = iCustomerService.queryCScreen(uId, rName, (page - 1) * limit, limit, cName, cTel, cProject, cEarnest, beginTime, endTime, cUId, cSource, ctId);
        //获取总条数
        Integer total = iCustomerService.getTotalByScreen(uId, rName, cName, cTel, cProject, cEarnest, beginTime, endTime, cUId, cSource, ctId);
        return new DataResult(0, "操作成功", total, customeres);
    }

}
