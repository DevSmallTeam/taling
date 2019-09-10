package com.uxunchina.taling.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.entity
 * @date 2019-09-01 12:03
 * 权限表
 */
@Getter
@Setter
@Entity
@Table(name = "syspermission")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = -1783693073790534959L;
    /**
     * 主键ID
     */
    @Id
    @GenericGenerator(name="generator",strategy = "native")
    @GeneratedValue
    private Integer permissionId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 描述
     */
    private String description;

    /**
     * 资源类型 [menu|button]
     */
    private String resourceType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 父类Id
     */
    private Long parentId;
    /**
     * 父类列表
     */
    private String parentIds;

    /**
     * 菜单层级 1、2、3
     */
    private Integer level;

    /**
     * 可用状态
     */
    private Boolean available = Boolean.FALSE;


}
