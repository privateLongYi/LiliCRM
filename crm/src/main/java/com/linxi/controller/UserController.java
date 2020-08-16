package com.linxi.controller;

import com.linxi.entity.User;
import com.linxi.service.IUserService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

    @PostMapping("login")
    @ApiOperation(value = "登录")
    @ResponseBody
    public DataResult login(@RequestBody @ApiParam(value = "用户对象", required = true) User user, HttpSession session){
        User u = iUserService.login(user);
        if (u != null) {
            //把对象存储到session中
            session.setAttribute("user", u);
            //设置session存活时间
            //session.setMaxInactiveInterval(30 * 60);
            return new DataResult(0, "登录成功", 0, null);
        } else {
            return new DataResult(1, "账号或密码错误",0 , null);
        }
    }

    @GetMapping("logout")
    @ApiOperation(value = "注销")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:../login.html";
    }

    @GetMapping("getUser")
    @ApiOperation(value = "获取用户对象")
    @ResponseBody
    public User getUser(HttpSession session){
        return (User) session.getAttribute("user");
    }

}
