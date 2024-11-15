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
-- Table structure for table `cabin`
--

DROP TABLE IF EXISTS `cabin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cabin` (
  `cabin_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `maxCapacity` int DEFAULT NULL,
  `regularPrice` int DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cabin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabin`
--

LOCK TABLES `cabin` WRITE;
/*!40000 ALTER TABLE `cabin` DISABLE KEYS */;
INSERT INTO `cabin` VALUES (1,'001',2,250,0,'http://localhost:31821/Img/cabin-001.jpg','Discover the ultimate luxury getaway for couples in the cozy wooden cabin 001. Nestled in a picturesque forest, this stunning cabin offers a secluded and intimate retreat. Inside, enjoy modern high-quality wood interiors, a comfortable seating area, a fireplace and a fully-equipped kitchen. The plush king-size bed, dressed in fine linens guarantees a peaceful nights sleep. Relax in the spa-like shower and unwind on the private deck with hot tub.','2024-10-09 04:07:46',NULL,NULL,NULL),(2,'002',2,350,20,'http://localhost:31821/Img/cabin-002.jpg','Escape to the serenity of nature and indulge in luxury in our cozy cabin 002. Perfect for couples, this cabin offers a secluded and intimate retreat in the heart of a picturesque forest. Inside, you will find warm and inviting interiors crafted from high-quality wood, a comfortable living area, a fireplace and a fully-equipped kitchen. The luxurious bedroom features a plush king-size bed and spa-like shower. Relax on the private deck with hot tub and take in the beauty of nature.','2024-10-09 04:07:46',NULL,NULL,NULL),(3,'003',4,300,0,'http://localhost:31821/Img/cabin-003.jpg','Experience luxury family living in our medium-sized wooden cabin 003. Perfect for families of up to 4 people, this cabin offers a comfortable and inviting space with all modern amenities. Inside, you will find warm and inviting interiors crafted from high-quality wood, a comfortable living area, a fireplace, and a fully-equipped kitchen. The bedrooms feature plush beds and spa-like bathrooms. The cabin has a private deck with a hot tub and outdoor seating area, perfect for taking in the natural surroundings.','2024-10-09 04:07:46',NULL,NULL,NULL),(4,'004',4,500,50,'http://localhost:31821/Img/cabin-004.jpg','Indulge in the ultimate luxury family vacation in this medium-sized cabin 004. Designed for families of up to 4, this cabin offers a sumptuous retreat for the discerning traveler. Inside, the cabin boasts of opulent interiors crafted from the finest quality wood, a comfortable living area, a fireplace, and a fully-equipped gourmet kitchen. The bedrooms are adorned with plush beds and spa-inspired en-suite bathrooms. Step outside to your private deck and soak in the natural surroundings while relaxing in your own hot tub.','2024-10-09 04:07:46',NULL,NULL,NULL),(5,'005',6,350,0,'http://localhost:31821/Img/cabin-005.jpg','Enjoy a comfortable and cozy getaway with your group or family in our spacious cabin 005. Designed to accommodate up to 6 people, this cabin offers a secluded retreat in the heart of nature. Inside, the cabin features warm and inviting interiors crafted from quality wood, a living area with fireplace, and a fully-equipped kitchen. The bedrooms are comfortable and equipped with en-suite bathrooms. Step outside to your private deck and take in the natural surroundings while relaxing in your own hot tub.','2024-10-09 04:07:46',NULL,NULL,NULL),(6,'006',6,800,100,'http://localhost:31821/Img/cabin-006.jpg','Experience the epitome of luxury with your group or family in our spacious wooden cabin 006. Designed to comfortably accommodate up to 6 people, this cabin offers a lavish retreat in the heart of nature. Inside, the cabin features opulent interiors crafted from premium wood, a grand living area with fireplace, and a fully-equipped gourmet kitchen. The bedrooms are adorned with plush beds and spa-like en-suite bathrooms. Step outside to your private deck and soak in the natural surroundings while relaxing in your own hot tub.','2024-10-09 04:07:46',NULL,NULL,NULL),(7,'007',8,600,100,'http://localhost:31821/Img/cabin-007.jpg','Accommodate your large group or multiple families in the spacious and grand wooden cabin 007. Designed to comfortably fit up to 8 people, this cabin offers a secluded retreat in the heart of beautiful forests and mountains. Inside, the cabin features warm and inviting interiors crafted from quality wood, multiple living areas with fireplace, and a fully-equipped kitchen. The bedrooms are comfortable and equipped with en-suite bathrooms. The cabin has a private deck with a hot tub and outdoor seating area, perfect for taking in the natural surroundings.','2024-10-09 04:07:46',NULL,NULL,NULL),(8,'008',10,1400,0,'http://localhost:31821/Img/cabin-008.jpg','Experience the epitome of luxury and grandeur','2024-10-09 04:07:46',NULL,NULL,NULL);
/*!40000 ALTER TABLE `cabin` ENABLE KEYS */;
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
