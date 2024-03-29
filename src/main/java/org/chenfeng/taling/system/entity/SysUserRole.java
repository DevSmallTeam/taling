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
 * @date 2019/9/2 11:12
 */
@TableName("sys_user_role")
@Data
@ApiModel(value = "用户角色关联表")
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 7692496259620335405L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Long roleId;


}
