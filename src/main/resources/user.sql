/*
 Navicat Premium Data Transfer

 Source Server         : 本机数据库
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : test01

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 06/06/2022 00:08:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1111', '$2a$10$GPTbcNCr5RcDu1MHwVozd.Yrg8tOVS7z5w4w2ul5IxNTOS0ZsvZqy', '封禁', 'ROLE_SEAL');
INSERT INTO `user` VALUES ('2222', '$2a$10$GPTbcNCr5RcDu1MHwVozd.Yrg8tOVS7z5w4w2ul5IxNTOS0ZsvZqy', '用户', 'ROLE_USER');
INSERT INTO `user` VALUES ('3333', '$2a$10$GPTbcNCr5RcDu1MHwVozd.Yrg8tOVS7z5w4w2ul5IxNTOS0ZsvZqy', 'vip', 'ROLE_VIP');
INSERT INTO `user` VALUES ('4444', '$2a$10$GPTbcNCr5RcDu1MHwVozd.Yrg8tOVS7z5w4w2ul5IxNTOS0ZsvZqy', '管理员', 'ROLE_MANAGER');

SET FOREIGN_KEY_CHECKS = 1;
