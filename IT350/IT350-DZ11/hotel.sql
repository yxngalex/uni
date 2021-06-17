-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2020 at 12:11 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `gost`
--

CREATE TABLE `gost` (
  `ime` char(25) NOT NULL,
  `prezime` char(25) NOT NULL,
  `jmbg` char(25) NOT NULL,
  `adresa` char(25) NOT NULL,
  `telefon` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gost`
--

INSERT INTO `gost` (`ime`, `prezime`, `jmbg`, `adresa`, `telefon`) VALUES
('Aleksa', 'Cekic', '0808999123456', 'Gornja Toponica', '0648592356');

-- --------------------------------------------------------

--
-- Table structure for table `odeljenje`
--

CREATE TABLE `odeljenje` (
  `ime` char(255) NOT NULL,
  `mesto` char(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `odeljenje`
--

INSERT INTO `odeljenje` (`ime`, `mesto`) VALUES
('Nisavski', 'Nis');

-- --------------------------------------------------------

--
-- Table structure for table `priprema_sobe`
--

CREATE TABLE `priprema_sobe` (
  `broj_sobe` int(10) NOT NULL,
  `zaposleni_ime` char(26) NOT NULL,
  `datum` date NOT NULL,
  `id_pripreme` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `priprema_sobe`
--

INSERT INTO `priprema_sobe` (`broj_sobe`, `zaposleni_ime`, `datum`, `id_pripreme`) VALUES
(1, 'Stefan', '0000-00-00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija_sobe`
--

CREATE TABLE `rezervacija_sobe` (
  `imeGosta` char(25) NOT NULL,
  `brojSOBE` int(10) NOT NULL,
  `datumOd` date NOT NULL,
  `datumDo` date NOT NULL,
  `id_rezervacije` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervacija_sobe`
--

INSERT INTO `rezervacija_sobe` (`imeGosta`, `brojSOBE`, `datumOd`, `datumDo`, `id_rezervacije`) VALUES
('Aleksa', 1, '0000-00-00', '0000-00-00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sef`
--

CREATE TABLE `sef` (
  `imeSefa` varchar(255) NOT NULL,
  `odeljenjeSefa` char(255) NOT NULL,
  `sobaSefa` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `soba`
--

CREATE TABLE `soba` (
  `broj` int(10) NOT NULL,
  `opis` char(255) NOT NULL,
  `slika` char(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`broj`, `opis`, `slika`) VALUES
(1, 'Plava soba', 'www.1234123.com');

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE `zaposleni` (
  `ime` char(25) NOT NULL,
  `prezime` char(25) NOT NULL,
  `jmbg` char(13) NOT NULL,
  `adresa` char(25) NOT NULL,
  `telefon` char(25) NOT NULL,
  `odeljenje_ime` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`ime`, `prezime`, `jmbg`, `adresa`, `telefon`, `odeljenje_ime`) VALUES
('Stefan', 'Gogic', '1234567890123', 'Pantelej, Nis', '0640282345', 'Nisavski');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gost`
--
ALTER TABLE `gost`
  ADD PRIMARY KEY (`ime`);

--
-- Indexes for table `odeljenje`
--
ALTER TABLE `odeljenje`
  ADD PRIMARY KEY (`ime`);

--
-- Indexes for table `priprema_sobe`
--
ALTER TABLE `priprema_sobe`
  ADD PRIMARY KEY (`id_pripreme`),
  ADD KEY `BROJ_SOBE_FK` (`broj_sobe`),
  ADD KEY `ZAPOSLENI_IME_FK` (`zaposleni_ime`);

--
-- Indexes for table `rezervacija_sobe`
--
ALTER TABLE `rezervacija_sobe`
  ADD PRIMARY KEY (`id_rezervacije`),
  ADD KEY `imeGosta_FK` (`imeGosta`),
  ADD KEY `brojSobe_FK` (`brojSOBE`);

--
-- Indexes for table `soba`
--
ALTER TABLE `soba`
  ADD PRIMARY KEY (`broj`);

--
-- Indexes for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD PRIMARY KEY (`ime`),
  ADD KEY `ODELJENJE_FK` (`odeljenje_ime`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `priprema_sobe`
--
ALTER TABLE `priprema_sobe`
  ADD CONSTRAINT `BROJ_SOBE_FK` FOREIGN KEY (`broj_sobe`) REFERENCES `soba` (`broj`),
  ADD CONSTRAINT `ZAPOSLENI_IME_FK` FOREIGN KEY (`zaposleni_ime`) REFERENCES `zaposleni` (`ime`);

--
-- Constraints for table `rezervacija_sobe`
--
ALTER TABLE `rezervacija_sobe`
  ADD CONSTRAINT `brojSobe_FK` FOREIGN KEY (`brojSOBE`) REFERENCES `soba` (`broj`),
  ADD CONSTRAINT `imeGosta_FK` FOREIGN KEY (`imeGosta`) REFERENCES `gost` (`ime`);

--
-- Constraints for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD CONSTRAINT `ODELJENJE_FK` FOREIGN KEY (`odeljenje_ime`) REFERENCES `odeljenje` (`ime`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
