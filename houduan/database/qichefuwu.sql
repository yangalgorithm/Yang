/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : qichefuwu

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 28/02/2025 21:22:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bianhuantu
-- ----------------------------
DROP TABLE IF EXISTS `bianhuantu`;
CREATE TABLE `bianhuantu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mingcheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `tupian` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of bianhuantu
-- ----------------------------
INSERT INTO `bianhuantu` VALUES (1, 'P名称', '/files/download/53', '2025-01-07 19:37:22');
INSERT INTO `bianhuantu` VALUES (2, 'C名称', '/files/download/54', '2025-01-07 19:37:22');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `shangpinxinxiID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (22, 11, 7);
INSERT INTO `collect` VALUES (23, 11, 6);
INSERT INTO `collect` VALUES (24, 10, 6);

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `originName` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fileName` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (1, 'bht1.jpg', 'bht1.jpg');
INSERT INTO `file` VALUES (2, 'bht2.jpg', 'bht2.jpg');
INSERT INTO `file` VALUES (3, 'bht3.jpg', 'bht3.jpg');
INSERT INTO `file` VALUES (4, 'bht4.jpg', 'bht4.jpg');
INSERT INTO `file` VALUES (5, 'bht5.jpg', 'bht5.jpg');
INSERT INTO `file` VALUES (6, 'jiazhengfuwu1.jpg', 'jiazhengfuwu1.jpg');
INSERT INTO `file` VALUES (7, 'jiazhengfuwu2.jpg', 'jiazhengfuwu2.jpg');
INSERT INTO `file` VALUES (8, 'jiazhengfuwu3.jpg', 'jiazhengfuwu3.jpg');
INSERT INTO `file` VALUES (9, 'jiazhengfuwu4.jpg', 'jiazhengfuwu4.jpg');
INSERT INTO `file` VALUES (10, 'jiazhengfuwu5.jpg', 'jiazhengfuwu5.jpg');
INSERT INTO `file` VALUES (11, 'jiazhengfuwu6.jpg', 'jiazhengfuwu6.jpg');
INSERT INTO `file` VALUES (12, 'jiazhengfuwu7.jpg', 'jiazhengfuwu7.jpg');
INSERT INTO `file` VALUES (13, 'jiazhengfuwu8.jpg', 'jiazhengfuwu8.jpg');
INSERT INTO `file` VALUES (14, 'jiazhengfuwu9.jpg', 'jiazhengfuwu9.jpg');
INSERT INTO `file` VALUES (15, 'jiazhengfuwu10.jpg', 'jiazhengfuwu10.jpg');
INSERT INTO `file` VALUES (16, 'yuangongxinxi1.jpg', 'yuangongxinxi1.jpg');
INSERT INTO `file` VALUES (17, 'yuangongxinxi2.jpg', 'yuangongxinxi2.jpg');
INSERT INTO `file` VALUES (18, 'yuangongxinxi3.jpg', 'yuangongxinxi3.jpg');
INSERT INTO `file` VALUES (19, 'yuangongxinxi4.jpg', 'yuangongxinxi4.jpg');
INSERT INTO `file` VALUES (20, 'yuangongxinxi5.jpg', 'yuangongxinxi5.jpg');
INSERT INTO `file` VALUES (21, 'yuangongxinxi6.jpg', 'yuangongxinxi6.jpg');
INSERT INTO `file` VALUES (22, 'yuangongxinxi7.jpg', 'yuangongxinxi7.jpg');
INSERT INTO `file` VALUES (23, 'yuangongxinxi8.jpg', 'yuangongxinxi8.jpg');
INSERT INTO `file` VALUES (24, 'yuangongxinxi9.jpg', 'yuangongxinxi9.jpg');
INSERT INTO `file` VALUES (25, 'yuangongxinxi10.jpg', 'yuangongxinxi10.jpg');
INSERT INTO `file` VALUES (26, '1.jpg', '11709725407038.jpg');
INSERT INTO `file` VALUES (27, '2.jpg', '21709725412769.jpg');
INSERT INTO `file` VALUES (28, '2.jpg', '21709725418137.jpg');
INSERT INTO `file` VALUES (29, '3.jpg', '31709725423090.jpg');
INSERT INTO `file` VALUES (30, '1BEAA53E-B0EB-3FB7-DCE8-B3D66A5D6771.jpg', '1BEAA53E-B0EB-3FB7-DCE8-B3D66A5D67711709725460497.jpg');
INSERT INTO `file` VALUES (31, '5e4ef0e451852e0114d75eac14f60924.jpeg', '5e4ef0e451852e0114d75eac14f609241709725464571.jpeg');
INSERT INTO `file` VALUES (32, 'R-C.jpg', 'R-C1709725469075.jpg');
INSERT INTO `file` VALUES (33, 'R-C (3).jpg', 'R-C (3)1709725474531.jpg');
INSERT INTO `file` VALUES (34, 'R-C (2).jpg', 'R-C (2)1709725480112.jpg');
INSERT INTO `file` VALUES (35, 'R-C (1).jpg', 'R-C (1)1709725486706.jpg');
INSERT INTO `file` VALUES (36, 'true.jpg', 'true1709725931282.jpg');
INSERT INTO `file` VALUES (37, 'R-C.jpg', 'R-C1709725936939.jpg');
INSERT INTO `file` VALUES (38, 'OIP-C.jpg', 'OIP-C1709725942575.jpg');
INSERT INTO `file` VALUES (39, 'OIP-C (1).jpg', 'OIP-C (1)1709726026515.jpg');
INSERT INTO `file` VALUES (40, 'OIP-C.jpg', 'OIP-C1709726032262.jpg');
INSERT INTO `file` VALUES (41, '11699611_144854599128_2.jpg', '11699611_144854599128_21709726038796.jpg');
INSERT INTO `file` VALUES (42, '3346.jpg_wh860.jpg', '3346.jpg_wh8601709726044648.jpg');
INSERT INTO `file` VALUES (43, '7fa87d83-f260-4eb3-ad01-9ffde0b5eb2e.jpg', '7fa87d83-f260-4eb3-ad01-9ffde0b5eb2e1709726050408.jpg');
INSERT INTO `file` VALUES (44, '20220823235427_8a5dc.thumb.1000_01705056415142.jpg', '20220823235427_8a5dc.thumb.1000_017050564151421733983253071.jpg');
INSERT INTO `file` VALUES (45, '20220823235427_8a5dc.thumb.1000_01705056415142.jpg', '20220823235427_8a5dc.thumb.1000_017050564151421733983316193.jpg');
INSERT INTO `file` VALUES (46, 'yhtx6.jpg', 'yhtx61733983346322.jpg');
INSERT INTO `file` VALUES (47, 'yhtx9.jpg', 'yhtx91733983355608.jpg');
INSERT INTO `file` VALUES (48, 'yonghu4.jpg', 'yonghu41733983378496.jpg');
INSERT INTO `file` VALUES (49, '1.jpg', '11740740782722.jpg');
INSERT INTO `file` VALUES (50, '2.jpg', '21740740869202.jpg');
INSERT INTO `file` VALUES (51, '3.jpg', '31740740931855.jpg');
INSERT INTO `file` VALUES (52, '4.jpg', '41740741026991.jpg');
INSERT INTO `file` VALUES (53, 'images.jpg', 'images1740741285340.jpg');
INSERT INTO `file` VALUES (54, 'images (1).jpg', 'images (1)1740741291248.jpg');

-- ----------------------------
-- Table structure for fuwuleibie
-- ----------------------------
DROP TABLE IF EXISTS `fuwuleibie`;
CREATE TABLE `fuwuleibie`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leibie` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `beizhu` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of fuwuleibie
-- ----------------------------
INSERT INTO `fuwuleibie` VALUES (2, '日常保养', 'abc', '2025-01-07 19:37:47');
INSERT INTO `fuwuleibie` VALUES (3, '故障维修', '无', '2025-01-07 19:37:47');
INSERT INTO `fuwuleibie` VALUES (9, '汽车清洗', '暂无', '2025-01-07 19:37:47');
INSERT INTO `fuwuleibie` VALUES (10, '钣金喷漆', '暂无', '2025-01-07 19:37:47');

