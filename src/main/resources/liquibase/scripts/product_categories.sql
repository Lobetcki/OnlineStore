-- liquibase formatted sql


-- changeset jalig:3
create table product_categories
(
    categories_id bigint NOT NULL REFERENCES category(id),
    products_id   bigint NOT NULL REFERENCES product(id),
    PRIMARY KEY (products_id, categories_id)
);
