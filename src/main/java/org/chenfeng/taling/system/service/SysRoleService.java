package org.chenfeng.taling.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.chenfeng.taling.system.entity.SysRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenfeng123
 * @since 2019-09-25
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据角色名字查询角色
     * @param roleName
     * @return
     */
    SysRole getRoleByName(String roleName);

    /**
     * 查询角色权限
     * @param sysRole
     * @return
     */
    List<SysRole> findRolePermissions(SysRole sysRole);

    /**
     * 更新角色权限
     * @param roleId
     * @param permissionIds
     */
    void updateRolePermission(String roleId,String permissionIds);

}
