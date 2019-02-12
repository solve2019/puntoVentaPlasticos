-- MySQL dump 10.11
--
-- Host: localhost    Database: punto_venta
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `punto_venta`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `punto_venta` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `punto_venta`;

--
-- Table structure for table `tc_clientes`
--

DROP TABLE IF EXISTS `tc_clientes`;
CREATE TABLE `tc_clientes` (
  `idcliente` int(11) NOT NULL auto_increment,
  `nombre_completo` varchar(255) default NULL,
  `calle` varchar(255) default NULL,
  `colonia` varchar(70) default NULL,
  `noext` varchar(15) default NULL,
  `cp` varchar(7) default NULL,
  `municipio` varchar(100) default NULL,
  `estado` varchar(100) default NULL,
  `telefono` varchar(15) default NULL,
  `rfc` varchar(15) default NULL,
  `email` varchar(100) default NULL,
  `puntos` int(11) default NULL,
  `codigo_barras` varchar(50) default NULL,
  `razon_social` varchar(150) default NULL,
  `pais` varchar(50) default NULL,
  `ciudad` varchar(100) default NULL,
  `no_interior` varchar(20) default NULL,
  `MetodoPago` varchar(40) default NULL,
  `FormaPago` varchar(70) default NULL,
  `noCuenta` varchar(30) default NULL,
  PRIMARY KEY  (`idcliente`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tc_clientes`
--

LOCK TABLES `tc_clientes` WRITE;
/*!40000 ALTER TABLE `tc_clientes` DISABLE KEYS */;
INSERT INTO `tc_clientes` VALUES (1,'JOSE','PASEO ABEDULES','BUGAMBILIAS','18','62570','JIUTEPEC','MORELOS','7773859652','AURD881223KK4','jose_domo@hotmail.com',0,'20160612132941','JOSE DOMINGO ANTUNEZ ROGEL','MEXICO',NULL,NULL,'TRANSFERENCIA','PAGO EN UNA SOLA EXHIBICION','0000'),(2,'LILIANA GONZALEZ',NULL,NULL,NULL,NULL,NULL,NULL,'77723402340','UE73JSIK34','lili@hotmail.com',0,'20160612133924',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tc_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tc_productos`
--

DROP TABLE IF EXISTS `tc_productos`;
CREATE TABLE `tc_productos` (
  `idproducto` int(11) NOT NULL auto_increment,
  `codigo_barras` varchar(120) default NULL,
  `nombre_producto` varchar(150) default NULL,
  `descripcion` varchar(255) default NULL,
  `marca` varchar(100) default NULL,
  `fecha_caducidad` date default NULL,
  `precio_compra` float(7,2) default '0.00',
  `precio_venta` float(7,2) default '0.00',
  `existencia` int(11) default '0',
  `cantidad_minima` int(5) default NULL,
  `estatus` int(1) default NULL,
  `fecha_registro` date default NULL,
  `usuario_registro` varchar(150) default NULL,
  `fecha_baja` date default NULL,
  `usuario_elimino` varchar(150) default NULL,
  PRIMARY KEY  (`idproducto`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tc_productos`
--

LOCK TABLES `tc_productos` WRITE;
/*!40000 ALTER TABLE `tc_productos` DISABLE KEYS */;
INSERT INTO `tc_productos` VALUES (1,'1111','COCA COLA',NULL,NULL,NULL,12.00,12.00,-50,11,1,'2016-07-12','ADMINISTRADOR DEL SISTEMA',NULL,NULL);
/*!40000 ALTER TABLE `tc_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tc_usuarios`
--

DROP TABLE IF EXISTS `tc_usuarios`;
CREATE TABLE `tc_usuarios` (
  `idusuario` int(11) NOT NULL auto_increment,
  `nombre` varchar(170) default NULL,
  `usuario` varchar(50) default NULL,
  `password` varchar(100) default NULL,
  `fecha_alta` date default NULL,
  `estatus` int(1) default NULL,
  `perfil` varchar(50) default NULL,
  PRIMARY KEY  (`idusuario`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tc_usuarios`
--

LOCK TABLES `tc_usuarios` WRITE;
/*!40000 ALTER TABLE `tc_usuarios` DISABLE KEYS */;
INSERT INTO `tc_usuarios` VALUES (1,'ADMINISTRADOR DEL SISTEMA','admin','523af537946b79c4f8369ed39ba78605','2016-04-15',1,'ADMINISTRADOR'),(2,'OPERADOR DEL SISTEMA','operador','523af537946b79c4f8369ed39ba78605','2016-04-15',1,'OPERADOR'),(3,'PEDRO JULIAN','pjulian','523af537946b79c4f8369ed39ba78605','2016-05-14',0,'OPERADOR');
/*!40000 ALTER TABLE `tc_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `th_inventarios_registrados`
--

DROP TABLE IF EXISTS `th_inventarios_registrados`;
CREATE TABLE `th_inventarios_registrados` (
  `id_ajuste` int(11) NOT NULL auto_increment,
  `id_producto` int(11) default NULL,
  `cantidad_agregada` int(11) default NULL,
  `fecha` datetime default NULL,
  `usuario_ajusto` varchar(170) default NULL,
  `tipo_mov` varchar(50) default NULL,
  `cantidad_actual` int(11) default NULL,
  `cantidad_nueva` int(11) default NULL,
  PRIMARY KEY  (`id_ajuste`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `th_inventarios_registrados`
--

LOCK TABLES `th_inventarios_registrados` WRITE;
/*!40000 ALTER TABLE `th_inventarios_registrados` DISABLE KEYS */;
INSERT INTO `th_inventarios_registrados` VALUES (1,1,1,'2016-07-12 20:15:38','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(2,1,3,'2016-07-16 09:59:41','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(3,1,20,'2016-07-16 10:03:50','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(4,1,3,'2016-07-16 10:04:05','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(5,1,1,'2016-07-16 10:08:31','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(6,1,1,'2016-07-16 11:31:33','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(7,1,1,'2016-07-16 11:33:27','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(8,1,12,'2016-07-31 09:52:49','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(9,1,1,'2016-07-31 10:16:30','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(10,1,1,'2016-07-31 10:26:20','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(11,1,1,'2016-07-31 10:27:59','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(12,1,1,'2016-07-31 10:30:42','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(13,1,1,'2016-07-31 10:31:46','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(14,1,1,'2016-07-31 10:34:59','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(15,1,1,'2016-07-31 10:41:20','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(16,1,1,'2016-07-31 10:42:30','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(17,1,1,'2016-07-31 10:43:07','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(18,1,1,'2016-07-31 10:45:20','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(19,1,1,'2016-07-31 10:45:32','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(20,1,3,'2016-07-31 10:51:03','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL),(21,1,5,'2016-07-31 12:50:31','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL);
/*!40000 ALTER TABLE `th_inventarios_registrados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `to_activacion`
--

DROP TABLE IF EXISTS `to_activacion`;
CREATE TABLE `to_activacion` (
  `id_activacion` int(11) NOT NULL auto_increment,
  `estatus` varchar(15) default NULL COMMENT 'ACTIVADO, DEMO',
  `serial` varchar(50) default NULL,
  `fecha_activo` datetime default NULL,
  `fecha_inicio` date default NULL,
  `fecha_fin` date default NULL,
  `idestatus` int(2) default NULL,
  `nombre` varchar(170) default NULL,
  `direccionmac` varchar(25) default NULL,
  PRIMARY KEY  (`id_activacion`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_activacion`
--

LOCK TABLES `to_activacion` WRITE;
/*!40000 ALTER TABLE `to_activacion` DISABLE KEYS */;
INSERT INTO `to_activacion` VALUES (1,'ACTIVADO','123','2016-07-31 13:13:22','2016-06-01','2017-06-01',5,'JOSE ANTUNEZ ROGEL','00-23-4E-21-92-22');
/*!40000 ALTER TABLE `to_activacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `to_cierre_caja`
--

DROP TABLE IF EXISTS `to_cierre_caja`;
CREATE TABLE `to_cierre_caja` (
  `id_cierre_caja` int(11) NOT NULL auto_increment,
  `monto_inicio_caja` float(8,2) default '0.00',
  `efectivo` float(8,2) default '0.00',
  `tarjeta` float(8,2) default '0.00',
  `entrada` float(8,2) default '0.00',
  `salida` float(8,2) default '0.00',
  `devoluciones` float(8,2) default '0.00',
  `activo` varchar(10) default NULL COMMENT 'SI,NO',
  `no_ventas` int(5) default '0',
  PRIMARY KEY  (`id_cierre_caja`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_cierre_caja`
--

LOCK TABLES `to_cierre_caja` WRITE;
/*!40000 ALTER TABLE `to_cierre_caja` DISABLE KEYS */;
INSERT INTO `to_cierre_caja` VALUES (1,0.00,423.45,0.00,0.00,0.00,0.00,'SI',14);
/*!40000 ALTER TABLE `to_cierre_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `to_folios`
--

DROP TABLE IF EXISTS `to_folios`;
CREATE TABLE `to_folios` (
  `idfolio` int(11) NOT NULL auto_increment,
  `no_folio` int(11) default NULL,
  `monto_total` float(8,2) default NULL,
  `efectivo` float(8,2) default '0.00',
  `tarjeta` float(8,2) default '0.00',
  `referencia_tarjeta` varchar(70) default NULL,
  `monto_puntos` float(8,2) default '0.00',
  `no_puntos` int(11) default '0',
  `id_sucursal` int(11) default NULL,
  `fecha_movimiento` datetime default NULL,
  `usuario_registro` varchar(170) default NULL,
  `tipo_movimiento` varchar(50) default NULL COMMENT 'VENTA, ENTRADA, SALIDA, DEVOLUCION',
  `id_devolucion_venta` int(11) default NULL,
  `forma_pago` varchar(20) default NULL COMMENT 'EFECTIVO, TARJETA, MIXTO, PUNTOS',
  `id_usuario` int(11) default NULL,
  `descuento` float(5,2) default '0.00',
  `iva` double(7,2) default '0.00',
  PRIMARY KEY  (`idfolio`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_folios`
--

LOCK TABLES `to_folios` WRITE;
/*!40000 ALTER TABLE `to_folios` DISABLE KEYS */;
INSERT INTO `to_folios` VALUES (1,1,60.00,70.00,0.00,'',0.00,0,NULL,'2016-07-31 12:50:31','ADMINISTRADOR DEL SISTEMA','VENTA',NULL,'EFECTIVO',1,0.00,9.60);
/*!40000 ALTER TABLE `to_folios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `to_parametros`
--

DROP TABLE IF EXISTS `to_parametros`;
CREATE TABLE `to_parametros` (
  `Id` int(11) NOT NULL auto_increment,
  `clave` varchar(20) default NULL,
  `descripcion` varchar(255) default NULL,
  `parametro` text,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_parametros`
--

LOCK TABLES `to_parametros` WRITE;
/*!40000 ALTER TABLE `to_parametros` DISABLE KEYS */;
INSERT INTO `to_parametros` VALUES (1,'FOLIO','FOLIO DE LOS TICKETS','1'),(2,'ENCABEZADO','ENCABEZADO DEL TICKET','         EXPEDIDO EN: SISTEMA DEMO\n          AV. DEMO NO. 18 COL. DEMO\n              RFC: CSI-SISTEMA DEMO\n         CEL. 7773943328 SISTEMA DEMO'),(3,'FOOTER','PIE DE PAGINA DEL TICKET','            Gracias por su visita \n              modo demostrativo'),(4,'CUTTER','CORTADOR DE TICKET','SI'),(5,'CLAVEADMIN','CLAVE DE ADMINISTRADOR PARA HACER OPERACIONES COMO DEVOLUCIONES, DESCUENTOS','admin'),(6,'CORREOSCORTECAJA','CORREOS A LOS QUE SE EL ENVIAN EL CORTE DE CAJA','jose_domo@hotmail.com,\njoly_2325@hotmail.com'),(7,'IVA','MONTO DEL IVA EN VENTAS','16\r\n');
/*!40000 ALTER TABLE `to_parametros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `to_ventas`
--

DROP TABLE IF EXISTS `to_ventas`;
CREATE TABLE `to_ventas` (
  `idventa` int(11) NOT NULL auto_increment,
  `idproducto` int(11) default NULL,
  `cantidad` int(5) default NULL,
  `precio` float(7,2) default NULL,
  `total` float(8,2) default NULL,
  `folio` int(11) default NULL,
  `fecha_mov` datetime default NULL,
  PRIMARY KEY  (`idventa`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_ventas`
--

LOCK TABLES `to_ventas` WRITE;
/*!40000 ALTER TABLE `to_ventas` DISABLE KEYS */;
INSERT INTO `to_ventas` VALUES (1,1,5,12.00,60.00,1,'2016-07-31 12:50:31');
/*!40000 ALTER TABLE `to_ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-31 18:36:23
