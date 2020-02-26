package com.uxunchina.taling.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uxunchina.taling.common.controller.BaseController;
import com.uxunchina.taling.common.entity.DataResponse;
import com.uxunchina.taling.system.entity.SysPermission;
import com.uxunchina.taling.system.service.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenfeng
 * @since 2019-12-05
 */
@Api("菜单/按钮管理")
@Controller
@RequestMapping("/sysPermission")
public class SysPermissionController extends BaseController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @ApiOperation("进入菜单/按钮/按钮管理页面")
    @GetMapping("sysPermissionList")
    public String sysPermissionList(Model model){
        QueryWrapper<SysPermission> ew = new QueryWrapper<SysPermission>();
        ew.eq("resource_type","0");
        List<SysPermission> data = sysPermissionService.list(ew);
        model.addAttribute("menu",data);
        return "system/menu";
    }

    @ApiOperation("查询菜单/按钮信息")
    @ResponseBody
    @GetMapping("list")
    public DataResponse sysPermission(){
        QueryWrapper<SysPermission> ew = new QueryWrapper<SysPermission>();
        List<SysPermission> data = sysPermissionService.list(ew);
        ew.orderByAsc("orderNum");
        return new DataResponse().success().count((long) data.size()).data(data).message("查询菜单/按钮成功");
    }

    @ApiOperation("新增菜单/按钮")
    @ResponseBody
    @PostMapping("createSysPermission")
    public DataResponse createSysPermission(@Valid SysPermission sysPermission){
        this.sysPermissionService.createSyspermission(sysPermission);
        return new DataResponse().success().message("新增菜单/按钮成功");
    }

    @ApiOperation("修改菜单/按钮")
    @ResponseBody
    @PostMapping("updateSysPermission")
    public DataResponse updateSysPermission(SysPermission sysPermission){
        if(StringUtils.isBlank(sysPermission.getPermissionId().toString())){
            return new DataResponse().fail().message("传入参数有误");
        }
        this.sysPermissionService.updateSysPermission(sysPermission);
        return new DataResponse().success().message("修改菜单/按钮成功");
    }

    @ApiOperation("删除菜单/按钮")
    @ResponseBody
    @PostMapping("deleteSysPermission")
    public DataResponse deleteSysPermission(@NotBlank(message = "{required}") String permissionId){
        this.sysPermissionService.deleteSysPermission(permissionId);
        return new DataResponse().success().message("删除菜单/按钮成功");
    }

}

