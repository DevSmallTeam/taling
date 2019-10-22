package com.uxunchina.taling.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uxunchina.taling.system.entity.SysRole;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenfeng123
 * @since 2019-09-25
 */
public interface SysRoleService extends IService<SysRole> {

    SysRole getRoleByName(String roleName);

}
