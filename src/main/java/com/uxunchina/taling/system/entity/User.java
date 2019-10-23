package com.uxunchina.taling.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.uxunchina.taling.common.entity.UserRoleBean;
import com.uxunchina.taling.common.entity.UserRolePermissionBean;
import lombok.Data;

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
@TableName("user")
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 9100517633904500429L;

    /**
     * 用户ID 主键
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    private Long userId;
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
     * 角色id
     */
    @TableField(exist = false)
    private String roleIds;
    /**
     * 所属角色
     */
    @TableField(exist = false)
    private String roles;

    /**
     * 用户角色列表
     */
    @Transient
    @TableField(exist = false)
    private List<UserRoleBean> userRoleBeanList;

    /**
     * 用户权限列表
     */
    @Transient
    @TableField(exist = false)
    private List<UserRolePermissionBean> userRolePermissionBeanList;

}