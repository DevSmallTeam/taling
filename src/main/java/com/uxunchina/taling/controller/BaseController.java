package com.uxunchina.taling.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uxunchina.taling.entity.User;
import org.apache.shiro.SecurityUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.controller
 * @date 2019/9/5 10:33
 */
public abstract class BaseController {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    @Resource
    protected HttpSession session;

    @Resource
    protected ServletContext application;

    // 需返回的消息内容
    protected String msg = "";

    /**
     * <p>
     * 获取分页对象
     * </p>
     */
    protected <T> Page<T> getPage(int pageNumber) {
        return getPage(pageNumber, 15);
    }

    /**
     * <p>
     * 获取分页对象
     * </p>
     *
     * @param pageNumber
     * @param pageSize
     *            每页显示数量
     * @return
     */
    protected <T> Page<T> getPage(int pageNumber, int pageSize) {
        return new Page<T>(pageNumber, pageSize);
    }

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
