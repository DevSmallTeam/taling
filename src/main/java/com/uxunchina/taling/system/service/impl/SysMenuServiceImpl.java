package com.uxunchina.taling.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uxunchina.taling.system.entity.SysMenu;
import com.uxunchina.taling.system.mapper.SysMenuMapper;
import com.uxunchina.taling.system.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenfeng123
 * @since 2019-09-20
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

}