-- ----------------------------
-- Table structure for fuwuleixing
-- ----------------------------
DROP TABLE IF EXISTS `fuwuleixing`;
CREATE TABLE `fuwuleixing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leixing` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `beizhu` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fuwuleixing
-- ----------------------------
INSERT INTO `fuwuleixing` VALUES (9, '类型3', '没问题', '2025-02-27 16:05:12');
INSERT INTO `fuwuleixing` VALUES (10, '类型2', '暂无', '2025-02-27 16:05:12');
INSERT INTO `fuwuleixing` VALUES (11, '类型1', 'ok', '2025-02-27 16:05:12');

-- ----------------------------
-- Table structure for fuwupingjia
-- ----------------------------
DROP TABLE IF EXISTS `fuwupingjia`;
CREATE TABLE `fuwupingjia`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fuwumingcheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fuwujiage` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gonghao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `manyiqingkuang` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `pingjianeirong` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `yonghuming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `xingming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of fuwupingjia
-- ----------------------------
INSERT INTO `fuwupingjia` VALUES (2, 'B服务', '99', '005', '正常', '还行打扫的挺好的', '001', '舒畅', '2025-01-07 20:19:39');
INSERT INTO `fuwupingjia` VALUES (3, 'R服务', '73', '001', '满意', '很不错 非常干净', '001', '舒畅', '2025-01-07 20:27:03');
INSERT INTO `fuwupingjia` VALUES (13, '发动机故障检修', '500 元起（视具体情况）', '001', '正常', '订单', '001', '舒畅', '2025-02-28 19:23:44');

-- ----------------------------
-- Table structure for fuwuxinxi
-- ----------------------------
DROP TABLE IF EXISTS `fuwuxinxi`;
CREATE TABLE `fuwuxinxi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fuwubianhao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fuwumingcheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `leixing` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `neirong` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `tupian` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gongsizhanghao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gongsimingcheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gongsidianhua` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `jiage` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `beizhu` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fuwuxinxi
-- ----------------------------
INSERT INTO `fuwuxinxi` VALUES (2, '51434743830146', 'M服务', '', '', '/files/download/65', '023', '中国医药集团总公司', '13184865998', '87', 'abc', '2025-02-27 16:05:12');
INSERT INTO `fuwuxinxi` VALUES (3, '51439848691089', 'E服务', '类型2', '', '/files/download/64', '004', '星河网络有限公司', '13769548711', '94', '暂无', '2025-02-27 16:05:12');
INSERT INTO `fuwuxinxi` VALUES (4, '51431377477728', 'F服务', '类型2', '', '/files/download/63', '005', '星界集团总公司', '13910215489', '31', 'abc', '2025-02-27 16:05:12');
INSERT INTO `fuwuxinxi` VALUES (6, '51430034474233', 'H服务', '类型3', '', '/files/download/62', '003', '九州通集团股份有限公司', '13623256544', '86', '没问题', '2025-02-27 16:05:12');
INSERT INTO `fuwuxinxi` VALUES (7, '51430595686751', 'D服务', '类型2', '', '/files/download/61', '025', '广州有限公司', '13025896548', '75', 'ok', '2025-02-27 16:05:12');
INSERT INTO `fuwuxinxi` VALUES (8, '51438860096014', 'R服务', '类型1', '', '/files/download/60', '034', '苍南仪表有限公司', '13489665487', '96', 'ok', '2025-02-27 16:05:12');
INSERT INTO `fuwuxinxi` VALUES (9, '51434621337965', 'G服务', '类型3', '', '/files/download/59', '020', '上海市股份有限公司', '17505772420', '31', 'abc', '2025-02-27 16:05:12');
INSERT INTO `fuwuxinxi` VALUES (10, '51438767199070', 'N服务', '类型1', '全屋清扫', '/files/download/58', '006', '苍南仪表有限公司', '13587835380', '81', 'abc', '2025-02-27 16:05:12');
INSERT INTO `fuwuxinxi` VALUES (11, '51437883401049', 'A服务', '类型1', '11111', '/files/download/48', '001', '', '13052154877', '87', '没问题', '2025-02-27 16:05:12');

-- ----------------------------
-- Table structure for goumaifuwu
-- ----------------------------
DROP TABLE IF EXISTS `goumaifuwu`;
CREATE TABLE `goumaifuwu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goumaibianhao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fuwubianhao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fuwumingcheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `leixing` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `neirong` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gongsizhanghao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gongsimingcheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gongsidianhua` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `jiage` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gonghao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `jiazhengxingming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `kehuming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `xingming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `lianxidianhua` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `beizhu` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `issh` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '0',
  `iszf` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goumaifuwu
