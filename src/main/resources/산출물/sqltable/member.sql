CREATE TABLE `member` (
  `no` int NOT NULL AUTO_INCREMENT COMMENT '회원번호',
  `id` varchar(45) NOT NULL COMMENT '아이디',
  `password` varchar(60) NOT NULL COMMENT '비밀번호',
  `date` datetime DEFAULT NULL COMMENT '가입일',
  `email` varchar(100) DEFAULT NULL COMMENT '이메일',
  `phonenumber` varchar(45) DEFAULT NULL COMMENT '휴대전화번호',
  `name` varchar(30) NOT NULL COMMENT '이름',
  `address1` varchar(45) DEFAULT NULL COMMENT '기본주소',
  `address2` varchar(45) DEFAULT NULL COMMENT '상세주소',
  `postnumber` varchar(5) DEFAULT NULL COMMENT '우편번호',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='회원정보'