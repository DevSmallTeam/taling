package org.chenfeng.taling.system.service;

import org.chenfeng.taling.system.entity.SysPermission;
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
    void createSysPermission(SysPermission sysPermission);

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
