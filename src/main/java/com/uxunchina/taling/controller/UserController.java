package com.uxunchina.taling.controller;

import com.uxunchina.taling.entity.User;
import com.uxunchina.taling.service.UserService;
import com.uxunchina.taling.utils.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author chenfeng
 * @since 2019-08-31 16:35:04
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 修改用户密码
     * @return
     */
    @ResponseBody
    @PostMapping("modifyPassword")
    public Map<String, Object> modifyPassword(@RequestParam("password") String password,
                                              @RequestParam("newPassword") String newPassword){
        Map<String,Object> dataMap = new HashMap<String,Object>();
        if(StringUtils.isBlank(password)){
            retcode = "0001";
            message = "原密码不能为空";
            dataMap.put("retcode",retcode);
            dataMap.put("message",message);
            return dataMap;
        }
        if(StringUtils.isBlank(newPassword)){
            retcode = "0002";
            message = "新密码不能为空";
            dataMap.put("retcode",retcode);
            dataMap.put("message",message);
            return dataMap;
        }
        //根据userName查询出用户信息
        User user = userService.queryByUserName(getUser().getUserName());
        String oldPassword = ShiroUtils.MD5(password,user.getSalt());
        if(!oldPassword.equals(user.getPassword())){
            retcode = "0002";
            message = "您输入的原密码不正确";
            dataMap.put("retcode",retcode);
            dataMap.put("message",message);
            return dataMap;
        }
        user.setSalt(ShiroUtils.getSalt());
        user.setPassword(ShiroUtils.MD5(newPassword,user.getSalt()));
        User newUser = userService.update(user);
        if(newUser == null){
            dataMap.put("retcode",retcode);
            dataMap.put("message",message);
            return dataMap;
        }
        //修改密码成功之后将用户信息注销
        logOut();
        retcode = "0000";
        message = "修改密码成功";
        goHref = "/login";
        dataMap.put("retcode",retcode);
        dataMap.put("message",message);
        dataMap.put("goHref",goHref);
       return dataMap;
    }

}