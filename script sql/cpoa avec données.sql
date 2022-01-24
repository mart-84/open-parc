-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 23 jan. 2022 à 22:33
-- Version du serveur : 10.6.5-MariaDB
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cpoa`
--

-- --------------------------------------------------------

--
-- Structure de la table `appartenir`
--

DROP TABLE IF EXISTS `appartenir`;
CREATE TABLE IF NOT EXISTS `appartenir` (
  `equipeRamasseursId` int(11) NOT NULL,
  `ramasseurBalleId` int(11) NOT NULL,
  PRIMARY KEY (`equipeRamasseursId`,`ramasseurBalleId`),
  KEY `ramasseurBalleId` (`ramasseurBalleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `arbitre`
--

DROP TABLE IF EXISTS `arbitre`;
CREATE TABLE IF NOT EXISTS `arbitre` (
  `arbitreId` int(11) NOT NULL AUTO_INCREMENT,
  `nomArbitre` varchar(254) COLLATE latin1_general_ci DEFAULT NULL,
  `prenomArbitre` varchar(254) COLLATE latin1_general_ci DEFAULT NULL,
  `categorie` varchar(254) COLLATE latin1_general_ci DEFAULT NULL,
  `nationalite` varchar(255) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`arbitreId`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `arbitre`
--

INSERT INTO `arbitre` (`arbitreId`, `nomArbitre`, `prenomArbitre`, `categorie`, `nationalite`) VALUES
(1, 'Ramirez', 'Hashim', 'ITT1', 'Ireland'),
(2, 'Salinas', 'Boris', 'ITT1', 'Austria'),
(3, 'Robertson', 'Amir', 'ITT1', 'Ireland'),
(4, 'Barton', 'Cadman', 'ITT1', 'Netherlands'),
(5, 'Serrano', 'Mannix', 'ITT1', 'China'),
(6, 'Pierce', 'Elton', 'ITT1', 'Mexico'),
(7, 'Montoya', 'Hall', 'ITT1', 'Spain'),
(8, 'Palmer', 'Thomas', 'ITT1', 'Norway'),
(9, 'Whitfield', 'Fuller', 'ITT1', 'Peru'),
(10, 'Mercado', 'Timon', 'ITT1', 'Colombia'),
(11, 'Holloway', 'Yoshio', 'ITT1', 'Austria'),
(12, 'French', 'Samson', 'ITT1', 'Mexico'),
(13, 'Heath', 'Orson', 'ITT1', 'Pakistan'),
(14, 'Garrett', 'Trevor', 'ITT1', 'Brazil'),
(15, 'Solomon', 'Alvin', 'ITT1', 'United States'),
(16, 'Holcomb', 'Steven', 'ITT1', 'Austria'),
(17, 'Harding', 'Walter', 'ITT1', 'Russian Federation'),
(18, 'Stephens', 'Ferdinand', 'ITT1', 'Netherlands'),
(19, 'Bass', 'Chaney', 'ITT1', 'Pakistan'),
(20, 'Daniels', 'Oren', 'ITT1', 'Austria'),
(21, 'Richardson', 'Felix', 'JAT2', 'Nigeria'),
(22, 'Mcknight', 'Ivor', 'JAT2', 'Vietnam'),
(23, 'Yang', 'Grant', 'JAT2', 'China'),
(24, 'Swanson', 'Kato', 'JAT2', 'Australia'),
(25, 'Williams', 'Yoshio', 'JAT2', 'Colombia'),
(26, 'Ortega', 'Sean', 'JAT2', 'Nigeria'),
(27, 'Whitney', 'Burton', 'JAT2', 'Colombia'),
(28, 'Peters', 'Dale', 'JAT2', 'Turkey'),
(29, 'Richard', 'Bernard', 'JAT2', 'Russian Federation'),
(30, 'Hahn', 'Jack', 'JAT2', 'Spain'),
(31, 'Mooney', 'Griffith', 'JAT2', 'Brazil'),
(32, 'Welch', 'Alvin', 'JAT2', 'Germany'),
(33, 'Bowman', 'Kareem', 'JAT2', 'Austria'),
(34, 'Vance', 'Cade', 'JAT2', 'Australia'),
(35, 'Frost', 'Edan', 'JAT2', 'Indonesia'),
(36, 'Bird', 'Norman', 'JAT2', 'Austria'),
(37, 'Sharpe', 'Hall', 'JAT2', 'Poland'),
(38, 'Saunders', 'Geoffrey', 'JAT2', 'Canada'),
(39, 'Barber', 'Edward', 'JAT2', 'Netherlands'),
(40, 'Wright', 'Hector', 'JAT2', 'China'),
(41, 'Reynolds', 'Thomas', 'JAT2', 'Belgium'),
(42, 'Alexander', 'Hunter', 'JAT2', 'China'),
(43, 'Long', 'Peter', 'JAT2', 'United States'),
(44, 'Padilla', 'Nathaniel', 'JAT2', 'Nigeria'),
(45, 'Allison', 'Clarke', 'JAT2', 'Nigeria'),
(46, 'Colon', 'Yardley', 'JAT2', 'South Korea'),
(47, 'Love', 'Fulton', 'JAT2', 'Indonesia'),
(48, 'Coleman', 'Bert', 'JAT2', 'Poland'),
(49, 'Houston', 'Alan', 'JAT2', 'Poland'),
(50, 'Burgess', 'Nissim', 'JAT2', 'China'),
(51, 'Harding', 'Phillip', 'JAT2', 'Spain'),
(52, 'Barrett', 'Rajah', 'JAT2', 'Costa Rica'),
(53, 'Calhoun', 'Maxwell', 'JAT2', 'France'),
(54, 'Russell', 'Erasmus', 'JAT2', 'China'),
(55, 'Barton', 'Hyatt', 'JAT2', 'Australia'),
(56, 'Ward', 'Lucian', 'JAT2', 'South Korea'),
(57, 'Jarvis', 'Kieran', 'JAT2', 'Russian Federation'),
(58, 'Mcclain', 'Ali', 'JAT2', 'South Korea'),
(59, 'Watson', 'Keegan', 'JAT2', 'France'),
(60, 'Warren', 'Lamar', 'JAT2', 'Chile'),
(61, 'Miller', 'Xavier', 'JAT2', 'China'),
(62, 'Graham', 'Galvin', 'JAT2', 'Norway'),
(63, 'Nguyen', 'Baxter', 'JAT2', 'United States'),
(64, 'Guerrero', 'Thor', 'JAT2', 'Belgium'),
(65, 'Robinson', 'Honorato', 'JAT2', 'Netherlands'),
(66, 'Martinez', 'Laith', 'JAT2', 'Russian Federation'),
(67, 'Barker', 'Macaulay', 'JAT2', 'Spain'),
(68, 'Cox', 'Byron', 'JAT2', 'Mexico'),
(69, 'Fischer', 'Axel', 'JAT2', 'Ireland'),
(70, 'Rowland', 'Fitzgerald', 'JAT2', 'India'),
(71, 'Harrison', 'Dante', 'JAT2', 'Chile'),
(72, 'Haney', 'Ferdinand', 'JAT2', 'Russian Federation'),
(73, 'Stark', 'Cade', 'JAT2', 'Russian Federation'),
(74, 'Berg', 'Tiger', 'JAT2', 'Brazil'),
(75, 'Mayo', 'Nolan', 'JAT2', 'Poland'),
(76, 'Maldonado', 'Finn', 'JAT2', 'Norway'),
(77, 'Lawson', 'Tyler', 'JAT2', 'Peru'),
(78, 'Kramer', 'Dustin', 'JAT2', 'Canada'),
(79, 'Tyler', 'Dale', 'JAT2', 'New Zealand'),
(80, 'Conley', 'Ross', 'JAT2', 'France'),
(81, 'Hughes', 'Ray', 'JAT2', 'Germany'),
(82, 'Battle', 'Alec', 'JAT2', 'India'),
(83, 'Jacobs', 'Sylvester', 'JAT2', 'Colombia'),
(84, 'Steele', 'Brady', 'JAT2', 'Colombia'),
(85, 'Torres', 'Duncan', 'JAT2', 'Costa Rica'),
(86, 'Gardner', 'Alexander', 'JAT2', 'Colombia'),
(87, 'Herring', 'Raymond', 'JAT2', 'Ireland'),
(88, 'Allen', 'Alvin', 'JAT2', 'Vietnam'),
(89, 'Macdonald', 'Hyatt', 'JAT2', 'Brazil'),
(90, 'Osborn', 'Drew', 'JAT2', 'Peru'),
(91, 'Ruiz', 'Leonard', 'JAT2', 'Chile'),
(92, 'Fisher', 'Addison', 'JAT2', 'China'),
(93, 'Beach', 'Brady', 'JAT2', 'Indonesia'),
(94, 'Mcguire', 'Addison', 'JAT2', 'Nigeria'),
(95, 'Riggs', 'Hyatt', 'JAT2', 'Austria'),
(96, 'Hogan', 'Moses', 'JAT2', 'Vietnam'),
(97, 'Stark', 'Jermaine', 'JAT2', 'Turkey'),
(98, 'Miller', 'Quinlan', 'JAT2', 'Indonesia'),
(99, 'Pittman', 'Nigel', 'JAT2', 'Mexico'),
(100, 'Woods', 'William', 'JAT2', 'United Kingdom'),
(101, 'Brewer', 'Hasad', 'JAT2', 'Chile'),
(102, 'Woodard', 'Xenos', 'JAT2', 'United Kingdom'),
(103, 'Walsh', 'Galvin', 'JAT2', 'United States'),
(104, 'Gillespie', 'Len', 'JAT2', 'Indonesia'),
(105, 'Stewart', 'Brent', 'JAT2', 'Australia'),
(106, 'Wagner', 'Gareth', 'JAT2', 'Russian Federation'),
(107, 'Rodgers', 'Mason', 'JAT2', 'Netherlands'),
(108, 'Mccarthy', 'Amos', 'JAT2', 'Norway'),
(109, 'Lott', 'Bruno', 'JAT2', 'Netherlands'),
(110, 'Giles', 'Jared', 'JAT2', 'Pakistan'),
(111, 'Sellers', 'Garrison', 'JAT2', 'Brazil'),
(112, 'Holmes', 'Justin', 'JAT2', 'Netherlands'),
(113, 'Perkins', 'Jackson', 'JAT2', 'Pakistan'),
(114, 'Buck', 'Fritz', 'JAT2', 'China'),
(115, 'Moses', 'Sean', 'JAT2', 'Brazil'),
(116, 'Newton', 'Jacob', 'JAT2', 'Ireland'),
(117, 'Owen', 'Avram', 'JAT2', 'Mexico'),
(118, 'Mullen', 'Carter', 'JAT2', 'Netherlands'),
(119, 'Frazier', 'Caldwell', 'JAT2', 'Peru'),
(120, 'Brock', 'Graiden', 'JAT2', 'Brazil');

-- --------------------------------------------------------

--
-- Structure de la table `arbitrer`
--

DROP TABLE IF EXISTS `arbitrer`;
CREATE TABLE IF NOT EXISTS `arbitrer` (
  `matchId` int(11) NOT NULL,
  `arbitreId` int(11) NOT NULL,
  PRIMARY KEY (`matchId`,`arbitreId`),
  KEY `arbitreId` (`arbitreId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `arbitrer`
--

INSERT INTO `arbitrer` (`matchId`, `arbitreId`) VALUES
(1, 3),
(1, 21),
(1, 22),
(1, 23),
(1, 24),
(1, 25),
(1, 26),
(1, 27),
(1, 28),
(2, 1),
(2, 21),
(2, 22),
(2, 23),
(2, 24),
(2, 25),
(2, 26),
(2, 27),
(2, 28),
(3, 6),
(3, 21),
(3, 22),
(3, 23),
(3, 24),
(3, 25),
(3, 26),
(3, 27),
(3, 28),
(4, 1),
(4, 21),
(4, 22),
(4, 23),
(4, 24),
(4, 25),
(4, 26),
(4, 27),
(4, 28),
(5, 1),
(5, 21),
(5, 22),
(5, 23),
(5, 24),
(5, 25),
(5, 26),
(5, 27),
(5, 28),
(7, 1),
(7, 21),
(7, 22),
(7, 23),
(7, 24),
(7, 25),
(7, 26),
(7, 27),
(7, 28),
(8, 4),
(8, 21),
(8, 22),
(8, 23),
(8, 24),
(8, 25),
(8, 26),
(8, 27),
(8, 28),
(10, 2),
(10, 21),
(10, 22),
(10, 23),
(10, 24),
(10, 25),
(10, 26),
(10, 27),
(10, 28),
(11, 2),
(11, 21),
(11, 22),
(11, 23),
(11, 24),
(11, 25),
(11, 26),
(11, 27),
(11, 28),
(101, 4),
(129, 1),
(129, 21),
(129, 22),
(129, 23),
(129, 24),
(129, 25),
(129, 26),
(129, 27),
(129, 28),
(201, 15),
(201, 21),
(201, 22),
(201, 23),
(201, 24),
(201, 25),
(201, 26),
(201, 27),
(201, 28),
(209, 6),
(209, 21),
(209, 22),
(209, 23),
(209, 24),
(209, 25),
(209, 26),
(209, 27),
(209, 28);

-- --------------------------------------------------------

--
-- Structure de la table `billet`
--

DROP TABLE IF EXISTS `billet`;
CREATE TABLE IF NOT EXISTS `billet` (
  `billetId` int(11) NOT NULL,
  `jourId` int(11) NOT NULL,
  `courtId` int(11) NOT NULL,
  `typeBilletId` int(11) NOT NULL,
  `prix` int(11) DEFAULT NULL,
  `place` int(11) DEFAULT NULL,
  PRIMARY KEY (`billetId`),
  KEY `typeBilletId` (`typeBilletId`),
  KEY `courtId` (`courtId`),
  KEY `jourId` (`jourId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `court`
--

DROP TABLE IF EXISTS `court`;
CREATE TABLE IF NOT EXISTS `court` (
  `courtId` int(11) NOT NULL,
  `nomCourt` varchar(254) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`courtId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `court`
--

INSERT INTO `court` (`courtId`, `nomCourt`) VALUES
(1, 'Court central'),
(2, 'Court annexe 1'),
(3, 'Court annexe 2'),
(4, 'Court annexe 3');

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
CREATE TABLE IF NOT EXISTS `equipe` (
  `equipeId` int(11) NOT NULL AUTO_INCREMENT,
  `j1Id` int(11) NOT NULL,
  `j2Id` int(11) NOT NULL,
  PRIMARY KEY (`equipeId`),
  KEY `j1Id` (`j1Id`),
  KEY `j2Id` (`j2Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `equipe`
--

INSERT INTO `equipe` (`equipeId`, `j1Id`, `j2Id`) VALUES
(1, 45, 46),
(2, 47, 48),
(3, 49, 50),
(4, 51, 52),
(5, 53, 54),
(6, 55, 56),
(7, 57, 58),
(8, 59, 60),
(9, 61, 62),
(10, 63, 64),
(11, 65, 66),
(12, 67, 68),
(13, 69, 70),
(14, 71, 72),
(15, 73, 74),
(16, 75, 76);

-- --------------------------------------------------------

--
-- Structure de la table `equipederamasseur`
--

DROP TABLE IF EXISTS `equipederamasseur`;
CREATE TABLE IF NOT EXISTS `equipederamasseur` (
  `equipeRamasseursId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`equipeRamasseursId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `equipederamasseur`
--

INSERT INTO `equipederamasseur` (`equipeRamasseursId`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17);

-- --------------------------------------------------------

--
-- Structure de la table `jouer`
--

DROP TABLE IF EXISTS `jouer`;
CREATE TABLE IF NOT EXISTS `jouer` (
  `jouerId` int(11) NOT NULL AUTO_INCREMENT,
  `matchId` int(11) NOT NULL,
  `joueurId` int(11) DEFAULT NULL,
  `numEquipe` int(11) DEFAULT NULL,
  PRIMARY KEY (`jouerId`),
  KEY `matchId` (`matchId`),
  KEY `joueurId` (`joueurId`),
  KEY `numEquipe` (`numEquipe`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `jouer`
--

INSERT INTO `jouer` (`jouerId`, `matchId`, `joueurId`, `numEquipe`) VALUES
(3, 2, 3, NULL),
(4, 2, 4, NULL),
(5, 4, 6, NULL),
(6, 4, 5, NULL),
(7, 5, 8, NULL),
(8, 5, 7, NULL),
(9, 7, 10, NULL),
(10, 7, 9, NULL),
(11, 8, 12, NULL),
(12, 8, 11, NULL),
(13, 10, 14, NULL),
(14, 10, 13, NULL),
(15, 11, 16, NULL),
(16, 11, 15, NULL),
(17, 101, 17, NULL),
(18, 101, 18, NULL),
(23, 1, 1, NULL),
(24, 1, 2, NULL),
(31, 201, NULL, 6),
(32, 201, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

DROP TABLE IF EXISTS `joueur`;
CREATE TABLE IF NOT EXISTS `joueur` (
  `joueurId` int(11) NOT NULL AUTO_INCREMENT,
  `nomJoueur` varchar(254) COLLATE latin1_general_ci DEFAULT NULL,
  `prenomJoueur` varchar(254) COLLATE latin1_general_ci DEFAULT NULL,
  `nationalite` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `codeTournoi` int(11) NOT NULL,
  PRIMARY KEY (`joueurId`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `joueur`
--

INSERT INTO `joueur` (`joueurId`, `nomJoueur`, `prenomJoueur`, `nationalite`, `codeTournoi`) VALUES
(1, 'Blake', 'Colby', 'Nigeria', 1),
(2, 'Lancaster', 'Phelan', 'Peru', 1),
(3, 'Hamilton', 'Len', 'India', 1),
(4, 'Parker', 'Blake', 'Brazil', 1),
(5, 'Butler', 'Chancellor', 'Colombia', 1),
(6, 'Cunningham', 'Armand', 'Spain', 1),
(7, 'Cochran', 'Carlos', 'Sweden', 1),
(8, 'Moreno', 'Nash', 'Austria', 1),
(9, 'Nelson', 'Mark', 'Germany', 1),
(10, 'Dodson', 'Francis', 'Peru', 1),
(11, 'Lynn', 'Chaim', 'France', 1),
(12, 'Mcintosh', 'Logan', 'India', 1),
(13, 'Dennis', 'Hakeem', 'Italy', 1),
(14, 'Castillo', 'Judah', 'Ireland', 1),
(15, 'Simpson', 'Aidan', 'Mexico', 1),
(16, 'Rios', 'Leroy', 'Turkey', 1),
(17, 'Lyons', 'Damian', 'New Zealand', 2),
(18, 'Booth', 'Damon', 'Costa Rica', 2),
(19, 'Horton', 'Alan', 'Germany', 2),
(20, 'Rodgers', 'Melvin', 'Mexico', 2),
(21, 'Ross', 'Graiden', 'France', 2),
(22, 'Mayer', 'Reed', 'Vietnam', 2),
(23, 'Mccormick', 'Macon', 'Australia', 2),
(24, 'Watts', 'Griffith', 'Vietnam', 2),
(25, 'Johnson', 'Adrian', 'United Kingdom', 2),
(26, 'Stone', 'Marshall', 'Brazil', 2),
(27, 'Velez', 'Sean', 'Ireland', 2),
(28, 'Hyde', 'Hu', 'Brazil', 2),
(29, 'Pena', 'Yuli', 'Mexico', 2),
(30, 'Gaines', 'Price', 'Norway', 2),
(31, 'Santana', 'Griffith', 'Pakistan', 2),
(32, 'Dennis', 'Xavier', 'United Kingdom', 2),
(33, 'Stark', 'Fitzgerald', 'Mexico', 2),
(34, 'Hampton', 'Kennedy', 'Nigeria', 2),
(35, 'Cooley', 'Barry', 'Costa Rica', 2),
(36, 'Benjamin', 'Malcolm', 'Poland', 2),
(37, 'Flowers', 'Beck', 'Chile', 2),
(38, 'Davidson', 'Russell', 'Nigeria', 2),
(39, 'Benton', 'Keaton', 'China', 2),
(40, 'O\'Neill', 'Bernard', 'New Zealand', 2),
(41, 'Mcfarland', 'Nehru', 'Indonesia', 2),
(42, 'Richardson', 'Callum', 'Mexico', 2),
(43, 'Campbell', 'Louis', 'France', 2),
(44, 'Ross', 'Deacon', 'Germany', 2),
(45, 'Huffman', 'Patrick', 'Peru', 3),
(46, 'Bernard', 'Lee', 'India', 3),
(47, 'Buckley', 'Hyatt', 'Sweden', 3),
(48, 'Callahan', 'Elton', 'Vietnam', 3),
(49, 'Dorsey', 'Henry', 'Sweden', 3),
(50, 'Garner', 'Oscar', 'Germany', 3),
(51, 'Craft', 'Thaddeus', 'Indonesia', 3),
(52, 'Sawyer', 'Ivor', 'Peru', 3),
(53, 'Foster', 'Raphael', 'Spain', 3),
(54, 'Curry', 'Allen', 'Vietnam', 3),
(55, 'Jacobson', 'Nathaniel', 'Russian Federation', 3),
(56, 'Strickland', 'Kuame', 'Spain', 3),
(57, 'Elliott', 'Zahir', 'United States', 3),
(58, 'Rivas', 'Sebastian', 'Australia', 3),
(59, 'Snider', 'Patrick', 'Austria', 3),
(60, 'Short', 'Elvis', 'Spain', 3),
(61, 'Sears', 'Cullen', 'Indonesia', 3),
(62, 'Rivers', 'Marshall', 'South Korea', 3),
(63, 'Mack', 'Luke', 'Italy', 3),
(64, 'Mayer', 'Caldwell', 'New Zealand', 3),
(65, 'Webb', 'Lionel', 'Canada', 3),
(66, 'Mccarthy', 'Colorado', 'Costa Rica', 3),
(67, 'Hurst', 'Griffith', 'Nigeria', 3),
(68, 'Heath', 'Rahim', 'Australia', 3),
(69, 'Norton', 'Ashton', 'Russian Federation', 3),
(70, 'Lee', 'Cadman', 'China', 3),
(71, 'Munoz', 'Erich', 'Turkey', 3),
(72, 'Dejesus', 'Fuller', 'Pakistan', 3),
(73, 'Tanner', 'Alexander', 'Belgium', 3),
(74, 'Cortez', 'Griffin', 'South Korea', 3),
(75, 'Gonzalez', 'Zeph', 'India', 3),
(76, 'Allison', 'Jacob', 'Canada', 3);

-- --------------------------------------------------------

--
-- Structure de la table `jour`
--

DROP TABLE IF EXISTS `jour`;
CREATE TABLE IF NOT EXISTS `jour` (
  `jourId` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`jourId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `jour`
--

INSERT INTO `jour` (`jourId`, `date`) VALUES
(1, '2022-05-14 00:00:00'),
(2, '2022-05-15 00:00:00'),
(3, '2022-05-16 00:00:00'),
(4, '2022-05-17 00:00:00'),
(5, '2022-05-18 00:00:00'),
(6, '2022-05-19 00:00:00'),
(7, '2022-05-20 00:00:00'),
(8, '2022-05-21 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `matchs`
--

DROP TABLE IF EXISTS `matchs`;
CREATE TABLE IF NOT EXISTS `matchs` (
  `matchId` int(11) NOT NULL AUTO_INCREMENT,
  `typeTournoiId` int(11) NOT NULL,
  `courtId` int(11) DEFAULT NULL,
  `jourId` int(11) DEFAULT NULL,
  `trancheId` int(11) DEFAULT NULL,
  `matchSuivant` int(11) DEFAULT NULL,
  `gagnantId` int(11) DEFAULT NULL,
  PRIMARY KEY (`matchId`),
  KEY `fk_matchs_matchid` (`matchSuivant`),
  KEY `fk_match_gagnant` (`gagnantId`),
  KEY `typeTournoiId` (`typeTournoiId`),
  KEY `jourId` (`jourId`),
  KEY `trancheId` (`trancheId`),
  KEY `courtId` (`courtId`)
) ENGINE=InnoDB AUTO_INCREMENT=216 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `matchs`
--

INSERT INTO `matchs` (`matchId`, `typeTournoiId`, `courtId`, `jourId`, `trancheId`, `matchSuivant`, `gagnantId`) VALUES
(1, 1, 1, 1, 1, 3, NULL),
(2, 1, 1, 1, 2, 3, NULL),
(3, 1, 2, 6, 3, NULL, NULL),
(4, 1, 1, 1, 3, 6, NULL),
(5, 1, 1, 1, 4, 6, NULL),
(6, 1, NULL, NULL, NULL, NULL, NULL),
(7, 1, 2, 1, 1, 9, NULL),
(8, 1, 2, 1, 2, 9, NULL),
(9, 1, NULL, NULL, NULL, NULL, NULL),
(10, 1, 2, 1, 3, 12, NULL),
(11, 1, 2, 1, 4, 12, NULL),
(12, 1, NULL, NULL, NULL, NULL, NULL),
(101, 2, 1, 3, 1, 117, NULL),
(102, 2, NULL, NULL, NULL, 117, NULL),
(103, 2, NULL, NULL, NULL, 118, NULL),
(104, 2, NULL, NULL, NULL, 118, NULL),
(105, 2, NULL, NULL, NULL, 119, NULL),
(106, 2, NULL, NULL, NULL, 119, NULL),
(107, 2, NULL, NULL, NULL, 120, NULL),
(108, 2, NULL, NULL, NULL, 120, NULL),
(109, 2, NULL, NULL, NULL, 121, NULL),
(110, 2, NULL, NULL, NULL, 121, NULL),
(111, 2, NULL, NULL, NULL, 122, NULL),
(112, 2, NULL, NULL, NULL, 122, NULL),
(113, 2, NULL, NULL, NULL, 123, NULL),
(114, 2, NULL, NULL, NULL, 123, NULL),
(115, 2, NULL, NULL, NULL, 124, NULL),
(116, 2, NULL, NULL, NULL, 124, NULL),
(117, 2, NULL, NULL, NULL, 125, NULL),
(118, 2, NULL, NULL, NULL, 125, NULL),
(119, 2, NULL, NULL, NULL, 126, NULL),
(120, 2, NULL, NULL, NULL, 126, NULL),
(121, 2, NULL, NULL, NULL, 127, NULL),
(122, 2, NULL, NULL, NULL, 127, NULL),
(123, 2, NULL, NULL, NULL, 128, NULL),
(124, 2, NULL, NULL, NULL, 128, NULL),
(125, 2, NULL, NULL, NULL, 129, NULL),
(126, 2, NULL, NULL, NULL, 129, NULL),
(127, 2, NULL, NULL, NULL, 130, NULL),
(128, 2, NULL, NULL, NULL, 130, NULL),
(129, 2, 1, 5, 1, 131, NULL),
(130, 2, NULL, NULL, NULL, 131, NULL),
(131, 2, NULL, NULL, NULL, NULL, NULL),
(201, 3, 4, 1, 1, 209, NULL),
(202, 3, NULL, NULL, NULL, 209, NULL),
(203, 3, NULL, NULL, NULL, 210, NULL),
(204, 3, NULL, NULL, NULL, 210, NULL),
(205, 3, NULL, NULL, NULL, 211, NULL),
(206, 3, NULL, NULL, NULL, 211, NULL),
(207, 3, NULL, NULL, NULL, 212, NULL),
(208, 3, NULL, NULL, NULL, 212, NULL),
(209, 3, 2, 5, 3, 213, NULL),
(210, 3, NULL, NULL, NULL, 213, NULL),
(211, 3, NULL, NULL, NULL, 214, NULL),
(212, 3, NULL, NULL, NULL, 214, NULL),
(213, 3, NULL, NULL, NULL, 215, NULL),
(214, 3, NULL, NULL, NULL, 215, NULL),
(215, 3, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `ramasser`
--

DROP TABLE IF EXISTS `ramasser`;
CREATE TABLE IF NOT EXISTS `ramasser` (
  `equipeRamasseursId` int(11) NOT NULL,
  `matchId` int(11) NOT NULL,
  PRIMARY KEY (`equipeRamasseursId`,`matchId`),
  KEY `matchId` (`matchId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `ramasser`
--

INSERT INTO `ramasser` (`equipeRamasseursId`, `matchId`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 7),
(1, 8),
(1, 10),
(1, 11),
(1, 129),
(1, 201),
(1, 209),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 7),
(2, 8),
(2, 10),
(2, 11),
(2, 129),
(2, 201),
(2, 209);

-- --------------------------------------------------------

--
-- Structure de la table `ramasseursdeballes`
--

DROP TABLE IF EXISTS `ramasseursdeballes`;
CREATE TABLE IF NOT EXISTS `ramasseursdeballes` (
  `ramasseurBalleId` int(11) NOT NULL AUTO_INCREMENT,
  `nomRamasseur` varchar(254) COLLATE latin1_general_ci DEFAULT NULL,
  `prenomRamasseur` varchar(254) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`ramasseurBalleId`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `ramasseursdeballes`
--

INSERT INTO `ramasseursdeballes` (`ramasseurBalleId`, `nomRamasseur`, `prenomRamasseur`) VALUES
(1, 'Simon', 'Sylvester'),
(2, 'Reese', 'Dieter'),
(3, 'Cross', 'Justin'),
(4, 'Carney', 'Yardley'),
(5, 'Vaughan', 'Chadwick'),
(6, 'Townsend', 'Cedric'),
(7, 'Kramer', 'Aquila'),
(8, 'Wright', 'Emmanuel'),
(9, 'Hendrix', 'Elliott'),
(10, 'Melendez', 'Keaton'),
(11, 'Cash', 'Neil'),
(12, 'Parsons', 'Aaron'),
(13, 'Lindsay', 'Emerson'),
(14, 'Larsen', 'Oren'),
(15, 'Romero', 'Beck'),
(16, 'Mcbride', 'Emmanuel'),
(17, 'Pollard', 'Wang'),
(18, 'Adkins', 'Ezra'),
(19, 'Levine', 'Hoyt'),
(20, 'Padilla', 'Eagan'),
(21, 'Forbes', 'Byron'),
(22, 'Lancaster', 'Myles'),
(23, 'Fitzpatrick', 'Vincent'),
(24, 'Yang', 'Kadeem'),
(25, 'Fitzgerald', 'Craig'),
(26, 'Craft', 'Perry'),
(27, 'Barnes', 'Knox'),
(28, 'Mosley', 'Basil'),
(29, 'Stuart', 'Thaddeus'),
(30, 'Lester', 'Hector'),
(31, 'Gutierrez', 'Steven'),
(32, 'Durham', 'Hyatt'),
(33, 'Bates', 'Judah'),
(34, 'Randolph', 'Simon'),
(35, 'Marquez', 'Oliver'),
(36, 'Roberson', 'Mannix'),
(37, 'Leonard', 'Zephania'),
(38, 'Wynn', 'Bruno'),
(39, 'Neal', 'Evan'),
(40, 'Blanchard', 'Eric'),
(41, 'Fox', 'Gareth'),
(42, 'Henderson', 'Cyrus'),
(43, 'Justice', 'Leo'),
(44, 'Castro', 'Baker'),
(45, 'Kane', 'Macaulay'),
(46, 'Michael', 'Rashad'),
(47, 'Webb', 'Adam'),
(48, 'Wilson', 'Kennedy'),
(49, 'Doyle', 'Hedley'),
(50, 'Mclean', 'Hamilton'),
(51, 'Santos', 'Orson'),
(52, 'Vargas', 'Joshua'),
(53, 'Taylor', 'Jarrod'),
(54, 'Lawrence', 'Odysseus'),
(55, 'Cummings', 'Porter'),
(56, 'Crawford', 'Ronan'),
(57, 'Velazquez', 'Fletcher'),
(58, 'Frost', 'Kirk'),
(59, 'Parker', 'Ferris'),
(60, 'Kelley', 'Francis'),
(61, 'Patel', 'Bradley'),
(62, 'Dixon', 'Nash'),
(63, 'Rivas', 'Gregory'),
(64, 'Vasquez', 'Burke'),
(65, 'Galloway', 'Davis'),
(66, 'Kline', 'Kenyon'),
(67, 'Brock', 'Ahmed'),
(68, 'Dickerson', 'Lee'),
(69, 'Cross', 'Lane'),
(70, 'Jefferson', 'Kennedy'),
(71, 'Bullock', 'Shad'),
(72, 'Decker', 'Scott'),
(73, 'Pena', 'Kasimir'),
(74, 'Wells', 'Troy'),
(75, 'England', 'Leo'),
(76, 'Whitaker', 'Tucker'),
(77, 'Jarvis', 'Driscoll'),
(78, 'Witt', 'Cyrus'),
(79, 'Austin', 'Grant'),
(80, 'Moody', 'Gray'),
(81, 'Bennett', 'Jordan'),
(82, 'Lawrence', 'Amir'),
(83, 'Mendez', 'Brent'),
(84, 'Byers', 'Theodore'),
(85, 'Barnes', 'Colton'),
(86, 'Burns', 'Carl'),
(87, 'Richard', 'Steven'),
(88, 'Herrera', 'Ivan'),
(89, 'Guerra', 'Thane'),
(90, 'Dejesus', 'Herman'),
(91, 'Weber', 'Jermaine'),
(92, 'Rasmussen', 'Lee'),
(93, 'Hampton', 'Eric'),
(94, 'Melendez', 'Jordan'),
(95, 'Henry', 'Hammett'),
(96, 'Garrison', 'Dylan'),
(97, 'Henry', 'Colt'),
(98, 'Spears', 'Ivan'),
(99, 'Patton', 'Lewis'),
(100, 'Lyons', 'Hoyt'),
(101, 'Burris', 'Bruce'),
(102, 'Sloan', 'Ahmed');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `reservationId` int(11) NOT NULL AUTO_INCREMENT,
  `courtId` int(11) NOT NULL,
  `jourId` int(11) NOT NULL,
  `trancheId` int(11) NOT NULL,
  `nomJoueur` varchar(255) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`reservationId`),
  KEY `jourId` (`jourId`),
  KEY `courtId` (`courtId`),
  KEY `trancheId` (`trancheId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`reservationId`, `courtId`, `jourId`, `trancheId`, `nomJoueur`) VALUES
(1, 3, 1, 1, 'Federer'),
(2, 3, 1, 2, 'fabrice'),
(8, 1, 1, 2, 'alexandre');

-- --------------------------------------------------------

--
-- Structure de la table `tranchehoraire`
--

DROP TABLE IF EXISTS `tranchehoraire`;
CREATE TABLE IF NOT EXISTS `tranchehoraire` (
  `trancheId` int(11) NOT NULL,
  `heureDebut` int(11) DEFAULT NULL,
  PRIMARY KEY (`trancheId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `tranchehoraire`
--

INSERT INTO `tranchehoraire` (`trancheId`, `heureDebut`) VALUES
(1, 10),
(2, 12),
(3, 14),
(4, 16);

-- --------------------------------------------------------

--
-- Structure de la table `typebillet`
--

DROP TABLE IF EXISTS `typebillet`;
CREATE TABLE IF NOT EXISTS `typebillet` (
  `typeBilletId` int(11) NOT NULL,
  `nomType` varchar(254) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`typeBilletId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `typedetournoi`
--

DROP TABLE IF EXISTS `typedetournoi`;
CREATE TABLE IF NOT EXISTS `typedetournoi` (
  `typeTournoiId` int(11) NOT NULL,
  `nomTournoi` varchar(254) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`typeTournoiId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `typedetournoi`
--

INSERT INTO `typedetournoi` (`typeTournoiId`, `nomTournoi`) VALUES
(1, 'Qualification'),
(2, 'Simple'),
(3, 'Double');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appartenir`
--
ALTER TABLE `appartenir`
  ADD CONSTRAINT `appartenir_ibfk_1` FOREIGN KEY (`ramasseurBalleId`) REFERENCES `ramasseursdeballes` (`ramasseurBalleId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `appartenir_ibfk_2` FOREIGN KEY (`equipeRamasseursId`) REFERENCES `equipederamasseur` (`equipeRamasseursId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `arbitrer`
--
ALTER TABLE `arbitrer`
  ADD CONSTRAINT `arbitrer_ibfk_1` FOREIGN KEY (`arbitreId`) REFERENCES `arbitre` (`arbitreId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `arbitrer_ibfk_2` FOREIGN KEY (`matchId`) REFERENCES `matchs` (`matchId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `billet`
--
ALTER TABLE `billet`
  ADD CONSTRAINT `billet_ibfk_1` FOREIGN KEY (`typeBilletId`) REFERENCES `typebillet` (`typeBilletId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `billet_ibfk_2` FOREIGN KEY (`courtId`) REFERENCES `court` (`courtId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `billet_ibfk_3` FOREIGN KEY (`jourId`) REFERENCES `jour` (`jourId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `equipe_ibfk_1` FOREIGN KEY (`j1Id`) REFERENCES `joueur` (`joueurId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `equipe_ibfk_2` FOREIGN KEY (`j2Id`) REFERENCES `joueur` (`joueurId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `jouer`
--
ALTER TABLE `jouer`
  ADD CONSTRAINT `jouer_ibfk_1` FOREIGN KEY (`matchId`) REFERENCES `matchs` (`matchId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jouer_ibfk_2` FOREIGN KEY (`joueurId`) REFERENCES `joueur` (`joueurId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jouer_ibfk_3` FOREIGN KEY (`numEquipe`) REFERENCES `equipe` (`equipeId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `matchs`
--
ALTER TABLE `matchs`
  ADD CONSTRAINT `matchs_ibfk_1` FOREIGN KEY (`typeTournoiId`) REFERENCES `typedetournoi` (`typeTournoiId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `matchs_ibfk_2` FOREIGN KEY (`jourId`) REFERENCES `jour` (`jourId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `matchs_ibfk_3` FOREIGN KEY (`trancheId`) REFERENCES `tranchehoraire` (`trancheId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `matchs_ibfk_4` FOREIGN KEY (`courtId`) REFERENCES `court` (`courtId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `ramasser`
--
ALTER TABLE `ramasser`
  ADD CONSTRAINT `ramasser_ibfk_1` FOREIGN KEY (`equipeRamasseursId`) REFERENCES `equipederamasseur` (`equipeRamasseursId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ramasser_ibfk_2` FOREIGN KEY (`matchId`) REFERENCES `matchs` (`matchId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`jourId`) REFERENCES `jour` (`jourId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`courtId`) REFERENCES `court` (`courtId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`trancheId`) REFERENCES `tranchehoraire` (`trancheId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
