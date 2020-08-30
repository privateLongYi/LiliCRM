package com.linxi.controller;

import com.linxi.entity.Role;
import com.linxi.service.IRoleService;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/30 15:17
 */
@Controller
@RequestMapping("role")
@Api(value = "角色控制类", tags = "角色控制类")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @GetMapping("queryRole")
    @ApiOperation(value = "查询角色")
    @ResponseBody
    public DataResult queryRole(){
        List<Role> roles = iRoleService.queryRole();
        return new DataResult(0, "操作成功",0 , roles);
    }

}
