alter table categories
    modify id tinyint not null auto_increment;

alter table products
    modify id bigint not null auto_increment;
