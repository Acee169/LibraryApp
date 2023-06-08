-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2023 at 09:09 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `signup`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Username`, `Password`) VALUES
('admin', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `Fullname` text NOT NULL,
  `SchoolID` text NOT NULL,
  `Password` text NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`Fullname`, `SchoolID`, `Password`, `firstname`, `lastname`) VALUES
('asd', 'asd', 'asd', 'asd', 'asd'),
('Vacant', 'e20200319', '12345', 'chanleang', 'heang'),
('Reaksmey', 'e20200013', '12345', 'Sokreaksmey', 'Sam');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `name` text NOT NULL,
  `bookname` text NOT NULL,
  `date` text NOT NULL,
  `status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`name`, `bookname`, `date`, `status`) VALUES
('asd', 'asd', 'asd', 'asd'),
('asdd', 'asdd', 'asdd', 'asdd');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `Id` int(100) NOT NULL,
  `Title` text NOT NULL,
  `Author` text NOT NULL,
  `Year` text NOT NULL,
  `Category` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`Id`, `Title`, `Author`, `Year`, `Category`) VALUES
(10, 'Ironman', 'Marvel', '2009', 'Action,Science');

-- --------------------------------------------------------

--
-- Table structure for table `loanlist`
--

CREATE TABLE `loanlist` (
  `username` text NOT NULL,
  `password` text NOT NULL,
  `title` text NOT NULL,
  `author` text NOT NULL,
  `year` text NOT NULL,
  `loandate` text NOT NULL,
  `bookid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loanlist`
--

INSERT INTO `loanlist` (`username`, `password`, `title`, `author`, `year`, `loandate`, `bookid`) VALUES
('chhay@gmail.com', '12345', 'asd', 'asd', '2005', '2023-05-15', 0),
('chhay@gmail.com', '12345', 'Harrypotter', 'Sokchhay', '2005', '2023-05-16', 0),
('asd', 'asd', 'chhay', 'Sokchhay', '1234', '2023-05-16', 0),
('asd', 'asd', 'HarryPotter', 'Sokchhay', '2020', '2023-05-16', 4),
('ace', '12345', 'Harry', 'sokchhay', '2005', '2023-05-15', 5);

-- --------------------------------------------------------

--
-- Table structure for table `loanlist1`
--

CREATE TABLE `loanlist1` (
  `Id` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `title` text NOT NULL,
  `author` text NOT NULL,
  `year` text NOT NULL,
  `loandate` text NOT NULL,
  `category` text NOT NULL,
  `returndate` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loanlist1`
--

INSERT INTO `loanlist1` (`Id`, `username`, `password`, `title`, `author`, `year`, `loandate`, `category`, `returndate`) VALUES
('5', 'Vacant', 'chanleang', 'Myhero', 'Jpanese', '2011', '2023-05-16', 'Action', ''),
('1', 'Vacant', 'chanleang', 'Harry', 'Jame', '2015', '2023-05-16', 'TextField[id=category, styleClass=text-input text-field]', ''),
('6', 'Sokchhay', 'e20200317', 'GOTA', 'Jamechhay', '2023', '2023-05-16', 'Action', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
