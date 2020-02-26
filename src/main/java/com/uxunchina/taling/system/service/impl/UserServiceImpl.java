package com.uxunchina.taling.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uxunchina.taling.common.entity.Content;
import com.uxunchina.taling.common.entity.UserRoleBean;
import com.uxunchina.taling.common.entity.UserRolePermissionBean;
import com.uxunchina.taling.system.entity.SysUserRole;
import com.uxunchina.taling.system.entity.User;
import com.uxunchina.taling.system.mapper.UserMapper;
import com.uxunchina.taling.system.service.SysUserRoleService;
import com.uxunchina.taling.system.service.UserService;
import com.uxunchina.taling.common.shiro.UserRealm;
import com.uxunchina.taling.common.utils.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author chenfeng
 * @since 2019-08-31 16:35:04
 */
@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private SysUserRoleService sysUserRoleService;

    @Resource
    private UserRealm userRealm;



    /**
     * 分页查询用户信息
     * @param page
     * @param queryWrapper
     * @return
     */
    @Override
    public IPage<User> queryAllUser(IPage<User> page, QueryWrapper<User> queryWrapper) {
        return baseMapper.queryAllUser(page,queryWrapper);
    }

    @Override
    public void createUser(User user) {
        user.setCreateTime(new Date());
        user.setState(Content.USER_VALID);
        user.setSalt(ShiroUtils.getSalt());
        user.setPassword(ShiroUtils.MD5(Content.DEFALT_PSW,user.getSalt()));
        save(user);
        // 保存用户角色
        String[] roles = user.getRoleIds().split(StringPool.COMMA);
        setUserRoles(user, roles);
    }

    /**
     * 删除用户信息
     * @param userId
     */
    @Override
    public void deleteUser(Long userId) {
        userMapper.deleteById(userId);
        //删除用户角色
        sysUserRoleService.remove(new QueryWrapper<SysUserRole>().lambda().eq(SysUserRole::getUserId, userId));
    }

    @Override
    public void updateUser(User user) {
        user.setSalt(null);
        user.setPassword(null);
        updateById(user);
        // 更新关联角色
        this.sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, user.getUserId()));
        String[] roles = user.getRoleIds().split(StringPool.COMMA);
        setUserRoles(user, roles);

        User currentUser = ShiroUtils.getCurrentUser();
        if (StringUtils.equalsIgnoreCase(currentUser.getUserName(), user.getUserName())) {
            userRealm.clearCache();
        }
    }

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

    /**
     * 设置用户角色
     * @param user
     * @param roles
     */
    private void setUserRoles(User user, String[] roles) {
        List<SysUserRole> userRoles = new ArrayList<>();
        Arrays.stream(roles).forEach(roleId -> {
            SysUserRole usr = new SysUserRole();
            usr.setUserId(user.getUserId());
            usr.setRoleId(Long.parseLong(roleId));
            userRoles.add(usr);
        });
        sysUserRoleService.saveBatch(userRoles);
    }
}