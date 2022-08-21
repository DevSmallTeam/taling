package org.chenfeng.taling.system.service;

import org.chenfeng.taling.system.entity.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenfeng
 * @since 2020-02-25
 */
public interface SysRolePermissionService extends IService<SysRolePermission> {

    /**
     * 根据角色ID 删除角色权限关联关系
     * @param roleIds
     */
    void deleteRolePermissionsByRoleId(List<String> roleIds);

    /**
     * 根据菜单/按钮 ID删除角色权限关联信息
     * @param permissionIds
     */
    void deleteRolePermissionsByPermissionId(List<String> permissionIds);
}
