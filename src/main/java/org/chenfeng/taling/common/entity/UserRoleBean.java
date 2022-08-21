package org.chenfeng.taling.common.entity;

import java.io.Serializable;

/**
 * @author chenfeng
 * @Package org.chenfeng.taling.common.entity
 * @date 2019/9/3 17:27
 */
public class UserRoleBean implements Serializable {

    private static final long serialVersionUID = -1204124150212632919L;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 角色
     */
    private String role;
    /**
     * 角色描述
     */
    private String roleDescription;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
