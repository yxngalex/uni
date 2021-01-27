-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2020 at 12:35 AM
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
-- Database: `it210-projekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `textarea` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id`, `firstname`, `lastname`, `email`, `subject`, `textarea`) VALUES
(1, 'Mark', 'Kjellberg', 'pewdiepiebruh@zimbra.ac.rs', 'TEST', 'TEST TEST TEST TEST TEST'),
(2, 'Aleksa', 'Aleksa', 'pekipeki@gmail.com', 'test2', 'test2 test2 test2');

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

CREATE TABLE `facture` (
  `facture_id` int(10) UNSIGNED NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `sum` int(11) NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `fact_item_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `facture`
--

INSERT INTO `facture` (`facture_id`, `date`, `sum`, `user_id`, `fact_item_id`) VALUES
(1, '2020-06-03', 920, 21, 18),
(2, '2020-06-03', 2841, 26, 19),
(3, '2020-06-03', 399, 26, 20);

-- --------------------------------------------------------

--
-- Table structure for table `facture_item`
--

CREATE TABLE `facture_item` (
  `fac_item_id` int(10) UNSIGNED NOT NULL,
  `quantity` int(10) UNSIGNED NOT NULL,
  `price` double UNSIGNED NOT NULL,
  `laptop_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `facture_item`
--

INSERT INTO `facture_item` (`fac_item_id`, `quantity`, `price`, `laptop_id`) VALUES
(13, 3, 7262, 8),
(14, 2, 1399, 4),
(15, 1, 590, 1),
(17, 1, 920, 10),
(18, 1, 920, 10),
(19, 2, 2841, 6),
(20, 1, 399, 7),
(21, 1, 1200, 11);

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `id` int(11) UNSIGNED NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` text NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`id`, `username`, `email`, `password`, `role_id`) VALUES
(21, 'Korisnik', 'korisnik@korisnik.com', '$2y$10$CylbVYJYGgIYHqQRlr/uGOU3SZi/zfCAUTowUXLnyzKqYUvtsjIZu', 2),
(22, 'admin', 'admin@tech.com', 'admin1234', 1),
(23, 'Aleksa', 'aleksa@cekic.com', '$2y$10$Sp0897UJK2MLmKtcDF.8uuUzC1EgG5a7g.n6Ui9i2GIjLUt7dHvbi', 1),
(26, 'Bogdan', 'boki@boki.com', '$2y$10$CaxyBLr.Q0EqQz9mi3auJeksMymyBG37mlqF21Sx5jx/ukHASWYxq', 2),
(27, 'igorcina', 'igorcina@iiiii.ad', '$2y$10$1obGDaoqY8pqR2AnIQTpuezcfTMW54adYPOA7zLvlrliYKVF6hHp2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `laptops`
--

CREATE TABLE `laptops` (
  `laptop_id` int(11) UNSIGNED NOT NULL,
  `laptop_name` text NOT NULL,
  `laptop_description` text NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `laptops`
--

INSERT INTO `laptops` (`laptop_id`, `laptop_name`, `laptop_description`, `image`, `price`, `quantity`) VALUES
(1, 'LENOVO IdeaPad L340-15IRH Gaming', 'Intel® Core™ i5 9300H do 4.1GHz, 15.6\", 256GB SSD, 8GB', 'images/laptop1.png', 590, 6),
(2, 'ACER Aspire 3 A315-42-R0QL', 'AMD® Picasso Ryzen 7 3700U do 4.0GHz, 15.6\", 1TB SSD,12GB', 'images/laptop2.png', 490, 7),
(3, 'ACER Nitro 5 AN515-54', 'Intel® Core™ i5 9300H do 4.1GHz, 15.6\", 256GB SSD, 8GB', 'images/laptop3.png', 450.52, 7),
(4, 'HP Notebook - 15-db1079nm', 'Picasso Ryzen 7 3700U do 4.0GHz, 15.6\", 512GB SSD, 8GB', 'images/laptop4.png', 699.9, 5),
(5, 'HP ProBook 445R G6 Notebook PC', 'Picasso Ryzen 5 3500U do 3.7GHz, 14\", 256GB SSD, 8GB', 'images/laptop5.png', 455.55, 4),
(6, 'HP Elite Dragonfly', 'Intel® Core™ i7 8565U do 4.6GHz, 13.3\", 512GB SSD, 16GB', 'images/laptop6.png', 1420.55, 3),
(7, 'HP ProBook 470 G5', 'Intel® Core™ i5 8250U do 3.4GHz, 17.3\", 512GB SSD, 8GB', 'images/laptop7.png', 399.69, 6),
(8, 'ACER Predator Triton 500', 'Intel® Core™ i7 9750H do 4.5GHz, 15.6\", 1TB SSD, 16GB', 'images/laptop8.png', 2420.99, 0),
(9, 'OMEN by HP - 6BK86EA', 'Intel® Core™ i7 8750H do 4.1GHz, 15.6\", 256GB SSD, 8GB', 'images/laptop9.png', 560.99, 7),
(10, 'LENOVO IdeaPad C340-14IWL', 'Intel® Core™ i5 8265U do 3.9GHz, 14\", 128GB SSD, 8GB', 'images/laptop10.png', 920.73, 5),
(11, 'DELL Vostro 15 7590 - NOT13927', 'Intel® Core™ i5 9300H do 4.1GHz, 15.6\", 256GB SSD', 'images/laptop5.png', 1200, 6);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) UNSIGNED NOT NULL,
  `role_name` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `role_name`) VALUES
(1, 'admin'),
(2, 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`facture_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `fact_item_id` (`fact_item_id`);

--
-- Indexes for table `facture_item`
--
ALTER TABLE `facture_item`
  ADD PRIMARY KEY (`fac_item_id`),
  ADD KEY `laptop_id` (`laptop_id`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`) USING HASH,
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `laptops`
--
ALTER TABLE `laptops`
  ADD PRIMARY KEY (`laptop_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `facture`
--
ALTER TABLE `facture`
  MODIFY `facture_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `facture_item`
--
ALTER TABLE `facture_item`
  MODIFY `fac_item_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `laptops`
--
ALTER TABLE `laptops`
  MODIFY `laptop_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `korisnici` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `facture_ibfk_2` FOREIGN KEY (`fact_item_id`) REFERENCES `facture_item` (`fac_item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `facture_item`
--
ALTER TABLE `facture_item`
  ADD CONSTRAINT `facture_item_ibfk_1` FOREIGN KEY (`laptop_id`) REFERENCES `laptops` (`laptop_id`);

--
-- Constraints for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD CONSTRAINT `korisnici_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
