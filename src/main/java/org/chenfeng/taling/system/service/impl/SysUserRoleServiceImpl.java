package org.chenfeng.taling.system.service.impl;

import org.chenfeng.taling.system.entity.SysUserRole;
import org.chenfeng.taling.system.mapper.SysUserRoleMapper;
import org.chenfeng.taling.system.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenfeng
 * @since 2019-10-02
 */
@Service("sysUserRoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}
