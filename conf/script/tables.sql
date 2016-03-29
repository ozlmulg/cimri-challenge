    drop table if exists product;

    drop table if exists product_price;

    create table product (
        id integer not null,
        title varchar(255) not null UNIQUE,
        brand varchar(255),
        category varchar(255),
        url varchar(255) not null UNIQUE,
        primary key (id)
    );

    create table product_price (
        product_id integer not null,
        price integer not null,
        date date not null,
        primary key (product_id, price, date)
    );
