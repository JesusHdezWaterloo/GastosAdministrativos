-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:7733
-- Generation Time: Jan 01, 2021 at 05:02 AM
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

--
-- Dumping data for table `gasto`
--

INSERT INTO `gasto` (`id_gasto`, `valor`, `moneda_fk`, `tipo_gasto_fk`, `cuadre_fk`) VALUES
(68, '60.0000', 10, 11, 191);

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
-- Dumping data for table `tipo_gasto`
--

INSERT INTO `tipo_gasto` (`id_tipo_gasto`, `nombre_gasto`, `descripcion`, `moneda_defecto_fk`, `tipo_operacion_contable_defecto_fk`, `forma_pago_fk`) VALUES
(11, 'Datos', 'Dinero que se gasta por concepto de compra de un paquete de datos', 10, 14, 8),
(12, 'Otro mas', '', 10, 14, 8),
(713, '123', '123', 12, 19, 7);

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
  MODIFY `id_gasto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT for table `tipo_gasto`
--
ALTER TABLE `tipo_gasto`
  MODIFY `id_tipo_gasto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=714;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gasto`
--
ALTER TABLE `gasto`
  ADD CONSTRAINT `FK_gasto_cuadre` FOREIGN KEY (`cuadre_fk`) REFERENCES `root101_sigecon_contabilidad`.`cuadre` (`id_cuadre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_gasto_moneda` FOREIGN KEY (`moneda_fk`) REFERENCES `root101_sigecon_contabilidad`.`moneda` (`id_moneda`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_gasto_tipo_gasto` FOREIGN KEY (`tipo_gasto_fk`) REFERENCES `tipo_gasto` (`id_tipo_gasto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tipo_gasto`
--
ALTER TABLE `tipo_gasto`
  ADD CONSTRAINT `FK_tipo_gasto_gorma_pago` FOREIGN KEY (`forma_pago_fk`) REFERENCES `root101_sigecon_contabilidad`.`forma_pago` (`id_forma_pago`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tipo_gasto_moneda` FOREIGN KEY (`moneda_defecto_fk`) REFERENCES `root101_sigecon_contabilidad`.`moneda` (`id_moneda`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tipo_gasto_tipo_op` FOREIGN KEY (`tipo_operacion_contable_defecto_fk`) REFERENCES `root101_sigecon_contabilidad`.`tipo_operacion_contable` (`id_tipo_operacion`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
