-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2023 at 05:20 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `psystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity_history`
--

CREATE TABLE `activity_history` (
  `ACT_ID` int(11) NOT NULL,
  `PHAR_ID` int(11) NOT NULL,
  `PHAR_USERNAME` varchar(100) NOT NULL,
  `PHAR_NAME` varchar(100) NOT NULL,
  `PHAR_POS` varchar(100) NOT NULL,
  `ACT_DATE` varchar(100) NOT NULL,
  `ACT_TIME` varchar(100) NOT NULL,
  `ACT_ACTION` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `activity_history`
--

INSERT INTO `activity_history` (`ACT_ID`, `PHAR_ID`, `PHAR_USERNAME`, `PHAR_NAME`, `PHAR_POS`, `ACT_DATE`, `ACT_TIME`, `ACT_ACTION`) VALUES
(16, 5, 'juby', 'Judylein Valiao', 'Seller', '2023-06-02', '15:49:43', 'Sold item from inventory'),
(17, 4, 'darell', 'Darell Sarana', 'Manager', '2023-06-02', '16:14:55', 'Updated user Position/Status'),
(18, 4, 'darell', 'Darell Sarana', 'Manager', '2023-06-02', '16:21:14', 'Updated user Position/Status'),
(19, 4, 'darell', 'Darell Sarana', 'Manager', '2023-06-02', '16:22:02', 'Updated user Position/Status'),
(20, 5, 'juby', 'Judylein Valiao', 'Seller', '2023-06-02', '16:23:09', 'Sold item from inventory'),
(21, 5, 'juby', 'juby neils Valiao', 'Seller', '2023-06-02', '18:17:02', 'Changed Information'),
(22, 4, 'darell', 'Darell Sarana', 'Manager', '2023-06-02', '18:33:27', 'Updated user Position/Status'),
(23, 4, 'darell', 'Darell Sarana', 'Manager', '2023-06-02', '18:34:02', 'Updated user Position/Status'),
(24, 8, 'berto', 'Berto Engbino', 'Seller', '2023-06-02', '18:34:59', 'Sold item from inventory'),
(25, 5, 'juby', 'juby neil Valiao', 'Seller', '2023-06-02', '18:40:31', 'Updated User Information'),
(26, 8, 'berto', 'Berto1 Engbino', 'Seller', '2023-06-02', '18:46:18', 'Updated User Information'),
(27, 8, 'berto', 'Berto1 Engbino', 'Seller', '2023-06-02', '18:46:25', 'Updated User Information'),
(28, 8, 'berto', 'Berto11 Engbino', 'Seller', '2023-06-02', '18:49:51', 'Updated User Information'),
(29, 8, 'berto', 'Berto11 Engbiknows', 'Seller', '2023-06-02', '18:55:54', 'Updated User Information'),
(30, 8, 'berto', 'Berto112 Engbiknows', 'Seller', '2023-06-02', '18:56:52', 'Updated User Information'),
(31, 4, 'darell', 'Darell Sarana', 'Manager', '2023-06-02', '19:09:37', 'Updated an item in inventory'),
(32, 4, 'darell', 'Darell Sarana', 'Manager', '2023-06-02', '19:09:50', 'Updated an item in inventory'),
(33, 4, 'darell', 'Darell Sarana', 'Manager', '2023-06-02', '19:10:09', 'Updated an item in inventory'),
(34, 8, 'berto', 'Berto112 Engbiknows', 'Seller', '2023-06-02', '19:32:45', 'Sold item from inventory'),
(35, 4, 'darell', 'Darell Sarana', 'Manager', '2023-06-02', '22:49:46', 'Added item in inventory'),
(36, 5, 'juby', 'juby neil Valiao', 'Seller', '2023-06-02', '23:03:51', 'Sold item from inventory');

-- --------------------------------------------------------

--
-- Table structure for table `log_in_history`
--

CREATE TABLE `log_in_history` (
  `LOG_ID` int(11) NOT NULL,
  `LOG_TIME` time NOT NULL,
  `LOG_DATE` date NOT NULL,
  `PHAR_ID` int(11) NOT NULL,
  `PHAR_NAME` varchar(100) NOT NULL,
  `PHAR_POS` varchar(100) NOT NULL,
  `LOG_TYPE` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `log_in_history`
--

INSERT INTO `log_in_history` (`LOG_ID`, `LOG_TIME`, `LOG_DATE`, `PHAR_ID`, `PHAR_NAME`, `PHAR_POS`, `LOG_TYPE`) VALUES
(1, '00:03:58', '2023-05-11', 1, 'ASDFASDF', 'ASDFSADF', ''),
(2, '14:47:19', '2023-06-02', 4, 'Darell  Sarana', 'Admin', 'Logged In'),
(3, '14:47:23', '2023-06-02', 4, 'Darell  Sarana', 'Admin', 'Logged In'),
(4, '14:47:31', '2023-06-02', 4, 'Darell  Sarana', 'Admin', 'Logged In'),
(5, '14:47:34', '2023-06-02', 4, 'Darell  Sarana', 'Admin', 'Logged In'),
(6, '14:48:19', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(7, '14:51:54', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(8, '14:53:17', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(9, '14:53:51', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(10, '14:53:57', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(11, '14:56:02', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(12, '14:57:39', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(13, '14:58:38', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(14, '15:01:14', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(15, '15:05:22', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(16, '15:07:38', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(17, '15:10:18', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(18, '15:11:10', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(19, '15:13:53', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(20, '15:14:02', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(21, '15:14:37', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(22, '15:14:51', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(23, '15:19:15', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(24, '15:19:41', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(25, '15:19:47', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(26, '15:22:40', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(27, '15:23:13', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged Out'),
(28, '15:23:18', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(29, '15:23:42', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(30, '15:24:53', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged Out'),
(31, '15:24:59', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(32, '15:25:15', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(33, '15:26:07', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged Out'),
(34, '15:26:16', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(35, '15:39:01', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(36, '15:39:09', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(37, '15:43:00', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(38, '15:49:14', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(39, '15:50:32', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged Out'),
(40, '15:50:38', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(41, '15:59:38', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(42, '16:04:04', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(43, '16:04:59', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(44, '16:07:49', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(45, '16:09:40', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(46, '16:14:49', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(47, '16:15:56', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(48, '16:21:03', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(49, '16:21:18', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(50, '16:21:24', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(51, '16:21:48', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(52, '16:21:56', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(53, '16:22:27', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(54, '16:22:33', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(55, '16:26:20', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(56, '16:52:02', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(57, '16:53:21', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(58, '16:56:04', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(59, '16:56:25', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(60, '16:56:38', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(61, '17:35:34', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(62, '17:39:08', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(63, '17:41:34', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(64, '17:45:53', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(65, '17:47:27', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(66, '17:59:20', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(67, '18:02:07', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(68, '18:03:46', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(69, '18:04:18', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(70, '18:10:23', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(71, '18:12:17', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(72, '18:13:21', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged In'),
(73, '18:13:51', '2023-06-02', 5, 'Judylein  Valiao', 'Seller', 'Logged Out'),
(74, '18:13:59', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(75, '18:14:22', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(76, '18:14:31', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(77, '18:14:43', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(78, '18:16:54', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged In'),
(79, '18:17:09', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged Out'),
(80, '18:17:14', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(81, '18:31:28', '2023-06-02', 7, 'Berto  Engbino', ' ', 'Logged In'),
(82, '18:31:29', '2023-06-02', 7, 'Berto  Engbino', ' ', 'Logged In'),
(83, '18:31:30', '2023-06-02', 7, 'Berto  Engbino', ' ', 'Logged In'),
(84, '18:31:31', '2023-06-02', 7, 'Berto  Engbino', ' ', 'Logged In'),
(85, '18:31:32', '2023-06-02', 7, 'Berto  Engbino', ' ', 'Logged In'),
(86, '18:31:58', '2023-06-02', 7, 'Berto  Engbino', ' ', 'Logged In'),
(87, '18:32:57', '2023-06-02', 8, 'Berto  Engbino', '', 'Logged In'),
(88, '18:33:06', '2023-06-02', 8, 'Berto  Engbino', '', 'Logged In'),
(89, '18:33:12', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(90, '18:33:31', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(91, '18:33:37', '2023-06-02', 8, 'Berto  Engbino', 'Seller', 'Logged In'),
(92, '18:33:49', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(93, '18:34:25', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(94, '18:34:32', '2023-06-02', 8, 'Berto  Engbino', 'Seller', 'Logged In'),
(95, '18:36:42', '2023-06-02', 5, 'juby neils  Valiao', 'Seller', 'Logged In'),
(96, '18:39:46', '2023-06-02', 5, 'juby neils  Valiao', 'Seller', 'Logged In'),
(97, '18:46:11', '2023-06-02', 8, 'Berto  Engbino', 'Seller', 'Logged In'),
(98, '18:49:45', '2023-06-02', 8, 'Berto1  Engbino', 'Seller', 'Logged In'),
(99, '18:55:36', '2023-06-02', 8, 'Berto11  Engbino', 'Seller', 'Logged In'),
(100, '18:56:10', '2023-06-02', 8, 'Berto11  Engbino', 'Seller', 'Logged Out'),
(101, '18:56:40', '2023-06-02', 8, 'Berto11  Engbiknows', 'Seller', 'Logged In'),
(102, '18:58:12', '2023-06-02', 8, 'Berto112  Engbiknows', 'Seller', 'Logged In'),
(103, '18:58:57', '2023-06-02', 8, 'Berto112  Engbiknows', 'Seller', 'Logged In'),
(104, '18:59:50', '2023-06-02', 8, 'Berto112  Engbiknows', 'Seller', 'Logged Out'),
(105, '18:59:55', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(106, '18:59:59', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(107, '19:00:33', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(108, '19:00:39', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(109, '19:09:30', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(110, '19:10:41', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(111, '19:10:47', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(112, '19:10:50', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(113, '19:17:27', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(114, '19:17:46', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(115, '19:30:35', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(116, '19:32:18', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(117, '19:32:24', '2023-06-02', 8, 'Berto112  Engbiknows', 'Seller', 'Logged In'),
(118, '22:20:15', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(119, '22:29:23', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(120, '22:29:45', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(121, '22:31:12', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(122, '22:31:37', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(123, '22:33:47', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(124, '22:34:15', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(125, '22:34:20', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(126, '22:35:15', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(127, '22:35:24', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(128, '22:35:33', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(129, '22:35:39', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(130, '22:36:06', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(131, '22:49:03', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(132, '22:52:29', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(133, '22:52:53', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(134, '22:53:00', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged In'),
(135, '22:53:31', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged Out'),
(136, '22:53:34', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged Out'),
(137, '22:53:40', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged Out'),
(138, '22:56:07', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged In'),
(139, '22:56:14', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged Out'),
(140, '22:56:20', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged Out'),
(141, '23:02:01', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged In'),
(142, '23:03:26', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged In'),
(143, '23:04:11', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged Out'),
(144, '23:04:18', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(145, '23:08:14', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged In'),
(146, '23:08:22', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged Out'),
(147, '23:08:29', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(148, '23:09:38', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(149, '23:11:22', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(150, '23:14:36', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(151, '23:16:00', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(152, '23:17:35', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(153, '23:18:16', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In'),
(154, '23:18:27', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged Out'),
(155, '23:18:33', '2023-06-02', 5, 'juby neil  Valiao', 'Seller', 'Logged In'),
(156, '23:19:03', '2023-06-02', 4, 'Darell  Sarana', 'Manager', 'Logged In');

-- --------------------------------------------------------

--
-- Table structure for table `med_inventory`
--

CREATE TABLE `med_inventory` (
  `MED_ID` int(11) NOT NULL,
  `MED_NAME` varchar(100) NOT NULL,
  `MED_DOSAGE` varchar(100) NOT NULL,
  `MED_TYPE` varchar(100) NOT NULL,
  `MED_MANUFACTURER` varchar(100) NOT NULL,
  `MED_EXPIRY` date NOT NULL,
  `MED_LOCATION` varchar(100) NOT NULL,
  `MED_QUANTITY` double NOT NULL,
  `MED_PRICE` double NOT NULL,
  `MED_STATUS` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `med_inventory`
--

INSERT INTO `med_inventory` (`MED_ID`, `MED_NAME`, `MED_DOSAGE`, `MED_TYPE`, `MED_MANUFACTURER`, `MED_EXPIRY`, `MED_LOCATION`, `MED_QUANTITY`, `MED_PRICE`, `MED_STATUS`) VALUES
(3, 'asdfasdfas', 'dasdfas', 'asdfasdf', 'asdfasdf', '2023-06-30', 'asdfasdf', 138, 12, 'Available'),
(4, 'asdfasdfasdf', 'asdfsadsadf', 'asdasdfsad', 'asdfsadfsadf', '2023-06-30', 'asdfsadfsadf', 983, 12, 'Available'),
(5, 'Enervon', '500 mg', 'Vitamins', 'Unilab', '2025-06-20', 'A6', 500, 9, 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `med_purchased`
--

CREATE TABLE `med_purchased` (
  `PUR_ID` int(20) NOT NULL,
  `TRANS_ID` int(11) NOT NULL,
  `MED_ID` int(11) NOT NULL,
  `MED_NAME` varchar(100) NOT NULL,
  `QUANTITY` int(11) NOT NULL,
  `MED_PRICE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `med_purchased`
--

INSERT INTO `med_purchased` (`PUR_ID`, `TRANS_ID`, `MED_ID`, `MED_NAME`, `QUANTITY`, `MED_PRICE`) VALUES
(27, 8, 3, 'asdfasdfas', 1, 12),
(28, 9, 4, 'asdfasdfasdf', 1, 12),
(29, 9, 3, 'asdfasdfas', 1, 12),
(30, 10, 3, 'asdfasdfas', 12, 12),
(31, 10, 4, 'asdfasdfasdf', 12, 12),
(32, 11, 3, 'asdfasdfas', 23, 12),
(33, 11, 4, 'asdfasdfasdf', 23, 12),
(34, 12, 4, 'asdfasdfasdf', 12309, 12),
(35, 13, 3, 'asdfasdfas', 12296, 12),
(36, 14, 3, 'asdfasdfas', 12, 12),
(37, 14, 4, 'asdfasdfasdf', 12, 12),
(38, 15, 4, 'asdfasdfasdf', 5, 12);

-- --------------------------------------------------------

--
-- Table structure for table `pharmacists_inf`
--

CREATE TABLE `pharmacists_inf` (
  `PHAR_ID` int(11) NOT NULL,
  `PHAR_FNAME` varchar(100) NOT NULL,
  `PHAR_LNAME` varchar(100) NOT NULL,
  `PHAR_BIRTHDATE` varchar(100) NOT NULL,
  `PHAR_ADD` varchar(100) NOT NULL,
  `PHAR_CELL_NUM` varchar(100) NOT NULL,
  `PHAR_POS` varchar(100) NOT NULL,
  `PHAR_USERNAME` varchar(100) NOT NULL,
  `PHAR_PASS` varchar(100) NOT NULL,
  `PHAR_STATUS` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pharmacists_inf`
--

INSERT INTO `pharmacists_inf` (`PHAR_ID`, `PHAR_FNAME`, `PHAR_LNAME`, `PHAR_BIRTHDATE`, `PHAR_ADD`, `PHAR_CELL_NUM`, `PHAR_POS`, `PHAR_USERNAME`, `PHAR_PASS`, `PHAR_STATUS`) VALUES
(4, 'Darell', 'Sarana', '11-01-2001', 'Gk Village Villareal Bayawan City', '09123456789', 'Manager', 'darell', 'darell', 'Active'),
(5, 'juby neil', 'Valiao', '11-11-11', 'asdasdfsadf', '23114567899', 'Seller', 'juby', 'juby', 'Active'),
(8, 'Berto112', 'Engbiknows', 'asdfasdf', 'asdfasdf', 'asfasdfdsaf', 'Seller', 'berto', 'berto', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `trans_history`
--

CREATE TABLE `trans_history` (
  `TRANS_ID` int(11) NOT NULL,
  `PHAR_ID` int(11) NOT NULL,
  `PHAR_NAME` varchar(100) NOT NULL,
  `TRANS_TIME` varchar(100) NOT NULL,
  `TRANS_DATE` varchar(100) NOT NULL,
  `TOTAL_PRICE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trans_history`
--

INSERT INTO `trans_history` (`TRANS_ID`, `PHAR_ID`, `PHAR_NAME`, `TRANS_TIME`, `TRANS_DATE`, `TOTAL_PRICE`) VALUES
(8, 5, 'Judylein  Valiao', '15:24:08', '2023-06-02', 12),
(9, 5, 'Judylein  Valiao', '15:39:32', '2023-06-02', 24),
(10, 5, 'Judylein  Valiao', '15:43:36', '2023-06-02', 288),
(11, 5, 'Judylein  Valiao', '15:49:42', '2023-06-02', 552),
(12, 5, 'Judylein  Valiao', '16:23:09', '2023-06-02', 147708),
(13, 8, 'Berto  Engbino', '18:34:58', '2023-06-02', 147552),
(14, 8, 'Berto112  Engbiknows', '19:32:44', '2023-06-02', 288),
(15, 5, 'juby neil  Valiao', '23:03:48', '2023-06-02', 60);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity_history`
--
ALTER TABLE `activity_history`
  ADD PRIMARY KEY (`ACT_ID`);

--
-- Indexes for table `log_in_history`
--
ALTER TABLE `log_in_history`
  ADD PRIMARY KEY (`LOG_ID`),
  ADD KEY `PHAR_ID` (`PHAR_ID`);

--
-- Indexes for table `med_inventory`
--
ALTER TABLE `med_inventory`
  ADD PRIMARY KEY (`MED_ID`);

--
-- Indexes for table `med_purchased`
--
ALTER TABLE `med_purchased`
  ADD PRIMARY KEY (`PUR_ID`),
  ADD KEY `MED_ID` (`MED_ID`),
  ADD KEY `TRANS_ID` (`TRANS_ID`);

--
-- Indexes for table `pharmacists_inf`
--
ALTER TABLE `pharmacists_inf`
  ADD PRIMARY KEY (`PHAR_ID`);

--
-- Indexes for table `trans_history`
--
ALTER TABLE `trans_history`
  ADD PRIMARY KEY (`TRANS_ID`),
  ADD KEY `SELLER_ID` (`PHAR_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activity_history`
--
ALTER TABLE `activity_history`
  MODIFY `ACT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `log_in_history`
--
ALTER TABLE `log_in_history`
  MODIFY `LOG_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=157;

--
-- AUTO_INCREMENT for table `med_inventory`
--
ALTER TABLE `med_inventory`
  MODIFY `MED_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `med_purchased`
--
ALTER TABLE `med_purchased`
  MODIFY `PUR_ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `pharmacists_inf`
--
ALTER TABLE `pharmacists_inf`
  MODIFY `PHAR_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `trans_history`
--
ALTER TABLE `trans_history`
  MODIFY `TRANS_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `log_in_history`
--
ALTER TABLE `log_in_history`
  ADD CONSTRAINT `log_in_history_ibfk_1` FOREIGN KEY (`PHAR_ID`) REFERENCES `pharmacists_inf` (`PHAR_ID`);

--
-- Constraints for table `med_purchased`
--
ALTER TABLE `med_purchased`
  ADD CONSTRAINT `med_purchased_ibfk_1` FOREIGN KEY (`TRANS_ID`) REFERENCES `trans_history` (`TRANS_ID`),
  ADD CONSTRAINT `med_purchased_ibfk_2` FOREIGN KEY (`MED_ID`) REFERENCES `med_inventory` (`MED_ID`);

--
-- Constraints for table `trans_history`
--
ALTER TABLE `trans_history`
  ADD CONSTRAINT `trans_history_ibfk_1` FOREIGN KEY (`PHAR_ID`) REFERENCES `pharmacists_inf` (`PHAR_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
