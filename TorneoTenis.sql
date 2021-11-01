-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-11-2021 a las 15:24:49
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `torneo tenis`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patrocinio`
--

CREATE TABLE `patrocinio` (
  `idPatrocinio` int(11) NOT NULL,
  `idPatrociador` int(11) NOT NULL,
  `idJugador` int(11) NOT NULL,
  `fechIniContrato` date NOT NULL,
  `fechFinContrato` date NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `Indumentaria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  ADD PRIMARY KEY (`idPatrocinio`),
  ADD KEY `patrocinio` (`idPatrociador`),
  ADD KEY `jugador` (`idJugador`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  ADD CONSTRAINT `jugador` FOREIGN KEY (`idJugador`) REFERENCES `jugador` (`idJugador`),
  ADD CONSTRAINT `patrocinio` FOREIGN KEY (`idPatrociador`) REFERENCES `sponsor` (`idPatrocinadores`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
