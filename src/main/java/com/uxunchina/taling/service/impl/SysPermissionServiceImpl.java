package com.uxunchina.taling.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.uxunchina.taling.entity.SysPermission;
import com.uxunchina.taling.mapper.SysPermissionMapper;
import com.uxunchina.taling.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysPermission)表服务实现类
 *
 * @author chenfeng
 * @since 2019-09-03 16:26:03
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper,SysPermission> implements SysPermissionService {
}