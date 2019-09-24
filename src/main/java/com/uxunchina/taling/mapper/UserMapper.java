package com.uxunchina.taling.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.uxunchina.taling.bean.UserRoleBean;
import com.uxunchina.taling.bean.UserRolePermissionBean;
import com.uxunchina.taling.entity.User;
import org.apache.ibatis.annotations.Mapper;
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