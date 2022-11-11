CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS users
(
    id       BIGSERIAL NOT NULL,
    username VARCHAR(255),
    password VARCHAR(255),
    email    VARCHAR(255),
    number   VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS category
(
    id          BIGSERIAL NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cook
(
    id             BIGSERIAL NOT NULL,
    name           VARCHAR(255),
    specialization VARCHAR(255),
    CONSTRAINT pk_cook PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS booking_table
(
    id           BIGSERIAL NOT NULL,
    user_id      BIGINT,
    date         date,
    time         TIME WITHOUT TIME ZONE,
    people_count INTEGER   NOT NULL,
    CONSTRAINT pk_booking_table PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS dish
(
    id          BIGSERIAL NOT NULL,
    title       VARCHAR(255),
    price       INTEGER   NOT NULL,
    category_id BIGINT,
    cook_id     BIGINT,
    CONSTRAINT pk_dish PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS dish_in_order
(
    id         BIGSERIAL NOT NULL,
    dish_id    BIGINT,
    order_id   BIGINT,
    dish_count INTEGER   NOT NULL,
    CONSTRAINT pk_dish_in_order PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS orders
(
    id      BIGSERIAL NOT NULL,
    user_id BIGINT,
    address VARCHAR(255),
    CONSTRAINT pk_orders PRIMARY KEY (id)
);




