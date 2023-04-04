-- liquibase formatted sql


-- changeset jalig:1
create table product
(
    id                BIGSERIAL NOT NULL PRIMARY KEY,
    creation_date     TIMESTAMP,
    description       VARCHAR(255),
    modification_date TIMESTAMP,
    name              VARCHAR(255)
);


