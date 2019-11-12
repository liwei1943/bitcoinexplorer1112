SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail`
(
  `tx_detail_id`  char(64) NOT NULL,
  `transaction_id`     int NOT NULL,
  `address`       char(64) NOT NULL,
  `type` varchar(255) ,
  `amount`     varchar (255),
  PRIMARY KEY (`tx_detail_id`),
  index `idx_address` (`address`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
