package com.uxunchina.taling.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.system.entity
 * @date 2019/9/2 11:01
 * 角色表
 */
@TableName("sys_role")
@Data
@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable {
    private static final long serialVersionUID = 8014787112682805259L;
    /**
     * 角色ID
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色
     */
    @Column(nullable = false, unique = true)
    @NotBlank(message ="名称不能为空")
    private String role;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 角色可用状态
     */
    private Boolean available;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 角色对应权限id
     */
    private transient String permissionIds;

}
