SHOW DATABASES;

CREATE DATABASE blog;

USE blog;

DROP TABLE `t_article`;
DROP TABLE `t_comment`;
DROP TABLE `t_user`;

CREATE TABLE `t_article` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `title` VARCHAR(200) DEFAULT NULL COMMENT '文章标题',
  `content` LONGTEXT COMMENT '文章内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=UTF8MB4;

INSERT INTO `t_article` VALUES ('1', 'Spring Boot基础入门', '从入门到精通讲解...');
INSERT INTO `t_article` VALUES ('2', 'Spring Cloud基础入门', '从入门到精通讲解...');
INSERT INTO `t_article` VALUES ('3', '尹立庆SpringBoot培训', '从入门到精通讲解...');

CREATE TABLE `t_comment` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `content` LONGTEXT COMMENT '评论内容',
  `author` VARCHAR(200) DEFAULT NULL COMMENT '评论作者',
  `a_id` BIGINT DEFAULT NULL COMMENT '关联的文章编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=UTF8MB4;

INSERT INTO `t_comment` VALUES ('1', '很全、很详细', '尹立庆', '1');
INSERT INTO `t_comment` VALUES ('2', '赞一个', '孙艳波', '3');
INSERT INTO `t_comment` VALUES ('3', '很详细，喜欢', '梁秀东', '1');
INSERT INTO `t_comment` VALUES ('4', '很好，非常详细', '钟芯', '2');
INSERT INTO `t_comment` VALUES ('5', '很不错', '张允', '2');
INSERT INTO `t_comment` VALUES ('6', '操作性强，真棒', '唐晓丽', '3');
INSERT INTO `t_comment` VALUES ('7', '内容全面，讲解清晰', '张杨', '1');


CREATE TABLE `t_user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户编号',
    `firstName` VARCHAR(255) NOT NULL COMMENT '姓名第一部分',
    `lastName` VARCHAR(255) NOT NULL COMMENT '姓名第二部分',
    `address` VARCHAR(255) DEFAULT NULL COMMENT '用户地址',
    `postCode` VARCHAR(20) DEFAULT NULL COMMENT '邮编',
    `phoneNumber` VARCHAR(20) DEFAULT NULL COMMENT '联系电话',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=UTF8MB4;

INSERT INTO `t_user` VALUES ('1', '尹', '立庆', '北京市海淀区', '100080', '13521526165');
INSERT INTO `t_user` VALUES ('2', '孙', '艳波', '北京市朝阳区', '100070', '13521526165');
INSERT INTO `t_user` VALUES ('3', '梁', '秀东', '北京市通州区', '100060', '13521526165');

SHOW TABLES;


