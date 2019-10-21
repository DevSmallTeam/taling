package com.uxunchina.taling.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uxunchina.taling.bean.DataResponse;
import com.uxunchina.taling.entity.LoginLog;
import com.uxunchina.taling.service.LoginLogService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenfeng
 * @since 2019-10-02
 */
@Controller
@RequestMapping("/loginLog")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    @ApiOperation("登录日志列表")
    @GetMapping("loginRecodeList")
    public String loginRecodeList(){
        return "user/loginRecord";
    }

    @ApiOperation("查询登录日志信息")
    @ResponseBody
    @PostMapping("loginRecode")
    public DataResponse loginRecode(@RequestParam Integer pageNumber,
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
        }
        IPage<LoginLog> pageData =  loginLogService.page(page,ew);
        return new DataResponse().success().count(page.getTotal()).data(pageData.getRecords());
    }

}
