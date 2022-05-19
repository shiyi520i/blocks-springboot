/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : recruitment

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 19/05/2022 09:44:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_bus_applylist
-- ----------------------------
DROP TABLE IF EXISTS `t_bus_applylist`;
CREATE TABLE `t_bus_applylist`  (
  `id` int NOT NULL COMMENT '营业执照号码',
  `loginid` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录id',
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件地址',
  `license` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照照片',
  `represent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法定代表人姓名',
  `representphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法定代表人电话',
  `number` int NULL DEFAULT NULL COMMENT '身份证号码',
  `frontimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证正面照地址',
  `backimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证反面照地址',
  `handimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手持身份证照地址',
  `phone` int NULL DEFAULT NULL COMMENT '联系人电话号码',
  `time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间',
  `type` int NULL DEFAULT NULL COMMENT '审核状态，0:未审核，1：未通过，2：已通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bus_applylist
-- ----------------------------
INSERT INTO `t_bus_applylist` VALUES (0, NULL, '1', '1', '', '1', '1', 1, '', '', '', 1, '2022-04-21 15:54:51', 0);
INSERT INTO `t_bus_applylist` VALUES (1, NULL, '1', '1', '', '1', '1', 1, '', '', '', 1, '2022-04-21 16:03:03', 1);
INSERT INTO `t_bus_applylist` VALUES (2, NULL, '1', '1', '', '1', '1', 1, '', '', '', 1, '2022-04-21 16:03:06', 2);
INSERT INTO `t_bus_applylist` VALUES (33, '6238114fe0dba61a880974ad', 'qqq', '', '', '', '', 0, '', '', '', 0, '2022-05-07 10:31:57', NULL);
INSERT INTO `t_bus_applylist` VALUES (123, '6238114fe0dba61a880974ad', '', '', '', '', '', 0, '', '', '', 0, '2022-05-07 10:49:47', 2);
INSERT INTO `t_bus_applylist` VALUES (1111, NULL, '', '', '', '', '', 0, '', '', '', 0, '2022-05-07 10:48:48', 2);

-- ----------------------------
-- Table structure for t_bus_chat
-- ----------------------------
DROP TABLE IF EXISTS `t_bus_chat`;
CREATE TABLE `t_bus_chat`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `sender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送者id',
  `receiver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收者id',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bus_chat
-- ----------------------------

-- ----------------------------
-- Table structure for t_bus_chatlist
-- ----------------------------
DROP TABLE IF EXISTS `t_bus_chatlist`;
CREATE TABLE `t_bus_chatlist`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人id',
  `loginid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bus_chatlist
-- ----------------------------

-- ----------------------------
-- Table structure for t_bus_companyinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_bus_companyinfo`;
CREATE TABLE `t_bus_companyinfo`  (
  `login_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `companyname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司名称',
  `type` int NULL DEFAULT NULL COMMENT '行业类型',
  `number` int NULL DEFAULT NULL COMMENT '公司规模',
  `landline` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '座机',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `area` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县',
  `address` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体地址',
  `logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'logo存放地址',
  `status` int NULL DEFAULT NULL COMMENT ' 0：停用，1：正常',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司简介',
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bus_companyinfo
-- ----------------------------
INSERT INTO `t_bus_companyinfo` VALUES ('6238114fe0dba61a880974ad', '广东好极有限公司', 1002, 2222, '2222', '2222', '广东省', '广州市', NULL, '1001', 'https://1-1310671968.cos.ap-guangzhou.myqcloud.com/images/avatar.jpg', NULL, '好极有限公司');
INSERT INTO `t_bus_companyinfo` VALUES ('626604922670050e48ed71f9', '广东无敌有限公司', 1001, 1222, '12345678910', '1222@qq.com', '1222', '1222', '1222', '1222', 'https://1-1310671968.cos.ap-guangzhou.myqcloud.com/images/avatar.jpg', NULL, '阿里巴巴集团的使命是让天下没有难做的生意。\r\n                我们旨在助力企业，帮助其变革营销、销售和经营的方式，提升其效率。我们为商家、品牌、零售商及其他企业提供技术基础设施以及营销平台，帮助其借助新技术的力量与用户和客户进行互动，并更高效地经营。\r\n                更多招聘信息请登陆：\r\n                https://talent.alibaba.com/home/');

-- ----------------------------
-- Table structure for t_bus_news
-- ----------------------------
DROP TABLE IF EXISTS `t_bus_news`;
CREATE TABLE `t_bus_news`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `authorid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章内容',
  `greatnum` int NULL DEFAULT NULL COMMENT '夸',
  `scannum` int NULL DEFAULT NULL COMMENT '浏览人数',
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章摘要',
  `html` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'html',
  `time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预览图地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bus_news
-- ----------------------------
INSERT INTO `t_bus_news` VALUES (2, '我无敌你随意', '6238114fe0dba61a880974ad', '我付 了额', 2, 2, '无敌是多么寂寞', '<p>我付 了额</p>\n', '2022-04-19 14:21:55', 'https://1-1310671968.cos.ap-guangzhou.myqcloud.com/images/logo.png');
INSERT INTO `t_bus_news` VALUES (4, '我无敌你随意', '6238114fe0dba61a880974ad', '我付 了额', 2, 2, '无敌是多么寂寞', '<p>我付 了额</p>\n', '2022-04-19 14:21:55', 'https://1-1310671968.cos.ap-guangzhou.myqcloud.com/images/logo.png');
INSERT INTO `t_bus_news` VALUES (5, '我无敌你随意', '6238114fe0dba61a880974ad', '我付 了额', 2, 2, '无敌是多么寂寞', '<p>我付 了额</p>\n', '2022-04-19 15:20:43', 'https://1-1310671968.cos.ap-guangzhou.myqcloud.com/images/logo.png');
INSERT INTO `t_bus_news` VALUES (6, '我无敌你随意', '6238114fe0dba61a880974ad', '我付 了额', 2, 2, '无敌是多么寂寞', '<p>我付 了额</p>\n', '2022-04-19 14:21:55', 'https://1-1310671968.cos.ap-guangzhou.myqcloud.com/images/logo.png');
INSERT INTO `t_bus_news` VALUES (7, '我无敌你随意', '6238114fe0dba61a880974ad', '我付 了额', 2, 2, '无敌是多么寂寞', '<p>我付 了额</p>\n', '2022-04-19 14:21:55', 'https://1-1310671968.cos.ap-guangzhou.myqcloud.com/images/logo.png');
INSERT INTO `t_bus_news` VALUES (8, '我无敌你随意', '6238114fe0dba61a880974ad', '我付 了额', 2, 2, '无敌是多么寂寞', '<p>我付 了额</p>\n', '2022-04-19 14:21:55', 'https://1-1310671968.cos.ap-guangzhou.myqcloud.com/images/logo.png');

-- ----------------------------
-- Table structure for t_bus_record
-- ----------------------------
DROP TABLE IF EXISTS `t_bus_record`;
CREATE TABLE `t_bus_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rid` int NULL DEFAULT NULL COMMENT '职位id',
  `cid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司id',
  `uid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `type` int NULL DEFAULT NULL COMMENT '类型，0：公司邀请面试，1：公司查看个人，2：个人投递简历 ，3：个人查看公司，4个人接受公司面试',
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1178718299 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bus_record
-- ----------------------------
INSERT INTO `t_bus_record` VALUES (1178718289, 21, '6238114fe0dba61a880974ad', '6238114fe0dba61a880974ad', 3, '2022-04-20 15:00:38');
INSERT INTO `t_bus_record` VALUES (1178718290, 23, '6238114fe0dba61a880974ad', '6238114fe0dba61a880974ad', 3, '2022-04-20 15:00:45');
INSERT INTO `t_bus_record` VALUES (1178718291, 25, '6238114fe0dba61a880974ad', '6238114fe0dba61a880974ad', 3, '2022-04-20 15:00:50');
INSERT INTO `t_bus_record` VALUES (1178718292, 26, '6238114fe0dba61a880974ad', '6238114fe0dba61a880974ad', 3, '2022-04-20 15:00:53');
INSERT INTO `t_bus_record` VALUES (1178718293, 21, '6238114fe0dba61a880974ad', '6238114fe0dba61a880974ad', 3, '2022-04-20 15:03:20');
INSERT INTO `t_bus_record` VALUES (1178718294, 21, '6238114fe0dba61a880974ad', '6238114fe0dba61a880974ad', 2, '2022-04-20 15:03:20');
INSERT INTO `t_bus_record` VALUES (1178718295, 21, '6238114fe0dba61a880974ad', '6238114fe0dba61a880974ad', 3, '2022-04-20 16:01:32');
INSERT INTO `t_bus_record` VALUES (1178718296, 21, '626604922670050e48ed71f9', '6238114fe0dba61a880974ad', 3, '2022-04-25 10:34:17');
INSERT INTO `t_bus_record` VALUES (1178718297, 21, '626604922670050e48ed71f9', '6238114fe0dba61a880974ad', 3, '2022-04-25 10:35:06');
INSERT INTO `t_bus_record` VALUES (1178718298, 23, '626604922670050e48ed71f9', '626604922670050e48ed71f9', 2, '2022-04-25 10:35:24');
INSERT INTO `t_bus_record` VALUES (1178718299, 21, '626604922670050e48ed71f9', '6238114fe0dba61a880974ad', 3, '2022-05-07 14:18:49');

-- ----------------------------
-- Table structure for t_bus_recruitinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_bus_recruitinfo`;
CREATE TABLE `t_bus_recruitinfo`  (
  `r_id` int NOT NULL AUTO_INCREMENT,
  `e_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业信息表id  外键',
  `r_post` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `r_jdescript` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位描述',
  `r_jaddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作地址',
  `r_jexperience` int NOT NULL COMMENT '范围（几年到几年或）',
  `r_erequirement` int NOT NULL COMMENT '学历要求',
  `r_jduty` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作职责',
  `r_jrequirement` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作要求',
  `r_number` int NOT NULL COMMENT '招聘人数',
  `r_minsalary` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '最低薪资  0：面议',
  `r_status` int NULL DEFAULT 1 COMMENT '0:关闭   1：开放',
  `r_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `r_worktype` int NULL DEFAULT NULL COMMENT '0:全职  1：兼职',
  `r_welfare` int NULL DEFAULT NULL COMMENT '0:包吃 1：包住 2：包吃住',
  `r_ischeck` int NULL DEFAULT NULL COMMENT '1:已认证   0：未认证',
  `r_stats` int NULL DEFAULT NULL COMMENT '是否急招   0：是  1：否',
  `r_age` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '招聘年龄',
  `r_starttime` datetime NULL DEFAULT NULL COMMENT '招聘开始时间',
  `r_endtime` datetime NULL DEFAULT NULL COMMENT '招聘结束时间',
  `r_maxsalary` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高薪资  ：面议',
  `r_province` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `r_city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `r_area` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县',
  `r_ztype` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业类型',
  `r_welfares` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位福利',
  `conname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位联系人姓名',
  `conphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位联系人电话',
  `conemail` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位联系人邮箱',
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bus_recruitinfo
-- ----------------------------
INSERT INTO `t_bus_recruitinfo` VALUES (2, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, '$.pf.renderColumns(record,\"status\",stateList,\"id\",\"name\")', '$.pf.renderColumns(record,\"status\",stateList,\"id\",\"name\")', 10, '19', 1, '2021-12-09 14:04:34', 1, 3, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '北京', '市辖区', '东城区', '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (3, '626604922670050e48ed71f9', '人事助理', '是人就行', '国贸大夏a栋二楼', 20, 11, '1.另外合肥文化氛围\n2.i前后日期和覅其\n3.科韦杰夫尾款付清二\n4.立刻反击可挖掘', '1.另外合肥文化氛围\n2.i前后日期和覅其\n3.科韦杰夫尾款付清二\n4.立刻反击可挖掘', 1, '19', 1, '2021-12-09 14:04:39', 1, 2, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '北京', '市辖区', '东城区', '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (4, '626604922670050e48ed71f9', '运维', '是人就行', '国贸大夏a栋二楼', 20, 11, '1.五日我国\n2.；我看见更名为', '1.五日我国\n2.；我看见更名为', 2, '19', 1, '2021-12-09 14:32:14', NULL, 1, 1, 0, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (5, '626604922670050e48ed71f9', 'Android', '是人就行', '国贸大夏a栋二楼', 20, 11, '1.将房屋交付\n2.嗯哦哦分几块五七二九', '1.将房屋交付\n2.嗯哦哦分几块五七二九', 6, '19', 1, '2021-12-10 09:45:13', NULL, 1, 1, 0, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (6, '626604922670050e48ed71f9', '前台', '是人就行', '国贸大夏a栋二楼', 20, 11, '无人过问过问如果', '二个人', 5, '19', 1, '2021-12-08 11:15:58', NULL, 1, 1, 0, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (7, '626604922670050e48ed71f9', 'w岗位', '是人就行', '国贸大夏a栋二楼', 20, 11, '二为凤尾', '外公外', 1, '19', 1, '2021-12-08 21:43:28', NULL, 1, 1, 0, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (16, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, 'wgwrgrwg', 'wrgrgergerg', 10, '19', 0, '2021-12-08 11:15:59', NULL, 1, 1, 0, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (21, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, '人格人格', '嗯阿热如果', 10, '19', 1, '2021-12-09 22:49:46', 0, 1, 1, 0, '18-30岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (22, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, 'eqfwejf\nwgfjewbgewj\nwegnewgnwe', 'wgweghwegw\ngwlignwrgkl', 10, '19', 1, '2021-12-09 23:00:07', 1, 2, 1, 0, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (23, '626604922670050e48ed71f9', '前端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, '<textarea name=\"\" cols=\"26\" rows=\"8\" style=\"vertical-align:top ;border-radius: 6px\" id=\"jzhize\" required=\"required\"></textarea>', '无人过问如果', 10, '19', 1, '2021-12-09 22:58:46', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (24, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, '\n                ', 'wefwefewf\n            wefwef    ', 10, '19', 0, '2021-12-09 23:01:37', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (25, '626604922670050e48ed71f9', '前端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, '\n                ', '\n                我如果温热', 10, '19', 1, '2021-12-09 22:46:11', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (26, '626604922670050e48ed71f9', '是啥', '是人就行', '国贸大夏a栋二楼', 20, 11, '\n                ', '无人过问如果\n     为发给我给            ', 20, '19', 1, '2021-12-09 22:54:24', 0, 1, 1, 0, '18-30岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (27, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, '工作职责：', '               微软各位 ', 10, '19', 1, '2021-12-09 22:50:50', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (28, '626604922670050e48ed71f9', 'erge', '是人就行', '国贸大夏a栋二楼', 20, 11, '\n                  <textarea name=\"\" cols=\"26\" rows=\"8\" style=\"vertical-align:top ;border-radius: 6px\" id=\"jzhize\" required=\"required\">                </textarea>\n                ', '                erger ', 10, '19', 1, '2021-12-09 22:51:05', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (29, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, ' wegweg                ', '                rewgwrgwg', 2, '19', 1, '2021-12-09 22:53:54', 0, 1, 1, 0, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (30, '626604922670050e48ed71f9', '前端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, '                ewfwef ', '                wegwegewg', 10, '19', 1, '2021-12-09 23:00:20', 0, 1, 1, 0, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (31, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, '   wrgrwg              ', '         rgergergerg       ', 10, '19', 1, '2021-12-08 11:15:59', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (32, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, '                 二百', '                 为各位', 10, '19', 1, '2021-12-08 11:15:59', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (33, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '国贸大夏a栋二楼', 20, 11, '                 让外人', '                而被人', 10, '19', 1, '2021-12-08 11:15:59', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (34, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '昊杰创新科技园', 20, 11, '                 为各位', '                如果微软', 10, '19', 1, '2021-12-08 11:15:59', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '上海', '市辖区', NULL, '服务业', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (35, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '昊杰创新科技园', 20, 11, '                 为各位', '                我如果温热', 10, '19', 1, '2021-12-08 11:15:59', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '广东', '惠州市', '惠城区', 'IT计算机', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (36, '626604922670050e48ed71f9', '后端开发工程师', '是人就行', '昊杰创新科技园', 20, 11, '                 推荐tea', '                二他会突然', 10, '19', 1, '2021-12-09 23:00:38', 0, 1, 1, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '广东', '惠州市', '惠城区', '销售', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (37, '626604922670050e48ed71f9', '前端开发工程师', NULL, '昊杰创新科技园', 20, 11, '                 wgwgwgwg', '                ', 10, '19', 1, '2021-12-09 10:14:47', 0, 1, NULL, 0, '18-30岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '广东', '惠州市', '惠城区', '销售', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (38, '626604922670050e48ed71f9', '前端开发工程师', NULL, '昊杰创新科技园', 20, 11, 'wegewg', 'wgwg', 10, '19', 1, '2021-12-09 10:16:50', 0, 1, NULL, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '广东', '惠州市', '惠城区', '销售', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (39, '626604922670050e48ed71f9', '后端开发工程师', NULL, '昊杰创新科技园', 20, 11, '如果认为给', '我如果温热', 10, '19', 1, '2021-12-09 10:20:00', 0, 1, NULL, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '广东', '惠州市', '惠城区', '销售', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (40, '626604922670050e48ed71f9', '后端开发工程师', 'wefwefewf', '昊杰创新科技园', 20, 11, 'wefwefwef', 'wefwefwefewf', 1, '19', 1, '2021-12-09 10:27:18', 0, 1, NULL, 1, '18-22岁', '2022-04-05 16:00:00', '2022-04-04 16:00:00', '20', '广东', '惠州市', '惠城区', '销售', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (41, '626604922670050e48ed71f9', '1', '1', '1', 20, 11, '1', '', 1, '1', 1, '2022-04-13 15:52:09', NULL, NULL, NULL, NULL, NULL, '2022-04-05 16:00:00', '2022-04-04 16:00:00', '1', NULL, NULL, NULL, '', '餐补,无敌,租房', '我无敌', '12345678910', '151425@qq.com');
INSERT INTO `t_bus_recruitinfo` VALUES (42, '626604922670050e48ed71f9', '1', '1', '1111', 22, 11, '1', '', 1, '1', 1, '2022-04-20 09:02:39', 0, NULL, NULL, 0, NULL, '2022-04-11 16:00:00', '2022-04-04 16:00:00', '11', NULL, NULL, NULL, '', '30,31,32', NULL, NULL, NULL);
INSERT INTO `t_bus_recruitinfo` VALUES (43, '626604922670050e48ed71f9', '11', '1', '11', 22, 11, '1', '', 111, '1', 1, '2022-04-20 09:58:16', 0, NULL, NULL, 0, NULL, '2022-04-03 16:00:00', '2022-04-04 16:00:00', '1', NULL, NULL, NULL, '', '31,30,32', NULL, NULL, NULL);
INSERT INTO `t_bus_recruitinfo` VALUES (44, '6238114fe0dba61a880974ad', 'aaaa', 'a', 'aaa', 21, 11, 'a', '', 1, '11', 1, '2022-04-20 10:37:25', 0, NULL, NULL, 0, NULL, '2022-04-03 16:00:00', '2022-04-05 16:00:00', '111', NULL, NULL, NULL, '', '住房补贴,交通费,工作午餐', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_bus_sortpost
-- ----------------------------
DROP TABLE IF EXISTS `t_bus_sortpost`;
CREATE TABLE `t_bus_sortpost`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `postid` int NULL DEFAULT NULL COMMENT '职位id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `weight` double NULL DEFAULT NULL COMMENT '权重',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bus_sortpost
-- ----------------------------
INSERT INTO `t_bus_sortpost` VALUES (1, 1, '前端', 3);
INSERT INTO `t_bus_sortpost` VALUES (2, 3, '后端', 5);
INSERT INTO `t_bus_sortpost` VALUES (3, 44, '左端', 6);
INSERT INTO `t_bus_sortpost` VALUES (4, 4, '中端', 7);
INSERT INTO `t_bus_sortpost` VALUES (5, 5, '右端', 8);
INSERT INTO `t_bus_sortpost` VALUES (6, 6, '无端', 4);

-- ----------------------------
-- Table structure for t_bus_weight
-- ----------------------------
DROP TABLE IF EXISTS `t_bus_weight`;
CREATE TABLE `t_bus_weight`  (
  `loginid` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司id',
  `weight` double NULL DEFAULT NULL COMMENT '权重',
  PRIMARY KEY (`loginid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bus_weight
-- ----------------------------
INSERT INTO `t_bus_weight` VALUES ('626604922670050e48ed71f9', 137);

-- ----------------------------
-- Table structure for t_sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_admin`;
CREATE TABLE `t_sys_admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_admin
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_parameter
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_parameter`;
CREATE TABLE `t_sys_parameter`  (
  `id` int NOT NULL COMMENT '子节点id',
  `pid` int NULL DEFAULT NULL COMMENT '父节点id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称',
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代号'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_parameter
-- ----------------------------
INSERT INTO `t_sys_parameter` VALUES (1, 0, '学历要求', 'xlyq');
INSERT INTO `t_sys_parameter` VALUES (10, 1, '高中', NULL);
INSERT INTO `t_sys_parameter` VALUES (11, 1, '专科及以上', NULL);
INSERT INTO `t_sys_parameter` VALUES (12, 1, '本科及以上', NULL);
INSERT INTO `t_sys_parameter` VALUES (13, 1, '研究生及以上', NULL);
INSERT INTO `t_sys_parameter` VALUES (14, 1, '硕士及以上', NULL);
INSERT INTO `t_sys_parameter` VALUES (2, 0, '工作要求', 'gzyq');
INSERT INTO `t_sys_parameter` VALUES (20, 2, '不限', NULL);
INSERT INTO `t_sys_parameter` VALUES (21, 2, '一年以下', NULL);
INSERT INTO `t_sys_parameter` VALUES (22, 2, '1-2年', NULL);
INSERT INTO `t_sys_parameter` VALUES (23, 2, '2-3年', NULL);
INSERT INTO `t_sys_parameter` VALUES (24, 2, '3年以上', NULL);
INSERT INTO `t_sys_parameter` VALUES (3, 0, '工作福利', 'gzfl');
INSERT INTO `t_sys_parameter` VALUES (30, 3, '五险一金', NULL);
INSERT INTO `t_sys_parameter` VALUES (31, 3, '住房补贴', NULL);
INSERT INTO `t_sys_parameter` VALUES (32, 3, '交通费', NULL);
INSERT INTO `t_sys_parameter` VALUES (33, 3, '工作午餐', NULL);
INSERT INTO `t_sys_parameter` VALUES (34, 3, '包住', NULL);
INSERT INTO `t_sys_parameter` VALUES (35, 3, '包吃', NULL);
INSERT INTO `t_sys_parameter` VALUES (100, 0, '行业分类', 'hyfl');
INSERT INTO `t_sys_parameter` VALUES (1001, 100, 'IT服务业', NULL);
INSERT INTO `t_sys_parameter` VALUES (1002, 100, '制造业', NULL);
INSERT INTO `t_sys_parameter` VALUES (1003, 100, '批发/零售', NULL);
INSERT INTO `t_sys_parameter` VALUES (1004, 100, '生活服务', NULL);
INSERT INTO `t_sys_parameter` VALUES (1005, 100, '文化/体育/娱乐业', NULL);
INSERT INTO `t_sys_parameter` VALUES (1006, 100, '建筑/房地产', NULL);
INSERT INTO `t_sys_parameter` VALUES (1007, 100, '教育', NULL);
INSERT INTO `t_sys_parameter` VALUES (1008, 100, '运输/物流/仓储', NULL);
INSERT INTO `t_sys_parameter` VALUES (1009, 100, '医疗', NULL);
INSERT INTO `t_sys_parameter` VALUES (1010, 100, '政府', NULL);
INSERT INTO `t_sys_parameter` VALUES (1011, 100, '金融', NULL);
INSERT INTO `t_sys_parameter` VALUES (1012, 100, '能源/采矿', NULL);
INSERT INTO `t_sys_parameter` VALUES (1013, 100, '农林渔牧', NULL);
INSERT INTO `t_sys_parameter` VALUES (1014, 100, '其他行业', NULL);
INSERT INTO `t_sys_parameter` VALUES (25, 2, '应届生', NULL);
INSERT INTO `t_sys_parameter` VALUES (26, 2, '实习生', NULL);

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`  (
  `login_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录id',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `cvurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简历地址',
  `graduate` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业学校',
  `grtime` datetime NULL DEFAULT NULL COMMENT '毕业时间',
  `position` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期望职位',
  `sex` int NULL DEFAULT NULL COMMENT '性别，1：男，0：女',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('6238114fe0dba61a880974ad', '哈哈', '14155345@qq.com', 111, '河北省-邯郸市-临漳县-d', '12345678910', NULL, '北京大学', '2022-04-20 11:49:21', '董事长', 1, 'https://1-1310671968.cos.ap-guangzhou.myqcloud.com/images/logo.png');
INSERT INTO `t_sys_user` VALUES ('626604922670050e48ed71f9', '我无敌', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://1-1310671968.cos.ap-guangzhou.myqcloud.com/AVATAR/8212465946103716658favicon.ico');

-- ----------------------------
-- Table structure for t_sys_userrole
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_userrole`;
CREATE TABLE `t_sys_userrole`  (
  `login_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录id，与三表关联',
  `type` int NULL DEFAULT NULL COMMENT '用户角色，0：管理员，1：企业，2：用户',
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_userrole
-- ----------------------------
INSERT INTO `t_sys_userrole` VALUES ('6238114fe0dba61a880974ad', 1);
INSERT INTO `t_sys_userrole` VALUES ('626604922670050e48ed71f9', 2);

SET FOREIGN_KEY_CHECKS = 1;
