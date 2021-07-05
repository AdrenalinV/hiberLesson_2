CREATE SCHEMA IF NOT EXISTS homework;
/*Удаляем таблицы*/
DROP TABLE IF EXISTS homework.orders;
DROP TABLE IF EXISTS homework.products;
DROP TABLE IF EXISTS homework.buyers;
/* Создаем таблицу продуктов */
CREATE TABLE homework.products (id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
title VARCHAR(255),
cost FLOAT NOT NULL);
INSERT INTO homework.products (title, cost) VALUES
('Product_1',125.23),
('Product_2',256.32),
('Product_3',1258.23),
('Product_4',125.36),
('Product_5',256.52);
/*Создаем таблицу покупателей */
CREATE TABLE homework.buyers (id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR(255));
INSERT INTO homework.buyers (name) VALUES
('Buyer_1'),
('Buyer_2'),
('Buyer_3'),
('Buyer_4'),
('Buyer_5');
/* Создаем таблицу покупок */
CREATE TABLE homework.orders (product_id INTEGER REFERENCES homework.products (id),
buyer_id INTEGER REFERENCES homework.buyers (id));
INSERT INTO homework.orders (product_id,buyer_id) VALUES
(1,3),
(2,3),
(4,3),
(1,1),
(2,1),
(3,1),
(4,2),
(5,4),
(2,5);
COMMIT;