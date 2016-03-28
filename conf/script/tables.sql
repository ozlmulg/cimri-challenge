    drop table if exists product;

    create table product (
        id integer not null,
        title varchar(255) not null UNIQUE,
        brand varchar(255) not null,
        category varchar(255) not null,
        url varchar(255) not null UNIQUE,
        primary key (id)
    );
