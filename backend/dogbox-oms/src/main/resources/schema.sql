CREATE DATABASE IF NOT EXISTS dogboxoms;

DROP TABLE IF EXISTS note, author, note_author;

CREATE TABLE breeds (
    id      INT             NOT NULL PRIMARY KEY,
    title   VARCHAR(100)    NOT NULL
);

CREATE TABLE note (
    id              INT             NOT NULL PRIMARY KEY,
    title           VARCHAR(20)     NOT NULL,
    description     VARCHAR(100)    NOT NULL,
    creation_date    TIMESTAMP       NOT NULL
);

CREATE TABLE CUSTOMERORDERS ();

CREATE TABLE customers_orders (
    order_id       INT     NOT NULL,
    customer_id    INT     NOT NULL,

    PRIMARY KEY(orderId, author_id),
    CONSTRAINT fk_note_author_note FOREIGN KEY (note_id) REFERENCES note (id),
    CONSTRAINT fk_note_author_author FOREIGN KEY (author_id) REFERENCES author (id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE customer (
    id              INT             NOT NULL PRIMARY KEY,
    title           VARCHAR(20)     NOT NULL,
    description     VARCHAR(100)    NOT NULL,
    creation_date    TIMESTAMP       NOT NULL

    --customerName
--    phoneNumber
--    houseName
--    streetName
--    postCode
--
--    dogsCount
--
--    dogNames
--
--    limitDogCalories
--    dogAge
--
--    breed
--
--    allergies
--    healthIssues
--    behaviouralProblems
--    blacklistIngredients
--    toysTypes
);
