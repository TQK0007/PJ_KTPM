-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: the_wild_oasis
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `guests`
--

DROP TABLE IF EXISTS `guests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guests` (
  `guest_id` int NOT NULL AUTO_INCREMENT,
  `fullName` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `nationality` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `nationalID` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `countryFlag` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`guest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guests`
--

LOCK TABLES `guests` WRITE;
/*!40000 ALTER TABLE `guests` DISABLE KEYS */;
INSERT INTO `guests` VALUES (1,'Jonas Schmedtmann','hello@jonas.io','Portugal','3525436345','https://flagcdn.com/pt.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(2,'Jonathan Smith','johnsmith@test.eu','Great Britain','4534593454','https://flagcdn.com/gb.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(3,'Jonatan Johansson','jonatan@example.com','Finland','9374074454','https://flagcdn.com/fi.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(4,'Jonas Mueller','jonas@example.eu','Germany','1233212288','https://flagcdn.com/de.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(5,'Jonas Anderson','anderson@example.com','Bolivia (Plurinational State of)','0988520146','https://flagcdn.com/bo.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(6,'Jonathan Williams','jowi@gmail.com','United States of America','633678543','https://flagcdn.com/us.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(7,'Emma Watson','emma@gmail.com','United Kingdom','1234578901','https://flagcdn.com/gb.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(8,'Mohammed Ali','mohammedali@yahoo.com','Egypt','987543210','https://flagcdn.com/eg.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(9,'Maria Rodriguez','maria@gmail.com','Spain','1098765321','https://flagcdn.com/es.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(10,'Li Mei','li.mei@hotmail.com','China','102934756','https://flagcdn.com/cn.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(11,'Khadija Ahmed','khadija@gmail.com','Sudan','1023457890','https://flagcdn.com/sd.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(12,'Gabriel Silva','gabriel@gmail.com','Brazil','109283465','https://flagcdn.com/br.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(13,'Maria Gomez','maria@example.com','Mexico','108765421','https://flagcdn.com/mx.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(14,'Ahmed Hassan','ahmed@gmail.com','Egypt','1077777777','https://flagcdn.com/eg.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(15,'John Doe','johndoe@gmail.com','United States','3245908744','https://flagcdn.com/us.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(16,'Fatima Ahmed','fatima@example.com','Pakistan','1089999363','https://flagcdn.com/pk.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(17,'David Smith','david@gmail.com','Australia','44450960283','https://flagcdn.com/au.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(18,'Marie Dupont','marie@gmail.com','France','06934233728','https://flagcdn.com/fr.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(19,'Ramesh Patel','ramesh@gmail.com','India','9875412303','https://flagcdn.com/in.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(20,'Fatimah Al-Sayed','fatimah@gmail.com','Kuwait','0123456789','https://flagcdn.com/kw.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(21,'Nina Williams','nina@hotmail.com','South Africa','2345678901','https://flagcdn.com/za.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(22,'Taro Tanaka','taro@gmail.com','Japan','3456789012','https://flagcdn.com/jp.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(23,'Abdul Rahman','abdul@gmail.com','Saudi Arabia','4567890123','https://flagcdn.com/sa.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(24,'Julie Nguyen','julie@gmail.com','Vietnam','5678901234','https://flagcdn.com/vn.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(25,'Sara Lee','sara@gmail.com','South Korea','6789012345','https://flagcdn.com/kr.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(26,'Carlos Gomez','carlos@yahoo.com','Colombia','7890123456','https://flagcdn.com/co.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(27,'Emma Brown','emma@gmail.com','Canada','8901234567','https://flagcdn.com/ca.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(28,'Juan Hernandez','juan@yahoo.com','Argentina','4343433333','https://flagcdn.com/ar.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(29,'Ibrahim Ahmed','ibrahim@yahoo.com','Nigeria','2345678009','https://flagcdn.com/ng.svg','2024-10-08 08:45:02',NULL,NULL,NULL),(30,'Mei Chen','mei@gmail.com','Taiwan','3456117890','https://flagcdn.com/tw.svg','2024-10-08 08:45:02',NULL,NULL,NULL);
/*!40000 ALTER TABLE `guests` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-13  8:31:51
