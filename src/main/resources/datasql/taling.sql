CREATE database if NOT EXISTS `taling` default character set utf8mb4 collate utf8mb4_general_ci;
use `taling`;
/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : taling

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 27/05/2021 15:46:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `browser` varchar(255) DEFAULT NULL,
                             `ip` varchar(255) DEFAULT NULL,
                             `location` varchar(255) DEFAULT NULL,
                             `login_time` datetime DEFAULT NULL,
                             `system` varchar(255) DEFAULT NULL,
                             `user_name` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of login_log
-- ----------------------------
BEGIN;
INSERT INTO `login_log` VALUES (1, 'Chrome 90', '127.0.0.1', '', '2021-05-27 13:31:18', 'Mac OS X 10_15_7', 'admin');
INSERT INTO `login_log` VALUES (2, 'Chrome 90', '127.0.0.1', '', '2021-05-27 13:34:55', 'Mac OS X 10_15_7', 'admin');
INSERT INTO `login_log` VALUES (3, 'Chrome 90', '127.0.0.1', '', '2021-05-27 13:49:45', 'Mac OS X 10_15_7', 'admin');
INSERT INTO `login_log` VALUES (4, 'Chrome 90', '127.0.0.1', '', '2021-05-27 13:51:17', 'Mac OS X 10_15_7', 'admin');
INSERT INTO `login_log` VALUES (5, 'Chrome 90', '127.0.0.1', '', '2021-05-27 13:57:29', 'Mac OS X 10_15_7', 'admin');
INSERT INTO `login_log` VALUES (6, 'Chrome 90', '127.0.0.1', '', '2021-05-27 15:16:01', 'Mac OS X 10_15_7', 'admin');
INSERT INTO `login_log` VALUES (7, 'Chrome 90', '127.0.0.1', '', '2021-05-27 15:25:38', 'Mac OS X 10_15_7', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
                                  `permission_id` bigint NOT NULL AUTO_INCREMENT,
                                  `create_time` datetime DEFAULT NULL,
                                  `icon` varchar(50) DEFAULT NULL,
                                  `order_num` int DEFAULT NULL,
                                  `parent_id` bigint DEFAULT NULL,
                                  `permission` varchar(50) DEFAULT NULL,
                                  `permission_name` varchar(10) DEFAULT NULL,
                                  `resource_type` varchar(255) DEFAULT NULL,
                                  `update_time` datetime DEFAULT NULL,
                                  `url` varchar(50) DEFAULT NULL,
                                  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_permission` VALUES (1, NULL, NULL, 1, 0, 'system:view', '系统管理', '0', NULL, '#');
INSERT INTO `sys_permission` VALUES (2, '2021-05-27 13:37:12', '', 2, 0, 'user:view', '用户管理', '0', '2021-05-27 13:37:26', 'user/userList');
INSERT INTO `sys_permission` VALUES (3, '2021-05-27 13:38:27', '', 3, 2, 'user:add', '用户添加', '1', '2021-05-27 13:54:17', 'user/userAdd');
INSERT INTO `sys_permission` VALUES (4, '2021-05-27 13:39:08', '', 4, 2, 'user:edit', '用户修改', '1', '2021-05-27 13:54:31', 'user/userEdit');
INSERT INTO `sys_permission` VALUES (5, '2021-05-27 13:39:39', '', 5, 2, 'user:del', '用户删除', '1', '2021-05-27 13:54:36', 'user/userDel');
INSERT INTO `sys_permission` VALUES (6, '2021-05-27 13:41:12', '', 6, 0, 'role:view', '角色管理', '0', '2021-05-27 13:54:40', 'role/roleList');
INSERT INTO `sys_permission` VALUES (8, '2021-05-27 13:43:21', '', 8, 6, 'role:edit', '角色修改', '1', '2021-05-27 13:54:56', 'role/roleEdit');
INSERT INTO `sys_permission` VALUES (9, '2021-05-27 13:42:23', NULL, 7, 6, 'role:add', '角色添加', '1', '2021-05-27 13:54:50', 'role/roleAdd');
INSERT INTO `sys_permission` VALUES (10, '2021-05-27 13:48:07', '', 9, 6, 'role:del', '角色删除', '1', '2021-05-27 13:55:00', 'role/roleDel');
INSERT INTO `sys_permission` VALUES (11, '2021-05-27 13:48:51', NULL, 10, 6, 'role:authorize', '角色授权', '1', '2021-05-27 13:55:05', 'role:authorize');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
                            `role_id` bigint NOT NULL AUTO_INCREMENT,
                            `available` bit(1) DEFAULT NULL,
                            `create_time` datetime DEFAULT NULL,
                            `description` varchar(255) DEFAULT NULL,
                            `role` varchar(255) NOT NULL,
                            PRIMARY KEY (`role_id`),
                            UNIQUE KEY `UK_mwbqlu5c82jfd2w9oa9d6e87d` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, b'1', '2019-08-31 00:00:00', '超级管理员', '超级管理员');
INSERT INTO `sys_role` VALUES (2, b'1', '2019-08-31 00:00:00', '高级用户', '高级用户');
INSERT INTO `sys_role` VALUES (3, b'1', '2019-08-31 00:00:00', '普通用户', '普通用户');
INSERT INTO `sys_role` VALUES (4, b'1', '2019-08-31 00:00:00', '游客', '游客');
INSERT INTO `sys_role` VALUES (6, b'1', '2019-10-02 00:00:00', '系统监控', '系统监控员');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
                                       `id` bigint NOT NULL AUTO_INCREMENT,
                                       `permission_id` bigint DEFAULT NULL,
                                       `role_id` bigint DEFAULT NULL,
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_permission` VALUES (17, 1, 1);
INSERT INTO `sys_role_permission` VALUES (18, 2, 1);
INSERT INTO `sys_role_permission` VALUES (19, 3, 1);
INSERT INTO `sys_role_permission` VALUES (20, 4, 1);
INSERT INTO `sys_role_permission` VALUES (21, 5, 1);
INSERT INTO `sys_role_permission` VALUES (22, 6, 1);
INSERT INTO `sys_role_permission` VALUES (23, 8, 1);
INSERT INTO `sys_role_permission` VALUES (24, 9, 1);
INSERT INTO `sys_role_permission` VALUES (25, 10, 1);
INSERT INTO `sys_role_permission` VALUES (26, 11, 1);
INSERT INTO `sys_role_permission` VALUES (27, 1, 2);
INSERT INTO `sys_role_permission` VALUES (28, 2, 2);
INSERT INTO `sys_role_permission` VALUES (29, 3, 2);
INSERT INTO `sys_role_permission` VALUES (30, 4, 2);
INSERT INTO `sys_role_permission` VALUES (31, 5, 2);
INSERT INTO `sys_role_permission` VALUES (32, 6, 2);
INSERT INTO `sys_role_permission` VALUES (33, 8, 2);
INSERT INTO `sys_role_permission` VALUES (34, 9, 2);
INSERT INTO `sys_role_permission` VALUES (35, 10, 2);
INSERT INTO `sys_role_permission` VALUES (36, 11, 2);
INSERT INTO `sys_role_permission` VALUES (37, 1, 3);
INSERT INTO `sys_role_permission` VALUES (38, 2, 3);
INSERT INTO `sys_role_permission` VALUES (39, 3, 3);
INSERT INTO `sys_role_permission` VALUES (40, 4, 3);
INSERT INTO `sys_role_permission` VALUES (41, 5, 3);
INSERT INTO `sys_role_permission` VALUES (42, 6, 3);
INSERT INTO `sys_role_permission` VALUES (43, 8, 3);
INSERT INTO `sys_role_permission` VALUES (44, 9, 3);
INSERT INTO `sys_role_permission` VALUES (45, 10, 3);
INSERT INTO `sys_role_permission` VALUES (46, 11, 3);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `role_id` bigint DEFAULT NULL,
                                 `user_id` bigint DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
                        `user_id` bigint NOT NULL AUTO_INCREMENT,
                        `create_time` datetime DEFAULT NULL,
                        `nick_name` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `salt` varchar(255) DEFAULT NULL,
                        `state` varchar(255) DEFAULT NULL,
                        `user_name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '2019-08-31 04:00:00', '超级管理员', 'b9951e3b7d82bbdb06e4f0d5ac48ca50', '134ccb279cc3067da0ed5b381bd72a70', '1', 'admin');
INSERT INTO `user` VALUES (2, '2019-08-31 12:00:00', '客户', '8473d52cbbc96bb13930964d02cb620a', '16fcfcb77c137bfbb3b3dc6b8f2e462b', '1', 'cust');
INSERT INTO `user` VALUES (5, '2019-10-02 14:43:18', '陈风', '2e95767f9cad74c77f78ce4be3f0027a', 'b6e7523615f45c6bd247b12a1c552241', '1', 'chenfeng');
INSERT INTO `user` VALUES (6, '2019-10-02 18:23:09', '黄国栋', '18484db93916df5946be64bd9f657833', '736e6f7bb5e8858b99e2d5eed504fe53', '1', 'huanggd');
INSERT INTO `user` VALUES (7, '2019-10-02 18:24:35', '殷耀威', 'cc59b227f6009b0b8b1c9fcca442df83', 'a34aa4cae461c565e8b5fad9bd267910', '1', 'yinyw');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
