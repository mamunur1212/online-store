create table categories (
    id TINYINT AUTO_INCREMENT primary key,
    name varchar(255) not null
);

create table products (
    id BIGINT AUTO_INCREMENT primary key,
    name varchar(255) not null,
    price decimal(10,2) not null,
    category_id TINYINT not null,
    foreign key (category_id) references categories(id) ON DELETE RESTRICT
);