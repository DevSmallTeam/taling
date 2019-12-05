package com.uxunchina.taling.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.system.entity
 * @date 2019-09-01 12:03
 * 权限表
 */
@TableName("sys_permission")
@Data
@Entity
@Table(name = "sys_permission")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = -1783693073790534959L;
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    private Long permissionId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 图标
     */
    private String icon;

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
     * 排序
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}
