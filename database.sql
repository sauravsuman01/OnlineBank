CREATE DATABASE  IF NOT EXISTS `perfios` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `perfios`;
-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: perfios
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `adminid` int NOT NULL,
  `adminpass` varchar(20) DEFAULT NULL,
  `adminname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (123456,'Admin@123','Saurav'),(456789,'Admin@123',NULL);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banking`
--

DROP TABLE IF EXISTS `banking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banking` (
  `initial` varchar(5) DEFAULT NULL,
  `first_name` varchar(15) DEFAULT NULL,
  `last_name` varchar(15) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `pan` varchar(10) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `occ` varchar(15) DEFAULT NULL,
  `income` varchar(30) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `acc` int NOT NULL,
  `custid` int DEFAULT NULL,
  `pass` varchar(45) DEFAULT NULL,
  `balance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`acc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banking`
--

LOCK TABLES `banking` WRITE;
/*!40000 ALTER TABLE `banking` DISABLE KEYS */;
INSERT INTO `banking` VALUES ('Mr.','Arijit','Roy','7277200451','POIKLJ7894','Bangalore','Salaried','Above 10 Lakhs',NULL,0,0,'World','5000'),('Mr.','Hello','World','7894561233','KIJUKLOP78','Bangalore','Salaried','Above 10 Lakhs','Savings',12563,78945,'World','5000'),('mr','Saurav ','Suman','7277200451','KGVPS2757D','Bangalore','salaried','a10','savings',56066,NULL,NULL,NULL),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',169376,13262,'lp','2530'),('Mr. ','Saurav','Suman','7277200451','KGVPS2757D','Patna','Salaried','Above 10 Lakhs','Savings',244272,83000,'Hello','14487038'),('mr','arijit','roy','7895641230','KLOPLKOPLK','BA','salaried','a10','savings',475275,25915,'ghj',NULL),('Ms. ','Unnathi','K','9398341502','AISPU041A','Bangalore','Salaried','Above 10 Lakhs','Savings',1601506,25383,'Killit','171750'),('Mr. ','Josh','Hong','1234567890','QWDRt23Q1','Canada','Salaried','Above 10 Lakhs','Savings',2738563,25784,'qwerty','5000'),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',2788637,56653,'lp','2530'),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',3180278,10843,'lp','2530'),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',3397296,64703,'lp','2530'),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',4475927,25700,'lp','2530'),('mr','Hello','World','785463221','HLIOPPP','Bangalore','self','1t5','savings',4595265,63948,'hlo',NULL),('Mr. ','Aditya','Prasad','7456891236','QWERTYU78','Bihar','Salaried','Above 10 Lakhs','Savings',4684107,47693,'Aditya','25000'),('Mr. ','Teja','H','7894561236','ASWQDE56RT','Bangalore','Salaried','Above 10 Lakhs','Savings',4808970,76557,'Mamba','50000'),('Mr. ','Abhinav','Bakshi','9369871523','BLMPB2155D','Lucknow','Self','Above 10 Lakhs','Savings',5105519,62089,'Organic@99','0'),('Mr. ','','','','','','Salaried','Less than 1 lakh','Savings',5809845,8667,'',NULL),('Mr. ','Dilip','G','7891230456','QGDTr45R','Bangalore','Self','Less than 1 lakh','Savings',6174446,29427,'qwerty','5000'),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',6210560,11496,'lp','2530'),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',6341234,79347,'lp','2530'),('Mr. ','Hello','World','7277200451','ASDFG123RG','Bangalore','salaried','Above 10 Lakhs','Savings',6674534,95100,'hloo',NULL),('Mr. ','dhb','jd','7894552314','jjj','jj','Salaried','Less than 1 lakh','Savings',7001001,27433,'hj',NULL),('Mr. ','','','','','','Salaried','Less than 1 lakh','Savings',7529609,14096,'',NULL),('mr','Saurav','Suman','7894561230','jkipk','Kolkata','salaried','a10','savings',7749369,18970,'Saurav',NULL),('Mr. ','Arijit ','Roy','7845123691','ASEDR123RF','Bangalore','Salaried','5 Lakhs to 10 Lakhs','Savings',7896189,63209,'Hlo','30000'),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',8366430,35751,'lp','2530'),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',8399962,77493,'lp','2530'),('Mr. ','Sahil','S','9658321472','PLOKIJUH89','Ara','Salaried','Above 10 Lakhs','Savings',8524285,64034,'Sahil','10000'),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',8556682,32151,'lp','2530'),('Mr. ','Devesh','Bharatiya','7845123695','LIKOPJHY78','Lucknow','Salaried','Above 10 Lakhs','Savings',8849169,89237,'Devesh','20000'),('Mr. ','sajks','skjdf','7896541253','skdm','kn','Salaried','Less than 1 lakh','Savings',9081859,99689,'jk',NULL),('Mr.','Saurav','Suman','72772051','KGVPS2757D','Bangalore','Salaried','Above 10 Lakhs','Savings',9654321,NULL,NULL,NULL),('Mr. ','hjkk','kok','7845123692','kliopl','njnn','Salaried','Less than 1 lakh','Savings',9924829,98416,'lp','2530');
/*!40000 ALTER TABLE `banking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gas`
--

DROP TABLE IF EXISTS `gas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gas` (
  `acc` int NOT NULL,
  `due` int DEFAULT NULL,
  PRIMARY KEY (`acc`),
  CONSTRAINT `gas_ibfk_1` FOREIGN KEY (`acc`) REFERENCES `banking` (`acc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gas`
--

LOCK TABLES `gas` WRITE;
/*!40000 ALTER TABLE `gas` DISABLE KEYS */;
INSERT INTO `gas` VALUES (244272,0),(1601506,0),(5105519,0);
/*!40000 ALTER TABLE `gas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `acc` int NOT NULL,
  `due` int DEFAULT NULL,
  PRIMARY KEY (`acc`),
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`acc`) REFERENCES `banking` (`acc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (244272,0);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-10 14:22:26
