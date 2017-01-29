
-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 29, 2017 at 10:42 AM
-- Server version: 10.0.28-MariaDB
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `u621445275_terro`
--

-- --------------------------------------------------------

--
-- Table structure for table `alert`
--

CREATE TABLE IF NOT EXISTS `alert` (
  `ano` int(11) NOT NULL AUTO_INCREMENT,
  `alert` text NOT NULL,
  `type` varchar(20) NOT NULL,
  `a_date` date NOT NULL,
  `a_time` time NOT NULL,
  PRIMARY KEY (`ano`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `alert`
--

INSERT INTO `alert` (`ano`, `alert`, `type`, `a_date`, `a_time`) VALUES
(24, 'information new', 'information', '2017-01-29', '08:48:03'),
(23, 'Information', 'information', '2017-01-29', '07:04:42'),
(22, '', 'undefined', '2017-01-29', '07:04:22'),
(21, '', 'undefined', '2017-01-29', '07:04:21'),
(20, 'this is another alert.', 'caution', '2017-01-29', '06:16:10'),
(19, 'this is an information.', 'information', '2017-01-29', '06:13:48'),
(18, 'this is an alert.', 'caution', '2017-01-29', '06:13:32');

-- --------------------------------------------------------

--
-- Table structure for table `casuality`
--

CREATE TABLE IF NOT EXISTS `casuality` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `age` int(2) NOT NULL,
  `hospital` text NOT NULL,
  `fund` int(11) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `casuality`
--

INSERT INTO `casuality` (`sno`, `name`, `age`, `hospital`, `fund`) VALUES
(1, 'mandeep', 21, 'sion hospital', 10000),
(2, 'akshay', 21, 'kem hospital', 19998),
(3, 'niranjan', 21, 'kem hospital', 30000);

-- --------------------------------------------------------

--
-- Table structure for table `dangerzone`
--

CREATE TABLE IF NOT EXISTS `dangerzone` (
  `dno` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `address` text NOT NULL,
  `range` int(11) NOT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`dno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `dangerzone`
--

INSERT INTO `dangerzone` (`dno`, `latitude`, `longitude`, `address`, `range`, `flag`) VALUES
(1, 18.71493093979887, 73.18177700042725, 'undefined', 100, 0),
(2, 18.711679207086544, 73.1515645980835, 'undefined', 200, 0),
(3, 18.652293618415175, 72.87941694259644, 'undefined', 200, 0),
(4, 19.108605648815562, 72.83753156661987, 'undefined', 50, 0),
(5, 19.108543808927312, 72.83801096678872, 'undefined', 100, 0),
(6, 19.107874720802872, 72.83635872603554, 'undefined', 1000, 0),
(7, 19.108221430565383, 72.83223885298867, 'Dil Rag, N S Rd Number 9, Nutan Laxmi Society, JVPD Scheme, Juhu, Mumbai, Maharashtra 400049, India', 100, 1),
(8, 19.11512810023582, 72.8276259899576, 'undefined', 50, 0),
(9, 19.11005532992331, 72.83759593963623, 'undefined', 50, 0),
(10, 19.12880474607646, 72.81990337389288, 'undefined', 50, 0),
(11, 18.99063413496156, 72.83703124525346, 'undefined', 50, 0),
(12, 19.110948448872627, 72.83344048262734, 'undefined', 100, 0),
(13, 19.106670355481356, 72.84117597359, 'Dadabhai Cross Road No 2, Irla, Vile Parle, Mumbai, Maharashtra 400047, India', 100, 1),
(14, 19.10216911375438, 72.82643455284415, 'undefined', 50, 0),
(15, 19.11190137403489, 72.83643382788796, 'undefined', 100, 0),
(16, 18.842857203468363, 75.79381942749023, 'undefined', 199, 1),
(17, 19.11088762367581, 72.83841866255898, 'undefined', 60, 1),
(18, 19.111181611919786, 72.83428806067604, 'undefined', 70, 1),
(19, 19.110613910013296, 72.83649820090432, 'undefined', 70, 1);

-- --------------------------------------------------------

--
-- Table structure for table `suspecious`
--

CREATE TABLE IF NOT EXISTS `suspecious` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `desciption` varchar(500) NOT NULL,
  `image` varchar(50) NOT NULL,
  `longitude` double NOT NULL,
  `latitude` double NOT NULL,
  `imei` varchar(21) NOT NULL,
  `vm_no` bigint(10) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `type` varchar(21) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `type`) VALUES
('killer', 'e10adc3949ba59abbe56e057f20f883e', 'police'),
('mandeep', '619e26758a159ab6fafda4e6ac81dcf3', 'ngo');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
