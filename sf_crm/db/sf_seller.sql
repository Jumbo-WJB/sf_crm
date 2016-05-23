/*
Navicat MySQL Data Transfer

Source Server         : suniu
Source Server Version : 50537
Source Host           : 121.40.58.169:3306
Source Database       : sf_seller

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-07-08 22:05:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment_jd
-- ----------------------------
DROP TABLE IF EXISTS `comment_jd`;
CREATE TABLE `comment_jd` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `user_id_jd` bigint(11) NOT NULL COMMENT '对应user_jd表user_id_jd',
  `jd_comment_id` varchar(20) DEFAULT NULL COMMENT '京东评价信息ID',
  `order_id` varchar(20) NOT NULL COMMENT '订单ID',
  `skuid` varchar(20) DEFAULT NULL COMMENT 'skuid',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sku_image` varchar(50) DEFAULT NULL COMMENT 'sku图片',
  `sku_name` varchar(50) DEFAULT NULL COMMENT '	sku名称',
  `reply_count` int(8) DEFAULT NULL COMMENT '	回复数',
  `score` int(4) DEFAULT NULL COMMENT '评价等级',
  `useful_count` int(4) DEFAULT NULL COMMENT '	有用数',
  `is_vender_reply` varchar(7) DEFAULT NULL COMMENT '商家是否回复',
  `nick_name` varchar(7) DEFAULT NULL COMMENT '用户昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='京东评价表';


-- ----------------------------
-- Table structure for comment_taobao
-- ----------------------------
DROP TABLE IF EXISTS `comment_taobao`;
CREATE TABLE `comment_taobao` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `user_id_tb` bigint(11) NOT NULL COMMENT '关联user_taobao表user_id_tb',
  `comment_id_tb` bigint(11) DEFAULT NULL COMMENT '内部淘宝评价信息@BizId',
  `tid` bigint(20) NOT NULL COMMENT '交易ID',
  `oid` bigint(20) NOT NULL COMMENT '子订单ID',
  `role` varchar(7) NOT NULL COMMENT '评价者角色.可选值:seller(卖家)buyer(买家)',
  `nick` varchar(20) NOT NULL COMMENT '评价者昵称',
  `result` varchar(7) NOT NULL COMMENT '评价结果可选值:good(好评)neutral(中评)bad(差评)',
  `created` datetime NOT NULL COMMENT '评价创建时间格式:yyyy-MM-dd HH:mm:ss',
  `rated_nick` varchar(20) NOT NULL COMMENT '被评价者昵称',
  `item_title` varchar(50) NOT NULL COMMENT '商品标题',
  `item_price` varchar(10) NOT NULL COMMENT '商品价格精确到2位小数;单位:元.如:200.07，表示:200元7分',
  `content` varchar(500) DEFAULT NULL COMMENT '评价内容最大长度:500个汉字',
  `reply` varchar(500) DEFAULT NULL COMMENT '评价解释最大长度:500个汉字',
  `num_iid` bigint(14) NOT NULL COMMENT '商品的数字ID',
  `valid_score` tinyint(1) DEFAULT NULL COMMENT '	评价信息是否用于记分， 可取值：true(参与记分)和false(不参与记分)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `comment_id_tb` (`comment_id_tb`)
) ENGINE=InnoDB AUTO_INCREMENT=39687 DEFAULT CHARSET=utf8 COMMENT='淘宝评价表';

-- ----------------------------
-- Table structure for crm_share
-- ----------------------------
DROP TABLE IF EXISTS `crm_share`;
CREATE TABLE `crm_share` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `crm_share_id` bigint(11) NOT NULL COMMENT '分享id,作为@BizId',
  `seller_id` bigint(11) NOT NULL COMMENT '商户Id',
  `sponsor_user_id` bigint(11) NOT NULL COMMENT '分享发起人',
  `receive_user_id` bigint(11) NOT NULL COMMENT '分享接收人',
  `receive_time` datetime NOT NULL COMMENT '分享时间',
  `type` varchar(16) NOT NULL COMMENT '类型 SHARE:分享  INVITE:邀请',
  `amount` bigint(11) DEFAULT NULL COMMENT '获得金额 分为单位',
  `biz_id` bigint(11) NOT NULL COMMENT '分享对象id',
  `biz_name` varchar(32) NOT NULL COMMENT '分享对象名称，冗余字段方便查询',
  `share_biz_type` varchar(32) NOT NULL COMMENT '分享对象类型，hontbao:红包sign_in：签到game:游戏',
  PRIMARY KEY (`id`),
  UNIQUE KEY `crm_share_id` (`crm_share_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分享表';

-- ----------------------------
-- Table structure for express_info
-- ----------------------------
DROP TABLE IF EXISTS `express_info`;
CREATE TABLE `express_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `context` text COMMENT '物流信息',
  `seller_id` bigint(11) UNSIGNED NOT NULL COMMENT '商家id' ,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `exp_company` varchar(255) DEFAULT NULL COMMENT '物流公司名称',
  `mail_no` varchar(255) DEFAULT NULL COMMENT '快递单号',
  `status` varchar(255) DEFAULT NULL COMMENT '-1 待查询 0 查询异常 1 暂无记录 2 在途中 3 派送中 4 已签收 5 用户拒签 6 疑难件 7 无效单 8 超时单 9 签收失败 10 退回',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hongbao_cash
-- ----------------------------
DROP TABLE IF EXISTS `hongbao_cash`;
CREATE TABLE `hongbao_cash` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(16) NOT NULL COMMENT '创建人',
  `modified_by` varchar(16) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(2) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `hongbao_cash_id` bigint(11) NOT NULL COMMENT '红包提现id,作为@BizId',
  `spbill_ip` varchar(32) DEFAULT NULL COMMENT '付款IP',
  `user_id` bigint(11) DEFAULT NULL COMMENT '提现用户ID',
  `amount` bigint(11) NOT NULL COMMENT '提现金额 分为单位',
  `open_id` varchar(32) DEFAULT NULL COMMENT 'openid',
  `pool_id` bigint(11) DEFAULT NULL COMMENT '红包池ID',
  `obtain_date` datetime DEFAULT NULL COMMENT '提现时间',
  `status` varchar(32) DEFAULT NULL COMMENT 'y 有效  n无效',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hongbao_cash_id` (`hongbao_cash_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='红包提现表';

-- ----------------------------
-- Table structure for hongbao_obtain
-- ----------------------------
DROP TABLE IF EXISTS `hongbao_obtain`;
CREATE TABLE `hongbao_obtain` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(16) NOT NULL COMMENT '创建人',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `modified_by` varchar(16) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `hongbao_obtain_id` bigint(11) DEFAULT NULL COMMENT '领取ID,作为@BizId',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户ID',
  `amount` bigint(11) NOT NULL COMMENT '金额 分为单位',
  `open_id` varchar(32) DEFAULT NULL COMMENT 'openid',
  `obtain_method` varchar(16) DEFAULT NULL COMMENT '获得方式：yyy 摇一摇 jfth 积分兑换gjc 关键词领取',
  `pool_id` bigint(11) NOT NULL COMMENT '红包池ID',
  `pool_name` varchar(32) DEFAULT NULL COMMENT '红包池名称冗余字段',
  `obtain_datatime` datetime DEFAULT NULL COMMENT '领取时间',
  `amount_range` varchar(32) DEFAULT NULL COMMENT '红包key便于查询',
  `obtain_post_number` varchar(32) DEFAULT NULL COMMENT '红包领用快递单号',
  `status` varchar(32) DEFAULT NULL COMMENT 'toReceive 待领取  received 已领取',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hongbao_obtain_id` (`hongbao_obtain_id`),
  KEY `index_amount_range` (`amount_range`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='红包领取表';

-- ----------------------------
-- Table structure for hongbao_pool
-- ----------------------------
DROP TABLE IF EXISTS `hongbao_pool`;
CREATE TABLE `hongbao_pool` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(16) NOT NULL COMMENT '创建人',
  `modified_by` varchar(16) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(2) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户Id',
  `pool_id` bigint(11) DEFAULT NULL COMMENT '红包池id ,作为@BizId',
  `start_date` datetime DEFAULT NULL COMMENT '开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  `RULE_CONFIG_ID` bigint(11) NOT NULL COMMENT '配置规则id',
  `name` varchar(32) NOT NULL COMMENT '红包池名称',
  `number` bigint(11) NOT NULL DEFAULT '0' COMMENT '红包个数',
  `NUMBER_OBTAIN` bigint(11) NOT NULL DEFAULT '0' COMMENT '已领个数',
  `CONFIG` varchar(20) NOT NULL COMMENT '配置 regular：规则设置Irregular:不规则设置',
  `STATES` varchar(20) DEFAULT NULL COMMENT '状态 unBoundd:未关联unReceived:待领取，receiving：领取中done:结束',
  `type` varchar(16) NOT NULL COMMENT '红包类别：yyy 摇一摇 jfth 积分兑换gjc 关键词领取birthday生日',
  `total_amount` bigint(11) DEFAULT NULL COMMENT '红包总金额',
  `obtain_amount` bigint(11) DEFAULT NULL COMMENT '红包领取金额',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pool_id` (`pool_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='红包池表';

-- ----------------------------
-- Table structure for item_info_jd
-- ----------------------------
DROP TABLE IF EXISTS `item_info_jd`;
CREATE TABLE `item_info_jd` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `ware_id` varchar(20) DEFAULT NULL COMMENT '元京东内部商品ID（极端情况下不保证返回，建议从商品接口获取  ',
  `user_id_jd` bigint(11) NOT NULL COMMENT '对应user_jd表user_id_jd',
  `order_id` varchar(20) NOT NULL COMMENT '订单ID',
  `sku_id` varchar(20) DEFAULT NULL COMMENT '京东内部SKU的ID ',
  `outer_sku_id` varchar(20) DEFAULT NULL COMMENT 'SKU外部ID（极端情况下不保证返回，建议从商品接口获取） ',
  `sku_name` varchar(200) DEFAULT NULL COMMENT '商品的名称+SKU规格 ',
  `jd_price` varchar(20) DEFAULT NULL COMMENT 'SKU的京东价 ',
  `gift_point` int(8) DEFAULT NULL COMMENT '赠送积分 ',
  `item_total` int(8) DEFAULT NULL COMMENT '数量 ',
  `product_no` varchar(20) DEFAULT NULL COMMENT '商品货号（极端情况下不保证返回，建议从商品接口获取）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12459 DEFAULT CHARSET=utf8 COMMENT='订单中商品明细';

-- ----------------------------
-- Table structure for keyword_reply_config
-- ----------------------------
DROP TABLE IF EXISTS `keyword_reply_config`;
CREATE TABLE `keyword_reply_config` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `title` varchar(50) DEFAULT NULL COMMENT '内容名称',
  `biz_id` bigint(11) DEFAULT NULL COMMENT '相关业务ID,比如红包领取对应红包池id',
  `key_word` varchar(50) NOT NULL COMMENT '关键字',
  `media_id` bigint(11) DEFAULT NULL COMMENT '图文素材Id',
  `biz_type` varchar(50) DEFAULT NULL COMMENT '业务类型point_exchange:积分换礼;express_query:快递查询;receive_hb:红包领取',
  `match_type` varchar(1) NOT NULL COMMENT '匹配类型0:模糊匹配1:精确匹配',
  `success_reply_content` varchar(1000) DEFAULT NULL COMMENT '成功回复内容',
  `msg_type` varchar(20) NOT NULL COMMENT '回复消息类型text:文本;image:图文',
  `fail_reply_content` varchar(1000) DEFAULT NULL COMMENT '失败回复',
  `repeat_operate_reply_content` varchar(1000) DEFAULT NULL COMMENT '重复操作回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='关键字回复配置';

-- ----------------------------
-- Table structure for mall_category
-- ----------------------------
DROP TABLE IF EXISTS `mall_category`;
CREATE TABLE `mall_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `cid` bigint(11) DEFAULT NULL COMMENT '		类目ID,作为@BizId',
  `parent_cid` bigint(11) NOT NULL COMMENT '		父类目ID=0时，代表的是一级的类目',
  `name` varchar(36) NOT NULL COMMENT '	类目名称',
  `is_parent` varchar(2) NOT NULL COMMENT '	该类目是否为父类目(即：该类目是否还有子类目)',
  `status` varchar(2) NOT NULL COMMENT '	y',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cid` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='积分商城 SKU表';

-- ----------------------------
-- Table structure for mall_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods`;
CREATE TABLE `mall_goods` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `goods_id` bigint(11) DEFAULT NULL COMMENT '商品id,作为@BizId',
  `title` varchar(128) NOT NULL COMMENT '商品标题',
  `category_id` bigint(11) NOT NULL COMMENT '叶子类目id',
  `is_virtual` varchar(2) NOT NULL COMMENT '是否虚拟商品 y是 n否',
  `list_time` datetime NOT NULL COMMENT '上架时间',
  `delist_time` datetime DEFAULT NULL COMMENT '下架时间',
  `status` varchar(16) NOT NULL COMMENT '状态  onsale：在售中 instock：在库中',
  `quantity` bigint(11) NOT NULL COMMENT '数量',
  `price` bigint(11) NOT NULL COMMENT '价格',
  `point` bigint(11) NOT NULL COMMENT '	兑换所需积分',
  `exchange_amount` bigint(11) NOT NULL DEFAULT '0' COMMENT '已兑换数量',
  `detail_url` varchar(256) NOT NULL COMMENT ' 详情页',
  `qr_url` varchar(256) COMMENT ' 二维码图片链接',
  `imgs_url` varchar(1024) NOT NULL COMMENT ' 图片列表',
  `thumbnail` varchar(256) COMMENT '商品小图,显示在首页和列表中的图片',
  `skus` varchar(256) DEFAULT NULL COMMENT ' 以逗号分隔的skuId',
  `props` varchar(256) DEFAULT NULL COMMENT '	属性串pid:vid',
  `props_name` varchar(256) DEFAULT NULL COMMENT ' 属性名串	pid:vid:pid_name:vid_name',
  `outer_id` varchar(64) DEFAULT NULL COMMENT '	外部编码',
  `version` bigint(11) DEFAULT 0 NOT NULL COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='积分商城 商品表';

-- ----------------------------
-- Table structure for mall_goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_sku`;
CREATE TABLE `mall_goods_sku` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `goods_id` bigint(11) DEFAULT NULL COMMENT ' 商品id',
  `sku_id` bigint(11) DEFAULT NULL COMMENT ' sku id,作为@BizId',
  `quantity` bigint(11) NOT NULL COMMENT '库存数量',
  `price` bigint(11) NOT NULL COMMENT '	价格，以分为单位',
  `point` bigint(11) NOT NULL COMMENT '	兑换所需积分',
  `props` varchar(128) DEFAULT NULL COMMENT '销售属性的组合，p1:v1; p2:v2;',
  `props_name` varchar(128) DEFAULT NULL COMMENT 'P1:v1:p1_name:v1_name;p2:v2:p2_name:v2_name',
  `outer_sku_id` varchar(64) DEFAULT NULL COMMENT '	外部编码',
  `version` bigint(11) DEFAULT 0 NOT NULL COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sku_id` (`sku_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='积分商城 SKU表';

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `oid` bigint(11) DEFAULT NULL COMMENT ' 子交易id,作为@BizId',
  `tid` bigint(11) NOT NULL COMMENT ' 主交易id',
  `goods_id` bigint(11) NOT NULL COMMENT '商品id',
  `sku_id` bigint(11) DEFAULT NULL COMMENT ' sku id，可为空',
  `quantity` int(8) NOT NULL COMMENT '数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `oid` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='积分商城 子交易表';

-- ----------------------------
-- Table structure for mall_property
-- ----------------------------
DROP TABLE IF EXISTS `mall_property`;
CREATE TABLE `mall_property` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `pid` bigint(11) DEFAULT NULL COMMENT '		属性id,作为@BizId',
  `name` varchar(36) NOT NULL COMMENT '	属性名',
  `is_sale_prop` varchar(2) NOT NULL COMMENT 'y是否销售属性',
  `is_color_prop` varchar(2) NOT NULL COMMENT 'y 是否颜色属性',
  `is_enum_prop` varchar(2) NOT NULL COMMENT 'y 是否可枚举属性',
  `cid` bigint(11) NOT NULL COMMENT '		类目id',
  `type` varchar(32) NOT NULL COMMENT '属性值类型。可选值： multiCheck(枚举多选) optional(枚举单选) multiCheckText(枚举可输入多选) optionalText(枚举可输入单选) text(非枚举可输入)，默认是枚举单选',
  `status` varchar(2) NOT NULL COMMENT 'y是否在使用中',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='积分商城 属性表';

-- ----------------------------
-- Table structure for mall_property_value
-- ----------------------------
DROP TABLE IF EXISTS `mall_property_value`;
CREATE TABLE `mall_property_value` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `pid` bigint(11) NOT NULL COMMENT '		属于id,作为@BizId',
  `prop_name` varchar(16) NOT NULL COMMENT '	属性名',
  `vid` bigint(11) DEFAULT NULL COMMENT '		属性值id',
  `name` varchar(16) NOT NULL COMMENT '	属性值',
  `status` varchar(2) NOT NULL COMMENT 'y 是否在使用中',
  PRIMARY KEY (`id`),
  UNIQUE KEY `vid` (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='积分商城 属性值表';

-- ----------------------------
-- Table structure for mall_receiver
-- ----------------------------
DROP TABLE IF EXISTS `mall_receiver`;
CREATE TABLE `mall_receiver` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `receiver_id` bigint(11) DEFAULT NULL COMMENT '收件人id,作为@BizId',
  `name` varchar(16) NOT NULL COMMENT '	姓名',
  `mobile` varchar(16) NOT NULL COMMENT '	手机',
  `province` varchar(16) DEFAULT NULL COMMENT '	省',
  `city` varchar(16) DEFAULT NULL COMMENT '	市',
  `district` varchar(16) DEFAULT NULL COMMENT '	区',
  `address` varchar(64) DEFAULT NULL COMMENT '	地址',
  `zip` varchar(16) DEFAULT NULL COMMENT '邮编',
  `is_default` varchar(2) DEFAULT NULL COMMENT 'y 是否默认收件人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `receiver_id` (`receiver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='积分商城 收件人表';

-- ----------------------------
-- Table structure for mall_trade
-- ----------------------------
DROP TABLE IF EXISTS `mall_trade`;
CREATE TABLE `mall_trade` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `tid` bigint(11) DEFAULT NULL COMMENT ' 交易id,作为@BizId',
  `status` varchar(32) NOT NULL COMMENT '交易状态：WAIT_BUYER_PAY WAIT_SELLER_SEND_GOODS WAIT_BUYER_CONFIRM_GOODS TRADE_FINISHED TRADE_CLOSED TRADE_CLOSED_BY_TAOBAO',
  `pay_time` datetime DEFAULT NULL COMMENT '		付款时间',
  `created` datetime NOT NULL COMMENT '		创建时间',
  `modified` datetime NOT NULL COMMENT '		修改时间',
  `consign_time` datetime DEFAULT NULL COMMENT '		发货时间',
  `end_time` datetime DEFAULT NULL COMMENT '		结束时间',
  `receiver_id` bigint(11) DEFAULT NULL COMMENT '		收件人id',
  `type` varchar(16) DEFAULT NULL COMMENT '  订单类型; shake_fetch摇一摇礼物领取订单, birthday_fetch生日礼物领取订单, default_fetch积分兑换商品订单',
  `fee` bigint(11) DEFAULT NULL COMMENT '		应付款（以分为单位）',
  `fee_point` bigint(11) DEFAULT NULL COMMENT '		应付积分',
  `payment` bigint(11) DEFAULT NULL COMMENT '		实付款（以分为单位）',
  `payment_point` bigint(11) DEFAULT NULL COMMENT '		实付积分',
  `shipping_type` varchar(16) DEFAULT NULL COMMENT ' 快递方式：free(卖家包邮) post(平邮) express(快递) ems(EMS) virtual(虚拟发货)',
  `shipping_id` varchar(32) DEFAULT NULL COMMENT ' 运单号',
  `shipping_company` varchar(16) DEFAULT NULL COMMENT ' 快递公司',
  `shipping_fee` bigint(11) DEFAULT NULL COMMENT ' 快递费',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tid` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='积分商城 主交易表';

-- ----------------------------
-- Table structure for market_activity
-- ----------------------------
DROP TABLE IF EXISTS `market_activity`;
CREATE TABLE `market_activity` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `activity_id` bigint(11) NOT NULL COMMENT '活动id,作为@BizId',
  `title` varchar(20) NOT NULL COMMENT '营销主题',
  `target` varchar(20) NOT NULL COMMENT '营销目的sale:销售；increase_fans：增粉；spread:传播；other：其他',
  `type` varchar(16) NOT NULL COMMENT '类型	wx：微信；sms：短信；email：邮件；wp：微博',
  `content_type` varchar(16) NOT NULL COMMENT '营销活动内容类型	Int	text:文本信息:single_image_text：单条图文；multi_image_text:多条图文；voice:语音',
  `content` varchar(500) NOT NULL COMMENT '营销活动内容	存放html界面的路径地址或者是文本信息',
  `url` varchar(50) DEFAULT NULL COMMENT '活动外链接	VARCHAR(100)	活动外链接',
  `email_type` varchar(20) DEFAULT NULL COMMENT '邮件营销邮件类型	qq:QQ邮箱;163:163邮箱;126:126邮箱;yahoo:yahoo邮箱并且不同的邮箱类型之间用，分隔',
  `wx_media_id` varchar(32) DEFAULT NULL COMMENT '关联微信公众号素材管理对应的素材Id',
  `wx_source_Type` varchar(8) DEFAULT NULL COMMENT '素材类型	VARCHAR（50）	媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）',
  `wx_person_Count` int(8) NOT NULL DEFAULT '0' COMMENT '活动覆盖人群',
  `feedback_number` int(8) NOT NULL DEFAULT '0' COMMENT '反馈人群数量',
  `status` varchar(30) DEFAULT NULL COMMENT '活动状态send_success:成功;send_failed:失败，send_cancel：取消',
  `execute_time` datetime DEFAULT NULL COMMENT '执行时间',
  `execute_type` varchar(2) NOT NULL  COMMENT '执行类型，1：立即执行，0：定时执行',
  `seller_id` bigint(11) NOT NULL COMMENT '商家id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `activity_id` (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='营销活动';

-- ----------------------------
-- Table structure for market_records
-- ----------------------------
DROP TABLE IF EXISTS `market_records`;
CREATE TABLE `market_records` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `activity_id` bigint(11) NOT NULL COMMENT '营销活动Id',
  `user_id` bigint(11) NOT NULL COMMENT '用户Id',
  `activity_title` varchar(50) NOT NULL COMMENT '营销方案主题',
  `mobile` varchar(11) DEFAULT NULL COMMENT '用户手机号码',
  `email` varchar(100) DEFAULT NULL COMMENT '用户的邮箱',
  `is_success` varchar(30) NOT NULL COMMENT '是否发送成功，send_failed:失败；send_success:成功',
  `is_open` varchar(30) NOT NULL DEFAULT 'send_unopen' COMMENT '标示邮件是否打开,send_unopen:未打开，send_open:打开，默认为send_unopen',
  `type` varchar(16) NOT NULL,
  `execute_time` datetime DEFAULT NULL,
  `seller_id` bigint(11) NOT NULL COMMENT '商家id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='营销记录';

-- ----------------------------
-- Table structure for order_jd
-- ----------------------------
DROP TABLE IF EXISTS `order_jd`;
CREATE TABLE `order_jd` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `order_id` varchar(20) NOT NULL COMMENT '订单ID',
  `shop_id` bigint(11) UNSIGNED NOT NULL COMMENT '店铺Id',
  `order_source` varchar(20) NOT NULL COMMENT '订单来源',
  `user_id_jd` bigint(11) NOT NULL COMMENT '对应user_jd表user_id_jd',
  `receiver_id_jd` bigint(11) NOT NULL COMMENT '收件人Id',
  `vender_id` varchar(20) NOT NULL COMMENT '商家id',
  `pay_type` varchar(20) NOT NULL COMMENT '支付方式（1货到付款 2邮局汇款 3自提 4在线支付 5公司转账 6银行转账）',
  `order_total_price` decimal(8,2) NOT NULL COMMENT '	订单总金额',
  `order_seller_price` decimal(8,2) NOT NULL COMMENT '	订单货款金额（订单总金额-商家优惠金额）',
  `order_payment` decimal(8,2) NOT NULL COMMENT '用户应付金额',
  `freight_price` decimal(8,2) DEFAULT NULL COMMENT '商品的运费',
  `seller_discount` decimal(8,2) DEFAULT NULL COMMENT '商家优惠金额',
  `order_state` varchar(64) NOT NULL COMMENT '订单状态（英文）',
  `order_state_remark` varchar(500) DEFAULT NULL COMMENT '	订单状态说明（中文）',
  `delivery_type` varchar(20) DEFAULT NULL COMMENT '送货（日期）类型（1-只工作日送货(双休日、假日不用送) ENGINE=InnoDB DEFAULT CHARSET=utf8;2-只双休日、假日送货(工作日不用送) ENGINE=InnoDB DEFAULT CHARSET=utf8;3-工作日、双休日与假日均可送货;其他值-返回‘任意时间’）',
  `invoice_info` varchar(200) DEFAULT NULL COMMENT '发票信息 返回‘不需要开具发票’时无需开具发票；其它返回值请正常开具发票',
  `order_remark` varchar(500) DEFAULT NULL COMMENT '买家下单时订单备注',
  `order_start_time` datetime DEFAULT NULL COMMENT '	下单时间',
  `order_end_time` datetime DEFAULT NULL COMMENT '结单时间 如返回信息为0001-01-01 00:00:00或1970-01-01 00:00:00等特殊值，可认为此订单为未完成状态。',
  `vender_remark` varchar(500) DEFAULT NULL COMMENT '商家订单备注（不大于500字符）可选字段，需要在输入参数optional_fields中写入才能返回',
  `balance_used` decimal(8,2) DEFAULT NULL COMMENT '余额支付金额 可选字段，需要在输入参数optional_fields中写入才能返回',
  `pin` varchar(50) DEFAULT NULL COMMENT '即买家的账号信息 可选字段，需要在输入参数optional_fields中写入才能返回',
  `return_order` varchar(1) DEFAULT NULL COMMENT '售后订单标记 0:不是换货订单 1返修发货直接赔偿客服补件 2售后调货 可选字段，需要在输入参数optional_fields中写入才能返回',
  `payment_confirm_time` datetime DEFAULT NULL COMMENT '付款确认时间 如果没有付款时间 默认返回0001-01-01 00:00:00 可选字段，需要在输入参数optional_fields中写入才能返回',
  `waybill` varchar(20) DEFAULT NULL COMMENT '运单号，当物流公司是厂家自送时运单号可为空，不同物流公司的运单号用|分隔，如果同一物流公司有多个运单号，则用英文逗号分隔 可选字段，需要在输入参数optional_fields中写入才能返回',
  `logistics_id` varchar(20) DEFAULT NULL COMMENT '物流公司ID，多个物流公司以|分隔 可选字段，需要在输入参数optional_fields中写入才能返回',
  `modified` datetime DEFAULT NULL COMMENT '订单更新时间',
  `parent_order_id` varchar(20) DEFAULT NULL COMMENT '父订单号 可选字段，需要在输入参数optional_fields中写入才能返回',
  `order_type` varchar(20) DEFAULT NULL COMMENT '订单类型（22 SOP；23 LBP ；25 SOPL）可选字段，需要在输入参数optional_fields中写入才能返回',
  `pull_comment` boolean not NULL  DEFAULT '0' COMMENT '是否已拉取评价信息',
  `store_order` varchar(20) DEFAULT NULL COMMENT '京仓订单.如果是京仓订单，结果返回文字“京仓订单”；否则返回结果为空值“”',
  `seller_id` bigint(11) NOT NULL COMMENT '商家id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12461 DEFAULT CHARSET=utf8 COMMENT='京东订单';

-- ----------------------------
-- Table structure for order_taobao
-- ----------------------------
DROP TABLE IF EXISTS `order_taobao`;
CREATE TABLE `order_taobao` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `user_id_tb` bigint(11) NOT NULL COMMENT '关联user_taobao表user_id_tb',
  `tid` bigint(20) NOT NULL COMMENT '交易ID',
  `oid` bigint(20) DEFAULT NULL COMMENT '子订单编号',
  `item_meal_name` varchar(100) DEFAULT NULL COMMENT '套餐的值。',
  `seller_nick` varchar(64) NOT NULL COMMENT '卖家昵称',
  `buyer_nick` varchar(64) NOT NULL COMMENT '买家昵称',
  `refund_status` varchar(32) DEFAULT NULL COMMENT '退款状态',
  `outer_iid` varchar(20) DEFAULT NULL COMMENT '商家外部编码(可与商家外部系统对接)。',
  `snapshot_url` varchar(128) DEFAULT NULL COMMENT '订单快照URL',
  `snapshot` varchar(200) DEFAULT NULL COMMENT '订单快照详细信息',
  `timeout_action_time` datetime DEFAULT NULL COMMENT '订单超时到期时间。格式:yyyy-MM-dd HH:mm:ss',
  `buyer_rate` varchar(7) NOT NULL COMMENT '买家是否已评价。',
  `cid` bigint(20) DEFAULT NULL COMMENT '交易商品对应的类目ID',
  `status` varchar(64) DEFAULT NULL COMMENT '订单状态（请关注此状态，如果为TRADE_CLOSED_BY_TAOBAO状态，则不要对此订单进行发货，切记啊！）',
  `title` varchar(128) DEFAULT NULL COMMENT '商品标题',
  `price` decimal(8,2) DEFAULT NULL COMMENT '商品价格。精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `num_iid` bigint(20) NOT NULL COMMENT '商品数字ID',
  `item_meal_id` bigint(20) DEFAULT NULL COMMENT '套餐ID',
  `sku_id` varchar(20) DEFAULT NULL COMMENT '商品的最小库存单位Sku的id.可以通过taobao.item.sku.get获取详细的Sku信息',
  `num` int(4) NOT NULL COMMENT '购买数量。取值范围:大于零的整数',
  `outer_sku_id` varchar(20) DEFAULT NULL COMMENT '外部网店自己定义的Sku编号',
  `order_from` varchar(20) DEFAULT NULL COMMENT '子订单来源如jhs(聚划算)、trade(淘宝)、wap(无线)',
  `total_fee` decimal(8,2) DEFAULT NULL COMMENT '应付金额',
  `payment` decimal(8,2) DEFAULT NULL COMMENT '子订单实付金额。',
  `discount_fee` decimal(8,2) DEFAULT NULL COMMENT '子订单级订单优惠金额。',
  `adjust_fee` decimal(8,2) DEFAULT NULL COMMENT '手工调整金额.',
  `modified` datetime DEFAULT NULL COMMENT '订单修改时间',
  `sku_properties_name` varchar(128) DEFAULT NULL COMMENT 'SKU的值。',
  `refund_id` bigint(20) DEFAULT NULL COMMENT '最近退款ID',
  `is_oversold` varchar(7) NOT NULL COMMENT '是否超卖',
  `end_time` datetime DEFAULT NULL COMMENT '子订单的交易结束时间',
  `consign_time` varchar(20) DEFAULT NULL COMMENT '子订单发货时间',
  `shipping_type` varchar(20) DEFAULT NULL COMMENT '子订单的运送方式',
  `bind_oid` bigint(20) DEFAULT NULL COMMENT '捆绑的子订单号，',
  `logistics_company` varchar(20) DEFAULT NULL COMMENT '子订单发货的快递公司名称',
  `simple_name` varchar(20) DEFAULT NULL COMMENT '快递公司的拼音码',
  `invoice_no` varchar(20) DEFAULT NULL COMMENT '子订单所在包裹的运单号',
  `is_daixiao` varchar(7) NOT NULL COMMENT '表示订单交易是否含有对应的代销采购单。',
  `divide_order_fee` decimal(8,2) DEFAULT NULL COMMENT '分摊之后的实付金额',
  `part_mjz_discount` varchar(8) DEFAULT NULL COMMENT '优惠分摊',
  `store_code` varchar(8) DEFAULT NULL COMMENT '发货的仓库编码',
  `seller_id` bigint(11) UNSIGNED NOT NULL COMMENT '商家id',
  `shop_id` bigint(11) UNSIGNED NOT NULL COMMENT '店铺Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83513 DEFAULT CHARSET=utf8 COMMENT='淘宝order';

-- ----------------------------
-- Table structure for order_yz
-- ----------------------------
DROP TABLE IF EXISTS `order_yz`;
CREATE TABLE `order_yz` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `num_iid` bigint(20) NOT NULL COMMENT '商品数字编号',
  `oid` bigint(20) NOT NULL COMMENT '订单ID',
  `tid` varchar(25) NOT NULL COMMENT '交易ID',
  `sku_id` bigint(20) DEFAULT NULL COMMENT 'Sku的ID',
  `sku_unique_code` varchar(20) DEFAULT NULL COMMENT 'Sku的唯一编码，该编码可用来判断所属商品，并保证商品唯一性。',
  `num` int(4) DEFAULT NULL COMMENT '商品购买数量',
  `outer_sku_id` varchar(20) DEFAULT NULL COMMENT '商家编码（商家为Sku设置的外部编号）',
  `user_id_yz` bigint(20) DEFAULT NULL COMMENT '应user_yz表user_id_yz',
  `outer_item_id` varchar(20) DEFAULT NULL COMMENT '商品货号（商家为商品设置的外部编号）',
  `title` varchar(20) DEFAULT NULL COMMENT '商品标题',
  `seller_nick` varchar(20) DEFAULT NULL COMMENT '卖家昵称',
  `price` varchar(20) DEFAULT NULL COMMENT '商品价格。',
  `total_fee` decimal(8,2) DEFAULT NULL COMMENT '应付金额（商品价格乘以数量的总金额）',
  `discount_fee` decimal(8,2) DEFAULT NULL COMMENT '交易明细内的优惠金额。',
  `payment` decimal(8,2) DEFAULT NULL COMMENT '实付金额',
  `sku_properties_name` varchar(20) DEFAULT NULL COMMENT 'SKU的值，即：商品的规格。如：机身颜色:黑色;手机套餐:官方标配',
  `item_type` int(4) DEFAULT NULL COMMENT '商品类型。',
  `seller_id` bigint(11) UNSIGNED NOT NULL COMMENT '商家id',
  `shop_id` bigint(11) UNSIGNED NOT NULL COMMENT '店铺Id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `num_iid` (`num_iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='有赞订单';

-- ----------------------------
-- Table structure for buyer_message
-- ----------------------------
DROP TABLE IF EXISTS `buyer_message_yz`;
CREATE TABLE `buyer_message` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `oid` bigint(20) NOT NULL COMMENT '订单ID',
  `title` varchar(50)  COMMENT '标题',
  `content` varchar(500) NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='有赞订单买家留言';

-- ----------------------------
-- Table structure for point_exchange
-- ----------------------------
DROP TABLE IF EXISTS `point_exchange`;
CREATE TABLE `point_exchange` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `user_id` bigint(11) NOT NULL COMMENT '用户Id',
  `point_amount` bigint(11) NOT NULL DEFAULT '0' COMMENT '兑换的积分数量',
  `exchange_id` bigint(11) NOT NULL COMMENT '兑换id：如果为红包，那么是红包id，如果为礼物，那么是礼物订单id',
  `exchange_present_amount` bigint(11) NOT NULL default 0 COMMENT '礼品属性数量, 红包就记录金额(分为单位)',
  `exchange_method` varchar(8) NOT NULL COMMENT '兑换方式：hongbao 红包,   goods 商品',
  `status` varchar(16) NOT NULL DEFAULT 'success' COMMENT '成功success 失败fail  过期expire(积分兑换红包过期) 兑换完over(积分兑换红包),待兑换 wait_exchange(积分兑换红包)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1242 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for point_obtain
-- ----------------------------
DROP TABLE IF EXISTS `point_obtain`;
CREATE TABLE `point_obtain` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `user_id` bigint(11) NOT NULL,
  `transferer_id` bigint(11) NOT NULL COMMENT '转让人，0为商家',
  `gmt_transfer` datetime DEFAULT NULL COMMENT '转让时间',
  `amount` bigint(11) NOT NULL DEFAULT '0' COMMENT '获得的积分数量',
  `amount_consumed` bigint(11) NOT NULL DEFAULT '0' COMMENT '消耗的积分',
  `gmt_expired` datetime DEFAULT NULL COMMENT '过期时间',
  `status` varchar(1) NOT NULL DEFAULT 'y' COMMENT 'y可用n不可用',
  `obtain_method` varchar(16) DEFAULT NULL COMMENT '获得方式：sign_in 签到 give赠送 share分享 shake 摇一摇 birthday生日 关注subscribe 购物shopping',
  `obtain_method_id` bigint(11) DEFAULT NULL COMMENT '获取id',
  `point_obtain_version` bigint(11) NOT NULL DEFAULT '0' COMMENT '版本号，用于乐观锁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2464 DEFAULT CHARSET=utf8 COMMENT='积分获得表';

-- ----------------------------
-- Table structure for point_transfer
-- ----------------------------
DROP TABLE IF EXISTS `point_transfer`;
CREATE TABLE `point_transfer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户号',
  `user_id` bigint(11) NOT NULL COMMENT '用户Id',
  `to_user_id` bigint(11) NOT NULL COMMENT '被转让的用户',
  `amount` bigint(11) NOT NULL COMMENT ' 转让数量',
  `gmt_transfer` datetime NOT NULL COMMENT '授予时间',
  `transfer_method` varchar(16) NOT NULL COMMENT '转让方式',
  `transfer_method_id` bigint(11) NOT NULL COMMENT '转让id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分转让表';

-- ----------------------------
-- Table structure for receiver_jd
-- ----------------------------
DROP TABLE IF EXISTS `receiver_jd`;
CREATE TABLE `receiver_jd` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(16) NOT NULL COMMENT '创建人',
  `modified_by` varchar(16) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(2) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `receiver_id_jd` bigint(11) NOT NULL COMMENT '收货人id,作为@BizId',
  `created` datetime NOT NULL COMMENT '交易创建时间',
  `user_id_jd` bigint(11) DEFAULT NULL COMMENT '对应user_jd表user_id_jd',
  `fullname` varchar(20) NOT NULL COMMENT '姓名',
  `telephone` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `full_address` varchar(200) NOT NULL COMMENT '地址',
  `province` varchar(32) COMMENT '省（省、市、县分级返回结果以下单地址为准）',
  `city` varchar(32) COMMENT '市（省、市、县分级返回结果以下单地址为准）',
  `county` varchar(32) COMMENT '县（省、市、县分级返回结果以下单地址为准）',
  `seller_id` bigint(11) NOT NULL COMMENT '商家id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `receiver_id_jd` (`receiver_id_jd`)
) ENGINE=InnoDB AUTO_INCREMENT=11442 DEFAULT CHARSET=utf8 COMMENT='京东收货人';

-- ----------------------------
-- Table structure for receiver_taobao
-- ----------------------------
DROP TABLE IF EXISTS `receiver_taobao`;
CREATE TABLE `receiver_taobao` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(2) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `receiver_id_tb` bigint(11) NOT NULL COMMENT '收货人id,作为@BizId',
  `user_id_tb` bigint(11) NOT NULL COMMENT '关联user_taobao表user_id_tb',
  `created` datetime NOT NULL COMMENT '交易创建时间。 格式: yyyy -MM - dd HH: mm :ss',
  `receiver_name` varchar(32) NOT NULL COMMENT '收货人姓名',
  `receiver_country` varchar(32) DEFAULT NULL COMMENT '国家',
  `receiver_state` varchar(32) NOT NULL COMMENT '收货人的所在省份',
  `receiver_city` varchar(32) DEFAULT NULL COMMENT ' 收货人城市',
  `receiver_district` varchar(32) DEFAULT NULL COMMENT ' 收货人地区',
  `receiver_town` varchar(32) DEFAULT NULL COMMENT '城镇',
  `receiver_address` varchar(256) NOT NULL COMMENT '收货人的详细地址',
  `receiver_zip` varchar(40) NOT NULL COMMENT '收货人邮编',
  `receiver_mobile` varchar(40) DEFAULT NULL COMMENT '收货人手机号码',
  `receiver_phone` varchar(40) DEFAULT NULL COMMENT '收货人电话',
  `seller_id` bigint(11) NOT NULL COMMENT '商家id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `receiver_id_tb` (`receiver_id_tb`)
) ENGINE=InnoDB AUTO_INCREMENT=155429 DEFAULT CHARSET=utf8 COMMENT='淘宝收货人';

-- ----------------------------
-- Table structure for receiver_yz
-- ----------------------------
DROP TABLE IF EXISTS `receiver_yz`;
CREATE TABLE `receiver_yz` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `receiver_id_yz` bigint(11) NOT NULL COMMENT '收货人id,作为@BizId',
  `user_id_yz` bigint(11) NOT NULL COMMENT '对应user_yz表user_id_yz',
  `created` datetime NOT NULL COMMENT '交易创建时间',
  `receiver_city` varchar(32) NOT NULL COMMENT '收货人的所在城市。',
  `receiver_district` varchar(32) NOT NULL COMMENT '收货人的所在地区',
  `receiver_name` varchar(32) NOT NULL COMMENT '收货人的姓名',
  `receiver_address` varchar(200) NOT NULL COMMENT '收货人的详细地址',
  `receiver_zip` varchar(10) DEFAULT NULL COMMENT '收货人的邮编',
  `receiver_mobile` varchar(20) NOT NULL COMMENT '收货人的手机号码',
  `receiver_state` varchar(32) NOT NULL COMMENT '收货人的所在省份',
  `seller_id` bigint(11) NOT NULL COMMENT '商家id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `receiver_id_yz` (`receiver_id_yz`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='有赞收货人';

-- ----------------------------
-- Table structure for rock_detail
-- ----------------------------
DROP TABLE IF EXISTS `rock_detail`;
CREATE TABLE `rock_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `rock_id` varchar(20) NOT NULL COMMENT '摇一摇ID',
  `seller_id` bigint(11) NOT NULL COMMENT '商家Id',
  `rock_title` varchar(20) NOT NULL COMMENT '摇一摇标题',
  `share_url` varchar(20) NOT NULL COMMENT '摇一url',
  `wx_number` varchar(20) NOT NULL COMMENT '微信公众号',
  `is_verify` varchar(5) NOT NULL COMMENT '是否需要验证 1:验证,0:不验证',
  `is_subscribe` varchar(5) NOT NULL COMMENT '是否需要关注,1:关注,0:未关注',
  `get_num` int(5) NOT NULL COMMENT '领取人数',
  `type` varchar(5) NOT NULL COMMENT '类型，my,自己摇，帮摇',
  `rock_num` int(5) NOT NULL COMMENT '摇的次数',
  `start_config` int(5) NOT NULL COMMENT '生效配置',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `start_date` int(5) DEFAULT NULL COMMENT '开始时间',
  `end_date` int(5) DEFAULT NULL COMMENT '结束时间',
  `hb_pool_id` int(5) DEFAULT NULL COMMENT '红包池ID',
  `hb_pool_name` varchar(20) DEFAULT NULL COMMENT '红包池Name',
  `get_hb_num` int(5) DEFAULT NULL COMMENT '领取红包人数',
  `is_get_hb_share` varchar(5) DEFAULT NULL COMMENT '领取是否需要分享，1：分享，0不分享',
  `get_gift_num` int(5) DEFAULT NULL COMMENT '领取礼物人数限制',
  `is_get_gift_share` varchar(5) DEFAULT NULL COMMENT '领取礼物后是否需要分享1：分享，0不分享',
  `goods_url` varchar(5) DEFAULT NULL COMMENT '商品地址',
  `point_interval_min` int(5) DEFAULT NULL COMMENT '积分最小值',
  `point_interval_max` int(5) DEFAULT NULL COMMENT '积分最大值',
  `get_point_num` int(5) DEFAULT NULL COMMENT '积分人数',
  `is_get_point_share` varchar(5) DEFAULT NULL COMMENT '领取积分后是否需要分享1：分享，0不分享',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='摇一摇配置明细表';

-- ----------------------------
-- Table structure for rule_config
-- ----------------------------
DROP TABLE IF EXISTS `rule_config`;
CREATE TABLE `rule_config` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户Id',
  `name` varchar(32) NOT NULL COMMENT 'Key',
  `value` varchar(1000) NOT NULL COMMENT '值',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `desc_text` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='规则配置表';

-- ----------------------------
-- Table structure for seller_mobile_menu
-- ----------------------------
DROP TABLE IF EXISTS `seller_mobile_menu`;
CREATE TABLE `seller_mobile_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `function_type` varchar(20) NOT NULL COMMENT '功能类型，advertisement:广告;module:模块',
  `type` varchar(20) NOT NULL COMMENT '菜单类型，indexpage:前端首页;point:积分商城',
  `name` varchar(20) NOT NULL COMMENT '菜单名称',
  `url` varchar(216) NOT NULL COMMENT '菜单图片地址',
  `link` varchar(216) NOT NULL COMMENT '菜单链接地址',
  `priority` int(4) NOT NULL COMMENT '优先级',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `is_show_other` varchar(2) NOT NULL DEFAULT '1' COMMENT '是否显示其他页面0:不是1:是',
  `is_select` varchar(2) NOT NULL DEFAULT '1' COMMENT '是否选中:0不是1:是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=242 DEFAULT CHARSET=utf8 COMMENT='商家手机端菜单配置';

-- ----------------------------
-- Table structure for sys_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_token`;
CREATE TABLE `sys_token` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `token` varchar(32) NOT NULL COMMENT 'token 值',
  `gmt_expired` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2288 DEFAULT CHARSET=utf8 COMMENT='防表单重复提交token';

-- ----------------------------
-- Table structure for tmall_rate_tag
-- ----------------------------
DROP TABLE IF EXISTS `tmall_rate_tag`;
CREATE TABLE `tmall_rate_tag` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `tag_id` bigint(11) DEFAULT NULL COMMENT '内部淘宝评价标签@BizId',
  `comment_id_tb` bigint(11) DEFAULT NULL COMMENT '内部淘宝评价id',
  `append_tags` tinyint(1) NOT NULL COMMENT '是否是追加的评论标签1:是;0:否',
  `tag_name` varchar(200) NOT NULL COMMENT '表示标签的名称',
  `posi` tinyint(1) NOT NULL COMMENT '表示标签的极性，正极1，负极0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tag_id` (`tag_id`),
  UNIQUE KEY `comment_id_tb` (`comment_id_tb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='淘宝评价标签表';

-- ----------------------------
-- Table structure for trade_taobao
-- ----------------------------
DROP TABLE IF EXISTS `trade_taobao`;
CREATE TABLE `trade_taobao` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `tid` bigint(20) NOT NULL COMMENT '交易编号 (父订单的交易编号)',
  `user_id_tb` bigint(11) NOT NULL COMMENT '关联user_taobao表user_id_tb',
  `receiver_id_tb` bigint(11) NOT NULL COMMENT '收件人Id',
  `seller_nick` varchar(20) NOT NULL COMMENT '卖家昵称',
  `shipping_type` varchar(64) DEFAULT NULL COMMENT '运送方式',
  `payment` decimal(8,2) NOT NULL COMMENT '实付金额。精确到2位小数;单位: 元。如:200.07，表示:200元7分',
  `seller_rate` varchar(7) NOT NULL COMMENT '卖家是否已评价',
  `buyer_obtain_point_fee` int(8) DEFAULT '0' COMMENT '返点积分',
  `post_fee` decimal(8,2) DEFAULT NULL COMMENT '快递费用',
  `receiver_name` varchar(32) NOT NULL COMMENT '收货人的姓名',
  `receiver_country` varchar(32) DEFAULT NULL COMMENT '国家',
  `receiver_state` varchar(32) NOT NULL COMMENT ' 收货人的所在省份',
  `receiver_town` varchar(32) DEFAULT NULL COMMENT '城镇',
  `receiver_address` varchar(256) NOT NULL COMMENT '收货人的详细地址',
  `receiver_zip` varchar(40) NOT NULL COMMENT '收货人的邮编',
  `receiver_mobile` varchar(40) DEFAULT NULL COMMENT '收货人的手机号码',
  `receiver_phone` varchar(40) DEFAULT NULL COMMENT ' 收货人的电话号码',
  `consign_time` datetime DEFAULT NULL COMMENT '卖家发货时间。 格式: yyyy -MM - dd HH: mm :ss',
  `seller_alipay_no` varchar(64) DEFAULT NULL COMMENT '卖家支付宝账号',
  `seller_mobile` varchar(11) DEFAULT NULL COMMENT '卖家手机',
  `seller_phone` varchar(20) DEFAULT NULL COMMENT '卖家电话',
  `seller_name` varchar(64) DEFAULT NULL COMMENT '卖家姓名',
  `seller_email` varchar(64) DEFAULT NULL COMMENT '卖家邮件地址',
  `available_confirm_fee` decimal(8,2) DEFAULT NULL COMMENT '交易中剩余的确认收货金额',
  `received_payment` decimal(8,2) DEFAULT NULL COMMENT '卖家实际收到的支付宝打款金额',
  `timeout_action_time` datetime DEFAULT NULL COMMENT '超时到期时间。 格式: yyyy -MM - dd HH: mm :ss。',
  `is_3d` varchar(7) NOT NULL COMMENT '是否是3D淘宝交易',
  `promotion` varchar(100) DEFAULT NULL COMMENT '交易促销详细信息',
  `est_con_time` datetime DEFAULT NULL COMMENT '商家的预计发货时间',
  `invoice_kind` varchar(2) DEFAULT NULL COMMENT '发票类型（1 电子发票 2 纸质发票）',
  `goods_category_num` int(8) DEFAULT '1' COMMENT '商品种类数量',
  `num` int(8) DEFAULT NULL COMMENT '商品购买数量。',
  `num_iid` varchar(256) NOT NULL COMMENT '商品数字编号列表',
  `status` varchar(64) NOT NULL COMMENT '交易状态。',
  `title` varchar(128) NOT NULL COMMENT '交易标题，以店铺名作为此标题的值。',
  `TYPE` varchar(20) DEFAULT NULL COMMENT '交易类型列表',
  `price` decimal(8,2) DEFAULT NULL COMMENT '商品价格。',
  `seller_cod_fee` decimal(8,2) DEFAULT NULL COMMENT '卖家货到付款服务费。',
  `discount_fee` decimal(8,2) DEFAULT NULL COMMENT '系统优惠金额',
  `point_fee` int(8) DEFAULT NULL COMMENT '买家使用积分 下单时生成，且一直不变。格式:100;单位: 个.',
  `total_fee` decimal(8,2) DEFAULT NULL COMMENT '商品金额',
  `is_brand_sale` varchar(7) NOT NULL COMMENT '表示是否是品牌特卖',
  `lg_aging` decimal(8,2) DEFAULT NULL COMMENT '次日达订单送达时间',
  `created` datetime NOT NULL COMMENT '交易创建时间。 格式: yyyy -MM - dd HH: mm :ss',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间。 格式: yyyy -MM - dd HH: mm :ss',
  `modified` datetime NOT NULL COMMENT '交易修改时间',
  `end_time` datetime DEFAULT NULL COMMENT '交易结束时间。',
  `buyer_message` varchar(500) DEFAULT NULL COMMENT '买家留言',
  `alipay_id` bigint(16) DEFAULT NULL COMMENT '买家的支付宝id号',
  `alipay_no` varchar(32) DEFAULT NULL COMMENT '支付宝交易号，如：2009112081173831',
  `buyer_alipay_no` varchar(64) DEFAULT NULL COMMENT '买家支付宝账号',
  `buyer_memo` varchar(500) DEFAULT NULL COMMENT '买家备注',
  `buyer_flag` int(2) DEFAULT NULL COMMENT '买家备注旗帜',
  `seller_memo` varchar(500) DEFAULT NULL COMMENT '卖家备注',
  `seller_flag` int(2) DEFAULT NULL COMMENT '卖家备注旗帜',
  `buyer_nick` varchar(32) NOT NULL COMMENT '买家昵称',
  `buyer_area` varchar(64) DEFAULT NULL COMMENT '买家下单的地区',
  `buyer_email` varchar(64) DEFAULT NULL COMMENT '买家邮件地址',
  `has_buyer_message` varchar(7) DEFAULT NULL COMMENT '判断订单是否有买家留言，有买家留言返回true，否则返回false',
  `area_id` varchar(20) DEFAULT NULL COMMENT '区域id',
  `credit_card_fee` varchar(20) DEFAULT NULL COMMENT '使用信用卡支付金额数',
  `nut_feature` varchar(64) DEFAULT NULL COMMENT '卡易售垂直表信息，去除下单ip之后的结果',
  `step_trade_status` varchar(50) DEFAULT NULL COMMENT '分阶段付款的订单状态',
  `step_paid_fee` varchar(50) DEFAULT NULL COMMENT ' 分阶段付款的已付金额（万人团订单已付金额）',
  `mark_desc` varchar(200) DEFAULT NULL COMMENT '订单出现异常问题的时候，给予用户的描述 没有异常的时候，此值为空',
  `send_time` varchar(32) DEFAULT NULL COMMENT '订单将在此时间前发出，主要用于预售订单',
  `trade_from` varchar(64) DEFAULT NULL COMMENT '交易内部来源。',
  `alipay_warn_msg` varchar(200) DEFAULT NULL COMMENT '淘宝下单成功了 但由于某种错误支付宝订单没有创建时返回的信息。trade.trade.add接口专用',
  `cod_status` varchar(32) DEFAULT NULL COMMENT '货到付款物流状态。',
  `can_rate` varchar(7) DEFAULT NULL COMMENT '买家可以通过此字段查询是否当前交易可以评论，can_rate=true可以评价，false则不能评价。',
  `commission_fee` varchar(16) DEFAULT NULL COMMENT '交易佣金。',
  `trade_memo` varchar(500) DEFAULT NULL COMMENT '交易备注。',
  `buyer_rate` varchar(7) DEFAULT NULL COMMENT '买家是否已评价。',
  `trade_source` varchar(16) DEFAULT NULL COMMENT ' 交易外部来源：ownshop(商家官网)',
  `is_part_consign` varchar(7) NOT NULL COMMENT '是否是多次发货的订单',
  `real_point_fee` int(8) DEFAULT NULL COMMENT '买家实际使用积分',
  `receiver_city` varchar(16) DEFAULT NULL COMMENT '收货人的所在城市',
  `receiver_district` varchar(16) DEFAULT NULL COMMENT '收货人的所在地区',
  `arrive_interval` int(4) DEFAULT NULL COMMENT '物流到货时效，单位天',
  `arrive_cut_time` varchar(20) DEFAULT NULL COMMENT ' 物流到货时效截单时间，格式 HH: mm',
  `consign_interval` int(4) DEFAULT NULL COMMENT ' 物流发货时效，单位小时',
  `async_modified` datetime DEFAULT NULL COMMENT '同步到卖家库的时间，trade.trades.sold.incrementv.get接口返回此字段',
  `alipay_point` int(8) DEFAULT NULL COMMENT '付款时使用的支付宝积分的额度 单位分，比如返回1，则为1分钱',
  `pcc_af` int(8) DEFAULT NULL COMMENT '天猫点券卡实付款金额 单位分',
  `is_wt` varchar(7) NOT NULL COMMENT '子订单是否是wt订单',
  `is_excel_import` varchar(7) NOT NULL DEFAULT 'false' COMMENT '是否是excel导入',
  `seller_id` bigint(11) NOT NULL COMMENT '商家id',
  `trade_close_reson` varchar(500) DEFAULT NULL COMMENT '订单关闭原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83514 DEFAULT CHARSET=utf8 COMMENT='淘宝交易';

-- ----------------------------
-- Table structure for trade_yz
-- ----------------------------
DROP TABLE IF EXISTS `trade_yz`;
CREATE TABLE `trade_yz` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '系统创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `tid` varchar(25) DEFAULT NULL COMMENT '订单ID',
  `user_id_yz` bigint(11) NOT NULL COMMENT '有赞用户id（内部系统定义）',
  `receiver_id_yz` bigint(11) NOT NULL COMMENT '收件人Id',
  `num` int(4) NOT NULL COMMENT '商品购买数量',
  `num_iid` varchar(200) NOT NULL COMMENT '所有商品编号',
  `pic_thumb_path` varchar(100) DEFAULT NULL COMMENT '商品主图片缩略图地址',
  `pic_path` varchar(100) DEFAULT NULL COMMENT '商品主图片地址',
  `price` decimal(8,2) NOT NULL COMMENT '商品价格',
  `title` varchar(50) NOT NULL COMMENT '订单标题',
  `type` varchar(10) NOT NULL COMMENT '交易类型交易类型。取值范围：FIXED （一口价）GIFT （送礼）PRESENT （赠品领取）COD （货到付款）QRCODE（扫码商家二维码直接支付的交易）',
  `weixin_user_id` bigint(11) NOT NULL COMMENT '微信粉丝ID',
  `buyer_type` int(2) NOT NULL COMMENT '买家类型，取值范围：0 为未知，1 为微信粉丝，2 为微博粉丝',
  `buyer_id` bigint(11) NOT NULL COMMENT ' 买家ID',
  `buyer_nick` varchar(20) NOT NULL COMMENT '买家昵称',
  `buyer_message` varchar(500) DEFAULT NULL COMMENT ' 买家购买附言',
  `seller_flag` int(2) NOT NULL COMMENT ' 卖家备注星标，取值范围 1、2、3、4、5；如果为0，表示没有备注星标',
  `trade_memo` varchar(500) DEFAULT NULL COMMENT ' 卖家对该交易的备注',
  `receiver_city` varchar(10) NOT NULL COMMENT ' 收货人的所在城市',
  `receiver_district` varchar(10) NOT NULL COMMENT ' 收货人的所在地区',
  `receiver_name` varchar(10) NOT NULL COMMENT ' 收货姓名',
  `receiver_state` varchar(10) NOT NULL COMMENT ' 收货人所在省',
  `receiver_address` varchar(100) NOT NULL COMMENT '收货人的详细地址',
  `receiver_zip` varchar(6) NOT NULL COMMENT '收货人邮编',
  `receiver_mobile` varchar(11) NOT NULL COMMENT '收货人手机',
  `feedback` int(5) NOT NULL COMMENT '交易维持状态',
  `outer_tid` varchar(20) DEFAULT NULL COMMENT '外部交易编号。比如，如果支付方式是微信支付，就是财付通的交易单号',
  `status` varchar(20) NOT NULL COMMENT '交易状态',
  `shipping_type` varchar(20) NOT NULL COMMENT '创建交易时的物流方式。取值范围：express（快递），fetch（到店自提）',
  `post_fee` decimal(8,2) DEFAULT NULL COMMENT '运费。单位：元，精确到分',
  `total_fee` decimal(8,2) NOT NULL COMMENT '商品应付金额（商品价格乘以数量的总金额）。单位：元，精确到分',
  `discount_fee` decimal(8,2) DEFAULT NULL COMMENT '交易优惠金额（不包含交易明细中的优惠金额）。单位：元，精确到分',
  `adjust_fee` decimal(8,2) DEFAULT NULL COMMENT '卖家手工调整订单金额',
  `payment` decimal(8,2) NOT NULL COMMENT '实付金额。单位：元，精确到分',
  `created` datetime NOT NULL COMMENT '交易创建时间',
  `update_time` datetime NOT NULL COMMENT '交易更新时间',
  `pay_time` datetime NOT NULL COMMENT '买家付款时间',
  `pay_type` varchar(10) DEFAULT NULL COMMENT '支付类型',
  `consign_time` datetime DEFAULT NULL COMMENT '发货时间',
  `sign_time` datetime DEFAULT NULL COMMENT '买家签收时间',
  `parent_tid` varchar(20) DEFAULT NULL COMMENT '父交易ID',
  `buyer_area` varchar(20) DEFAULT NULL COMMENT '下单区域',
  `seller_id` bigint(11) NOT NULL COMMENT '商家id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tid` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='有赞交易';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `user_id` bigint(11) DEFAULT NULL COMMENT '内部用户Id,作为@BizId',
  `seller_id` bigint(11) DEFAULT NULL COMMENT '商家Id',
  `user_id_tb` bigint(11) DEFAULT NULL COMMENT 'user_taobao表user_id',
  `user_id_jd` bigint(11) DEFAULT NULL COMMENT 'user_jd表user_id',
  `user_id_yz` bigint(11) DEFAULT NULL COMMENT 'user_yz表user_id',
  `first_source` varchar(16) NOT NULL COMMENT '用户来源 JD TB YZ WX，可以多个渠道',
  `receiver_id_tb` bigint(11) DEFAULT NULL COMMENT 'taobao receiver id',
  `receiver_id_jd` bigint(11) DEFAULT NULL COMMENT 'jd receiver id',
  `receiver_id_yz` bigint(11) DEFAULT NULL COMMENT 'youzan receiver id',
  `jd_pin` varchar(50) DEFAULT NULL COMMENT '买家账号信息',
  `tb_buyer_nick` varchar(32) DEFAULT NULL COMMENT '买家昵称',
  `wx_openid` varchar(32) DEFAULT NULL COMMENT '微信openid',
  `name` varchar(32) DEFAULT NULL COMMENT '用户姓名 从收货人中提取',
  `wx_nick_name` varchar(32) DEFAULT NULL COMMENT '微信昵称',
  `sex` varchar(1) DEFAULT '0' COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `city` varchar(32) DEFAULT NULL COMMENT '城市',
  `country` varchar(32) DEFAULT NULL COMMENT '用户所在国家',
  `province` varchar(32) DEFAULT NULL COMMENT '用户所在省份',
  `email` varchar(64) DEFAULT NULL COMMENT '邮件',
  `mobile` varchar(11) DEFAULT NULL COMMENT '用户手机号码',
  `wx_subscribe` varchar(8) DEFAULT NULL COMMENT '公众号关注标识',
  `wx_headimgurl` varchar(32) DEFAULT NULL COMMENT '微信头像',
  `wx_subscribe_time` varchar(32) DEFAULT NULL COMMENT '关注时间',
  `is_old_user` varchar(1) DEFAULT '0' COMMENT '老客户标识，1：老客户，0：新客户',
  `integral` bigint(11) DEFAULT '0' COMMENT '用户积分',
  `brand_fans` varchar(1) DEFAULT '0' COMMENT '品牌粉丝，1：是，0:否',
  `is_verify` varchar(1) DEFAULT '0' COMMENT '是否验证，1：是，0::否',
  `is_received_hb` varchar(1) DEFAULT '0' COMMENT '是领取过红包，1：是，0::否',
  `user_portrait_id` bigint(11) DEFAULT NULL COMMENT '用户画像Id',
  `user_birthday` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64254 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for user_bound
-- ----------------------------
DROP TABLE IF EXISTS `user_bound`;
CREATE TABLE `user_bound` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(2) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户Id',
  `bound_id` bigint(11) DEFAULT NULL COMMENT '绑定id,作为@BizId',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `user_id_tb` bigint(11) DEFAULT NULL COMMENT 'user_taobao表user_id',
  `user_id_jd` bigint(11) DEFAULT NULL COMMENT 'user_jd表user_id',
  `user_id_yz` bigint(11) DEFAULT NULL COMMENT 'user_yz表user_id',
  `receiver_id_tb` bigint(11) DEFAULT NULL COMMENT 'user_yz表user_id',
  `receiver_id_jd` bigint(11) DEFAULT NULL COMMENT 'user_yz表user_id',
  `receiver_id_yz` bigint(11) DEFAULT NULL COMMENT 'user_yz表user_id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `bound_id` (`bound_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户绑定表';

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(2) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `seller_id` bigint(11) NOT NULL COMMENT '商户Id',
  `account_id` bigint(11) DEFAULT NULL COMMENT '账户id,作为@BizId',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `hongbao_amount` bigint(11) DEFAULT NULL COMMENT '账户余额分为单位',
  `hbtotal_number` bigint(11) DEFAULT NULL COMMENT '累计领取红包个数',
  `hbobtain_amount` bigint(11) DEFAULT NULL COMMENT '累计领取红包金额分为单位',
  `hongbao_praise_amount` bigint(11) DEFAULT NULL COMMENT '累计领取好评返红包金额分为单位',
  `hongbao_shop_amount` bigint(11) DEFAULT NULL COMMENT '累计领取购物红包金额分为单位',
  `hbobtain_date` datetime DEFAULT NULL COMMENT '最近一次红包领取时间',
  `hbcash_amount` bigint(11) DEFAULT NULL COMMENT '累计提现红包金额分为单位',
  `hbcash_date` datetime DEFAULT NULL COMMENT '最近一次红包提现时间',
  `hbcash_number` bigint(11) DEFAULT NULL COMMENT '累计红包提现个数',
  `point_amount` bigint(11) NOT NULL DEFAULT '0' COMMENT '当前有效积分',
  `point_amount_total` bigint(11) NOT NULL DEFAULT '0' COMMENT '累计获得积分',
  `point_amount_exchange` bigint(11) NOT NULL DEFAULT '0' COMMENT '累计兑换积分',
  `point_amount_expired` bigint(11) NOT NULL DEFAULT '0' COMMENT '累计过期积分',
  `point_amount_transferred` bigint(11) NOT NULL DEFAULT '0' COMMENT '累计转让积分',
  `user_account_version` bigint(11) NOT NULL COMMENT '用户账户版本号，用于乐观锁',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2990 DEFAULT CHARSET=utf8 COMMENT='用户账户表';

-- ----------------------------
-- Table structure for user_interaction_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_interaction_detail`;
CREATE TABLE `user_interaction_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `biz_id` bigint(11) DEFAULT NULL COMMENT '互动业务id',
  `interaction_time` datetime NOT NULL COMMENT ' 互动时间',
  `interaction_type` varchar(16) DEFAULT NULL COMMENT '互动类型: EXCHANGE_GOODS:积分兑换商品,EXCHANGE_HONGBAO:积分兑换红包，SHIPPING_SEARCH:物流查询，GAME:游戏, DIAN_ZAN:点赞',
  `interaction_entry` varchar(32) NOT NULL COMMENT '互动入口（主要针对微信）: LINK:链接; SHAKE:遥一遥; KEY_WORD：关键字',
  `content` varchar(32) DEFAULT NULL COMMENT '互动内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户互动明细表';

-- ----------------------------
-- Table structure for user_interaction_statistic
-- ----------------------------
DROP TABLE IF EXISTS `user_interaction_statistic`;
CREATE TABLE `user_interaction_statistic` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `biz_id` bigint(11) DEFAULT NULL COMMENT '互动业务id',
  `dim_type` varchar(8) NOT NULL COMMENT 'user:用户维度;biz:业务维度（可以同时两个维度）',
  `first_interaction_time` datetime DEFAULT NULL COMMENT ' 第一次互动时间',
  `last_interaction_time` datetime DEFAULT NULL COMMENT '最后一次互动时间',
  `interaction_type` varchar(16) DEFAULT NULL COMMENT '互动类型: EXCHANGE_GOODS:积分兑换商品,EXCHANGE_HONGBAO:积分兑换红包，SHIPPING_SEARCH:物流查询，GAME:游戏, DIAN_ZAN:点赞',
  `interaction_entry` varchar(16) DEFAULT NULL COMMENT '互动入口（主要针对微信）:LINK:链接;SHAKE:遥一遥;KEY_WORD：关键字',
  `interaction_stat` varchar(128) NOT NULL COMMENT '互动的一些主体属性json格式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户互动统计表';

-- ----------------------------
-- Table structure for user_jd
-- ----------------------------
DROP TABLE IF EXISTS `user_jd`;
CREATE TABLE `user_jd` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `user_id_jd` bigint(11) DEFAULT NULL COMMENT '京东id,作为@BizId',
  `seller_id` bigint(11) NOT NULL COMMENT '商家Id',
  `pin` varchar(50) NOT NULL COMMENT '买家账号信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_jd` (`user_id_jd`)
) ENGINE=InnoDB AUTO_INCREMENT=10319 DEFAULT CHARSET=utf8 COMMENT='京东用户表';

-- ----------------------------
-- Table structure for user_portrait
-- ----------------------------
DROP TABLE IF EXISTS `user_portrait`;
CREATE TABLE `user_portrait` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `user_portrait_id` bigint(11) DEFAULT NULL COMMENT '用户画像Id,作为@BizId',
  `liveness` int(1) NOT NULL DEFAULT '0' COMMENT ' 用户活跃度，几颗星',
  `contribution` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '用户贡献度总体，总分100',
  `contribution_tb` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '用户贡献度tb，总分100',
  `contribution_jd` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '用户贡献度jd，总分100',
  `contribution_yz` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '用户贡献度yz，总分100',
  `total_purchase_amount` bigint(11) NOT NULL DEFAULT '0' COMMENT '累计购买金额',
  `total_purchase_times` int(8) NOT NULL DEFAULT '0' COMMENT '累计购买次数',
  `interactions_times` int(8) NOT NULL DEFAULT '0' COMMENT '累计互动次数',
  `sign_in_times` int(8) DEFAULT '0' COMMENT '累计签到次数',
  `last_sign_in_date` datetime  COMMENT '最后一次签到时间',
  `last_purchase_date` datetime  COMMENT '最后一次购买时间',
  `first_purchase_date` datetime  COMMENT '第一次购买时间',
  `last_purchase_amount` bigint(11) NOT NULL DEFAULT '0' COMMENT '最后一次购买金额',
  `mobile_purchase_rate` decimal(3,2) NOT NULL DEFAULT '0.00' COMMENT '手机购买率 例:0.5',
  `purchase_average_cycle` decimal(6,2) NOT NULL DEFAULT '0.00' COMMENT '平均购买周期',
  `purchase_average_amount` bigint(11) NOT NULL DEFAULT '0' COMMENT '平均购买金额',
  `wx_purchase_average_amount` bigint(11) DEFAULT '0' COMMENT '微信购买均价',
  `sms_accept_number` int(8) DEFAULT '0' COMMENT '短信接收次数',
  `sms_accept_circle` int(8) DEFAULT '0' COMMENT '短信接收周期，单位：天',
  `email_accept_number` int(8) DEFAULT '0' COMMENT '邮件接收次数',
  `email_accept_circle` int(8) DEFAULT '0' COMMENT '邮件接收周期，单位：天',
  `fancy` varchar(32) COMMENT '喜好',
  `goods_rate` decimal(3,2)  COMMENT '好评率 例0.5',
  `seller_id` bigint(11) NOT NULL COMMENT '商家Id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_portrait_id` (`user_portrait_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53888 DEFAULT CHARSET=utf8 COMMENT='用户画像';

-- ----------------------------
-- Table structure for user_tag_yz
-- ----------------------------
DROP TABLE IF EXISTS `user_tag_yz`;
CREATE TABLE `user_tag_yz` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `user_id_yz` bigint(11) NOT NULL COMMENT '有赞用户id',
  `tag_id` bigint(11) NOT NULL COMMENT '有赞用户标签id,@BizId',
  `name` varchar(64) NOT NULL COMMENT '有赞用户标签名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='有赞用户标签表';

-- ----------------------------
-- Table structure for user_taobao
-- ----------------------------
DROP TABLE IF EXISTS `user_taobao`;
CREATE TABLE `user_taobao` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `user_id_tb` bigint(11) DEFAULT NULL COMMENT '淘宝用户id,作为@BizId',
  `seller_id` bigint(11) NOT NULL COMMENT '商家Id',
  `buyer_alipay_no` varchar(64) DEFAULT NULL COMMENT '买家支付宝账号',
  `alipay_id` bigint(16) DEFAULT NULL COMMENT '买家支付宝Id',
  `buyer_nick` varchar(32) NOT NULL COMMENT '买家昵称',
  `buyer_email` varchar(64) DEFAULT NULL COMMENT '买家邮件',
  `area_id` varchar(6) DEFAULT NULL COMMENT '区域id，代表订单下单的区位码，区位码是通过省市区转换而来，通过区位码能精确到区内的划分，比如310012是杭州市西湖区华星路',
  `buyer_area` varchar(100) DEFAULT NULL COMMENT '买家下单地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_tb` (`user_id_tb`)
) ENGINE=InnoDB AUTO_INCREMENT=64265 DEFAULT CHARSET=utf8 COMMENT='淘宝用户表';

-- ----------------------------
-- Table structure for user_validate
-- ----------------------------
DROP TABLE IF EXISTS `user_validate`;
CREATE TABLE `user_validate` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `openid` varchar(32) NOT NULL COMMENT '微信openid',
  `mobile` varchar(11) DEFAULT NULL COMMENT '验证手机号',
  `code` varchar(6) NOT NULL COMMENT '手机验证码',
  `validate_date` datetime DEFAULT NULL COMMENT '验证时间',
  `result` varchar(1) DEFAULT NULL COMMENT '是否验证成功0:失败1:成功',
  `user_id` bigint(11) DEFAULT NULL COMMENT '验证成功返回的user_id',
  `status` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否验证 0:未验证 1：已验证',
  `invalid_time` int(1) DEFAULT NULL COMMENT '验证码失效时间',
  `seller_id` bigint(11) NOT NULL COMMENT '商家id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户认证记录表';

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
  `seller_id` bigint(11) NOT NULL COMMENT '商家Id',
  `msg_id` varchar(32) DEFAULT NULL COMMENT '消息id',
  `msg_type` varchar(32) NOT NULL COMMENT '消息类型',
  `key_word_config_id`  bigint(11)  COMMENT '关键字智能回复配置id',
  `key_word`  varchar(100)  COMMENT '关键字',
  `biz_type` varchar(32) NOT NULL COMMENT '业务类型,point_exchange_hb:积分兑换红包、express_query：快递查询、receive_common_hb：普通红包领取、praise_receive_hb：好评返红包、share_receive_hb：分享送红包、sign_in：签到、user_validate：用户验证、point_query：积分查询',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户Id',
  `first_source` varchar(20) DEFAULT NULL COMMENT '用户来源',
  `wx_openid` varchar(32) DEFAULT NULL COMMENT '微信用户OPENID',
  `wx_nick_name` varchar(20) DEFAULT NULL COMMENT '微信昵称',
  `mobile` varchar(20) DEFAULT NULL COMMENT '用户手机号码',
  `reply_type` varchar(32) DEFAULT NULL COMMENT '回复类型；intelligence：智能;artificial：人工',
  `send_type` varchar(32) NOT NULL COMMENT '发送类型，from_custom：客户发送，from_seller：商家发送',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  `to_user_name` varchar(32) NOT NULL COMMENT '商家公众号',
  `from_user_name` varchar(32) DEFAULT NULL COMMENT '发送者帐号',
  `create_time` datetime NOT NULL COMMENT '消息发送时间',
  `receive_content` varchar(500) DEFAULT NULL COMMENT '接收的内容',
  `reply_content` varchar(500) DEFAULT NULL COMMENT '回复内容',
  `media_id` varchar(20) DEFAULT NULL COMMENT '图片id',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `url` varchar(100) DEFAULT NULL COMMENT '点击链接的地址',
  `pic_url` varchar(100) DEFAULT NULL COMMENT '图片链接的地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='微信用户消息表';

-- ----------------------------
-- Table structure for user_yz
-- ----------------------------
DROP TABLE IF EXISTS `user_yz`;
CREATE TABLE `user_yz` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `user_id_yz` bigint(11) DEFAULT NULL COMMENT '有赞用户id,作为@BizId',
  `seller_id` bigint(11) NOT NULL COMMENT '商家Id',
  `weixin_user_id` bigint(20) NOT NULL COMMENT '微信粉丝ID',
  `buyer_area` varchar(100) DEFAULT NULL COMMENT '浙江省杭州市',
  `buyer_id` bigint(11) NOT NULL COMMENT '买家Id',
  `buyer_nick` varchar(32) NOT NULL COMMENT '买家昵称',
  `openid` varchar(32) NOT NULL COMMENT '微信openid',
  `nick_name` varchar(32) NOT NULL COMMENT '微信昵称',
  `sex` varchar(1) NOT NULL DEFAULT '1' COMMENT '性别',
  `city` varchar(32) NOT NULL COMMENT '城市',
  `province` varchar(32) NOT NULL COMMENT '用户所在省份',
  `headimgurl` varchar(32) DEFAULT NULL COMMENT '微信头像',
  `subscribe_time` varchar(32) DEFAULT NULL COMMENT '关注时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_yz` (`user_id_yz`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='有赞用户表';

-- ----------------------------
-- Table structure for wx_media
-- ----------------------------
DROP TABLE IF EXISTS `wx_media`;
CREATE TABLE `wx_media` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `created_by` varchar(20) NOT NULL COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL COMMENT '修改人',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑上被删除0:未删除1:删除',
  `title` varchar(50) DEFAULT NULL COMMENT '图文消息的标题',
  `thumb_media_id` bigint(11) DEFAULT NULL COMMENT '媒体文件上传后，获取时的唯一标识',
  `show_cover_pic` varchar(1) DEFAULT NULL COMMENT '是否显示封面，0为false，即不显示，1为true，即显示',
  `author` varchar(50) NOT NULL COMMENT '作者',
  `digest` varchar(500) DEFAULT NULL COMMENT '图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空',
  `content` mediumtext COMMENT '图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS',
  `url` varchar(50) DEFAULT NULL COMMENT '图文页的URL',
  `content_source_url` varchar(50) DEFAULT NULL COMMENT '图文消息的原文地址，即点击“阅读原文”后的URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信媒体素材';



-- ----------------------------
-- Table structure for seller_mobile_menu
-- ----------------------------
DROP TABLE IF EXISTS `shake_detail`;
CREATE TABLE `shake_detail` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` DATETIME NOT NULL COMMENT '创建时间',
  `gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
  `created_by` VARCHAR(20) NOT NULL COMMENT '创建人',
  `modified_by` VARCHAR(20) NOT NULL COMMENT '修改人',
  `is_deleted` VARCHAR(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `rock_id` VARCHAR(20)  NOT NULL COMMENT '摇一摇ID',
  `seller_id` bigint(11) NOT NULL COMMENT '商家Id',
  `rock_title` VARCHAR(20)  NOT NULL COMMENT '摇一摇标题',
  `share_url` VARCHAR(20)   COMMENT '摇一url',
  `wx_number` VARCHAR(20)   COMMENT '微信公众号',
  `is_verify` VARCHAR(5)  NOT NULL COMMENT '是否需要验证 1:验证,0:不验证',
  `is_subscribe` VARCHAR(5)   COMMENT '是否需要关注,1:关注,0:未关注',
  `get_num` INT(5)  NOT NULL COMMENT '领取人数',
  `random_num` INT(5)  NOT NULL COMMENT '机率值，1-100',
  `type` VARCHAR(5)  NOT NULL COMMENT '类型，my,自己摇，帮摇',
  `rock_num` INT(5)  NOT NULL COMMENT '摇的次数',
  `start_config` INT(5)  NOT NULL COMMENT '生效配置',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `start_date` DATETIME   COMMENT '开始时间',
  `end_date` DATETIME   COMMENT '结束时间',
  `is_shake_hb` VARCHAR(20)   COMMENT '是否摇红包',
  `hb_pool_id` VARCHAR(20)   COMMENT '红包池ID',
  `hb_pool_name` VARCHAR(20)   COMMENT '红包池Name',
  `get_hb_num` INT(5)   COMMENT '领取红包人数',
  `is_get_hb_share` VARCHAR(5)   COMMENT '领取是否需要分享，1：分享，0不分享',
  `is_shake_gift` VARCHAR(20)   COMMENT '是否摇礼物',
  `get_gift_num` INT(5)   COMMENT '领取礼物人数限制',
  `is_get_gift_share` VARCHAR(5)   COMMENT '领取礼物后是否需要分享1：分享，0不分享',
  `goods_id` VARCHAR(5)   COMMENT '商品地址',
  `goods_name` VARCHAR(5)   COMMENT '商品',
  `is_shake_point` VARCHAR(20)   COMMENT '是否摇积分',
  `point_interval_min` INT(5)   COMMENT '积分最小值',
  `point_interval_max` INT(5)   COMMENT '积分最大值',
  `get_point_num` INT(5)  COMMENT '积分人数',
  `is_get_point_share` VARCHAR(5)   COMMENT '领取积分后是否需要分享1：分享，0不分享',
PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='摇一摇配置明细表';



DROP TABLE IF EXISTS `shake_obtain`;
CREATE TABLE `shake_obtain` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gmt_created` DATETIME NOT NULL COMMENT '创建时间',
  `gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
  `created_by` VARCHAR(20) NOT NULL COMMENT '创建人',
  `modified_by` VARCHAR(20) NOT NULL COMMENT '修改人',
  `seller_id` bigint(11) NOT NULL COMMENT '商家Id',
  `is_deleted` VARCHAR(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `rock_id` bigint(20) DEFAULT NULL COMMENT '摇一摇id',
  `obtain_id` bigint(20) DEFAULT NULL COMMENT '领取ID,红包为红包领取表ID，积分为积分获取明细表ID',
  `rock_title` VARCHAR(20)  NOT NULL COMMENT '摇一摇标题',
  `rock_result` VARCHAR(20)  COMMENT '摇一摇结果',
  `rock_type` VARCHAR(20)  NOT NULL COMMENT '摇一摇类型',
  `shake_status` VARCHAR(20)  NOT NULL COMMENT '状态',
  `shake_date` DATETIME  NOT NULL COMMENT '摇到时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='摇一摇获取明细表';
-- ----------------------------
-- Table structure for user_birthday_config
-- ----------------------------
DROP TABLE IF EXISTS `user_birthday_config`;
CREATE TABLE `user_birthday_config` (
`id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`gmt_created` datetime NOT NULL COMMENT '系统创建时间',
`gmt_modified` datetime NOT NULL COMMENT '系统修改时间',
`created_by` varchar(20) NOT NULL COMMENT '创建人',
`modified_by` varchar(20) NOT NULL COMMENT '修改人',
`is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)',
`birthday_activity_id`  bigint NOT NULL COMMENT '生日id@BizId' ,
`seller_id` bigint NOT NULL COMMENT '商家id',
`goods_id`  bigint NULL COMMENT '对应积分商城的商品' ,
`points` bigint(20) DEFAULT '0' COMMENT '生日赠送积分',
`pool_id`  bigint(20) NULL COMMENT '关联红包池pool_id',
`title`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '标题' ,
`care_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '关怀类别(HB-红包;gifts-礼物;points-积分;discount-生日折扣)' ,
`status` int(1) NULL DEFAULT NULL COMMENT '活动状态，unstart未开始, start开启状态;stop暂停;over结束',
`send_target`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '赠送对象(auto-自动选择;manual-手动选择)' ,
`get_limit`  int NULL DEFAULT 1 COMMENT '限领次数' ,
`secret_password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '购物折扣暗号' ,
`discount`  double NULL COMMENT '生日当天折扣' ,
`remind_short_message`  int NULL COMMENT '是否短信提醒(1-是;0-否)' ,
`short_message_content`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '短信提醒内容' ,
`start_time` datetime COMMENT '开始时间',
`end_time`  datetime COMMENT '结束时间' ,
PRIMARY KEY (`id`),
UNIQUE KEY `birthday_activity_id` (`birthday_activity_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生日表配置表';

-- ----------------------------
-- Table structure for birthday_present
-- ----------------------------
DROP TABLE IF EXISTS `present`;
CREATE TABLE `present` (
`id`  bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
`gmt_created`  datetime NOT NULL COMMENT '创建时间' ,
`gmt_modified`  datetime NOT NULL COMMENT '修改时间' ,
`created_by`  varchar(20) COMMENT '创建人' ,
`modified_by`  varchar(20) NOT NULL COMMENT '修改人' ,
`is_deleted`  varchar(1)  DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)' ,
`present_id`  bigint(11) DEFAULT NULL COMMENT '内部礼物Id,作为@BizId' ,
`seller_id` bigint(11) UNSIGNED NOT NULL COMMENT '商家id',
`user_id`  bigint(11)  UNSIGNED NOT NULL COMMENT '用户id' ,
`birthday_acivity_id`  bigint(11) NOT NULL COMMENT '生日活动Id' ,
`present_type`  varchar(20)  NOT NULL COMMENT '礼物类型 ' ,
`present_name`  varchar(20)  NOT NULL COMMENT '礼物名字' ,
`present_source` varchar(20) DEFAULT NULL COMMENT '礼物来源  shake摇一摇, birthday生日' ,
`discount`  double DEFAULT NULL COMMENT '购物折扣' ,
`present_password`  varchar(20) DEFAULT NULL COMMENT '礼物暗号' ,
`goods_id`  bigint(11) DEFAULT NULL COMMENT '对应积分商城的商品id' ,
`hb_pool_id`  bigint(11) DEFAULT NULL COMMENT '对应红包池id' ,
`amount`  bigint(11) NULL COMMENT '赠送的红包金额或赠送的积分数量' ,
`is_receive`  tinyint  DEFAULT 0 COMMENT '是否已领取(1领取;0未领取)' ,
`expire_date` datetime DEFAULT NULL COMMENT '过期时间' ,
PRIMARY KEY (`id`),
UNIQUE KEY `present_id` (`present_id`)
)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='我的生日礼物表';

-- ----------------------------
-- Table structure for activity_records
-- ----------------------------
CREATE TABLE activity_records (
`id`  bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
`gmt_created`  datetime NOT NULL COMMENT '创建时间' ,
`gmt_modified`  datetime NOT NULL COMMENT '修改时间' ,
`created_by`  varchar(20)  NOT NULL COMMENT '创建人' ,
`modified_by`  varchar(20) NOT NULL COMMENT '修改人' ,
`is_deleted`  varchar(1)  DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)' ,
`activity_id`  bigint(11) NOT NULL COMMENT '活动Id' ,
`activity_name`  bigint(11) NOT NULL COMMENT '活动名称' ,
`seller_id` bigint(11) UNSIGNED NOT NULL COMMENT '商家id' ,
`user_id`  bigint(11)  UNSIGNED NOT NULL COMMENT '用户id' ,
`activity_type`  varchar(20) DEFAULT NULL COMMENT '活动类型，如摇一摇活动、生日活动' ,
`receive_date`  datetime DEFAULT NULL  COMMENT '领取日期' ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='活动记录表';

-- ----------------------------
-- Table structure for praise_records
-- ----------------------------
CREATE TABLE praise_records (
  `id`  bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `gmt_created`  datetime NOT NULL COMMENT '创建时间' ,
  `gmt_modified`  datetime NOT NULL COMMENT '修改时间' ,
  `created_by`  varchar(20)  NOT NULL COMMENT '创建人' ,
  `modified_by`  varchar(20) NOT NULL COMMENT '修改人' ,
  `is_deleted`  varchar(1)  DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)' ,
  `praise_id`  bigint(11) NOT NULL COMMENT '点赞记录Id' ,
  `seller_id` bigint(11) UNSIGNED NOT NULL COMMENT '商家id' ,
  `user_id`  bigint(11)  UNSIGNED NOT NULL COMMENT '点赞人id' ,
  `b_user_id`  bigint(11)  UNSIGNED NOT NULL COMMENT '被点赞人id' ,
  `praise_time`  datetime NOT NULL COMMENT '点赞时间' ,
  `praise_entry`  varchar(32) DEFAULT NULL COMMENT '点赞入口，红包领取排行榜：hongbao_receive_rank；积分兑换排行榜：point_exchange_rank' ,
  PRIMARY KEY (`id`),
  unique KEY (`praise_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='点赞记录表';

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE activity (
  `id`  bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `gmt_created`  datetime NOT NULL COMMENT '创建时间' ,
  `gmt_modified`  datetime NOT NULL COMMENT '修改时间' ,
  `created_by`  varchar(20)  NOT NULL COMMENT '创建人' ,
  `modified_by`  varchar(20) NOT NULL COMMENT '修改人' ,
  `is_deleted`  varchar(1)  DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)' ,
  `seller_id` bigint(11) NOT NULL COMMENT '商户Id',
  `activity_id`  bigint(11) NOT NULL COMMENT '活动Id,@BizId' ,
  `activity_name`  varchar(64) NOT NULL COMMENT '活动名称' ,
  `activity_photo_url` varchar(256)  NOT NULL COMMENT '活动图片地址' ,
  `activity_type` varchar(32) DEFAULT NULL COMMENT '活动类型，如摇一摇活动(activity_shake)、生日活动(activity_birthday)、购物红包活动(activity_shopping_hongbao)等等' ,
  `activity_desc` varchar(500) DEFAULT NULL COMMENT '活动详细说明' ,
  `begin_date`  datetime DEFAULT NULL  COMMENT '活动开始日期' ,
  `end_date`  datetime DEFAULT NULL  COMMENT '活动结束日期' ,
  `status` varchar(16) DEFAULT NULL COMMENT '活动状态：暂停(stop)，进行中(progressing )，已结束(end)，开启(start)',
  PRIMARY KEY (`id`),
  UNIQUE KEY(`activity_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='通用活动表';


-- ----------------------------
-- Table structure for activity_goods
-- ----------------------------
DROP TABLE IF EXISTS `activity_goods`;
CREATE TABLE activity_goods (
  `id`  bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `gmt_created`  datetime NOT NULL COMMENT '创建时间' ,
  `gmt_modified`  datetime NOT NULL COMMENT '修改时间' ,
  `created_by`  varchar(20)  NOT NULL COMMENT '创建人' ,
  `modified_by`  varchar(20) NOT NULL COMMENT '修改人' ,
  `is_deleted`  varchar(1)  DEFAULT '0' COMMENT '是否删除：1(删除) 0(未删除)' ,
  `seller_id` bigint(11) NOT NULL COMMENT '商户Id',
  `activity_id`  bigint(11) NOT NULL COMMENT '活动Id' ,
  `activity_goods_id`  bigint(11) NOT NULL COMMENT '活动商品Id, @BizId' ,
  `goods_id`  varchar(16) NOT NULL COMMENT '活动商品在购物平台的Id' ,
  `goods_name`  varchar(128) NOT NULL COMMENT '活动商品名称' ,
  `goods_url` varchar(256)  DEFAULT NULL COMMENT '活动商品图片地址' ,
  `goods_link` varchar(256)  NOT NULL COMMENT '活动商品在购物平台的详情链接' ,
  `goods_price`  int(9) NOT NULL COMMENT '活动商品价格，用分表示' ,
  `goods_quantity`  int(7) NOT NULL COMMENT '活动商品数量' ,
  `goods_source` varchar(16)  NOT NULL COMMENT '活动商品来源:  京东JD，天猫TMALL， 淘宝TB，有赞YOUZAN' ,
  `shop_name` varchar(32)  NOT NULL COMMENT '活动商品所在购物平台店铺名称' ,
  `cashback_type` varchar(16)  NOT NULL COMMENT '返现方式：红包hongbao，现金crash， 优惠券等' ,
  `hb_pool_id` VARCHAR(20)  NOT NULL COMMENT '红包池ID',
  `hbcash_amount` int(9) DEFAULT 0 COMMENT '累计红包总金额，分为单位',
  `apply_range` VARCHAR(20)   COMMENT '红包使用范围：指定商品可用goods， 全店通用shop',
  `release_time` int(5) DEFAULT 24 COMMENT '限定多少小时内没有购物，红包自动释放',
  PRIMARY KEY (`id`),
  UNIQUE KEY(`activity_goods_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='活动商品表';