-- ----------------------------
INSERT INTO `goumaifuwu` VALUES (2, '20240514257', '51437883401049', 'A服务', NULL, NULL, '001', '九州通医药集团股份有限公司', '13052154877', '87', '001', '李鹏', '001', '王永民', '13025896548', NULL, '1', '是', '2025-02-27 17:30:38');
INSERT INTO `goumaifuwu` VALUES (3, '202502276952', '51434621337965', 'G服务', '类型3', NULL, '020', '上海市股份有限公司', '17505772420', '31', '020', '马庆炳', '001', '王永民', '13025896548', NULL, '1', '否', '2025-02-27 20:16:26');
INSERT INTO `goumaifuwu` VALUES (4, '202502277965', '51437883401049', 'A服务', '类型1', '11111', '001', NULL, '13052154877', '87', '001', '李鹏', '002', '王柏弘', '17505772420', NULL, '1', '否', '2025-02-27 20:17:50');

-- ----------------------------
-- Table structure for guanliyuan
-- ----------------------------
DROP TABLE IF EXISTS `guanliyuan`;
CREATE TABLE `guanliyuan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `mima` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '0',
  `level` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '管理员',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of guanliyuan
-- ----------------------------
INSERT INTO `guanliyuan` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '0', '管理员', '2025-01-07 19:37:22');

-- ----------------------------
-- Table structure for jiazhengfuwu
-- ----------------------------
DROP TABLE IF EXISTS `jiazhengfuwu`;
CREATE TABLE `jiazhengfuwu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fuwumingcheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `leibie` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fuwujiage` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fuwushichang` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `tupian` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fuwujianjie` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gonghao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `mingzi` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jiazhengfuwu
-- ----------------------------
INSERT INTO `jiazhengfuwu` VALUES (5, '更换机油机滤', '日常保养', '200 元', '1 小时', '/files/download/49', 'ok', '002', '吴官本', '2025-01-07 19:38:04');
INSERT INTO `jiazhengfuwu` VALUES (6, '发动机故障检修', '故障维修', '500 元起（视具体情况）', '2 - 4 小时', '/files/download/50', 'abc', '001', '郑亚斌', '2025-01-07 19:38:04');
INSERT INTO `jiazhengfuwu` VALUES (7, '标准洗车', '汽车清洗', '50 元', '30 分钟', '/files/download/51', '无', '005', '哈登', '2025-01-07 19:38:04');
INSERT INTO `jiazhengfuwu` VALUES (8, '车门钣金喷漆', '钣金喷漆', '800 元', '1 - 2 天（含晾干时间）', '/files/download/52', '没问题', '004', '余少庆', '2025-01-07 19:38:04');

-- ----------------------------
-- Table structure for jiazhenggongsi
-- ----------------------------
DROP TABLE IF EXISTS `jiazhenggongsi`;
CREATE TABLE `jiazhenggongsi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gongsizhanghao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `mima` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gongsimingcheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gongsidianhua` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `dizhi` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `touxiang` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `beizhu` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `level` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '家政公司',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of jiazhenggongsi
-- ----------------------------
INSERT INTO `jiazhenggongsi` VALUES (3, '028', 'dc5c7986daef50c1e02ab09b442ee34f', '九州通集团股份有限公司', '13748589658', '解放路73号', '/files/download/72', '无', '家政公司', '2025-02-27 16:05:12');
INSERT INTO `jiazhenggongsi` VALUES (4, '022', 'dc5c7986daef50c1e02ab09b442ee34f', '大小姐有限公司', '17505772420', '泰兴路22号', '/files/download/71', '没问题', '家政公司', '2025-02-27 16:05:12');
INSERT INTO `jiazhenggongsi` VALUES (6, '013', 'dc5c7986daef50c1e02ab09b442ee34f', '苍南仪表有限公司', '18759640002', '复兴街27号', '/files/download/70', '没问题', '家政公司', '2025-02-27 16:05:12');
INSERT INTO `jiazhenggongsi` VALUES (7, '033', 'dc5c7986daef50c1e02ab09b442ee34f', '星河网络有限公司', '18956482221', '开明路22号', '/files/download/69', 'abc', '家政公司', '2025-02-27 16:05:12');
INSERT INTO `jiazhenggongsi` VALUES (8, '010', 'dc5c7986daef50c1e02ab09b442ee34f', '上海市家政股份有限公司', '13910215489', '鑫和锦园2栋', '/files/download/68', 'abc', '家政公司', '2025-02-27 16:05:12');
INSERT INTO `jiazhenggongsi` VALUES (9, '012', 'dc5c7986daef50c1e02ab09b442ee34f', '南京保洁股份有限公司', '13769548711', '河滨东路139号', '/files/download/67', '没问题', '家政公司', '2025-02-27 16:05:12');
INSERT INTO `jiazhenggongsi` VALUES (11, '001', 'dc5c7986daef50c1e02ab09b442ee34f', '广州有限公司', '13623256544', '龙翔路11号', '/files/download/66', '没问题', '家政公司', '2025-02-27 16:05:12');

-- ----------------------------
-- Table structure for jiazhengrenyuan
-- ----------------------------
DROP TABLE IF EXISTS `jiazhengrenyuan`;
CREATE TABLE `jiazhengrenyuan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `mima` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `jiazhengxingming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `shenfenzheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `lianxidianhua` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `xingbie` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `jiguan` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `touxiang` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `congyeshijian` date NULL DEFAULT NULL,
  `gongsizhanghao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gongsimingcheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gongsidianhua` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `beizhu` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `level` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '家政人员',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of jiazhengrenyuan
