
-- 监控表建表语句
DROP TABLE IF EXISTS `gp_backup_monitor`;
CREATE TABLE `user_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL COMMENT '标题',
  `content` varchar(64) DEFAULT NULL COMMENT '内容',
  `level` varchar(64) DEFAULT NULL COMMENT '日志级别',
  `month` varchar(64) DEFAULT NULL COMMENT '备份月份',
  `db` varchar(64) DEFAULT NULL COMMENT '数据库名称',
  `table` varchar(64) DEFAULT NULL COMMENT '表格名称',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

