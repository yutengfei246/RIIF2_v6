-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 23, 2017 at 05:15 PM
-- Server version: 5.5.46-0ubuntu0.14.04.2
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `RIIF2`
--

-- --------------------------------------------------------

--
-- Table structure for table `definitions`
--

CREATE TABLE IF NOT EXISTS `definitions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `definition` text NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=264 ;

-- --------------------------------------------------------

--
-- Table structure for table `attributes`
--

CREATE TABLE IF NOT EXISTS `attributes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `value` int(11) DEFAULT NULL,
  `belongs` varchar(50) NOT NULL,
  `refersId` int(11) NOT NULL,
  `definitionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`definitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE 
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `childComponents`
--

CREATE TABLE IF NOT EXISTS `childComponents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` int(11) NOT NULL,
  `isAssociative` tinyint(1) NOT NULL,
  `associativeId` int(11) DEFAULT NULL,
  `arrayLength` int(11) DEFAULT NULL,
  `definitionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`definitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE 
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `constants`
--

CREATE TABLE IF NOT EXISTS `constants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `value` varchar(50) DEFAULT NULL,
  `isAssociative` tinyint(1) NOT NULL,
  `associativeId` int(11) DEFAULT NULL,
  `arrayLength` int(11) DEFAULT NULL,
  `definitionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`definitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE 
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `failModes`
--

CREATE TABLE IF NOT EXISTS `failModes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `isAssociative` tinyint(1) NOT NULL,
  `associativeId` int(11) DEFAULT NULL,
  `arrayLength` int(11) DEFAULT NULL,
  `definitionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`definitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE 
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parameters`
--

CREATE TABLE IF NOT EXISTS `parameters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `value` varchar(50) DEFAULT NULL,
  `isAssociative` tinyint(1) NOT NULL,
  `associativeId` int(11) DEFAULT NULL,
  `arrayLength` int(11) DEFAULT NULL,
  `definitionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`definitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE 
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `recorder`
--

CREATE TABLE IF NOT EXISTS `recorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `definitionId` int(11) NOT NULL,
  `eiDefinitionId` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`definitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE,
  FOREIGN KEY (`eiDefinitionId`) REFERENCES `definitions` (`id`) ON DELETE CASCADE 
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Table structure for table `requirements`
--

CREATE TABLE IF NOT EXISTS `environments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `inputOutput` varchar(50) NOT NULL,
  `value` varchar(50) DEFAULT NULL,
  `isAssociative` tinyint(1) NOT NULL,
  `associativeId` int(11) DEFAULT NULL,
  `arrayLength` int(11) DEFAULT NULL,
  `definitionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`definitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE 
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------
--
-- Table structure for table `requirements`
--

CREATE TABLE IF NOT EXISTS `requirements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `definitionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`definitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------


-- --------------------------------------------------------
--
-- Table structure for table `binds`
--

CREATE TABLE IF NOT EXISTS `binds` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `requirementDefinitionId` int(11) NOT NULL,
  `componentDefinitionId` int(11) NOT NULL,
  `definitionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`requirementDefinitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE,
  FOREIGN KEY (`componentDefinitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE,
  FOREIGN KEY (`definitionId`) REFERENCES `definitions` (`id`) ON  DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;




/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
