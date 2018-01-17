/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.0.67-community-nt : Database - bookstore_170410
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore_170410` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore_170410`;

/*Table structure for table `bs_books` */

DROP TABLE IF EXISTS `bs_books`;

CREATE TABLE `bs_books` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(50) NOT NULL,
  `author` varchar(20) default NULL,
  `price` double(11,2) default NULL,
  `sales` int(11) default NULL,
  `stocks` int(11) default NULL,
  `img_path` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

/*Data for the table `bs_books` */

insert  into `bs_books`(`id`,`title`,`author`,`price`,`sales`,`stocks`,`img_path`) values (42,'时间简史5','霍金',58.00,40,50,'static/img/default.jpg'),(43,'解忧杂货店','东野圭吾',27.20,60,70,'static/img/default.jpg'),(44,'边城','沈从文',23.00,101,99,'static/img/default.jpg'),(45,'中国哲学史','冯友兰1',44.50,100,100,'static/img/default.jpg'),(46,'忽然七日',' 劳伦',19.33,100,100,'static/img/default.jpg'),(47,'苏东坡传','林语堂',19.30,100,100,'static/img/default.jpg'),(48,'百年孤独','马尔克斯',29.50,100,100,'static/img/default.jpg'),(49,'扶桑','严歌苓',19.80,100,100,'static/img/default.jpg'),(50,'教父','马里奥·普佐',29.00,100,100,'static/img/default.jpg'),(51,'给孩子的诗','北岛',22.20,100,100,'static/img/default.jpg'),(52,'为奴十二年','所罗门',16.50,100,100,'static/img/default.jpg'),(54,'悟空传','今何在',14.00,100,100,'static/img/default.jpg'),(56,'从晚清到民国','唐德刚6',39.90,100,100,'static/img/default.jpg'),(57,'三体','刘慈欣',56.50,100,100,'static/img/default.jpg'),(60,'小王子','安托万3',19.20,100,100,'static/img/default.jpg'),(61,'我们仨','杨绛',11.30,100,100,'static/img/default.jpg'),(62,'生命不息,折腾不止','罗永浩',25.20,100,100,'static/img/default.jpg'),(63,'皮囊','蔡崇达',23.90,100,100,'static/img/default.jpg'),(64,'恰到好处的幸福','毕淑敏',16.40,100,100,'static/img/default.jpg'),(65,'艾伦·图灵传','安德鲁',47.20,100,100,'static/img/default.jpg'),(66,'大数据预测','埃里克3',37.20,100,100,'static/img/default.jpg'),(67,'人月神话','布鲁克斯',55.90,100,100,'static/img/default.jpg'),(68,'C语言入门经典','霍尔顿',45.00,100,100,'static/img/default.jpg'),(69,'数学之美','吴军',29.90,200,100,'upload/1493711428816_Java核心技术 卷Ⅰ基础知识.jpg'),(70,'Java编程思想','埃史尔',70.50,100,100,'static/img/default.jpg'),(71,'Tomcat与javaWeb开发','孙卫琴',78.00,100,100,'static/img/default.jpg'),(72,'java 开发思想11','曹曹',56.00,104,96,'upload/1493711446761_深入理解JAVA虚拟机 JVM高级特性.jpg'),(73,'少年啊，路还远着呢','徐泸生',20.00,200,200,'upload/1493714352834_Java Web整合开发实战.jpg'),(74,'sfsdf','dsfsdfwerewrwe',23.00,232,232,'upload/1493714443403_java面试宝典.jpg');

/*Table structure for table `bs_order_items` */

DROP TABLE IF EXISTS `bs_order_items`;

CREATE TABLE `bs_order_items` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(20) default NULL,
  `author` varchar(20) default NULL,
  `price` double(11,2) default NULL,
  `sales` int(11) default NULL,
  `stocks` int(11) default NULL,
  `img_path` varchar(100) default NULL,
  `count` int(11) default NULL,
  `amount` double(11,2) default NULL,
  `order_id` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `bs_order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `bs_orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `bs_order_items` */

