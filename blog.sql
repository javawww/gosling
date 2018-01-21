/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-21 14:42:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typeId` int(11) DEFAULT NULL COMMENT '分类ID',
  `typePath` varchar(255) DEFAULT NULL COMMENT '分类路径',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `createId` int(11) DEFAULT NULL COMMENT '创建人id',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', null, '测试测试', '<p>阿道夫阿斯达阿斯顿发行政村vasdf<img src=\"http://localhost:8080/blog//upload/image/20171223/1514037540653051746.jpg\" title=\"1514037540653051746.jpg\" alt=\"1024025.jpg\"/></p>', '阿金', '1', '2017-12-23 21:59:08');

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int(11) DEFAULT NULL COMMENT '父ID',
  `ppath` varchar(255) DEFAULT NULL COMMENT '父路径',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序 ',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES ('1', '0', '/', 'JAVA技术', '1', '2017-12-23 15:37:10');
INSERT INTO `classify` VALUES ('2', '0', null, 'JS技术', '1', '2017-12-23 16:10:41');
INSERT INTO `classify` VALUES ('5', '0', null, 'css技术', '2', '2017-12-23 16:10:43');
INSERT INTO `classify` VALUES ('6', '0', null, 'html技术', '4', '2017-12-23 16:10:10');
INSERT INTO `classify` VALUES ('7', '1', null, 'spring技术', '1', '2017-12-23 19:14:54');
INSERT INTO `classify` VALUES ('8', '1', null, 'mybatis技术', '2', '2017-12-23 19:15:10');
INSERT INTO `classify` VALUES ('10', '2', null, '基础教程', '1', '2017-12-23 19:18:59');
INSERT INTO `classify` VALUES ('11', '2', null, '高级教程', '2', '2017-12-23 19:19:10');
INSERT INTO `classify` VALUES ('12', '0', null, 'php技术', '1', '2017-12-23 19:19:51');
INSERT INTO `classify` VALUES ('13', '7', null, '阿斯达', '2', '2017-12-23 19:55:34');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `introduct` text COMMENT '自我介绍',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `salary` decimal(10,2) DEFAULT NULL COMMENT '薪水',
  `entryTime` datetime DEFAULT NULL COMMENT '入职时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'admin', '123456', '阿金', null);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int(11) DEFAULT NULL COMMENT '父ID',
  `ppath` varchar(255) DEFAULT NULL COMMENT '父路径',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序 ',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '0', '/', 'JAVA技术', '1', '2017-12-23 15:37:10');
INSERT INTO `type` VALUES ('2', '0', null, 'JS技术', '1', '2017-12-23 16:10:41');
INSERT INTO `type` VALUES ('5', '0', null, 'css技术', '2', '2017-12-23 16:10:43');
INSERT INTO `type` VALUES ('6', '0', null, 'html技术', '4', '2017-12-23 16:10:10');
INSERT INTO `type` VALUES ('7', '1', null, 'spring技术', '1', '2017-12-23 19:14:54');
INSERT INTO `type` VALUES ('8', '1', null, 'mybatis技术', '2', '2017-12-23 19:15:10');
INSERT INTO `type` VALUES ('10', '2', null, '基础教程', '1', '2017-12-23 19:18:59');
INSERT INTO `type` VALUES ('11', '2', null, '高级教程', '2', '2017-12-23 19:19:10');
INSERT INTO `type` VALUES ('12', '0', null, 'php技术', '1', '2017-12-23 19:19:51');
INSERT INTO `type` VALUES ('13', '7', null, '阿斯达', '2', '2017-12-23 19:55:34');
