package com.uxunchina.taling.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uxunchina.taling.common.controller.BaseController;
import com.uxunchina.taling.common.entity.DataResponse;
import com.uxunchina.taling.common.utils.TreeUtil;
import com.uxunchina.taling.system.entity.MenuTree;
import com.uxunchina.taling.system.entity.SysPermission;
import com.uxunchina.taling.system.entity.SysRole;
import com.uxunchina.taling.system.service.SysPermissionService;
import com.uxunchina.taling.system.service.SysRolePermissionService;
import com.uxunchina.taling.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenfeng123
 * @since 2019-09-25
 */
@Api(tags = "角色操作接口")
@Controller
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {

    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysPermissionService sysPermissionService;

    @ApiOperation("进入角色列表页面")
    @GetMapping("/roleList")
    public String roleList(){
        return "system/role";
    }

    @ApiOperation("分页查询角色信息页面")
    @PostMapping("/roleList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber",value = "当前页",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页总数",defaultValue = "10"),
            @ApiImplicitParam(name = "role",value = "角色名")
    })
    @ResponseBody
    public DataResponse roleList(@RequestParam Integer pageNumber,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 SysRole role ){
        Page<SysRole> page = getPage(pageNumber,pageSize);
        QueryWrapper<SysRole> ew = new QueryWrapper<SysRole>();
        if(role != null){
            if(StringUtils.isNotBlank(role.getRole())){
                ew.like("role",role.getRole());
            }
        }
        IPage<SysRole> pageData = sysRoleService.page(page,ew);
        return new DataResponse().success().count(page.getTotal()).data(pageData.getRecords());
    }

    @ApiOperation("添加角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role",value = "角色名称",required = true),
            @ApiImplicitParam(name = "description",value = "描述",required = true)
    })
    @PostMapping("/addRole")
    @ResponseBody
    public DataResponse addRole(SysRole role) {
        /* 判断系统中是否存在该角色，如果存在则提示用户改角色以存在 */
        SysRole resultRole = sysRoleService.getRoleByName(role.getRole());
        if(resultRole != null) {
            return new DataResponse().fail().message("该角色已经存在");
        }
        Date date = new Date();
        role.setCreateTime(date);
        role.setAvailable(Boolean.FALSE);
        boolean result = sysRoleService.save(role);
        if(!result){
            return new DataResponse().fail().message("新增角色失败");
        }
        return new DataResponse().success().message("新增角色成功");
    }

    @ApiOperation("删除角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId",value = "角色ID",required = true)
    })
    @PostMapping("/deleteRole")
    @ResponseBody
    public DataResponse deleteRole(SysRole role) {
        boolean result = sysRoleService.removeById(role.getRoleId());
        if(!result) {
            return new DataResponse().fail().message("删除角色失败");
        }
        return  new DataResponse().success().message("删除角色成功");
    }

    @ApiOperation("修改角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role",value = "角色名称"),
            @ApiImplicitParam(name = "description",value = "角色描述"),
            @ApiImplicitParam(name = "available",value = "角色状态")
    })
    @PostMapping("/updateRole")
    @ResponseBody
    public DataResponse updateRole(SysRole role) {
        SysRole resultRole = sysRoleService.getById(role.getRoleId());
        if(role.getAvailable() != null) {
            role.setRole(resultRole.getRole());
            role.setCreateTime(resultRole.getCreateTime());
            role.setDescription(resultRole.getDescription());
            boolean result = sysRoleService.updateById(role);
            if(!result) {
                return new DataResponse().fail().message("修改角色状态失败");
            }
            return new DataResponse().success().message("修改角色状态成功");
        } else {
            role.setAvailable(resultRole.getAvailable());
            role.setCreateTime(resultRole.getCreateTime());
            boolean result = sysRoleService.updateById(role);
            if (!result) {
                return new DataResponse().fail().message("修改角色信息失败");
            }
            return new DataResponse().success().message("修改角色信息成功");
        }
    }

    @ResponseBody
    @PostMapping("findRolePermission")
    public DataResponse findRolePermission(Long roleId){
        SysRole sysRole = new SysRole();
        sysRole.setRoleId(roleId);
        List<SysRole> rolePermissions = this.sysRoleService.findRolePermissions(sysRole);
        List<SysPermission> permissions = this.sysPermissionService.list();
        List<MenuTree> menuTrees = TreeUtil.buildMenuTree(rolePermissions.get(0).getPermissionIds(),permissions);
        return new DataResponse().success().message("查询角色权限成功").data(menuTrees);
    }

    @ResponseBody
    @PostMapping("updateRolePermission")
    public DataResponse updateRolePermission(@NotBlank(message = "{required}")String roleId, String permissionIds){
        this.sysRoleService.updateRolePermission(roleId,permissionIds);
        return new DataResponse().success().message("修改角色权限成功");
    }
}


