-- ----------------------------
-- 黑名单表结构
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist` (
  `blacklist_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '黑名单ID',
  `user_id` bigint(20) NOT NULL COMMENT '被拉黑用户ID',
  `user_name` varchar(30) DEFAULT NULL COMMENT '被拉黑用户名',
  `user_nick_name` varchar(30) DEFAULT NULL COMMENT '被拉黑用户昵称',
  `blacklist_type` tinyint(1) DEFAULT '1' COMMENT '黑名单类型：1-投诉拉黑，2-主动拉黑',
  `reason` varchar(500) DEFAULT NULL COMMENT '拉黑原因',
  `related_complaint_id` bigint(20) DEFAULT NULL COMMENT '关联投诉ID',
  `operator_id` bigint(20) DEFAULT NULL COMMENT '操作人ID',
  `operator_name` varchar(64) DEFAULT NULL COMMENT '操作人名称',
  `unblock_time` datetime DEFAULT NULL COMMENT '解封时间（永久为NULL）',
  `status` char(1) DEFAULT '0' COMMENT '状态：0-拉黑中，1-已解封',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`blacklist_id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_status` (`status`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='黑名单表';

-- ----------------------------
-- 初始化一些测试数据（可选）
-- ----------------------------
-- INSERT INTO `blacklist` (`user_id`, `user_name`, `user_nick_name`, `blacklist_type`, `reason`, `operator_id`, `operator_name`, `status`, `create_by`, `remark`)
-- VALUES (1, 'test_user', '测试用户', 1, '多次恶意投诉', 1, 'admin', '0', 'admin', '因恶意投诉被永久拉黑');
