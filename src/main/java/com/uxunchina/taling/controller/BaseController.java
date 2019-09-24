package com.uxunchina.taling.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.uxunchina.taling.entity.User;
import org.apache.shiro.SecurityUtils;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.controller
 * @date 2019/9/5 10:33
 */
public abstract class BaseController {

    // 消息的响应码
    protected Integer code = 0;
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
