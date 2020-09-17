-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:7733
-- Generation Time: Sep 17, 2020 at 03:42 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sigecon_gasto`
--

-- --------------------------------------------------------

--
-- Table structure for table `gasto`
--

CREATE TABLE `gasto` (
  `id_gasto` int(11) NOT NULL,
  `valor` decimal(19,4) NOT NULL,
  `moneda_fk` int(11) NOT NULL,
  `tipo_gasto_fk` int(11) NOT NULL,
  `cuadre_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tipo_gasto`
--

CREATE TABLE `tipo_gasto` (
  `id_tipo_gasto` int(11) NOT NULL,
  `nombre_gasto` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `moneda_defecto_fk` int(11) NOT NULL,
  `tipo_operacion_contable_defecto_fk` int(11) NOT NULL,
  `forma_pago_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gasto`
--
ALTER TABLE `gasto`
  ADD PRIMARY KEY (`id_gasto`),
  ADD KEY `FK_gasto_cuadre` (`cuadre_fk`),
  ADD KEY `FK_gasto_moneda` (`moneda_fk`),
  ADD KEY `FK_gasto_tipo_gasto` (`tipo_gasto_fk`);

--
-- Indexes for table `tipo_gasto`
--
ALTER TABLE `tipo_gasto`
  ADD PRIMARY KEY (`id_tipo_gasto`),
  ADD UNIQUE KEY `nombre_gasto` (`nombre_gasto`),
  ADD KEY `FK_tipo_gasto_moneda` (`moneda_defecto_fk`),
  ADD KEY `FK_tipo_gasto_tipo_op` (`tipo_operacion_contable_defecto_fk`),
  ADD KEY `FK_tipo_gasto_gorma_pago` (`forma_pago_fk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gasto`
--
ALTER TABLE `gasto`
  MODIFY `id_gasto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `tipo_gasto`
--
ALTER TABLE `tipo_gasto`
  MODIFY `id_tipo_gasto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gasto`
--
ALTER TABLE `gasto`
  ADD CONSTRAINT `FK_gasto_cuadre` FOREIGN KEY (`cuadre_fk`) REFERENCES `sigecon_contabilidad`.`cuadre` (`id_cuadre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_gasto_moneda` FOREIGN KEY (`moneda_fk`) REFERENCES `sigecon_contabilidad`.`moneda` (`id_moneda`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_gasto_tipo_gasto` FOREIGN KEY (`tipo_gasto_fk`) REFERENCES `tipo_gasto` (`id_tipo_gasto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tipo_gasto`
--
ALTER TABLE `tipo_gasto`
  ADD CONSTRAINT `FK_tipo_gasto_gorma_pago` FOREIGN KEY (`forma_pago_fk`) REFERENCES `sigecon_contabilidad`.`forma_pago` (`id_forma_pago`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tipo_gasto_moneda` FOREIGN KEY (`moneda_defecto_fk`) REFERENCES `sigecon_contabilidad`.`moneda` (`id_moneda`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tipo_gasto_tipo_op` FOREIGN KEY (`tipo_operacion_contable_defecto_fk`) REFERENCES `sigecon_contabilidad`.`tipo_operacion_contable` (`id_tipo_operacion`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
