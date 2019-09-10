package com.uxunchina.taling.service.impl;

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
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userId) {
        return this.userMapper.queryById(userId);
    }

    @Override
    public User queryByUserName(String userName) {
        return this.userMapper.queryByUserName(userName);
    }

    /**
     * 查询所有记录
     * @param user
     * @return
     */
    @Override
    public List<User> queryAll(User user) {
        return this.userMapper.queryAll(user);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userMapper.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.userMapper.deleteById(userId) > 0;
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