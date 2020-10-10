-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2019 at 06:18 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airlines booking system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'ate/5109/09', '123');

-- --------------------------------------------------------

--
-- Table structure for table `adminaccessrequest`
--

CREATE TABLE `adminaccessrequest` (
  `id` int(11) NOT NULL,
  `workId` varchar(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminaccessrequest`
--

INSERT INTO `adminaccessrequest` (`id`, `workId`, `password`, `email`) VALUES
(1, 'ATE/5109/09', 'mypassword', 'abiud_melaku@yahoo.com'),
(2, 'ATE/5144/09', 'Dagi', 'dagmawi@yahoo.com'),
(3, 'ate/3189/09', 'unknownguy', 'unknownguy@yahoo.cm'),
(4, 'ate/6789/34', 'fkdsjgs', 'jk@hotmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `payedperson`
--

CREATE TABLE `payedperson` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `destination` varchar(30) NOT NULL,
  `departureDate` varchar(10) NOT NULL,
  `departureTime` varchar(10) NOT NULL,
  `passportNumber` varchar(255) NOT NULL,
  `usingPlane` varchar(50) NOT NULL,
  `chekedIn` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payedperson`
--

INSERT INTO `payedperson` (`id`, `name`, `userName`, `destination`, `departureDate`, `departureTime`, `passportNumber`, `usingPlane`, `chekedIn`) VALUES
(11, 'Sosena Kebede', 's_kebede', 'bali indonesia', '12/02/2019', '1:00 am', '456', 'emirates airlines1', 'false'),
(12, 'Maraki Melaku', 'mak', 'sydney australia', '18/02/2019', '12:00 am', 'ep44', 'quatar airlines3', 'false'),
(13, 'chernet', 'cheregc', 'rio brazil', '28/02/2019', '1:00pm', '5141', 'turkish airlines6', 'false'),
(14, 'abel yohannes', 'abelYo', 'rio brazil', '28/02/2019', '1:00pm', 'ep5144', 'turkish airlines6', 'false'),
(17, 'chuchu', 'chuchu', 'hamburge germany', '28/03/2019', '12:00 am', 'ep122', 'luftansa airline7', 'false'),
(18, 'Moaz mohammed', 'moaz', 'nairobi keya', '22/03/2019', '6:00 am', 'ep123', 'Ethiopian Airlines21', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `planedestinations`
--

CREATE TABLE `planedestinations` (
  `id` int(11) NOT NULL,
  `airlinesName` varchar(25) NOT NULL,
  `destination` varchar(25) NOT NULL,
  `departureDate` varchar(100) NOT NULL,
  `departureTime` varchar(100) NOT NULL,
  `passengerSeats` int(11) NOT NULL,
  `paymentAmount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `planedestinations`
--

INSERT INTO `planedestinations` (`id`, `airlinesName`, `destination`, `departureDate`, `departureTime`, `passengerSeats`, `paymentAmount`) VALUES
(1, 'emirates airline', 'bali indonesia', '15/03/2019', '1:00 am', 213, 22000),
(3, 'quatar airlines', 'sydney australia', '18/02/2019', '12:00 am', 184, 34000),
(7, 'luftansa airline', 'hamburge germany', '28/03/2019', '12:00 am', 195, 15700),
(20, 'quatar airline', 'sydney australia', '18/03/2019', '12:00 am', 184, 34000),
(21, 'Ethiopian Airlines', 'nairobi keya', '22/03/2019', '6:00 am', 199, 12500),
(22, 'Ethiopian Airlines', 'nairobi keya', '22/03/2019', '6:00 am', 200, 12500),
(23, 'Koriean Airlines', 'rio brazil', '28/07/2019', '1:00pm', 130, 60000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `passPort` varchar(100) NOT NULL,
  `creditCard` varchar(15) NOT NULL,
  `eMail` varchar(30) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `passWord` varchar(150) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `passPort`, `creditCard`, `eMail`, `userName`, `passWord`, `role`) VALUES
(1, 'Abiud Melaku Ayele', '', '123', 'abiud_melaku@yahoo.com', 'ate/5109/09', '123', 'admin'),
(2, 'Sosena Kebede', '456', '456', 's_abiud2002@yahoo.com', 's_kebede', '123', 'customer'),
(3, 'Melaku Ayele', '789', '789', 'm_ayele2000@yahoo.com', 'm_ayele', '123', 'customer'),
(4, 'abel yohannes', 'ep5144', '213', 'abel@yahoo.com', 'abelYo', '123', 'customer'),
(5, 'chernet', '5141', '313', 'cheregc@gmail.com', 'cheregc', '123', 'customer'),
(6, 'Maraki Melaku', 'ep444', '321', 'Maraki@yahoo.com', 'mar_mela', '123', 'customer'),
(9, 'Maraki Melaku', 'ep44', '321', 'mak@yahoo.com', 'mak', '123', 'customer'),
(10, 'Kalabe', 'kal123', 'kal123', 'Kalabe@yahoo.ci', 'kal', '123', 'customer'),
(11, 'b', 'b123', 'b123', 'B@yahoo.com', 'b', '123', 'customer'),
(12, 'c', 'c123', '1234', 'c@c.com', 'c', '123', 'customer'),
(13, 'chuchu', 'ep122', '763ew', 'chuchu@yahoo.com', 'chuchu', '123', 'customer'),
(14, 'Moaz mohammed', 'ep123', '12345', 'moaz@yahoo.com', 'moaz', '123', 'customer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `adminaccessrequest`
--
ALTER TABLE `adminaccessrequest`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payedperson`
--
ALTER TABLE `payedperson`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `planedestinations`
--
ALTER TABLE `planedestinations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `adminaccessrequest`
--
ALTER TABLE `adminaccessrequest`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `payedperson`
--
ALTER TABLE `payedperson`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `planedestinations`
--
ALTER TABLE `planedestinations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
