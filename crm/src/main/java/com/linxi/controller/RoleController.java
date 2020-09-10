package com.linxi.controller;

import com.linxi.entity.Menu;
import com.linxi.entity.Role;
import com.linxi.entity.RoleMenu;
import com.linxi.service.IMenuService;
import com.linxi.service.IRoleMenuService;
import com.linxi.service.IRoleService;
import com.linxi.util.DataResult;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private IRoleMenuService iRoleMenuService;

    @Autowired
    private IMenuService iMenuService;

    @GetMapping("queryRole")
    @ApiOperation(value = "查询所有角色")
    @ResponseBody
    public DataResult queryRole(){
        List<Role> roles = iRoleService.queryRole();
        return new DataResult(0, "操作成功", 0, roles);
    }

    @GetMapping("queryRByRName")
    @ApiOperation(value = "根据角色名查询角色")
    @ResponseBody
    public DataResult queryRByRName(@ApiParam(name = "rName", value = "角色名", required = true) String rName,
                                    @ApiParam(name = "page", value = "页码", required = true) Integer page,
                                    @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
        List<Role> roles = iRoleService.queryRByRName(rName, (page - 1) * limit, limit);
        Integer total = iRoleService.getTotalByRName(rName);
        return new DataResult(0, "操作成功", total, roles);
    }

    @PostMapping("saveRole")
    @ApiOperation(value = "新增角色")
    @ResponseBody
    public DataResult saveRole(@ApiParam(name = "rName", value = "角色名", required = true) String rName){
        iRoleService.saveRole(new Role(rName));
        return new DataResult(0, "新增成功");
    }

    @GetMapping("goDetail")
    @ApiOperation(value = "根据编号查询角色")
    public String goDetail(@ApiParam(name = "rId", value = "编号", required = true) Integer rId, ModelMap map){
        Role role = iRoleService.queryRByRId(rId);
        map.addAttribute("r", role);
        return "role/roledetail";
    }

    @GetMapping("delRByRId")
    @ApiOperation(value = "根据编号删除角色")
    @ResponseBody
    public DataResult delRByRId(@ApiParam(name = "rId", value = "编号", required = true) Integer rId){
        iRoleService.delRByRId(rId);
        return new DataResult(0, "删除成功");
    }

    @GetMapping("queryRByRId")
    @ApiOperation(value = "根据编号查询角色")
    public String queryRByRId(@ApiParam(name = "rId", value = "编号", required = true) Integer rId, ModelMap map){
        Role role = iRoleService.queryRByRId(rId);
        map.addAttribute("r", role);
        return "role/roleedit";
    }

    @PostMapping("editRByRId")
    @ApiOperation(value = "根据编号编辑角色")
    @ResponseBody
    public DataResult editRByRId(@ApiParam(name = "rId", value = "编号", required = true) Integer rId,
                                @ApiParam(name = "rName", value = "角色名", required = true) String rName){
        iRoleService.editRByRId(new Role(rId, rName));
        return new DataResult(0, "编辑成功");
    }

    @GetMapping("roleSetting")
    @ApiOperation(value = "根据角色编号查询角色菜单")
    @ResponseBody
    public List<Map<String, Object>> roleSetting(@ApiParam(name = "rId", value = "编号", required = true) Integer rId){
        //根据角色编号查询角色菜单
        List<RoleMenu> roleMenus = iRoleMenuService.queryRMByRId(rId);
        //创建树结构并返回
        return newTree(roleMenus, 0);
    }

    //获得树结构
    private List<Map<String, Object>> newTree(List<RoleMenu> roleMenus, Integer pId){
        //根据父级编号查询所有子级
        List<Menu> menus = iMenuService.queryMByMPId(pId);
        //创建list集合
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (Menu menu:menus
                ) {
            //创建map对象
            Map<String,Object> map = new HashMap<String, Object>();
            //加入节点数据
            map.put("id", menu.getmId());
            map.put("title", menu.getmName());
            map.put("spread", true);
            //判断是否具有该权限
            for (RoleMenu rm : roleMenus
                    ) {
                if (menu.getmId().equals(rm.getRmMId()) && menu.getChildCount() == 0) {
                    //添加选中状态
                    map.put("checked", true);
                }
            }
            //判断是否为有子节点
            if (menu.getChildCount() > 0){
                //递归加入子节点数据
                map.put("children", newTree(roleMenus, menu.getmId()));
            }
            //把数据加入到集合中
            list.add(map);
        }
        return list;
    }

}
