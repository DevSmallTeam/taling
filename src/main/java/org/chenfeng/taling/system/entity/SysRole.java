package org.chenfeng.taling.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenfeng
 * @Package org.chenfeng.taling.system.entity
 * @date 2019/9/2 11:01
 * 角色表
 */
@TableName("sys_role")
@Data
@ApiModel(value = "角色表")
public class SysRole implements Serializable {
    private static final long serialVersionUID = 8014787112682805259L;
    /**
     * 角色ID
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    /**
     * 角色
     */
    @NotBlank(message ="名称不能为空")
    @ApiModelProperty(value = "角色名称")
    private String role;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述")
    private String description;

    /**
     * 角色可用状态
     */
    @ApiModelProperty(value = "角色可用状态，true可用，false不可用")
    private Boolean available;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createTime;

    /**
     * 角色对应权限id
     */
    @ApiModelProperty(value = "角色权限ids")
    private transient String permissionIds;

}
