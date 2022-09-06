DROP TABLE IF EXISTS purchase_line;
DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS category_translation;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS language;
DROP TABLE IF EXISTS customer;

DROP DATABASE IF EXISTS cyberware;
CREATE DATABASE cyberware;

USE cyberware;

CREATE TABLE customer
(
    identifier              INT AUTO_INCREMENT,
    first_name              VARCHAR(30)  NOT NULL,
    last_name               VARCHAR(30)  NOT NULL,
    username                VARCHAR(50)  NOT NULL,
    phone_number            VARCHAR(20),
    address                 VARCHAR(100) NOT NULL,
    password                VARCHAR(60)  NOT NULL,
    authorities             VARCHAR(30)  NOT NULL,
    account_non_expired     BOOLEAN      NOT NULL,
    account_non_locked      BOOLEAN      NOT NULL,
    credentials_non_expired BOOLEAN      NOT NULL,
    enabled                 BOOLEAN      NOT NULL,

    CONSTRAINT PRIMARY KEY (identifier),
    CONSTRAINT UNIQUE (username),
    CONSTRAINT UNIQUE (phone_number),
    CONSTRAINT CHECK (phone_number REGEXP '^([0-9]{10})$'),
    CONSTRAINT CHECK (username REGEXP '^(\w+@\w+)$')
);

CREATE TABLE language
(
    identifier INT AUTO_INCREMENT,
    name       VARCHAR(30) NOT NULL,
    image_name VARCHAR(30) NOT NULL,

    CONSTRAINT PRIMARY KEY (identifier),
    CONSTRAINT UNIQUE (name)
);

CREATE TABLE category
(
    identifier  INT AUTO_INCREMENT,
    description VARCHAR(400),
    image_name  VARCHAR(30) NOT NULL,

    CONSTRAINT PRIMARY KEY (identifier)
);

CREATE TABLE category_translation
(
    identifier INT,
    name       VARCHAR(30) NOT NULL,
    category   INT         NOT NULL,
    language   INT         NOT NULL,

    CONSTRAINT identifier UNIQUE (category, language),
    CONSTRAINT PRIMARY KEY (identifier),
    CONSTRAINT FOREIGN KEY (category) REFERENCES category (identifier),
    CONSTRAINT FOREIGN KEY (language) REFERENCES language (identifier)
);

CREATE TABLE item
(
    identifier  INT AUTO_INCREMENT,
    name        VARCHAR(30) NOT NULL,
    price       DOUBLE      NOT NULL,
    description VARCHAR(400),
    category    INT         NOT NULL,
    image_name  VARCHAR(30) NOT NULL,

    CONSTRAINT PRIMARY KEY (identifier),
    CONSTRAINT FOREIGN KEY (category) REFERENCES category (identifier)
);

CREATE TABLE purchase
(
    identifier INT AUTO_INCREMENT,
    is_paid    BOOLEAN   NOT NULL,
    date       TIMESTAMP NOT NULL,
    customer   INT       NOT NULL,

    CONSTRAINT PRIMARY KEY (identifier),
    CONSTRAINT FOREIGN KEY (customer) REFERENCES customer (identifier)
);

CREATE TABLE purchase_line
(
    identifier         INT,
    item_price         DOUBLE NOT NULL,
    requested_quantity INT    NOT NULL,
    item               INT    NOT NULL,
    purchase           INT    NOT NULL,

    CONSTRAINT identifier UNIQUE (item, purchase),
    CONSTRAINT PRIMARY KEY (identifier),
    CONSTRAINT FOREIGN KEY (item) REFERENCES item (identifier),
    CONSTRAINT FOREIGN KEY (purchase) REFERENCES purchase (identifier),
    CONSTRAINT CHECK (requested_quantity BETWEEN 1 AND 100)
);