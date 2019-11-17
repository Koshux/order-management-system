USE dogbox_oms;

INSERT INTO sizes (NAME)
VALUES
('XS'),
('S'),
('M'),
('L'),
('XL');

INSERT INTO breeds (NAME, SIZE_ID)
VALUES
('Alsation', 5),
('Yorkshire Terrier', 2),
('Golden Retriever', 4);

INSERT INTO dogs (AGE, LIMITCALORIES, NAME, BREED_ID)
VALUES
('Adult', 1500, 'Jimbo', 1),
('Puppy', 2200, 'Sherry', 3),
('Mid-age', 1900, 'Fasco', 2);

INSERT INTO customers (CREATION_DATE, NAME, PHONE_NUMBER, HOUSE_NAME, ADDR_LINE_1, ADDR_LINE_2, ADDR_LINE_3, POST_CODE)
VALUES
('2019-08-18 20:59:59', 'Chris', '+35699112233', 'Friggieri', 'Triq Sannat', 'Kristu Rxoxt', 'Terapija', 'SNT1553');

INSERT INTO customers_dogs (DOG_ID, CUSTOMER_ID)
VALUES
(1, 1),
(2, 1);

INSERT INTO allergies
VALUES
(1, 'Beef'),
(2, 'Dairy'),
(999, 'None');

INSERT INTO behavioural_problems
VALUES
(1, 'Barking'),
(999, 'None');

INSERT INTO health_issues
VALUES
(1, 'Flees'),
(999, 'None');

INSERT INTO toy_types
VALUES
(1, 'Chicken Bone'),
(1, 'Squeezy Ball'),
(999, 'None');

INSERT INTO dogs_information
VALUES
(1, 1, 1, 1, 1),
(1, 2, 2, 999, 999);

