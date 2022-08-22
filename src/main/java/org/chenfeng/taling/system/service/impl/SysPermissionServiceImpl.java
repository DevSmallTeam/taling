package org.chenfeng.taling.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import org.chenfeng.taling.common.shiro.UserRealm;
import org.chenfeng.taling.system.entity.SysPermission;
import org.chenfeng.taling.system.mapper.SysPermissionMapper;
import org.chenfeng.taling.system.service.SysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.chenfeng.taling.system.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenfeng
 * @since 2019-12-05
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private UserRealm userRealm;

    @Autowired
    private SysRolePermissionService sysRolePermissionService;



    @Override
    @Transactional
    public void createSysPermission(SysPermission sysPermission) {
        sysPermission.setCreateTime(new Date());
        this.setSysPermission(sysPermission);
        this.baseMapper.insert(sysPermission);
    }

    @Override
    @Transactional
    public void updateSysPermission(SysPermission sysPermission) {
        sysPermission.setUpdateTime(new Date());
        this.setSysPermission(sysPermission);
        this.baseMapper.updateById(sysPermission);

        userRealm.clearCache();
    }

    @Override
    @Transactional
    public void deleteSysPermission(String permissionIds) {
        String[] permissionIdsArray = permissionIds.split(StringPool.COMMA);
        this.delete(Arrays.asList(permissionIdsArray));

        userRealm.clearCache();
    }

    private void setSysPermission(SysPermission sysPermission) {
        if (sysPermission.getParentId() == null)
            sysPermission.setParentId(SysPermission.TOP_NODE);
        if (SysPermission.TYPE_BUTTON.equals(sysPermission.getResourceType())) {
            sysPermission.setUrl("#");
            sysPermission.setIcon(null);
        }
    }

    private void delete(List<String> permissionId) {
        List<String> list = new ArrayList<>(permissionId);
        removeByIds(permissionId);

        LambdaQueryWrapper<SysPermission> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(SysPermission::getParentId, permissionId);
        List<SysPermission> menus = baseMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(menus)) {
            List<String> menuIdList = new ArrayList<>();
            menus.forEach(m -> menuIdList.add(String.valueOf(m.getPermissionId())));
            list.addAll(menuIdList);
            this.sysRolePermissionService.deleteRolePermissionsByPermissionId(list);
            this.delete(menuIdList);
        } else {
            this.sysRolePermissionService.deleteRolePermissionsByPermissionId(list);
        }
    }
}
