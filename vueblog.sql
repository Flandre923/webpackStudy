/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : vueblog

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 26/03/2021 18:33:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'flandre', '$2a$10$JlqPZQnlIn5iea4k3ESbjOfJNLLHuQJlFT03DJHMvQ2TtOGm2TQ4a');

-- ----------------------------
-- Table structure for anime
-- ----------------------------
DROP TABLE IF EXISTS `anime`;
CREATE TABLE `anime`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `animename` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '番剧名字',
  `animeoriginname` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '番剧原标题',
  `animedesc` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '番剧介绍',
  `animeimg` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '番剧图片',
  `animeprogress` int(11) NULL DEFAULT NULL COMMENT '番剧进度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of anime
-- ----------------------------
INSERT INTO `anime` VALUES (1, '日常悠哉大王', 'のんのんびより', '故事以有着优美自然风景的乡下学校旭丘分校为舞台，讲述少女们的悠哉日常生活。', 'https://gss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/377adab44aed2e7348b0f47e8101a18b87d6fa03.jpg', 30);
INSERT INTO `anime` VALUES (2, 'Re：从零开始的异世界生活 第二季 后半)', 'Re：ゼロから始める異世界生活', '我一定会拯救你。在打倒了魔女教大罪司教「怠惰」担当——培提其乌斯·罗曼尼康帝之后，菜月昴和爱蜜莉雅又得以重新开始。克服了艰难的诀别，两人终于和解，然而这只是新一轮风波的序幕。超乎想象的绝境危机，接踵而至的残酷现实。少年将再次直面残酷的命运。', 'https://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/6c224f4a20a44623a3ae19699022720e0cf3d751.jpg', 50);
INSERT INTO `anime` VALUES (3, '转生成蜘蛛又怎样！', '蜘蛛ですが、なにか？', '曾经是一名女高中生的“我”，突然转生变成了幻想世界中的蜘蛛魔物。而且，出生地点还是各种凶恶魔物所盘踞的大迷宫。“我”以人类的智慧和非同寻常的积极心态为武器，使用蜘蛛的丝网以及陷阱打倒比自己等级高得多的敌人，从而存活下来……身为种族链底端的，拥有最强精神力的这位少女的迷宫生存剧，现在开幕！', 'http://www.suanchang.com/zb_users/upload/2020/06/202006281593337873581435.jpg', 10);
INSERT INTO `anime` VALUES (4, '进击的巨人', '進撃の巨人', '在他正做着到墙壁的外面去这个梦的时候，毁坏墙壁的超大巨人出现了。', 'http://www.people.com.cn/mediafile/pic/20150115/74/17371177951978825502.jpg', 80);

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '标题',
  `summary` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '简述',
  `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新日期',
  `content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `number` int(11) NOT NULL COMMENT '字数',
  `read_time` int(11) NOT NULL COMMENT '阅读时间',
  `picture` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, 'Redis+定时任务实现访客标识及统计PV、UV', '又是沉迷游戏的一个月，入了异星工厂后，果断踹开 Screeps...作为基建狂魔快乐了一把，花了123小时废了三个档通关（实际上通关后游戏才真正开始..），感觉啥都好，就是有点废肝，不愧是轻松惬意奖提名', '2021-03-18 15:31:50', '## 你好\n这是一篇测试的blog\n~~你可以随意编辑~~\n```java\nSystem.out.println(\'你也是可以随便编辑的\')\n```\n\n你好\n\n![关于图片的特使](https://cdn.jsdelivr.net/gh/moezx/cdn@3.3.5/img/other/sakura-features/sakura%20%281%29.png?thumb=_tn#width-full)', '2021-03-12 20:40:11', 162, 8, 'https://cdn.jsdelivr.net/gh/moezx/cdn@3.3.5/img/other/sakura-features/sakura%20%281%29.png?thumb=_tn#width-full');
