************************************************************
Sequel Pro SQL dump
Version 4541
http://www.sequelpro.com/
https://github.com/sequelpro/sequelpro
Host: 192.168.145.202 (MySQL 5.6.33)
Database: tzcxw
Generation Time: 2016-09-22 01:54:11 +0000
************************************************************
/*!40101 SET @OLDCHARACTERSETCLIENT=@@CHARACTERSETCLIENT /; /!40101 SET @OLDCHARACTERSETRESULTS=@@CHARACTERSETRESULTS /; /!40101 SET @OLDCOLLATIONCONNECTION=@@COLLATIONCONNECTION /; /!40101 SET NAMES utf8 /; /!40014 SET @OLDFOREIGNKEYCHECKS=@@FOREIGNKEYCHECKS, FOREIGNKEYCHECKS=0 /; /!40101 SET @OLDSQLMODE=@@SQLMODE, SQLMODE='NOAUTOVALUEONZERO' /; /!40111 SET @OLDSQLNOTES=@@SQLNOTES, SQLNOTES=0 */;

Dump of table companies
------------------------------------------------------------
DROP TABLE IF EXISTS companies;

CREATE TABLE companies ( id int(11) unsigned NOT NULL AUTOINCREMENT, name varchar(80) NOT NULL DEFAULT '' COMMENT '姓名', user_name varchar(80) NOT NULL DEFAULT '' COMMENT '用户名', password varchar(80) NOT NULL DEFAULT '' COMMENT '密码', email varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱', company varchar(50) NOT NULL DEFAULT '' COMMENT '公司名称', industry varchar(50) NOT NULL DEFAULT '' COMMENT '所属行业', type varchar(50) NOT NULL DEFAULT '' COMMENT '公司性质', create_date varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期', employees varchar(50) NOT NULL DEFAULT '' COMMENT '员工人数', money varchar(50) NOT NULL DEFAULT '' COMMENT '注册资金', html varchar(50) NOT NULL DEFAULT '' COMMENT '公司首页', area varchar(50) NOT NULL DEFAULT '' COMMENT '所属地区', introduction varchar(200) NOT NULL DEFAULT '' COMMENT '所属行业', concat_name varchar(50) NOT NULL DEFAULT '' COMMENT '联系人', phone varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话', fax varchar(50) NOT NULL DEFAULT '' COMMENT '传真号码', address varchar(50) NOT NULL DEFAULT '' COMMENT '通讯地址', watch int(11) DEFAULT '0' COMMENT '浏览次数', created_at timestamp NULL DEFAULT CURRENTTIMESTAMP COMMENT '创建时间', updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间', PRIMARY KEY (id), KEY IDX_MN (user_name) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES companies WRITE; /*!40000 ALTER TABLE companies DISABLE KEYS */;

INSERT INTO companies (id, name, user_name, password, email, company, industry, type, create_date, employees, money, html, area, introduction, concat_name, phone, fax, address, watch, created_at, updated_at) VALUES (3,'312312321','hzq','123456','2','31','2','2','22','2','2','2','2','2','3','2','2','2',NULL,'2016-08-06 19:38:32','2016-06-21 21:33:28');

/*!40000 ALTER TABLE companies ENABLE KEYS */; UNLOCK TABLES;

Dump of table recruitments
------------------------------------------------------------
DROP TABLE IF EXISTS recruitments;

CREATE TABLE recruitments ( id int(11) unsigned NOT NULL AUTOINCREMENT, company_id int(11) NOT NULL DEFAULT '-1' COMMENT '企业编号', picture varchar(160) NOT NULL DEFAULT '' COMMENT '企业相册', type int(11) NOT NULL DEFAULT '0' COMMENT '职位类别', education int(11) NOT NULL DEFAULT '0' COMMENT '学历', people_count int(11) NOT NULL DEFAULT '0' COMMENT '招聘人数', work_year varchar(50) NOT NULL DEFAULT '' COMMENT '工作年限', salary int(11) NOT NULL DEFAULT '0' COMMENT '月薪', probation int(11) NOT NULL DEFAULT '0' COMMENT '试用期', work_area int(11) NOT NULL DEFAULT '0' COMMENT '工作区域', detail_area varchar(50) NOT NULL DEFAULT '' COMMENT '详细地点', title varchar(80) NOT NULL DEFAULT '' COMMENT '招聘标题', introduction varchar(500) NOT NULL DEFAULT '' COMMENT '职位描述', concact_name varchar(50) NOT NULL DEFAULT '' COMMENT '联系人', concact_phone varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话', created_at timestamp NULL DEFAULT CURRENTTIMESTAMP COMMENT '创建时间', updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间', deleted_at timestamp NULL DEFAULT NULL COMMENT '删除时间', watch int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数', PRIMARY KEY (id), KEY IDX_MN (company_id) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我的招聘';

LOCK TABLES recruitments WRITE; /*!40000 ALTER TABLE recruitments DISABLE KEYS */;

INSERT INTO recruitments (id, company_id, picture, type, education, people_count, work_year, salary, probation, work_area, detail_area, title, introduction, concact_name, concact_phone, created_at, updated_at, deleted_at, watch) VALUES (2,3,'url',0,0,3,'0',0,1,0,'312','31231','岗位职责：任职资格：工作31231时间：\r\n ','312','31231','2016-06-21 20:44:05',NULL,NULL,0), (3,3,'url',0,0,3,'0',0,1,0,'312','31231','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n ','312','31231 Name','2016-06-21 20:49:14',NULL,NULL,0), (4,3,'url',0,0,3,'0',0,1,0,'312','31231','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n ','312','31231 Name','2016-06-21 20:49:20',NULL,NULL,0), (5,3,'url',0,0,3,'0',0,1,0,'312','31231','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n ','312','31231 Name','2016-06-21 21:32:32',NULL,NULL,0), (6,3,'url',0,0,3,'0',0,1,0,'312','31231','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n ','312','31231 Name','2016-06-21 21:33:20',NULL,NULL,0), (7,3,'url',0,0,3,'0',0,1,0,'312','31231','å²ä½èè´£ï¼ä»»èèµæ ¼ï¼å·¥ä½31231æ¶é´ï¼\r\n ','312','31231 Name','2016-06-21 21:33:28',NULL,NULL,0);

/*!40000 ALTER TABLE recruitments ENABLE KEYS */; UNLOCK TABLES;

Dump of table resumes
------------------------------------------------------------
DROP TABLE IF EXISTS resumes;

CREATE TABLE resumes ( id int(11) unsigned NOT NULL AUTOINCREMENT, user_id int(11) NOT NULL DEFAULT '-1' COMMENT '所属用户', title varchar(80) NOT NULL DEFAULT '' COMMENT '简历标题', type int(11) NOT NULL DEFAULT '0' COMMENT '职位类别', picture varchar(160) NOT NULL DEFAULT '' COMMENT '相片', name varchar(50) NOT NULL DEFAULT '' COMMENT '姓名', sex varchar(50) NOT NULL DEFAULT '' COMMENT '性别', birth_year varchar(50) NOT NULL DEFAULT '' COMMENT '出生年份', birth_date varchar(50) NOT NULL DEFAULT '' COMMENT '出生月份', work_year varchar(50) NOT NULL DEFAULT '' COMMENT '工作年限', education varchar(50) NOT NULL DEFAULT '' COMMENT '学历', work_area int(11) NOT NULL DEFAULT '0' COMMENT '工作区域', detail_area varchar(50) NOT NULL DEFAULT '' COMMENT '详细地点', salary int(11) NOT NULL DEFAULT '0' COMMENT '月薪', phone varchar(50) NOT NULL DEFAULT '' COMMENT '手机号', email varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱', address varchar(50) NOT NULL DEFAULT '' COMMENT '籍贯', introduction varchar(200) NOT NULL DEFAULT '' COMMENT '自我介绍', concact_name varchar(50) NOT NULL DEFAULT '' COMMENT '联系人', concact_phone varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话', created_at timestamp NULL DEFAULT CURRENTTIMESTAMP COMMENT '创建时间', updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间', deleted_at timestamp NULL DEFAULT NULL COMMENT '删除时间', watch int(11) NOT NULL DEFAULT '0' COMMENT '被查看数', PRIMARY KEY (id), KEY IDX_MN (user_id) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES resumes WRITE; /*!40000 ALTER TABLE resumes DISABLE KEYS */;

INSERT INTO resumes (id, user_id, title, type, picture, name, sex, birth_year, birth_date, work_year, education, work_area, detail_area, salary, phone, email, address, introduction, concact_name, concact_phone, created_at, updated_at, deleted_at, watch) VALUES (1,3,'312',0,'123','312','0','11','23','0','0',0,'',0,'312','312','312','简单介绍下自己，让用人企业更关注你！\r\n 23','321','321','2016-06-21 18:27:25',NULL,NULL,0);

/*!40000 ALTER TABLE resumes ENABLE KEYS */; UNLOCK TABLES;

Dump of table users
------------------------------------------------------------
DROP TABLE IF EXISTS users;

CREATE TABLE users ( id int(11) unsigned NOT NULL AUTOINCREMENT, name varchar(80) NOT NULL DEFAULT '' COMMENT '姓名', user_name varchar(80) NOT NULL DEFAULT '' COMMENT '用户名', password varchar(80) NOT NULL DEFAULT '' COMMENT '密码', email varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱', created_at timestamp NULL DEFAULT CURRENTTIMESTAMP COMMENT '创建时间', updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间', PRIMARY KEY (id), KEY IDX_MN (user_name) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES users WRITE; /*!40000 ALTER TABLE users DISABLE KEYS */;

INSERT INTO users (id, name, user_name, password, email, created_at, updated_at) VALUES (1,'31233','3333','333333','','2016-08-06 18:34:59',NULL), (2,'32131','32131','3123131','','2016-08-06 18:53:25',NULL), (3,'3312','hzq','123456','','2016-08-06 19:41:26','2016-06-21 20:58:16'), (4,'名字','username','123456','','2016-06-21 20:09:25',NULL);

/*!40000 ALTER TABLE users ENABLE KEYS */; UNLOCK TABLES;

/*!40111 SET SQLNOTES=@OLDSQLNOTES /; /!40101 SET SQLMODE=@OLDSQLMODE /; /!40014 SET FOREIGNKEYCHECKS=@OLDFOREIGNKEYCHECKS /; /!40101 SET CHARACTERSETCLIENT=@OLDCHARACTERSETCLIENT /; /!40101 SET CHARACTERSETRESULTS=@OLDCHARACTERSETRESULTS /; /!40101 SET COLLATIONCONNECTION=@OLDCOLLATIONCONNECTION */;