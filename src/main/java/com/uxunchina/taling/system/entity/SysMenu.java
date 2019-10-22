package com.uxunchina.taling.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.system.entity
 * @date 2019/9/20 14:53
 */
@TableName("sys_menu")
@Data
@Entity
@Table(name = "sys_menu")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = -2596222874744956040L;
    /**
     * 自增长主键id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    public Long id;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 父级菜单ID
     */
    private String pid;
    /**
     * 连接地址
     */
    private String url;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 深度
     */
    private Integer deep;
    /**
     * 编码
     */
    private String code;
    /**
     * 资源名称
     */
    private String resource;



}
