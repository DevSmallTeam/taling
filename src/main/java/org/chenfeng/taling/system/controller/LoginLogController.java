package org.chenfeng.taling.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chenfeng.taling.common.entity.DataResponse;
import org.chenfeng.taling.system.entity.LoginLog;
import org.chenfeng.taling.system.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chenfeng
 * @since 2019-10-02
 */
@Api(tags = "登录日志接口")
@Controller
@RequestMapping("/loginLog")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    @ApiOperation("登录日志列表")
    @GetMapping("loginRecordList")
    public String loginRecordList() {
        return "user/loginRecord";
    }

    @ApiOperation("查询登录日志信息")
    @ResponseBody
    @PostMapping("loginRecord")
    public DataResponse loginRecord(@RequestParam Integer pageNumber,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    LoginLog loginLog) {
        Page<LoginLog> page = new Page<LoginLog>(pageNumber, pageSize);
        QueryWrapper<LoginLog> ew = new QueryWrapper<LoginLog>();
        if (loginLog != null) {
            ew.like(StringUtils.isNotBlank(loginLog.getUserName()), "user_name", loginLog.getUserName());
            ew.ge(StringUtils.isNotBlank(loginLog.getLoginTimeFrom()), "login_time", loginLog.getLoginTimeFrom());
            ew.le(StringUtils.isNotBlank(loginLog.getLoginTimeTo()), "login_time", loginLog.getLoginTimeTo());
            ew.orderByDesc("login_time");
        }
        IPage<LoginLog> pageData = loginLogService.page(page, ew);
        return new DataResponse().success().count(page.getTotal()).data(pageData.getRecords());
    }

}
