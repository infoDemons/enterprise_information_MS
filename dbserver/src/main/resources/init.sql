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
values (3, 'talk is cheap', 'show me the code');



drop table if exists `enterprise`;
create table `enterprise`
(
    `enterprise_id`                    int primary key,
    `unified_social_credit_identifier` text,
    `enterprise_name`                  text,
    `registered_capital`               text,
    `paid_in_capital`                  text,
    `business_scope`                   text,
    `legal_representative`             text,
    `industry`                         text,
    `telephone_number`                 text,
    `email`                            text,
    `registered_address`               text,
    `form_of_business_enterprise`      text,
    `business_registration_number`     text,
    `registration_authority`           text,
    `business_status`                  text
);


drop table if exists `enterprise_information_change`;
create table `enterprise_information_change`
(
    `enterprise_id`           int,
    `enterprise_name`         text,
    `information_change_date` text,
    `information_change_type` text,
    `information_before`      text,
    `information_after`       text,
    `create_date`             text,
    foreign key (`enterprise_id`) references `enterprise` (`enterprise_id`)
);


drop table if exists `trademark`;
create table `trademark`
(
    `enterprise_id`       int,
    `applicant`           text,
    `trademark_address`   text,
    `trademark_name`      text,
    `registration_number` text,
    `classification`      text,
    `trademark_status`    text,
    `trademark_process`   text,
    foreign key (`enterprise_id`) references `enterprise` (`enterprise_id`)
);

drop table if exists `enterprise_main_staff`;
create table `enterprise_main_staff`
(
    `enterprise_id`            int,
    `enterprise_name`          text,
    `staff_name`               text,
    `owning_enterprise_number` int,
    `position`                 text,
    foreign key (`enterprise_id`) references `enterprise` (`enterprise_id`)
);



load data infile '/Users/albert/DB/project/dataset/企业基础信息.csv'
    into table dbserver.enterprise
    fields terminated by ','
    enclosed by '"'
    lines terminated by '\r\n' ignore 1 lines;


load data infile '/Users/albert/DB/project/dataset/企业变更信息.csv'
    into table dbserver.enterprise_information_change
    fields terminated by ','
    enclosed by '"'
    lines terminated by '\r\n' ignore 1 lines;


load data infile '/Users/albert/DB/project/dataset/商标注册信息_更新.csv'
    into table dbserver.trademark
    fields terminated by ','
    enclosed by '"'
    lines terminated by '\r\n' ignore 1 lines;


load data infile '/Users/albert/DB/project/dataset/主要人员信息.csv'
    into table dbserver.enterprise_main_staff
    fields terminated by ','
    enclosed by '"'
    lines terminated by '\r\n' ignore 1 lines;


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