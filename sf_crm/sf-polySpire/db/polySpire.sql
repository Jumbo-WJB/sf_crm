
/**
 * 聚石塔淘宝交易相关数据库，线上环境默认建好库，以下sql供开发环境和测试环境使用
 */
DROP database  if exists `sys_info`;

CREATE database `sys_info`;

/**
 * 交易数据
 */
DROP TABLE if exists `jdp_tb_trade`;
CREATE TABLE `jdp_tb_trade`(
  `tid` bigint(20) NOT NULL,
  `status` varchar(64) DEFAULT NULL,
  `type` varchar(64) DEFAULT NULL,
  `seller_nick` varchar(32) DEFAULT NULL,
  `buyer_nick` varchar(32) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `jdp_hashcode` varchar(128) DEFAULT NULL,
  `jdp_response` mediumtext,
  `jdp_created` datetime DEFAULT NULL,
  `jdp_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `ind_jdp_tb_trade_seller_nick_jdp_modified` (`seller_nick`,`jdp_modified`),
  KEY `ind_jdp_tb_trade_jdp_modified` (`jdp_modified`),
  KEY `ind_jdp_tb_trade_seller_nick_modified` (`seller_nick`,`modified`),
  KEY `ind_jdp_tb_trade_modified` (`modified`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `seller_id` bigint(11) NOT NULL  COMMENT '商家ID',
  `datasource_name` varchar(32) NOT NULL COMMENT '数据源名称',
  `driver_class_name` varchar(64) NOT NULL COMMENT '驱动名',
  `url` varchar(64) NOT NULL COMMENT '链接地址',
  `user_name` varchar(16) NOT NULL COMMENT '用户名',
  `passwd` varchar(32) NOT NULL COMMENT '密码',
  `initial_pool_size` int(4) NOT NULL DEFAULT '1' COMMENT '初始化连接数',
  `max_active` int(4) NOT NULL DEFAULT '20' COMMENT '最大并发连接数',
  `min_idle` int(4) NOT NULL DEFAULT '1' COMMENT '最小空闲连接数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据源配置';

-- ----------------------------
-- Table structure for comment_taobao
-- ----------------------------
DROP TABLE IF EXISTS `comment_taobao`;
CREATE TABLE `comment_taobao` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `user_id_tb` bigint(11) default 0 COMMENT '关联user_taobao表user_id_tb',
  `comment_id_tb` bigint(11) unique COMMENT '内部淘宝评价信息@BizId',
  `tid` bigint(20) NOT NULL COMMENT '交易ID',
  `oid` bigint(20) NOT NULL COMMENT '子订单ID',
  `role` varchar(7) NOT NULL COMMENT '评价者角色.可选值:seller(卖家)buyer(买家)',
  `nick` varchar(20) NOT NULL COMMENT '评价者昵称',
  `result` varchar(7) NOT NULL COMMENT '评价结果可选值:good(好评)neutral(中评)bad(差评)',
  `created` datetime NOT NULL COMMENT '评价创建时间格式:yyyy-MM-dd HH:mm:ss',
  `rated_nick` varchar(20) NOT NULL COMMENT '被评价者昵称',
  `item_title` varchar(50) NOT NULL COMMENT '商品标题',
  `item_price` decimal(8,2) NOT NULL COMMENT '商品价格精确到2位小数;单位:元.如:200.07，表示:200元7分',
  `content` varchar(500) DEFAULT NULL COMMENT '评价内容最大长度:500个汉字',
  `reply` varchar(500) DEFAULT NULL COMMENT '评价解释最大长度:500个汉字',
  `num_iid` bigint(14) NOT NULL COMMENT '商品的数字ID',
  `valid_score` varchar(5) DEFAULT NULL COMMENT '	评价信息是否用于记分， 可取值：true(参与记分)和false(不参与记分)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='淘宝评价表';

-- ----------------------------
-- Table structure for tmall_rate_tag
-- ----------------------------
DROP TABLE IF EXISTS `tmall_rate_tag`;
CREATE TABLE `tmall_rate_tag` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `tag_id` bigint(11) UNIQUE COMMENT '内部淘宝评价标签@BizId',
  `comment_id_tb` bigint(11) unique COMMENT '内部淘宝评价id',
  `append_tags` boolean NOT NULL COMMENT '是否是追加的评论标签1:是;0:否',
  `tag_name` varchar(200) NOT NULL COMMENT '表示标签的名称',
  `posi` boolean NOT NULL COMMENT '表示标签的极性，正极1，负极0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='淘宝评价标签表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据同步job配置表';

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
  `seller_id` bigint(11)  COMMENT '商户号',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `status` varchar(20) NOT NULL COMMENT '状态',
  `error_msg` varchar(1000) NOT NULL COMMENT '异常内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务记录表';