-- ----------------------------
INSERT INTO `jiazhengrenyuan` VALUES (3, '005', 'dc5c7986daef50c1e02ab09b442ee34f', '李景阳', '330327199504059511', '13587835380', '0', '海南', '/files/download/80', '2025-02-27', '010', '苍南仪表有限公司', '13769548711', '暂无', '家政人员', '2025-02-27 16:05:12');
INSERT INTO `jiazhengrenyuan` VALUES (4, '008', 'dc5c7986daef50c1e02ab09b442ee34f', '孙俪', '33032719900723568X', '13489665487', '0', '天津', '/files/download/79', '2025-02-27', '017', '华莱士有限公司', '13587835380', 'abc', '家政人员', '2025-02-27 16:05:12');
INSERT INTO `jiazhengrenyuan` VALUES (5, '024', 'dc5c7986daef50c1e02ab09b442ee34f', '袁庆轩', '140781200302155562', '13623256544', '1', '辽宁', '/files/download/78', '2025-02-27', '015', '华莱士有限公司', '13186835580', 'abc', '家政人员', '2025-02-27 16:05:12');
INSERT INTO `jiazhengrenyuan` VALUES (6, '021', 'dc5c7986daef50c1e02ab09b442ee34f', '黄行阳', '330327198708070789', '13025896548', '0', '吉林', '/files/download/77', '2025-02-27', '007', '上海市医药股份有限公司', '17706641413', '没问题', '家政人员', '2025-02-27 16:05:12');
INSERT INTO `jiazhengrenyuan` VALUES (7, '003', 'dc5c7986daef50c1e02ab09b442ee34f', '赵姿吟', '330327198811020456', '18956482221', '0', '北京', '/files/download/76', '2025-02-27', '023', '广州医药有限公司', '13748589658', '暂无', '家政人员', '2025-02-27 16:05:12');
INSERT INTO `jiazhengrenyuan` VALUES (8, '002', 'dc5c7986daef50c1e02ab09b442ee34f', '王柏弘', '330327198501020300', '13159863241', '1', '陕西', '/files/download/75', '2025-02-27', '028', '南京医药股份有限公司', '18759640002', '没问题', '家政人员', '2025-02-27 16:05:12');
INSERT INTO `jiazhengrenyuan` VALUES (9, '020', 'dc5c7986daef50c1e02ab09b442ee34f', '马庆炳', '330327198406150488', '13184865998', '1', '福建', '/files/download/74', '2025-02-27', '020', '苍南仪表有限公司', '13910215489', '无', '家政人员', '2025-02-27 16:05:12');
INSERT INTO `jiazhengrenyuan` VALUES (10, '012', 'dc5c7986daef50c1e02ab09b442ee34f', '温宗达', '330327198805060222', '13544655202', '0', '湖北', '/files/download/73', '2025-02-27', '006', '九州通医药集团股份有限公司', '17505772420', 'abc', '家政人员', '2025-02-27 16:05:12');
INSERT INTO `jiazhengrenyuan` VALUES (11, '001', 'dc5c7986daef50c1e02ab09b442ee34f', '李鹏', '330327185403060589', '17706641413', '0', '山东', '/files/download/49', '2025-02-27', '001', '广州医药有限公司', '13489665487', '没问题', '家政人员', '2025-02-27 16:05:12');

