package com.uxunchina.taling.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uxunchina.taling.system.entity.SysPermission;
import com.uxunchina.taling.system.mapper.SysPermissionMapper;
import com.uxunchina.taling.system.service.SysPermissionService;
import org.springframework.stereotype.Service;

/**
 * (SysPermission)表服务实现类
 *
 * @author chenfeng
 * @since 2019-09-03 16:26:03
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper,SysPermission> implements SysPermissionService {
}