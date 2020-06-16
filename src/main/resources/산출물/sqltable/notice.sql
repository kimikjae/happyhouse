CREATE TABLE `notice` (
  `noticeno` int NOT NULL AUTO_INCREMENT COMMENT '공지번호',
  `id` varchar(45) NOT NULL COMMENT '아이디',
  `name` varchar(45) NOT NULL COMMENT '이름',
  `subject` varchar(100) NOT NULL COMMENT '제목',
  `content` varchar(1000) DEFAULT NULL COMMENT '내용',
  `uploaddate` datetime DEFAULT NULL COMMENT '게시일',
  PRIMARY KEY (`noticeno`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='공지사항'