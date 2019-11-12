SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction`
(
  `txid`  int NOT NULL,
  `transaction_id`  int NOT NULL,
  `txhash`  char(64) NOT NULL,
  `confirmations`     int NOT NULL,
  `time`       bigint ,
  `amount`     int NOT NULL,
  `height`       int NOT NULL,
  `total_input` double,
  `weight`     int NOT NULL,
  `status`     tinyint,
  `total_output` double ,
  `fees` varchar (50),
  `fee_per_byte` int NOT NULL,
  `fee_per_weight` int NOT NULL,
  `sizeOnDisk` int NOT NULL,
  `block_id` int not null ,
  PRIMARY KEY (`transaction_id`),
  index `idx_time` (`time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
