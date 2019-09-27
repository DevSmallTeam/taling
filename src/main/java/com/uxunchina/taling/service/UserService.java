package com.uxunchina.taling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uxunchina.taling.bean.UserRoleBean;
import com.uxunchina.taling.bean.UserRolePermissionBean;
import com.uxunchina.taling.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author chenfeng
 * @since 2019-08-31 16:35:04
 */
public interface UserService  extends IService<User> {


    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User queryByUserName(String userName);

    /**
     * 根据用户名查询用户角色
     * @param userName
     * @return
     */
    List<UserRoleBean> findSysRoleByUserName(String userName);

    /**
     * 根据用户名查询用户权限
     * @param userName
     * @return
     */
    List<UserRolePermissionBean> findSysRolePermissionByUserName(String userName);

}