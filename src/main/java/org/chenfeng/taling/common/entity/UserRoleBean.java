package org.chenfeng.taling.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfeng
 * @Package org.chenfeng.taling.common.entity
 * @date 2019/9/3 17:27
 */
@Data
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

}
