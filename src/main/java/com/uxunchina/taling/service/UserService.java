package com.uxunchina.taling.service;

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
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User queryByUserName(String userName);

    /**
     * 查询所有
     * @param user
     * @return
     */
    List<User> queryAll(User user);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

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