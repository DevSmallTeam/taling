package org.chenfeng.taling.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 * 用户表
 * @author chenfeng
 * @since 2019-08-31 16:35:04
 */
@TableName("user")
@Data
@ApiModel(value = "用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 9100517633904500429L;

    /**
     * 用户ID 主键
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     *  用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 加密盐
     */
    @ApiModelProperty(value = "加密盐")
    private String salt;
    /**
     * 状态 0 停用 1启用
     */
    @ApiModelProperty(value = "状态 0 停用 1启用")
    private String state;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createTime;

    /**
     * 角色id
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "角色id")
    private String roleIds;
    /**
     * 所属角色
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "所属角色")
    private String roles;


}