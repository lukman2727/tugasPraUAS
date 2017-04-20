/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.21-MariaDB : Database - perpustakaan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`perpustakaan` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `perpustakaan`;

/*Table structure for table `anggota` */

DROP TABLE IF EXISTS `anggota`;

CREATE TABLE `anggota` (
  `NoAnggota` varchar(10) NOT NULL,
  `Nama` varchar(30) DEFAULT NULL,
  `Alamat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`NoAnggota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `anggota` */

insert  into `anggota`(`NoAnggota`,`Nama`,`Alamat`) values ('001','Risya','Bandung'),('002','Khansa','Bandung'),('003','Mahira','Bandung'),('004','Iyong','Aamiin'),('005','Anggota5','Alamat5');

/*Table structure for table `buku` */

DROP TABLE IF EXISTS `buku`;

CREATE TABLE `buku` (
  `KodeBuku` varchar(10) NOT NULL,
  `Judul` varchar(60) DEFAULT NULL,
  `Pengarang` varchar(50) DEFAULT NULL,
  `Penerbit` varchar(30) DEFAULT NULL,
  `TahunTerbit` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`KodeBuku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `buku` */

insert  into `buku`(`KodeBuku`,`Judul`,`Pengarang`,`Penerbit`,`TahunTerbit`) values ('001','Java','Yuzkin',NULL,NULL),('003','Delphi','Eza',NULL,NULL),('004','Judul','Pengarang','Tau','2014');

/*Table structure for table `detailpinjam` */

DROP TABLE IF EXISTS `detailpinjam`;

CREATE TABLE `detailpinjam` (
  `NoPinjam` varchar(255) DEFAULT NULL,
  `KodeBuku` varchar(255) DEFAULT NULL,
  `Status` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `detailpinjam` */

insert  into `detailpinjam`(`NoPinjam`,`KodeBuku`,`Status`) values ('001','001','1'),('005','004','1'),('005','003','1'),('006','003','1'),('002','001','1'),('010','004','1'),('010','001','1'),('007','003','1'),('100','004','1'),('011','004','1'),('101','004','1'),('120','003','1'),('121','001','1'),('123','004','1'),('901','004','1'),('231','001','1'),('321','001','1'),('450','001','1'),('450','003','1'),('450','004','1'),('809','001','1'),('291','001','1'),('7584','001','1');

/*Table structure for table `pinjam` */

DROP TABLE IF EXISTS `pinjam`;

CREATE TABLE `pinjam` (
  `NoPinjam` varchar(255) NOT NULL,
  `TglPinjam` timestamp NULL DEFAULT NULL,
  `NoAnggota` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`NoPinjam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pinjam` */

insert  into `pinjam`(`NoPinjam`,`TglPinjam`,`NoAnggota`) values ('001','2010-11-01 00:00:00','001'),('002','2016-01-24 00:00:00','003'),('005','2016-01-19 00:00:00','002'),('006','2016-01-24 00:00:00','002'),('007','2016-01-24 00:00:00','001'),('010','2016-01-24 00:00:00','002'),('011','2016-01-24 00:00:00','001'),('100','2016-01-24 00:00:00','002'),('101','2016-01-24 00:00:00','002'),('120','2016-01-24 00:00:00','002'),('121','2016-01-24 00:00:00','002'),('123','2016-01-24 00:00:00','003'),('231','2016-01-24 00:00:00','002'),('291','2017-04-19 00:00:00','001'),('321','2016-01-25 00:00:00','002'),('450','2016-01-25 00:00:00','003'),('7584','2017-04-20 00:00:00','001'),('809','2017-04-18 00:00:00','001'),('901','2016-01-24 00:00:00','002');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Nama` varchar(255) DEFAULT NULL,
  `Bagian` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`Username`,`Password`,`Nama`,`Bagian`) values ('lukman','lukman','Lukman Kurniawan','Admin'),('mamen','mamen','Lukman','Sirkulasi');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
