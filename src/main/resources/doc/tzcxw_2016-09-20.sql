# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 192.168.29.101 (MySQL 5.6.33)
# Database: tzcxw
# Generation Time: 2016-09-20 10:07:46 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table companies
# ------------------------------------------------------------

DROP TABLE IF EXISTS `companies`;

CREATE TABLE `companies` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL DEFAULT '' COMMENT '姓名',
  `user_name` varchar(80) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(80) NOT NULL DEFAULT '' COMMENT '密码',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `company` varchar(50) NOT NULL DEFAULT '' COMMENT '公司名称',
  `industry` varchar(50) NOT NULL DEFAULT '' COMMENT '所属行业',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '公司性质',
  `create_date` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `employees` varchar(50) NOT NULL DEFAULT '' COMMENT '员工人数',
  `money` varchar(50) NOT NULL DEFAULT '' COMMENT '注册资金',
  `html` varchar(50) NOT NULL DEFAULT '' COMMENT '公司首页',
  `area` varchar(50) NOT NULL DEFAULT '' COMMENT '所属地区',
  `introduction` varchar(200) NOT NULL DEFAULT '' COMMENT '所属行业',
  `concat_name` varchar(50) NOT NULL DEFAULT '' COMMENT '联系人',
  `phone` varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话',
  `fax` varchar(50) NOT NULL DEFAULT '' COMMENT '传真号码',
  `address` varchar(50) NOT NULL DEFAULT '' COMMENT '通讯地址',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `IDX_MN` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;

INSERT INTO `companies` (`id`, `name`, `user_name`, `password`, `email`, `company`, `industry`, `type`, `create_date`, `employees`, `money`, `html`, `area`, `introduction`, `concat_name`, `phone`, `fax`, `address`, `created_at`, `updated_at`)
VALUES
	(3,'312312321','3312313','333333','2','31','2','2','22','2','2','2','2','2','3','2','2','2','2016-08-06 19:38:32',NULL);

/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL DEFAULT '' COMMENT '姓名',
  `user_name` varchar(80) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(80) NOT NULL DEFAULT '' COMMENT '密码',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `IDX_MN` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `name`, `user_name`, `password`, `email`, `created_at`, `updated_at`)
VALUES
	(1,'31233','3333','333333','','2016-08-06 18:34:59',NULL),
	(2,'32131','32131','3123131','','2016-08-06 18:53:25',NULL),
	(3,'3312','hzq','111111','','2016-08-06 19:41:26',NULL);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
