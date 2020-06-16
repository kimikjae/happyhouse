CREATE TABLE `qna_board` (
  `qna_no` int NOT NULL AUTO_INCREMENT COMMENT '질문번호',
  `qna_title` varchar(300) NOT NULL COMMENT '질문제목',
  `qna_content` varchar(4000) NOT NULL COMMENT '질문내용',
  `qna_userid` varchar(20) NOT NULL COMMENT '질문자아이디',
  `qna_datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '질문일시',
  `reply_content` varchar(4000) DEFAULT NULL COMMENT '답변내용',
  `reply_datetime` timestamp NULL DEFAULT NULL COMMENT '답변일시',
  `reply_userid` varchar(20) DEFAULT NULL COMMENT '답변자아이디',
  PRIMARY KEY (`qna_no`),
  KEY `qna_to_user_fk1` (`qna_userid`),
  KEY `qna_to_user_fk2` (`reply_userid`),
  CONSTRAINT `qna_to_user_fk1` FOREIGN KEY (`qna_userid`) REFERENCES `ssafy_member` (`userid`),
  CONSTRAINT `qna_to_user_fk2` FOREIGN KEY (`reply_userid`) REFERENCES `ssafy_member` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='질문게시판'