-- ----------------------------
-- Table structure for kehu
-- ----------------------------
DROP TABLE IF EXISTS `kehu`;
CREATE TABLE `kehu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kehuming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `mima` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `xingming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `shenfenzheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `lianxidianhua` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `xingbie` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `jiguan` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `touxiang` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `beizhu` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `level` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '客户',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kehu
-- ----------------------------
INSERT INTO `kehu` VALUES (2, '001', 'dc5c7986daef50c1e02ab09b442ee34f', '王永民', '330327198406150488', '13025896548', '1', '广东', '/files/download/57', 'ok', '客户', '2025-02-27 16:05:12');
INSERT INTO `kehu` VALUES (3, '002', 'dc5c7986daef50c1e02ab09b442ee34f', '王柏弘', '330327198501020300', '17505772420', '1', '浙江', '/files/download/56', 'abc', '客户', '2025-02-27 16:05:12');
INSERT INTO `kehu` VALUES (4, '003', 'dc5c7986daef50c1e02ab09b442ee34f', '陈明希', '330327185403060589', '13587835380', '0', '黑龙江', '/files/download/55', '没问题', '客户', '2025-02-27 16:05:12');
INSERT INTO `kehu` VALUES (5, '004', 'dc5c7986daef50c1e02ab09b442ee34f', '白鹭', '330327199010142546', '13623256544', '0', '河北', '/files/download/54', '暂无', '客户', '2025-02-27 16:05:12');
INSERT INTO `kehu` VALUES (6, '005', 'dc5c7986daef50c1e02ab09b442ee34f', '陈燕琪', '330327198805060222', '13052154877', '0', '山东', '/files/download/47', '暂无', '客户', '2025-02-27 16:05:12');

-- ----------------------------
-- Table structure for liuyanban
-- ----------------------------
DROP TABLE IF EXISTS `liuyanban`;
CREATE TABLE `liuyanban`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cheng` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `touxiang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `biaoti` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `neirong` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `huifu` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `parent` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of liuyanban
-- ----------------------------

-- ----------------------------
-- Table structure for pinglun
-- ----------------------------
DROP TABLE IF EXISTS `pinglun`;
CREATE TABLE `pinglun`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pinglunneirong` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `pingfen` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `biao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `pinglunren` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shujuid` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of pinglun
-- ----------------------------
INSERT INTO `pinglun` VALUES (33, '好', '5', 'yuangongxinxi', '001', '2025-01-07 20:38:23', '4');
INSERT INTO `pinglun` VALUES (34, '很负责', '5', 'yuangongxinxi', '001', '2025-01-07 20:49:35', '8');
INSERT INTO `pinglun` VALUES (35, '0', '5', 'yuangongxinxi', '001', '2025-02-28 19:19:23', '7');
INSERT INTO `pinglun` VALUES (36, '好', '5', 'jiazhengfuwu', '001', '2025-02-28 19:19:34', '6');

