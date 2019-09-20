package com.uxunchina.taling.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.uxunchina.taling.bean.UserRoleBean;
import com.uxunchina.taling.bean.UserRolePermissionBean;
import com.uxunchina.taling.entity.User;
import com.uxunchina.taling.mapper.UserMapper;
import com.uxunchina.taling.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author chenfeng
 * @since 2019-08-31 16:35:04
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @Override
    public User queryByUserName(String userName) {
        return this.userMapper.queryByUserName(userName);
    }

    /**
     * 根据用户名查询用户角色
     * @param userName
     * @return
     */
    @Override
    public List<UserRoleBean> findSysRoleByUserName(String userName) {
        return this.userMapper.findUserRoleByUserName(userName);
    }

    /**
     * 根据用户名查询用户权限
     * @param userName
     * @return
     */
    @Override
    public List<UserRolePermissionBean> findSysRolePermissionByUserName(String userName) {
        return this.userMapper.findUserRolePermissionByUserName(userName);
    }
}