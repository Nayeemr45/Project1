-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 21, 2019 at 03:00 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `furniture`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `user_name` varchar(30) NOT NULL,
  `pass` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`user_name`, `pass`) VALUES
('abid', 1234567),
('nayeem', 123456);

-- --------------------------------------------------------

--
-- Table structure for table `assistant`
--

CREATE TABLE `assistant` (
  `user_name` varchar(30) NOT NULL,
  `pass` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assistant`
--

INSERT INTO `assistant` (`user_name`, `pass`) VALUES
('mohit', 12345678);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `con_no` int(3) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(35) NOT NULL,
  `mobile_no` varchar(11) NOT NULL,
  `message` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`con_no`, `name`, `email`, `mobile_no`, `message`) VALUES
(1, 'afid', 'afid@gmail.com', '01712356987', 'Good Service');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `c_no` int(2) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `pass` int(10) NOT NULL,
  `email` varchar(25) NOT NULL,
  `mobile_no` varchar(11) NOT NULL,
  `loc_id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`c_no`, `user_name`, `pass`, `email`, `mobile_no`, `loc_id`) VALUES
(1, 'fahim', 12345, 'fahim@gmail.com', '01712345681', 1),
(2, 'sakib', 12345, 'sakib@gmail.com', '01712345682', 2),
(3, 'noman', 12345, 'noman@gmail.com', '01712345678', 1),
(4, 'shad', 12345, 'shad@gmail.com', '01712358965', 1);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `loc_id` int(2) NOT NULL,
  `address` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`loc_id`, `address`) VALUES
(1, 'azimpur,dhaka'),
(2, 'danmondi,dhaka'),
(3, '01712532145'),
(4, '01712345678');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_no` int(3) NOT NULL,
  `payment_method` varchar(8) NOT NULL,
  `payment_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_no`, `payment_method`, `payment_date`) VALUES
(1, 'cash', '2019-08-14 18:00:00'),
(2, 'card', '2019-08-17 18:00:00'),
(3, 'Cash', '2019-08-19 10:18:06'),
(4, 'Card', '2019-08-20 19:08:35'),
(5, 'Check', '2019-08-21 00:56:19');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `p_no` int(3) NOT NULL,
  `p_name` varchar(20) NOT NULL,
  `price` int(5) NOT NULL,
  `available_no` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`p_no`, `p_name`, `price`, `available_no`) VALUES
(1, 'table', 900, 2),
(2, 'chair', 500, 1),
(3, 'bed', 1500, 1),
(4, 'bookshelf', 1200, 1);

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `rent_no` int(11) NOT NULL,
  `price` varchar(5) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`rent_no`, `price`, `date`) VALUES
(4, '500', '2019-08-19 10:17:58'),
(5, '500', '2019-08-19 16:13:02'),
(6, '700', '2019-08-20 19:08:31'),
(7, '1200', '2019-08-21 00:56:11');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`user_name`,`pass`);

--
-- Indexes for table `assistant`
--
ALTER TABLE `assistant`
  ADD PRIMARY KEY (`user_name`,`pass`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`con_no`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`c_no`,`user_name`,`pass`),
  ADD KEY `loc_id` (`loc_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`loc_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_no`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`p_no`);

--
-- Indexes for table `rent`
--
ALTER TABLE `rent`
  ADD PRIMARY KEY (`rent_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `con_no` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `c_no` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `loc_id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_no` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `rent`
--
ALTER TABLE `rent`
  MODIFY `rent_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`loc_id`) REFERENCES `location` (`loc_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
