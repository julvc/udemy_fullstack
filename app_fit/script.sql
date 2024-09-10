CREATE DATABASE `zone_fit` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

DROP TABLE IF EXISTS `zone_fit`.`client`;

CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `memberId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `memberId_UNIQUE` (`memberId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `zone_fit`.`client` (`name`, `lastname`, `memberId`) VALUES ('Julio', 'VC', '001');
INSERT INTO `zone_fit`.`client` (`name`, `lastname`, `memberId`) VALUES ('Julio', 'VC', '002');
INSERT INTO `zone_fit`.`client` (`name`, `lastname`, `memberId`) VALUES ('Julio', 'VC', '003');
INSERT INTO `zone_fit`.`client` (`name`, `lastname`, `memberId`) VALUES ('Julio', 'VC', '004');
