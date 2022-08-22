package org.chenfeng.taling.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfeng
 * @Package org.chenfeng.taling.common.entity
 * @date 2019/9/3 18:22
 */
@Data
public class UserRolePermissionBean implements Serializable {

    private static final long serialVersionUID = 1680892573361869879L;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 权限ID
     */
    private Integer permissionId;
    /**
     * 权限
     */
    private String permission;
    /**
     * 权限名
     */
    private String permissionName;

}
