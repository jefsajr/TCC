-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: TCC
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.18.04.4

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
-- Table structure for table `audiencia`
--

DROP TABLE IF EXISTS `audiencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audiencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `nome_juiz` varchar(255) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audiencia`
--

LOCK TABLES `audiencia` WRITE;
/*!40000 ALTER TABLE `audiencia` DISABLE KEYS */;
INSERT INTO `audiencia` VALUES (79,'2019-11-18 00:36:26','Lierte Sobrinho Queiroz','1'),(80,'2019-11-18 00:37:00','Agenor Melo Siqueira','0'),(81,'2019-11-18 00:37:22','José Amancio Ribeiro','0'),(82,'2019-11-18 00:37:50','José Amancio Ribeiro','0'),(83,'2019-11-19 00:07:53','José Amancio Ribeiro','0'),(84,'2019-11-20 00:37:37','Agenor Melo Siqueira','1'),(85,'2019-11-20 01:06:18','Pedro Rúbio Marthis','0'),(86,'2019-11-20 01:20:07','José Amancio Ribeiro','1'),(87,'2019-12-08 21:13:23','Lierte Sobrinho Queiroz','1');
/*!40000 ALTER TABLE `audiencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogador`
--

DROP TABLE IF EXISTS `jogador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `total_pts` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogador`
--

LOCK TABLES `jogador` WRITE;
/*!40000 ALTER TABLE `jogador` DISABLE KEYS */;
INSERT INTO `jogador` VALUES (1,'Jeferson Sá Figueiredo Junior','jef','123456',15),(2,'Juliana dos Santos Mendonça','ju','123456',25),(3,'Tiago Peres Silveira','tiago','123456',0),(4,'Rafael Medeiros Campos','rafa','123456',0),(5,'Fabricio Germano Oliveira','fabricio','123456',0);
/*!40000 ALTER TABLE `jogador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogador_resposta`
--

DROP TABLE IF EXISTS `jogador_resposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogador_resposta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_Jogador` bigint(20) NOT NULL,
  `id_resposta` bigint(20) NOT NULL,
  `id_audiencia` bigint(20) NOT NULL,
  `soma_peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_jogador_resposta_audiencia_fk_idx` (`id_audiencia`),
  KEY `fk_jogador_resposta_jogador_fk_idx` (`id_Jogador`),
  KEY `fk_jogador_resposta_resposta_fk_idx` (`id_resposta`),
  CONSTRAINT `fk_jogador_resposta_audiencia_fk` FOREIGN KEY (`id_audiencia`) REFERENCES `audiencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_jogador_resposta_jogador_fk` FOREIGN KEY (`id_Jogador`) REFERENCES `jogador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_jogador_resposta_resposta_fk` FOREIGN KEY (`id_resposta`) REFERENCES `resposta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogador_resposta`
--

LOCK TABLES `jogador_resposta` WRITE;
/*!40000 ALTER TABLE `jogador_resposta` DISABLE KEYS */;
INSERT INTO `jogador_resposta` VALUES (116,2,1,79,1),(117,2,7,79,2),(118,2,13,79,3),(119,2,19,79,4),(120,2,25,79,5),(121,2,2,80,2),(122,2,7,80,2),(123,2,13,80,3),(124,2,2,81,2),(125,2,10,81,5),(126,2,13,81,3),(127,2,17,81,2),(128,2,2,82,2),(129,2,8,82,3),(130,2,1,84,1),(131,2,6,84,1),(132,2,11,84,1),(133,2,16,84,1),(134,2,21,84,1),(135,2,1,85,1),(136,2,6,85,1),(137,1,1,86,1),(138,1,7,86,2),(139,1,13,86,3),(140,1,19,86,4),(141,1,25,86,5),(142,2,4,87,4),(143,2,9,87,4),(144,2,15,87,5),(145,2,20,87,5),(146,2,25,87,5);
/*!40000 ALTER TABLE `jogador_resposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pergunta`
--

DROP TABLE IF EXISTS `pergunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pergunta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pergunta`
--

LOCK TABLES `pergunta` WRITE;
/*!40000 ALTER TABLE `pergunta` DISABLE KEYS */;
INSERT INTO `pergunta` VALUES (1,'Pergunta 1'),(2,'Pergunta 2'),(3,'Pergunta 3'),(4,'Pergunta 4'),(5,'Pergunta 5');
/*!40000 ALTER TABLE `pergunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resposta`
--

DROP TABLE IF EXISTS `resposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resposta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  `id_pergunta` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK74oo5u746tinf4q482qo1888n` (`id_pergunta`),
  CONSTRAINT `FK74oo5u746tinf4q482qo1888n` FOREIGN KEY (`id_pergunta`) REFERENCES `pergunta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resposta`
--

LOCK TABLES `resposta` WRITE;
/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;
INSERT INTO `resposta` VALUES (1,'resposta 1 da pergunta 1',1,1),(2,'resposta 2 da pergunta 1',2,1),(3,'resposta 3 da pergunta 1',3,1),(4,'resposta 4 da pergunta 1',4,1),(5,'resposta 5 da pergunta 1',5,1),(6,'resposta 1 da pergunta 1',1,2),(7,'resposta 2 da pergunta 1',2,2),(8,'resposta 3 da pergunta 1',3,2),(9,'resposta 4 da pergunta 1',4,2),(10,'resposta 5 da pergunta 1',5,2),(11,'resposta 1 da pergunta 3',1,3),(12,'resposta 2 da pergunta 3',2,3),(13,'resposta 3 da pergunta 3',3,3),(14,'resposta 4 da pergunta 3',4,3),(15,'resposta 5 da pergunta 3',5,3),(16,'resposta 1 da pergunta 4',1,4),(17,'resposta 2 da pergunta 4',2,4),(18,'resposta 3 da pergunta 4',3,4),(19,'resposta 4 da pergunta 4',4,4),(20,'resposta 5 da pergunta 4',5,4),(21,'resposta 1 da pergunta 5',1,5),(22,'resposta 2 da pergunta 5',2,5),(23,'resposta 3 da pergunta 5',3,5),(24,'resposta 4 da pergunta 5',4,5),(25,'resposta 5 da pergunta 5',5,5);
/*!40000 ALTER TABLE `resposta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-08 17:23:26
