package org.chenfeng.taling.common.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import org.chenfeng.taling.system.entity.MenuTree;
import org.chenfeng.taling.system.entity.SysPermission;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

    protected TreeUtil(){

    }

    public static List<MenuTree> buildMenuTree(String permissionIds, List<SysPermission> sysPermissionList){
        List<MenuTree> menuTreeList = new ArrayList<>();
        if(sysPermissionList != null && sysPermissionList.size() > 0){
            for(SysPermission permission : sysPermissionList){
                MenuTree menuTree = new MenuTree();
                String name = permission.getPermissionName();
                if(StringUtils.isNotBlank(permission.getPermission()) && !"#".equals(permission.getPermission())){
                    name = name+StringPool.SPACE+permission.getPermission();
                }
                menuTree.setName(name);
                menuTree.setChecked(false);
                if(StringUtils.isNotBlank(permissionIds)){
                    String[]  permissionIdArray = permissionIds.split(StringPool.COMMA);
                    if(ArrayUtils.contains(permissionIdArray,permission.getPermissionId().toString())){
                        menuTree.setChecked(true);
                    }
                }
                menuTree.setPermissionId(permission.getPermissionId());
                menuTree.setParentId(permission.getParentId());
                menuTree.setOpen(true);
                menuTreeList.add(menuTree);
            }
        }
        return menuTreeList;
    }


}
