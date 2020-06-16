CREATE TABLE `houseinfo` (
  `no` int NOT NULL AUTO_INCREMENT COMMENT '집번호',
  `dong` varchar(45) NOT NULL COMMENT '법정동명',
  `AptName` varchar(45) NOT NULL COMMENT '아파트 이름',
  `code` int NOT NULL COMMENT '법정동코드',
  `buildYear` varchar(45) DEFAULT NULL COMMENT '건축연도',
  `jibun` varchar(45) DEFAULT NULL COMMENT '지번',
  `lat` varchar(45) DEFAULT NULL COMMENT '위도',
  `lng` varchar(45) DEFAULT NULL COMMENT '경도',
  `img` varchar(45) DEFAULT NULL COMMENT '이미지',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=5996 DEFAULT CHARSET=utf8 COMMENT='집정보'