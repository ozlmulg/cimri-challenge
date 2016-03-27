    drop table if exists product;

    create table product (
        product_id integer not null auto_increment,
        id integer not null,
        title varchar(255) not null,
        brand varchar(255) not null,
        category varchar(255) not null,
        url varchar(255) not null,
        primary key (product_id)
    );
