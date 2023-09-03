-- liquibase formatted sql
-- changeset nkorovenkov:02-09-2023-init-db
create table if not exists user
(
    id             bigint auto_increment,
    username       varchar(255) not null,
    network_status boolean      not null,
    rating         double       not null,
    name           varchar(255),
    surname        varchar(255),
    gender         varchar(255) not null default 'NOT_SPECIFIED',
    age            int,
    constraint pk_user primary key (id),
    constraint uq_user_username unique (username)
);

create table if not exists game
(
    id     bigint auto_increment,
    title  varchar(255) not null,
    rating double       not null default 0.0,
    constraint pk_game primary key (id),
    constraint uq_game_title unique (title)
);

create table if not exists `group`
(
    id      bigint auto_increment,
    title   varchar(255) not null,
    game_id bigint       not null,
    constraint pk_group primary key (id),
    constraint uq_group_title unique (title)
);
create table if not exists `genre`
(
    id      bigint auto_increment,
    title   varchar(255) not null,
    constraint pk_genre primary key (id),
    constraint uq_genre_title unique (title)
);

create table if not exists `game_users`
(
    users_id       bigint not null,
    games_id       bigint not null,
    constraint fk_game_users_user
        foreign key (users_id) references user (id),
    constraint fk_game_users_game
        foreign key (games_id) references game (id)
);
create table if not exists `group_users`
(
    groups_id       bigint not null,
    users_id        bigint not null,
    constraint fk_group_users_user
        foreign key (users_id) references user (id),
    constraint fk_group_users_group
        foreign key (groups_id) references `group` (id)
);
create table if not exists `game_genres`
(
    games_id       bigint not null,
    genres_id        bigint not null,
    constraint fk_game_genres_game
        foreign key (games_id) references game (id),
    constraint fk_game_genres_genre
        foreign key (genres_id) references `genre` (id)
);
create table if not exists `user_friends`
(
    user_id       bigint not null,
    friends_id        bigint not null,
    constraint fk_user_friends_user
        foreign key (user_id) references user (id),
    constraint fk_user_friends_friend
        foreign key (friends_id) references user (id)
);
