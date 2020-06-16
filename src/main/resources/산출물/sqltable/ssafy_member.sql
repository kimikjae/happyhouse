CREATE TABLE `ssafy_member` (
  `userid` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `userpwd` varchar(100) NOT NULL,
  `email` varchar(2000) DEFAULT NULL,
  `address` varchar(2000) DEFAULT NULL,
  `joindate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8