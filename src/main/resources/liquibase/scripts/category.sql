-- liquibase formatted sql


-- changeset jalig:2
create table category
(
    id   BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(255)
);


