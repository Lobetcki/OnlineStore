-- liquibase formatted sql


-- changeset jalig:2
create table category
(
    id   BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(255)
);

-- changeset anton:2.1:insertSQLChangeType
INSERT  INTO  store.public.category  (name)  VALUES  ('Gan');
INSERT  INTO  store.public.category  (name)  VALUES  ('Car');
INSERT  INTO  store.public.category  (name)  VALUES  ('Tou');

