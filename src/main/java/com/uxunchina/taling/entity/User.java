package com.uxunchina.taling.entity;

import com.uxunchina.taling.bean.UserRoleBean;
import com.uxunchina.taling.bean.UserRolePermissionBean;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (User)实体类
 * 用户表
 * @author chenfeng
 * @since 2019-08-31 16:35:04
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 9100517633904500429L;

    /**
     * 用户ID 主键
     */
    @Id
    @GeneratedValue
    private Integer userId;
    /**
     *  用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 加密盐
     */
    private String salt;
    /**
     * 状态 0 停用 1启用
     */
    private String state;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户角色列表
     */
    @Transient
    private List<UserRoleBean> userRoleBeanList;
    /**
     * 用户权限列表
     */
    @Transient
    private List<UserRolePermissionBean> userRolePermissionBeanList;


}