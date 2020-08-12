/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : store

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 12/08/2020 19:47:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for count
-- ----------------------------
DROP TABLE IF EXISTS `count`;
CREATE TABLE `count`  (
  `min` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `max` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of count
-- ----------------------------
INSERT INTO `count` VALUES ('1000', '3000', '0.98');
INSERT INTO `count` VALUES ('3000', '5000', '0.95');
INSERT INTO `count` VALUES ('5000', '10000', '0.9');
INSERT INTO `count` VALUES ('10000', '15000', '0.88');
INSERT INTO `count` VALUES ('15000', '20000', '0.85');

-- ----------------------------
-- Table structure for income
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income`  (
  `wareid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `warename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `warenum` int(11) NULL DEFAULT NULL,
  `realprize` double NULL DEFAULT NULL,
  `sumprize` double NULL DEFAULT NULL,
  `saletime` datetime(0) NULL DEFAULT NULL,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of income
-- ----------------------------
INSERT INTO `income` VALUES ('2000001', '中长裙', 'M', '酒红色', 1, 168, 160, '2020-05-01 11:39:57', 'aaa');
INSERT INTO `income` VALUES ('9000099', '港式衬衣', 'S', '卡其色', 2, 128, 256, '2020-07-29 11:40:03', 'li');
INSERT INTO `income` VALUES ('1900114', 'aj', '42', '天空灰', 2, 1780, 1700, '2020-07-30 08:47:25', 'aaa');
INSERT INTO `income` VALUES ('7000003', '棒球帽', '', '', 1, 36, 36, '2020-07-30 08:50:49', 'aaa');
INSERT INTO `income` VALUES ('2000001', '中长裙', 'S', '酒红色', 1, 168, 168, '2020-08-01 11:46:07', 'lp');
INSERT INTO `income` VALUES ('1900114', 'aj', '37', '天空灰', 1, 1780, 1780, '2020-08-01 17:39:30', 'mmp');
INSERT INTO `income` VALUES ('7000003', '棒球帽', '均码', '', 1, 36, 36, '2020-08-01 17:41:38', 'pp');
INSERT INTO `income` VALUES ('1900114', 'aj', '37', '天空灰', 1, 1780, 1780, '2020-08-01 17:47:49', 'pp');
INSERT INTO `income` VALUES ('1900114', 'aj', '', '', 1, 1780, 1680, '2020-08-01 17:51:36', 'aaa');
INSERT INTO `income` VALUES ('2000002', 'A字裙', '', '', 1, 130, 120, '2020-08-01 17:53:17', 'li');
INSERT INTO `income` VALUES ('2000002', 'A字裙', '', '', 2, 130, 130, '2020-08-01 17:57:22', 'mmp');
INSERT INTO `income` VALUES ('2000002', 'A字裙', 'M', '黑色', 1, 130, 130, '2020-08-01 18:02:16', 'li');
INSERT INTO `income` VALUES ('2000001', '中长裙', 'S', '酒红色', 1, 168, 150, '2020-08-01 23:03:57', 'aaa');
INSERT INTO `income` VALUES ('1900114', 'aj', '42', '', 1, 1780, 1700, '2020-08-02 10:36:18', 'aaa');
INSERT INTO `income` VALUES ('1900114', 'aj', '', '', 1, 1780, 1780, '2020-08-02 10:50:25', 'aaa');
INSERT INTO `income` VALUES ('200001', '中长裙', '', '', 1, 168, 155, '2020-08-02 19:26:32', 'aaa');
INSERT INTO `income` VALUES ('1900114', 'aj', '37', '黑色', 1, 1780, 1780, '2020-08-02 23:35:40', 'lp');
INSERT INTO `income` VALUES ('2000001', '中长裙', 'S', '酒红色', 1, 168, 168, '2020-08-03 00:19:39', 'li');

-- ----------------------------
-- Table structure for menber
-- ----------------------------
DROP TABLE IF EXISTS `menber`;
CREATE TABLE `menber`  (
  `mid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `msex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mtel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mcount` double NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menber
-- ----------------------------
INSERT INTO `menber` VALUES ('00008', 'Fairy', '女', '909090', 0.8);
INSERT INTO `menber` VALUES ('00021', 'Chung', '男', '998013', 0.75);
INSERT INTO `menber` VALUES ('10001', '小环', '女', '102778', 0.8);
INSERT INTO `menber` VALUES ('10006', '胡毅', '男', '666666', 0.88);
INSERT INTO `menber` VALUES ('10021', '莉莉', '女', '321111', 0.95);
INSERT INTO `menber` VALUES ('10031', '陈赫', '男', '999990', 0.85);
INSERT INTO `menber` VALUES ('10035', '王利', '男', '689099', 0.9);
INSERT INTO `menber` VALUES ('10098', '陈恒', '男', '988900', 0.95);
INSERT INTO `menber` VALUES ('20004', '王杰', '男', '890123', 0.8);
INSERT INTO `menber` VALUES ('80021', 'Cindy', '女', '780991', 0.9);
INSERT INTO `menber` VALUES ('80065', 'coco', '女', '666890', 0.88);
INSERT INTO `menber` VALUES ('90001', '李希', '女', '998676', 0.78);
INSERT INTO `menber` VALUES ('90005', 'ad', '男', '892141', 0.9);

-- ----------------------------
-- Table structure for setting
-- ----------------------------
DROP TABLE IF EXISTS `setting`;
CREATE TABLE `setting`  (
  `sid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of setting
-- ----------------------------
INSERT INTO `setting` VALUES ('1', '仓库管理系统');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iden` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `income` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('aaa', '123456', '朱莉', '经理', '0.1');
INSERT INTO `staff` VALUES ('admin', '111111', '王曦', '董事', '0.8');
INSERT INTO `staff` VALUES ('li', '123456', 'cily', '经理', '0.1');
INSERT INTO `staff` VALUES ('lp', '999999', '陈欢', '员工', '0.02');
INSERT INTO `staff` VALUES ('mmp', '123000', '陈恒', '经理', '0.1');
INSERT INTO `staff` VALUES ('pp', '000000', '王利', '员工', '0.02');
INSERT INTO `staff` VALUES ('qq', '102329', 'fy', '老板', '0.5');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lable` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('aaa', '123456', '2');
INSERT INTO `user` VALUES ('admin', '111111', '2');
INSERT INTO `user` VALUES ('cc', '123456', '2');
INSERT INTO `user` VALUES ('li', '123456', '2');
INSERT INTO `user` VALUES ('lp', '999999', '1');
INSERT INTO `user` VALUES ('mmp', '123000', '2');
INSERT INTO `user` VALUES ('pp', '000000', '1');
INSERT INTO `user` VALUES ('qq', '102329', '2');

-- ----------------------------
-- Table structure for ware
-- ----------------------------
DROP TABLE IF EXISTS `ware`;
CREATE TABLE `ware`  (
  `wareid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `warename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `waredd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inprize` double(255, 0) NULL DEFAULT NULL,
  `outprize` double(255, 0) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`wareid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ware
-- ----------------------------
INSERT INTO `ware` VALUES ('1900114', 'aj', '0114', '天空灰，黑色', '36,37,38,39,40,41,42', 1280, 1780, 10);
INSERT INTO `ware` VALUES ('2000001', '中长裙', '0001', '酒红色', 'XS,S,M,L', 78, 168, 20);
INSERT INTO `ware` VALUES ('2000002', 'A字裙', '0002', '黑色', 'S,M,L', 66, 130, 50);
INSERT INTO `ware` VALUES ('2000003', '鞋子', '0011', '红色', '34', 133, 111, 77);
INSERT INTO `ware` VALUES ('5000678', '椰子鞋', '0678', '灰色', '36,37,38,39,40,41,42', 1200, 1880, 10);
INSERT INTO `ware` VALUES ('5400919', 'jk', '0919', '黑色', 'S,M,L,XL', 430, 588, 20);
INSERT INTO `ware` VALUES ('7000003', '棒球帽', '0003', '黑色', '均码', 25, 36, 50);
INSERT INTO `ware` VALUES ('9000099', '港式衬衣', '0099', '卡其色', 'XS,S,M', 56, 128, 50);
INSERT INTO `ware` VALUES ('9000321', '长丝袜', '0321', '黑色，肉色', '均码', 15, 30, 200);
INSERT INTO `ware` VALUES ('9008901', '渔夫帽', '8901', '黑色，浅咖色', '均码', 15, 25, 15);
INSERT INTO `ware` VALUES ('9800032', '阔腿裤', '0032', '黑色，牛仔色', 'S,M,L,XL', 88, 170, 20);

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `workerid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `workername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `workertel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wokerhome` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wareid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`workerid`) USING BTREE,
  INDEX `wareid`(`wareid`) USING BTREE,
  CONSTRAINT `wareid` FOREIGN KEY (`wareid`) REFERENCES `ware` (`wareid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('175102', 'lili', '190999', '陕西省', '2000002');
INSERT INTO `worker` VALUES ('182108', '王思', '111111', '广东省', '2000001');
INSERT INTO `worker` VALUES ('195021', '张三', '666666', '湖南省', '1900114');
INSERT INTO `worker` VALUES ('198036', '七七', '343211', '浙江省', '9000099');
INSERT INTO `worker` VALUES ('209111', '陈竹', '671211', '湖北省', '7000003');

SET FOREIGN_KEY_CHECKS = 1;
