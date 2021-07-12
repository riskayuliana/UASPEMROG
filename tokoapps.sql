-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2021 at 01:04 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tokoapps`
--

-- --------------------------------------------------------

--
-- Table structure for table `entry_barang`
--

CREATE TABLE `entry_barang` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `hargabeli_barang` int(100) NOT NULL,
  `hargajual_barang` int(100) NOT NULL,
  `jumlah` int(100) NOT NULL,
  `entry_by` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `entry_barang`
--

INSERT INTO `entry_barang` (`id_barang`, `nama_barang`, `hargabeli_barang`, `hargajual_barang`, `jumlah`, `entry_by`) VALUES
(2, 'Buku Tulis', 30000, 99000, 3, 'Riska Yuliana'),
(5, 'Buku Cetak', 23000, 126500, 5, 'Riska Yuliana'),
(7, 'Pena', 5000, 55000, 10, 'Riska Yuliana'),
(8, 'Penggaris', 10000, 22000, 2, 'Riska Yuliana');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama_lengkap` varchar(50) NOT NULL,
  `email` varchar(70) NOT NULL,
  `alamat` varchar(70) NOT NULL,
  `jenis_kelamin` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`, `nama_lengkap`, `email`, `alamat`, `jenis_kelamin`) VALUES
(1, 'riskayuliana', 'riska', 'Riska Yuliana', 'riskayliana@gmail.com', 'K.H.Nasution', 'P');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `entry_barang`
--
ALTER TABLE `entry_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `entry_barang`
--
ALTER TABLE `entry_barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
