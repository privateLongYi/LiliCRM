package com.linxi.controller;

import com.linxi.config.security.PasswordConfig;
import com.linxi.entity.RoleMenu;
import com.linxi.entity.User;
import com.linxi.service.IRoleMenuService;
import com.linxi.service.IUserService;
import com.linxi.util.DataResult;
import com.linxi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author LongYi
 * @create 2020/7/31 20:03
 */
@Controller
@RequestMapping("user")
@Api(value = "用户控制类", tags = "用户控制类")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private PasswordConfig passwordConfig;

    @GetMapping("queryUserByRName")
    @ApiOperation(value = "获取角色为销售员的用户对象")
    @ResponseBody
    public DataResult queryUserByRName(){
        List<User> users = iUserService.queryUserByRName();
        return new DataResult(0, "操作成功",0 , users);
    }

    @GetMapping("queryRNameByRId")
    @ApiOperation(value = "根据角色编号查询角色名称")
    @ResponseBody
    public String queryRNameByRId(@ApiParam(name = "uRoleId", value = "角色编号", required = true) Integer uRoleId){
        return iUserService.queryRNameByRId(uRoleId);
    }

    @GetMapping("queryUserByUNameAndRId")
    @ApiOperation(value = "根据用户名和角色编号查询用户")
    @ResponseBody
    public DataResult queryUserByUNameAndRId(@ApiParam(name = "page", value = "页码", required = true) Integer page,
                                             @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit,
                                             @ApiParam(name = "uName", value = "用户名") String uName,
                                             @ApiParam(name = "uRoleId", value = "角色编号") Integer uRoleId){
        List<User> users = iUserService.queryUserByUNameAndRId((page-1)*limit, limit, uName, uRoleId);
        //获取总条数
        Integer total = iUserService.getTotalByUNameAndRId(uName, uRoleId);
        return new DataResult(0, "操作成功", total, users);
    }

    @PostMapping("saveUser")
    @ApiOperation(value = "新增用户")
    @ResponseBody
    public DataResult saveUser(@ApiParam(name = "uName", value = "用户名", required = true) String uName,
                               @ApiParam(name = "uPassword", value = "密码", required = true) String uPassword,
                               @ApiParam(name = "uRoleId", value = "角色编号", required = true) Integer uRoleId){
        User user = new User(uName, uPassword, uRoleId);
        //MD5加密
        user.setuPassword(passwordConfig.encode(user.getuPassword()));
        iUserService.saveUser(user);
        return new DataResult(0, "新增成功");
    }

}
