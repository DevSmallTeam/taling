package org.chenfeng.taling.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfeng
 * @Package org.chenfeng.taling.system.entity
 * @date 2019/9/2 11:15
 */
@TableName("sys_role_permission")
@Data
@ApiModel(value = "角色权限关联表")
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 2453645057197231765L;
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色id")
    private Long roleId;
    /**
     * 权限ID
     */
    @ApiModelProperty(value = "权限ID")
    private Long permissionId;

}
