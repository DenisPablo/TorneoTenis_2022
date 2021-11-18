-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2021 a las 05:29:49
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
(28, 5, 8, '2021-11-11', '12x30', 8, 'Finalizado', 6, 1, 3),
(30, 9, 12, '2021-11-26', '20', 0, 'En Juego', 7, 1, 3),
(31, 5, 9, '2021-11-02', '', 0, 'Programado', 6, 1, 4),
(32, 8, 11, '2021-11-11', '51x36', 11, 'Finalizado', 6, 1, 4),
(33, 5, 10, '2021-11-11', '', 0, 'En Juego', 7, 1, 4);

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
  `dimension` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL COMMENT 'enUso (1) o desUso (0)'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estadio`
--

INSERT INTO `estadio` (`idEstadio`, `nombre`, `ciudad`, `categoria`, `activo`, `direComercial`, `dimension`, `estado`) VALUES
(3, 'Martin', 'San Luis', 'Cemento', 1, 'Av Fundador', '20*50', 0),
(4, 'Juan Gilberto Funes', 'La Punta', 'Cemento', 1, 'Av Los Tilos', '20*30', 0),
(5, 'La Lucha', 'San Luis', 'cesped', 1, 'Av Los puqios', '25*30', 0),
(6, 'Juan Gilberto Funes', 'La Punta', 'Cemento', 1, 'Av Los Tilos', '20*30', 0),
(7, 'La Lucha', 'San Luis', 'cesped', 1, 'Av Los puqios', '25*30', 0),
(8, 'Pepe', 'San Luis', 'Cemento', 1, 'Av Fundador ', '20*30', 0),
(9, 'dasd', 'asdas', 'Cesped', 1, 'asda', '20x30', 0);

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
(4, 'Julio', 12235235, '1996-03-23', 1.78, 78.3, 'agresivo', 'derecho', 0, 3, 2, 1),
(5, 'Mario', 23565565, '1996-03-23', 1.78, 78.3, 'agresivo', 'Zurdo', 0, 4, 2, 1),
(8, 'asdljah', 12345678, '2021-11-03', 1.78, 78.3, 'Agresivo', 'Derecha', 0, 1, 3, 1),
(9, 'cPepe', 12345678, '2021-11-01', 178.3, 87.3, 'Voleadores', 'Derecha', 0, 5, 1, 1),
(10, 'Chavo', 1323564, '2021-11-04', 1.69, 67.3, 'Voleadores', 'Derecha', 0, 6, 0, 1),
(11, 'Luis', 23452685, '2021-11-01', 178, 780, 'Voleadores', 'Izquierda', 0, 2, 3, 1),
(12, 'sdad', 13546412, '2021-11-04', 178, 780, 'Agresivo', 'Derecha', 0, 7, 0, 1);

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
(7, 10, 5, '2021-11-01', '2021-11-28', 1, 'Relojes'),
(8, 6, 10, '2021-11-09', '2021-11-28', 1, 'Ropa');

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
(3, 'Nike', 1),
(6, 'Adidas', 1),
(7, 'Nike', 1),
(8, 'wilson', 1),
(9, 'Fila', 1),
(10, 'asda', 1),
(11, 'Adidass', 1);

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
(2, 'La Cruda', '2021-01-11', '2021-12-12', 1),
(3, 'The Champion', '2021-03-11', '2022-03-11', 1),
(4, 'ggggggggggg', '2021-11-01', '2021-11-28', 1),
(5, 'Plata', '2021-11-01', '2021-11-28', 1),
(6, 'La Liga', '2021-11-01', '2021-11-20', 1);

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
  ADD KEY `estadio` (`idEstadio`),
  ADD KEY `encuentro_ibfk_1` (`idTorneo`);

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
  MODIFY `idEncuentro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de la tabla `estadio`
--
ALTER TABLE `estadio`
  MODIFY `idEstadio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `idJugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  MODIFY `idPatrocinio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `idSponsor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `torneo`
--
ALTER TABLE `torneo`
  MODIFY `idTorneo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `encuentro`
--
ALTER TABLE `encuentro`
  ADD CONSTRAINT `encuentro_ibfk_1` FOREIGN KEY (`idTorneo`) REFERENCES `torneo` (`idTorneo`),
  ADD CONSTRAINT `estadio` FOREIGN KEY (`idEstadio`) REFERENCES `estadio` (`idEstadio`),
  ADD CONSTRAINT `j1` FOREIGN KEY (`jugador1`) REFERENCES `jugador` (`idJugador`),
  ADD CONSTRAINT `j2` FOREIGN KEY (`jugador2`) REFERENCES `jugador` (`idJugador`);

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
