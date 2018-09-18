CREATE TABLE `t_raffle_present` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL COMMENT '名称',
  `total_amount` INT NOT NULL COMMENT '总数',
  `remain` INT NOT NULL COMMENT '剩余数量',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='礼物表' AUTO_INCREMENT=1 ;

INSERT INTO `t_raffle_present` VALUES (1, 'iphoneX', 1, 89, '2018-3-10 17:37:42', '2018-3-18 14:04:32');
INSERT INTO `t_raffle_present` VALUES (2, '电动车', 2, 184, '2018-3-10 17:37:58', '2018-3-18 13:50:36');
INSERT INTO `t_raffle_present` VALUES (3, '美的电饭煲', 6, 279, '2018-3-10 17:38:11', '2018-3-18 13:37:20');
INSERT INTO `t_raffle_present` VALUES (4, '小熊养生壶', 10, 417, '2018-3-10 17:38:24', '2018-3-18 13:22:26');
