/*
Navicat MySQL Data Transfer

Source Server         : cxdb
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : pet

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2020-04-03 19:12:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(64) NOT NULL COMMENT '客户编号',
  `pet_number` varchar(20) NOT NULL COMMENT '宠艾号',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户名称',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `portrait` varchar(255) DEFAULT NULL COMMENT '头像',
  `wx_unionId` varchar(128) DEFAULT NULL COMMENT '微信UnionId',
  `wx_number` varchar(64) DEFAULT NULL COMMENT '微信号',
  `profile` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `back_img` varchar(255) DEFAULT NULL COMMENT '背景图',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_partnership` int(2) DEFAULT '0' COMMENT '是否为合作关系 1-合作',
  `deleted` int(2) DEFAULT '0' COMMENT '是否有效',
  PRIMARY KEY (`id`,`uuid`),
  KEY `index_uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', 'ce47b06d-91d5-433b-8d80-b32d173c3fbf', '', 'cxx', '17701436110', null, '1', '25', 'https://oss.tobetibetan.com/czx_file/137f730331b64de6bb699d18052c807b.jpg?690,712', null, null, '你好，谢谢关注', null, null, '2020-03-23 17:56:17', null, '0');

-- ----------------------------
-- Table structure for t_customer_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_comment`;
CREATE TABLE `t_customer_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户uuid',
  `works_id` bigint(20) NOT NULL COMMENT '作品id',
  `remark` text COLLATE utf8mb4_unicode_ci COMMENT '评论内容',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除 0没有 1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户评论表';

-- ----------------------------
-- Records of t_customer_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_customer_point
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_point`;
CREATE TABLE `t_customer_point` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
  `works_id` bigint(20) NOT NULL COMMENT '作品id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户点赞表';

-- ----------------------------
-- Records of t_customer_point
-- ----------------------------

-- ----------------------------
-- Table structure for t_customer_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_relation`;
CREATE TABLE `t_customer_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_customer_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关注人uuid',
  `to_customer_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '被关注人id',
  `relation_type` int(1) DEFAULT '1' COMMENT '关系类型;1-粉丝  2-黑名单',
  `deleted` int(1) DEFAULT '0',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户关系表';

-- ----------------------------
-- Records of t_customer_relation
-- ----------------------------

-- ----------------------------
-- Table structure for t_history_match
-- ----------------------------
DROP TABLE IF EXISTS `t_history_match`;
CREATE TABLE `t_history_match` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '每次比赛信息为一张图，图片地址',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='历史比赛表\r\n\r\n设计稿5-5, 所有的比赛信息为图片  ';

-- ----------------------------
-- Records of t_history_match
-- ----------------------------

-- ----------------------------
-- Table structure for t_system_money
-- ----------------------------
DROP TABLE IF EXISTS `t_system_money`;
CREATE TABLE `t_system_money` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '金币图片',
  `amount` int(11) DEFAULT NULL COMMENT '系统都是整数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统固定的充币金额';

-- ----------------------------
-- Records of t_system_money
-- ----------------------------
INSERT INTO `t_system_money` VALUES ('1', null, '15');
INSERT INTO `t_system_money` VALUES ('2', null, '60');
INSERT INTO `t_system_money` VALUES ('3', null, '150');

-- ----------------------------
-- Table structure for t_works
-- ----------------------------
DROP TABLE IF EXISTS `t_works`;
CREATE TABLE `t_works` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户uuid',
  `first_img` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '首图地址',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作品内容（视频或者图片链接）',
  `describe` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作品内容文字描述',
  `p_x` decimal(10,5) DEFAULT NULL COMMENT '纬度',
  `p_y` decimal(10,5) DEFAULT NULL COMMENT '经度',
  `is_recommend` int(2) DEFAULT '0' COMMENT '是否推荐',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_match` int(2) DEFAULT '0' COMMENT '是否参加比赛，1-参加',
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='作品表';

-- ----------------------------
-- Records of t_works
-- ----------------------------
