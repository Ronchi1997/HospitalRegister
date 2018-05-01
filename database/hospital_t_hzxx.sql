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
-- Table structure for table `t_hzxx`
--

DROP TABLE IF EXISTS `t_hzxx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_hzxx` (
  `HZBH` char(6) NOT NULL,
  `HZMC` char(12) NOT NULL,
  `PYZS` char(4) NOT NULL,
  `KSBH` char(6) NOT NULL,
  `SFZJ` tinyint(1) NOT NULL,
  `GHRS` int(11) NOT NULL,
  `GHFY` decimal(8,2) NOT NULL,
  PRIMARY KEY (`HZBH`),
  KEY `index2` (`HZBH`),
  KEY `index3` (`KSBH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_hzxx`
--

LOCK TABLES `t_hzxx` WRITE;
/*!40000 ALTER TABLE `t_hzxx` DISABLE KEYS */;
INSERT INTO `t_hzxx` VALUES ('000001','号种一','HZYI','000001',0,2,10.00),('000002','号种二','HZER','000002',0,5,20.00),('000003','号种三','HZSA','000003',0,5,30.00),('000004','号种四','HZSI','000004',1,3,40.00),('000005','号种五','HZWU','000005',1,3,50.00),('000006','号种六','HZLI','000006',1,3,60.00);
/*!40000 ALTER TABLE `t_hzxx` ENABLE KEYS */;
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
