CREATE TABLE `fund_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fcode` varchar(10) NOT NULL DEFAULT '' COMMENT '基金代码',
  `fdate` datetime DEFAULT NULL COMMENT '基金日期',
  `NAV` decimal(10,4) DEFAULT NULL COMMENT '单位净值',
  `ACCNAV` decimal(10,4) DEFAULT NULL COMMENT '累计净值',
  `DGR` varchar(20) DEFAULT NULL COMMENT '日增长率',
  `pstate` varchar(20) DEFAULT NULL COMMENT '申购状态',
  `rstate` varchar(20) DEFAULT NULL COMMENT '赎回状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基金详细数据表';


