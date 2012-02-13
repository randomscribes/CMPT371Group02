-- MySQL dump 10.13  Distrib 5.5.20, for Linux (x86_64)
--
-- Host: edjo.usask.ca    Database: cmpt371group2_TeamEffort
-- ------------------------------------------------------
-- Server version	5.1.52

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
-- Table structure for table `announcements`
--

DROP TABLE IF EXISTS `announcements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcements` (
  `poster` int(11) DEFAULT NULL,
  `message` text COLLATE utf8_unicode_ci,
  `access` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcements`
--

LOCK TABLES `announcements` WRITE;
/*!40000 ALTER TABLE `announcements` DISABLE KEYS */;
INSERT INTO `announcements` VALUES (1101,'hi',1),(1007,'hello',2),(1007,'Welcome to the Soccer Management System.',2);
/*!40000 ALTER TABLE `announcements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_stats`
--

DROP TABLE IF EXISTS `game_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_stats` (
  `game_id` int(11) DEFAULT NULL,
  `goal` int(11) DEFAULT NULL,
  `assist` int(11) DEFAULT NULL,
  KEY `game_id` (`game_id`),
  KEY `goal` (`goal`),
  KEY `assist` (`assist`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_stats`
--

LOCK TABLES `game_stats` WRITE;
/*!40000 ALTER TABLE `game_stats` DISABLE KEYS */;
INSERT INTO `game_stats` VALUES (138,1089,1093),(116,1001,1000),(117,1000,1000),(118,1071,1071),(117,1000,1000),(118,1006,1007),(118,1006,1007),(118,1006,1007),(118,1006,1007),(115,1001,1006),(115,1001,1006),(117,1000,1000),(117,1000,1000),(117,1000,1001),(117,1000,1000),(117,1000,1000),(118,1006,1006),(118,1071,1006),(118,1071,1006),(118,1071,1006),(118,1071,1006),(118,1071,1006),(118,1071,NULL),(117,1000,1000),(117,1000,1000),(117,1000,1000),(117,1000,1000),(117,1000,1000),(117,1000,1000),(117,1000,1000),(117,1000,1000),(117,1000,1000),(138,1092,1095),(138,1102,1103),(138,1112,1118),(138,1110,1129),(138,1102,1103),(120,1092,1099),(120,1092,1099),(120,1092,1099),(120,1113,NULL),(120,1130,1118),(120,1093,1100),(120,1093,1100),(120,1093,1100),(120,1130,NULL),(120,1130,NULL),(139,1139,1142),(139,1139,1142),(139,1138,1137),(139,1135,1133),(139,1142,1141),(139,1142,1141),(139,1142,1141),(139,1142,1141),(139,1143,1141),(139,1139,1142),(139,1139,1142),(139,1139,1142),(139,1139,1142),(139,1139,1142),(139,1139,1142),(139,1139,1142),(139,1140,1141),(122,1143,1141),(122,1143,NULL),(122,1141,NULL),(122,1092,NULL),(122,1092,NULL),(139,1139,NULL);
/*!40000 ALTER TABLE `game_stats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `home_team` int(11) NOT NULL,
  `away_team` int(11) NOT NULL,
  `home_score` int(11) DEFAULT '0',
  `away_score` int(11) DEFAULT '0',
  `status` char(25) COLLATE utf8_unicode_ci DEFAULT 'Not Played',
  `location` char(25) COLLATE utf8_unicode_ci NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`game_id`),
  KEY `home_team` (`home_team`),
  KEY `away_team` (`away_team`)
) ENGINE=MyISAM AUTO_INCREMENT=146 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (123,35,37,0,0,'Not Played','Field 4','2011-11-26'),(126,31,36,0,0,'Not Played','Field 1','2011-12-04'),(125,36,37,0,0,'Not Played','Field 4','2011-11-30'),(124,31,35,0,0,'Not Played','Field 1','2011-11-30'),(122,31,36,2,3,'Played','Field 3','2011-11-26'),(120,31,35,6,4,'Not Played','Field 1','2011-11-20'),(121,36,37,0,0,'Not Played','Field 2','2011-11-25'),(127,31,36,0,0,'Not Played','Field 2','2011-12-06'),(128,35,36,0,0,'Not Played','Field 4','2011-12-10'),(129,36,37,0,0,'Not Played','Field 3','2011-12-15'),(145,31,35,0,0,'Not Played','Field 1','2012-02-06'),(131,36,31,0,0,'Not Played','Field 2','2011-12-20'),(132,37,35,0,0,'Not Played','Field 3','2011-12-20'),(133,36,35,0,0,'Not Played','Field 4','2012-01-02'),(134,35,31,0,0,'Not Played','Field 3','2012-01-05'),(135,31,36,0,0,'Not Played','Field 2','2012-01-26'),(136,35,37,0,0,'Not Played','Field 3','2012-02-01'),(137,31,37,0,0,'Not Played','Field 1','2012-02-05'),(138,31,35,4,2,'Not Played','Field 1','2011-11-01'),(139,36,37,16,2,'Played','Field 2','2011-10-05'),(140,36,37,0,0,'Not Played','Field 3','2011-11-03'),(141,31,35,0,0,'Not Played','Field 4','2011-10-30'),(142,37,31,0,0,'Not Played','Field 2','2011-10-31'),(143,35,36,0,0,'Played','Field 1','2011-10-28');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teams` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` char(20) COLLATE utf8_unicode_ci NOT NULL,
  `manager` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `games_played` int(11) DEFAULT NULL,
  `wins` int(11) DEFAULT NULL,
  `losses` int(11) DEFAULT NULL,
  `ties` int(11) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `ratio` float DEFAULT NULL,
  `goals_for` int(11) DEFAULT NULL,
  `goals_against` int(11) DEFAULT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (31,'NHFC',1101,2011,0,0,0,0,0,0,0,0),(35,'Ganbaro',1130,2011,0,0,0,0,0,0,0,0),(36,'WOTN FC',1141,2011,0,0,0,0,0,0,0,0),(37,'SPA Sentinels',1147,2011,0,0,0,0,0,0,0,0),(48,'Arsenal',1141,2011,0,0,0,0,0,0,0,0),(60,'Test',1101,2009,0,0,0,0,0,0,0,0),(61,'',0,0,0,0,0,0,0,0,0,0),(62,'at20characterlimit00',0,0,0,0,0,0,0,0,0,0),(63,'below20char',0,0,0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` text COLLATE utf8_unicode_ci NOT NULL,
  `last_name` text COLLATE utf8_unicode_ci NOT NULL,
  `address` char(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL,
  `fees_paid` tinyint(1) DEFAULT NULL,
  `jersey_number` int(11) DEFAULT NULL,
  `password` char(25) COLLATE utf8_unicode_ci NOT NULL,
  `access` char(25) COLLATE utf8_unicode_ci NOT NULL,
  `username` char(6) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  KEY `team_id` (`team_id`),
  FULLTEXT KEY `first_name` (`first_name`,`last_name`),
  FULLTEXT KEY `first_name_2` (`first_name`,`last_name`)
) ENGINE=MyISAM AUTO_INCREMENT=1176 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1139,'Matt','Arsenault',NULL,36,NULL,NULL,NULL,NULL,'default','0','ma44'),(1138,'Virginia','Kapronczal',NULL,37,NULL,NULL,NULL,NULL,'default','0','vk33'),(1007,'admin','admin','Admin Street',37,NULL,NULL,NULL,NULL,'admin','2','admin'),(1137,'Lee','Jones',NULL,37,NULL,NULL,NULL,NULL,'default','0','lj33'),(1136,'Melissa','Hanson',NULL,37,NULL,NULL,NULL,NULL,'default','0','mh33'),(1135,'Vince','Gabruch',NULL,37,NULL,NULL,NULL,NULL,'default','0','vg33'),(1140,'Jordi','Bott',NULL,36,NULL,NULL,NULL,NULL,'default','0','jb44'),(1134,'Priscila','Clayton',NULL,37,NULL,NULL,NULL,NULL,'default','0','pc33'),(1133,'Rebeca','Camargo',NULL,37,NULL,NULL,NULL,NULL,'default','0','rc33'),(1089,'Adam','Nestmann',NULL,31,NULL,NULL,NULL,NULL,'default','0','an11'),(1090,'Anthony','Zimmer',NULL,31,NULL,NULL,NULL,NULL,'default','0','az11'),(1091,'Brian','Truman',NULL,31,NULL,NULL,NULL,NULL,'default','0','bt11'),(1092,'Bryce','Geeraert',NULL,31,NULL,NULL,NULL,NULL,'default','0','bg11'),(1093,'Craig','Haker',NULL,31,NULL,NULL,NULL,NULL,'default','0','ch11'),(1094,'David','Dyck',NULL,31,NULL,NULL,NULL,NULL,'default','0','dd11'),(1095,'Jeff','Elder',NULL,31,NULL,NULL,NULL,NULL,'default','0','je11'),(1096,'Jingjin','Chen',NULL,31,NULL,NULL,NULL,NULL,'default','0','jj11'),(1097,'Mark','Gelineau',NULL,31,NULL,NULL,NULL,NULL,'default','0','mg11'),(1098,'Mike','Kieluk',NULL,31,NULL,NULL,NULL,NULL,'default','0','mk11'),(1099,'Miles','Buchwaldt',NULL,31,NULL,NULL,NULL,NULL,'default','0','mb11'),(1100,'Nathan','Schartner',NULL,31,NULL,NULL,NULL,NULL,'default','0','ns11'),(1101,'Noel','Zimmer',NULL,31,NULL,NULL,NULL,NULL,'default','1','nz11'),(1102,'Razvan','Rusescu',NULL,31,NULL,NULL,NULL,NULL,'default','0','rr11'),(1103,'Scott','Breckner',NULL,31,NULL,NULL,NULL,NULL,'default','0','sc11'),(1104,'Simon','Fanner',NULL,31,NULL,NULL,NULL,NULL,'default','0','sf11'),(1105,'Stephane','Wacholtz',NULL,31,NULL,NULL,NULL,NULL,'default','0','sw11'),(1106,'Steven','McKenna',NULL,31,NULL,NULL,NULL,NULL,'default','0','sm11'),(1107,'Justin','Bruce',NULL,31,NULL,NULL,NULL,NULL,'default','0','jb11'),(1108,'Jude','Godino',NULL,31,NULL,NULL,NULL,NULL,'default','0','jg11'),(1109,'Nadine','Brenaut',NULL,35,NULL,NULL,NULL,NULL,'default','0','nb22'),(1110,'Kristina','Carlson',NULL,35,NULL,NULL,NULL,NULL,'default','0','kc22'),(1130,'Melissa','Gan',NULL,35,NULL,NULL,NULL,NULL,'default','1','mg22'),(1112,'Erin','Hopkins',NULL,35,NULL,NULL,NULL,NULL,'default','0','eh22'),(1113,'Robin','Kooymans',NULL,35,NULL,NULL,NULL,NULL,'default','0','rk22'),(1114,'Jonny','Nicholson',NULL,35,NULL,NULL,NULL,NULL,'default','0','jn22'),(1115,'Matthew','Nicholson',NULL,35,NULL,NULL,NULL,NULL,'default','0','mn22'),(1116,'Angela','Nickel',NULL,35,NULL,NULL,NULL,NULL,'default','0','an22'),(1117,'Michelle','Sawatzky',NULL,35,NULL,NULL,NULL,NULL,'default','0','ms22'),(1118,'Matthew','Van den Berghe',NULL,35,NULL,NULL,NULL,NULL,'default','0','mv22'),(1147,'Steve','Barss',NULL,37,NULL,NULL,NULL,NULL,'default','1','sb33'),(1128,'Shane','Van den Berghe',NULL,35,NULL,NULL,NULL,NULL,'default','0','sv22'),(1131,'Dale','Amyotta',NULL,37,NULL,NULL,NULL,NULL,'default','0','da33'),(1129,'Nancy','Winder',NULL,35,NULL,NULL,NULL,NULL,'default','0','nw22'),(1141,'Dylan','Carlson',NULL,36,NULL,NULL,NULL,NULL,'default','1','dc44'),(1142,'Steven','Cheyne',NULL,36,NULL,NULL,NULL,NULL,'default','0','sc44'),(1143,'Arden','Georget',NULL,36,NULL,NULL,NULL,NULL,'default','0','ag44'),(1144,'Micheal','Leblanc',NULL,36,NULL,NULL,NULL,NULL,'default','0','ml44'),(1145,'Todd','Leblanc',NULL,36,NULL,NULL,NULL,NULL,'default','0','tl44'),(1146,'Keith','Mackenzie',NULL,36,NULL,NULL,NULL,NULL,'default','0','km44'),(1150,'Bob','bob',NULL,31,NULL,NULL,NULL,NULL,'default','0','bb33'),(1167,'','',NULL,NULL,NULL,NULL,NULL,NULL,'','','r'),(1168,'rehalrbuiehuuvednvdfvnjhbssssssggrtsadrtviooooosgiktnseeeeeeeeauievkldfsnmjkvbtrfgs','',NULL,NULL,NULL,NULL,NULL,NULL,'','','t'),(1169,'','gthsergbuitebvuhdnkslguthnseruihnifguvdjslfngjkfnnnnnnnnnuitlsdhnisdgulllrgtuirlrt',NULL,NULL,NULL,NULL,NULL,NULL,'','','y'),(1170,'','',NULL,NULL,NULL,NULL,NULL,NULL,'thisisa25charlimitpasswor','','u'),(1171,'','',NULL,NULL,NULL,NULL,NULL,NULL,'','','sfg123'),(1172,'njvreuisl#$%','',NULL,NULL,NULL,NULL,NULL,NULL,'','','i'),(1173,'','',NULL,NULL,NULL,NULL,NULL,NULL,'','','asd#$%'),(1174,'','',NULL,NULL,NULL,NULL,NULL,NULL,'qwefsd#$%','','l'),(1175,'','gbyuuuuer$%#',NULL,NULL,NULL,NULL,NULL,NULL,'','','h');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-02-13 15:42:50