INSERT INTO `blog` VALUES (2, 'WordPress 主题 Sakura', '我改的第二个 WordPress 主题，前后花了大半年的时间，选择在博客一周年的时候开源出来算是一个纪念。从一年前技术为零走到今天，最该感谢的就是各个开源项目和教程，我深深体会到了开源精神的力量，所以这也算是对开源社区的微小贡献吧。主题经过测试，WordPress 全新安装的情况下可直接使用，后台的设置面板可满足正常使用需要，无需手动修改代码', '2021-03-13 16:13:29', '是我改的第二个 WordPress 主题，前后花了大半年的时间，选择在博客一周年的时候开源出来算是一个纪念。从一年前技术为零走到今天，最该感谢的就是各个开源项目和教程，我深深体会到了开源精神的力量，所以这也算是对开源社区的微小贡献吧。主题经过测试，WordPress 全新安装的情况下可直接使用，后台的设置面板可满足正常使用需要，无需手动修改代码', '2021-03-13 16:02:13', 162, 8, 'https://cdn.jsdelivr.net/gh/moezx/cdn@3.3.5/img/other/sakura-features/sakura%20%281%29.png?thumb=_tn#width-full');
INSERT INTO `blog` VALUES (3, 'Docker 部署 1Zabbix + Grafana', '\n\n两年前在服务1器上放了一套 Grafana + Zabbix + Prometheus 的监控系统，当时是照着文档和网上各路教程一个一个编译的，插件和配置文件丢得七零八落，很难维护，故这几天借迁移服务器的机会，改用 Docker 安装，基本只用一个配置文件，今后随时可以一键部署。目前写好了 MySQL + Grafana + Zabbix-Server + Zabbix-Agent 的配置，Prometheus（以前主要用来监控 MySQL）暂时还没做，以后补上。', '2021-03-18 12:41:00', '\n1两年前在服务器上放了一套 Grafana + Zabbix + Prometheus 的监控系统，当时是照着文档和网上各路教程一个一个编译的，插件和配置文件丢得七零八落，很难维护，故这几天借迁移服务器的机会，改用 Docker 安装，基本只用一个配置文件，今后随时可以一键部署。目前写好了 MySQL + Grafana + Zabbix-Server + Zabbix-Agent 的配置，Prometheus（以前主要用来监控 MySQL）暂时还没做，以后补上。111', '2020-06-10 16:46:45', 1221, 111, 'https://2heng.xin/wp-content/uploads//2017/12/｡･：＊：･✿-PID65231071-by-hakusai.jpg');
INSERT INTO `blog` VALUES (5, '关于第周一没有更新进击巨人', '这可真是难办啊。\n', '2021-03-18 19:46:06', '## 1 没有更新\n### 2 没有更i性能\n#### 4 日本地名了\n```java\nprint(\"牛啊\")\n```\n\n==122==\n\n> 这个也行啊\n\n~~试试~~\n\n', '2021-03-18 19:44:15', 1, 1, 'https://view.moezx.cc/images/2021/02/14/eb6934b125f8680358349ee3750f4235.webp');

-- ----------------------------
-- Table structure for blog2tag
-- ----------------------------
DROP TABLE IF EXISTS `blog2tag`;
CREATE TABLE `blog2tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogid` int(11) NOT NULL,
  `tagid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog2tag
-- ----------------------------
INSERT INTO `blog2tag` VALUES (1, 1, 1);
INSERT INTO `blog2tag` VALUES (4, 2, 1);
INSERT INTO `blog2tag` VALUES (17, 3, 1);
INSERT INTO `blog2tag` VALUES (20, 3, 2);
INSERT INTO `blog2tag` VALUES (21, 3, 3);
INSERT INTO `blog2tag` VALUES (22, 3, 10);
INSERT INTO `blog2tag` VALUES (28, 1, 2);
INSERT INTO `blog2tag` VALUES (29, 5, 1);
INSERT INTO `blog2tag` VALUES (31, 5, 2);

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
  `friendname` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '友链名字',
  `frienddesc` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '友链描述',
  `friendurl` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '友链连接',
  `friendavatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '友链头像',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('test1', 'test1', 'http://www.baidu.com', 'https://view.moezx.cc/images/2021/03/08/d637633dc5d6de2f4d7d790d73297e32.jpg', 1);
INSERT INTO `friend` VALUES ('test2', 'test2', 'http://www.bilibili.com', 'https://view.moezx.cc/images/2021/03/08/d637633dc5d6de2f4d7d790d73297e32.jpg', 2);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'tag主键',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, '测试112');
INSERT INTO `tag` VALUES (2, '测试2');
INSERT INTO `tag` VALUES (3, '测试3');

SET FOREIGN_KEY_CHECKS = 1;
