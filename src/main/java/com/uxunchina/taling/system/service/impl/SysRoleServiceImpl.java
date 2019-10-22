package com.uxunchina.taling.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uxunchina.taling.system.entity.SysRole;
import com.uxunchina.taling.system.mapper.SysRoleMapper;
import com.uxunchina.taling.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenfeng123
 * @since 2019-09-25
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysRole getRoleByName(String roleName) {
        return sysRoleMapper.getRoleByName(roleName);
    }
}
