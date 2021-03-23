package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
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
@RequestMapping("crm/authority")
@Api(value = "权限控制类", tags = "权限控制类")
public class AuthorityController {

    @Autowired
    private IRoleMenuService iRoleMenuService;

    @GetMapping("queryRMByRId")
    @ApiOperation(value = "根据角色编号查询权限")
    @ResponseBody
    public DataResult queryRMByRId(@ApiParam(value = "角色编号", required = true) Integer rId){
        List<RoleMenu> roleMenus = iRoleMenuService.queryRMByRId(rId);
        return DataResult.success(roleMenus);
    }

    @NoRepeatSubmit
    @GetMapping("editRMByRId")
    @ApiOperation(value = "根据角色编号编辑权限")
    @ResponseBody
    public DataResult editRMByRId(@ApiParam(value = "角色编号", required = true) Integer rId,
                                  @ApiParam(value = "菜单编号列表", required = true) String menuList){
        iRoleMenuService.delRMByRId(rId);
        String[] list = menuList.split(",");
        for (String s : list) {
            iRoleMenuService.saveRoleMenu(rId, Integer.parseInt(s));
        }
        return DataResult.success();
    }

}
