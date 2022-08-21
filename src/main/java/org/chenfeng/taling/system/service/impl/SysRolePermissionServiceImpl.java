package org.chenfeng.taling.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.chenfeng.taling.system.entity.SysRolePermission;
import org.chenfeng.taling.system.mapper.SysRolePermissionMapper;
import org.chenfeng.taling.system.service.SysRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenfeng
 * @since 2020-02-25
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

    @Override
    @Transactional
    public void deleteRolePermissionsByRoleId(List<String> roleIds) {
        this.baseMapper.delete(new QueryWrapper<SysRolePermission>().lambda().in(SysRolePermission::getRoleId, roleIds));
    }

    @Override
    @Transactional
    public void deleteRolePermissionsByPermissionId(List<String> permissionIds) {
        this.baseMapper.delete(new QueryWrapper<SysRolePermission>().lambda().in(SysRolePermission::getPermissionId, permissionIds));
    }
}
