
-- 合伙人添加推荐人字段
ALTER TABLE `solshire`.`sol_riches`
ADD COLUMN `reference` VARCHAR(45) NULL COMMENT '推荐人' AFTER `addtime`;
ALTER TABLE `solshire`.`sol_orderdata`
CHANGE COLUMN `policyNo` `policyNo` VARCHAR(32) NULL DEFAULT NULL COMMENT '保单编号' ;

-- select @@global.sql_mode;
-- set global sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

-- 不一致 费率和保单表 货币类型字段
-- 酬金发放添加 实际支付 佣金返回时间
-- 保险产品费率 添加时间是不是失效时间  首年年供佣金 首年月供佣金  生效时间
-- 财富团队费率 设置佣金比率 字段问题 产品类型
-- richer 添加金牌顾问字段