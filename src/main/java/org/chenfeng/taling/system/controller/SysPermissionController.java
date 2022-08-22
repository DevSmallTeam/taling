package org.chenfeng.taling.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.chenfeng.taling.common.controller.BaseController;
import org.chenfeng.taling.common.entity.DataResponse;
import org.chenfeng.taling.system.entity.SysPermission;
import org.chenfeng.taling.system.service.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenfeng
 * @since 2019-12-05
 */
@Api(tags = "菜单/按钮管理")
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
        ew.orderByAsc("order_num");
        List<SysPermission> data = sysPermissionService.list(ew);
        return new DataResponse().success().count((long) data.size()).data(data).message("查询菜单/按钮成功");
    }

    @ApiOperation("新增菜单/按钮")
    @ResponseBody
    @PostMapping("createSysPermission")
    public DataResponse createSysPermission(@Valid SysPermission sysPermission){
        this.sysPermissionService.createSysPermission(sysPermission);
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

