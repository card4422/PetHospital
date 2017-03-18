/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : pethospital

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-19 00:18:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for case
-- ----------------------------
DROP TABLE IF EXISTS `case`;
CREATE TABLE `case` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `case_name` varchar(255) DEFAULT NULL,
  `symptom` int(11) DEFAULT NULL,
  `examination` int(11) DEFAULT NULL,
  `result` int(11) DEFAULT NULL,
  `method` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of case
-- ----------------------------

-- ----------------------------
-- Table structure for case_resource
-- ----------------------------
DROP TABLE IF EXISTS `case_resource`;
CREATE TABLE `case_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of case_resource
-- ----------------------------

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examination _name` varchar(255) DEFAULT NULL,
  `examination _price` float DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examination
-- ----------------------------

-- ----------------------------
-- Table structure for hospital_record
-- ----------------------------
DROP TABLE IF EXISTS `hospital_record`;
CREATE TABLE `hospital_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient` varchar(255) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital_record
-- ----------------------------

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(255) DEFAULT NULL,
  `medicine_price` float DEFAULT NULL,
  `medicine_type` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('1', 'm1', '1.2', '1', 'med1');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` date DEFAULT NULL,
  `patient` varchar(255) DEFAULT NULL,
  `pet_type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `room_access` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `room_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `room_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  `user_type` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhu', 'zhu', '1');
INSERT INTO `user` VALUES ('2', 'yang', 'yang', '0');
INSERT INTO `user` VALUES ('3', 'xu', 'xu', '1');
INSERT INTO `user` VALUES ('4', 'james', 'james', '0');
INSERT INTO `user` VALUES ('5', 'harden', 'harden', '1');
INSERT INTO `user` VALUES ('6', 'kobe', 'kobe', '0');
INSERT INTO `user` VALUES ('7', 'curry', 'curry', '1');
INSERT INTO `user` VALUES ('8', 'capela', 'capela', '0');
INSERT INTO `user` VALUES ('9', 'messi', 'messi', '1');
INSERT INTO `user` VALUES ('10', 'xavi', 'xavi', '0');
INSERT INTO `user` VALUES ('11', 'neymar', 'neymar', '1');
INSERT INTO `user` VALUES ('12', 'pique', 'pique', '0');
INSERT INTO `user` VALUES ('13', 'pogba', 'pogba', '1');
INSERT INTO `user` VALUES ('14', 'rooney', 'rooney', '0');
INSERT INTO `user` VALUES ('15', 'kante', 'kante', '1');
