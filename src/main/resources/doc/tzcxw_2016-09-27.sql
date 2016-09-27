# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 192.168.145.202 (MySQL 5.6.33)
# Database: tzcxw
# Generation Time: 2016-09-27 01:34:29 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table car_merchant
# ------------------------------------------------------------

DROP TABLE IF EXISTS `car_merchant`;

CREATE TABLE `car_merchant` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company` varchar(50) NOT NULL DEFAULT '' COMMENT '公司名称',
  `type` int(11) DEFAULT '0' COMMENT '店铺类型',
  `user_id` int(11) NOT NULL DEFAULT '-1' COMMENT '用户编号',
  `name` varchar(80) NOT NULL DEFAULT '' COMMENT '负责人姓名',
  `phone` varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话',
  `picture` varchar(160) NOT NULL DEFAULT '' COMMENT '营业执照',
  `id_card` varchar(160) NOT NULL DEFAULT '' COMMENT '身份证',
  `province` int(11) NOT NULL DEFAULT '-1' COMMENT '省份',
  `address` varchar(50) NOT NULL DEFAULT '' COMMENT '通讯地址',
  `watch` int(11) DEFAULT '0' COMMENT '被浏览次数',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `IDX_MN` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二手车商家';

LOCK TABLES `car_merchant` WRITE;
/*!40000 ALTER TABLE `car_merchant` DISABLE KEYS */;

INSERT INTO `car_merchant` (`id`, `company`, `type`, `user_id`, `name`, `phone`, `picture`, `id_card`, `province`, `address`, `watch`, `created_at`, `updated_at`)
VALUES
	(8,'312',2,3,'312','312','/upload/carMerchant/5286F8A19980ADB6850923A149CBC29432125949D069F688A6E6FC77380EE5FA','/upload/carMerchant/A4D4433A1913E09B85FB022B6BB15E473FFB865C89E5EEBBCCE9B2E88A465056',3,'321',0,'2016-06-22 20:26:18',NULL);

/*!40000 ALTER TABLE `car_merchant` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table companies
# ------------------------------------------------------------

DROP TABLE IF EXISTS `companies`;

CREATE TABLE `companies` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL DEFAULT '' COMMENT '姓名',
  `user_name` varchar(80) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(80) NOT NULL DEFAULT '' COMMENT '密码',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `picture` varchar(160) NOT NULL DEFAULT '' COMMENT '企业相册',
  `company` varchar(50) NOT NULL DEFAULT '' COMMENT '公司名称',
  `industry` varchar(50) NOT NULL DEFAULT '' COMMENT '所属行业',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '公司性质',
  `create_date` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `employees` varchar(50) NOT NULL DEFAULT '' COMMENT '员工人数',
  `money` varchar(50) NOT NULL DEFAULT '' COMMENT '注册资金',
  `html` varchar(50) NOT NULL DEFAULT '' COMMENT '公司首页',
  `area` varchar(50) NOT NULL DEFAULT '' COMMENT '所属地区',
  `introduction` varchar(200) NOT NULL DEFAULT '' COMMENT '公司介绍',
  `concat_name` varchar(50) NOT NULL DEFAULT '' COMMENT '联系人',
  `phone` varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话',
  `fax` varchar(50) NOT NULL DEFAULT '' COMMENT '传真号码',
  `address` varchar(50) NOT NULL DEFAULT '' COMMENT '通讯地址',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `watch` int(11) DEFAULT '0' COMMENT '被浏览次数',
  PRIMARY KEY (`id`),
  KEY `IDX_MN` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='注册企业';

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;

INSERT INTO `companies` (`id`, `name`, `user_name`, `password`, `email`, `picture`, `company`, `industry`, `type`, `create_date`, `employees`, `money`, `html`, `area`, `introduction`, `concat_name`, `phone`, `fax`, `address`, `created_at`, `updated_at`, `watch`)
VALUES
	(3,'312312321','hzq','123456','2','/upload/companyPic/95CED208A16B78F69A9FAB6E4379CD97D2436AB354AB54138BACDD020608F4EF','公司名称','公司产业','民营','2015-12-123','200人','200w','www.baidu.com','2','2','苟先生','1333333','2','xxxxx街道','2016-08-06 19:38:32','2016-06-22 17:20:23',103),
	(4,'312312321','3312313','333333','2','3','31','2','2','22','2','2','2','2','2','3','2','2','2','2016-08-07 07:18:48','2016-06-22 16:50:48',0),
	(6,'123','123','123456','312','/upload/companyPic/76A1F276F110B9DADB0DA046A893E2870E2CB7839E1C5E11E8B763214B8E7889','321','312','312','321','321','321','321','321','321','321','321','321','312','2016-06-22 16:57:48',NULL,0);

/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table job_news
# ------------------------------------------------------------

DROP TABLE IF EXISTS `job_news`;

CREATE TABLE `job_news` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '职场资讯内容',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `watch` int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职场资讯';

LOCK TABLES `job_news` WRITE;
/*!40000 ALTER TABLE `job_news` DISABLE KEYS */;

INSERT INTO `job_news` (`id`, `title`, `content`, `created_at`, `updated_at`, `deleted_at`, `watch`)
VALUES
	(1,'123','资讯1','2016-06-21 23:47:35','2016-06-22 12:35:00',NULL,0),
	(2,'321','资讯2','2016-06-21 23:47:38','2016-06-22 12:35:01',NULL,0);

/*!40000 ALTER TABLE `job_news` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table recruitments
# ------------------------------------------------------------

DROP TABLE IF EXISTS `recruitments`;

CREATE TABLE `recruitments` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL DEFAULT '-1' COMMENT '企业编号',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '职位类别',
  `education` int(11) NOT NULL DEFAULT '0' COMMENT '学历',
  `people_count` int(11) NOT NULL DEFAULT '0' COMMENT '招聘人数',
  `work_year` varchar(50) NOT NULL DEFAULT '' COMMENT '工作年限',
  `salary` int(11) NOT NULL DEFAULT '0' COMMENT '月薪',
  `probation` int(11) NOT NULL DEFAULT '0' COMMENT '试用期',
  `work_area` int(11) NOT NULL DEFAULT '0' COMMENT '工作区域',
  `detail_area` varchar(50) NOT NULL DEFAULT '' COMMENT '详细地点',
  `title` varchar(80) NOT NULL DEFAULT '' COMMENT '招聘标题',
  `introduction` varchar(500) NOT NULL DEFAULT '' COMMENT '职位描述',
  `concact_name` varchar(50) NOT NULL DEFAULT '' COMMENT '联系人',
  `concact_phone` varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `watch` int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `is_full` int(11) NOT NULL DEFAULT '0' COMMENT '是否兼职',
  PRIMARY KEY (`id`),
  KEY `IDX_MN` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我的招聘';

LOCK TABLES `recruitments` WRITE;
/*!40000 ALTER TABLE `recruitments` DISABLE KEYS */;

INSERT INTO `recruitments` (`id`, `company_id`, `type`, `education`, `people_count`, `work_year`, `salary`, `probation`, `work_area`, `detail_area`, `title`, `introduction`, `concact_name`, `concact_phone`, `created_at`, `updated_at`, `deleted_at`, `watch`, `is_full`)
VALUES
	(1,3,0,0,3,'2',2,1,1,'312','31231','岗位职责：任职资格：工作31231时间：\r\n                ','312','31231 Name','2016-08-07 07:19:57','2016-06-22 07:47:57',NULL,0,0),
	(2,3,0,0,3,'0',0,1,0,'312','标题','1','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:47:59',NULL,0,0),
	(3,3,0,0,3,'0',0,1,0,'312','标题','2','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:55:13',NULL,0,0),
	(4,3,0,0,3,'0',0,1,0,'312','标题','3','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:55:33',NULL,0,0),
	(5,3,0,0,3,'0',0,1,0,'312','标题','312','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:55:33',NULL,0,0),
	(6,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:55:33',NULL,0,0),
	(7,3,0,0,3,'0',0,1,0,'312','2','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:55:58',NULL,0,0),
	(8,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:53:35','2016-06-22 07:56:12',NULL,0,0),
	(9,3,0,0,3,'0',0,1,0,'312','标题','岗位职责:\n每天24小时带着','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:55:33',NULL,0,0),
	(10,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:55:33',NULL,0,0),
	(11,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:55:33',NULL,0,0),
	(12,3,0,0,3,'0',0,1,0,'312','3','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:55:57',NULL,0,0),
	(13,3,0,0,3,'0',0,1,0,'312','2','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 07:55:55',NULL,0,0),
	(14,3,0,0,3,'0',0,1,0,'312','标题2','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-11 07:55:54',NULL,0,0),
	(15,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(16,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(17,3,0,0,3,'0',2,1,3,'312','标题q','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 08:29:18',NULL,0,1),
	(18,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(19,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(20,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(21,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(22,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(23,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(24,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(25,3,0,0,3,'0',1,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 09:04:35',NULL,0,1),
	(26,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(27,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(28,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(29,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(30,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(31,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(32,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(33,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(34,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(35,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(36,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(37,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(38,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(39,3,0,0,3,'0',0,1,0,'312','标题','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n                ','312','31231 Name','2016-06-22 00:57:35','2016-06-22 05:03:58',NULL,0,1),
	(40,3,0,0,32,'0',0,1,0,'','312','岗位职责：任职资格：工作时间：\r\n                312','321312','312','2016-06-22 17:17:28','2016-06-22 17:17:28',NULL,0,0),
	(41,3,0,0,32,'0',0,1,0,'','312','岗位职责：任职资格：工作时间：\r\n                312','321312','312','2016-06-22 17:17:49','2016-06-22 17:17:49',NULL,0,0),
	(42,3,0,0,3,'0',0,1,0,'','321','岗位职责：任职资格：工作时间：\r\n                312','321','312','2016-06-22 17:18:14','2016-06-22 17:18:14',NULL,0,0),
	(43,3,0,0,321,'0',0,1,0,'','3123','岗位职责：任职资格：工作时间：\r\n                12','312','312','2016-06-22 17:20:04','2016-06-22 17:20:04',NULL,0,1),
	(44,3,0,0,32,'0',0,1,0,'321','321','岗位职责：任职资格：工作时间：\r\n                321','321','321','2016-06-22 17:20:23','2016-06-22 17:20:23',NULL,0,1);

/*!40000 ALTER TABLE `recruitments` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table resume_job_relations
# ------------------------------------------------------------

DROP TABLE IF EXISTS `resume_job_relations`;

CREATE TABLE `resume_job_relations` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `resume_id` int(11) NOT NULL COMMENT '简历编号',
  `user_id` int(11) NOT NULL COMMENT '简历所属用户',
  `recruitment_id` int(11) NOT NULL COMMENT '职位编号',
  `company_id` int(11) NOT NULL COMMENT '职位所属公司',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '投递时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_watch` int(11) NOT NULL DEFAULT '0' COMMENT '企业是否查看',
  PRIMARY KEY (`id`),
  KEY `IDX_MN` (`resume_id`),
  KEY `IDX_MM` (`recruitment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历,招聘关系表';

LOCK TABLES `resume_job_relations` WRITE;
/*!40000 ALTER TABLE `resume_job_relations` DISABLE KEYS */;

INSERT INTO `resume_job_relations` (`id`, `resume_id`, `user_id`, `recruitment_id`, `company_id`, `created_at`, `updated_at`, `is_watch`)
VALUES
	(7,1,1,1,3,'2016-08-07 07:50:35',NULL,0),
	(9,4,3,1,3,'2016-06-22 01:39:11',NULL,0),
	(10,2,3,1,3,'2016-06-22 01:39:28',NULL,0);

/*!40000 ALTER TABLE `resume_job_relations` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table resumes
# ------------------------------------------------------------

DROP TABLE IF EXISTS `resumes`;

CREATE TABLE `resumes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '-1' COMMENT '所属用户',
  `title` varchar(80) NOT NULL DEFAULT '' COMMENT '简历标题',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '职位类别',
  `picture` varchar(160) NOT NULL DEFAULT '' COMMENT '相片',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `sex` varchar(50) NOT NULL DEFAULT '' COMMENT '性别',
  `birth_year` varchar(50) NOT NULL DEFAULT '' COMMENT '出生年份',
  `birth_date` varchar(50) NOT NULL DEFAULT '' COMMENT '出生月份',
  `work_year` varchar(50) NOT NULL DEFAULT '' COMMENT '工作年限',
  `education` varchar(50) NOT NULL DEFAULT '' COMMENT '学历',
  `work_area` int(11) NOT NULL DEFAULT '0' COMMENT '工作区域',
  `detail_area` varchar(50) NOT NULL DEFAULT '' COMMENT '详细地点',
  `salary` int(11) NOT NULL DEFAULT '0' COMMENT '月薪',
  `phone` varchar(50) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `address` varchar(50) NOT NULL DEFAULT '' COMMENT '籍贯',
  `introduction` varchar(200) NOT NULL DEFAULT '' COMMENT '自我介绍',
  `concact_name` varchar(50) NOT NULL DEFAULT '' COMMENT '联系人',
  `concact_phone` varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `watch` int(11) NOT NULL DEFAULT '0' COMMENT '被查看数',
  PRIMARY KEY (`id`),
  KEY `IDX_MN` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历信息';

LOCK TABLES `resumes` WRITE;
/*!40000 ALTER TABLE `resumes` DISABLE KEYS */;

INSERT INTO `resumes` (`id`, `user_id`, `title`, `type`, `picture`, `name`, `sex`, `birth_year`, `birth_date`, `work_year`, `education`, `work_area`, `detail_area`, `salary`, `phone`, `email`, `address`, `introduction`, `concact_name`, `concact_phone`, `created_at`, `updated_at`, `deleted_at`, `watch`)
VALUES
	(1,1,'\"简历标题\"',1,'\"picture\"','\"用户名\"','\"1\"','\"1992\"','12','2','1',2,'\"detail\"',1,'\"18868815433\"','\"123@qq\"','\"机关\"','\"介绍\"','\"12\"','\"phone\"','2016-08-07 07:42:42',NULL,NULL,0),
	(2,3,'\"简历标题\"',1,'\"picture\"','\"用户名\"','\"1\"','\"1992\"','12','2','1',2,'\"detail\"',1,'\"18868815433\"','\"123@qq\"','\"机关\"','\"介绍\"','\"12\"','\"phone\"','2016-08-07 07:42:47','2016-08-07 07:42:57',NULL,0),
	(3,3,'简历3',1,'\"picture\"','名字','\"1\"','\"1992\"','12','2','1',2,'\"detail\"',1,'\"18868815433\"','\"123@qq\"','\"æºå³\"','\"ä»ç»\"','\"12\"','\"phone\"','2016-06-22 01:18:51','2016-06-22 01:20:47',NULL,0),
	(4,3,'简历4',1,'\"picture\"','名字','\"1\"','\"1992\"','12','2','1',2,'\"detail\"',1,'\"18868815433\"','\"123@qq\"','\"æºå³\"','\"ä»ç»\"','\"12\"','\"phone\"','2016-06-22 01:21:16','2016-06-22 01:21:22',NULL,0),
	(5,3,'321',2,'972881B83A804E1BA50A396ABA8A3FC893906DAA28CD7610A9AB1D0B5845C5BF','321','0','321','321','2','0',0,'3213',0,'12','321','312','简单介绍下自己，让用人企312业更关注你！\r\n                ','3123','31231','2016-06-22 16:21:19',NULL,NULL,0),
	(6,3,'2313',3,'/upload/userResume/','321','0','312','321321','0','0',0,'321',0,'321','321','3123','简单介绍下自己，让用人企业更关注你！\r\n                3123','321','312','2016-06-22 16:38:21',NULL,NULL,0),
	(7,3,'2313',3,'/upload/userResume/','321','0','312','321321','0','0',0,'321',0,'321','321','3123','简单介绍下自己，让用人企业更关注你！\r\n                3123','321','312','2016-06-22 16:38:27',NULL,NULL,0);

/*!40000 ALTER TABLE `resumes` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table second_car
# ------------------------------------------------------------

DROP TABLE IF EXISTS `second_car`;

CREATE TABLE `second_car` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '发布人',
  `merchant_id` int(11) NOT NULL DEFAULT '0' COMMENT '发布商家id',
  `is_merchant` int(11) NOT NULL DEFAULT '0' COMMENT '是否为商家',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '汽车品牌',
  `title` varchar(80) NOT NULL DEFAULT '' COMMENT '标题',
  `journey` decimal(10,2) NOT NULL COMMENT '行程',
  `buy_time` varchar(50) NOT NULL DEFAULT '' COMMENT '购买时间',
  `license_time` varchar(50) NOT NULL DEFAULT '' COMMENT '上牌时间',
  `insurance_deadtime` varchar(50) NOT NULL DEFAULT '' COMMENT '交强险到期时间',
  `introduction` varchar(500) NOT NULL DEFAULT '' COMMENT '描述',
  `nature` varchar(80) NOT NULL DEFAULT '' COMMENT '是否运营',
  `exhaust` decimal(10,2) NOT NULL COMMENT '排气量',
  `pictue` varchar(160) NOT NULL DEFAULT '' COMMENT '驾照',
  `price` decimal(10,2) NOT NULL COMMENT 'sales',
  `color` int(11) NOT NULL DEFAULT '0' COMMENT '车身颜色',
  `car_pic` varchar(2000) NOT NULL DEFAULT '' COMMENT '汽车照片数组',
  `concact_name` varchar(50) NOT NULL DEFAULT '' COMMENT '联系人',
  `concact_phone` varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话',
  `watch` int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `times` int(11) NOT NULL DEFAULT '0' COMMENT '过户次数',
  `constrct` varchar(50) NOT NULL DEFAULT '' COMMENT '车身结构',
  PRIMARY KEY (`id`),
  KEY `IDX_MN` (`user_id`),
  KEY `IDX_MM` (`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二手车信息';

LOCK TABLES `second_car` WRITE;
/*!40000 ALTER TABLE `second_car` DISABLE KEYS */;

INSERT INTO `second_car` (`id`, `user_id`, `merchant_id`, `is_merchant`, `type`, `title`, `journey`, `buy_time`, `license_time`, `insurance_deadtime`, `introduction`, `nature`, `exhaust`, `pictue`, `price`, `color`, `car_pic`, `concact_name`, `concact_phone`, `watch`, `created_at`, `updated_at`, `deleted_at`, `times`, `constrct`)
VALUES
	(1,3,7,1,1,'3123',32.00,'312','312','312','1                    车辆信息，要求等等\r\n                31','0',32.00,'AD729B015C2DB1783CC4639EC7D0076BBD2C22612A695FFB8542C8E899DE49EE',32.00,1,'C4AF1542E461FB5A848FCCB91CDDFF52871EB3E3480600175EA9E43A5DE28907,BFFF2C41DD8B34D1C0E39DF5D121E9A2F4907FC6B88AD4AD0F0925BB2E5EFBD2','312','312',0,'2016-06-22 20:11:10',NULL,NULL,0,''),
	(2,3,7,1,1,'3123',32.00,'312','312','312','1                    车辆信息，要求等等\r\n                31','0',32.00,'AD729B015C2DB1783CC4639EC7D0076BBD2C22612A695FFB8542C8E899DE49EE',32.00,1,'C4AF1542E461FB5A848FCCB91CDDFF52871EB3E3480600175EA9E43A5DE28907,BFFF2C41DD8B34D1C0E39DF5D121E9A2F4907FC6B88AD4AD0F0925BB2E5EFBD2','312','312',0,'2016-06-22 20:11:19',NULL,NULL,0,''),
	(3,3,7,1,1,'3123',32.00,'312','312','312','1                    车辆信息，要求等等\r\n                31','0',32.00,'/upload/carMerchant/AD729B015C2DB1783CC4639EC7D0076BBD2C22612A695FFB8542C8E899DE49EE',32.00,1,'/upload/carMerchant/C4AF1542E461FB5A848FCCB91CDDFF52871EB3E3480600175EA9E43A5DE28907,/upload/carMerchant/BFFF2C41DD8B34D1C0E39DF5D121E9A2F4907FC6B88AD4AD0F0925BB2E5EFBD2','312','312',0,'2016-06-22 20:17:33',NULL,NULL,0,''),
	(4,3,7,1,1,'3123',32.00,'312','312','312','1                    车辆信息，要求等等\r\n                31','0',32.00,'/upload/carMerchant/AD729B015C2DB1783CC4639EC7D0076BBD2C22612A695FFB8542C8E899DE49EE',32.00,1,'/upload/carMerchant/C4AF1542E461FB5A848FCCB91CDDFF52871EB3E3480600175EA9E43A5DE28907,/upload/carMerchant/BFFF2C41DD8B34D1C0E39DF5D121E9A2F4907FC6B88AD4AD0F0925BB2E5EFBD2,/upload/carMerchant/5C988F705E103D9F8ECC41F43F164613BD80AB3372D36A40FE1B51D3DBE3020C,/upload/carMerchant/9A4DDEDECAF68C47520FF83D0B0F3615B541DE4680DA47C371B75A87DAE2A32C','312','312',0,'2016-06-22 20:20:29',NULL,NULL,0,'');

/*!40000 ALTER TABLE `second_car` ENABLE KEYS */;
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
  `is_merchant` int(11) DEFAULT '0' COMMENT '是否是商家',
  PRIMARY KEY (`id`),
  KEY `IDX_MN` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='注册用户';

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `name`, `user_name`, `password`, `email`, `created_at`, `updated_at`, `is_merchant`)
VALUES
	(1,'31233','3333','333333','','2016-08-06 18:34:59',NULL,0),
	(2,'32131','32131','3123131','','2016-08-06 18:53:25',NULL,0),
	(3,'3312','hzq','123456','','2016-08-06 19:41:26','2016-06-22 18:58:34',1);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