-- ----------------------------
-- Table structure for xinwentongzhi
-- ----------------------------
DROP TABLE IF EXISTS `xinwentongzhi`;
CREATE TABLE `xinwentongzhi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `biaoti` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `leibie` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `neirong` longtext CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL,
  `dianjilv` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `dianzan_d` int(11) NULL DEFAULT 0,
  `dianzan_c` int(11) NULL DEFAULT 0,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of xinwentongzhi
-- ----------------------------
INSERT INTO `xinwentongzhi` VALUES (10, '浙江省历史文化遗产保护管理委员会召开年会', '站内新闻', '&nbsp;&nbsp;&nbsp;&nbsp;省历史文化遗产保护管理委员会2010年度会议月26日在杭召开。副省长郑继伟出席会议并讲话。 \r\n<P>　　会议强调，我省要在世界文化遗产申报上有新的推进，梯度推进我省申遗工作；要在文化遗产普查上有新的推进，保障成果有效转化；要在文化遗产保护队伍和设施建设上有新的推进，形成较完善的工作人才培训体系；要在合理利用上有新的推进，努力把历史文化资源优势融入现代生活；要在科技创新上有新的推进，进一步加大政策、资金等方面的支持力度；要在营造氛围上有新的推进，利用好“文化遗产日”等开展宣传展示工作。 \r\n<P>　　会议要求，各级政府要进一步加强对文化遗产保护工作的领导，把它纳入经济社会发展规划，纳入城乡建设规划，纳入地方财政预算，实行目标责任考核。</P>', '66', 0, 0, '2025-01-07 19:37:22');
INSERT INTO `xinwentongzhi` VALUES (11, '我国明年可能投资1.4万亿建1000万套保障房', '站内新闻', '<P>　　2011年，全国保障性安居工程住房建设规模或将高达1000万套，相比2010年的580万套，增长72.4%，以此计算，2011年保障性安居工程投资或将达1.4万亿元。而计划新增的420万套住房中，公共租赁房将占主要部分。这预示着保障房建设黄金期即将来临。</P>\r\n<P>　　住建部日前正在向各地发出《关于报送城镇保障性安居工程任务的通知》(以下简称“通知”)，这份通知明确提出，2011年计划建设保障性安居工程任务是1000万套，这相比2010年新增420万套，且公共租赁房将占主要部分。</P>\r\n<P>　　<STRONG>明年将建1000万套保障房</STRONG></P>\r\n<P>　　按照住建部的要求，各地提出具体任务目标时，要结合本地中偏下收入家庭、新就业职工和外来务工人员规模、住房等情况，重点规划安排好公共租赁住房建设任务。</P>\r\n<P>　　根据通知要求，12月10日前，各省级政府要完成相关规划，上报住建部、发改委、财政部等相关部门。</P>\r\n<P>　　通知表示，2011年计划建设保障性安居工程任务为1000万套，为落实任务，各地要综合考虑本地区财力状况、住房保障状况等，2011年计划任务要在原有《2010-2012年保障性住房建设规划》的基础上进行调整，并确保将计划落实到市县。</P>\r\n<P>　　<STRONG>投资规模预计达1.4万亿元</STRONG></P>\r\n<P>　　记者注意到，根据住建部统计，截至今年9月份时，全国保障性安居工程已完成投资4700亿元，占全年计划的60%，且中央财政692亿元专项补助资金已经全部下达。</P>\r\n<P>　　按以上数据推算，明年1000万套保障房的建设目标远超此前市场预期，意味着2011年保障性安居工程投资将达1.4万亿元，达到全国房地产投资规模的五分之一左右。</P>\r\n<P>　　<STRONG>建设资金瓶颈有望获突破</STRONG></P>\r\n<P>　　值得关注的是，资金问题是保障房建设普遍面临的难题，为此今后国家有关部门将继续鼓励各地探索建立保障性住房建设融资平台，尽快建立起由政府主导的市场化投融资和建设机制，从而实现保障性住房建设可持续发展。</P>\r\n<P>　　不久前，有关部门负责人强调，各地为保障性安居工程建立的融资平台不在清理地方融资平台范围之内。而且，随着公积金闲置资金支持保障性住房建设的试点的逐步成熟，覆盖面必将扩大。</P>\r\n<P>　　另外，记者了解到，有些地区还在开展房地产投资信托基金试点准备，有望摸索出一条利用资本市场解决保障性住房建设资金的道路。 文/记者李洪鹏</P>\r\n<P>　　<STRONG>北京落点</STRONG></P>\r\n<P>　　<STRONG>今年可交5万套将超额完成</STRONG></P>\r\n<P>　　市住建委透露，截至目前，今年竣工交用4.6万套保障性住房的任务已经完成。</P>\r\n<P>　　根据保障性住房的建设进展，预计全年实际竣工交用的政策房可达到5万套。同时，本市年初计划新开建设和收购各类政策性住房13.6万套，而这一数据已经上升至14万套。</P>\r\n<P>　　“十二五”期间，北京已初步确定了“政策房比重提高，商品房比重降低”的思路，重点建设公租房。</P>\r\n<P>　　市委、市政府已经决定，明年起，本市公租房建设比例要扩大到保障房建设规模的60%以上，市领导要求密切协调配合，确保目标的完成。 文/记者陈斯</P><!-- publish_helper_end --><!-- google_ad_section_end --><!-- 正文内容 end --><!-- $ {新版相关媒体新闻显示} -->', '1', 0, 0, '2025-01-07 19:37:22');

-- ----------------------------
-- Table structure for yonghuxinxi
-- ----------------------------
DROP TABLE IF EXISTS `yonghuxinxi`;
CREATE TABLE `yonghuxinxi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `xingming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `xingbie` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `mima` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `shouji` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `shenfenzheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `beizhu` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `level` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '用户',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nicheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `touxiang` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of yonghuxinxi
-- ----------------------------
INSERT INTO `yonghuxinxi` VALUES (2, '006', '伍兆斌', '女', 'dc5c7986daef50c1e02ab09b442ee34f', '13025896548', '330327199504059511', 'ok', '用户', '2025-01-07 19:38:12', '王大锤', '/files/download/45');
INSERT INTO `yonghuxinxi` VALUES (5, '002', '杨颖', '女', 'dc5c7986daef50c1e02ab09b442ee34f', '13184865998', '330327185403060589', 'abc', '用户', '2025-01-07 19:38:12', '小羊睡不醒', '/files/download/47');
INSERT INTO `yonghuxinxi` VALUES (8, '005', '司宪策', '女', 'dc5c7986daef50c1e02ab09b442ee34f', '13186835580', '330327198811020456', '无', '用户', '2025-01-07 19:38:12', '不吃香菜', '/files/download/46');
INSERT INTO `yonghuxinxi` VALUES (11, '001', '舒畅', '男', 'dc5c7986daef50c1e02ab09b442ee34f', '18956482221', '330327198406150488', 'abc', '用户', '2025-01-07 19:38:12', '翻斗乐园牛爷爷', '/files/download/48');

