-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bma
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `church_member` int(11) DEFAULT NULL,
  `attended` tinyint(2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attendance_member_id_idx` (`church_member`),
  CONSTRAINT `attendance_member_id` FOREIGN KEY (`church_member`) REFERENCES `church_member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2945 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `attendance_evaluation`
--

DROP TABLE IF EXISTS `attendance_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance_evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attended1` int(11) DEFAULT NULL,
  `attended2` int(11) DEFAULT NULL,
  `attended3` int(11) DEFAULT NULL,
  `attended4` int(11) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  `church_member` int(11) DEFAULT NULL,
  `attendance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attendance_evaluation_member_id_idx` (`church_member`),
  CONSTRAINT `attendance_evaluation_member_id` FOREIGN KEY (`church_member`) REFERENCES `church_member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=369 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `calling`
--

DROP TABLE IF EXISTS `calling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calling` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `church_member`
--

DROP TABLE IF EXISTS `church_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `church_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `fullname` varchar(95) DEFAULT NULL,
  `calling` int(11) DEFAULT NULL,
  `organization` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `calling_idx` (`calling`),
  KEY `member_organization_id_idx` (`organization`),
  CONSTRAINT `member_calling_id` FOREIGN KEY (`calling`) REFERENCES `calling` (`id`),
  CONSTRAINT `member_organization_id` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=372 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `discourse`
--

DROP TABLE IF EXISTS `discourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `church_member` int(11) DEFAULT NULL,
  `topic` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `assigned_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `topic_idx` (`topic`),
  KEY `discourse_member_id_idx` (`church_member`),
  KEY `discourse_assigned_by_id_idx` (`assigned_by`),
  CONSTRAINT `discourse_assigned_by_id` FOREIGN KEY (`assigned_by`) REFERENCES `church_member` (`id`),
  CONSTRAINT `discourse_member_id` FOREIGN KEY (`church_member`) REFERENCES `church_member` (`id`),
  CONSTRAINT `discourse_topic` FOREIGN KEY (`topic`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hymn`
--

DROP TABLE IF EXISTS `hymn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hymn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `piano_number` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `topic` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `topic_idx` (`topic`),
  CONSTRAINT `hymn_topic_id` FOREIGN KEY (`topic`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=343 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `prayer`
--

DROP TABLE IF EXISTS `prayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prayer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `church_member` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `prayer_member_id_idx` (`church_member`),
  CONSTRAINT `prayer_member_id` FOREIGN KEY (`church_member`) REFERENCES `church_member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sacrament_meeting`
--

DROP TABLE IF EXISTS `sacrament_meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sacrament_meeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `announcements` varchar(105) DEFAULT NULL,
  `preside` int(11) DEFAULT NULL,
  `lead` int(11) DEFAULT NULL,
  `assistance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sacrament_meeting_preside_id_idx` (`preside`),
  KEY `sacrament_meeting_lead_id_idx` (`lead`),
  CONSTRAINT `sacrament_meeting_lead_id` FOREIGN KEY (`lead`) REFERENCES `church_member` (`id`),
  CONSTRAINT `sacrament_meeting_preside_id` FOREIGN KEY (`preside`) REFERENCES `church_member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sacrament_meeting_hymn`
--

DROP TABLE IF EXISTS `sacrament_meeting_hymn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sacrament_meeting_hymn` (
  `sacrament_meeting_id` int(11) NOT NULL,
  `hymn_id` int(11) NOT NULL,
  PRIMARY KEY (`sacrament_meeting_id`,`hymn_id`),
  KEY `sacrament_meeting_hymn_id_idx` (`hymn_id`),
  CONSTRAINT `sacrament_meeting_hymn_id` FOREIGN KEY (`hymn_id`) REFERENCES `hymn` (`id`),
  CONSTRAINT `sacrament_meeting_id` FOREIGN KEY (`sacrament_meeting_id`) REFERENCES `sacrament_meeting` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sustaining_release`
--

DROP TABLE IF EXISTS `sustaining_release`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sustaining_release` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member` int(11) DEFAULT NULL,
  `calling` int(11) DEFAULT NULL,
  `init_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sustaining_release_calling_id_idx` (`calling`),
  KEY `sustaining_release_member_id_idx` (`member`),
  CONSTRAINT `sustaining_release_calling_id` FOREIGN KEY (`calling`) REFERENCES `calling` (`id`),
  CONSTRAINT `sustaining_release_member_id` FOREIGN KEY (`member`) REFERENCES `church_member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-22 22:55:55
