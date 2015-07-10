/*
Navicat MySQL Data Transfer

Source Server         : TestDBMS
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : student_info

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-07-10 15:50:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hrd_students
-- ----------------------------
DROP TABLE IF EXISTS `hrd_students`;
CREATE TABLE `hrd_students` (
  `stu_id` varchar(10) NOT NULL,
  `stu_name` varchar(100) NOT NULL,
  `stu_gender` smallint(1) NOT NULL,
  `stu_university` varchar(50) NOT NULL,
  `stu_class` varchar(5) NOT NULL,
  `stu_status` smallint(1) NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hrd_students
-- ----------------------------
INSERT INTO `hrd_students` VALUES ('131N10', 'Neng Channa', '1', 'SETEC', 'BTB', '0');
INSERT INTO `hrd_students` VALUES ('131N11', 'Leang Mardy', '1', 'RUPP', 'SR', '1');
INSERT INTO `hrd_students` VALUES ('131N12', 'Sot So', '1', 'SETEC', 'KPS', '1');
INSERT INTO `hrd_students` VALUES ('131N13', 'Doung Chan Khihort', '1', 'SETEC', 'PP', '1');
INSERT INTO `hrd_students` VALUES ('131N14', 'Anonymous', '0', 'PPIU', 'PP', '1');
