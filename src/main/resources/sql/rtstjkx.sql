/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost:3306
 Source Schema         : rtstjkx

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : 65001

 Date: 03/09/2020 09:55:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_alarm
-- ----------------------------
DROP TABLE IF EXISTS `c_alarm`;
CREATE TABLE `c_alarm`  (
  `ID` int(4) NOT NULL AUTO_INCREMENT COMMENT '告警编号',
  `BITValueA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节1',
  `AlarmTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '告警时间',
  `WS_Code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监控箱编号',
  `BITValueB` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节2',
  `BITValueC` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节3',
  `state` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '告警状态：已处理/未处理',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_alarminformation
-- ----------------------------
DROP TABLE IF EXISTS `c_alarminformation`;
CREATE TABLE `c_alarminformation`  (
  `ID` int(4) NOT NULL,
  `AlarmName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '告警数据名称',
  `AlarmBitAddress` int(4) NULL DEFAULT NULL COMMENT '告警bit位置',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_company
-- ----------------------------
DROP TABLE IF EXISTS `c_company`;
CREATE TABLE `c_company`  (
  `ID` int(4) NOT NULL,
  `ComName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_dsignal
-- ----------------------------
DROP TABLE IF EXISTS `c_dsignal`;
CREATE TABLE `c_dsignal`  (
  `DS_ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `WS_Code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监控箱编号',
  `DS_Jldy` double(16, 2) NULL DEFAULT NULL COMMENT '交流电压',
  `DS_Jldl` double(16, 2) NULL DEFAULT NULL COMMENT '交流电流',
  `DS_Jldn` double(16, 2) NULL DEFAULT NULL COMMENT '交流电能',
  `DS_DC12dy` double(16, 2) NULL DEFAULT NULL COMMENT '12V电压',
  `DS_DC24dy` double(16, 2) NULL DEFAULT NULL COMMENT '24V电压',
  `DS_WD` double(10, 1) NULL DEFAULT NULL COMMENT '温度',
  `DS_SD` double(10, 1) NULL DEFAULT NULL COMMENT '湿度',
  `DS_ZYQX` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '左右倾斜',
  `DS_QHQX` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前后倾斜',
  `DS_GMADC` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '光敏ADC',
  `DS_SJADC` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水浸ADC',
  `DS_ZTBYTEA` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节1',
  `DS_ZTBYTEB` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节2',
  `DS_ZTBYTEC` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节3',
  `DS_PMA` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'PM2.5',
  `DS_PMB` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'PM10',
  `DS_ZS` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '噪声',
  `DS_YL` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '雨量',
  `DS_FL` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '风量',
  `DS_YLA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '预留',
  `DS_YLB` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '预留',
  `DS_YLC` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '预留',
  `DS_YLD` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '预留',
  `DS_DateTime` datetime(0) NULL DEFAULT NULL COMMENT '采集时间',
  PRIMARY KEY (`DS_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14772 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_fazhivalueset
-- ----------------------------
DROP TABLE IF EXISTS `c_fazhivalueset`;
CREATE TABLE `c_fazhivalueset`  (
  `ID` int(4) NOT NULL,
  `WS_Code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监控箱编号',
  `JLDYUP` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交流电压上限',
  `JLDYDown` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交流电压下限',
  `ZYQX` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '左右倾斜阀值',
  `QHQX` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前后倾斜阀值',
  `SJADC` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水浸ADC阀值',
  `UPDateTime` int(4) NULL DEFAULT NULL COMMENT '上传时间间隔',
  `WDUP` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '温度上限',
  `WDDown` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '温度下限',
  `YL1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留',
  `YL2` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留',
  `YL3` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留',
  `YL4` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留',
  `YL5` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留',
  `YL6` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_pcs
-- ----------------------------
DROP TABLE IF EXISTS `c_pcs`;
CREATE TABLE `c_pcs`  (
  `PCS_Code` int(4) NOT NULL AUTO_INCREMENT COMMENT '派出所编号',
  `PCS_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '派出所名称',
  `PCS_AreaID` int(4) NULL DEFAULT NULL COMMENT '区域ID',
  PRIMARY KEY (`PCS_Code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_sxj
-- ----------------------------
DROP TABLE IF EXISTS `c_sxj`;
CREATE TABLE `c_sxj`  (
  `ID` int(4) NOT NULL,
  `SCJComID` int(4) NULL DEFAULT NULL COMMENT '厂家ID',
  `SXJName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摄像机名称',
  `SXJType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摄像机类型',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_sxjcompany
-- ----------------------------
DROP TABLE IF EXISTS `c_sxjcompany`;
CREATE TABLE `c_sxjcompany`  (
  `ID` int(4) NOT NULL,
  `SXJCom` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摄像机厂家名称',
  `SXJYA` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留',
  `SXJYB` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留',
  `SXJYC` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_user
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user`  (
  `ID` int(4) NOT NULL,
  `UserName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `UserType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人员类型ID',
  `UserOrg` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位ID',
  `UserTel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_worksite
-- ----------------------------
DROP TABLE IF EXISTS `c_worksite`;
CREATE TABLE `c_worksite`  (
  `WS_Code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '监控箱编号',
  `WS_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '监控点名称',
  `WS_IP` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监控箱IP',
  `WS_Org_Code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人',
  `WS_Area_Code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域ID',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址详情',
  `WS_DWS_Code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备ID',
  `WS_Longitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '经度',
  `WS_Latitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '纬度',
  `WS_SysCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属派出所',
  `WS_Operators` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护人',
  `WS_Num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留',
  `WS_State` int(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`WS_Code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_worksitestate
-- ----------------------------
DROP TABLE IF EXISTS `c_worksitestate`;
CREATE TABLE `c_worksitestate`  (
  `ID` int(4) NOT NULL,
  `WS_Code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监控箱编号',
  `BITValueA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节1',
  `BITValueB` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节2',
  `BITValueC` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节3',
  `AlarmTime` datetime(0) NULL DEFAULT NULL COMMENT '告警时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_wson_off
-- ----------------------------
DROP TABLE IF EXISTS `c_wson_off`;
CREATE TABLE `c_wson_off`  (
  `ID` int(4) NOT NULL,
  `WS_Code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DV121STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '12V状态',
  `DV121SXJCOMID` int(4) NULL DEFAULT NULL COMMENT '对应摄像机厂家ID',
  `DV121SXJID` int(4) NULL DEFAULT NULL COMMENT '对应摄像机ID',
  `DV122STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DV122SXJCOMID` int(4) NULL DEFAULT NULL,
  `DV122SXJID` int(4) NULL DEFAULT NULL,
  `DV123STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DV123SXJCOMID` int(4) NULL DEFAULT NULL,
  `DV123SXJID` int(4) NULL DEFAULT NULL,
  `DV124STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DV124SXJCOMID` int(4) NULL DEFAULT NULL,
  `DV124SXJID` int(4) NULL DEFAULT NULL,
  `DV241STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DV241SXJCOMID` int(4) NULL DEFAULT NULL,
  `DV241SXJID` int(4) NULL DEFAULT NULL,
  `DV242STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DV242SXJCOMID` int(4) NULL DEFAULT NULL,
  `DV242SXJID` int(4) NULL DEFAULT NULL,
  `DV2201STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DV2201SXJCOMID` int(4) NULL DEFAULT NULL,
  `DV2201SXJID` int(4) NULL DEFAULT NULL,
  `DV2202STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DV2202SXJCOMID` int(4) NULL DEFAULT NULL,
  `DV2202SXJID` int(4) NULL DEFAULT NULL,
  `POE1STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `POE1SXJCOMID` int(4) NULL DEFAULT NULL,
  `POE1SXJID` int(4) NULL DEFAULT NULL,
  `POE2STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `POE2SXJCOMID` int(4) NULL DEFAULT NULL,
  `POE2SXJID` int(4) NULL DEFAULT NULL,
  `POE3STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `POE3SXJCOMID` int(4) NULL DEFAULT NULL,
  `POE3SXJID` int(4) NULL DEFAULT NULL,
  `POE4STA` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `POE4SXJCOMID` int(4) NULL DEFAULT NULL,
  `POE4SXJID` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`WS_Code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for energyday
-- ----------------------------
DROP TABLE IF EXISTS `energyday`;
CREATE TABLE `energyday`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `wsCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '监控箱编号',
  `energyDayStart` float(8, 4) NULL DEFAULT 0.0000 COMMENT '每天0点时的电表电能示数',
  `energyDayEnd` float(8, 4) NULL DEFAULT 0.0000 COMMENT '每天23点59分59秒时的电表电能示数',
  `energyDay` float(8, 4) NULL DEFAULT 0.0000 COMMENT '每日能耗值',
  `dateTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for energymonth
-- ----------------------------
DROP TABLE IF EXISTS `energymonth`;
CREATE TABLE `energymonth`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `wsCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '监控箱编号',
  `energyMonthStart` float(8, 4) NOT NULL DEFAULT 0.0000 COMMENT '开始值',
  `energyMonthEnd` float(8, 4) NOT NULL DEFAULT 0.0000 COMMENT '结束值',
  `energyMonth` float(8, 4) NOT NULL DEFAULT 0.0000 COMMENT '每月统计的能耗值',
  `dateTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for energyyear
-- ----------------------------
DROP TABLE IF EXISTS `energyyear`;
CREATE TABLE `energyyear`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `wsCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '监控箱编号',
  `energyYearStart` float(8, 4) NOT NULL DEFAULT 0.0000 COMMENT '开始值',
  `energyYearEnd` float(8, 4) NOT NULL DEFAULT 0.0000 COMMENT '结束值',
  `energyYear` float(8, 4) NOT NULL DEFAULT 0.0000 COMMENT '统计年能耗值',
  `dateTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '时间日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for equipmentintact
-- ----------------------------
DROP TABLE IF EXISTS `equipmentintact`;
CREATE TABLE `equipmentintact`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `intactRate` float(4, 2) NOT NULL DEFAULT 0.00 COMMENT '设备完好率',
  `dateTime` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for lu_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `lu_dictionary`;
CREATE TABLE `lu_dictionary`  (
  `Dic_ID` bigint(8) NOT NULL,
  `Dic_Type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Dic_TypeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Dic_Value` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Dic_ValueName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Dic_Sort` int(4) NOT NULL,
  PRIMARY KEY (`Dic_Type`, `Dic_Value`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `wsIp` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '监控箱Ip',
  `bITValueA` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节1',
  `bITValueB` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节2',
  `bITValueC` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态字节3',
  `orderTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作时间',
  `operationType` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '控制命令详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `permissionId` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `available` bit(1) NULL DEFAULT NULL COMMENT '是否启用',
  `parentId` bigint(20) NULL DEFAULT NULL,
  `parentIds` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名',
  `permissionName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resourceType` enum('menu','button') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`permissionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `available` bit(1) NULL DEFAULT NULL COMMENT '是否启用',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色详情描述',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleId`) USING BTREE,
  UNIQUE INDEX `UK_8sggqkp1sv8guimk979mf6anf`(`role`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permissionId` int(11) NOT NULL COMMENT '权限ID',
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKpuhqkr403td1v28c3e71cgm4b`(`roleId`) USING BTREE,
  INDEX `FKjwye79px7p33gsqu4kftj0ua1`(`permissionId`) USING BTREE,
  CONSTRAINT `FKjwye79px7p33gsqu4kftj0ua1` FOREIGN KEY (`permissionId`) REFERENCES `sys_permission` (`permissionId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKpuhqkr403td1v28c3e71cgm4b` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人邮箱',
  `expiredDate` date NULL DEFAULT NULL COMMENT '有效日期',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值',
  `state` tinyint(4) NOT NULL COMMENT '用户状态',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `org` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属单位',
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE INDEX `UK_hl8fftx66p59oqgkkcfit3eay`(`userName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKgnn5rpnbwhx9fu93b19daiwbt`(`roleId`) USING BTREE,
  INDEX `FKsaymuhj4r4qr22w2q1e2oewx`(`userId`) USING BTREE,
  CONSTRAINT `FKgnn5rpnbwhx9fu93b19daiwbt` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKsaymuhj4r4qr22w2q1e2oewx` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
