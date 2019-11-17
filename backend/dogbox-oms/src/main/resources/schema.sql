CREATE DATABASE IF NOT EXISTS dogbox_oms;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS allergies;
CREATE TABLE allergies (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS attributes;
CREATE TABLE attributes (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS behavioural_problems;
CREATE TABLE behavioural_problems (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS brands;
CREATE TABLE brands (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS EVENTS;
CREATE TABLE EVENTS (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS flavours;
CREATE TABLE flavours (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS health_issues;
CREATE TABLE health_issues (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS ingredients;
CREATE TABLE ingredients (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS product_types;
CREATE TABLE product_types (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS sizes;
CREATE TABLE sizes (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS suppliers;
CREATE TABLE suppliers (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS toy_types;
CREATE TABLE toy_types (
    id     INT            NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(50)    NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS products;
CREATE TABLE products (
    id                  INT            NOT NULL AUTO_INCREMENT,
    NAME                VARCHAR(100)   NOT NULL,
    brand               VARCHAR(100)   NOT NULL,
    weight              VARCHAR(100)   NOT NULL,
    sku                 VARCHAR(100)   NOT NULL,
    size_id             INT            NOT NULL,
    flavour_id          INT            NOT NULL,
    product_type_id     INT            NOT NULL,
    financial_info_id   INT            NOT NULL,
    nutritional_info_id INT            NOT NULL,
    suitability_info_id INT            NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_products_size FOREIGN KEY (size_id) REFERENCES sizes (id),
    CONSTRAINT fk_products_flavour FOREIGN KEY (flavour_id) REFERENCES flavours (id),
    CONSTRAINT fk_products_product_type FOREIGN KEY (product_type_id) REFERENCES product_types (id),
    CONSTRAINT fk_products_financial_info FOREIGN KEY (financial_info_id) REFERENCES financial_information (id),
    CONSTRAINT fk_products_nutritional_info FOREIGN KEY (nutritional_info_id) REFERENCES nutritional_information (id),
    CONSTRAINT fk_products_suitability_info FOREIGN KEY (suitability_info_id) REFERENCES suitability_information (id)
);

DROP TABLE IF EXISTS financial_information;
CREATE TABLE financial_information (
    id                  INT            NOT NULL AUTO_INCREMENT,
    is_vat_used         TINYINT(1)     NOT NULL,
    rrp                 VARCHAR(1000)  NOT NULL,
    profit              VARCHAR(20)    NOT NULL,
    purchase_price      VARCHAR(20)    NOT NULL,
    vat_value           VARCHAR(20)    NOT NULL,
    vat_refund          VARCHAR(20)    NOT NULL,
    vat_adjusted_cogs   VARCHAR(20)    NOT NULL,
    product_id          INT            NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_financial_info_product FOREIGN KEY (product_id) REFERENCES products (id)
);

DROP TABLE IF EXISTS nutritional_information;
CREATE TABLE nutritional_information (
    id                  INT           NOT NULL AUTO_INCREMENT,
    kcal_per_hundred    VARCHAR(1000) NOT NULL,
    percentage_meat     VARCHAR(100)  NOT NULL,
    percentage_protein  VARCHAR(100)  NOT NULL,
    percentage_fat      VARCHAR(100)  NOT NULL,
    percentage_carbs    VARCHAR(100)  NOT NULL,
    product_id          INT           NOT NULL,
    ingredient_id       INT           NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_nutritional_info_product FOREIGN KEY (product_id) REFERENCES products (id),
    CONSTRAINT fk_nutritional_info_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredients (id)
);

DROP TABLE IF EXISTS suitability_information;
CREATE TABLE suitability_information (
    id              INT         NOT NULL AUTO_INCREMENT,
    age             VARCHAR(35) NOT NULL,
    size_id         INT         NOT NULL,
    supplier_id     INT         NOT NULL,
    product_id      INT         NOT NULL,
    attribute_id    INT         NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_suitability_info_size FOREIGN KEY (size_id) REFERENCES sizes (id),
    CONSTRAINT fk_suitability_info_product FOREIGN KEY (product_id) REFERENCES products (id)
);

DROP TABLE IF EXISTS breeds;
CREATE TABLE breeds (
    id     INT             NOT NULL AUTO_INCREMENT,
    NAME   VARCHAR(100)    NOT NULL,
    size_id INT            NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_breeds_size FOREIGN KEY (size_id) REFERENCES sizes (id)
);

DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
    id              INT             NOT NULL AUTO_INCREMENT,
    creation_date   TIMESTAMP       NOT NULL,
    NAME            VARCHAR(100)    NOT NULL,
    phone_number    VARCHAR(12)     NOT NULL,
    house_name      VARCHAR(20)     NOT NULL,
    addr_line1      VARCHAR(35)     NOT NULL,
    addr_line2      VARCHAR(35)     NOT NULL,
    addr_line3      VARCHAR(35)     NOT NULL,
    post_code       VARCHAR(20)     NOT NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs (
    id                      INT           NOT NULL AUTO_INCREMENT,
    age                     VARCHAR(10)   NOT NULL,
    limitCalories           INT           NOT NULL,
    NAME                    VARCHAR(45)   NOT NULL,
    breed_id                INT    	      NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_dogs_breed FOREIGN KEY (breed_id) REFERENCES breeds (id)
);

DROP TABLE IF EXISTS dogs_allergies;
CREATE TABLE dogs_allergies (
    dog_id       INT     NOT NULL,
    allergy_id   INT     NOT NULL,

    PRIMARY KEY(dog_id, allergy_id),
    CONSTRAINT fk_dogs_allergies_dog FOREIGN KEY (dog_id)
        REFERENCES dogs (id),
    CONSTRAINT fk_dogs_allergies_allergy FOREIGN KEY (allergy_id)
        REFERENCES allergies (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS dogs_behavioural_problems;
CREATE TABLE dogs_behavioural_problems (
    dog_id                  INT     NOT NULL,
    behaviour_problem_id    INT     NOT NULL,

    PRIMARY KEY(dog_id, behaviour_problem_id),
    CONSTRAINT fk_dogs_behavioural_problems_dog FOREIGN KEY (dog_id)
        REFERENCES dogs (id),
    CONSTRAINT fk_dogs_behavioural_problems_behaviour_problem FOREIGN KEY (behaviour_problem_id)
        REFERENCES behavioural_problems (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS dogs_health_issues;
CREATE TABLE dogs_health_issues (
    dog_id             INT     NOT NULL,
    health_issue_id    INT     NOT NULL,

    PRIMARY KEY(dog_id, health_issue_id),
    CONSTRAINT fk_dogs_health_issues_dog FOREIGN KEY (dog_id)
        REFERENCES dogs (id),
    CONSTRAINT fk_dogs_health_issues_health_issue FOREIGN KEY (health_issue_id)
        REFERENCES health_issues (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS dogs_toy_types;
CREATE TABLE dogs_toy_types (
    dog_id         INT     NOT NULL,
    toy_type_id    INT     NOT NULL,

    PRIMARY KEY(dog_id, toy_type_id),
    CONSTRAINT fk_dogs_toy_types_dog FOREIGN KEY (dog_id)
        REFERENCES dogs (id),
    CONSTRAINT fk_dogs_toy_types_toy_type FOREIGN KEY (toy_type_id)
        REFERENCES toy_types (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS products_ingredients;
CREATE TABLE products_ingredients (
    product_id       INT     NOT NULL,
    ingredient_id    INT     NOT NULL,

    PRIMARY KEY(product_id, ingredient_id),
    CONSTRAINT fk_customers_dogs_product FOREIGN KEY (product_id) REFERENCES products (id),
    CONSTRAINT fk_customers_dogs_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredients (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS customers_dogs;
CREATE TABLE customers_dogs (
    dog_id       INT     NOT NULL,
    customer_id    INT     NOT NULL,

    PRIMARY KEY(dog_id, customer_id),
    CONSTRAINT fk_customers_dogs_dog FOREIGN KEY (dog_id) REFERENCES dogs (id),
    CONSTRAINT fk_customers_dogs_customer FOREIGN KEY (customer_id) REFERENCES customers (id) ON UPDATE CASCADE ON DELETE CASCADE
);

--    DROP TABLE IF EXISTS customers_orders;
--    CREATE TABLE customers_orders (
--        order_id       INT     NOT NULL,
--        customer_id    INT     NOT NULL,
--
--        PRIMARY KEY(orderId, customer_id),
--        CONSTRAINT fk_customers_orders_order FOREIGN KEY (order_id) REFERENCES order (id),
--        CONSTRAINT fk_customers_orders_customer FOREIGN KEY (customer_id) REFERENCES author (id) ON UPDATE CASCADE ON DELETE CASCADE
--    );
SET FOREIGN_KEY_CHECKS=1;
COMMIT;