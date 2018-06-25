
-- 合伙人添加推荐人字段
ALTER TABLE `solshire`.`sol_riches`
ADD COLUMN `reference` VARCHAR(45) NULL COMMENT '推荐人' AFTER `addtime`;
ALTER TABLE `solshire`.`sol_orderdata`
CHANGE COLUMN `policyNo` `policyNo` VARCHAR(32) NULL DEFAULT NULL COMMENT '保单编号' ;

-- select @@global.sql_mode;
-- set global sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
