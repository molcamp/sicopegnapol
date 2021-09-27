-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-09-2021 a las 02:31:22
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sicopegnapol`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `apellido` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `dni` decimal(9,0) NOT NULL,
  `lugar_residencia` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `tiempo_permanencia` decimal(10,0) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  `id_vehiculo` int(11) NOT NULL,
  `fecha_persona` datetime NOT NULL DEFAULT current_timestamp(),
  `id_usuario` int(11) NOT NULL,
  `reincidente` int(11) DEFAULT NULL,
  `condicion_pers` int(1) NOT NULL,
  `zona` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id_persona`, `apellido`, `nombre`, `dni`, `lugar_residencia`, `tiempo_permanencia`, `tipo`, `id_vehiculo`, `fecha_persona`, `id_usuario`, `reincidente`, `condicion_pers`, `zona`) VALUES
(85, 'asdas', 'assa', '32433', 'asda', '3', 1, 150, '2020-07-07 00:51:26', 1, 0, 0, 0),
(86, 'maria', 'asas', '3342312', 'asdsad', '3', 0, 150, '2020-07-07 00:52:03', 1, 4, 0, 0),
(87, '', '', '1111', '', '0', 1, 166, '2020-07-07 03:40:49', 1, 3, 0, 0),
(92, 'ASD', 'ADSASD', '1231231', 'ASDADS', '2', 1, 190, '2020-07-09 02:50:34', 1, 2, 0, 0),
(93, 'ASDASD', 'ASDASD', '1212212', 'ASDDAS', '3', 0, 190, '2020-07-09 02:51:00', 1, 2, 0, 0),
(94, 'MOLINA', 'CARLOS MARIO ESTEBAN', '35965647', 'PARANA', '5', 1, 191, '2020-07-09 03:19:04', 1, 3, 0, 0),
(95, 'ASDASD', 'ASDASD', '99999999', 'ASAS', '2332', 1, 198, '2020-07-23 01:31:52', 1, 0, 1, 0),
(96, 'ASDA', 'SDASD', '3232323', 'ASDASD', '3', 1, 199, '2020-07-23 01:33:44', 1, 0, 0, 0),
(97, 'ASDA', 'SDASD', '3333333', 'ASDSA', '32', 1, 200, '2020-07-23 02:13:14', 1, 4, 0, 0),
(98, 'ASDASD', 'ASDASD', '3333333', 'DASDAS', '3', 1, 208, '2020-07-23 02:50:11', 1, 1, 0, 1),
(115, 'ASDASDA', 'SDASADS', '4444444', 'ASDDASD', '3', 1, 220, '2020-07-23 03:42:27', 1, 1, 0, 1),
(116, 'ASDASD', 'ASDASD', '5555555', 'ASDASD', '32', 0, 220, '2020-07-23 03:42:45', 1, 0, 0, 0),
(117, 'ASDAS', 'ASDASD', '5555555', 'ASDAS', '3', 1, 221, '2020-07-23 03:44:25', 1, 0, 0, 1),
(118, 'DADASD', 'ASDASDADS', '3223423', 'ASDASD', '3', 1, 266, '2020-07-23 05:54:44', 1, 0, 0, 1),
(119, 'ASDASD', 'ASDAS', '3434333', 'ASDASD', '3', 1, 269, '2020-07-23 05:57:56', 1, 0, 0, 1),
(120, 'MOLINA', 'MARIO', '35678456', 'PARANA', '4', 1, 272, '2020-07-23 22:02:38', 82, 1, 1, 0),
(121, 'MARIA', 'MIASASD', '35678455', 'PARANA', '4', 0, 272, '2020-07-23 22:05:26', 82, 0, 1, 1),
(122, 'MARIO', 'MOLINA', '35678456', 'PARANA', '4', 1, 273, '2020-07-23 22:07:14', 82, 0, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `usuario` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `condicion` tinyint(1) NOT NULL,
  `id_local` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `password`, `condicion`, `id_local`) VALUES
