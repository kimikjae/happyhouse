CREATE TABLE `housedeal` (
  `no` int NOT NULL AUTO_INCREMENT COMMENT '거래번호',
  `dong` varchar(45) NOT NULL COMMENT '법정동명',
  `Aptname` varchar(45) NOT NULL COMMENT '아파트이름',
  `code` int NOT NULL COMMENT '법정동코드',
  `dealAmount` varchar(45) NOT NULL COMMENT '거래금액',
  `buildYear` varchar(45) DEFAULT NULL COMMENT '건축연도',
  `dealYear` varchar(45) DEFAULT NULL COMMENT '거래연도',
  `dealMonth` varchar(45) DEFAULT NULL COMMENT '거래월',
  `dealDay` varchar(45) DEFAULT NULL COMMENT '거래일',
  `area` varchar(45) DEFAULT NULL COMMENT '면적',
  `floor` varchar(45) DEFAULT NULL COMMENT '층',
  `jibun` varchar(45) DEFAULT NULL COMMENT '지번',
  `type` varchar(45) DEFAULT NULL COMMENT '거래타입',
  `rentMoney` varchar(45) DEFAULT NULL COMMENT '월세',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=68865 DEFAULT CHARSET=utf8 COMMENT='실거래가'