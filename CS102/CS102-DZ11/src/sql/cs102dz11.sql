-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2020 at 07:42 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cs102dz11`
--

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

CREATE TABLE `predmet` (
  `id` int(10) NOT NULL,
  `sifra_predmeta` varchar(255) NOT NULL,
  `naziv_predmeta` varchar(255) NOT NULL,
  `id_profesora` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`id`, `sifra_predmeta`, `naziv_predmeta`, `id_profesora`) VALUES
(23, 'CD456', 'Informacione Tehnologije', 27),
(24, 'AAA34', 'Diskretne Strukture', 31),
(26, 'CS122', 'Programiranje u mrezi', 31),
(27, 'CS122', 'Programiranje u mrezi', 27),
(29, 'CS105', 'Programiranje', 31),
(30, 'NT112', 'Engleski 2', 25);

-- --------------------------------------------------------

--
-- Table structure for table `profesor`
--

CREATE TABLE `profesor` (
  `id` int(10) NOT NULL,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `godina_izbora_u_zvanje` int(4) NOT NULL,
  `naslov_doktorata` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `profesor`
--

INSERT INTO `profesor` (`id`, `ime`, `prezime`, `godina_izbora_u_zvanje`, `naslov_doktorata`) VALUES
(25, 'Marko', 'Milisevic', 2005, 'Informacioni Sistemi'),
(26, 'Greg', 'Pantovic', 2012, 'Programer'),
(27, 'Mihailo', 'Cekic', 1995, 'Diskretne Strukture'),
(30, 'Patricija', 'Perovic', 1992, 'Racunarske Mreze'),
(31, 'Aleksa', 'Cekic', 2020, 'Softversko inzinjerstvo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `predmet`
--
ALTER TABLE `predmet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `profesor_fk` (`id_profesora`);

--
-- Indexes for table `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uniP` (`ime`,`prezime`,`godina_izbora_u_zvanje`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `predmet`
--
ALTER TABLE `predmet`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `profesor`
--
ALTER TABLE `profesor`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
