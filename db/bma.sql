CREATE DATABASE  IF NOT EXISTS `bma` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bma`;
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
  `member` int(11) DEFAULT NULL,
  `attended` tinyint(2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attendance_member_id_idx` (`member`),
  CONSTRAINT `attendance_member_id` FOREIGN KEY (`member`) REFERENCES `church_member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

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
  `member` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attendance_evaluation_member_id_idx` (`member`),
  CONSTRAINT `attendance_evaluation_member_id` FOREIGN KEY (`member`) REFERENCES `church_member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance_evaluation`
--

LOCK TABLES `attendance_evaluation` WRITE;
/*!40000 ALTER TABLE `attendance_evaluation` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calling`
--

LOCK TABLES `calling` WRITE;
/*!40000 ALTER TABLE `calling` DISABLE KEYS */;
/*!40000 ALTER TABLE `calling` ENABLE KEYS */;
UNLOCK TABLES;

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
  `organization` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `calling_idx` (`calling`),
  CONSTRAINT `member_calling_id` FOREIGN KEY (`calling`) REFERENCES `calling` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=371 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `church_member`
--

LOCK TABLES `church_member` WRITE;
/*!40000 ALTER TABLE `church_member` DISABLE KEYS */;
INSERT INTO `church_member` VALUES (3,'Elsa Beatriz','Agresta Santurion','Agresta Santurion, Elsa Beatriz',NULL,NULL),(4,'Felipe Manuel','Agresta Santurión','Agresta Santurión, Felipe Manuel',NULL,NULL),(5,'Lorenzo Julian','Agresta Santurion','Agresta Santurion, Lorenzo Julian',NULL,NULL),(6,'Lourdes Francesca','Agresta Santuriòn','Agresta Santuriòn, Lourdes Francesca',NULL,NULL),(7,'Elbio Ricardo','Agresta Sosa','Agresta Sosa, Elbio Ricardo',NULL,NULL),(8,'Ana Cecilia','Aguilar','Aguilar, Ana Cecilia',NULL,NULL),(9,'Jose Edgar','Altamirano Lopez','Altamirano Lopez, Jose Edgar',NULL,NULL),(10,'Laura Noelia','Altamirano Lopez','Altamirano Lopez, Laura Noelia',NULL,NULL),(11,'Leandro Baltazar','Alvez López','Alvez López, Leandro Baltazar',NULL,NULL),(12,'Elida Sonia','Alvez Silvera','Alvez Silvera, Elida Sonia',NULL,NULL),(13,'Natalia Vanesa','Amor Garcia','Amor Garcia, Natalia Vanesa',NULL,NULL),(14,'Soñia Yolanda','Apolo','Apolo, Soñia Yolanda',NULL,NULL),(15,'Blanca','Apolo Banega','Apolo Banega, Blanca',NULL,NULL),(16,'Carlos Eugenio','Arce','Arce, Carlos Eugenio',NULL,NULL),(17,'Luis Antonio','Barcelo Rodriguez','Barcelo Rodriguez, Luis Antonio',NULL,NULL),(18,'Maria Victoria','Barcelos Gonzalez','Barcelos Gonzalez, Maria Victoria',NULL,NULL),(19,'Yolanda Beatriz','Beron','Beron, Yolanda Beatriz',NULL,NULL),(20,'Juan Ramon','Beron Giulfo','Beron Giulfo, Juan Ramon',NULL,NULL),(21,'Antonella','Beron Ubarne','Beron Ubarne, Antonella',NULL,NULL),(22,'Giuliana','Beron Ubarne','Beron Ubarne, Giuliana',NULL,NULL),(23,'Maximiliano Gaston','Bica Castro','Bica Castro, Maximiliano Gaston',NULL,NULL),(24,'Rosa Elena','Blanco','Blanco, Rosa Elena',NULL,NULL),(25,'Ruben Rafael','Blanco','Blanco, Ruben Rafael',NULL,NULL),(26,'Carlos Humberto','Bobadilla Cardozo','Bobadilla Cardozo, Carlos Humberto',NULL,NULL),(27,'Carlos Xavier','Bobadilla Latorre','Bobadilla Latorre, Carlos Xavier',NULL,NULL),(28,'Liliana Arabel','Bolf Cabrera','Bolf Cabrera, Liliana Arabel',NULL,NULL),(29,'Maria Teresa','Bonaldi','Bonaldi, Maria Teresa',NULL,NULL),(30,'Maria Araceli','Borges Silva','Borges Silva, Maria Araceli',NULL,NULL),(31,'GARCIA VELAZCO','BRIAN ALEXIS','BRIAN ALEXIS, GARCIA VELAZCO',NULL,NULL),(32,'Sonia','Britos','Britos, Sonia',NULL,NULL),(33,'Lidia Gregoria','Burgeño Nuñez','Burgeño Nuñez, Lidia Gregoria',NULL,NULL),(34,'Gabriel Marcelo','Burgueño','Burgueño, Gabriel Marcelo',NULL,NULL),(35,'Luis Alberto','Burgueño','Burgueño, Luis Alberto',NULL,NULL),(36,'Stefano Ezequiel','Buzzo Machado','Buzzo Machado, Stefano Ezequiel',NULL,NULL),(37,'Alicia','Cabrera','Cabrera, Alicia',NULL,NULL),(38,'Guillermo','*Cabrera Braga','*Cabrera Braga, Guillermo',NULL,NULL),(39,'Ignacio','*Cabrera Braga','*Cabrera Braga, Ignacio',NULL,NULL),(40,'Victor Alberto','Cabrera Liscano','Cabrera Liscano, Victor Alberto',NULL,NULL),(41,'MELANY','CABRERA MOREIRA','CABRERA MOREIRA, MELANY',NULL,NULL),(42,'ROMINA','CABRERA MOREIRA','CABRERA MOREIRA, ROMINA',NULL,NULL),(43,'Mirta Graciela','Calcagno','Calcagno, Mirta Graciela',NULL,NULL),(44,'Gabriel','Calero Gutierrez','Calero Gutierrez, Gabriel',NULL,NULL),(45,'Juan Pablo','Camuso Camuso','Camuso Camuso, Juan Pablo',NULL,NULL),(46,'Cristofer Jonathan','Canepa Diaz','Canepa Diaz, Cristofer Jonathan',NULL,NULL),(47,'Ruben Alexander','Canepa Diaz','Canepa Diaz, Ruben Alexander',NULL,NULL),(48,'Fernando Daniel','Cardozo Braga','Cardozo Braga, Fernando Daniel',NULL,NULL),(49,'Oscar Alberto','Cardozo Durante','Cardozo Durante, Oscar Alberto',NULL,NULL),(50,'Virginia Lorena','Cardozo Rodriguez','Cardozo Rodriguez, Virginia Lorena',NULL,NULL),(51,'Rodrigo','Cardozo Silva','Cardozo Silva, Rodrigo',NULL,NULL),(52,'Analia Joseline','Cardozo Socias','Cardozo Socias, Analia Joseline',NULL,NULL),(53,'Bruno','Caruso','Caruso, Bruno',NULL,NULL),(54,'Maria Ema Nario de','Casas','Casas, Maria Ema Nario de',NULL,NULL),(55,'Ricardo Domingo','Casas Amante','Casas Amante, Ricardo Domingo',NULL,NULL),(56,'Catherine Elizabeth','Casas Nario','Casas Nario, Catherine Elizabeth',NULL,NULL),(57,'Adriana Lorena','Castro','Castro, Adriana Lorena',NULL,NULL),(58,'Ricardo Manuel','Castro','Castro, Ricardo Manuel',NULL,NULL),(59,'Pamela Tathiana','Castro Diaz','Castro Diaz, Pamela Tathiana',NULL,NULL),(60,'Maria del Carmen','Cedrez Molina','Cedrez Molina, Maria del Carmen',NULL,NULL),(61,'Gerardo Juan','Cetrulo','Cetrulo, Gerardo Juan',NULL,NULL),(62,'Rumilda Isabel','Corbo','Corbo, Rumilda Isabel',NULL,NULL),(63,'Francesca','Corral Cetrulo','Corral Cetrulo, Francesca',NULL,NULL),(64,'Gabriela Yudith','Correa Rocha','Correa Rocha, Gabriela Yudith',NULL,NULL),(65,'Florencia','Cuña Silvera','Cuña Silvera, Florencia',NULL,NULL),(66,'Micaela','Cuña Silvera','Cuña Silvera, Micaela',NULL,NULL),(67,'Samira','Cuña Silvera','Cuña Silvera, Samira',NULL,NULL),(68,'Claudia Yanet','Da Rosa Cuadro','Da Rosa Cuadro, Claudia Yanet',NULL,NULL),(69,'Jose Ignacio','Da Silva Corbo','Da Silva Corbo, Jose Ignacio',NULL,NULL),(70,'Yessica','Da Silva Duarte','Da Silva Duarte, Yessica',NULL,NULL),(71,'Alvaro Jorge','de Armas Etchegiomberry','de Armas Etchegiomberry, Alvaro Jorge',NULL,NULL),(72,'Gabriel Nicolas','Delfino','Delfino, Gabriel Nicolas',NULL,NULL),(73,'Claudia Elizabeth','De Lima','De Lima, Claudia Elizabeth',NULL,NULL),(74,'Lucy Loreley','De Los Santos','De Los Santos, Lucy Loreley',NULL,NULL),(75,'Iracema','del Pino Simoez','del Pino Simoez, Iracema',NULL,NULL),(76,'Alba Celestina','Del Rivero','Del Rivero, Alba Celestina',NULL,NULL),(77,'Griselda Miriam','Demello Direni','Demello Direni, Griselda Miriam',NULL,NULL),(78,'Rodney Arturo','Desiderio Teixeira','Desiderio Teixeira, Rodney Arturo',NULL,NULL),(79,'Antonio Damian','Diaz Ferreyra','Diaz Ferreyra, Antonio Damian',NULL,NULL),(80,'Karla Paola','Dorado Baéz','Dorado Baéz, Karla Paola',NULL,NULL),(81,'Alejandra Veronica','Dourrom','Dourrom, Alejandra Veronica',NULL,NULL),(82,'Cesar Alejandro','Dourrom','Dourrom, Cesar Alejandro',NULL,NULL),(83,'Sandra Monica','Dourrom','Dourrom, Sandra Monica',NULL,NULL),(84,'Monica','Duarte','Duarte, Monica',NULL,NULL),(85,'Antonio Braulio','Dutra Nieto','Dutra Nieto, Antonio Braulio',NULL,NULL),(86,'Piriz Cardozo','Emiliano','Emiliano, Piriz Cardozo',NULL,NULL),(87,'Rossana','Espinoza Subedra','Espinoza Subedra, Rossana',NULL,NULL),(88,'German','Falconi','Falconi, German',NULL,NULL),(89,'Kevin','Falconi','Falconi, Kevin',NULL,NULL),(90,'Micaela Victoria','Falero Rodriguez','Falero Rodriguez, Micaela Victoria',NULL,NULL),(91,'Daniel Ademar','Fernandez','Fernandez, Daniel Ademar',NULL,NULL),(92,'Joaquin Javier','*Fernandez Gonzalez','*Fernandez Gonzalez, Joaquin Javier',NULL,NULL),(93,'Mary Raquel','Fernandez Torena','Fernandez Torena, Mary Raquel',NULL,NULL),(94,'Maria Cristina','Ferrari Canepa','Ferrari Canepa, Maria Cristina',NULL,NULL),(95,'Maria Giovana','Ferraz Araujo','Ferraz Araujo, Maria Giovana',NULL,NULL),(96,'Roxana','Ferreira','Ferreira, Roxana',NULL,NULL),(97,'Maria Lourdez','Ferreira Oviedo','Ferreira Oviedo, Maria Lourdez',NULL,NULL),(98,'Mariella Lilian','Ferreyra','Ferreyra, Mariella Lilian',NULL,NULL),(99,'Sebastian','Figueredo Termezano','Figueredo Termezano, Sebastian',NULL,NULL),(100,'Fabrizzia','Flores Espinoza','Flores Espinoza, Fabrizzia',NULL,NULL),(101,'Francisco Mateo','Francisco Mateo','Francisco Mateo, Francisco Mateo',NULL,NULL),(102,'Rumalda Beatriz','Freire','Freire, Rumalda Beatriz',NULL,NULL),(103,'Leonardo Javier','Frontora','Frontora, Leonardo Javier',NULL,NULL),(104,'Mariana Mercedes','Frontora','Frontora, Mariana Mercedes',NULL,NULL),(105,'Roque Agustin','Fuentes','Fuentes, Roque Agustin',NULL,NULL),(106,'Beatriz','Gaitan Gamarra','Gaitan Gamarra, Beatriz',NULL,NULL),(107,'Cecilia Mariana','Galo De Los Santos','Galo De Los Santos, Cecilia Mariana',NULL,NULL),(108,'Hector Santiago','*Galo de los Santos','*Galo de los Santos, Hector Santiago',NULL,NULL),(109,'Felix Martin','Garay','Garay, Felix Martin',NULL,NULL),(110,'Martin','Garay','Garay, Martin',NULL,NULL),(111,'Natalia Mariana','Garay','Garay, Natalia Mariana',NULL,NULL),(112,'Rocio Erlinda','Garay','Garay, Rocio Erlinda',NULL,NULL),(113,'Alicia Carmen','Garcia','Garcia, Alicia Carmen',NULL,NULL),(114,'Daniel Gregorio','Garcia Aguilar','Garcia Aguilar, Daniel Gregorio',NULL,NULL),(115,'María José','Garrido Britos','Garrido Britos, María José',NULL,NULL),(116,'Maria del Rosario','Gatti','Gatti, Maria del Rosario',NULL,NULL),(117,'Alcibiades','Gavilan','Gavilan, Alcibiades',NULL,NULL),(118,'Sonia Patricia','Gavilan','Gavilan, Sonia Patricia',NULL,NULL),(119,'Jostin Aaron','Gavilan Leiro','Gavilan Leiro, Jostin Aaron',NULL,NULL),(120,'Sharon Nathael','Gavilan Leiro','Gavilan Leiro, Sharon Nathael',NULL,NULL),(121,'Lucila Vianneys','Ghigliazza Bueno','Ghigliazza Bueno, Lucila Vianneys',NULL,NULL),(122,'Ana Maria','Gimenez Arismendi','Gimenez Arismendi, Ana Maria',NULL,NULL),(123,'Jorge Maria','Gimenez Techera','Gimenez Techera, Jorge Maria',NULL,NULL),(124,'Luz Valeria','Giordano Nuñez','Giordano Nuñez, Luz Valeria',NULL,NULL),(125,'Ivan Mateo','Gomez Monrroy','Gomez Monrroy, Ivan Mateo',NULL,NULL),(126,'Renatta Isabella','Gomez Suarez','Gomez Suarez, Renatta Isabella',NULL,NULL),(127,'Jose Edgar','Gonzalez','Gonzalez, Jose Edgar',NULL,NULL),(128,'Mirian Lurdes','Gonzalez','Gonzalez, Mirian Lurdes',NULL,NULL),(129,'Ricardo Valentin','Gonzalez','Gonzalez, Ricardo Valentin',NULL,NULL),(130,'Silvia Mariela','Gonzalez','Gonzalez, Silvia Mariela',NULL,NULL),(131,'Pablo Martin','Gonzalez Accossano','Gonzalez Accossano, Pablo Martin',NULL,NULL),(132,'Rosario Anabella','Gonzalez Carnales Becerra','Gonzalez Carnales Becerra, Rosario Anabella',NULL,NULL),(133,'Maria Noelia','Gonzalez Chirimine','Gonzalez Chirimine, Maria Noelia',NULL,NULL),(134,'Andrea Gabriela','Gonzalez Fernandez','Gonzalez Fernandez, Andrea Gabriela',NULL,NULL),(135,'Sergio Elbio','Gonzalez Hidalgo','Gonzalez Hidalgo, Sergio Elbio',NULL,NULL),(136,'Carlos Fabian','Gonzalez Morais','Gonzalez Morais, Carlos Fabian',NULL,NULL),(137,'Esteban Raul','Gonzalez Palomeque','Gonzalez Palomeque, Esteban Raul',NULL,NULL),(138,'Laura Viviana','Gonzalez Perez Casari','Gonzalez Perez Casari, Laura Viviana',NULL,NULL),(139,'Joel','Gonzalez Pierrotti','Gonzalez Pierrotti, Joel',NULL,NULL),(140,'Jose Avelino','Gonzalez Sosa','Gonzalez Sosa, Jose Avelino',NULL,NULL),(141,'Francisco Leonel','Gutierrez Porraz','Gutierrez Porraz, Francisco Leonel',NULL,NULL),(142,'Ayelen Silvina','Hernandez Freitas','Hernandez Freitas, Ayelen Silvina',NULL,NULL),(143,'William Eduardo','Ibarra Galeano','Ibarra Galeano, William Eduardo',NULL,NULL),(144,'Alicia','Iparaguerre Santos','Iparaguerre Santos, Alicia',NULL,NULL),(145,'Carmen Catalina','Jaurena Ramirez','Jaurena Ramirez, Carmen Catalina',NULL,NULL),(146,'Gustavo Americo','Jaurena Ramirez','Jaurena Ramirez, Gustavo Americo',NULL,NULL),(147,'Sergio','Juani','Juani, Sergio',NULL,NULL),(148,'Helen Danaer','Kastaing Beroqui','Kastaing Beroqui, Helen Danaer',NULL,NULL),(149,'Mario','Labriola','Labriola, Mario',NULL,NULL),(150,'Jose Luis','Labriola Peñalva','Labriola Peñalva, Jose Luis',NULL,NULL),(151,'Victoria Dominique','Laluz Murugosa','Laluz Murugosa, Victoria Dominique',NULL,NULL),(152,'Leonardo Carlos','Laluz Varona','Laluz Varona, Leonardo Carlos',NULL,NULL),(153,'Gustavo Juan','Lapido Paita','Lapido Paita, Gustavo Juan',NULL,NULL),(154,'Mathias Fabian','Lapido Paita','Lapido Paita, Mathias Fabian',NULL,NULL),(155,'Maria Solange','Larrondo','Larrondo, Maria Solange',NULL,NULL),(156,'Martin','Laureano Olivera','Laureano Olivera, Martin',NULL,NULL),(157,'Olga Marta','Lecuona Vega','Lecuona Vega, Olga Marta',NULL,NULL),(158,'Deysi Raquel','Ledesma','Ledesma, Deysi Raquel',NULL,NULL),(159,'Adriana Karina','Leiro','Leiro, Adriana Karina',NULL,NULL),(160,'Jessica Fiorella','Leiro Grillo','Leiro Grillo, Jessica Fiorella',NULL,NULL),(161,'Daniel Armando','Leiro Lapaz','Leiro Lapaz, Daniel Armando',NULL,NULL),(162,'Cristina','Leites Duartes','Leites Duartes, Cristina',NULL,NULL),(163,'Alicia Paola','Lima Gonzalez','Lima Gonzalez, Alicia Paola',NULL,NULL),(164,'Fabiana Karina','Lopez Pereira','Lopez Pereira, Fabiana Karina',NULL,NULL),(165,'Sonia Alejandra','Luz','Luz, Sonia Alejandra',NULL,NULL),(166,'Joselyn Veronica','Machado','Machado, Joselyn Veronica',NULL,NULL),(167,'Marcelo Alejandro','Machado','Machado, Marcelo Alejandro',NULL,NULL),(168,'Sebastian Walter','Machado','Machado, Sebastian Walter',NULL,NULL),(169,'Wendy Rossana','Machado','Machado, Wendy Rossana',NULL,NULL),(170,'Ayelen','*Machado Martinez','*Machado Martinez, Ayelen',NULL,NULL),(171,'Jose Ignacio','Machado Martinez','Machado Martinez, Jose Ignacio',NULL,NULL),(172,'Lucas Benjamin','*Machado Martinez','*Machado Martinez, Lucas Benjamin',NULL,NULL),(173,'Karen Veronica','Machado Paz','Machado Paz, Karen Veronica',NULL,NULL),(174,'Tadeo Gabriel','Machado Zelayeta','Machado Zelayeta, Tadeo Gabriel',NULL,NULL),(175,'Alba Luz','Maciel','Maciel, Alba Luz',NULL,NULL),(176,'Maximo Feliz','Magnini Lopez','Magnini Lopez, Maximo Feliz',NULL,NULL),(177,'Lila Dinorah','*Magnone Dos Santos','*Magnone Dos Santos, Lila Dinorah',NULL,NULL),(178,'Blanca Delia','Malvagni','Malvagni, Blanca Delia',NULL,NULL),(179,'Gina','Malvagni Zapata','Malvagni Zapata, Gina',NULL,NULL),(180,'Ornella','Malvagni Zapata','Malvagni Zapata, Ornella',NULL,NULL),(181,'Sofia Paola','Malvagni Zapata','Malvagni Zapata, Sofia Paola',NULL,NULL),(182,'Stephanie Cecilia','Malvagni Zapata','Malvagni Zapata, Stephanie Cecilia',NULL,NULL),(183,'Olimpia Lujan','Marichal Zapata','Marichal Zapata, Olimpia Lujan',NULL,NULL),(184,'Gladis Amelia','Marquez','Marquez, Gladis Amelia',NULL,NULL),(185,'Gaston Omar','Marquez Beroqui','Marquez Beroqui, Gaston Omar',NULL,NULL),(186,'Jesus Nicolas','Marquez Beroqui','Marquez Beroqui, Jesus Nicolas',NULL,NULL),(187,'Romina Paula','Marquez Coitiño','Marquez Coitiño, Romina Paula',NULL,NULL),(188,'Jose Luis','Marquez Godoy','Marquez Godoy, Jose Luis',NULL,NULL),(189,'Francisca Rosario','Martinez','Martinez, Francisca Rosario',NULL,NULL),(190,'Nairena Ailen','Martinez Acosta','Martinez Acosta, Nairena Ailen',NULL,NULL),(191,'Mary Inocencia','Martinez Almeida','Martinez Almeida, Mary Inocencia',NULL,NULL),(192,'Analia Paola','Martinez Bidonda','Martinez Bidonda, Analia Paola',NULL,NULL),(193,'Karen Roxana','Martinez Cuadro','Martinez Cuadro, Karen Roxana',NULL,NULL),(194,'Gabriela Irene','Martinez Martinez','Martinez Martinez, Gabriela Irene',NULL,NULL),(195,'Sindia Daiana','Martinez Martinez','Martinez Martinez, Sindia Daiana',NULL,NULL),(196,'Maria Cristina','Martinez Telis','Martinez Telis, Maria Cristina',NULL,NULL),(197,'Olga Elena','Martinez Teliz','Martinez Teliz, Olga Elena',NULL,NULL),(198,'Wilson','Mederos Vidarte','Mederos Vidarte, Wilson',NULL,NULL),(199,'Rodrigo Nicolas','Mega Sosa','Mega Sosa, Rodrigo Nicolas',NULL,NULL),(200,'Stephanie','Mesa Rodriguez','Mesa Rodriguez, Stephanie',NULL,NULL),(201,'Angel Ahmulek','Molina Sutil','Molina Sutil, Angel Ahmulek',NULL,NULL),(202,'Giulliana Valentina','Molina Sutil','Molina Sutil, Giulliana Valentina',NULL,NULL),(203,'Gabina','Montero','Montero, Gabina',NULL,NULL),(204,'Patricia Leticia','Montero','Montero, Patricia Leticia',NULL,NULL),(205,'Maria Noel','Montero Coitinho','Montero Coitinho, Maria Noel',NULL,NULL),(206,'Silvia Glessy','Morales','Morales, Silvia Glessy',NULL,NULL),(207,'Corina Elena','Moran','Moran, Corina Elena',NULL,NULL),(208,'Laura','Moran Gonzalez','Moran Gonzalez, Laura',NULL,NULL),(209,'Darwin Adalberto','Moreno','Moreno, Darwin Adalberto',NULL,NULL),(210,'Andres Carlos','Moreno Dorado','Moreno Dorado, Andres Carlos',NULL,NULL),(211,'Lucas Ezequiel','Moreno Dorado','Moreno Dorado, Lucas Ezequiel',NULL,NULL),(212,'Mikaela','Moreno Dorado','Moreno Dorado, Mikaela',NULL,NULL),(213,'Rosa Beatriz','Moreno Nuñez','Moreno Nuñez, Rosa Beatriz',NULL,NULL),(214,'Ernesto Gonzalo','Mori Hernandez','Mori Hernandez, Ernesto Gonzalo',NULL,NULL),(215,'Alba Luz','Muniz Gorello','Muniz Gorello, Alba Luz',NULL,NULL),(216,'Antonella','Murugosa Panzacchi','Murugosa Panzacchi, Antonella',NULL,NULL),(217,'Gabriel Leonardo','Murugosa Panzacchi','Murugosa Panzacchi, Gabriel Leonardo',NULL,NULL),(218,'Máximo Lorenzo','Murugosa Panzacchi','Murugosa Panzacchi, Máximo Lorenzo',NULL,NULL),(219,'Camila Elizabeth','Murugosa Soto','Murugosa Soto, Camila Elizabeth',NULL,NULL),(220,'Cecilia Noemi','Murugosa Soto','Murugosa Soto, Cecilia Noemi',NULL,NULL),(221,'Daniel Eduardo','Nacher Fernandez','Nacher Fernandez, Daniel Eduardo',NULL,NULL),(222,'Daniel Andres','Nacher Pifano','Nacher Pifano, Daniel Andres',NULL,NULL),(223,'Dominga Esther','Nacher Pifano','Nacher Pifano, Dominga Esther',NULL,NULL),(224,'Agustina Belen','Nacher Ruiz','Nacher Ruiz, Agustina Belen',NULL,NULL),(225,'Mathías Benjamín','Nacher Ruiz','Nacher Ruiz, Mathías Benjamín',NULL,NULL),(226,'Flavia','Nacher Ruiz Silva','Nacher Ruiz Silva, Flavia',NULL,NULL),(227,'Shirley Ivonne','Nieto Carreras','Nieto Carreras, Shirley Ivonne',NULL,NULL),(228,'Bibiana','Nieves Pradiee','Nieves Pradiee, Bibiana',NULL,NULL),(229,'Juan','Noble Almeida','Noble Almeida, Juan',NULL,NULL),(230,'Maria Joaquina','Noble Echague Barrios','Noble Echague Barrios, Maria Joaquina',NULL,NULL),(231,'Maria del Carmen','Novo de los Santos','Novo de los Santos, Maria del Carmen',NULL,NULL),(232,'Dario Maximiliano','Nuñez Conde','Nuñez Conde, Dario Maximiliano',NULL,NULL),(233,'Fernanda Gabriela','Ocampo','Ocampo, Fernanda Gabriela',NULL,NULL),(234,'Maria Victoria','Ocampo','Ocampo, Maria Victoria',NULL,NULL),(235,'Marilia Julie','Ocampo','Ocampo, Marilia Julie',NULL,NULL),(236,'Hector','Ocampo Gonzalez','Ocampo Gonzalez, Hector',NULL,NULL),(237,'Silvia Rosa','Ogando','Ogando, Silvia Rosa',NULL,NULL),(238,'Andres Nicolas','Olivera Trinidad','Olivera Trinidad, Andres Nicolas',NULL,NULL),(239,'Carlos Andres','Oroño','Oroño, Carlos Andres',NULL,NULL),(240,'Elba Margot','Ortiz','Ortiz, Elba Margot',NULL,NULL),(241,'Felix Enrique','Ortiz','Ortiz, Felix Enrique',NULL,NULL),(242,'Pablo David','Ortiz','Ortiz, Pablo David',NULL,NULL),(243,'Agustin','Paolilla Viberti','Paolilla Viberti, Agustin',NULL,NULL),(244,'Isabel del Lourdes','Pastorino Correa','Pastorino Correa, Isabel del Lourdes',NULL,NULL),(245,'Mariano Wilson','Peña Reis','Peña Reis, Mariano Wilson',NULL,NULL),(246,'Gloria Rosemarie','Pereira','Pereira, Gloria Rosemarie',NULL,NULL),(247,'Javier Walberto','Pereira','Pereira, Javier Walberto',NULL,NULL),(248,'Sandra Raquel','Pereira Peña','Pereira Peña, Sandra Raquel',NULL,NULL),(249,'Monica del Lujan','Pereyra de Leon','Pereyra de Leon, Monica del Lujan',NULL,NULL),(250,'Neliz Esmer','Perez Perez','Perez Perez, Neliz Esmer',NULL,NULL),(251,'Marta Susana','Piastre Calzada','Piastre Calzada, Marta Susana',NULL,NULL),(252,'Anahir Lourdes','Pierrotti Rivas De Gonzalez','Pierrotti Rivas De Gonzalez, Anahir Lourdes',NULL,NULL),(253,'Estela','Pintado Pajares','Pintado Pajares, Estela',NULL,NULL),(254,'Patricia Malvina','Piovesan','Piovesan, Patricia Malvina',NULL,NULL),(255,'Eduardo Heraldo','Piovesan Fernandez','Piovesan Fernandez, Eduardo Heraldo',NULL,NULL),(256,'Pablo Nicolas','Piovesan Fernandez','Piovesan Fernandez, Pablo Nicolas',NULL,NULL),(257,'Marcos Vicente','Piovesan Rodriguez','Piovesan Rodriguez, Marcos Vicente',NULL,NULL),(258,'Rosa Magali','Pirez Marquez','Pirez Marquez, Rosa Magali',NULL,NULL),(259,'Patricia Monica','Piriz','Piriz, Patricia Monica',NULL,NULL),(260,'Emiliano','Piriz Cardoso','Piriz Cardoso, Emiliano',NULL,NULL),(261,'Rudy Omar','Piriz Diaz','Piriz Diaz, Rudy Omar',NULL,NULL),(262,'Mateo','Possamay Borba','Possamay Borba, Mateo',NULL,NULL),(263,'Carol Grey','Prattes Falcon','Prattes Falcon, Carol Grey',NULL,NULL),(264,'Gilberto','Pratt Percovich','Pratt Percovich, Gilberto',NULL,NULL),(265,'Juan Andres','Pratt Ramirez','Pratt Ramirez, Juan Andres',NULL,NULL),(266,'Nicolas Matías','Pratt Ramirez','Pratt Ramirez, Nicolas Matías',NULL,NULL),(267,'Mirta Noemi','Presa Romero','Presa Romero, Mirta Noemi',NULL,NULL),(268,'Carlos William','Quintero Gutierrez','Quintero Gutierrez, Carlos William',NULL,NULL),(269,'Violeta Natalia','Ramirez Villarrueta','Ramirez Villarrueta, Violeta Natalia',NULL,NULL),(270,'Jorge Diego','Ramirez Villaurrueta','Ramirez Villaurrueta, Jorge Diego',NULL,NULL),(271,'Carol Jacinta','Rey','Rey, Carol Jacinta',NULL,NULL),(272,'Jorge Gabriel','Rey','Rey, Jorge Gabriel',NULL,NULL),(273,'Clara Salma','Rios Beron','Rios Beron, Clara Salma',NULL,NULL),(274,'Nahuel Nicolas','Rivas Braga','Rivas Braga, Nahuel Nicolas',NULL,NULL),(275,'Franco Erik','Roberts Sosa','Roberts Sosa, Franco Erik',NULL,NULL),(276,'Judith Alejandra','Rodriguez','Rodriguez, Judith Alejandra',NULL,NULL),(277,'Marcelino Francisco','Rodriguez','Rodriguez, Marcelino Francisco',NULL,NULL),(278,'Maria Cristina','Rodriguez','Rodriguez, Maria Cristina',NULL,NULL),(279,'Rosa Veronica','Rodriguez','Rodriguez, Rosa Veronica',NULL,NULL),(280,'Sandra Graciela','Rodriguez','Rodriguez, Sandra Graciela',NULL,NULL),(281,'Dario','Rodriguez Gilberto','Rodriguez Gilberto, Dario',NULL,NULL),(282,'Lucia Belen','Rodriguez Gonzalez','Rodriguez Gonzalez, Lucia Belen',NULL,NULL),(283,'Rita','Rodriguez Laimo','Rodriguez Laimo, Rita',NULL,NULL),(284,'Esequiel','Rodriguez Rivas','Rodriguez Rivas, Esequiel',NULL,NULL),(285,'Diego Fernando','Rogel Gamboa','Rogel Gamboa, Diego Fernando',NULL,NULL),(286,'Agustin Maximiliano','Rogel Paita','Rogel Paita, Agustin Maximiliano',NULL,NULL),(287,'Maria Silvia','Rogel Paita','Rogel Paita, Maria Silvia',NULL,NULL),(288,'Sandra','Romero','Romero, Sandra',NULL,NULL),(289,'Eva Vicenta','Rosales Castroman','Rosales Castroman, Eva Vicenta',NULL,NULL),(290,'Nurimar Amita','Rossi Otero','Rossi Otero, Nurimar Amita',NULL,NULL),(291,'Vilma Noemi','Saldivia Presa','Saldivia Presa, Vilma Noemi',NULL,NULL),(292,'Valeria','Salvetti','Salvetti, Valeria',NULL,NULL),(293,'Thiago Francisco','Salvetti Moreira','Salvetti Moreira, Thiago Francisco',NULL,NULL),(294,'Marcel','Salvetti Sequeira','Salvetti Sequeira, Marcel',NULL,NULL),(295,'Daniel Ricardo','Santos','Santos, Daniel Ricardo',NULL,NULL),(296,'Natalia Florencia','*Santos','*Santos, Natalia Florencia',NULL,NULL),(297,'Pablo Nahuel','Santos Rodriguez','Santos Rodriguez, Pablo Nahuel',NULL,NULL),(298,'Daniel Eduardo','Sayanes','Sayanes, Daniel Eduardo',NULL,NULL),(299,'Matias Daniel','*Sayanes','*Sayanes, Matias Daniel',NULL,NULL),(300,'Sonia B.','Sayanes','Sayanes, Sonia B.',NULL,NULL),(301,'Haydee Carmen','Shmitt','Shmitt, Haydee Carmen',NULL,NULL),(302,'Cristhian Fernando','Silva Almeda','Silva Almeda, Cristhian Fernando',NULL,NULL),(303,'Elias Benjamin','Silva Ghigliazza','Silva Ghigliazza, Elias Benjamin',NULL,NULL),(304,'Federico Waldemar','Silva Ghigliazza','Silva Ghigliazza, Federico Waldemar',NULL,NULL),(305,'Simón Wilman','Silva Ghigliazza','Silva Ghigliazza, Simón Wilman',NULL,NULL),(306,'Aida Ines','Silva Perla','Silva Perla, Aida Ines',NULL,NULL),(307,'Yolanda','Silveira','Silveira, Yolanda',NULL,NULL),(308,'Alexis Emanuel','Silveira Ramirez','Silveira Ramirez, Alexis Emanuel',NULL,NULL),(309,'Angela Antonia','Silveira Ramirez','Silveira Ramirez, Angela Antonia',NULL,NULL),(310,'Valeria Lucia','Silveira Ramirez','Silveira Ramirez, Valeria Lucia',NULL,NULL),(311,'Laura','Silvera','Silvera, Laura',NULL,NULL),(312,'MARIA VIRGINIA','SILVERA BORBA','SILVERA BORBA, MARIA VIRGINIA',NULL,NULL),(313,'Martin Hiram','Silvera Moreira','Silvera Moreira, Martin Hiram',NULL,NULL),(314,'Alejandra Patricia','Silvia Perez','Silvia Perez, Alejandra Patricia',NULL,NULL),(315,'Valeria Paola','Simaldone','Simaldone, Valeria Paola',NULL,NULL),(316,'Javier Anthony','Solis Delgado','Solis Delgado, Javier Anthony',NULL,NULL),(317,'Yolanda Mireya','Sosa','Sosa, Yolanda Mireya',NULL,NULL),(318,'Gladys Raquel','Sosa Bastos','Sosa Bastos, Gladys Raquel',NULL,NULL),(319,'Alicia Marisol','Sosa Perez','Sosa Perez, Alicia Marisol',NULL,NULL),(320,'Gimena Aylin','Sosa Perez','Sosa Perez, Gimena Aylin',NULL,NULL),(321,'Maria Eriselba','Sosa Silveira','Sosa Silveira, Maria Eriselba',NULL,NULL),(322,'Adelio Abel','Soto Acosta','Soto Acosta, Adelio Abel',NULL,NULL),(323,'Eneo Santiago','Soto Acosta','Soto Acosta, Eneo Santiago',NULL,NULL),(324,'Beatriz Elena','Soto Gonzalez','Soto Gonzalez, Beatriz Elena',NULL,NULL),(325,'Stiven Abel','Soto Gonzalez','Soto Gonzalez, Stiven Abel',NULL,NULL),(326,'Ezequiel Abel','Soto Guerrero','Soto Guerrero, Ezequiel Abel',NULL,NULL),(327,'Maria del Lujan','Soto Sanchez Lotito','Soto Sanchez Lotito, Maria del Lujan',NULL,NULL),(328,'Fernando','Suarez','Suarez, Fernando',NULL,NULL),(329,'Hernan','Suarez Montero','Suarez Montero, Hernan',NULL,NULL),(330,'Gaston Alejandro','Suarez Sosa','Suarez Sosa, Gaston Alejandro',NULL,NULL),(331,'Grisell Romina','Suarez Sosa','Suarez Sosa, Grisell Romina',NULL,NULL),(332,'Jacqueline Valeria','Suarez Sosa','Suarez Sosa, Jacqueline Valeria',NULL,NULL),(333,'Leonardo Javier','Suarez Sosa','Suarez Sosa, Leonardo Javier',NULL,NULL),(334,'Nohelia Lucia','Suarez Sosa','Suarez Sosa, Nohelia Lucia',NULL,NULL),(335,'Jose Alejandro','Surra','Surra, Jose Alejandro',NULL,NULL),(336,'Mariella Virginia','Sutil Carabajal','Sutil Carabajal, Mariella Virginia',NULL,NULL),(337,'Norma Cristina','Tabarez Cadimar','Tabarez Cadimar, Norma Cristina',NULL,NULL),(338,'Brenda Mabel','Tabeira','Tabeira, Brenda Mabel',NULL,NULL),(339,'Sebastian Efrain','Terrazo Lucia','Terrazo Lucia, Sebastian Efrain',NULL,NULL),(340,'Valeria Antonella','Torres Pintado','Torres Pintado, Valeria Antonella',NULL,NULL),(341,'Analia','Torres Rodriguez','Torres Rodriguez, Analia',NULL,NULL),(342,'Soledad','*Torres Rodriguez','*Torres Rodriguez, Soledad',NULL,NULL),(343,'Wilfredo Dorival','Trindade Leon','Trindade Leon, Wilfredo Dorival',NULL,NULL),(344,'Alexia','Trindade Rodriguez','Trindade Rodriguez, Alexia',NULL,NULL),(345,'Juan Carlos','Trinidad','Trinidad, Juan Carlos',NULL,NULL),(346,'Jose Samuel Ronaldo','Trinidad Varela','Trinidad Varela, Jose Samuel Ronaldo',NULL,NULL),(347,'Juan Artigas Benjamin','Trinidad Varela','Trinidad Varela, Juan Artigas Benjamin',NULL,NULL),(348,'Maria Angelica Yanina','Trinidad Varela','Trinidad Varela, Maria Angelica Yanina',NULL,NULL),(349,'Virginia Ronalda','Trinidad Varela Lopez','Trinidad Varela Lopez, Virginia Ronalda',NULL,NULL),(350,'Leandro','Uriarte Sosa','Uriarte Sosa, Leandro',NULL,NULL),(351,'Mathias Nauhel','Uriarte Sosa','Uriarte Sosa, Mathias Nauhel',NULL,NULL),(352,'Maria del Rosario','Varela Lopez','Varela Lopez, Maria del Rosario',NULL,NULL),(353,'Artigas Alfredo','Varela Silva','Varela Silva, Artigas Alfredo',NULL,NULL),(354,'Sofia Patricia','Vargas Piovesan','Vargas Piovesan, Sofia Patricia',NULL,NULL),(355,'Alejandra Marcela','Vaz Barboza','Vaz Barboza, Alejandra Marcela',NULL,NULL),(356,'Mabel Mercedes','Vazquez Dos Santos','Vazquez Dos Santos, Mabel Mercedes',NULL,NULL),(357,'Leandro Martin','Vechio Roman','Vechio Roman, Leandro Martin',NULL,NULL),(358,'Roxana','Velazquez Velazquez','Velazquez Velazquez, Roxana',NULL,NULL),(359,'Marcela del Carmen','Vera Gadea','Vera Gadea, Marcela del Carmen',NULL,NULL),(360,'Jose Maria','Verdala Diaz','Verdala Diaz, Jose Maria',NULL,NULL),(361,'Facundo','*Verdala Pirez','*Verdala Pirez, Facundo',NULL,NULL),(362,'Valentina','Verdala Pirez','Verdala Pirez, Valentina',NULL,NULL),(363,'Raquel','Viazzo Garcia','Viazzo Garcia, Raquel',NULL,NULL),(364,'Sonia Ester','Viberti Fernandez','Viberti Fernandez, Sonia Ester',NULL,NULL),(365,'Griselda Teresita','Viera','Viera, Griselda Teresita',NULL,NULL),(366,'Adalberto Gabriel','Viera Bandeira','Viera Bandeira, Adalberto Gabriel',NULL,NULL),(367,'Juan Maria','Viera Sanguinetti','Viera Sanguinetti, Juan Maria',NULL,NULL),(368,'Yanaira Tatiana','Viera Velazquez','Viera Velazquez, Yanaira Tatiana',NULL,NULL),(369,'Monica Gabriela','Yacquez Echagüe','Yacquez Echagüe, Monica Gabriela',NULL,NULL),(370,'Roberto','Yanuzzi','Yanuzzi, Roberto',NULL,NULL);
/*!40000 ALTER TABLE `church_member` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discourse`
--

LOCK TABLES `discourse` WRITE;
/*!40000 ALTER TABLE `discourse` DISABLE KEYS */;
INSERT INTO `discourse` VALUES (1,38,3,'2019-12-01',38);
/*!40000 ALTER TABLE `discourse` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=342 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hymn`
--

LOCK TABLES `hymn` WRITE;
/*!40000 ALTER TABLE `hymn` DISABLE KEYS */;
INSERT INTO `hymn` VALUES (1,1,NULL,'The Morning Breaks',NULL),(2,2,NULL,'The Spirit of God',NULL),(3,3,NULL,'Now Let Us Rejoice',NULL),(4,4,NULL,'Truth Eternal',NULL),(5,5,NULL,'High on the Mountain Top',NULL),(6,6,NULL,'Redeemer of Israel',NULL),(7,7,NULL,'Israel, Israel, God Is Calling',NULL),(8,8,NULL,'Awake and Arise',NULL),(9,9,NULL,'Come, Rejoice',NULL),(10,10,NULL,'Come, Sing to the Lord',NULL),(11,11,NULL,'What Was Witnessed in the Heavens?',NULL),(12,12,NULL,'Twas Witnessed in the Morning Sky*',NULL),(13,13,NULL,'An Angel from on High',NULL),(14,14,NULL,'Sweet Is the Peace the Gospel Brings',NULL),(15,15,NULL,'I Saw a Mighty Angel Fly*',NULL),(16,16,NULL,'What Glorious Scenes Mine Eyes Behold',NULL),(17,17,NULL,'Awake, Ye Saints of God, Awake!',NULL),(18,18,NULL,'The Voice of God Again Is Heard',NULL),(19,19,NULL,'We Thank Thee, O God, for a Prophet',NULL),(20,20,NULL,'God of Power, God of Right',NULL),(21,21,NULL,'Come, Listen to a Prophet\'s Voice',NULL),(22,22,NULL,'We Listen to a Prophet\'s Voice',NULL),(23,23,NULL,'We Ever Pray for Thee',NULL),(24,24,NULL,'God Bless Our Prophet Dear',NULL),(25,25,NULL,'Now We\'ll Sing with One Accord',NULL),(26,26,NULL,'Joseph Smith\'s First Prayer',NULL),(27,27,NULL,'Praise to the Man',NULL),(28,28,NULL,'Saints, Behold How Great Jehovah',NULL),(29,29,NULL,'A Poor Wayfaring Man of Grief',NULL),(30,30,NULL,'Come, Come, Ye Saints',NULL),(31,31,NULL,'O God, Our Help in Ages Past',NULL),(32,32,NULL,'The Happy Day at Last Has Come',NULL),(33,33,NULL,'Our Mountain Home So Dear',NULL),(34,34,NULL,'O Ye Mountains High',NULL),(35,35,NULL,'For the Strength of the Hills',NULL),(36,36,NULL,'They, the Builders of the Nation',NULL),(37,37,NULL,'The Wintry Day, Descending to Its Close',NULL),(38,38,NULL,'Come, All Ye Saints of Zion',NULL),(39,39,NULL,'O Saints of Zion',NULL),(40,40,NULL,'Arise, O Glorious Zion',NULL),(41,41,NULL,'Let Zion in Her Beauty Rise',NULL),(42,42,NULL,'Hail to the Brightness of Zion\'s Glad Morning!',NULL),(43,43,NULL,'Zion Stands with Hills Surrounded',NULL),(44,44,NULL,'Beautiful Zion, Built Above',NULL),(45,45,NULL,'Lead Me into Life Eternal',NULL),(46,46,NULL,'Glorious Things of Thee Are Spoken',NULL),(47,47,NULL,'We Will Sing of Zion',NULL),(48,48,NULL,'Glorious Things Are Sung of Zion',NULL),(49,49,NULL,'Adam-ondi-Ahman',NULL),(50,50,NULL,'Come, Thou Glorious Day of Promise',NULL),(51,51,NULL,'Sons of Michael, He Approaches',NULL),(52,52,NULL,'The Day Dawn Is Breaking',NULL),(53,53,NULL,'Let Earth\'s Inhabitants Rejoice',NULL),(54,54,NULL,'Behold, the Mountain of the Lord*',NULL),(55,55,NULL,'Lo, the Mighty God Appearing!',NULL),(56,56,NULL,'Softly Beams the Sacred Dawning',NULL),(57,57,NULL,'We\'re Not Ashamed to Own Our Lord',NULL),(58,58,NULL,'Come, Ye Children of the Lord',NULL),(59,59,NULL,'Come, O Thou King of Kings',NULL),(60,60,NULL,'Battle Hymn of the Republic',NULL),(61,61,NULL,'Raise Your Voices to the Lord',NULL),(62,62,NULL,'All Creatures of Our God and King*',NULL),(63,63,NULL,'Great King of Heaven',NULL),(64,64,NULL,'On This Day of Joy and Gladness',NULL),(65,65,NULL,'Come, All Ye Saints Who Dwell on Earth',NULL),(66,66,NULL,'Rejoice, the Lord Is King!',NULL),(67,67,NULL,'Glory to God on High',NULL),(68,68,NULL,'A Mighty Fortress Is Our God',NULL),(69,69,NULL,'All Glory, Laud, and Honor',NULL),(70,70,NULL,'Sing Praise to Him',NULL),(71,71,NULL,'With Songs of Praise',NULL),(72,72,NULL,'Praise to the Lord, the Almighty',NULL),(73,73,NULL,'Praise the Lord with Heart and Voice',NULL),(74,74,NULL,'Praise Ye the Lord',NULL),(75,75,NULL,'In Hymns of Praise',NULL),(76,76,NULL,'God of Our Fathers, We Come unto Thee',NULL),(77,77,NULL,'Great Is the Lord',NULL),(78,78,NULL,'God of Our Fathers, Whose Almighty Hand',NULL),(79,79,NULL,'With All the Power of Heart and Tongue',NULL),(80,80,NULL,'God of Our Fathers, Known of Old',NULL),(81,81,NULL,'Press Forward, Saints',NULL),(82,82,NULL,'For All the Saints*',NULL),(83,83,NULL,'Guide Us, O Thou Great Jehovah',NULL),(84,84,NULL,'Faith of Our Fathers',NULL),(85,85,NULL,'How Firm a Foundation',NULL),(86,86,NULL,'How Great Thou Art*',NULL),(87,87,NULL,'God Is Love',NULL),(88,88,NULL,'Great God, Attend While Zion Sings',NULL),(89,89,NULL,'The Lord Is My Light',NULL),(90,90,NULL,'From All That Dwell below the Skies',NULL),(91,91,NULL,'Father, Thy Children to Thee Now Raise',NULL),(92,92,NULL,'For the Beauty of the Earth',NULL),(93,93,NULL,'Prayer of Thanksgiving',NULL),(94,94,NULL,'Come, Ye Thankful People',NULL),(95,95,NULL,'Now Thank We All Our God',NULL),(96,96,NULL,'Dearest Children, God Is Near You',NULL),(97,97,NULL,'Lead, Kindly Light',NULL),(98,98,NULL,'I Need Thee Every Hour',NULL),(99,99,NULL,'Nearer, Dear Savior, to Thee',NULL),(100,100,NULL,'Nearer, My God, to Thee',NULL),(101,101,NULL,'Guide Me to Thee',NULL),(102,102,NULL,'Jesus, Lover of My Soul',NULL),(103,103,NULL,'Precious Savior, Dear Redeemer',NULL),(104,104,NULL,'Jesus, Savior, Pilot Me',NULL),(105,105,NULL,'Master, the Tempest Is Raging',NULL),(106,106,NULL,'God Speed the Right',NULL),(107,107,NULL,'Lord, Accept Our True Devotion',NULL),(108,108,NULL,'The Lord Is My Shepherd',NULL),(109,109,NULL,'The Lord My Pasture Will Prepare',NULL),(110,110,NULL,'Cast Thy Burden upon the Lord',NULL),(111,111,NULL,'Rock of Ages',NULL),(112,112,NULL,'Savior, Redeemer of My Soul',NULL),(113,113,NULL,'Our Savior\'s Love',NULL),(114,114,NULL,'Come unto Him',NULL),(115,115,NULL,'Come, Ye Disconsolate',NULL),(116,116,NULL,'Come, Follow Me',NULL),(117,117,NULL,'Come unto Jesus',NULL),(118,118,NULL,'Ye Simple Souls Who Stray',NULL),(119,119,NULL,'Come, We That Love the Lord',NULL),(120,120,NULL,'Lean on My Ample Arm',NULL),(121,121,NULL,'I\'m a Pilgrim, I\'m a Stranger',NULL),(122,122,NULL,'Though Deepening Trials',NULL),(123,123,NULL,'Oh, May My Soul Commune with Thee',NULL),(124,124,NULL,'Be Still, My Soul*',NULL),(125,125,NULL,'How Gentle God\'s Commands',NULL),(126,126,NULL,'How Long, O Lord Most Holy and True',NULL),(127,127,NULL,'Does the Journey Seem Long?',NULL),(128,128,NULL,'When Faith Endures',NULL),(129,129,NULL,'Where Can I Turn for Peace?',NULL),(130,130,NULL,'Be Thou Humble',NULL),(131,131,NULL,'More Holiness Give Me',NULL),(132,132,NULL,'God Is in His Holy Temple',NULL),(133,133,NULL,'Father in Heaven',NULL),(134,134,NULL,'I Believe in Christ',NULL),(135,135,NULL,'My Redeemer Lives',NULL),(136,136,NULL,'I Know That My Redeemer Lives',NULL),(137,137,NULL,'Testimony',NULL),(138,138,NULL,'Bless Our Fast, We Pray',NULL),(139,139,NULL,'In Fasting We Approach Thee',NULL),(140,140,NULL,'Did You Think to Pray?',NULL),(141,141,NULL,'Jesus, the Very Thought of Thee',NULL),(142,142,NULL,'Sweet Hour of Prayer',NULL),(143,143,NULL,'Let the Holy Spirit Guide*',NULL),(144,144,NULL,'Secret Prayer',NULL),(145,145,NULL,'Prayer Is the Soul\'s Sincere Desire',NULL),(146,146,NULL,'Gently Raise the Sacred Strain',NULL),(147,147,NULL,'Sweet Is the Work',NULL),(148,148,NULL,'Sabbath Day',NULL),(149,149,NULL,'As the Dew from Heaven Distilling',NULL),(150,150,NULL,'O Thou Kind and Gracious Father',NULL),(151,151,NULL,'We Meet, Dear Lord',NULL),(152,152,NULL,'God Be with You Till We Meet Again',NULL),(153,153,NULL,'Lord, We Ask Thee Ere We Part',NULL),(154,154,NULL,'Father, This Hour Has Been One of Joy',NULL),(155,155,NULL,'We Have Partaken of Thy Love',NULL),(156,156,NULL,'Sing We Now at Parting',NULL),(157,157,NULL,'Thy Spirit, Lord, Has Stirred Our Souls',NULL),(158,158,NULL,'Before Thee, Lord, I Bow My Head',NULL),(159,159,NULL,'Now the Day Is Over',NULL),(160,160,NULL,'Softly Now the Light of Day',NULL),(161,161,NULL,'The Lord Be with Us',NULL),(162,162,NULL,'Lord, We Come before Thee Now',NULL),(163,163,NULL,'Lord, Dismiss Us with Thy Blessing',NULL),(164,164,NULL,'Great God, to Thee My Evening Song',NULL),(165,165,NULL,'Abide with Me; \'Tis Eventide',NULL),(166,166,NULL,'Abide with Me!',NULL),(167,167,NULL,'Come, Let Us Sing an Evening Hymn',NULL),(168,168,NULL,'As the Shadows Fall',NULL),(169,169,NULL,'As Now We Take the Sacrament',NULL),(170,170,NULL,'God, Our Father, Hear Us Pray',NULL),(171,171,NULL,'With Humble Heart',NULL),(172,172,NULL,'In Humility, Our Savior',NULL),(173,173,NULL,'While of These Emblems We Partake',NULL),(174,174,NULL,'While of These Emblems We Partake',NULL),(175,175,NULL,'O God, the Eternal Father',NULL),(176,176,NULL,'Tis Sweet to Sing the Matchless Love',NULL),(177,177,NULL,'Tis Sweet To Sing the Matchless Love',NULL),(178,178,NULL,'O Lord of Hosts',NULL),(179,179,NULL,'Again, Our Dear Redeeming Lord',NULL),(180,180,NULL,'Father in Heaven, We Do Believe',NULL),(181,181,NULL,'Jesus of Nazareth, Savior and King',NULL),(182,182,NULL,'We\'ll Sing All Hail to Jesus\' Name',NULL),(183,183,NULL,'In Remembrance of Thy Suffering',NULL),(184,184,NULL,'Upon the Cross of Calvary',NULL),(185,185,NULL,'Reverently and Meekly Now',NULL),(186,186,NULL,'Again We Meet around the Board',NULL),(187,187,NULL,'God Loved Us, So He Sent His Son',NULL),(188,188,NULL,'Thy Will, O Lord, Be Done',NULL),(189,189,NULL,'O Thou, Before the World Began',NULL),(190,190,NULL,'In Memory of the Crucified',NULL),(191,191,NULL,'Behold the Great Redeemer Die',NULL),(192,192,NULL,'He Died! The Great Redeemer Died',NULL),(193,193,NULL,'I Stand All Amazed',NULL),(194,194,NULL,'There Is a Green Hill Far Away',NULL),(195,195,NULL,'How Great the Wisdom and the Love',NULL),(196,196,NULL,'Jesus, Once of Humble Birth',NULL),(197,197,NULL,'O Savior, Thou Who Wearest a Crown',NULL),(198,198,NULL,'That Easter Morn',NULL),(199,199,NULL,'He Is Risen!',NULL),(200,200,NULL,'Christ the Lord Is Risen Today',NULL),(201,201,NULL,'Joy to the World',NULL),(202,202,NULL,'Oh, Come, All Ye Faithful',NULL),(203,203,NULL,'Angels We Have Heard on High',NULL),(204,204,NULL,'Silent Night',NULL),(205,205,NULL,'Once in Royal David\'s City',NULL),(206,206,NULL,'Away in a Manger',NULL),(207,207,NULL,'It Came upon the Midnight Clear',NULL),(208,208,NULL,'O Little Town of Bethlehem',NULL),(209,209,NULL,'Hark! The Herald Angels Sing',NULL),(210,210,NULL,'With Wondering Awe',NULL),(211,211,NULL,'While Shepherds Watched Their Flocks',NULL),(212,212,NULL,'Far, Far Away on Judea\'s Plains',NULL),(213,213,NULL,'The First Noel',NULL),(214,214,NULL,'I Heard the Bells on Christmas Day',NULL),(215,215,NULL,'Ring Out, Wild Bells',NULL),(216,216,NULL,'We Are Sowing',NULL),(217,217,NULL,'Come, Let Us Anew',NULL),(218,218,NULL,'We Give Thee But Thine Own',NULL),(219,219,NULL,'Because I Have Been Given Much*',NULL),(220,220,NULL,'Lord, I Would Follow Thee',NULL),(221,221,NULL,'Dear to the Heart of the Shepherd',NULL),(222,222,NULL,'Hear Thou Our Hymn, O Lord',NULL),(223,223,NULL,'Have I Done Any Good?',NULL),(224,224,NULL,'I Have Work Enough to Do',NULL),(225,225,NULL,'We Are Marching On to Glory',NULL),(226,226,NULL,'Improve the Shining Moments',NULL),(227,227,NULL,'There Is Sunshine in My Soul Today',NULL),(228,228,NULL,'You Can Make the Pathway Bright',NULL),(229,229,NULL,'Today, While the Sun Shines',NULL),(230,230,NULL,'Scatter Sunshine',NULL),(231,231,NULL,'Father, Cheer Our Souls Tonight',NULL),(232,232,NULL,'Let Us Oft Speak Kind Words',NULL),(233,233,NULL,'Nay, Speak No Ill',NULL),(234,234,NULL,'Jesus, Mighty King in Zion',NULL),(235,235,NULL,'Should You Feel Inclined to Censure',NULL),(236,236,NULL,'Lord, Accept into Thy Kingdom',NULL),(237,237,NULL,'Do What Is Right',NULL),(238,238,NULL,'Behold Thy Sons and Daughters, Lord',NULL),(239,239,NULL,'Choose the Right',NULL),(240,240,NULL,'Know This, That Every Soul Is Free',NULL),(241,241,NULL,'Count Your Blessings',NULL),(242,242,NULL,'Praise God, from Whom All Blessings Flow',NULL),(243,243,NULL,'Let Us All Press On',NULL),(244,244,NULL,'Come Along, Come Along',NULL),(245,245,NULL,'This House We Dedicate to Thee',NULL),(246,246,NULL,'Onward, Christian Soldiers',NULL),(247,247,NULL,'We Love Thy House, O God',NULL),(248,248,NULL,'Up, Awake, Ye Defenders of Zion',NULL),(249,249,NULL,'Called to Serve',NULL),(250,250,NULL,'We Are All Enlisted',NULL),(251,251,NULL,'Behold! A Royal Army',NULL),(252,252,NULL,'Put Your Shoulder to the Wheel',NULL),(253,253,NULL,'Like Ten Thousand Legions Marching',NULL),(254,254,NULL,'True to the Faith',NULL),(255,255,NULL,'Carry On',NULL),(256,256,NULL,'As Zion\'s Youth in Latter Days',NULL),(257,257,NULL,'Rejoice! A Glorious Sound Is Heard',NULL),(258,258,NULL,'O Thou Rock of Our Salvation',NULL),(259,259,NULL,'Hope of Israel',NULL),(260,260,NULL,'Who\'s on the Lord\'s Side?',NULL),(261,261,NULL,'Thy Servants Are Prepared',NULL),(262,262,NULL,'Go, Ye Messengers of Glory',NULL),(263,263,NULL,'Go Forth with Faith',NULL),(264,264,NULL,'Hark, All Ye Nations!',NULL),(265,265,NULL,'Arise, O God, and Shine',NULL),(266,266,NULL,'The Time Is Far Spent',NULL),(267,267,NULL,'How Wondrous and Great',NULL),(268,268,NULL,'Come, All Whose Souls Are Lighted',NULL),(269,269,NULL,'Jehovah, Lord of Heaven and Earth',NULL),(270,270,NULL,'I\'ll Go Where You Want Me to Go',NULL),(271,271,NULL,'Oh, Holy Words of Truth and Love',NULL),(272,272,NULL,'Oh Say, What Is Truth?',NULL),(273,273,NULL,'Truth Reflects upon Our Senses',NULL),(274,274,NULL,'The Iron Rod',NULL),(275,275,NULL,'Men Are That They Might Have Joy',NULL),(276,276,NULL,'Come Away to the Sunday School',NULL),(277,277,NULL,'As I Search the Holy Scriptures',NULL),(278,278,NULL,'Thanks for the Sabbath School',NULL),(279,279,NULL,'Thy Holy Word',NULL),(280,280,NULL,'Welcome, Welcome, Sabbath Morning',NULL),(281,281,NULL,'Help Me Teach with Inspiration',NULL),(282,282,NULL,'We Meet Again in Sabbath School',NULL),(283,283,NULL,'The Glorious Gospel Light Has Shone',NULL),(284,284,NULL,'If You Could Hie to Kolob*',NULL),(285,285,NULL,'God Moves in a Mysterious Way',NULL),(286,286,NULL,'Oh, What Songs of the Heart',NULL),(287,287,NULL,'Rise, Ye Saints, and Temples Enter',NULL),(288,288,NULL,'How Beautiful Thy Temples, Lord',NULL),(289,289,NULL,'Holy Temples on Mount Zion',NULL),(290,290,NULL,'Rejoice, Ye Saints of Latter Days',NULL),(291,291,NULL,'Turn Your Hearts',NULL),(292,292,NULL,'O My Father',NULL),(293,293,NULL,'Each Life That Touches Ours for Good',NULL),(294,294,NULL,'Love at Home',NULL),(295,295,NULL,'O Love That Glorifies the Son',NULL),(296,296,NULL,'Our Father, by Whose Name',NULL),(297,297,NULL,'From Homes of Saints Glad Songs Arise',NULL),(298,298,NULL,'Home Can Be a Heaven on Earth',NULL),(299,299,NULL,'Children of Our Heavenly Father*',NULL),(300,300,NULL,'Families Can Be Together Forever',NULL),(301,301,NULL,'I Am a Child of God',NULL),(302,302,NULL,'I Know My Father Lives',NULL),(303,303,NULL,'Keep the Commandments',NULL),(304,304,NULL,'Teach Me to Walk in the Light',NULL),(305,305,NULL,'The Light Divine',NULL),(306,306,NULL,'God\'s Daily Care',NULL),(307,307,NULL,'In Our Lovely Deseret',NULL),(308,308,NULL,'Love One Another',NULL),(309,309,NULL,'As Sisters in Zion (Women)',NULL),(310,310,NULL,'A Key Was Turned in Latter Days (Women)',NULL),(311,311,NULL,'We Meet Again as Sisters (Women)',NULL),(312,312,NULL,'We Ever Pray for Thee (Women)',NULL),(313,313,NULL,'God Is Love (Women)',NULL),(314,314,NULL,'How Gentle God\'s Commands (Women)',NULL),(315,315,NULL,'Jesus, the Very Thought of Thee (Women)',NULL),(316,316,NULL,'The Lord Is My Shepherd (Women)',NULL),(317,317,NULL,'Sweet Is the Work (Women)',NULL),(318,318,NULL,'Love at Home (Women)',NULL),(319,319,NULL,'Ye Elders of Israel (Men)',NULL),(320,320,NULL,'The Priesthood of Our Lord (Men)',NULL),(321,321,NULL,'Ye Who Are Called to Labor (Men)',NULL),(322,322,NULL,'Come, All Ye Sons of God (Men)',NULL),(323,323,NULL,'Rise Up, O Men of God (Men\'s Choir)',NULL),(324,324,NULL,'Rise Up, O Men of God (Men)',NULL),(325,325,NULL,'See the Mighty Priesthood Gathered (Men\'s Choir)',NULL),(326,326,NULL,'Come, Come, Ye Saints (Men\'s Choir)',NULL),(327,327,NULL,'Go, Ye Messengers of Heaven (Men\'s Choir)',NULL),(328,328,NULL,'An Angel from on High',NULL),(329,329,NULL,'Thy Servants Are Prepared (Men\'s Choir)',NULL),(330,330,NULL,'See, the Mighty Angel Flying (Men\'s Choir)',NULL),(331,331,NULL,'Oh Say, What Is Truth? (Men\'s Choir)',NULL),(332,332,NULL,'Come, O Thou King of Kings (Men\'s Choir)',NULL),(333,333,NULL,'High on the Mountain Top (Men\'s Choir)',NULL),(334,334,NULL,'I Need Thee Every Hour (Men\'s Choir)',NULL),(335,335,NULL,'Brightly Beams Our Father\'s Mercy (Men\'s Choir)',NULL),(336,336,NULL,'School Thy Feelings (Men\'s Choir)',NULL),(337,337,NULL,'O Home Beloved (Men\'s Choir)',NULL),(338,338,NULL,'America the Beautiful',NULL),(339,339,NULL,'My Country, \'Tis of Thee',NULL),(340,340,NULL,'The Star-Spangled Banner',NULL),(341,341,NULL,'God Save the King',NULL);
/*!40000 ALTER TABLE `hymn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prayer`
--

DROP TABLE IF EXISTS `prayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prayer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `prayer_member_id_idx` (`member`),
  CONSTRAINT `prayer_member_id` FOREIGN KEY (`member`) REFERENCES `church_member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prayer`
--

LOCK TABLES `prayer` WRITE;
/*!40000 ALTER TABLE `prayer` DISABLE KEYS */;
/*!40000 ALTER TABLE `prayer` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `sacrament_meeting`
--

LOCK TABLES `sacrament_meeting` WRITE;
/*!40000 ALTER TABLE `sacrament_meeting` DISABLE KEYS */;
/*!40000 ALTER TABLE `sacrament_meeting` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `sacrament_meeting_hymn`
--

LOCK TABLES `sacrament_meeting_hymn` WRITE;
/*!40000 ALTER TABLE `sacrament_meeting_hymn` DISABLE KEYS */;
/*!40000 ALTER TABLE `sacrament_meeting_hymn` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `sustaining_release`
--

LOCK TABLES `sustaining_release` WRITE;
/*!40000 ALTER TABLE `sustaining_release` DISABLE KEYS */;
/*!40000 ALTER TABLE `sustaining_release` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'Fe'),(2,'Jesuscristo'),(3,'Arrepentimiento');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

/*church member alter*/
ALTER TABLE `bma`.`attendance`
DROP FOREIGN KEY `attendance_member_id`;
ALTER TABLE `bma`.`attendance`
CHANGE COLUMN `member` `church_member` INT(11) NULL DEFAULT NULL ;
ALTER TABLE `bma`.`attendance`
ADD CONSTRAINT `attendance_member_id`
  FOREIGN KEY (`church_member`)
  REFERENCES `bma`.`church_member` (`id`);
