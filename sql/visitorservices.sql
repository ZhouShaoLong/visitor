--用户表
CREATE TABLE User (
  id int(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255)  NULL,
  email VARCHAR(255)  NOT NULL,
  password VARCHAR(255)  NOT NULL,
  birthday DATE,
  phone VARCHAR(255),
  address VARCHAR(255),
  qq VARCHAR(255),
  PRIMARY KEY (id)
) ENGINE=MyISAM AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8;

--投诉
CREATE TABLE Complaint(
id int(20) NOT NULL AUTO_INCREMENT,
title varchar(255),
userId int(11),
content text,
handleStatus int NOT NULL,
checkStatus int NOT NULL,
star int,
judge text,
PRIMARY KEY (id)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--修改投诉 增加提交时间、处理时间、审核时间
alter table Complaint add settime date;
alter table Complaint add handletime date;
alter table Complaint add checktime date;
alter table Complaint add reply text;

--演出表
CREATE TABLE performance(
performance_id int(20) NOT NULL AUTO_INCREMENT,
title VARCHAR(255) NOT NULL ,
type INT NOT  NULL ,
groupname VARCHAR(255) NOT NULL ,
starttime DATE NOT NULL ,
endtime DATE NOT NULL ,
intro text,
price NUMERIC(10,2) NOT NULL,
PRIMARY KEY (performance_id)
)DEFAULT CHARSET=utf8;

--演出表修改
alter table performance drop type;
alter table performance add type VARCHAR(50);

--管理员表
CREATE TABLE Admin(
  admin_id INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(50) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  name VARCHAR(255) NOT NULL ,
  PRIMARY KEY (admin_id)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--发布信息表
CREATE TABLE Notice(
  notice_id INT(20) NOT NULL AUTO_INCREMENT,
  starttime DATE NOT NULL ,
  content TEXT NOT NULL ,
  admin_id INT(11) NOT NULL ,
  title TEXT NOT NULL ,
  endtime DATE,
  PRIMARY KEY (notice_id),
  FOREIGN KEY (admin_id) REFERENCES Admin(admin_id)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--酒店表
CREATE TABLE Hotel(
  hotel_id INT(20) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL ,
  address VARCHAR(255) NOT NULL ,
  longitude VARCHAR(30) NOT NULL ,
  latitude VARCHAR(30) NOT NULL ,
  star INT NOT NULL ,
  picture VARCHAR(255) NOT NULL ,
  PRIMARY KEY (hotel_id)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--房间表修改，增加联系电话、最低价、城市
alter table Hotel add phone VARCHAR(30);
alter table Hotel add minPrice numeric(10,2);
alter table Hotel add city VARCHAR(50);

--房间表
CREATE TABLE Room(
  room_num VARCHAR(255) NOT NULL ,
  hotel_id INT(20) NOT NULL ,
  type INT NOT NULL ,
  price NUMERIC(10,2) NOT NULL ,
  picture VARCHAR(255) NOT NULL ,
  orderstatus INT NOT NULL ,
  starttime DATE,
  endtime DATE,
  PRIMARY KEY (hotel_id,room_num),
  FOREIGN KEY (hotel_id) REFERENCES Hotel(hotel_id)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--附件表
CREATE TABLE attachment(
complaint_id int(20) NOT NULL ,
filename varchar(255) NOT NULL ,
type int NOT NULL ,
PRIMARY KEY (filename),
FOREIGN KEY (complaint_id) REFERENCES Complaint(id)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;