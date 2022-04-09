-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2022 at 01:24 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill_confirm`
--

CREATE TABLE `bill_confirm` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `seller_history`
--

CREATE TABLE `seller_history` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seller_history`
--

INSERT INTO `seller_history` (`id`, `name`, `amount`, `price`, `date`) VALUES
(9, 'GEFORCE RTX 3090', 500, 52800, '2022-03-01'),
(10, 'Apple Watch', 230, 13900, '2022-03-01'),
(11, 'Apple Pencil', 200, 4490, '2022-03-01'),
(12, 'Apple Pencil', 200, 4490, '2022-03-01'),
(13, 'dddd', 25, 35000, '2022-03-01'),
(14, 'Apple Pencil2', 200, 4490, '2022-03-01'),
(15, 'iphone 13 pro max', 50, 28000, '2022-03-01'),
(16, 'Galaxy S22 Ultra', 24, 39000, '2022-03-01'),
(17, 'Apple Pencil', 200, 4490, '2022-03-01'),
(18, 'GEFORCE RTX 3090', 500, 52800, '2022-03-01'),
(19, 'macbook pro', 70, 280000, '2022-03-01'),
(20, 'GEFORCE RTX 3090', 500, 52800, '2022-03-02'),
(21, 'Intel CPU Core i9-12900K', 500, 23900, '2022-03-02'),
(22, 'Apple Pencil', 200, 4490, '2022-03-03'),
(23, 'macbook pro', 70, 280000, '2022-03-08'),
(24, 'GEFORCE RTX 3090', 500, 52800, '2022-03-08'),
(25, 'GEFORCE RTX 3090', 500, 52800, '2022-03-09');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `quantity`, `price`) VALUES
(1, 'iphone 13 pro max', 50, 28000),
(2, 'ipad pro', 100, 23500),
(3, 'macbook pro', 70, 280000),
(4, 'Apple Pencil', 200, 4490),
(5, 'Apple Watch', 230, 13900),
(6, 'GEFORCE RTX 3090', 500, 52800),
(7, 'Intel CPU Core i9-12900K', 500, 23900),
(8, '980 PRO PCle 4.0 NVMe M.2 SSD', 1000, 7390),
(9, 'Asus Tuf Dash F15 ', 20, 32900),
(10, 'Galaxy S22 Ultra', 24, 39000),
(11, 'Galaxy A53 5G', 50, 14499),
(12, 'Xiaomi 12 Pro', 5, 31990),
(13, 'POCO X4 Pro 5G', 5, 10990);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill_confirm`
--
ALTER TABLE `bill_confirm`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `seller_history`
--
ALTER TABLE `seller_history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill_confirm`
--
ALTER TABLE `bill_confirm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `seller_history`
--
ALTER TABLE `seller_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=223;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
