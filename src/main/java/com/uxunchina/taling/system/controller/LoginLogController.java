package com.uxunchina.taling.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uxunchina.taling.common.entity.DataResponse;
import com.uxunchina.taling.system.entity.LoginLog;
import com.uxunchina.taling.system.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenfeng
 * @since 2019-10-02
 */
@Api("登录日志接口")
@Controller
@RequestMapping("/loginLog")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    @ApiOperation("登录日志列表")
    @GetMapping("loginRecordList")
    public String loginRecordList(){
        return "user/loginRecord";
    }

    @ApiOperation("查询登录日志信息")
    @ResponseBody
    @PostMapping("loginRecord")
    public DataResponse loginRecord(@RequestParam Integer pageNumber,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    LoginLog loginLog){
        Page<LoginLog> page = new Page<LoginLog>(pageNumber,pageSize);
        QueryWrapper<LoginLog> ew = new QueryWrapper<LoginLog>();
        if(loginLog != null){
            if(StringUtils.isNotBlank(loginLog.getUserName())){
                ew.like("user_name",loginLog.getUserName());
            }
            if(StringUtils.isNotBlank(loginLog.getLoginTimeFrom())){
                ew.ge("login_time",loginLog.getLoginTimeFrom());
            }
            if(StringUtils.isNotBlank(loginLog.getLoginTimeTo())){
                ew.le("login_time",loginLog.getLoginTimeTo());
            }
            ew.orderByDesc("login_time");
        }
        IPage<LoginLog> pageData =  loginLogService.page(page,ew);
        return new DataResponse().success().count(page.getTotal()).data(pageData.getRecords());
    }

}
