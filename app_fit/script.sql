CREATE DATABASE `zone_fit` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

DROP TABLE IF EXISTS `zone_fit`.`client`;

CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `memberid` int,
  PRIMARY KEY (`id`),
  UNIQUE KEY `memberid_UNIQUE` (`memberid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `zone_fit`.`client` (`name`, `lastname`, `memberid`) VALUES ('Julio', 'VC', 1);
INSERT INTO `zone_fit`.`client` (`name`, `lastname`, `memberid`) VALUES ('Julio', 'VC', 2);
INSERT INTO `zone_fit`.`client` (`name`, `lastname`, `memberid`) VALUES ('Julio', 'VC', 3);
INSERT INTO `zone_fit`.`client` (`name`, `lastname`, `memberid`) VALUES ('Julio', 'VC', 4);