-- ----------------------------
-- Table structure for yuangongxinxi
-- ----------------------------
DROP TABLE IF EXISTS `yuangongxinxi`;
CREATE TABLE `yuangongxinxi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `mima` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `mingzi` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `xingbie` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `zhiwei` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `shanchang` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `shoujihao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fuwufanwei` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `dengji` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `touxiang` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `level` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '员工',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gongzi` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of yuangongxinxi
-- ----------------------------
INSERT INTO `yuangongxinxi` VALUES (4, '005', 'dc5c7986daef50c1e02ab09b442ee34f', '吴亦凡的', '男', '保姆', '看娃', '1888888889', '东大街', '高级', '/files/download/34', '员工', '2025-01-07 19:38:20', '10000');
INSERT INTO `yuangongxinxi` VALUES (7, '004', 'dc5c7986daef50c1e02ab09b442ee34f', '吴官本', '男', '家政', '收拾', '1888888888', '西大街', '高级', '/files/download/35', '员工', '2025-01-07 19:38:20', '10000');
INSERT INTO `yuangongxinxi` VALUES (8, '003', 'dc5c7986daef50c1e02ab09b442ee34f', '郑亚斌', '女', ' 兼职', '钟点工', '1888888887', '南大街', '中级', '/files/download/33', '员工', '2025-01-07 19:38:20', '7000');
INSERT INTO `yuangongxinxi` VALUES (9, '002', 'dc5c7986daef50c1e02ab09b442ee34f', '乔维', '女', ' 月嫂', '月嫂', '1888888886', '西大街', '初级', '/files/download/32', '员工', '2025-01-07 19:38:20', '5000');
INSERT INTO `yuangongxinxi` VALUES (10, '001', 'dc5c7986daef50c1e02ab09b442ee34f', '滕少华', '男', '全能', '全能', '1888888885', '东大街', '中级', '/files/download/30', '员工', '2025-01-07 19:38:20', '7000');

