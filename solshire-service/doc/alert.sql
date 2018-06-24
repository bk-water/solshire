
-- 合伙人添加推荐人字段
ALTER TABLE `solshire`.`sol_riches`
ADD COLUMN `reference` VARCHAR(45) NULL COMMENT '推荐人' AFTER `addtime`;
ALTER TABLE `solshire`.`sol_orderdata`
CHANGE COLUMN `policyNo` `policyNo` VARCHAR(32) NULL DEFAULT NULL COMMENT '保单编号' ;

