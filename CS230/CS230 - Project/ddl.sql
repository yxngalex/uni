drop table if exists firm;

drop table if exists job;

drop table if exists role;

drop table if exists user;

drop table if exists user_job;

create table firm
(
   firm_id int not null auto_increment primary key,
   name                 varchar(255),
   address              varchar(255)
);

create table job
(
   job_id int not null auto_increment primary key,
   firm_id              int not null,
   name                 varchar(255),
   description          varchar(255),
   constraint fk_firm_job foreign key (firm_id)
      references firm (firm_id) on delete restrict on update restrict
);

create table role
(
   role_id int not null auto_increment primary key
   role                 varchar(255)
);

create table user
(
   username             varchar(255),
   password             varchar(255),
   email                varchar(255),
   user_id int not null auto_increment primary key,
   role_id              int not null,
   constraint fk_relationship_3 foreign key (role_id)
      references role (role_id) on delete restrict on update restrict
);

create table user_job
(
   user_job_id int not null auto_increment primary key
   user_id              int not null,
   job_id               int not null,
   constraint fk_user_job foreign key (user_id)
      references user (user_id) on delete restrict on update restrict,
   constraint fk_user_job2 foreign key (job_id)
      references job (job_id) on delete restrict on update restrict
);

