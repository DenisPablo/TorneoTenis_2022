-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-10-2021 a las 15:01:15
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `TenisCorrecion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuentro`
--

CREATE TABLE `encuentro` (
  `idPartido` int(11) NOT NULL,
  `jugador1` int(11) NOT NULL,
  `jugador2` int(11) NOT NULL,
  `fechaEncuentro` date NOT NULL,
  `resultado` varchar(30) NOT NULL,
  `jugadorGanador` int(11) DEFAULT NULL,
  `estado` varchar(30) NOT NULL,
  `idEstadio` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `idTorneo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadio`
--

CREATE TABLE `estadio` (
  `idEstadio` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `categoria` varchar(30) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `direComercial` varchar(80) NOT NULL,
  `dimension` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `idJugador` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `dni` int(11) NOT NULL,
  `fechaNac` date NOT NULL,
  `altura` double NOT NULL,
  `peso` double NOT NULL,
  `estilo` varchar(40) NOT NULL,
  `manoHabil` tinyint(1) NOT NULL,
  `torneosGanados` int(11) NOT NULL,
  `ranking` int(11) NOT NULL,
  `idPatrocinadores` int(11) NOT NULL,
  `puntaje` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sponsor`
--

CREATE TABLE `sponsor` (
  `idPatrocinadores` int(11) NOT NULL,
  `marca` varchar(40) NOT NULL,
  `indumentaria` varchar(40) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneo`
--

CREATE TABLE `torneo` (
  `idTorneo` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `fechaNacInicio` date NOT NULL,
  `fechaNacFinal` date NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `encuentro`
--
ALTER TABLE `encuentro`
  ADD PRIMARY KEY (`idPartido`),
  ADD KEY `j1` (`jugador1`),
  ADD KEY `j2` (`jugador2`),
  ADD KEY `ganador2` (`jugadorGanador`),
  ADD KEY `estadio` (`idEstadio`),
  ADD KEY `torneo` (`idTorneo`);

--
-- Indices de la tabla `estadio`
--
ALTER TABLE `estadio`
  ADD PRIMARY KEY (`idEstadio`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`idJugador`),
  ADD KEY `Sponsor` (`idPatrocinadores`);

--
-- Indices de la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  ADD PRIMARY KEY (`idPatrocinio`),
  ADD KEY `patrocinio` (`idPatrociador`),
  ADD KEY `jugador` (`idJugador`);

--
-- Indices de la tabla `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`idPatrocinadores`);

--
-- Indices de la tabla `torneo`
--
ALTER TABLE `torneo`
  ADD PRIMARY KEY (`idTorneo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `encuentro`
--
ALTER TABLE `encuentro`
  MODIFY `idPartido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estadio`
--
ALTER TABLE `estadio`
  MODIFY `idEstadio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `idJugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `idPatrocinadores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `torneo`
--
ALTER TABLE `torneo`
  MODIFY `idTorneo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `encuentro`
--
ALTER TABLE `encuentro`
  ADD CONSTRAINT `estadio` FOREIGN KEY (`idEstadio`) REFERENCES `estadio` (`idEstadio`),
  ADD CONSTRAINT `j1` FOREIGN KEY (`jugador1`) REFERENCES `jugador` (`idJugador`),
  ADD CONSTRAINT `j2` FOREIGN KEY (`jugador2`) REFERENCES `jugador` (`idJugador`),
  ADD CONSTRAINT `torneo` FOREIGN KEY (`idTorneo`) REFERENCES `torneo` (`idTorneo`);

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
