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
    `business_status`                  text,
    `popularity`                       int default 0
);

create index `enterprise_index` on `enterprise` (`enterprise_name`(100), `industry`(100), `popularity`);
create index `popularity_index` on `enterprise` (`popularity`);


drop table if exists `enterprise_information_change`;
create table `enterprise_information_change`
(
    `enterprise_information_change_id` int primary key not null auto_increment,
    `enterprise_id`                    int,
    `enterprise_name`                  text,
    `information_change_date`          text,
    `information_change_type`          text,
    `information_before`               text,
    `information_after`                text,
    `create_date`                      text,
    foreign key (`enterprise_id`) references `enterprise` (`enterprise_id`) on delete cascade
);


drop table if exists `trademark`;
create table `trademark`
(
    `trademark_id`        int primary key not null auto_increment,
    `enterprise_id`       int,
    `applicant`           text,
    `trademark_address`   text,
    `trademark_name`      text,
    `registration_number` text,
    `classification`      text,
    `trademark_status`    text,
    `trademark_process`   text,
    foreign key (`enterprise_id`) references `enterprise` (`enterprise_id`) on delete cascade
);

drop table if exists `enterprise_main_staff`;
create table `enterprise_main_staff`
(
    `staff_id`                 int primary key not null auto_increment,
    `enterprise_id`            int,
    `enterprise_name`          text,
    `staff_name`               text,
    `owning_enterprise_number` int,
    `position`                 text,
    foreign key (`enterprise_id`) references `enterprise` (`enterprise_id`) on delete cascade
);



load data infile '/Users/albert/DB/project/dataset/企业基础信息.csv'
    into table dbserver.enterprise
    fields terminated by ','
    enclosed by '"'
    lines terminated by '\r\n' ignore 1 lines
    (`enterprise_id`,
     `unified_social_credit_identifier`,
     `enterprise_name`,
     `registered_capital`,
     `paid_in_capital`,
     `business_scope`,
     `legal_representative`,
     `industry`,
     `telephone_number`,
     `email`,
     `registered_address`,
     `form_of_business_enterprise`,
     `business_registration_number`,
     `registration_authority`,
     `business_status`);


load data infile '/Users/albert/DB/project/dataset/企业变更信息.csv'
    into table dbserver.enterprise_information_change
    fields terminated by ','
    enclosed by '"'
    lines terminated by '\r\n' ignore 1 lines
    (`enterprise_id`,
     `enterprise_name`,
     `information_change_date`,
     `information_change_type`,
     `information_before`,
     `information_after`,
     `create_date`);


load data infile '/Users/albert/DB/project/dataset/商标注册信息_更新.csv'
    into table dbserver.trademark
    fields terminated by ','
    enclosed by '"'
    lines terminated by '\r\n' ignore 1 lines
    (`enterprise_id`,
     `applicant`,
     `trademark_address`,
     `trademark_name`,
     `registration_number`,
     `classification`,
     `trademark_status`,
     `trademark_process`);


load data infile '/Users/albert/DB/project/dataset/主要人员信息.csv'
    into table dbserver.enterprise_main_staff
    fields terminated by ','
    enclosed by '"'
    lines terminated by '\r\n' ignore 1 lines
    (`enterprise_id`,
     `enterprise_name`,
     `staff_name`,
     `owning_enterprise_number`,
     `position`);


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


create trigger refresh_enterprise_name_trigger
    after update
    on `enterprise`
    for each row
begin
    update enterprise_main_staff
    set enterprise_name = new.enterprise_name
    where enterprise_id = new.enterprise_id;

    update enterprise_information_change
    set enterprise_name = new.enterprise_name
    where enterprise_id = new.enterprise_id;
end;