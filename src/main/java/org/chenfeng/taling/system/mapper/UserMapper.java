package org.chenfeng.taling.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.chenfeng.taling.common.entity.UserRoleBean;
import org.chenfeng.taling.common.entity.UserRolePermissionBean;
import org.chenfeng.taling.system.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author chenfeng
 * @since 2019-08-31 16:35:04
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 分页查询所有用户
     * @param page
     * @param queryWrapper
     * @return
     */
    IPage<User> queryAllUser(IPage<User> page, @Param(Constants.WRAPPER) QueryWrapper<User> queryWrapper);

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
    List<UserRoleBean> findUserRoleByUserName(String userName);

    /**
     * 根据用户名查询用户权限
     * @param userName
     * @return
     */
    List<UserRolePermissionBean> findUserRolePermissionByUserName(String userName);



}