/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2017-07-20 19:33:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '哈哈', '11');
INSERT INTO `user` VALUES ('2', '呵呵', '23');