(1, 'mario', 'molina', 0, 'CONCEPCION DEL URUGUAY'),
(2, 'cte', 'canabiris', 1, ''),
(3, 'cur1', 'concepcion', 0, 'CONCEPCION DEL URUGUAY'),
(4, 'cur2', 'concepcion', 0, 'CONCEPCION DEL URUGUAY'),
(5, 'cur3', 'concepcion', 0, 'CONCEPCION DEL URUGUAY'),
(6, 'cur4', 'concepcion', 0, 'CONCEPCION DEL URUGUAY'),
(7, 'cur5', 'concepcion', 0, 'CONCEPCION DEL URUGUAY'),
(8, 'cur6', 'concepcion', 0, 'CONCEPCION DEL URUGUAY'),
(9, 'cur7', 'concepcion', 0, 'CONCEPCION DEL URUGUAY'),
(10, 'cur8', 'concepcion', 0, 'CONCEPCION DEL URUGUAY'),
(11, 'cur9', 'concepcion', 0, 'CONCEPCION DEL URUGUAY'),
(12, 'cur10', 'concepcion', 0, 'CONCEPCION DEL URUGUAY'),
(13, 'cur21', 'concepcion', 1, 'CONCEPCION DEL URUGUAY'),
(14, 'cur22', 'concepcion', 1, 'CONCEPCION DEL URUGUAY'),
(15, 'cur23', 'concepcion', 1, 'CONCEPCION DEL URUGUAY'),
(16, 'cur24', 'concepcion', 1, 'CONCEPCION DEL URUGUAY'),
(17, 'cur25', 'concepcion', 1, 'CONCEPCION DEL URUGUAY'),
(18, 'cur26', 'concepcion', 1, 'CONCEPCION DEL URUGUAY'),
(19, 'cur27', 'concepcion', 1, 'CONCEPCION DEL URUGUAY'),
(20, 'cur28', 'concepcion', 1, 'CONCEPCION DEL URUGUAY'),
(21, 'cur29', 'concepcion', 1, 'CONCEPCION DEL URUGUAY'),
(22, 'cur30', 'concepcion', 1, 'CONCEPCION DEL URUGUAY'),
(23, 'col1', 'colon', 0, 'COLON'),
(24, 'col2', 'colon', 0, 'COLON'),
(25, 'col3', 'colon', 0, 'COLON'),
(26, 'col4', 'colon', 0, 'COLON'),
(27, 'col5', 'colon', 0, 'COLON'),
(28, 'col6', 'colon', 0, 'COLON'),
(29, 'col7', 'colon', 0, 'COLON'),
(30, 'col8', 'colon', 0, 'COLON'),
(31, 'col9', 'colon', 0, 'COLON'),
(32, 'col10', 'colon', 0, 'COLON'),
(33, 'col21', 'colon', 1, 'COLON'),
(34, 'col22', 'colon', 1, 'COLON'),
(35, 'col23', 'colon', 1, 'COLON'),
(36, 'col24', 'colon', 1, 'COLON'),
(37, 'col25', 'colon', 1, 'COLON'),
(38, 'col26', 'colon', 1, 'COLON'),
(39, 'col27', 'colon', 1, 'COLON'),
(40, 'col28', 'colon', 1, 'COLON'),
(41, 'col29', 'colon', 1, 'COLON'),
(42, 'col30', 'colon', 1, 'COLON'),
(43, 'sjo1', 'sanjose', 0, 'SAN JOSE'),
(44, 'sjo2', 'sanjose', 0, 'SAN JOSE'),
(45, 'sjo3', 'sanjose', 0, 'SAN JOSE'),
(46, 'sjo4', 'sanjose', 0, 'SAN JOSE'),
(47, 'sjo5', 'sanjose', 0, 'SAN JOSE'),
(48, 'sjo6', 'sanjose', 0, 'SAN JOSE'),
(49, 'sjo7', 'sanjose', 0, 'SAN JOSE'),
(50, 'sjo8', 'sanjose', 0, 'SAN JOSE'),
(51, 'sjo9', 'sanjose', 0, 'SAN JOSE'),
(52, 'sjo10', 'sanjose', 0, 'SAN JOSE'),
(53, 'sjo21', 'sanjose', 1, 'SAN JOSE'),
(54, 'sjo22', 'sanjose', 1, 'SAN JOSE'),
(55, 'sjo23', 'sanjose', 1, 'SAN JOSE'),
(56, 'sjo24', 'sanjose', 1, 'SAN JOSE'),
(57, 'sjo25', 'sanjose', 1, 'SAN JOSE'),
(58, 'sjo26', 'sanjose', 1, 'SAN JOSE'),
(59, 'sjo27', 'sanjose', 1, 'SAN JOSE'),
(60, 'sjo28', 'sanjose', 1, 'SAN JOSE'),
(61, 'sjo29', 'sanjose', 1, 'SAN JOSE'),
(62, 'sjo30', 'sanjose', 1, 'SAN JOSE'),
(63, 'vel1', 'villaelisa', 0, 'VILLA ELISA'),
(64, 'vel2', 'villaelisa', 0, 'VILLA ELISA'),
(65, 'vel3', 'villaelisa', 0, 'VILLA ELISA'),
(66, 'vel4', 'villaelisa', 0, 'VILLA ELISA'),
(67, 'vel5', 'villaelisa', 0, 'VILLA ELISA'),
(68, 'vel6', 'villaelisa', 0, 'VILLA ELISA'),
(69, 'vel7', 'villaelisa', 0, 'VILLA ELISA'),
(70, 'vel8', 'villaelisa', 0, 'VILLA ELISA'),
(71, 'vel9', 'villaelisa', 0, 'VILLA ELISA'),
(72, 'vel10', 'villaelisa', 0, 'VILLA ELISA'),
(73, 'vel21', 'villaelisa', 1, 'VILLA ELISA'),
(74, 'vel22', 'villaelisa', 1, 'VILLA ELISA'),
(75, 'vel23', 'villaelisa', 1, 'VILLA ELISA'),
(76, 'vel24', 'villaelisa', 1, 'VILLA ELISA'),
(77, 'vel25', 'villaelisa', 1, 'VILLA ELISA'),
(78, 'vel26', 'villaelisa', 1, 'VILLA ELISA'),
(79, 'vel27', 'villaelisa', 1, 'VILLA ELISA'),
(80, 'vel28', 'villaelisa', 1, 'VILLA ELISA'),
(81, 'vel29', 'villaelisa', 1, 'VILLA ELISA'),
(82, 'vel30', 'villaelisa', 1, 'VILLA ELISA'),
(83, 'pli1', 'liebig', 0, 'PUEBO LIEBIG'),
(84, 'pli2', 'liebig', 0, 'PUEBO LIEBIG'),
(85, 'pli3', 'liebig', 0, 'PUEBO LIEBIG'),
(86, 'pli4', 'liebig', 0, 'PUEBO LIEBIG'),
(87, 'pli5', 'liebig', 0, 'PUEBO LIEBIG'),
(88, 'pli6', 'liebig', 0, 'PUEBO LIEBIG'),
(89, 'pli7', 'liebig', 0, 'PUEBO LIEBIG'),
(90, 'pli8', 'liebig', 0, 'PUEBO LIEBIG'),
(91, 'pli9', 'liebig', 0, 'PUEBO LIEBIG'),
(92, 'pli10', 'liebig', 0, 'PUEBO LIEBIG'),
(93, 'pli21', 'liebig', 1, 'PUEBO LIEBIG'),
(94, 'pli22', 'liebig', 1, 'PUEBO LIEBIG'),
(95, 'pli23', 'liebig', 1, 'PUEBO LIEBIG'),
(96, 'pli24', 'liebig', 1, 'PUEBO LIEBIG'),
(97, 'pli25', 'liebig', 1, 'PUEBO LIEBIG'),
(98, 'pli26', 'liebig', 1, 'PUEBO LIEBIG'),
(99, 'pli27', 'liebig', 1, 'PUEBO LIEBIG'),
(100, 'pli28', 'liebig', 1, 'PUEBO LIEBIG'),
(101, 'pli29', 'liebig', 1, 'PUEBO LIEBIG'),
(102, 'pli30', 'liebig', 1, 'PUEBO LIEBIG'),
(103, 'uba1', 'ubajay', 0, 'UBAJAY'),
(104, 'uba2', 'ubajay', 0, 'UBAJAY'),
(105, 'uba3', 'ubajay', 0, 'UBAJAY'),
(106, 'uba4', 'ubajay', 0, 'UBAJAY'),
(107, 'uba5', 'ubajay', 0, 'UBAJAY'),
(108, 'uba6', 'ubajay', 0, 'UBAJAY'),
(109, 'uba7', 'ubajay', 0, 'UBAJAY'),
(110, 'uba8', 'ubajay', 0, 'UBAJAY'),
(111, 'uba9', 'ubajay', 0, 'UBAJAY'),
(112, 'uba10', 'ubajay', 0, 'UBAJAY'),
(113, 'uba21', 'ubajay', 1, 'UBAJAY'),
(114, 'uba22', 'ubajay', 1, 'UBAJAY'),
(115, 'uba23', 'ubajay', 1, 'UBAJAY'),
(116, 'uba24', 'ubajay', 1, 'UBAJAY'),
(117, 'uba25', 'ubajay', 1, 'UBAJAY'),
(118, 'uba26', 'ubajay', 1, 'UBAJAY'),
(119, 'uba27', 'ubajay', 1, 'UBAJAY'),
(120, 'uba28', 'ubajay', 1, 'UBAJAY'),
(121, 'uba29', 'ubajay', 1, 'UBAJAY'),
(122, 'uba30', 'ubajay', 1, 'UBAJAY'),
(123, 'vil1', 'villaguay', 0, 'VILLAGUAY'),
(124, 'vil2', 'villaguay', 0, 'VILLAGUAY'),
(125, 'vil3', 'villaguay', 0, 'VILLAGUAY'),
(126, 'vil4', 'villaguay', 0, 'VILLAGUAY'),
(127, 'vil5', 'villaguay', 0, 'VILLAGUAY'),
(128, 'vil6', 'villaguay', 0, 'VILLAGUAY'),
(129, 'vil7', 'villaguay', 0, 'VILLAGUAY'),
(130, 'vil8', 'villaguay', 0, 'VILLAGUAY'),
(131, 'vil9', 'villaguay', 0, 'VILLAGUAY'),
(132, 'vil10', 'villaguay', 0, 'VILLAGUAY'),
(133, 'vil21', 'villaguay', 1, 'VILLAGUAY'),
(134, 'vil22', 'villaguay', 1, 'VILLAGUAY'),
(135, 'vil23', 'villaguay', 1, 'VILLAGUAY'),
(136, 'vil24', 'villaguay', 1, 'VILLAGUAY'),
(137, 'vil25', 'villaguay', 1, 'VILLAGUAY'),
(138, 'vil26', 'villaguay', 1, 'VILLAGUAY'),
(139, 'vil27', 'villaguay', 1, 'VILLAGUAY'),
(140, 'vil28', 'villaguay', 1, 'VILLAGUAY'),
(141, 'vil29', 'villaguay', 1, 'VILLAGUAY'),
(142, 'vil30', 'villaguay', 1, 'VILLAGUAY'),
(143, 'slu1', 'sauce', 0, 'SAUCE DE LUNA'),
(144, 'slu2', 'sauce', 0, 'SAUCE DE LUNA'),
(145, 'slu3', 'sauce', 0, 'SAUCE DE LUNA'),
(146, 'slu4', 'sauce', 0, 'SAUCE DE LUNA'),
(147, 'slu5', 'sauce', 0, 'SAUCE DE LUNA'),
(148, 'slu6', 'sauce', 0, 'SAUCE DE LUNA'),
(149, 'slu7', 'sauce', 0, 'SAUCE DE LUNA'),
(150, 'slu8', 'sauce', 0, 'SAUCE DE LUNA'),
(151, 'slu9', 'sauce', 0, 'SAUCE DE LUNA'),
(152, 'slu10', 'sauce', 0, 'SAUCE DE LUNA'),
(153, 'slu21', 'sauce', 1, 'SAUCE DE LUNA'),
(154, 'slu22', 'sauce', 1, 'SAUCE DE LUNA'),
(155, 'slu23', 'sauce', 1, 'SAUCE DE LUNA'),
(156, 'slu24', 'sauce', 1, 'SAUCE DE LUNA'),
(157, 'slu25', 'sauce', 1, 'SAUCE DE LUNA'),
(158, 'slu26', 'sauce', 1, 'SAUCE DE LUNA'),
(159, 'slu27', 'sauce', 1, 'SAUCE DE LUNA'),
(160, 'slu28', 'sauce', 1, 'SAUCE DE LUNA'),
(161, 'slu29', 'sauce', 1, 'SAUCE DE LUNA'),
(162, 'slu30', 'sauce', 1, 'SAUCE DE LUNA'),
(163, 'bas1', 'Basavilbaso', 0, 'BASAVILBASO'),
(164, 'bas2', 'Basavilbaso', 0, 'BASAVILBASO'),
(165, 'bas3', 'Basavilbaso', 0, 'BASAVILBASO'),
(166, 'bas4', 'Basavilbaso', 0, 'BASAVILBASO'),
(167, 'bas5', 'Basavilbaso', 0, 'BASAVILBASO'),
(168, 'bas6', 'Basavilbaso', 0, 'BASAVILBASO'),
(169, 'bas7', 'Basavilbaso', 0, 'BASAVILBASO'),
(170, 'bas8', 'Basavilbaso', 0, 'BASAVILBASO'),
(171, 'bas9', 'Basavilbaso', 0, 'BASAVILBASO'),
(172, 'bas10', 'Basavilbaso', 0, 'BASAVILBASO'),
(173, 'bas21', 'Basavilbaso', 1, 'BASAVILBASO'),
(174, 'bas22', 'Basavilbaso', 1, 'BASAVILBASO'),
(175, 'bas23', 'Basavilbaso', 1, 'BASAVILBASO'),
(176, 'bas24', 'Basavilbaso', 1, 'BASAVILBASO'),
(177, 'bas25', 'Basavilbaso', 1, 'BASAVILBASO'),
(178, 'bas26', 'Basavilbaso', 1, 'BASAVILBASO'),
(179, 'bas27', 'Basavilbaso', 1, 'BASAVILBASO'),
(180, 'bas28', 'Basavilbaso', 1, 'BASAVILBASO'),
(181, 'bas29', 'Basavilbaso', 1, 'BASAVILBASO'),
(182, 'bas30', 'Basavilbaso', 1, 'BASAVILBASO'),
(183, 'sju1', 'sanjusto', 0, 'SAN JUSTO'),
(184, 'sju2', 'sanjusto', 0, 'SAN JUSTO'),
(185, 'sju3', 'sanjusto', 0, 'SAN JUSTO'),
(186, 'sju4', 'sanjusto', 0, 'SAN JUSTO'),
(187, 'sju5', 'sanjusto', 0, 'SAN JUSTO'),
(188, 'sju6', 'sanjusto', 0, 'SAN JUSTO'),
(189, 'sju7', 'sanjusto', 0, 'SAN JUSTO'),
(190, 'sju8', 'sanjusto', 0, 'SAN JUSTO'),
(191, 'sju9', 'sanjusto', 0, 'SAN JUSTO'),
(192, 'sju10', 'sanjusto', 0, 'SAN JUSTO'),
(193, 'sju21', 'sanjusto', 1, 'SAN JUSTO'),
(194, 'sju22', 'sanjusto', 1, 'SAN JUSTO'),
(195, 'sju23', 'sanjusto', 1, 'SAN JUSTO'),
(196, 'sju24', 'sanjusto', 1, 'SAN JUSTO'),
(197, 'sju25', 'sanjusto', 1, 'SAN JUSTO'),
(198, 'sju26', 'sanjusto', 1, 'SAN JUSTO'),
(199, 'sju27', 'sanjusto', 1, 'SAN JUSTO'),
(200, 'sju28', 'sanjusto', 1, 'SAN JUSTO'),
(201, 'sju29', 'sanjusto', 1, 'SAN JUSTO'),
(202, 'sju30', 'sanjusto', 1, 'SAN JUSTO'),
(203, 'cas1', 'caseros', 0, 'CACEROS'),
(204, 'cas2', 'caseros', 0, 'CACEROS'),
(205, 'cas3', 'caseros', 0, 'CACEROS'),
(206, 'cas4', 'caseros', 0, 'CACEROS'),
(207, 'cas5', 'caseros', 0, 'CACEROS'),
(208, 'cas6', 'caseros', 0, 'CACEROS'),
(209, 'cas7', 'caseros', 0, 'CACEROS'),
(210, 'cas8', 'caseros', 0, 'CACEROS'),
(211, 'cas9', 'caseros', 0, 'CACEROS'),
(212, 'cas10', 'caseros', 0, 'CACEROS'),
(213, 'cas21', 'caseros', 1, 'CACEROS'),
(214, 'cas22', 'caseros', 1, 'CACEROS'),
(215, 'cas23', 'caseros', 1, 'CACEROS'),
(216, 'cas24', 'caseros', 1, 'CACEROS'),
(217, 'cas25', 'caseros', 1, 'CACEROS'),
(218, 'cas26', 'caseros', 1, 'CACEROS'),
(219, 'cas27', 'caseros', 1, 'CACEROS'),
(220, 'cas28', 'caseros', 1, 'CACEROS'),
(221, 'cas29', 'caseros', 1, 'CACEROS'),
(222, 'cas30', 'caseros', 1, 'CACEROS'),
(223, 'pro1', 'pronunciamiento', 0, 'PRONUNCIAMIENTO'),
(224, 'pro2', 'pronunciamiento', 0, 'PRONUNCIAMIENTO'),
(225, 'pro3', 'pronunciamiento', 0, 'PRONUNCIAMIENTO'),
(226, 'pro4', 'pronunciamiento', 0, 'PRONUNCIAMIENTO'),
(227, 'pro5', 'pronunciamiento', 0, 'PRONUNCIAMIENTO'),
(228, 'pro6', 'pronunciamiento', 0, 'PRONUNCIAMIENTO'),
(229, 'pro7', 'pronunciamiento', 0, 'PRONUNCIAMIENTO'),
(230, 'pro8', 'pronunciamiento', 0, 'PRONUNCIAMIENTO'),
(231, 'pro9', 'pronunciamiento', 0, 'PRONUNCIAMIENTO'),
(232, 'pro10', 'pronunciamiento', 0, 'PRONUNCIAMIENTO'),
(233, 'pro21', 'pronunciamiento', 1, 'PRONUNCIAMIENTO'),
(234, 'pro22', 'pronunciamiento', 1, 'PRONUNCIAMIENTO'),
(235, 'pro23', 'pronunciamiento', 1, 'PRONUNCIAMIENTO'),
(236, 'pro24', 'pronunciamiento', 1, 'PRONUNCIAMIENTO'),
(237, 'pro25', 'pronunciamiento', 1, 'PRONUNCIAMIENTO'),
(238, 'pro26', 'pronunciamiento', 1, 'PRONUNCIAMIENTO'),
(239, 'pro27', 'pronunciamiento', 1, 'PRONUNCIAMIENTO'),
(240, 'pro28', 'pronunciamiento', 1, 'PRONUNCIAMIENTO'),
(241, 'pro29', 'pronunciamiento', 1, 'PRONUNCIAMIENTO'),
(242, 'pro30', 'pronunciamiento', 1, 'PRONUNCIAMIENTO'),
(243, 'vdo1', 'dominguez', 0, 'VILLA DOMINGUEZ'),
(244, 'vdo2', 'dominguez', 0, 'VILLA DOMINGUEZ'),
(245, 'vdo3', 'dominguez', 0, 'VILLA DOMINGUEZ'),
(246, 'vdo4', 'dominguez', 0, 'VILLA DOMINGUEZ'),
(247, 'vdo5', 'dominguez', 0, 'VILLA DOMINGUEZ'),
(248, 'vdo6', 'dominguez', 0, 'VILLA DOMINGUEZ'),
(249, 'vdo7', 'dominguez', 0, 'VILLA DOMINGUEZ'),
(250, 'vdo8', 'dominguez', 0, 'VILLA DOMINGUEZ'),
(251, 'vdo9', 'dominguez', 0, 'VILLA DOMINGUEZ'),
(252, 'vdo10', 'dominguez', 0, 'VILLA DOMINGUEZ'),
(253, 'vdo21', 'dominguez', 1, 'VILLA DOMINGUEZ'),
(254, 'vdo22', 'dominguez', 1, 'VILLA DOMINGUEZ'),
(255, 'vdo23', 'dominguez', 1, 'VILLA DOMINGUEZ'),
(256, 'vdo24', 'dominguez', 1, 'VILLA DOMINGUEZ'),
(257, 'vdo25', 'dominguez', 1, 'VILLA DOMINGUEZ'),
(258, 'vdo26', 'dominguez', 1, 'VILLA DOMINGUEZ'),
(259, 'vdo27', 'dominguez', 1, 'VILLA DOMINGUEZ'),
(260, 'vdo28', 'dominguez', 1, 'VILLA DOMINGUEZ'),
(261, 'vdo29', 'dominguez', 1, 'VILLA DOMINGUEZ'),
(262, 'vdo30', 'dominguez', 1, 'VILLA DOMINGUEZ'),
(263, 'vcl1', 'villaclara', 0, 'VILLA CLARA'),
(264, 'vcl2', 'villaclara', 0, 'VILLA CLARA'),
(265, 'vcl3', 'villaclara', 0, 'VILLA CLARA'),
(266, 'vcl4', 'villaclara', 0, 'VILLA CLARA'),
(267, 'vcl5', 'villaclara', 0, 'VILLA CLARA'),
(268, 'vcl6', 'villaclara', 0, 'VILLA CLARA'),
(269, 'vcl7', 'villaclara', 0, 'VILLA CLARA'),
(270, 'vcl8', 'villaclara', 0, 'VILLA CLARA'),
(271, 'vcl9', 'villaclara', 0, 'VILLA CLARA'),
(272, 'vcl10', 'villaclara', 0, 'VILLA CLARA'),
(273, 'vcl21', 'villaclara', 1, 'VILLA CLARA'),
(274, 'vcl22', 'villaclara', 1, 'VILLA CLARA'),
(275, 'vcl23', 'villaclara', 1, 'VILLA CLARA'),
(276, 'vcl24', 'villaclara', 1, 'VILLA CLARA'),
(277, 'vcl25', 'villaclara', 1, 'VILLA CLARA'),
(278, 'vcl26', 'villaclara', 1, 'VILLA CLARA'),
(279, 'vcl27', 'villaclara', 1, 'VILLA CLARA'),
(280, 'vcl28', 'villaclara', 1, 'VILLA CLARA'),
(281, 'vcl29', 'villaclara', 1, 'VILLA CLARA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `id_veh` int(11) NOT NULL,
  `dominio` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_vehiculo` datetime NOT NULL DEFAULT current_timestamp(),
  `tipo_vehiculo` int(1) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`id_veh`, `dominio`, `descripcion`, `fecha_vehiculo`, `tipo_vehiculo`, `id_usuario`) VALUES
(150, 'as324za', 'auto', '2020-07-07 00:51:14', 0, 1),
(166, 'asas', 'asas', '2020-07-08 03:40:45', 1, 1),
(189, 'ASASDAD', 'ASDASD', '2020-07-09 02:17:25', 0, 1),
(190, 'ASDASD', 'ASDADS', '2020-07-09 02:49:45', 0, 1),
(191, 'HSHS', 'VDHSHDH', '2020-07-09 03:18:44', 0, 1),
(192, 'ASDASA', 'SDASDS', '2020-07-09 03:27:35', 0, 1),
(193, 'ASDASD', 'ASDASD', '2020-07-19 01:32:18', 0, 1),
(194, 'ASSA', 'ASSASA', '2020-07-19 01:49:17', 0, 1),
(195, 'ASDASDA', 'SDSADSDA', '2020-07-19 01:54:20', 0, 1),
(196, 'ASASSA', 'ASSASA', '2020-07-19 01:55:20', 0, 1),
(197, 'ASDSAD', 'ASDASD', '2020-07-19 01:58:14', 0, 1),
(198, 'ASDASDA', 'SDASD', '2020-07-23 01:31:41', 0, 1),
(199, 'ASDASDA', 'DASDASD', '2020-07-23 01:33:36', 0, 1),
(200, 'ASDASD', 'ASDASD', '2020-07-23 02:13:05', 0, 1),
(201, 'ASDASDA', 'SDASD', '2020-07-23 02:24:33', 0, 1),
(202, 'ASDSAD', 'SDASD', '2020-07-23 02:29:01', 0, 1),
(203, 'DASDASD', 'ASDASDADS', '2020-07-23 02:37:46', 0, 1),
(204, 'ASDASD', 'ASDASD', '2020-07-23 02:39:45', 0, 1),
(205, 'SDASD', 'ASDASD', '2020-07-23 02:42:17', 0, 1),
(206, 'ASDASD', 'ASDASD', '2020-07-23 02:43:51', 0, 1),
(207, 'DASDA', 'SDASD', '2020-07-23 02:45:13', 0, 1),
(208, 'SDASDASD', 'ASDASDDAS', '2020-07-23 02:49:59', 0, 1),
(209, 'ASDASDA', 'SDASD', '2020-07-23 02:50:30', 0, 1),
(210, 'ASDSAD', 'ASDASD', '2020-07-23 03:01:48', 0, 1),
(212, 'SDASD', 'ASDASD', '2020-07-23 03:10:58', 0, 1),
(213, 'ASDASDAS', 'DASDASD', '2020-07-23 03:13:41', 0, 1),
(214, 'SDASDASDA', 'DASDDAS', '2020-07-23 03:15:02', 0, 1),
(217, 'ASDASDA', 'SDADS', '2020-07-23 03:34:30', 0, 1),
(218, 'SDSADA', 'SDASD', '2020-07-23 03:38:19', 0, 1),
(219, 'SDASDAS', 'DASDS', '2020-07-23 03:40:37', 0, 1),
(220, 'ASDASDA', 'SDASDASD', '2020-07-23 03:41:57', 0, 1),
(221, 'ASDASDA', 'SDASDAS', '2020-07-23 03:43:36', 0, 1),
(225, 'AA634ZR', 'LOGAN', '2020-07-23 04:21:03', 0, 1),
(226, 'AA654DE', 'AADSAS', '2020-07-23 04:22:34', 0, 1),
(227, 'AA4323AS', 'ASDASDA', '2020-07-23 04:24:04', 0, 1),
(228, 'ASD32', 'ASDASD', '2020-07-23 04:25:27', 0, 1),
(241, 'ASDASD2', 'ASDASD', '2020-07-23 05:04:35', 0, 1),
(244, 'SDASD2', 'ASDASD', '2020-07-23 05:12:27', 0, 1),
(246, 'AS32323AS', 'LOGANSIAS', '2020-07-23 05:16:03', 0, 1),
(247, 'ASDASDADS32', 'DSADSAAD', '2020-07-23 05:18:48', 0, 1),
(248, 'ASDAD', 'ASDASD', '2020-07-23 05:20:24', 0, 1),
(250, 'AS32321AS', 'LOGANSIN', '2020-07-23 05:27:49', 0, 1),
(256, 'AA324ASD', 'LOGANSITO', '2020-07-23 05:39:37', 0, 1),
(257, 'AS3232', 'LOGANS', '2020-07-23 05:40:47', 0, 1),
(258, 'AS3223', 'ASDASD', '2020-07-23 05:42:48', 0, 1),
(259, 'ASDASDA', 'SDASDADS', '2020-07-23 05:43:43', 0, 1),
(260, 'ASDASDA', 'SDASD', '2020-07-23 05:45:03', 0, 1),
(266, 'ASDASD', 'ASDASDADS', '2020-07-23 05:54:35', 0, 1),
(269, 'AA454AS', 'LOGANSITO NEGRO', '2020-07-23 05:57:44', 0, 1),
(271, 'AA546ZE', 'LOGAN', '2020-07-23 22:01:29', 0, 82),
(272, 'AA453ZE', 'LOGAN', '2020-07-23 22:02:12', 0, 82),
(273, 'ASA3223', 'ZOANS', '2020-07-23 22:06:30', 0, 82),
(279, 'ASDASD', 'ASDASDASD', '2020-07-24 02:25:54', 0, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`),
  ADD KEY `id_vehiculo` (`id_vehiculo`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`id_veh`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=283;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `id_veh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=280;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculo` (`id_veh`) ON UPDATE CASCADE,
  ADD CONSTRAINT `persona_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `vehiculo_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
