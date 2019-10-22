package com.uxunchina.taling.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uxunchina.taling.system.entity.SysRole;

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
}
