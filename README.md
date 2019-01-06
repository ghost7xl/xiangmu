数码商城使用说明文档
1、概述..............................................................................................................................
1.1 项目名称
1.2 项目概述
1.3 开发环境
1.4 运行环境
2、业务流程.......................................................................................................................
3、系统功能模块设计........................................................................................................
3.1 前台系统
3.1.1 商品浏览
3.1.2 商品查找
3.1.3 用户注册及登陆
3.1.4 个人中心
3.1.5 购物车
3.2 后台系统...............................................................................................................
3.2.1 用户管理
3.2.2 商品类型管理
3.2.3 商品管理
 	3.2.4 订单管理
4、数据库设计................................................................................................................
1)用户信息
2)购物车信息
3)购物车商品详情
4)商品详情
5)商品分类
6)收货地址：省份
7)收货地址：市区
8)收货地址：城市
9)管理员信息
10)订单信息
11)订单详情

1、概述
1.1 项目名称
数码商城(NIIT)
1.2 项目概述
该商城系统仅用于学习使用，前台系统包括了：商品浏览、注册及登陆、个人中心、购物车、提交订单等功能。后台系统包括了：用户管理、商品类型管理、商品管理、订单管理等。
1.3 开发环境 java jdk 8 +eclipse oxygen + mysql 5.7 +tomcat 7.0 
1.4 运行环境
Deepin linux 15.7

2、业务流程
进入主页——注册用户——用户登陆——浏览商品——搜索商品——加入购物车——
个人中心——查看个人信息——查看订单信息——购物车——购买
管理员登陆——管理用户——查看修改商品信息——添加商品——添加商品分类——
订单管理

3、系统功能模块设计
3.1 前台浏览
3.1.1 商品浏览
商品浏览包括：推荐浏览、商品分类浏览、商品列表浏览、商品基本信息浏览
3.1.2 商品查找
通过搜索框进行查找，商品类型和商品名称皆可搜索。
3.1.3 用户注册及登陆
注册登陆
3.1.4 个人中心
修改个人信息、收货地址等
3.1.5 购物车
更改商品数量，且提交订单
3.2 后台系统
3.2.1 用户管理
可进行用户信息的增删改。
3.2.2 商品类型管理
可进行商品类型的增删改。
3.2.3 商品管理
可添加商品，并且附加图片、介绍信息等。
 	3.2.4 订单管理
可将调整订单的状态，比如发货等。

4、数据库设计
12)用户信息
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '前台用户表id',
  `username` varchar(50) NOT NULL COMMENT '用户账号',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `email` varchar(50) NOT NULL COMMENT '用户邮箱',
  `activatecode` varchar(50) DEFAULT NULL COMMENT '激活码',
  `flag` int(2) NOT NULL DEFAULT '2' COMMENT '用户有效状态（1无效，2有效）',
  `gender` char(2) NOT NULL COMMENT '性别',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE 		CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) 
13)购物车信息
CREATE TABLE `t_cart` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '购物车表id',
  `uid` int(10) NOT NULL COMMENT '用户id',
  `money` double(10,0) NOT NULL COMMENT '总金额',
  PRIMARY KEY (`id`)
)
14)购物车商品详情
CREATE TABLE `t_cartdetail` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '购物车详情表id',
  `cid` int(10) DEFAULT NULL COMMENT '购物车id',
  `gid` int(10) DEFAULT NULL COMMENT '商品id',
  `num` int(10) DEFAULT NULL COMMENT '商品数量',
  `money` double(10,0) DEFAULT NULL COMMENT '商品金额',
  PRIMARY KEY (`id`)
)
15)商品详情
CREATE TABLE `t_goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品表id',
  `name` varchar(50) NOT NULL,
  `price` double(10,2) NOT NULL,
  `pubdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tid` int(11) NOT NULL COMMENT '所属类别',
  `intro` varchar(255) DEFAULT NULL COMMENT '商品介绍',
  `picture` varchar(100) DEFAULT NULL COMMENT '商品图片',
  `star` int(11) DEFAULT NULL COMMENT '商品星级',
  `flag` int(1) DEFAULT '2',
  PRIMARY KEY (`id`)
)
16)商品分类
CREATE TABLE `t_goodstype` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品类别表id',
  `name` varchar(20) NOT NULL,
  `level` int(11) DEFAULT NULL COMMENT '类别级别',
  `parentid` int(11) DEFAULT '0' COMMENT '父类类别',
  `flag` int(2) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`)
)
17)收货地址：省份
CREATE TABLE `t_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
18)收货地址：市区
CREATE TABLE `t_county` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `weatherCode` varchar(10) DEFAULT NULL,
  `cityid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
19)收货地址：城市
CREATE TABLE `t_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
20)管理员信息
DROP TABLE IF EXISTS `t_sysuser`;
CREATE TABLE `t_sysuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统用户',
  `username` varchar(50) NOT NULL COMMENT '用户账号',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `flag` int(2) NOT NULL DEFAULT '2' COMMENT '用户有效状态（1无效，2有效）',
  PRIMARY KEY (`id`)
) 
INSERT INTO `t_sysuser` VALUES ('1', 'admin', 'admin', '2');
21)订单信息
CREATE TABLE `t_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '订单表',
  `uid` int(10) NOT NULL,
  `uaid` int(10) NOT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `money` double NOT NULL,
  `flag` int(2) DEFAULT NULL COMMENT '有效状态（1无效，2有效）',
  PRIMARY KEY (`id`)
)

22)订单详情
CREATE TABLE `t_orderdetail` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '订单列表订单id',
  `oid` int(10) NOT NULL,
  `gid` int(10) NOT NULL,
  `num` int(10) NOT NULL,
  `money` double NOT NULL,
  PRIMARY KEY (`id`)
) 
