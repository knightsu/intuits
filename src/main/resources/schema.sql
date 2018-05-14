create table seller (
  seller_id int(11) auto_increment primary key,
  seller_name varchar(255));

create table buyers (
  buyer_id int(11)  auto_increment primary key,
  buyer_name varchar(255));

create table bid (
  bid_id int(11) auto_increment primary key ,
  proj_id int(11) not null,
  buyer_id int(11) not null,
  bid_price double not null);

create table project (
  proj_id int(11) auto_increment primary key,
  detail varchar(255),
  max_budget double,
  deadline Date,
  win_price double);