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
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `bookings_id` int NOT NULL AUTO_INCREMENT,
  `cabin_id` int NOT NULL,
  `guest_id` int NOT NULL,
  `numNights` int DEFAULT NULL,
  `numGuests` int DEFAULT NULL,
  `cabinPrice` double DEFAULT NULL,
  `extrasPrice` double DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `status` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `hasBreakfast` tinyint(1) DEFAULT NULL,
  `isPaid` tinyint(1) DEFAULT NULL,
  `observations` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `endDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`bookings_id`),
  KEY `fk_CabinBookings` (`cabin_id`),
  KEY `fk_GuestsBookings` (`guest_id`),
  CONSTRAINT `fk_CabinBookings` FOREIGN KEY (`cabin_id`) REFERENCES `cabin` (`cabin_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_GuestsBookings` FOREIGN KEY (`guest_id`) REFERENCES `guests` (`guest_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,1,2,7,1,1750,105,1855,'unconfirmed',1,0,'I have a gluten allergy and would like to request a gluten-free breakfast.','2024-10-19 09:53:48',NULL,NULL,NULL,'2024-11-07 17:00:00','2024-11-14 17:00:00'),(2,1,3,10,2,2500,300,2800,'checked-out',1,1,'','2024-10-07 03:34:54',NULL,NULL,NULL,'2024-10-16 17:00:00','2024-10-26 17:00:00'),(3,1,4,6,2,1500,0,1500,'unconfirmed',0,0,'','2024-10-13 03:34:54',NULL,NULL,NULL,'2024-11-20 17:00:00','2024-11-26 17:00:00'),(4,2,5,16,2,5200,0,5200,'checked-out',0,1,'','2024-09-25 03:34:54',NULL,NULL,NULL,'2024-09-24 17:00:00','2024-10-10 17:00:00'),(5,2,6,3,2,975,90,1065,'unconfirmed',1,1,'','2024-11-07 03:34:54',NULL,NULL,NULL,'2024-11-23 17:00:00','2024-11-26 17:00:00'),(6,2,7,15,2,4875,450,5325,'unconfirmed',1,0,'','2024-11-04 03:34:54',NULL,NULL,NULL,'2024-12-11 17:00:00','2024-12-26 17:00:00'),(7,3,8,5,4,1500,300,1800,'checked-out',1,1,'','2024-09-05 03:34:54',NULL,NULL,NULL,'2024-10-14 17:00:00','2024-10-19 17:00:00'),(8,3,9,2,3,600,0,600,'checked-in',0,1,'We will be bringing our small dog with us','2024-11-07 03:34:54',NULL,NULL,NULL,'2024-11-06 17:00:00','2024-11-08 17:00:00'),(9,3,10,3,4,900,180,1080,'checked-out',1,1,'','2024-10-26 03:34:54',NULL,NULL,NULL,'2024-10-25 17:00:00','2024-10-28 17:00:00'),(10,4,11,12,4,5400,720,6120,'checked-in',1,1,'','2024-10-10 03:34:54',NULL,NULL,NULL,'2024-11-04 17:00:00','2024-11-16 17:00:00'),(11,4,12,5,4,2250,300,2550,'unconfirmed',1,0,'','2024-11-08 03:34:54',NULL,NULL,NULL,'2024-11-20 17:00:00','2024-11-25 17:00:00'),(12,4,13,1,1,450,0,450,'unconfirmed',0,1,'','2024-11-06 03:34:54',NULL,NULL,NULL,'2024-11-26 17:00:00','2024-11-27 17:00:00'),(13,5,14,7,5,2450,525,2975,'unconfirmed',1,0,'','2024-11-09 03:34:54',NULL,NULL,NULL,'2024-11-22 17:00:00','2024-11-29 17:00:00'),(14,5,15,2,4,700,120,820,'checked-out',1,1,'','2024-11-03 03:34:54',NULL,NULL,NULL,'2024-11-02 17:00:00','2024-11-04 17:00:00'),(15,5,16,3,6,1050,0,1050,'checked-out',0,1,'','2024-11-05 03:34:54',NULL,NULL,NULL,'2024-11-04 17:00:00','2024-11-07 17:00:00'),(16,6,17,11,6,7700,0,7700,'unconfirmed',0,1,'We will be checking in late, around midnight. Hope that\'s okay :)','2024-11-06 03:34:54',NULL,NULL,NULL,'2024-11-08 17:00:00','2024-11-19 17:00:00'),(17,6,18,7,4,4900,420,5320,'checked-out',1,1,'I will need a rollaway bed for one of the guests','2024-10-24 03:34:54',NULL,NULL,NULL,'2024-10-23 17:00:00','2024-10-30 17:00:00'),(18,6,19,3,6,2100,270,2370,'checked-out',1,1,'','2024-10-22 03:34:54',NULL,NULL,NULL,'2024-11-04 17:00:00','2024-11-07 17:00:00'),(19,7,20,6,8,3000,0,3000,'unconfirmed',0,0,'','2024-11-07 03:34:54',NULL,NULL,NULL,'2024-11-25 17:00:00','2024-12-01 17:00:00'),(20,7,21,10,7,5000,1050,6050,'unconfirmed',1,1,'','2024-11-02 03:34:54',NULL,NULL,NULL,'2024-12-18 17:00:00','2024-12-28 17:00:00'),(21,7,22,5,6,2500,450,2950,'unconfirmed',1,1,'','2024-09-15 03:34:54',NULL,NULL,NULL,'2024-12-10 17:00:00','2024-12-15 17:00:00'),(22,8,1,5,9,7000,675,7675,'checked-in',1,1,'My wife has a gluten allergy so I would like to request a gluten-free breakfast if possible','2024-11-01 03:34:54',NULL,NULL,NULL,'2024-11-03 17:00:00','2024-11-08 17:00:00'),(23,8,23,5,10,7000,750,7750,'unconfirmed',1,1,'I am celebrating my anniversary, can you arrange for any special amenities or decorations?','2024-11-09 03:34:54',NULL,NULL,NULL,'2024-11-08 17:00:00','2024-11-13 17:00:00'),(24,8,24,3,7,4200,0,4200,'unconfirmed',0,1,'','2024-10-30 03:34:54',NULL,NULL,NULL,'2024-11-18 17:00:00','2024-11-21 17:00:00');
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-13  8:31:50
