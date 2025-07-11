create database travelmanagementsystem;
show databases;
use travelmanagementsystem;

create table account(username varchar(20), name varchar(20) , password varchar(20), security varchar(100), answer varchar(100));
show tables;
select * from account;
create table customer(username varchar(20),Id varchar(20), Number varchar(20),name varchar(20) ,  Gender varchar(10), Country varchar(20), Address varchar(100), Phone varchar(10), Email varchar(20));

drop table customer;
select * from customer;

create table bookpackage(username varchar(20),package varchar(20),persons varchar(20),Id varchar(20), Number varchar(20),Phone varchar(10),price varchar(20));
select * from bookpackage;
create table hotel(name varchar(20),costperperson varchar(20),acroom varchar(10), food varchar(20));
insert into hotel values("Hotel Ideal",'3400','1000','1700');
insert into hotel values("Sayaji Hotel",'2400','1600','1000');
insert into hotel values("Hotel Villa Empire",'4800','1290','2900');
select * from hotel;
create table bookhotel(username varchar(20),name varchar(20),persons varchar(10),days varchar(10),ac varchar(10),food varchar(10),Id varchar(20), Number varchar(20),Phone varchar(10),price varchar(20));
select * from bookhotel;
commit;
