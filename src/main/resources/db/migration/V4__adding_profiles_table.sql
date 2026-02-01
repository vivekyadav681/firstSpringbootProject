create table profiles
(
    id             bigint       not null
        primary key,
    bio            varchar(255) not null,
    phone_number   bigint       not null,
    date_of_birth  varchar(255) not null,
    loyalty_points int          not null,
    constraint profiles_users_id_fk
        foreign key (id) references users (id)
);