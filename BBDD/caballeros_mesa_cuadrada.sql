-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-03-2024 a las 17:20:46
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `caballeros_mesa_cuadrada`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arma`
--

CREATE TABLE `arma` (
  `id` int(11) NOT NULL,
  `daño` int(11) NOT NULL,
  `tipo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `arma`
--

INSERT INTO `arma` (`id`, `daño`, `tipo`) VALUES
(2, 2, 'ESPADA CORTA'),
(3, 3, 'ESPADA LARGA'),
(4, 4, 'CLAYMORE'),
(5, 5, 'ZWEIHÄNDER'),
(7, 1, 'Daga');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caballero`
--

CREATE TABLE `caballero` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `fuerza` int(11) NOT NULL,
  `nivel` int(11) NOT NULL,
  `id_arma` int(11) DEFAULT NULL,
  `id_escudo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `caballero`
--

INSERT INTO `caballero` (`id`, `nombre`, `fuerza`, `nivel`, `id_arma`, `id_escudo`) VALUES
(1, 'DON QUIJOTE', 50, 7, 5, 1),
(2, 'Rodrigo Diaz de vivar', 3, 1, 2, 6),
(3, 'Ricardo corazon de leon', 15, 6, 7, 6),
(7, 'Sir Galahad', 10, 9, 3, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caballo`
--

CREATE TABLE `caballo` (
  `nombre` varchar(255) NOT NULL,
  `velocidad_maxima` int(11) NOT NULL,
  `resistencia` int(11) NOT NULL,
  `id_caballero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `caballo`
--

INSERT INTO `caballo` (`nombre`, `velocidad_maxima`, `resistencia`, `id_caballero`) VALUES
('Perdigona', 90, 25, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escudero`
--

CREATE TABLE `escudero` (
  `id_caballero` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nivel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `escudero`
--

INSERT INTO `escudero` (`id_caballero`, `nombre`, `nivel`) VALUES
(1, 'Escudero', 3),
(3, 'yoquese', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escudo`
--

CREATE TABLE `escudo` (
  `id` int(11) NOT NULL,
  `defensa` int(11) NOT NULL,
  `tipo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `escudo`
--

INSERT INTO `escudo` (`id`, `defensa`, `tipo`) VALUES
(1, 3, 'Rodela'),
(2, 2, 'Escudo'),
(6, 1, 'Broquel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lucha`
--

CREATE TABLE `lucha` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `caballero1` int(11) NOT NULL,
  `caballero2` int(11) NOT NULL,
  `ganador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `lucha`
--

INSERT INTO `lucha` (`id`, `fecha`, `caballero1`, `caballero2`, `ganador`) VALUES
(1, '2024-03-18', 1, 2, 1),
(2, '2024-03-18', 1, 2, 1),
(3, '2024-03-19', 1, 2, 1),
(4, '2024-03-20', 1, 2, 1),
(5, '2024-03-20', 1, 2, 1),
(6, '2024-03-20', 1, 2, 1),
(7, '2024-03-20', 1, 3, 1),
(9, '2024-03-20', 1, 3, 1),
(11, '2024-03-20', 1, 2, 1),
(13, '2024-03-20', 1, 3, 1),
(14, '2024-03-20', 3, 2, 3),
(15, '2024-03-20', 3, 2, 3),
(16, '2024-03-20', 3, 1, 3),
(17, '2024-03-20', 3, 2, 3),
(18, '2024-03-20', 3, 2, 3),
(19, '2024-03-20', 3, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `arma`
--
ALTER TABLE `arma`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `caballero`
--
ALTER TABLE `caballero`
  ADD PRIMARY KEY (`id`),
  ADD KEY `caballero_escudo` (`id_escudo`),
  ADD KEY `caballero_arma` (`id_arma`);

--
-- Indices de la tabla `caballo`
--
ALTER TABLE `caballo`
  ADD PRIMARY KEY (`id_caballero`);

--
-- Indices de la tabla `escudero`
--
ALTER TABLE `escudero`
  ADD PRIMARY KEY (`id_caballero`);

--
-- Indices de la tabla `escudo`
--
ALTER TABLE `escudo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `lucha`
--
ALTER TABLE `lucha`
  ADD PRIMARY KEY (`id`,`fecha`,`caballero1`,`caballero2`),
  ADD KEY `LUCHA_CABALLERO1` (`caballero1`),
  ADD KEY `LUCHA_CABALLERO2` (`caballero2`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `arma`
--
ALTER TABLE `arma`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `caballero`
--
ALTER TABLE `caballero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `escudo`
--
ALTER TABLE `escudo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `lucha`
--
ALTER TABLE `lucha`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `caballero`
--
ALTER TABLE `caballero`
  ADD CONSTRAINT `caballero_arma` FOREIGN KEY (`id_arma`) REFERENCES `arma` (`id`),
  ADD CONSTRAINT `caballero_escudo` FOREIGN KEY (`id_escudo`) REFERENCES `escudo` (`id`);

--
-- Filtros para la tabla `caballo`
--
ALTER TABLE `caballo`
  ADD CONSTRAINT `FK_CABALLO` FOREIGN KEY (`id_caballero`) REFERENCES `caballero` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `escudero`
--
ALTER TABLE `escudero`
  ADD CONSTRAINT `FK_ESCUDERO` FOREIGN KEY (`id_caballero`) REFERENCES `caballero` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `lucha`
--
ALTER TABLE `lucha`
  ADD CONSTRAINT `LUCHA_CABALLERO1` FOREIGN KEY (`caballero1`) REFERENCES `caballero` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `LUCHA_CABALLERO2` FOREIGN KEY (`caballero2`) REFERENCES `caballero` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
