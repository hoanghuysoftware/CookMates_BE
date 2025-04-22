-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: recipe_sharing_dev
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'2025-03-30 14:29:22.934711','2025-03-30 14:29:22.934711','Món canh'),(2,'2025-03-30 14:29:32.923763','2025-03-30 14:29:32.923763','Món xào'),(3,'2025-03-30 14:29:35.990134','2025-03-30 14:29:35.990134','Món kho'),(4,'2025-03-30 14:29:39.599020','2025-03-30 14:29:39.599020','Món nướng'),(5,'2025-03-30 14:29:45.266229','2025-03-30 14:29:45.266229','Món hấp'),(6,'2025-03-30 14:30:08.855920','2025-03-30 14:30:08.855920','Lẩu'),(7,'2025-03-30 14:30:20.433186','2025-03-30 14:30:20.433186','Gỏi'),(8,'2025-03-30 14:30:26.543933','2025-03-30 14:30:26.543933','Món chiên');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (1,'Muối'),(2,'Đường'),(3,'Tiêu'),(4,'Bột ngọt'),(5,'Hành'),(6,'tỏi'),(7,'gừng'),(8,'sả'),(9,'ớt'),(10,'Nước mắm'),(11,'xì dầu'),(12,'giấm'),(13,'dầu hào'),(14,'Ngũ vị hương'),(15,'bột cà ri'),(16,'bột nghệ'),(17,'bột ớt'),(18,'Lá chanh'),(19,'lá nguyệt quế'),(20,'lá húng quế'),(21,'rau răm'),(22,'thì là'),(23,'hành lá'),(24,'ngò gai'),(25,'ngò rí'),(26,'Thịt bò'),(27,'Thịt heo'),(28,'Thịt gà'),(29,'thịt vịt'),(30,'cá hồi'),(31,'cá basa'),(32,'cá thu'),(33,'cá ngừ'),(34,'tôm'),(35,'mực'),(36,'bạch tuộc'),(37,'nghêu'),(38,'sò'),(39,'ốc'),(40,'hến'),(41,'thịt cừu'),(42,'thịt dê'),(43,'thịt thỏ'),(44,'thịt ngỗng'),(45,'cà rốt'),(46,'khoai tây'),(47,'khoai lang'),(48,'khoai môn'),(49,'su hào'),(50,'súp lơ'),(51,'bắp cải'),(52,'rau muống'),(53,'rau dền'),(54,'cà chua'),(55,'dưa leo'),(56,'ớt chuông'),(57,'bí đỏ'),(58,'bí xanh'),(59,'nấm hương'),(60,'nấm rơm'),(61,'nấm kim châm'),(62,'nấm bào ngư'),(63,'đậu xanh'),(64,'đậu đen'),(65,'đậu đỏ'),(66,'đậu nành'),(67,'hạt điều'),(68,'hạnh nhân'),(69,'hạt óc chó'),(70,'hạt dẻ'),(71,'đậu phộng'),(72,'hạt chia'),(73,'hạt lanh'),(74,'gạo'),(75,'nếp'),(76,'yến mạch'),(77,'lúa mì'),(78,'lúa mạch'),(79,'bột mỳ'),(80,'bột năng'),(81,'bột gạo'),(82,'bột bắp'),(83,'bánh mì'),(84,'phở'),(85,'bún'),(86,'mì sợi'),(87,'trứng gà'),(88,'trứng vịt'),(89,'trứng cút'),(90,'sữa tươi'),(91,'sữa đặc'),(92,'sữa chua'),(93,'phô mai'),(94,'bơ'),(95,'kem tươi'),(96,'sữa hạnh nhân'),(97,'dầu thực vật'),(98,'mỡ động vật');
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-30 19:09:32
