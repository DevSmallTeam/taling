/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : taling

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 16/12/2019 18:08:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `browser` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `system` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_log
-- ----------------------------
BEGIN;
INSERT INTO `login_log` VALUES (1, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-02 21:39:56', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (2, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-02 21:40:50', 'Mac OS X 10_14_6', 'chenfeng');
INSERT INTO `login_log` VALUES (3, 'Safari Version 13.0.1 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-02 21:41:18', 'Mac OS X 10_14_6', 'cust');
INSERT INTO `login_log` VALUES (4, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 00:18:49', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (5, 'Safari Version 13.0.1 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 00:19:02', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (6, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 00:22:47', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (7, 'Safari Version 13.0.1 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 00:24:09', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (8, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 00:30:50', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (9, 'Safari Version 13.0.1 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 00:31:19', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (10, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 00:31:49', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (11, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 00:36:46', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (12, 'Safari Version 13.0.1 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 00:37:21', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (13, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 12:20:48', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (14, 'Safari Version 13.0.1 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-03 12:45:08', 'Mac OS X 10_14_6', 'admin');
INSERT INTO `login_log` VALUES (15, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-17 16:42:46', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (16, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-21 15:06:01', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (17, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-21 17:21:06', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (18, 'Chrome 77', '172.16.142.105', '内网IP|0|0|内网IP|内网IP', '2019-10-21 18:38:22', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (19, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-22 15:35:56', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (20, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-22 16:45:36', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (21, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-22 17:32:16', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (22, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-23 09:39:43', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (23, 'Firefox 69', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-23 09:40:31', 'Mac OS X 10.15; ', 'chenfeng');
INSERT INTO `login_log` VALUES (24, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 16:16:30', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (25, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 16:29:29', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (26, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 16:45:03', 'Mac OS X 10_15_0', 'yinyw');
INSERT INTO `login_log` VALUES (27, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 16:47:26', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (28, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 16:56:19', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (29, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 17:18:37', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (30, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 17:20:20', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (31, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 17:35:33', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (32, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 17:46:56', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (33, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 17:48:45', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (34, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 17:55:08', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (35, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 17:55:31', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (36, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 17:57:13', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (37, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-25 17:57:48', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (38, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 10:53:11', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (39, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 10:53:55', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (40, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 14:36:49', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (41, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 14:47:06', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (42, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 14:49:11', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (43, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 14:50:11', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (44, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 17:31:25', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (45, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 17:31:43', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (46, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 17:54:14', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (47, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 17:54:36', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (48, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:08:06', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (49, 'Safari Version 13.0.2 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:08:44', 'Mac OS X 10_15) ', 'chenfeng');
INSERT INTO `login_log` VALUES (50, 'Safari Version 13.0.2 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:12:00', 'Mac OS X 10_15) ', 'chenfeng');
INSERT INTO `login_log` VALUES (51, 'Safari Version 13.0.2 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:15:12', 'Mac OS X 10_15) ', 'chenfeng');
INSERT INTO `login_log` VALUES (52, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:19:42', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (53, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:19:55', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (54, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:20:48', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (55, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:28:39', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (56, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:31:20', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (57, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:31:31', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (58, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:31:47', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (59, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:33:23', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (60, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:33:49', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (61, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:34:14', 'Mac OS X 10_15_0', 'chenfeng');
INSERT INTO `login_log` VALUES (62, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:42:34', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (63, 'Safari Version 13.0.2 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:43:15', 'Mac OS X 10_15) ', 'admin');
INSERT INTO `login_log` VALUES (64, 'Safari Version 13.0.2 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:43:52', 'Mac OS X 10_15) ', 'chenfeng');
INSERT INTO `login_log` VALUES (65, 'Safari Version 13.0.2 ', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:47:45', 'Mac OS X 10_15) ', 'chenfeng');
INSERT INTO `login_log` VALUES (66, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 18:48:07', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (67, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-28 19:05:00', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (68, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-29 15:20:29', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (69, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-29 17:15:40', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (70, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-30 09:05:45', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (71, 'Chrome 77', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-10-30 09:50:46', 'Mac OS X 10_15_0', 'admin');
INSERT INTO `login_log` VALUES (72, '', '192.168.1.21', '内网IP|0|0|内网IP|内网IP', '2019-11-01 20:02:49', 'Mac OS X) AppleW', 'chenfeng');
INSERT INTO `login_log` VALUES (73, 'Chrome 78', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-11-29 17:40:05', 'Mac OS X 10_15_1', 'admin');
INSERT INTO `login_log` VALUES (74, 'Chrome 78', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-12-05 14:34:01', 'Mac OS X 10_15_1', 'chenfeng');
INSERT INTO `login_log` VALUES (75, 'Chrome 78', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-12-05 14:34:36', 'Mac OS X 10_15_1', 'admin');
INSERT INTO `login_log` VALUES (76, 'Chrome 78', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-12-05 15:42:09', 'Mac OS X 10_15_1', 'admin');
INSERT INTO `login_log` VALUES (77, 'Chrome 78', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-12-05 16:21:55', 'Mac OS X 10_15_1', 'admin');
INSERT INTO `login_log` VALUES (78, 'Chrome 78', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2019-12-10 16:57:57', 'Mac OS X 10_15_1', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `permission_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  `resource_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_permission` VALUES (1, b'1', 0, 'system:view', '系统管理', '0', '#', NULL, 1, NULL, NULL);
INSERT INTO `sys_permission` VALUES (2, b'1', 1, 'user:view', '用户管理', '0', 'user/userList', NULL, 2, NULL, NULL);
INSERT INTO `sys_permission` VALUES (3, b'1', 2, 'user:add', '用户添加', '1', 'user/userAdd', NULL, 3, NULL, NULL);
INSERT INTO `sys_permission` VALUES (4, b'1', 2, 'user:edit', '用户修改', '1', 'user/userEdit', NULL, 3, NULL, NULL);
INSERT INTO `sys_permission` VALUES (5, b'1', 2, 'user:del', '用户删除', '1', 'user/userDel', NULL, 3, NULL, NULL);
INSERT INTO `sys_permission` VALUES (6, b'1', 1, 'role:view', '角色管理', '0', 'role/roleList', NULL, 2, NULL, NULL);
INSERT INTO `sys_permission` VALUES (7, b'1', 6, 'role:add', '角色添加', '1', 'role/roleAdd', NULL, 3, NULL, NULL);
INSERT INTO `sys_permission` VALUES (8, b'1', 6, 'role:edit', '角色修改', '1', 'role/roleEdit', NULL, 3, NULL, NULL);
INSERT INTO `sys_permission` VALUES (9, b'1', 6, 'role:del', '角色删除', '1', 'role/roleDel', NULL, 3, NULL, NULL);
INSERT INTO `sys_permission` VALUES (10, b'1', 6, 'role:authorize', '角色授权', '1', 'role/authorize', NULL, 3, NULL, NULL);
INSERT INTO `sys_permission` VALUES (11, b'1', 0, 'customer:view', '客户管理', '0', '#', NULL, 1, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `creat_time` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `UK_mwbqlu5c82jfd2w9oa9d6e87d` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, b'1', '2019-08-31', '超级管理员', '超级管理员');
INSERT INTO `sys_role` VALUES (2, b'1', '2019-08-31', '高级用户', '高级用户');
INSERT INTO `sys_role` VALUES (3, b'1', '2019-08-31', '普通用户', '普通用户');
INSERT INTO `sys_role` VALUES (4, b'1', '2019-08-31', '游客', '游客');
INSERT INTO `sys_role` VALUES (6, b'1', '2019-10-02', '系统监控', '系统监控员');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_permission` VALUES (1, 1, 1);
INSERT INTO `sys_role_permission` VALUES (2, 2, 1);
INSERT INTO `sys_role_permission` VALUES (3, 3, 1);
INSERT INTO `sys_role_permission` VALUES (4, 4, 1);
INSERT INTO `sys_role_permission` VALUES (5, 5, 1);
INSERT INTO `sys_role_permission` VALUES (6, 6, 1);
INSERT INTO `sys_role_permission` VALUES (7, 7, 1);
INSERT INTO `sys_role_permission` VALUES (8, 8, 1);
INSERT INTO `sys_role_permission` VALUES (9, 9, 1);
INSERT INTO `sys_role_permission` VALUES (10, 10, 1);
INSERT INTO `sys_role_permission` VALUES (11, 1, 2);
INSERT INTO `sys_role_permission` VALUES (12, 2, 2);
INSERT INTO `sys_role_permission` VALUES (13, 7, 2);
INSERT INTO `sys_role_permission` VALUES (14, 8, 2);
INSERT INTO `sys_role_permission` VALUES (15, 9, 2);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (16, 1, 6);
INSERT INTO `sys_user_role` VALUES (19, 3, 7);
INSERT INTO `sys_user_role` VALUES (50, 2, 2);
INSERT INTO `sys_user_role` VALUES (59, 1, 1);
INSERT INTO `sys_user_role` VALUES (62, 4, 5);
INSERT INTO `sys_user_role` VALUES (63, 1, 5);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `role_ids` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '2019-08-31 12:00:00', '超级管理员', 'b9951e3b7d82bbdb06e4f0d5ac48ca50', '134ccb279cc3067da0ed5b381bd72a70', '1', 'admin', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, '2019-08-31 12:00:00', '客户', '8473d52cbbc96bb13930964d02cb620a', '16fcfcb77c137bfbb3b3dc6b8f2e462b', '0', 'cust', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, '2019-10-02 14:43:18', '陈风', '2e95767f9cad74c77f78ce4be3f0027a', 'b6e7523615f45c6bd247b12a1c552241', '1', 'chenfeng', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, '2019-10-02 18:23:09', '黄国栋', '18484db93916df5946be64bd9f657833', '736e6f7bb5e8858b99e2d5eed504fe53', '1', 'huanggd', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, '2019-10-02 18:24:35', '殷耀威', 'cc59b227f6009b0b8b1c9fcca442df83', 'a34aa4cae461c565e8b5fad9bd267910', '1', 'yinyw', NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;