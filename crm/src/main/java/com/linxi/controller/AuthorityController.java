package com.linxi.controller;

import com.linxi.entity.Customer;
import com.linxi.entity.RoleMenu;
import com.linxi.service.IRoleMenuService;
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

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/24 20:02
 */
@Controller
@RequestMapping("menu")
@Api(value = "权限控制类", tags = "权限控制类")
public class AuthorityController {

    @Autowired
    private IRoleMenuService iRoleMenuService;

    @GetMapping("queryRoleMenuByRoleId")
    @ApiOperation(value = "查询权限")
    @ResponseBody
    public DataResult queryRoleMenuByRoleId(@ApiParam(value = "用户编号", required = true) Integer roleId){
        //根据用户编号查询权限
        List<RoleMenu> roleMenus = iRoleMenuService.queryRoleMenuByRoleId(roleId);
        return new DataResult(0, "操作成功", 0, roleMenus);
    }

}
