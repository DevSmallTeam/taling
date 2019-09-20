package com.uxunchina.taling.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.uxunchina.taling.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.annotations.MetaValue;

import java.util.List;

/**
 * (Syspermission)表数据库访问层
 *
 * @author chenfeng
 * @since 2019-09-03 16:26:03
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

}