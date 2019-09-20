#sys_role表数据
INSERT INTO `sys_role` (`role_id`,`available`,`description`,`role`) VALUES (1,1,'超级管理员','admin');
INSERT INTO `sys_role` (`role_id`,`available`,`description`,`role`) VALUES (2,1,'高级用户','powerUser');
INSERT INTO `sys_role` (`role_id`,`available`,`description`,`role`) VALUES (3,1,'普通用户','user');
INSERT INTO `sys_role` (`role_id`,`available`,`description`,`role`) VALUES (4,1,'游客','guest');

##系统管理菜单
INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (1,1,'系统管理',0,'0','system:view','menu','#',1);

INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (2,1,'用户管理',1,'1','user:view','menu','user/userList',2);
INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (3,1,'用户添加',2,'1/2','user:add','button','user/userAdd',3);
INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (4,1,'用户修改',2,'1/2','user:edit','button','user/userEdit',3);
INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (5,1,'用户删除',2,'1/2','user:del','button','user/userDel',3);

INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (6,1,'角色管理',1,'1','role:view','menu','role/roleList',2);
INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (7,1,'角色添加',6,'1/6','role:add','button','role/roleAdd',3);
INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (8,1,'角色修改',6,'1/6','role:edit','button','role/roleEdit',3);
INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (9,1,'角色删除',6,'1/6','role:del','button','role/roleDel',3);
INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (10,1,'角色授权',6,'1/6','role:authorize','button','role/authorize',3);

#客户管理菜单
INSERT INTO `sys_permission` (`permission_id`,`available`,`permission_name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`,level)
VALUES (11,1,'客户管理',0,'0','customer:view','menu','#',1);

#角色权限
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (1,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (2,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (3,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (4,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (5,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (6,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (7,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (8,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (9,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (10,1);

INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (1,2);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (2,2);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (7,2);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (8,2);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (9,2);

#用户角色
INSERT INTO `sys_user_role` (`role_id`,`user_id`) VALUES (1,1);
INSERT INTO `sys_user_role` (`role_id`,`user_id`) VALUES (2,2);

#初始化两条数据
INSERT INTO `user` VALUES (1, '2019-08-31 12:00:00', '系统管理员', '8473d52cbbc96bb13930964d02cb620a', '16fcfcb77c137bfbb3b3dc6b8f2e462b', '1', 'admin');
INSERT INTO `user` VALUES (2, '2019-08-31 12:00:00', '客户', '8473d52cbbc96bb13930964d02cb620a', '16fcfcb77c137bfbb3b3dc6b8f2e462b', '1', 'cust');