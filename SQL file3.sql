create database travelmanagementsystem;
show databases;
use travelmanagementsystem;

create table account(username varchar(20), name varchar(20) , password varchar(20), security varchar(100), answer varchar(100));
show tables;
select * from account;
create table customer(Username varchar(20), Id varchar(20), Number varchar(20), Name varchar(20), Gender varchar(10), Country varchar(20), Address varchar(100), Phone varchar(10), Email varchar(20));
select * from customer;
insert into customer values("par","aadhar","77","patel raghu","Male","india","vadodara,gujarat","1122334455","raghupat@gmail.com");
commit;