insert  into `bs_order_items`(`id`,`title`,`author`,`price`,`sales`,`stocks`,`img_path`,`count`,`amount`,`order_id`) values (1,'时间简史','霍金',58.00,100,100,'static/img/default.jpg',100,5800.00,'14930345549611'),(2,'Tomcat与javaWeb开发','孙卫琴',78.00,100,100,'static/img/default.jpg',1,78.00,'14930414158132'),(3,'Java编程思想','埃史尔',70.50,100,100,'static/img/default.jpg',1,70.50,'14930414158132'),(4,'人月神话','布鲁克斯',55.90,100,100,'static/img/default.jpg',1,55.90,'14930414633972'),(5,'艾伦·图灵传','安德鲁',47.20,100,100,'static/img/default.jpg',1,47.20,'14930414633972'),(6,'大数据预测','埃里克3',37.20,100,100,'static/img/default.jpg',1,37.20,'14930414633972'),(7,'数学之美','吴军',29.90,100,100,'static/img/default.jpg',1,29.90,'14930428904861'),(8,'Java编程思想','埃史尔',70.50,100,100,'static/img/default.jpg',1,70.50,'14930428904861'),(9,'Java编程思想','埃史尔',70.50,100,100,'static/img/default.jpg',1,70.50,'14930436968801'),(10,'Tomcat与javaWeb开发','孙卫琴',78.00,100,100,'static/img/default.jpg',1,78.00,'14930436968801'),(11,'java 开发思想','曹曹',56.00,100,100,'static/img/default.jpg',1,56.00,'14930436968801'),(12,'Tomcat与javaWeb开发','孙卫琴',78.00,100,100,'static/img/default.jpg',1,78.00,'14930858798661'),(13,'java 开发思想','曹曹',56.00,100,100,'static/img/default.jpg',2,112.00,'14930858798661'),(14,'扶桑','严歌苓',19.80,100,100,'static/img/default.jpg',1,19.80,'14930861244001'),(15,'教父','马里奥·普佐',29.00,100,100,'static/img/default.jpg',1,29.00,'14930861244001'),(16,'时间简史','霍金',58.00,100,100,'static/img/default.jpg',100,5800.00,'14930345549611'),(17,'时间简史1','霍金1',58.00,100,100,'static/img/default.jpg',100,5800.00,'14930345549611'),(18,'扶桑','严歌苓',19.80,100,100,'static/img/default.jpg',1,19.80,'14930892878541'),(19,'教父','马里奥·普佐',29.00,100,100,'static/img/default.jpg',1,29.00,'14930892878541'),(20,'从晚清到民国','唐德刚6',39.90,100,100,'static/img/default.jpg',1,39.90,'14931687952181'),(21,'悟空传','今何在',14.00,100,100,'static/img/default.jpg',1,14.00,'14931687952181'),(22,'Tomcat与javaWeb开发','孙卫琴',78.00,100,100,'static/img/default.jpg',1,78.00,'14931705250651'),(23,'java 开发思想','曹曹',56.00,100,100,'static/img/default.jpg',1,56.00,'14931705250651');

/*Table structure for table `bs_orders` */

DROP TABLE IF EXISTS `bs_orders`;

CREATE TABLE `bs_orders` (
  `id` varchar(100) NOT NULL,
  `total_count` int(11) default NULL,
  `total_amount` double(11,2) default NULL,
  `user_id` int(11) default NULL,
  `state` int(2) default NULL,
  `create_date` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bs_orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `bs_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_orders` */

insert  into `bs_orders`(`id`,`total_count`,`total_amount`,`user_id`,`state`,`create_date`) values ('14930345549611',100,100.00,1,2,NULL),('14930414158132',2,148.50,2,1,NULL),('14930414633972',3,140.30,2,1,NULL),('14930428904861',2,100.40,1,2,NULL),('14930436968801',3,204.50,1,2,'2017-04-24 22:21:36'),('14930437619101',0,0.00,1,2,'2017-04-24 22:22:41'),('14930858798661',3,190.00,1,2,'2017-04-25 10:04:39'),('14930861244001',2,48.80,1,0,'2017-04-25 10:08:44'),('14930862223101',0,0.00,1,0,'2017-04-25 10:10:22'),('14930892878541',2,48.80,1,0,'2017-04-25 11:01:27'),('14931687952181',2,53.90,1,0,'2017-04-26 09:06:35'),('14931705250651',2,134.00,1,0,'2017-04-26 09:35:25');

/*Table structure for table `bs_users` */

DROP TABLE IF EXISTS `bs_users`;

CREATE TABLE `bs_users` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `bs_users` */

insert  into `bs_users`(`id`,`username`,`password`,`email`) values (1,'admin','123123','admin@163.com'),(2,'liuzaishi','123123','liuzaishi@163.com'),(3,'hahaha','hahaha','haha@163.com'),(4,'jinzhongguo','123123','jinzhongguo@163.com'),(5,'jinzhongguo2','123123','jinzhongguo@163.com'),(6,'jinzhongguo3','123123','jinzhongguo@163.com'),(7,'jinzhongguo1','123123','jinzhongguo@163.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
