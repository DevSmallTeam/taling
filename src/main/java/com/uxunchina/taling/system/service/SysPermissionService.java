package com.uxunchina.taling.system.service;

import com.uxunchina.taling.system.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenfeng
 * @since 2019-12-05
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 新增菜单/按钮
     * @param sysPermission
     */
    void createSyspermission(SysPermission sysPermission);

    /**
     * 修改菜单/按钮
     * @param sysPermission
     */
    void updateSysPermission(SysPermission sysPermission);

    /**
     * 删除菜单/按钮
     * @param permissionId
     */
    void deleteSysPermission(String permissionId);
}
