/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : pethospital

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-28 15:58:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for case_entity
-- ----------------------------
DROP TABLE IF EXISTS `case_entity`;
CREATE TABLE `case_entity` (
  `id`             INT(11) NOT NULL AUTO_INCREMENT,
  `case_name`      VARCHAR(255)     DEFAULT NULL,
  `symptom`        INT(11)          DEFAULT NULL,
  `exam`           INT(11)          DEFAULT NULL,
  `result`         INT(11)          DEFAULT NULL,
  `method`         INT(11)          DEFAULT NULL,
  `classification` VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of case_entity
-- ----------------------------
INSERT INTO `case_entity` VALUES ('1', 'c1', '1', '2', '3', '4', 'contagion');
INSERT INTO `case_entity` VALUES ('2', 'c2', '2', '1', '4', '3', 'parasitosis');
INSERT INTO `case_entity` VALUES ('3', 'c3', '3', '4', '1', '2', 'internal');
INSERT INTO `case_entity` VALUES ('4', 'c4', '4', '2', '3', '1', 'external');
INSERT INTO `case_entity` VALUES ('5', 'c5', '3', '2', '1', '4', 'surgery');
INSERT INTO `case_entity` VALUES ('6', 'c6', '1', '3', '2', '4', 'immune');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of case_resource
-- ----------------------------
INSERT INTO `case_resource` VALUES ('1', 'aaa', 'qqq', 'ee');
INSERT INTO `case_resource` VALUES ('2', 'bbb', 'www', 'ff');
INSERT INTO `case_resource` VALUES ('3', 'ccc', 'eee', 'rrr');
INSERT INTO `case_resource` VALUES ('4', 'ddd', 'hhh', 'yyy');

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examination_name` varchar(255) DEFAULT NULL,
  `examination_price` float DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examination
-- ----------------------------
INSERT INTO `examination` VALUES ('1', 'CT', '200', 'CT');
INSERT INTO `examination` VALUES ('2', 'B ultrasound', '400', 'B ultrasound');
INSERT INTO `examination` VALUES ('3', 'NMR', '300', 'NMR');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital_record
-- ----------------------------
INSERT INTO `hospital_record` VALUES ('1', 'shiro', '2017-02-28', '2017-03-01', 'flu');
INSERT INTO `hospital_record` VALUES ('2', 'kuro', '2017-03-24', '2017-03-24', 'cough');
INSERT INTO `hospital_record` VALUES ('3', 'sora', '2017-03-25', '2017-03-28', 'pregnant');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('1', 'm1', '1.2', '1', 'med1');
INSERT INTO `medicine` VALUES ('2', 'm2', '1.5', '1', 'mde2');
INSERT INTO `medicine` VALUES ('3', 'm3', '400', '2', 'med3');

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
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '2017-03-21', 'shiro', 'neko', 'flu', '500');
INSERT INTO `record` VALUES ('2', '2017-02-28', 'kuro', 'inu', 'cough', '200');
INSERT INTO `record` VALUES ('3', '2017-03-23', 'sora', 'tori', 'pregnant', '300');
INSERT INTO `record` VALUES ('4', '2017-04-03', 'abc', 'dog', 'what', '400');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_access` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1 2');
INSERT INTO `role` VALUES ('2', '1 2 3');
INSERT INTO `role` VALUES ('3', '3 4');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `room_type` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', 'room1');
INSERT INTO `room` VALUES ('2', 'room2');
INSERT INTO `room` VALUES ('3', 'room3');

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
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', 'kumamon', 'professor', '1');
INSERT INTO `staff` VALUES ('2', 'konan', 'professor', '1');
INSERT INTO `staff` VALUES ('3', 'pikacyu', 'associate professor', '2');
INSERT INTO `staff` VALUES ('4', 'pudin', 'doctor', '1');
INSERT INTO `staff` VALUES ('5', 'guradon', 'doctor', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  `user_type` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8;

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
INSERT INTO `user` VALUES ('16', '朱', 'zhu', '0');
