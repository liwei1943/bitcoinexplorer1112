SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `block`;
CREATE TABLE `block`
(
  `block_id`  int NOT NULL,
  `blockhash`  char(64) NOT NULL,
  `confirmations`     int NOT NULL,
  `time`      bigint,
  `height`     int NOT NULL,
  `txnumber`       int NOT NULL,
  `difficulty` double,
  `weight`     int NOT NULL,
  `merkle_root` char(64),
  `version` varchar (50),
  `bits` int NOT NULL,
  `miner` varchar (50),
  `nonce` int NOT NULL,
  `txvolume` double,
  `block_reward` double,
  `fee_reward` double,
  `sizeOnDisk` int not null,
  PRIMARY KEY (`blockhash`),
  index `idx_height` (`height`),
  index `idx_time` (`time`),
  index `idx_blockhash` (`blockhash`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
