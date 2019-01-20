-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: crazy_dumplings__game_world_registry
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `action` (
  `ID_ACTION` int(11) NOT NULL AUTO_INCREMENT,
  `UNIQUE_NAME` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID_ACTION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `automation_object_provider`
--

DROP TABLE IF EXISTS `automation_object_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `automation_object_provider` (
  `ID_AUTOMATION_OBJECT_PROVIDER` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID_AUTOMATION_OBJECT_PROVIDER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automation_object_provider`
--

LOCK TABLES `automation_object_provider` WRITE;
/*!40000 ALTER TABLE `automation_object_provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `automation_object_provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_addon_interaction_receiving_property_modifier`
--

DROP TABLE IF EXISTS `game_addon_interaction_receiving_property_modifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_addon_interaction_receiving_property_modifier` (
  `ID_GAME_ADDON_INTERACTION_RECEIVING_PROPERTY_MODIFIER` int(11) NOT NULL AUTO_INCREMENT,
  `GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE_ID` int(11) DEFAULT NULL,
  `AFFECTED_GAME_OBJECT_TYPE_PROPERTY_ID` int(11) DEFAULT NULL,
  `APPLIED_PROPERTY_VALUE_MULTIPLIER` double DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_ADDON_INTERACTION_RECEIVING_PROPERTY_MODIFIER`),
  KEY `FK_G_A_INT_REC_PROP_MOD_GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE_ID` (`GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE_ID`),
  KEY `FK_G_A_INT_REC_PROP_MOD_AFFECTED_GAME_OBJECT_TYPE_PROPERTY_ID` (`AFFECTED_GAME_OBJECT_TYPE_PROPERTY_ID`),
  CONSTRAINT `FK_G_A_INT_REC_PROP_MOD_AFFECTED_GAME_OBJECT_TYPE_PROPERTY_ID` FOREIGN KEY (`AFFECTED_GAME_OBJECT_TYPE_PROPERTY_ID`) REFERENCES `game_object_type_property` (`id_game_object_type_property`),
  CONSTRAINT `FK_G_A_INT_REC_PROP_MOD_GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE_ID`) REFERENCES `game_object_type_allowed_addon_type` (`id_game_object_type_allowed_addon_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_addon_interaction_receiving_property_modifier`
--

LOCK TABLES `game_addon_interaction_receiving_property_modifier` WRITE;
/*!40000 ALTER TABLE `game_addon_interaction_receiving_property_modifier` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_addon_interaction_receiving_property_modifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_assets_repository`
--

DROP TABLE IF EXISTS `game_assets_repository`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_assets_repository` (
  `ID_GAME_ASSETS_REPOSITORY` int(11) NOT NULL AUTO_INCREMENT,
  `UNIQUE_NAME` varchar(250) DEFAULT NULL,
  `DESCRIPTION` text,
  `PICTURE_HASH` text,
  PRIMARY KEY (`ID_GAME_ASSETS_REPOSITORY`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_assets_repository`
--

LOCK TABLES `game_assets_repository` WRITE;
/*!40000 ALTER TABLE `game_assets_repository` DISABLE KEYS */;
INSERT INTO `game_assets_repository` VALUES (1,'PRIMUS','The primordial repository',NULL),(2,'TESTUS','Repository for testing assets in-game',NULL),(4,'DELETE_ME','da da da',NULL),(48,'Test Create and Edit','The purpose of this repository is to test the creation and editing functionality of the repositories management page. The picture has not yet been addressed because of missing hashing / de-hashing functionality, which will be added later, once there is time to think it through. Blah, blah, blah, blah, blah, blah, blah, blah, blah, blah, blah, let\'s see the scroll bar !!! !!! !!! ha ha ha, the scroll bar looks nice :) but the text is not shown entirely. It is missing a line. Fuck Prime Faces !!! Motherfuckers ! aaaaaa aaaaa aaaaaaaaaaaaaaaaaaaa\n\n\n',NULL);
/*!40000 ALTER TABLE `game_assets_repository` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_assets_repository_owner`
--

DROP TABLE IF EXISTS `game_assets_repository_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_assets_repository_owner` (
  `ID_GAME_ASSETS_REPOSITORY_OWNER` bigint(20) NOT NULL AUTO_INCREMENT,
  `GAME_ASSETS_REPOSITORY_ID` bigint(20) NOT NULL,
  `OWNER_USER_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_GAME_ASSETS_REPOSITORY_OWNER`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_assets_repository_owner`
--

LOCK TABLES `game_assets_repository_owner` WRITE;
/*!40000 ALTER TABLE `game_assets_repository_owner` DISABLE KEYS */;
INSERT INTO `game_assets_repository_owner` VALUES (1,2,1),(45,48,1);
/*!40000 ALTER TABLE `game_assets_repository_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_client_type`
--

DROP TABLE IF EXISTS `game_client_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_client_type` (
  `ID_GAME_CLIENT_TYPE` int(11) NOT NULL AUTO_INCREMENT,
  `UNIQUE_NAME` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_CLIENT_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_client_type`
--

LOCK TABLES `game_client_type` WRITE;
/*!40000 ALTER TABLE `game_client_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_client_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type`
--

DROP TABLE IF EXISTS `game_object_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type` (
  `ID_GAME_OBJECT_TYPE` int(11) NOT NULL AUTO_INCREMENT,
  `GAME_ASSETS_REPOSITORY_ID` int(11) DEFAULT NULL,
  `GAME_OBJECT_TYPE_CLASS_ID` int(11) DEFAULT NULL,
  `UNIQUE_NAME` varchar(250) DEFAULT NULL,
  `IS_EXPERIMENTAL` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE`),
  KEY `FK_GAME_OBJECT_TYPE_GAME_OBJECT_TYPE_CLASS_ID` (`GAME_OBJECT_TYPE_CLASS_ID`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_GAME_OBJECT_TYPE_CLASS_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_CLASS_ID`) REFERENCES `game_object_type_class` (`id_game_object_type_class`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type`
--

LOCK TABLES `game_object_type` WRITE;
/*!40000 ALTER TABLE `game_object_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type_allowed_addon_type`
--

DROP TABLE IF EXISTS `game_object_type_allowed_addon_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type_allowed_addon_type` (
  `ID_GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE` int(11) NOT NULL AUTO_INCREMENT,
  `UNIQUE_NAME` varchar(250) DEFAULT NULL,
  `ADDON_GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  `APPLICABLE_TO_GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  `IS_EQUIPED_BY_DEFAULT` int(11) DEFAULT NULL,
  `IS_INCREMENTAL` int(11) DEFAULT NULL,
  `IS_TRIGGERED` int(11) DEFAULT NULL,
  `TRIGGER_ACTION_ID` int(11) DEFAULT NULL,
  `IS_SPAWNING` int(11) DEFAULT NULL,
  `SPAWNABLE_GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  `HAS_LIMITED_DURATION` int(11) DEFAULT NULL,
  `DURATION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE`),
  KEY `FK_GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE_ADDON_GAME_OBJECT_TYPE_ID` (`ADDON_GAME_OBJECT_TYPE_ID`),
  KEY `FK_G_OBJ_TYPE_A_ADDON_TYPE_APP_TO_GAME_OBJECT_TYPE_ID` (`APPLICABLE_TO_GAME_OBJECT_TYPE_ID`),
  KEY `FK_G_OBJ_TYPE_ALLOWED_ADDON_TYPE_TRIGGER_ACTION_ID` (`TRIGGER_ACTION_ID`),
  KEY `FK_G_OBJ_TYPE_ALLOWED_ADDON_TYPE_SPAWNABLE_GAME_OBJECT_TYPE_ID` (`SPAWNABLE_GAME_OBJECT_TYPE_ID`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE_ADDON_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`ADDON_GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`),
  CONSTRAINT `FK_G_OBJ_TYPE_ALLOWED_ADDON_TYPE_SPAWNABLE_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`SPAWNABLE_GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`),
  CONSTRAINT `FK_G_OBJ_TYPE_ALLOWED_ADDON_TYPE_TRIGGER_ACTION_ID` FOREIGN KEY (`TRIGGER_ACTION_ID`) REFERENCES `action` (`id_action`),
  CONSTRAINT `FK_G_OBJ_TYPE_A_ADDON_TYPE_APP_TO_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`APPLICABLE_TO_GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type_allowed_addon_type`
--

LOCK TABLES `game_object_type_allowed_addon_type` WRITE;
/*!40000 ALTER TABLE `game_object_type_allowed_addon_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type_allowed_addon_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type_automation`
--

DROP TABLE IF EXISTS `game_object_type_automation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type_automation` (
  `ID_GAME_OBJECT_TYPE_AUTOMATION` int(11) NOT NULL AUTO_INCREMENT,
  `GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  `AUTOMATION_OBJECT_PROVIDER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE_AUTOMATION`),
  KEY `FK_GAME_OBJECT_TYPE_AUTOMATION_GAME_OBJECT_TYPE_ID` (`GAME_OBJECT_TYPE_ID`),
  KEY `FK_GAME_OBJECT_TYPE_AUTOMATION_AUTOMATION_OBJECT_PROVIDER_ID` (`AUTOMATION_OBJECT_PROVIDER_ID`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_AUTOMATION_AUTOMATION_OBJECT_PROVIDER_ID` FOREIGN KEY (`AUTOMATION_OBJECT_PROVIDER_ID`) REFERENCES `automation_object_provider` (`id_automation_object_provider`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_AUTOMATION_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type_automation`
--

LOCK TABLES `game_object_type_automation` WRITE;
/*!40000 ALTER TABLE `game_object_type_automation` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type_automation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type_class`
--

DROP TABLE IF EXISTS `game_object_type_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type_class` (
  `ID_GAME_OBJECT_TYPE_CLASS` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE_CLASS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type_class`
--

LOCK TABLES `game_object_type_class` WRITE;
/*!40000 ALTER TABLE `game_object_type_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type_interaction`
--

DROP TABLE IF EXISTS `game_object_type_interaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type_interaction` (
  `ID_GAME_OBJECT_TYPE_INTERACTION` int(11) NOT NULL AUTO_INCREMENT,
  `DONATING_GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  `RECEIVING_GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  `RADIUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE_INTERACTION`),
  KEY `FK_GAME_OBJECT_TYPE_INTERACTION_DONATING_GAME_OBJECT_TYPE_ID` (`DONATING_GAME_OBJECT_TYPE_ID`),
  KEY `FK_GAME_OBJECT_TYPE_INTERACTION_RECEIVING_GAME_OBJECT_TYPE_ID` (`RECEIVING_GAME_OBJECT_TYPE_ID`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_INTERACTION_DONATING_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`DONATING_GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_INTERACTION_RECEIVING_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`RECEIVING_GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type_interaction`
--

LOCK TABLES `game_object_type_interaction` WRITE;
/*!40000 ALTER TABLE `game_object_type_interaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type_interaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type_interaction_property`
--

DROP TABLE IF EXISTS `game_object_type_interaction_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type_interaction_property` (
  `ID_GAME_OBJECT_TYPE_INTERACTION_PROPERTY` int(11) NOT NULL AUTO_INCREMENT,
  `GAME_OBJECT_TYPE_INTERACTION_ID` int(11) DEFAULT NULL,
  `DONATING_GAME_OBJECT_TYPE_PROPERTY_ID` int(11) DEFAULT NULL,
  `RECEIVING_GAME_OBJECT_TYPE_PROPERTY_ID` int(11) DEFAULT NULL,
  `OVERFLOW_GAME_OBJECT_TYPE_PROPERTY_ID` int(11) DEFAULT NULL,
  `IS_INCREMENTAL` int(11) DEFAULT NULL,
  `IS_INVERTED` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE_INTERACTION_PROPERTY`),
  KEY `FK_G_OBJ_TYPE_INTERACTION_PROP_GAME_OBJECT_TYPE_INTERACTION_ID` (`GAME_OBJECT_TYPE_INTERACTION_ID`),
  KEY `FK_G_OBJ_TYPE_INTERACTION_PROP_DTING_GE_OBJECT_TY_PROPERTY_ID` (`DONATING_GAME_OBJECT_TYPE_PROPERTY_ID`),
  KEY `FK_G_OBJ_TYPE_INTERACTION_PROP_REC_GAME_OBJECT_TYPE_PROPERTY_ID` (`RECEIVING_GAME_OBJECT_TYPE_PROPERTY_ID`),
  KEY `FK_G_OBJ_TYPE_INTERACTION_PROP_OVW_GAME_OBJ_TYPE_PROPERTY_ID` (`OVERFLOW_GAME_OBJECT_TYPE_PROPERTY_ID`),
  CONSTRAINT `FK_G_OBJ_TYPE_INTERACTION_PROP_DTING_GE_OBJECT_TY_PROPERTY_ID` FOREIGN KEY (`DONATING_GAME_OBJECT_TYPE_PROPERTY_ID`) REFERENCES `game_object_type_property` (`id_game_object_type_property`),
  CONSTRAINT `FK_G_OBJ_TYPE_INTERACTION_PROP_GAME_OBJECT_TYPE_INTERACTION_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_INTERACTION_ID`) REFERENCES `game_object_type_interaction` (`id_game_object_type_interaction`),
  CONSTRAINT `FK_G_OBJ_TYPE_INTERACTION_PROP_OVW_GAME_OBJECT_TYPE_PROPERTY_ID` FOREIGN KEY (`OVERFLOW_GAME_OBJECT_TYPE_PROPERTY_ID`) REFERENCES `game_object_type_property` (`id_game_object_type_property`),
  CONSTRAINT `FK_G_OBJ_TYPE_INTERACTION_PROP_OVW_GAME_OBJ_TYPE_PROPERTY_ID` FOREIGN KEY (`OVERFLOW_GAME_OBJECT_TYPE_PROPERTY_ID`) REFERENCES `game_object_type_property` (`id_game_object_type_property`),
  CONSTRAINT `FK_G_OBJ_TYPE_INTERACTION_PROP_RECG_GAME_OBJECT_TYPE_PROPERTY_ID` FOREIGN KEY (`RECEIVING_GAME_OBJECT_TYPE_PROPERTY_ID`) REFERENCES `game_object_type_property` (`id_game_object_type_property`),
  CONSTRAINT `FK_G_OBJ_TYPE_INTERACTION_PROP_REC_GAME_OBJECT_TYPE_PROPERTY_ID` FOREIGN KEY (`RECEIVING_GAME_OBJECT_TYPE_PROPERTY_ID`) REFERENCES `game_object_type_property` (`id_game_object_type_property`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type_interaction_property`
--

LOCK TABLES `game_object_type_interaction_property` WRITE;
/*!40000 ALTER TABLE `game_object_type_interaction_property` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type_interaction_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type_property`
--

DROP TABLE IF EXISTS `game_object_type_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type_property` (
  `ID_GAME_OBJECT_TYPE_PROPERTY` int(11) NOT NULL AUTO_INCREMENT,
  `GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  `PROPERTY_NAME` varchar(250) DEFAULT NULL,
  `PROPERTY_DEFAULT_VALUE` double DEFAULT NULL,
  `PROPERTY_MIN_VALUE` double DEFAULT NULL,
  `PROPERTY_MAX_VALUE` double DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE_PROPERTY`),
  KEY `FK_GAME_OBJECT_TYPE_PROPERTY_GAME_OBJECT_TYPE_ID` (`GAME_OBJECT_TYPE_ID`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_PROPERTY_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type_property`
--

LOCK TABLES `game_object_type_property` WRITE;
/*!40000 ALTER TABLE `game_object_type_property` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type_representation`
--

DROP TABLE IF EXISTS `game_object_type_representation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type_representation` (
  `ID_GAME_OBJECT_TYPE_REPRESENTATION` int(11) NOT NULL AUTO_INCREMENT,
  `GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  `GAME_CLIENT_TYPE_ID` int(11) DEFAULT NULL,
  `OBJECT_HASH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE_REPRESENTATION`),
  KEY `FK_GAME_OBJECT_TYPE_REPRESENTATION_GAME_OBJECT_TYPE_ID` (`GAME_OBJECT_TYPE_ID`),
  KEY `FK_GAME_OBJECT_TYPE_REPRESENTATION_GAME_CLIENT_TYPE_ID` (`GAME_CLIENT_TYPE_ID`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_REPRESENTATION_GAME_CLIENT_TYPE_ID` FOREIGN KEY (`GAME_CLIENT_TYPE_ID`) REFERENCES `game_client_type` (`id_game_client_type`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_REPRESENTATION_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type_representation`
--

LOCK TABLES `game_object_type_representation` WRITE;
/*!40000 ALTER TABLE `game_object_type_representation` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type_representation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type_state`
--

DROP TABLE IF EXISTS `game_object_type_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type_state` (
  `ID_GAME_OBJECT_TYPE_STATE` int(11) NOT NULL AUTO_INCREMENT,
  `GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  `NAME` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE_STATE`),
  KEY `FK_GAME_OBJECT_TYPE_STATE_GAME_OBJECT_TYPE_ID` (`GAME_OBJECT_TYPE_ID`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_STATE_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type_state`
--

LOCK TABLES `game_object_type_state` WRITE;
/*!40000 ALTER TABLE `game_object_type_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type_state_property_modifier`
--

DROP TABLE IF EXISTS `game_object_type_state_property_modifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type_state_property_modifier` (
  `ID_GAME_OBJECT_TYPE_STATE_PROPERTY_MODIFIER` int(11) NOT NULL AUTO_INCREMENT,
  `GAME_OBJECT_TYPE_STATE_ID` int(11) DEFAULT NULL,
  `GAME_OBJECT_TYPE_PROPERTY_ID` int(11) DEFAULT NULL,
  `PROPERTY_ACTUAL_VALUE` double DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE_STATE_PROPERTY_MODIFIER`),
  KEY `FK_GAME_OBJECT_TYPE_STATE_PROPERTY_MOD_GAME_OBJECT_TYPE_STATE_ID` (`GAME_OBJECT_TYPE_STATE_ID`),
  KEY `FK_GAME_OBJECT_TYPE_ST_PROPERTY_MOD_GAME_OBJECT_TYPE_PROPERTY_ID` (`GAME_OBJECT_TYPE_PROPERTY_ID`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_STATE_PROPERTY_MOD_GAME_OBJECT_TYPE_STATE_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_STATE_ID`) REFERENCES `game_object_type_state` (`id_game_object_type_state`),
  CONSTRAINT `FK_GAME_OBJECT_TYPE_ST_PROPERTY_MOD_GAME_OBJECT_TYPE_PROPERTY_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_PROPERTY_ID`) REFERENCES `game_object_type_property` (`id_game_object_type_property`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type_state_property_modifier`
--

LOCK TABLES `game_object_type_state_property_modifier` WRITE;
/*!40000 ALTER TABLE `game_object_type_state_property_modifier` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type_state_property_modifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object_type_state_transition`
--

DROP TABLE IF EXISTS `game_object_type_state_transition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_object_type_state_transition` (
  `ID_GAME_OBJECT_TYPE_STATE_TRANSITION` int(11) NOT NULL AUTO_INCREMENT,
  `SOURCE_GAME_OBJECT_TYPE_STATE_ID` int(11) DEFAULT NULL,
  `TARGET_GAME_OBJECT_TYPE_STATE_ID` int(11) DEFAULT NULL,
  `IS_AUTOMATIC` int(11) DEFAULT NULL,
  `TRIGGER_ACTION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_OBJECT_TYPE_STATE_TRANSITION`),
  KEY `FK_GA_OBJ_TYP_ST_TRANS_SOURCE_GAME_OBJECT_TYPE_STATE_ID` (`SOURCE_GAME_OBJECT_TYPE_STATE_ID`),
  KEY `FK_G_OBJ_TYPE_ST_TRANS_TARGET_GAME_OBJECT_TYPE_STATE_ID` (`TARGET_GAME_OBJECT_TYPE_STATE_ID`),
  KEY `FK_G_OBJ_TYPE_STATE_TRANSITION_TRIGGER_ACTION_ID` (`TRIGGER_ACTION_ID`),
  CONSTRAINT `FK_GA_OBJ_TYP_ST_TRANS_SOURCE_GAME_OBJECT_TYPE_STATE_ID` FOREIGN KEY (`SOURCE_GAME_OBJECT_TYPE_STATE_ID`) REFERENCES `game_object_type_state` (`id_game_object_type_state`),
  CONSTRAINT `FK_G_OBJ_TYPE_STATE_TRANSITION_TRIGGER_ACTION_ID` FOREIGN KEY (`TRIGGER_ACTION_ID`) REFERENCES `action` (`id_action`),
  CONSTRAINT `FK_G_OBJ_TYPE_ST_TRANS_TARGET_GAME_OBJECT_TYPE_STATE_ID` FOREIGN KEY (`TARGET_GAME_OBJECT_TYPE_STATE_ID`) REFERENCES `game_object_type_state` (`id_game_object_type_state`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object_type_state_transition`
--

LOCK TABLES `game_object_type_state_transition` WRITE;
/*!40000 ALTER TABLE `game_object_type_state_transition` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_object_type_state_transition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_world`
--

DROP TABLE IF EXISTS `game_world`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_world` (
  `ID_GAME_WORLD` int(11) NOT NULL AUTO_INCREMENT,
  `UNIQUE_NAME` varchar(250) DEFAULT NULL,
  `DESCRIPTION` text,
  `PICTURE_REF_PATH` text,
  `WIDTH` int(11) DEFAULT NULL,
  `HEIGHT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_WORLD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_world`
--

LOCK TABLES `game_world` WRITE;
/*!40000 ALTER TABLE `game_world` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_world` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_world_cell`
--

DROP TABLE IF EXISTS `game_world_cell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_world_cell` (
  `ID_GAME_WORLD_CELL` int(11) NOT NULL AUTO_INCREMENT,
  `GAME_WORLD_ID` int(11) DEFAULT NULL,
  `GAME_WORLD_CELL_TYPE_ID` int(11) DEFAULT NULL,
  `X_INDEX` int(11) DEFAULT NULL,
  `Y_INDEX` int(11) DEFAULT NULL,
  `ATTACHED_GAME_WORLD_SPAWN_POINT_TYPE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_WORLD_CELL`),
  KEY `FK_GAME_WORLD_CELL_GAME_WORLD_ID` (`GAME_WORLD_ID`),
  KEY `FK_GAME_WORLD_CELL_GAME_WORLD_CELL_TYPE_ID` (`GAME_WORLD_CELL_TYPE_ID`),
  KEY `FK_GAME_WORLD_CELL_ATTACHED_GAME_WORLD_SPAWN_POINT_TYPE_ID` (`ATTACHED_GAME_WORLD_SPAWN_POINT_TYPE_ID`),
  CONSTRAINT `FK_GAME_WORLD_CELL_ATTACHED_GAME_WORLD_SPAWN_POINT_TYPE_ID` FOREIGN KEY (`ATTACHED_GAME_WORLD_SPAWN_POINT_TYPE_ID`) REFERENCES `game_world_spawn_point_type` (`id_game_world_spawn_point_type`),
  CONSTRAINT `FK_GAME_WORLD_CELL_GAME_WORLD_CELL_TYPE_ID` FOREIGN KEY (`GAME_WORLD_CELL_TYPE_ID`) REFERENCES `game_world_cell_type` (`id_game_world_cell_type`),
  CONSTRAINT `FK_GAME_WORLD_CELL_GAME_WORLD_ID` FOREIGN KEY (`GAME_WORLD_ID`) REFERENCES `game_world` (`id_game_world`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_world_cell`
--

LOCK TABLES `game_world_cell` WRITE;
/*!40000 ALTER TABLE `game_world_cell` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_world_cell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_world_cell_property`
--

DROP TABLE IF EXISTS `game_world_cell_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_world_cell_property` (
  `ID_GAME_WORLD_CELL_PROPERTY` int(11) NOT NULL AUTO_INCREMENT,
  `GAME_WORLD_CELL_ID` int(11) DEFAULT NULL,
  `GAME_OBJECT_TYPE_PROPERTY_ID` int(11) DEFAULT NULL,
  `PROPERTY_ACTUAL_VALUE` double DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_WORLD_CELL_PROPERTY`),
  KEY `FK_GAME_WORLD_CELL_PROPERTY_GAME_WORLD_CELL_ID` (`GAME_WORLD_CELL_ID`),
  KEY `FK_GAME_WORLD_CELL_PROPERTY_GAME_OBJECT_TYPE_PROPERTY_ID` (`GAME_OBJECT_TYPE_PROPERTY_ID`),
  CONSTRAINT `FK_GAME_WORLD_CELL_PROPERTY_GAME_OBJECT_TYPE_PROPERTY_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_PROPERTY_ID`) REFERENCES `game_object_type_property` (`id_game_object_type_property`),
  CONSTRAINT `FK_GAME_WORLD_CELL_PROPERTY_GAME_WORLD_CELL_ID` FOREIGN KEY (`GAME_WORLD_CELL_ID`) REFERENCES `game_world_cell` (`id_game_world_cell`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_world_cell_property`
--

LOCK TABLES `game_world_cell_property` WRITE;
/*!40000 ALTER TABLE `game_world_cell_property` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_world_cell_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_world_cell_type`
--

DROP TABLE IF EXISTS `game_world_cell_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_world_cell_type` (
  `ID_GAME_WORLD_CELL_TYPE` int(11) NOT NULL AUTO_INCREMENT,
  `UNIQUE_NAME` varchar(250) DEFAULT NULL,
  `GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_WORLD_CELL_TYPE`),
  KEY `FK_GAME_WORLD_CELL_TYPE_GAME_OBJECT_TYPE_ID` (`GAME_OBJECT_TYPE_ID`),
  CONSTRAINT `FK_GAME_WORLD_CELL_TYPE_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_world_cell_type`
--

LOCK TABLES `game_world_cell_type` WRITE;
/*!40000 ALTER TABLE `game_world_cell_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_world_cell_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_world_spawn_point_type`
--

DROP TABLE IF EXISTS `game_world_spawn_point_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game_world_spawn_point_type` (
  `ID_GAME_WORLD_SPAWN_POINT_TYPE` int(11) NOT NULL AUTO_INCREMENT,
  `SPAWN_POINT_GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  `SPAWNED_GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GAME_WORLD_SPAWN_POINT_TYPE`),
  KEY `FK_GAME_WORLD_SPAWN_POINT_TYPE_SPAWN_POINT_GAME_OBJECT_TYPE_ID` (`SPAWN_POINT_GAME_OBJECT_TYPE_ID`),
  KEY `FK_GAME_WORLD_SPAWN_POINT_TYPE_SPAWNED_GAME_OBJECT_TYPE_ID` (`SPAWNED_GAME_OBJECT_TYPE_ID`),
  CONSTRAINT `FK_GAME_WORLD_SPAWN_POINT_TYPE_SPAWNED_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`SPAWNED_GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`),
  CONSTRAINT `FK_GAME_WORLD_SPAWN_POINT_TYPE_SPAWN_POINT_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`SPAWN_POINT_GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_world_spawn_point_type`
--

LOCK TABLES `game_world_spawn_point_type` WRITE;
/*!40000 ALTER TABLE `game_world_spawn_point_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_world_spawn_point_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playable_character_type`
--

DROP TABLE IF EXISTS `playable_character_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `playable_character_type` (
  `ID_PLAYABLE_CHARACTER_TYPE` int(11) NOT NULL AUTO_INCREMENT,
  `UNIQUE_CHARACTER_TYPE_NAME` varchar(250) DEFAULT NULL,
  `GAME_OBJECT_TYPE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_PLAYABLE_CHARACTER_TYPE`),
  KEY `FK_PLAYABLE_CHARACTER_TYPE_GAME_OBJECT_TYPE_ID` (`GAME_OBJECT_TYPE_ID`),
  CONSTRAINT `FK_PLAYABLE_CHARACTER_TYPE_GAME_OBJECT_TYPE_ID` FOREIGN KEY (`GAME_OBJECT_TYPE_ID`) REFERENCES `game_object_type` (`id_game_object_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playable_character_type`
--

LOCK TABLES `playable_character_type` WRITE;
/*!40000 ALTER TABLE `playable_character_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `playable_character_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-20 14:46:19
