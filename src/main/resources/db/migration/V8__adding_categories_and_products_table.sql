create table Categories
(
    id   tinyint      not null primary key,
    name varchar(255) not null
);

create table products
(
    id          bigint         not null
        primary key,
    name        varchar(255)   not null,
    price       decimal(10, 2) not null,
    category_id tinyint        not null,
    constraint products_categories_id_fk
        foreign key (category_id) references categories (id)
);

