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
    @GeneratedValue
    @TableId(type = IdType.AUTO)
    public Integer id;
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