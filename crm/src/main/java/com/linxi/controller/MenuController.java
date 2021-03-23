package com.linxi.controller;

import com.linxi.anno.NoRepeatSubmit;
import com.linxi.entity.Menu;
import com.linxi.service.IMenuService;
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

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/7 20:15
 */
@Controller
@RequestMapping("crm/menu")
@Api(value = "菜单控制类", tags = "菜单控制类")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;

    @GetMapping("queryMByMName")
    @ApiOperation(value = "根据菜单名称查询菜单")
    @ResponseBody
    public DataResult queryMByMName(@ApiParam(name = "mName", value = "菜单名称", required = true) String mName,
                                    @ApiParam(name = "page", value = "页码", required = true) Integer page,
                                    @ApiParam(name = "limit", value = "显示条数", required = true) Integer limit){
        List<Menu> menus = iMenuService.queryMByMName(mName, (page - 1) * limit, limit);
        Integer total = iMenuService.getTotalByMName(mName);
        return DataResult.success(total, menus);
    }

    @GetMapping("queryMParent")
    @ApiOperation(value = "查询父级菜单")
    @ResponseBody
    public DataResult queryMParent(){
        List<Menu> menus = iMenuService.queryMParent();
        return DataResult.success(menus);
    }

    @NoRepeatSubmit
    @PostMapping("saveMenu")
    @ApiOperation(value = "新增菜单")
    @ResponseBody
    public DataResult saveMenu(@ApiParam(name = "mName", value = "菜单名称", required = true) String mName,
                               @ApiParam(name = "mUrl", value = "菜单路径", required = true) String mUrl,
                               @ApiParam(name = "mParentId", value = "菜单父级编号", required = false) Integer mParentId,
                               @ApiParam(name = "mType", value = "菜单类型", required = true) String mType,
                               @ApiParam(name = "mNavgition", value = "菜单导航文本", required = true) String mNavgition){
        iMenuService.saveMenu(new Menu(null, mName, mUrl, mParentId, mType, mNavgition));
        return DataResult.success();
    }

    @NoRepeatSubmit
    @GetMapping("delMByMId")
    @ApiOperation(value = "根据编号删除菜单")
    @ResponseBody
    public DataResult delMByMId(@ApiParam(name = "mId", value = "编号", required = true) Integer mId){
        iMenuService.delMByMId(mId);
        return DataResult.success();
    }

    @GetMapping("queryMByMId")
    @ApiOperation(value = "根据编号查询菜单")
    public String queryMByMId(@ApiParam(name = "mId", value = "编号", required = true) Integer mId, ModelMap map){
        Menu menu = iMenuService.queryMByMId(mId);
        map.addAttribute("m", menu);
        return "menu/menuedit";
    }

    @NoRepeatSubmit
    @PostMapping("editMByMId")
    @ApiOperation(value = "根据编号编辑菜单")
    @ResponseBody
    public DataResult editMByMId(@ApiParam(name = "mId", value = "菜单名称", required = true) Integer mId,
                                 @ApiParam(name = "mName", value = "菜单名称", required = true) String mName,
                                 @ApiParam(name = "mUrl", value = "菜单路径", required = true) String mUrl,
                                 @ApiParam(name = "mParentId", value = "菜单父级编号", required = false) Integer mParentId,
                                 @ApiParam(name = "mType", value = "菜单类型", required = true) String mType,
                                 @ApiParam(name = "mNavgition", value = "菜单导航文本", required = true) String mNavgition){
        iMenuService.editMByMId(new Menu(mId, mName, mUrl, mParentId, mType, mNavgition));
        return DataResult.success();
    }

}
