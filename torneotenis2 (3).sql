-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-11-2021 a las 23:07:00
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
-- Base de datos: `torneotenis2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuentro`
--

CREATE TABLE `encuentro` (
  `idEncuentro` int(11) NOT NULL,
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

--
-- Volcado de datos para la tabla `encuentro`
--

INSERT INTO `encuentro` (`idEncuentro`, `jugador1`, `jugador2`, `fechaEncuentro`, `resultado`, `jugadorGanador`, `estado`, `idEstadio`, `activo`, `idTorneo`) VALUES
(2, 4, 5, '1999-03-11', '60-30', 4, 'activo', 3, 1, 2);

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

--
-- Volcado de datos para la tabla `estadio`
--

INSERT INTO `estadio` (`idEstadio`, `nombre`, `ciudad`, `categoria`, `activo`, `direComercial`, `dimension`) VALUES
(3, 'Martin', 'San Luis', 'Cemento', 0, 'Av Fundador', '20*50'),
(4, 'Juan Gilberto Funes', 'La Punta', 'Cemento', 1, 'Av Los Tilos', '20*30'),
(5, 'La Lucha', 'San Luis', 'cesped', 1, 'Av Los puqios', '25*30');

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
  `manoHabil` varchar(30) NOT NULL,
  `torneosGanados` int(11) NOT NULL,
  `ranking` int(11) NOT NULL,
  `puntaje` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`idJugador`, `nombre`, `dni`, `fechaNac`, `altura`, `peso`, `estilo`, `manoHabil`, `torneosGanados`, `ranking`, `puntaje`, `activo`) VALUES
(4, 'Julio', 12235235, '1996-03-23', 1.78, 78.3, 'agresivo', 'derecho', 0, 0, 0, 1),
(5, 'Mario', 23565565, '1996-03-23', 1.78, 78.3, 'agresivo', 'Zurdo', 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patrocinio`
--

CREATE TABLE `patrocinio` (
  `idPatrocinio` int(11) NOT NULL,
  `idSponsor` int(11) NOT NULL,
  `idJugador` int(11) NOT NULL,
  `fechIniContrato` date NOT NULL,
  `fechFinContrato` date NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `Indumentaria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `patrocinio`
--

INSERT INTO `patrocinio` (`idPatrocinio`, `idSponsor`, `idJugador`, `fechIniContrato`, `fechFinContrato`, `activo`, `Indumentaria`) VALUES
(1, 2, 4, '2021-03-05', '2025-03-05', 1, 'indumentaria'),
(2, 2, 4, '2021-03-05', '2025-03-05', 1, 'Calsado'),
(3, 3, 5, '2021-03-05', '2025-03-05', 1, 'Indumentaria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sponsor`
--

CREATE TABLE `sponsor` (
  `idSponsor` int(11) NOT NULL,
  `marca` varchar(40) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sponsor`
--

INSERT INTO `sponsor` (`idSponsor`, `marca`, `activo`) VALUES
(2, 'Adidas2', 1),
(3, 'Nike', 1);

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
-- Volcado de datos para la tabla `torneo`
--

INSERT INTO `torneo` (`idTorneo`, `nombre`, `fechaNacInicio`, `fechaNacFinal`, `activo`) VALUES
(2, 'La Cruda', '2021-11-10', '2021-12-12', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `encuentro`
--
ALTER TABLE `encuentro`
  ADD PRIMARY KEY (`idEncuentro`),
  ADD KEY `j1` (`jugador1`),
  ADD KEY `j2` (`jugador2`),
  ADD KEY `ganador2` (`jugadorGanador`),
  ADD KEY `estadio` (`idEstadio`);

--
-- Indices de la tabla `estadio`
--
ALTER TABLE `estadio`
  ADD PRIMARY KEY (`idEstadio`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`idJugador`);

--
-- Indices de la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  ADD PRIMARY KEY (`idPatrocinio`),
  ADD KEY `patrocinio` (`idSponsor`),
  ADD KEY `jugador` (`idJugador`);

--
-- Indices de la tabla `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`idSponsor`);

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
  MODIFY `idEncuentro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `estadio`
--
ALTER TABLE `estadio`
  MODIFY `idEstadio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `idJugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  MODIFY `idPatrocinio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `idSponsor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `torneo`
--
ALTER TABLE `torneo`
  MODIFY `idTorneo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `encuentro`
--
ALTER TABLE `encuentro`
  ADD CONSTRAINT `encuentro_ibfk_1` FOREIGN KEY (`idEncuentro`) REFERENCES `torneo` (`idTorneo`),
  ADD CONSTRAINT `estadio` FOREIGN KEY (`idEstadio`) REFERENCES `estadio` (`idEstadio`),
  ADD CONSTRAINT `j1` FOREIGN KEY (`jugador1`) REFERENCES `jugador` (`idJugador`),
  ADD CONSTRAINT `j2` FOREIGN KEY (`jugador2`) REFERENCES `jugador` (`idJugador`),
  ADD CONSTRAINT `jGanador` FOREIGN KEY (`jugadorGanador`) REFERENCES `jugador` (`idJugador`);

--
-- Filtros para la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  ADD CONSTRAINT `jugador` FOREIGN KEY (`idJugador`) REFERENCES `jugador` (`idJugador`),
  ADD CONSTRAINT `patrocinio` FOREIGN KEY (`idSponsor`) REFERENCES `sponsor` (`idSponsor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
