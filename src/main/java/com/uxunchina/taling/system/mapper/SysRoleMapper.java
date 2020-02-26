package com.uxunchina.taling.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uxunchina.taling.system.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenfeng123
 * @since 2019-09-25
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据角色名查询角色信息
     * @param roleName
     * @return
     */
    SysRole getRoleByName(String roleName);

    /**
     * 查询角色权限信息
     * @param sysRole
     * @return
     */
    List<SysRole> findRolePermissions(@Param("sysRole") SysRole sysRole);
}
