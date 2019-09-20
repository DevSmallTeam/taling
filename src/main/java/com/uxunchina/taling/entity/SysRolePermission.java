package com.uxunchina.taling.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @GeneratedValue
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 权限ID
     */
    private Integer permissionId;

}
