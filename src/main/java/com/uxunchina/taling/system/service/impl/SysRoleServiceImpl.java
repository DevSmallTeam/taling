package com.uxunchina.taling.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uxunchina.taling.common.shiro.UserRealm;
import com.uxunchina.taling.system.entity.SysRole;
import com.uxunchina.taling.system.entity.SysRolePermission;
import com.uxunchina.taling.system.mapper.SysRoleMapper;
import com.uxunchina.taling.system.service.SysRolePermissionService;
import com.uxunchina.taling.system.service.SysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenfeng123
 * @since 2019-09-25
 */
@Service("sysRoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysRolePermissionService sysRolePermissionService;

    @Resource
    private UserRealm userRealm;

    @Override
    public SysRole getRoleByName(String roleName) {
        return sysRoleMapper.getRoleByName(roleName);
    }

    @Override
    public List<SysRole> findRolePermissions(SysRole sysRole) {
        return this.sysRoleMapper.findRolePermissions(sysRole);
    }

    @Override
    @Transactional
    public void updateRolePermission(String roleId, String permissionIds) {
        List<String> roleIds = new ArrayList<>();
        roleIds.add(roleId);
        this.sysRolePermissionService.deleteRolePermissionsByRoleId(roleIds);
        saveRolePermission(roleId,permissionIds);

        userRealm.clearCache();
    }

    private void saveRolePermission(String roleId, String permissionIds) {
        if (StringUtils.isNotBlank(permissionIds)) {
            String[] permissionIdArray = permissionIds.split(StringPool.COMMA);
            List<SysRolePermission> sysRolePermissionListy = new ArrayList<>();
            Arrays.stream(permissionIdArray).forEach(permissionId -> {
                SysRolePermission sysRolePermission = new SysRolePermission();
                sysRolePermission.setRoleId(Long.valueOf(roleId));
                sysRolePermission.setPermissionId(Long.valueOf(permissionId));
                sysRolePermissionListy.add(sysRolePermission);
            });
            sysRolePermissionService.saveBatch(sysRolePermissionListy);
        }
    }
}
