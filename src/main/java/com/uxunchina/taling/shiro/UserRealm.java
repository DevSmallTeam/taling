package com.uxunchina.taling.shiro;

import com.uxunchina.taling.bean.Content;
import com.uxunchina.taling.bean.UserRoleBean;
import com.uxunchina.taling.bean.UserRolePermissionBean;
import com.uxunchina.taling.entity.User;
import com.uxunchina.taling.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.shrio
 * @date 2019-08-31 10:34
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    public UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("------------开始进行权限验证------------");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //取出用户信息
        User user = (User) principalCollection.getPrimaryPrincipal();
        //获取用户角色
        List<UserRoleBean> userRoleBeanList = user.getUserRoleBeanList();
        //将用户角色给shiro
        for(UserRoleBean userRole:userRoleBeanList){
            authorizationInfo.addRole(userRole.getRole());
        }
        //获取用户角色权限
        List<UserRolePermissionBean> userRolePermissionBeanList = user.getUserRolePermissionBeanList();
        //将用户角色权限给shiro
        for(UserRolePermissionBean userRolePermission:userRolePermissionBeanList){
            authorizationInfo.addStringPermission(userRolePermission.getPermission());
        }
        return authorizationInfo;
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("------------开始进行身份验证------------");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userName = usernamePasswordToken.getUsername();
        User user = userService.queryByUserName(userName);
        if(user == null ){
            throw new UnknownAccountException();
        }else if(Content.USER_LOCK.equals(user.getState())){
            throw new LockedAccountException();
        }else{
            log.info("获取的用户名是{},密码是{}",userName,user.getPassword());
            //查询用户角色
            List<UserRoleBean> userRoleBeanList = userService.findSysRoleByUserName(userName);
            //查询用户权限
            List<UserRolePermissionBean> userRolePermissionBeanList = userService.findSysRolePermissionByUserName(userName);

            user.setUserRoleBeanList(userRoleBeanList);
            user.setUserRolePermissionBeanList(userRolePermissionBeanList);

            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    user,user.getPassword(),ByteSource.Util.bytes(user.getSalt()),getName());
            return simpleAuthenticationInfo;
        }
    }

    /**
     * 清除当前用户权限缓存
     * 使用方法：在需要清除用户权限的地方注入 UserRealm,
     * 然后调用其 clearCache方法。
     */
    public void clearCache() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

}
