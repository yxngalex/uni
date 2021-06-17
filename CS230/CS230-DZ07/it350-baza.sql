-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2021 at 11:02 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `it350-baza`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `ID_KORISNIKA` int(11) NOT NULL,
  `ID_ADMINISTARTORA` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`ID_KORISNIKA`, `ID_ADMINISTARTORA`, `created_date`, `last_modified_date`, `last_modified_by`, `record_status`) VALUES
(1, 1, '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1);

-- --------------------------------------------------------

--
-- Table structure for table `fajlovi`
--

CREATE TABLE `fajlovi` (
  `ID_FAJLA` int(11) NOT NULL,
  `ID_RADNIKA` int(11) NOT NULL,
  `TIP_FAJLA` text DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fajlovi`
--

INSERT INTO `fajlovi` (`ID_FAJLA`, `ID_RADNIKA`, `TIP_FAJLA`, `created_date`, `last_modified_date`, `last_modified_by`, `record_status`) VALUES
(1, 1, 'Test', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `ID_KORISNIKA` int(11) NOT NULL,
  `ime` varchar(16) NOT NULL,
  `prezime` varchar(16) NOT NULL,
  `godine` varchar(16) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`ID_KORISNIKA`, `ime`, `prezime`, `godine`, `created_date`, `last_modified_date`, `last_modified_by`, `record_status`) VALUES
(1, 'Greg', 'Tosic', '20', '2021-01-10 02:15:39', '2021-01-10 02:15:39', 'system', 1),
(2, 'Marko', 'Miletic', '19', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1),
(3, 'Stefan', 'Gogic', '19', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1),
(4, 'Aleksa', 'Cekic', '21', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1),
(5, 'Igor', 'Markovic', '31', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1),
(6, 'Andrija', 'Radojevic', '43', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1),
(7, 'Petar', 'Ivkovic', '55', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1),
(8, 'Marko', 'Gorisek', '21', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1),
(9, 'Milan', 'Velickovic', '21', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1),
(10, 'Nikola', 'Popovic', '20', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1),
(11, 'Jovan', 'Petkovic', '43', '2021-01-08 15:48:15', '2021-01-08 15:48:15', 'system', 1),
(12, 'Test', 'Testic', '23', '2021-01-09 16:53:04', '2021-01-09 16:53:04', 'system', 1),
(13, 'Testovar', 'Testovski', '54', '2021-01-09 16:54:36', '2021-01-09 16:54:36', 'system', 1),
(14, 'Nenad', 'Trifunovic', '37', '2021-01-09 17:02:30', '2021-01-09 17:02:30', 'system', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ocena`
--

CREATE TABLE `ocena` (
  `ID_OCENE` int(11) NOT NULL,
  `ID_POSLA` int(11) NOT NULL,
  `ID_RADNIKA` int(11) NOT NULL,
  `OCENA` int(11) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ocena`
--

INSERT INTO `ocena` (`ID_OCENE`, `ID_POSLA`, `ID_RADNIKA`, `OCENA`, `created_date`, `last_modified_date`, `last_modified_by`, `record_status`) VALUES
(1, 1, 1, 5, '2021-01-08 15:48:16', '2021-01-08 15:48:16', 'system', 1),
(2, 6, 6, 10, '2021-01-08 15:48:16', '2021-01-08 15:48:16', 'system', 1),
(3, 5, 8, 9, '2021-01-08 15:48:16', '2021-01-08 15:48:16', 'system', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ponuda`
--

CREATE TABLE `ponuda` (
  `KRATAKOPIS` text DEFAULT NULL,
  `ID_PONUDE` int(11) NOT NULL,
  `ID_POSLA` int(11) NOT NULL,
  `PREDLOZENACENA` decimal(10,0) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ponuda`
--

INSERT INTO `ponuda` (`KRATAKOPIS`, `ID_PONUDE`, `ID_POSLA`, `PREDLOZENACENA`, `created_date`, `last_modified_date`, `last_modified_by`, `record_status`) VALUES
('Test test test', 1, 1, '400', '2021-01-08 15:48:16', '2021-01-08 15:48:16', 'system', 1);

-- --------------------------------------------------------

--
-- Table structure for table `poruka`
--

CREATE TABLE `poruka` (
  `ID_PORUKE` int(11) NOT NULL,
  `PORUKA` text DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `poruka`
--

INSERT INTO `poruka` (`ID_PORUKE`, `PORUKA`, `created_date`, `last_modified_date`, `last_modified_by`, `record_status`) VALUES
(1, 'Test', '2021-01-08 15:48:16', '2021-01-08 15:48:16', 'system', 1),
(2, 'Dobar dan, testing.', '2021-01-08 15:48:16', '2021-01-08 15:48:16', 'system', 1);

-- --------------------------------------------------------

--
-- Table structure for table `poslodavac`
--

CREATE TABLE `poslodavac` (
  `ID_KORISNIKA` int(11) NOT NULL,
  `ID_POSLODAVCA` int(11) NOT NULL,
  `ID_PORUKE` int(11) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `poslodavac`
--

INSERT INTO `poslodavac` (`ID_KORISNIKA`, `ID_POSLODAVCA`, `ID_PORUKE`, `created_date`, `last_modified_date`, `last_modified_by`, `record_status`) VALUES
(3, 1, NULL, '2021-01-08 15:48:16', '2021-01-08 15:48:16', 'system', 1),
(4, 2, 1, '2021-01-08 15:48:16', '2021-01-08 15:48:16', 'system', 1),
(5, 3, 2, '2021-01-08 15:48:16', '2021-01-08 15:48:16', 'system', 1),
(6, 4, 2, '2021-01-08 15:48:16', '2021-01-08 15:48:16', 'system', 1);

-- --------------------------------------------------------

--
-- Table structure for table `poslovi`
--

CREATE TABLE `poslovi` (
  `ID_POSLA` int(11) NOT NULL,
  `ID_POSLODAVCA` int(11) NOT NULL,
  `NAZIV` varchar(16) DEFAULT NULL,
  `OPIS` varchar(255) DEFAULT NULL,
  `MAKS_BUDZET` decimal(10,0) DEFAULT NULL,
  `DUZINA_TRAJANJA` int(11) DEFAULT NULL,
  `BROJ_POTREBNIH_RADNIKA` int(11) DEFAULT NULL,
  `KLJUCNA_REC` varchar(16) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `poslovi`
--

INSERT INTO `poslovi` (`ID_POSLA`, `ID_POSLODAVCA`, `NAZIV`, `OPIS`, `MAKS_BUDZET`, `DUZINA_TRAJANJA`, `BROJ_POTREBNIH_RADNIKA`, `KLJUCNA_REC`, `created_date`, `last_modified_date`, `last_modified_by`, `record_status`) VALUES
(1, 1, 'Test', 'Test, test, test.', '200', 4, 3, 'RADOVI_U_TOKU', '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(2, 1, 'Gradjevina', 'Gradjevina u Nisu.', '5000000', 12, 120, 'Aktivan', '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(3, 2, 'Gradjevina', 'Gradnja Ambasador hotela u Nisu.', '40000', 5, 30, 'Aktivan', '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(4, 1, 'Game Development', 'Izrada video igara.', '50000', 6, 5, 'Aktivan', '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(5, 3, 'Profesor', 'Treba nam profesor na univerzitetu Metropolitan u Nisu. \r\nZnanje neophodno za ovaj posao je znanje programiranja u Javi.', '400', 24, 1, 'Pregovor', '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(6, 4, 'IT strucnjak', 'IT strucnjak u odrzavanju sistema.', '1500', 6, 3, 'Zavrsen', '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1);

-- --------------------------------------------------------

--
-- Table structure for table `radnik`
--

CREATE TABLE `radnik` (
  `ID_KORISNIKA` int(11) NOT NULL,
  `ID_RADNIKA` int(11) NOT NULL,
  `RAD_ID_RADNIKA` int(11) DEFAULT NULL,
  `ID_PONUDE` int(11) NOT NULL,
  `ID_POSLA` int(11) DEFAULT NULL,
  `ID_PORUKE` int(11) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `radnik`
--

INSERT INTO `radnik` (`ID_KORISNIKA`, `ID_RADNIKA`, `RAD_ID_RADNIKA`, `ID_PONUDE`, `ID_POSLA`, `ID_PORUKE`, `created_date`, `last_modified_date`, `last_modified_by`, `record_status`) VALUES
(2, 1, NULL, 1, 1, NULL, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(9, 2, NULL, 1, 6, 2, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(8, 3, 2, 1, 6, 2, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(10, 4, 2, 1, 6, 2, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(7, 5, 2, 1, 6, 2, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(6, 6, NULL, 1, 3, 2, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(11, 8, NULL, 1, NULL, NULL, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1);

-- --------------------------------------------------------

--
-- Table structure for table `zarada`
--

CREATE TABLE `zarada` (
  `ID_ZARADE` int(11) NOT NULL,
  `ID_RADNIKA` int(11) NOT NULL,
  `VREDNOST` decimal(10,0) NOT NULL,
  `MESEC` int(2) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `zarada`
--

INSERT INTO `zarada` (`ID_ZARADE`, `ID_RADNIKA`, `VREDNOST`, `MESEC`, `created_date`, `last_modified_date`, `last_modified_by`, `record_status`) VALUES
(8, 4, '4800', 2, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(9, 2, '2600', 3, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(10, 5, '3500', 1, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(11, 5, '2751', 3, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(12, 3, '5000', 11, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(13, 6, '3000', 9, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(14, 8, '4500', 8, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(15, 1, '6600', 12, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(16, 4, '5000', 1, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1),
(17, 6, '7000', 3, '2021-01-08 15:48:17', '2021-01-08 15:48:17', 'system', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`ID_ADMINISTARTORA`),
  ADD KEY `FK_PRIPADAJU3` (`ID_KORISNIKA`);

--
-- Indexes for table `fajlovi`
--
ALTER TABLE `fajlovi`
  ADD PRIMARY KEY (`ID_FAJLA`),
  ADD KEY `FK_UPLOADUJE` (`ID_RADNIKA`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`ID_KORISNIKA`);

--
-- Indexes for table `ocena`
--
ALTER TABLE `ocena`
  ADD PRIMARY KEY (`ID_OCENE`),
  ADD KEY `FK_RELATIONSHIP_6` (`ID_POSLA`),
  ADD KEY `FK_RELATIONSHIP_7` (`ID_RADNIKA`);

--
-- Indexes for table `ponuda`
--
ALTER TABLE `ponuda`
  ADD PRIMARY KEY (`ID_PONUDE`),
  ADD KEY `FK_IMA` (`ID_POSLA`);

--
-- Indexes for table `poruka`
--
ALTER TABLE `poruka`
  ADD PRIMARY KEY (`ID_PORUKE`);

--
-- Indexes for table `poslodavac`
--
ALTER TABLE `poslodavac`
  ADD PRIMARY KEY (`ID_POSLODAVCA`),
  ADD KEY `FK_PRIPADAJU2` (`ID_KORISNIKA`),
  ADD KEY `FK_SALJE_PRIMA` (`ID_PORUKE`);

--
-- Indexes for table `poslovi`
--
ALTER TABLE `poslovi`
  ADD PRIMARY KEY (`ID_POSLA`),
  ADD KEY `FK_KREIRA` (`ID_POSLODAVCA`);

--
-- Indexes for table `radnik`
--
ALTER TABLE `radnik`
  ADD PRIMARY KEY (`ID_RADNIKA`),
  ADD KEY `FK_ANGAZOVANJE` (`ID_POSLA`),
  ADD KEY `FK_POSTAVLJA` (`ID_PONUDE`),
  ADD KEY `FK_PRIMA_SALJE` (`ID_PORUKE`),
  ADD KEY `FK_PRIPADAJU` (`ID_KORISNIKA`),
  ADD KEY `FK_VODJA_TIMA` (`RAD_ID_RADNIKA`);

--
-- Indexes for table `zarada`
--
ALTER TABLE `zarada`
  ADD PRIMARY KEY (`ID_ZARADE`),
  ADD KEY `FK_ZARADJUJE` (`ID_RADNIKA`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrator`
--
ALTER TABLE `administrator`
  MODIFY `ID_ADMINISTARTORA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `fajlovi`
--
ALTER TABLE `fajlovi`
  MODIFY `ID_FAJLA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `ID_KORISNIKA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `ocena`
--
ALTER TABLE `ocena`
  MODIFY `ID_OCENE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `ponuda`
--
ALTER TABLE `ponuda`
  MODIFY `ID_PONUDE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `poruka`
--
ALTER TABLE `poruka`
  MODIFY `ID_PORUKE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `poslodavac`
--
ALTER TABLE `poslodavac`
  MODIFY `ID_POSLODAVCA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `poslovi`
--
ALTER TABLE `poslovi`
  MODIFY `ID_POSLA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `radnik`
--
ALTER TABLE `radnik`
  MODIFY `ID_RADNIKA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `zarada`
--
ALTER TABLE `zarada`
  MODIFY `ID_ZARADE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `FK_PRIPADAJU3` FOREIGN KEY (`ID_KORISNIKA`) REFERENCES `korisnik` (`ID_KORISNIKA`);

--
-- Constraints for table `fajlovi`
--
ALTER TABLE `fajlovi`
  ADD CONSTRAINT `FK_UPLOADUJE` FOREIGN KEY (`ID_RADNIKA`) REFERENCES `radnik` (`ID_RADNIKA`);

--
-- Constraints for table `ocena`
--
ALTER TABLE `ocena`
  ADD CONSTRAINT `FK_RELATIONSHIP_6` FOREIGN KEY (`ID_POSLA`) REFERENCES `poslovi` (`ID_POSLA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`ID_RADNIKA`) REFERENCES `radnik` (`ID_RADNIKA`);

--
-- Constraints for table `ponuda`
--
ALTER TABLE `ponuda`
  ADD CONSTRAINT `FK_IMA` FOREIGN KEY (`ID_POSLA`) REFERENCES `poslovi` (`ID_POSLA`);

--
-- Constraints for table `poslodavac`
--
ALTER TABLE `poslodavac`
  ADD CONSTRAINT `FK_PRIPADAJU2` FOREIGN KEY (`ID_KORISNIKA`) REFERENCES `korisnik` (`ID_KORISNIKA`),
  ADD CONSTRAINT `FK_SALJE_PRIMA` FOREIGN KEY (`ID_PORUKE`) REFERENCES `poruka` (`ID_PORUKE`);

--
-- Constraints for table `poslovi`
--
ALTER TABLE `poslovi`
  ADD CONSTRAINT `FK_KREIRA` FOREIGN KEY (`ID_POSLODAVCA`) REFERENCES `poslodavac` (`ID_POSLODAVCA`);

--
-- Constraints for table `radnik`
--
ALTER TABLE `radnik`
  ADD CONSTRAINT `FK_ANGAZOVANJE` FOREIGN KEY (`ID_POSLA`) REFERENCES `poslovi` (`ID_POSLA`),
  ADD CONSTRAINT `FK_POSTAVLJA` FOREIGN KEY (`ID_PONUDE`) REFERENCES `ponuda` (`ID_PONUDE`),
  ADD CONSTRAINT `FK_PRIMA_SALJE` FOREIGN KEY (`ID_PORUKE`) REFERENCES `poruka` (`ID_PORUKE`),
  ADD CONSTRAINT `FK_PRIPADAJU` FOREIGN KEY (`ID_KORISNIKA`) REFERENCES `korisnik` (`ID_KORISNIKA`),
  ADD CONSTRAINT `FK_VODJA_TIMA` FOREIGN KEY (`RAD_ID_RADNIKA`) REFERENCES `radnik` (`ID_RADNIKA`);

--
-- Constraints for table `zarada`
--
ALTER TABLE `zarada`
  ADD CONSTRAINT `FK_ZARADJUJE` FOREIGN KEY (`ID_RADNIKA`) REFERENCES `radnik` (`ID_RADNIKA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
