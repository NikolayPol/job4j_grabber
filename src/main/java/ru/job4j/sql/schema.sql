create table post(
    id serial primary key,
    name varchar(255),
    link text unique,
    text text,
    created timestamp
);