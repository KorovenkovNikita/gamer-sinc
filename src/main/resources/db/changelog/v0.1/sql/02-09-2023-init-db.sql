-- liquibase formatted sql
-- changeset nkorovenkov:02-09-2023-init-db
create table if not exists user
(
    id int auto_increment,
    name varchar(255) not null,
    constraint pk_user primary key (id),
    constraint uq_user_name unique (name)
);