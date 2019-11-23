drop database if exists `dbserver`;
create database `dbserver` default character set utf8;

use `dbserver`;

drop table if exists `value`;
create table `value`
(
    `id`          int primary key,
    `name`        text default null,
    `explanation` text default null
);

insert into `value`(`id`, `name`, `explanation`)
values (1, '追求极致', 'Aim for the highest');

insert into `value`(`id`, `name`, `explanation`)
values (2, '不设边界', 'No boundaries');

insert into `value`(`id`, `name`, `explanation`)
values (3, 'talk is cheap show me the code', 'talk is cheap show me the code');



drop table if exists `user`;
create table `user`
(
    `id`       int primary key,
    `username` text not null,
    `password` text not null,
    `role`     text default null
);

insert into `user`(`id`, `username`, `password`, `role`)
values (1, 'root', '63a9f0ea7bb98050796b649e85481845', 'root');