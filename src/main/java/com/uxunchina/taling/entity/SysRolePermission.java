package com.uxunchina.taling.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.entity
 * @date 2019/9/2 11:15
 */
@TableName("sys_role_permission")
@Data
@Entity
@Table(name = "sys_role_permission")
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 2453645057197231765L;
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long permissionId;

}
