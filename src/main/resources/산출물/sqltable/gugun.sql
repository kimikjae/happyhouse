CREATE TABLE `gugun` (
  `gugun` varchar(20) NOT NULL,
  `city` varchar(2) DEFAULT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`gugun`),
  KEY `city` (`city`),
  CONSTRAINT `gugun_ibfk_1` FOREIGN KEY (`city`) REFERENCES `city` (`city`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8