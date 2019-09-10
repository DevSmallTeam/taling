package com.uxunchina.taling.controller;

import com.uxunchina.taling.entity.User;
import org.apache.shiro.SecurityUtils;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.controller
 * @date 2019/9/5 10:33
 */
public abstract class BaseController {

    protected String retcode = "";// 消息的响应码
    protected String message = "";// 需返回的消息内容
    protected String goHref = ""; //跳转链接地址

    /**
     * 获取用户信息
     * @return
     */
    public User getUser(){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        //用户敏感信息置空
        user.setPassword("");
        user.setSalt("");
        return user;
    }

    /**
     * 退出登录
     */
    public void logOut(){
        SecurityUtils.getSubject().logout();
    }

}
