# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 192.168.29.101 (MySQL 5.6.33)
# Database: tzcxw
# Generation Time: 2016-09-22 02:41:15 +0000
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='注册企业';

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;

INSERT INTO `companies` (`id`, `name`, `user_name`, `password`, `email`, `company`, `industry`, `type`, `create_date`, `employees`, `money`, `html`, `area`, `introduction`, `concat_name`, `phone`, `fax`, `address`, `created_at`, `updated_at`)
VALUES
	(3,'312312321','hzq','123456','2','31','2','2','22','2','2','2','2','2','3','2','2','2','2016-08-06 19:38:32','2016-08-07 07:08:02');

/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table recruitments
# ------------------------------------------------------------

DROP TABLE IF EXISTS `recruitments`;

CREATE TABLE `recruitments` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL DEFAULT '-1' COMMENT '企业编号',
  `picture` varchar(160) NOT NULL DEFAULT '' COMMENT '企业相册',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='注册用户';

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `name`, `user_name`, `password`, `email`, `created_at`, `updated_at`)
VALUES
	(1,'31233','3333','333333','','2016-08-06 18:34:59',NULL),
	(2,'32131','32131','3123131','','2016-08-06 18:53:25',NULL),
	(3,'3312','hzq','123456','','2016-08-06 19:41:26','2016-08-07 07:07:51');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
