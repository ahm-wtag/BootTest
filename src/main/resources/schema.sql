drop table if exists employee;

create table employee (
  id int auto_increment primary key ,
  name varchar(50) not null,
  email varchar(50) not null ,
  password  varchar(50) not null
);

