/*
Navicat MySQL Data Transfer

Source Server         : suniu
Source Server Version : 50537
Source Host           : 121.40.58.169:3306
Source Database       : sf_base

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-07-08 22:05:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_resource
-- ----------------------------
DROP TABLE IF EXISTS `admin_resource`;
CREATE TABLE `admin_resource` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `resource_id` bigint(11) DEFAULT NULL COMMENT '后台资源@BizId',
  `parent_resource_id` bigint(11) DEFAULT '0' COMMENT '父资源Id',
  `name` varchar(50) NOT NULL COMMENT '资源名',
  `type` varchar(20) NOT NULL COMMENT '资源类型，url:链接;menu:菜单',
  `style` varchar(50) DEFAULT NULL COMMENT '菜单样式',
  `url` varchar(50) DEFAULT NULL COMMENT '链接',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `priority` int(4) NOT NULL COMMENT '优先级',
  PRIMARY KEY (`id`),
  UNIQUE KEY `resource_id` (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='后台资源表';

-- ----------------------------
-- Table structure for admin_resource_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_resource_role`;
CREATE TABLE `admin_resource_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `role_id` bigint(11) NOT NULL COMMENT '后台角色id',
  `resource_id` bigint(11) NOT NULL COMMENT '后台资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='后台资源角色关联表';

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `role_id` bigint(11) DEFAULT NULL COMMENT '后台角色@BizId',
  `name` varchar(50) NOT NULL COMMENT '角色名',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台角色表';

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) DEFAULT NULL COMMENT '商户号',
  `admin_user_id` bigint(11) DEFAULT NULL COMMENT '后台用户@BizId',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `sex` varchar(1) NOT NULL COMMENT '性别1:男；2:女',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `position` varchar(50) NOT NULL COMMENT '职位',
  `enabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '用户是否被禁止：1(是) 0(否)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_user_id` (`admin_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `role_id` bigint(11) NOT NULL COMMENT '后台角色id',
  `admin_user_id` bigint(11) NOT NULL COMMENT '后台用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台用户角色关联表';

-- ----------------------------
-- Table structure for datasource_config
-- ----------------------------
DROP TABLE IF EXISTS `datasource_config`;
CREATE TABLE `datasource_config` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商家ID',
  `datasource_name` varchar(32) NOT NULL COMMENT '数据源名称',
  `driver_class_name` varchar(64) NOT NULL COMMENT '驱动名',
  `url` varchar(64) NOT NULL COMMENT '链接地址',
  `user_name` varchar(16) NOT NULL COMMENT '用户名',
  `passwd` varchar(32) NOT NULL COMMENT '密码',
  `initial_pool_size` int(4) NOT NULL DEFAULT '1' COMMENT '初始化连接数',
  `max_active` int(4) NOT NULL DEFAULT '20' COMMENT '最大并发连接数',
  `min_idle` int(4) NOT NULL DEFAULT '1' COMMENT '最小空闲连接数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='数据源配置';

-- ----------------------------
-- Table structure for job_detail
-- ----------------------------
DROP TABLE IF EXISTS `job_detail`;
CREATE TABLE `job_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `job_name` varchar(64) DEFAULT NULL COMMENT 'job名称',
  `job_demo` varchar(200) DEFAULT NULL COMMENT '描述',
  `end_sync_data_time` datetime DEFAULT NULL COMMENT '数据同步结束时间',
  `sync_data_interval_time` int(8) DEFAULT '60' COMMENT '数据同步时间间隔:单位s',
  `end_time` datetime DEFAULT NULL COMMENT '任务结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='数据同步job配置表';

-- ----------------------------
-- Table structure for job_log
-- ----------------------------
DROP TABLE IF EXISTS `job_log`;
CREATE TABLE `job_log` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) DEFAULT NULL COMMENT '商户号',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `status` varchar(20) NOT NULL COMMENT '状态',
  `error_msg` varchar(1000) NOT NULL COMMENT '异常内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9426 DEFAULT CHARSET=utf8 COMMENT='定时任务记录表';

-- ----------------------------
-- Table structure for lst_of_val
-- ----------------------------
DROP TABLE IF EXISTS `lst_of_val`;
CREATE TABLE `lst_of_val` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `name` varchar(50) NOT NULL COMMENT 'Key',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `value` varchar(500) NOT NULL COMMENT '值',
  `desc_text` varchar(50) DEFAULT NULL COMMENT '描述',
  `value_01` varchar(500) DEFAULT NULL COMMENT '一个key对应多个值时需要',
  `value_02` varchar(500) DEFAULT NULL COMMENT '一个key对应多个值时需要',
  `value_03` varchar(500) DEFAULT NULL COMMENT '一个key对应多个值时需要',
  `orde_by` int(4) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1135 DEFAULT CHARSET=utf8 COMMENT='配置表';

-- ----------------------------
-- Table structure for mail_status_report
-- ----------------------------
DROP TABLE IF EXISTS `mail_status_report`;
CREATE TABLE `mail_status_report` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `seller_id` bigint(11) DEFAULT NULL COMMENT '商户号',
  `seq_id` varchar(30) NOT NULL COMMENT '发送任务ID',
  `email_address` varchar(50) DEFAULT NULL COMMENT '是否发送成功',
  `is_success` varchar(10) DEFAULT NULL COMMENT '是否发送成功',
  `is_back` varchar(10) DEFAULT NULL COMMENT '是否弹回',
  `is_open` varchar(10) DEFAULT NULL COMMENT '是否打开',
  `is_unsubscribe` varchar(10) DEFAULT NULL COMMENT '是否退订',
  `is_complaints` varchar(10) DEFAULT NULL COMMENT '是否投诉',
  `submit_data` datetime DEFAULT NULL COMMENT '发送时间',
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='邮件态报告表';

-- ----------------------------
-- Table structure for seller_config_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_config_info`;
CREATE TABLE `seller_config_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) DEFAULT NULL COMMENT '商家Id,作为@BizId',
  `seller_name` varchar(20) NOT NULL COMMENT '商家名称',
  `mobile` varchar(11) DEFAULT NULL COMMENT '商家手机号码',
  `phone` varchar(13) DEFAULT NULL COMMENT '商家电话号码',
  `email` varchar(32) DEFAULT NULL COMMENT '商家邮箱',
  `email_sign` varchar(32)  COMMENT '邮件签名',
  `email_from_name` varchar(32)  COMMENT '发件人名称',
  `address` varchar(64) DEFAULT NULL COMMENT '商家地址',
  `sms_serial` varchar(32) NOT NULL COMMENT '短信扩展码',
  `sms_notify_sign` varchar(32)  COMMENT '短信通知类签名',
  `sms_sale_sign` varchar(32)  COMMENT '短信营销类签名',
  `wx_no` varchar(32) NOT NULL COMMENT '微信号',
  `wx_app_id` varchar(32) NOT NULL COMMENT '	微信appid',
  `wx_app_secret` varchar(32) NOT NULL COMMENT '	微信app_secret',
  `wx_access_token` varchar(32) DEFAULT NULL COMMENT '微信wx_access_token',
  `wx_refresh_token` varchar(32) DEFAULT NULL COMMENT '微信wx_refresh_token',
  `wx_token_expire` datetime COMMENT '微信token过期时间',
  `tb_app_id` varchar(20) DEFAULT NULL COMMENT '淘宝app_id',
  `tb_app_secret` varchar(32) DEFAULT NULL COMMENT '淘宝app_secret',
  `tb_access_token` varchar(32) DEFAULT NULL COMMENT '淘宝 access_token',
  `tb_refresh_token` varchar(32) DEFAULT NULL COMMENT '淘宝 refresh_token',
  `poly_spire_url` varchar(64) DEFAULT NULL COMMENT '聚石塔url',
  `tb_token_expire` datetime COMMENT '淘宝token过期时间',
  `jd_app_id` varchar(32) DEFAULT NULL COMMENT '京东app_id',
  `jd_app_secret` varchar(32) DEFAULT NULL COMMENT '京东app_secret',
  `jd_access_token` varchar(64) DEFAULT NULL COMMENT '京东 access_token',
  `jd_refresh_token` varchar(64) DEFAULT NULL COMMENT '京东 refresh_token',
  `jd_token_expire` datetime COMMENT '京东token过期时间',
  `app_id` varchar(32) DEFAULT NULL COMMENT '本地app_id',
  `app_secret` varchar(32) DEFAULT NULL COMMENT '本地app_secret',
  `access_token` varchar(32) DEFAULT NULL COMMENT '本地 access_token',
  `refresh_token` varchar(32) DEFAULT NULL COMMENT '本地 refresh_token',
  PRIMARY KEY (`id`),
  UNIQUE KEY `seller_id` (`seller_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商家配置';

-- ----------------------------
-- Table structure for seller_package_count
-- ----------------------------
DROP TABLE IF EXISTS `seller_package_count`;
CREATE TABLE `seller_package_count` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL COMMENT '0	是否逻辑上被删除',
  `seller_id` varchar(30) NOT NULL COMMENT '商户ID',
  `seller_package_remain` bigint(11) NOT NULL COMMENT '商户套餐余额',
  `seller_package_total` bigint(11) NOT NULL COMMENT '商户套餐总数',
  `seller_package_used` bigint(11) NOT NULL COMMENT '商户套餐已使用数',
  `seller_package_expired` bigint(11) NOT NULL COMMENT '商户套餐过期数',
  `seller_package_version` bigint(11) NOT NULL COMMENT '版本号，用于乐观锁',
  `seller_package_type` varchar(10) NOT NULL COMMENT '套餐类型，SMS:短信，MAIL：邮件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2018 DEFAULT CHARSET=utf8 COMMENT='商户套餐统计表';

-- ----------------------------
-- Table structure for seller_package_detail
-- ----------------------------
DROP TABLE IF EXISTS `seller_package_detail`;
CREATE TABLE `seller_package_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL COMMENT '0	是否逻辑上被删除',
  `package_id` varchar(30) NOT NULL COMMENT '套餐ID,作为bizid',
  `seller_id` varchar(30) NOT NULL COMMENT '商户ID',
  `package_name` varchar(30) NOT NULL COMMENT '套餐包名',
  `package_count` int(8) NOT NULL COMMENT '套餐包数量总数',
  `expired_time` datetime NOT NULL COMMENT '过期时间',
  `expired_flag` varchar(20) NOT NULL COMMENT '过期标识',
  `package_remain` int(11) NOT NULL COMMENT '剩余数量',
  `package_type` varchar(8) NOT NULL COMMENT '套餐类型：SMS：短信；EMAIL:邮件',
  `package_fee` int(11) NOT NULL COMMENT '套餐费用',
  `package_free` int(8) NOT NULL COMMENT '购送数量',
  `send_times` int(8) NOT NULL COMMENT '发送次数',
  `send_suc_rate` int(8) NOT NULL COMMENT '发送成功率',
  `package_desc` varchar(500) DEFAULT NULL COMMENT '套餐描述',
  `package_version` int(11) NOT NULL COMMENT '短信版本号，用于乐观锁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20152 DEFAULT CHARSET=utf8 COMMENT='商户套餐订购表';

-- ----------------------------
-- Table structure for send_detail
-- ----------------------------
DROP TABLE IF EXISTS `send_detail`;
CREATE TABLE `send_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL COMMENT '0	是否逻辑上被删除',
  `seller_id` varchar(30) NOT NULL COMMENT '商户ID',
  `seq_id` varchar(30) NOT NULL COMMENT '短信任务ID',
  `package_id` varchar(30) NOT NULL COMMENT '套餐ID',
  `sale_type` varchar(20) NOT NULL COMMENT '类型，SMS：短信，EMAIL:邮件',
  `user_send_address` varchar(100) NOT NULL COMMENT '发送的号码或邮件地址',
  `STATUS` varchar(20) NOT NULL COMMENT '状态',
  `send_priority` varchar(2) DEFAULT NULL COMMENT '短信级别',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `activity_id` varchar(30) DEFAULT NULL COMMENT '营销活动ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8 COMMENT='短信明细表';

-- ----------------------------
-- Table structure for send_plan
-- ----------------------------
DROP TABLE IF EXISTS `send_plan`;
CREATE TABLE `send_plan` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL COMMENT '0	是否逻辑上被删除',
  `seller_id` varchar(30) NOT NULL COMMENT '商户ID',
  `seq_id` varchar(30) NOT NULL COMMENT '短信任务ID,作为@BizId',
  `campaignId` varchar(30) DEFAULT NULL COMMENT '返回的邮件活动ID',
  `sale_type` varchar(20) NOT NULL COMMENT '营销类型',
  `send_type` varchar(20) NOT NULL COMMENT '发送类型',
  `STATUS` varchar(20) NOT NULL COMMENT '状态',
  `flag` varchar(20) DEFAULT NULL COMMENT '拉取标记',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `send_title` varchar(50) DEFAULT NULL COMMENT '发送标题',
  `send_content` varchar(5000) NOT NULL COMMENT '发送内容',
  `send_from` varchar(100) DEFAULT NULL COMMENT '发送者邮箱地址',
  `send_fromName` varchar(100) DEFAULT NULL COMMENT '发送者名称',
  `send_priority` varchar(2) DEFAULT NULL COMMENT '短信级别',
  `sms_passage` varchar(20) DEFAULT NULL COMMENT '短信通道',
  `activity_id` varchar(30) DEFAULT NULL COMMENT '营销活动ID',
  `fatigue` varchar(5) NOT NULL DEFAULT '1' COMMENT '是否疲劳处理，默认进行疲劳处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='发送任务表';

-- ----------------------------
-- Table structure for send_user_unsubscribe
-- ----------------------------
DROP TABLE IF EXISTS `send_user_unsubscribe`;
CREATE TABLE `send_user_unsubscribe` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL COMMENT '0	是否逻辑上被删除',
  `seller_id` varchar(30) NOT NULL COMMENT '商户ID',
  `user_send_address` varchar(20) NOT NULL COMMENT '用户手机号码',
  `unsubscribe_type` varchar(20) DEFAULT NULL COMMENT '退订类型（邮件）',
  `sms_content` varchar(100) NOT NULL COMMENT '短信内容',
  `sent_time` varchar(30) NOT NULL COMMENT '发送时间',
  `add_serial` varchar(30) DEFAULT NULL COMMENT '发送者扩展码',
  `add_serial_rev` varchar(30) DEFAULT NULL COMMENT '接收扩展码',
  `channel_number` varchar(30) DEFAULT NULL COMMENT '服务号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='发送用户退订表';

-- ----------------------------
-- Table structure for sms_status_report
-- ----------------------------
DROP TABLE IF EXISTS `sms_status_report`;
CREATE TABLE `sms_status_report` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `seq_id` varchar(30) NOT NULL COMMENT '短信任务ID',
  `memo` varchar(300) DEFAULT NULL COMMENT '备注',
  `error_code` varchar(30)  COMMENT '返回的错误码',
  `mobile` varchar(20) NOT NULL COMMENT '-手机号码',
  `receive_data` datetime  COMMENT '接收时间',
  `report_status` varchar(10)  COMMENT '报告状态',
  `service_code_add` varchar(30)  COMMENT '短信下行服务码',
  `submit_data` datetime  COMMENT '发送时间',
  `status` varchar(20)  COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信状态报告表';

-- ----------------------------
-- Table structure for user_wx_message
-- ----------------------------
DROP TABLE IF EXISTS `user_wx_message`;
CREATE TABLE `user_wx_message` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `msg_id` varchar(32) DEFAULT NULL COMMENT '消息id',
  `msg_type` varchar(32) NOT NULL COMMENT '消息类型',
  `biz_type` varchar(32) NOT NULL COMMENT '业务类型',
  `seller_id` bigint(11) DEFAULT NULL COMMENT '商家Id',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户Id',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `send_type` varchar(32) NOT NULL COMMENT '发送类型',
  `to_user_name` varchar(32) NOT NULL COMMENT '商家公众号',
  `from_user_name` varchar(32) DEFAULT NULL COMMENT '发送者帐号',
  `create_time` datetime NOT NULL COMMENT '消息发送时间',
  `reply_time` datetime DEFAULT NULL COMMENT '消息回复时间',
  `receive_content` varchar(500) DEFAULT NULL COMMENT '接收的内容',
  `reply_content` varchar(500) DEFAULT NULL COMMENT '回复内容',
  `ediaId` varchar(20) DEFAULT NULL COMMENT '图片id',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `url` varchar(100) DEFAULT NULL COMMENT '点击链接的地址',
  `picurl` varchar(100) DEFAULT NULL COMMENT '图片链接的地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信用户消息表';

-- ----------------------------
-- Table structure for package_account
-- ----------------------------
DROP TABLE IF EXISTS `market_package`;
CREATE TABLE `market_package` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT 0 COMMENT '是否逻辑上被删除0:未删除1:删除',
  `package_id` varchar(30) NOT NULL COMMENT '套餐ID,作为@bizid',
  `package_name` varchar(30) NOT NULL COMMENT '套餐包名',
  `package_type` varchar(8) NOT NULL COMMENT '套餐类型：SMS：短信；EMAIL:邮件',
  `package_count` int(8) NOT NULL COMMENT '套餐包数量总数',
  `package_fee` int(11) NOT NULL COMMENT '套餐费用(单位：分)',
  `package_free` int(8) NOT NULL COMMENT '赠送数量',
  `package_desc` varchar(500) DEFAULT NULL COMMENT '套餐描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20152 DEFAULT CHARSET=utf8 COMMENT='营销套餐表';

-- ----------------------------
-- Table structure for online_message
-- ----------------------------
CREATE TABLE online_message (
`id`  bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
`gmt_created`  datetime NOT NULL COMMENT '创建时间' ,
`gmt_modified`  datetime NOT NULL COMMENT '修改时间' ,
`created_by`  varchar(20)  NOT NULL COMMENT '创建人' ,
`modified_by`  varchar(20) NOT NULL COMMENT '修改人' ,
`is_deleted`  varchar(1)  DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)' ,
`name`  varchar(50) NOT NULL COMMENT '客户姓名' ,
`mobile`  varchar(20) DEFAULT NULL COMMENT '客户手机或座机号码' ,
`qq`  varchar(20) DEFAULT NULL COMMENT '客户qq号码' ,
`email`  varchar(100) DEFAULT NULL COMMENT '客户邮箱地址' ,
`company_name`  varchar(100) NOT NULL COMMENT '公司名称' ,
`address`  varchar(100) NOT NULL COMMENT '地址' ,
`remark`  text COMMENT '备注信息' ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='线上官网留言信息表';
