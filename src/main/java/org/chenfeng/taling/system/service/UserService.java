package org.chenfeng.taling.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.chenfeng.taling.common.entity.UserRoleBean;
import org.chenfeng.taling.common.entity.UserRolePermissionBean;
import org.chenfeng.taling.system.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author chenfeng
 * @since 2019-08-31 16:35:04
 */
public interface UserService  extends IService<User> {


    /**
     * 分页查询所有用户信息
     * @param page
     * @param queryWrapper
     * @return
     */
    IPage<User> queryAllUser(IPage<User> page, QueryWrapper<User> queryWrapper);

    /**
     * 创建用户
     * @param user
     */
    void createUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Long userId);

    /**
     * 修改用户信息
     */
    void updateUser(User user);

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