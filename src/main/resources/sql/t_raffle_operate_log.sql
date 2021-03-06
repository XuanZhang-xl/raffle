CREATE TABLE `t_raffle_operate_log` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `present_id` INT NOT NULL COMMENT '礼物id',
  `amount` INT NOT NULL COMMENT '数量',
  `lucky_dogs` VARCHAR(255) NOT NULL COMMENT '幸运儿',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT '操作表' AUTO_INCREMENT=1;