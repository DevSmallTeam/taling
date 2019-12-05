package com.uxunchina.taling.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uxunchina.taling.common.controller.BaseController;
import com.uxunchina.taling.common.entity.DataResponse;
import com.uxunchina.taling.system.entity.SysPermission;
import com.uxunchina.taling.system.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenfeng
 * @since 2019-12-05
 */
@Controller
@RequestMapping("/sysPermission")
public class SysPermissionController extends BaseController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping("sysPermissionList")
    public String sysPermissionList(){
        return "system/menu";
    }

    @ResponseBody
    @GetMapping("list")
    public DataResponse sysPermission(){
        QueryWrapper<SysPermission> ew = new QueryWrapper<SysPermission>();
        List<SysPermission> data = sysPermissionService.list(ew);
        ew.orderByAsc("orderNum");
        return new DataResponse().success().count((long) data.size()).data(data).message("查询菜单成功");
    }

}

