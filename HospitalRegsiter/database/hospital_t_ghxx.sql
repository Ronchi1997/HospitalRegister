-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_ghxx`
--

DROP TABLE IF EXISTS `t_ghxx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ghxx` (
  `GHBH` char(6) NOT NULL,
  `HZBH` char(6) NOT NULL,
  `YSBH` char(6) NOT NULL,
  `BRBH` char(6) NOT NULL,
  `GHRC` int(11) NOT NULL,
  `THBZ` tinyint(1) NOT NULL,
  `GHFY` decimal(8,2) NOT NULL,
  `RQSJ` datetime NOT NULL,
  PRIMARY KEY (`GHBH`),
  KEY `index2` (`GHBH`),
  KEY `index3` (`HZBH`),
  KEY `index4` (`YSBH`),
  KEY `index5` (`BRBH`),
  KEY `index6` (`GHRC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ghxx`
--

LOCK TABLES `t_ghxx` WRITE;
/*!40000 ALTER TABLE `t_ghxx` DISABLE KEYS */;
INSERT INTO `t_ghxx` VALUES ('042402','000001','000001','000004',2,1,10.00,'2018-04-24 22:11:06'),('042901','000001','000001','000001',1,1,10.00,'2018-04-29 21:40:08'),('042902','000003','000003','000001',1,1,30.00,'2018-04-29 21:40:37');
/*!40000 ALTER TABLE `t_ghxx` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-29 22:45:12
