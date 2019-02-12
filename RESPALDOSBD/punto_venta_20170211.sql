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
-- Table structure for table `proveedor_tc`
--

DROP TABLE IF EXISTS `proveedor_tc`;
CREATE TABLE `proveedor_tc` (
  `IdProveedor` int(11) NOT NULL auto_increment,
  `nombreProveedor` varchar(120) default NULL,
  `tel` varchar(15) default NULL,
  `direccion` varchar(150) default NULL,
  `estado` varchar(35) default NULL,
  `cp` varchar(6) default NULL,
  `colonia` varchar(45) default NULL,
  `rfcProveedor` varchar(15) default NULL,
  `fechaRegistro` date default NULL,
  `estatus_proveedor` int(1) default '1',
  PRIMARY KEY  (`IdProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proveedor_tc`
--

LOCK TABLES `proveedor_tc` WRITE;
/*!40000 ALTER TABLE `proveedor_tc` DISABLE KEYS */;
INSERT INTO `proveedor_tc` VALUES (1,'JOSE ANTUNEZ','777329349','CALLE','MORELOS','CP','COLONIA','RFC398',NULL,1);
/*!40000 ALTER TABLE `proveedor_tc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor_tc_compraprod`
--

DROP TABLE IF EXISTS `proveedor_tc_compraprod`;
CREATE TABLE `proveedor_tc_compraprod` (
  `Idcompra` int(11) NOT NULL auto_increment,
  `idprod` int(11) default NULL,
  `IdFolioCompra` int(255) default NULL,
  `cantidad` float(8,2) default '0.00',
  `precio` double(8,2) default '0.00',
  `total` double(8,2) default '0.00',
  PRIMARY KEY  (`Idcompra`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proveedor_tc_compraprod`
--

LOCK TABLES `proveedor_tc_compraprod` WRITE;
/*!40000 ALTER TABLE `proveedor_tc_compraprod` DISABLE KEYS */;
INSERT INTO `proveedor_tc_compraprod` VALUES (1,1,1,1.00,22.00,22.00),(2,1,2,12.00,12.00,144.00),(3,1,3,1080.00,4.10,4428.00),(4,1,4,1080.00,4.10,4428.00),(5,1,5,1080.00,4.10,4428.00),(6,1,6,1080.00,4.10,4428.00),(7,1,7,1080.00,4.10,4428.00),(8,1,8,1080.00,4.10,4428.00),(9,1,9,1080.00,4.10,4428.00),(10,1,10,1080.00,4.10,4428.00),(11,1,11,1080.00,4.10,4428.00),(12,1,12,1080.00,4.10,4428.00),(13,1,13,1080.00,4.10,4428.00),(14,1,14,1080.00,4.10,4428.00);
/*!40000 ALTER TABLE `proveedor_tc_compraprod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor_to_compra`
--

DROP TABLE IF EXISTS `proveedor_to_compra`;
CREATE TABLE `proveedor_to_compra` (
  `IdCompraFolio` int(11) NOT NULL auto_increment,
  `IdProveedor` int(11) default NULL,
  `fecha_registro` datetime default NULL,
  `FolioCompra` int(11) default NULL,
  `monto_compra` double(8,2) default NULL,
  `usuario_registro` varchar(150) default NULL,
  `fecha_cancelacion` datetime default NULL,
  `usuarioCancelo` varchar(150) default NULL,
  `estatuscompra` int(1) default '1' COMMENT '1.- ACTIVA  2.-CANCELADA',
  PRIMARY KEY  (`IdCompraFolio`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proveedor_to_compra`
--

LOCK TABLES `proveedor_to_compra` WRITE;
/*!40000 ALTER TABLE `proveedor_to_compra` DISABLE KEYS */;
INSERT INTO `proveedor_to_compra` VALUES (1,NULL,'2017-01-30 23:35:32',1,22.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(2,NULL,'2017-02-02 22:29:28',2,144.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(3,NULL,'2017-02-02 22:40:15',3,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(4,NULL,'2017-02-02 22:41:19',4,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(5,NULL,'2017-02-02 22:44:03',5,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(6,NULL,'2017-02-02 22:45:58',6,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(7,NULL,'2017-02-02 22:51:43',7,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(8,NULL,'2017-02-02 22:55:10',8,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(9,1,'2017-02-02 22:55:41',9,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(10,NULL,'2017-02-02 23:02:50',10,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(11,1,'2017-02-02 23:03:22',11,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(12,1,'2017-02-02 23:05:13',12,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(13,NULL,'2017-02-02 23:05:52',13,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1),(14,1,'2017-02-02 23:06:20',14,4428.00,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1);
/*!40000 ALTER TABLE `proveedor_to_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tc_categorias`
--

DROP TABLE IF EXISTS `tc_categorias`;
CREATE TABLE `tc_categorias` (
  `Idcategoria` int(4) NOT NULL auto_increment,
  `nombre` varchar(60) default NULL,
  `descripcion` varchar(255) default NULL,
  `estatus` int(1) default '1',
  `usuario_elimino` varchar(120) default NULL,
  `fecha_baja` date default NULL,
  PRIMARY KEY  (`Idcategoria`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tc_categorias`
--

LOCK TABLES `tc_categorias` WRITE;
/*!40000 ALTER TABLE `tc_categorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `tc_categorias` ENABLE KEYS */;
UNLOCK TABLES;

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
  `estatus` int(1) default '1',
  PRIMARY KEY  (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tc_clientes`
--

LOCK TABLES `tc_clientes` WRITE;
/*!40000 ALTER TABLE `tc_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tc_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tc_mascotas`
--

DROP TABLE IF EXISTS `tc_mascotas`;
CREATE TABLE `tc_mascotas` (
  `Idmascota` int(11) NOT NULL auto_increment,
  `nombrepaciente` varchar(255) default NULL,
  `fecha_nacimiento` date default NULL,
  `raza` varchar(255) default NULL,
  `sexo` varchar(255) default NULL,
  `color` varchar(255) default NULL,
  `observaciones` varchar(255) default NULL,
  `idrcliente` int(11) default NULL,
  `imagen` longblob,
  PRIMARY KEY  (`Idmascota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tc_mascotas`
--

LOCK TABLES `tc_mascotas` WRITE;
/*!40000 ALTER TABLE `tc_mascotas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tc_mascotas` ENABLE KEYS */;
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
  `imagen` longblob,
  `idrcategoria` int(4) default NULL,
  `precio_mayoreo` float(9,2) default '0.00',
  `cantidad_mayoreo` int(6) default '0',
  `precio_promocion` float(8,2) default '0.00',
  `cantidad_promocion` int(6) default '0',
  PRIMARY KEY  (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tc_productos`
--

LOCK TABLES `tc_productos` WRITE;
/*!40000 ALTER TABLE `tc_productos` DISABLE KEYS */;
INSERT INTO `tc_productos` VALUES (1,'1234','COCA COLA 600ML',NULL,NULL,NULL,4.10,7.00,1,12,1,'2017-01-29','ADMINISTRADOR DEL SISTEMA',NULL,NULL,NULL,NULL,6.00,12,0.00,0);
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
-- Table structure for table `th_abonos_cliente`
--

DROP TABLE IF EXISTS `th_abonos_cliente`;
CREATE TABLE `th_abonos_cliente` (
  `IdAbono` int(11) NOT NULL auto_increment,
  `IdrCliente` int(11) default NULL,
  `Monto` double(9,2) default '0.00',
  `Fecha` datetime default NULL,
  `UsuarioMovimiento` varchar(170) default NULL,
  `FormaPago` varchar(35) default NULL,
  PRIMARY KEY  (`IdAbono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `th_abonos_cliente`
--

LOCK TABLES `th_abonos_cliente` WRITE;
/*!40000 ALTER TABLE `th_abonos_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `th_abonos_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `th_cliente_credito`
--

DROP TABLE IF EXISTS `th_cliente_credito`;
CREATE TABLE `th_cliente_credito` (
  `Id` int(11) NOT NULL auto_increment,
  `idrcliente` int(11) default NULL,
  `idrfolio` int(11) default NULL,
  `fechamovimiento` datetime default NULL,
  `usuariomovimiento` varchar(150) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `th_cliente_credito`
--

LOCK TABLES `th_cliente_credito` WRITE;
/*!40000 ALTER TABLE `th_cliente_credito` DISABLE KEYS */;
/*!40000 ALTER TABLE `th_cliente_credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `th_entradasefectivo`
--

DROP TABLE IF EXISTS `th_entradasefectivo`;
CREATE TABLE `th_entradasefectivo` (
  `Id` int(11) NOT NULL auto_increment,
  `fecha` datetime default NULL,
  `monto` double(8,2) default '0.00',
  `motivo` varchar(200) default NULL,
  `movimiento` varchar(30) default NULL COMMENT 'ENTRADA o SALIDA',
  `usuario` varchar(150) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `th_entradasefectivo`
--

LOCK TABLES `th_entradasefectivo` WRITE;
/*!40000 ALTER TABLE `th_entradasefectivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `th_entradasefectivo` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `th_inventarios_registrados`
--

LOCK TABLES `th_inventarios_registrados` WRITE;
/*!40000 ALTER TABLE `th_inventarios_registrados` DISABLE KEYS */;
INSERT INTO `th_inventarios_registrados` VALUES (1,1,2,'2017-01-29 22:42:13','ADMINISTRADOR DEL SISTEMA','INGRESO',NULL,NULL),(2,1,1,'2017-02-09 00:22:53','ADMINISTRADOR DEL SISTEMA','SALIDA',NULL,NULL);
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
INSERT INTO `to_activacion` VALUES (1,'ACTIVADO','123','2016-07-31 13:13:22','2016-06-01','2019-02-15',5,'JOSE ANTUNEZ ROGEL','00-23-4E-21-92-22');
/*!40000 ALTER TABLE `to_activacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `to_agenda`
--

DROP TABLE IF EXISTS `to_agenda`;
CREATE TABLE `to_agenda` (
  `id_agenda` int(11) NOT NULL auto_increment,
  `fecha` date default NULL,
  `nota` varchar(255) default NULL,
  PRIMARY KEY  (`id_agenda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_agenda`
--

LOCK TABLES `to_agenda` WRITE;
/*!40000 ALTER TABLE `to_agenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `to_agenda` ENABLE KEYS */;
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
  `credito` float(8,2) default '0.00',
  PRIMARY KEY  (`id_cierre_caja`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_cierre_caja`
--

LOCK TABLES `to_cierre_caja` WRITE;
/*!40000 ALTER TABLE `to_cierre_caja` DISABLE KEYS */;
INSERT INTO `to_cierre_caja` VALUES (1,0.00,53.00,0.00,0.00,0.00,0.00,'SI',3,0.00);
/*!40000 ALTER TABLE `to_cierre_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `to_cotizacion`
--

DROP TABLE IF EXISTS `to_cotizacion`;
CREATE TABLE `to_cotizacion` (
  `id_cotizacion` int(11) NOT NULL auto_increment,
  `fecha` datetime default NULL,
  `monto_total` float(8,2) default '0.00',
  `usuario_registro` varchar(150) default NULL,
  PRIMARY KEY  (`id_cotizacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_cotizacion`
--

LOCK TABLES `to_cotizacion` WRITE;
/*!40000 ALTER TABLE `to_cotizacion` DISABLE KEYS */;
INSERT INTO `to_cotizacion` VALUES (1,'2017-02-09 00:17:45',7.00,'ADMINISTRADOR DEL SISTEMA'),(2,'2017-02-09 00:22:04',90.00,'ADMINISTRADOR DEL SISTEMA');
/*!40000 ALTER TABLE `to_cotizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `to_cotizacion_prod`
--

DROP TABLE IF EXISTS `to_cotizacion_prod`;
CREATE TABLE `to_cotizacion_prod` (
  `idcotiprod` int(11) NOT NULL auto_increment,
  `idproducto` int(11) default NULL,
  `cantidad` int(5) default NULL,
  `precio` float(7,2) default NULL,
  `total` float(8,2) default NULL,
  `id_coti` int(11) default NULL,
  `fecha_mov` datetime default NULL,
  PRIMARY KEY  (`idcotiprod`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_cotizacion_prod`
--

LOCK TABLES `to_cotizacion_prod` WRITE;
/*!40000 ALTER TABLE `to_cotizacion_prod` DISABLE KEYS */;
INSERT INTO `to_cotizacion_prod` VALUES (1,1,1,7.00,7.00,1,'2017-02-09 00:17:45'),(2,1,15,6.00,90.00,2,'2017-02-09 00:22:04');
/*!40000 ALTER TABLE `to_cotizacion_prod` ENABLE KEYS */;
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
  `fecha_devolucion` datetime default NULL,
  `usuario_devolucion` varchar(170) default NULL,
  `estatus` int(1) default '1',
  PRIMARY KEY  (`idfolio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_folios`
--

LOCK TABLES `to_folios` WRITE;
/*!40000 ALTER TABLE `to_folios` DISABLE KEYS */;
INSERT INTO `to_folios` VALUES (1,1,7.00,7.00,0.00,'',0.00,0,NULL,'2017-02-09 00:22:53','ADMINISTRADOR DEL SISTEMA','VENTA',NULL,'EFECTIVO',1,0.00,0.00,NULL,NULL,1);
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
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_parametros`
--

LOCK TABLES `to_parametros` WRITE;
/*!40000 ALTER TABLE `to_parametros` DISABLE KEYS */;
INSERT INTO `to_parametros` VALUES (1,'FOLIO','FOLIO DE LOS TICKETS','1'),(2,'ENCABEZADO','ENCABEZADO DEL TICKET','         EXPEDIDO EN: SISTEMA DEMO\n          AV. DEMO NO. 18 COL. DEMO\n              RFC: CSI-SISTEMA DEMO\n         CEL. 7773943328 SISTEMA DEMO'),(3,'FOOTER','PIE DE PAGINA DEL TICKET','            Gracias por su visita \n              modo demostrativo'),(4,'CUTTER','CORTADOR DE TICKET','SI'),(5,'CLAVEADMIN','CLAVE DE ADMINISTRADOR PARA HACER OPERACIONES COMO DEVOLUCIONES, DESCUENTOS','admin'),(6,'CORREOSCORTECAJA','CORREOS A LOS QUE SE EL ENVIAN EL CORTE DE CAJA','jose_domo@hotmail.com'),(7,'IVA','MONTO DEL IVA EN VENTAS','0'),(8,'TIPOIMPRESION','TIPO DE IMPRESION DE TICKET PDF/ESC/POS','PDF'),(9,'FOLIOCOMRA','FOLIO DE LOS TICKETS DE COMPRA','14'),(10,'RUTARESPALDOBD','RUTA DONDE SE OBTIENE EL RESPADO DE LA BASE DE DATOS','C:/AppServ/MySQL/bin');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `to_ventas`
--

LOCK TABLES `to_ventas` WRITE;
/*!40000 ALTER TABLE `to_ventas` DISABLE KEYS */;
INSERT INTO `to_ventas` VALUES (1,1,1,7.00,7.00,1,'2017-02-09 00:22:53');
/*!40000 ALTER TABLE `to_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veterinaria_consultas`
--

DROP TABLE IF EXISTS `veterinaria_consultas`;
CREATE TABLE `veterinaria_consultas` (
  `Id` int(11) NOT NULL auto_increment,
  `fecha_consulta` date default NULL,
  `observaciones` varchar(255) default '',
  `fecha_registro` date default NULL,
  `usuario_registro` varchar(130) default NULL,
  `idrpaciente` int(11) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `veterinaria_consultas`
--

LOCK TABLES `veterinaria_consultas` WRITE;
/*!40000 ALTER TABLE `veterinaria_consultas` DISABLE KEYS */;
/*!40000 ALTER TABLE `veterinaria_consultas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veterinaria_parasitos`
--

DROP TABLE IF EXISTS `veterinaria_parasitos`;
CREATE TABLE `veterinaria_parasitos` (
  `IdParasito` int(11) NOT NULL auto_increment,
  `fechacontrolparacito` date default NULL,
  `producto` varchar(130) default NULL,
  `laboratorio` varchar(130) default NULL,
  `cita` date default NULL,
  `fecha_registro` datetime default NULL,
  `usuario_registro` varchar(130) default NULL,
  `idrpaciente` int(11) default NULL,
  PRIMARY KEY  (`IdParasito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `veterinaria_parasitos`
--

LOCK TABLES `veterinaria_parasitos` WRITE;
/*!40000 ALTER TABLE `veterinaria_parasitos` DISABLE KEYS */;
/*!40000 ALTER TABLE `veterinaria_parasitos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veterinaria_to_controlmedico`
--

DROP TABLE IF EXISTS `veterinaria_to_controlmedico`;
CREATE TABLE `veterinaria_to_controlmedico` (
  `Idcontrol` int(11) NOT NULL auto_increment,
  `descripcion` text,
  `fecharegistro` date default NULL,
  `usuario_registro` varchar(130) default NULL,
  `idrpaciente` int(11) default NULL,
  PRIMARY KEY  (`Idcontrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `veterinaria_to_controlmedico`
--

LOCK TABLES `veterinaria_to_controlmedico` WRITE;
/*!40000 ALTER TABLE `veterinaria_to_controlmedico` DISABLE KEYS */;
/*!40000 ALTER TABLE `veterinaria_to_controlmedico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veterinaria_to_vacunas`
--

DROP TABLE IF EXISTS `veterinaria_to_vacunas`;
CREATE TABLE `veterinaria_to_vacunas` (
  `Idvacunas` int(11) NOT NULL auto_increment,
  `idrpaciente` int(11) default NULL,
  `fecha` date default NULL,
  `lote` varchar(100) default NULL,
  `vacuna` varchar(120) default NULL,
  `revacunacion` date default NULL,
  `fecha_registro` date default NULL,
  `usuario_registro` varchar(255) default NULL,
  PRIMARY KEY  (`Idvacunas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `veterinaria_to_vacunas`
--

LOCK TABLES `veterinaria_to_vacunas` WRITE;
/*!40000 ALTER TABLE `veterinaria_to_vacunas` DISABLE KEYS */;
/*!40000 ALTER TABLE `veterinaria_to_vacunas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-11 21:54:36