-- ----------------------------
-- Table structure for yuyuejiazheng
-- ----------------------------
DROP TABLE IF EXISTS `yuyuejiazheng`;
CREATE TABLE `yuyuejiazheng`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fuwumingcheng` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `leibie` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fuwujiage` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fuwushichang` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `gonghao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `mingzi` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `yuyueshijian` datetime NULL DEFAULT NULL,
  `yonghuming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `xingming` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `shouji` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `beizhu` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `dizhi` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `issh` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '待审核',
  `shhf` varchar(200) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `iszf` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of yuyuejiazheng
-- ----------------------------
INSERT INTO `yuyuejiazheng` VALUES (19, '标准洗车', '汽车清洗', '50 元', '30 分钟', '005', '哈登', '2025-02-28 07:11:51', '001', '舒畅', '18956482221', NULL, NULL, '已通过', '好', '否', '2025-02-28 19:11:53');
INSERT INTO `yuyuejiazheng` VALUES (20, '发动机故障检修', '故障维修', '500 元起（视具体情况）', '2 - 4 小时', '001', '郑亚斌', '2025-02-28 07:19:38', '001', NULL, NULL, NULL, 'dd', '已通过', '订单', '否', '2025-02-28 19:19:40');
INSERT INTO `yuyuejiazheng` VALUES (21, '更换机油机滤', '日常保养', '200 元', '1 小时', '002', '吴官本', '2026-02-05 12:00:00', '001', '舒畅', '18956482221', NULL, NULL, '待审核', NULL, '是', '2025-02-28 19:23:28');

SET FOREIGN_KEY_CHECKS = 1;
