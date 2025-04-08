CREATE TABLE storedb.products (
    id IDENTITY PRIMARY KEY,
    sku VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE storedb.specialoffers (
    id IDENTITY PRIMARY KEY,
    sku VARCHAR(10) NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    spec_desc VARCHAR(100),
    spec_price DECIMAL(10, 2),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('A', 'GameBox', 50, 'TechGreat Latest Game Console');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('B', 'Kid Tennis Rack', 30, 'Wilson Tennis Rack for Kid');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('C', 'Banana Cake', 20, 'Ripe and tasty banana cake');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('D', 'Yogurt', 4, 'Creamy and delicious yogurt');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('E', 'Chive', 0.49, 'Fresh chives for seasoning');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('F', 'Steak', 12.99, 'skuTender and juicy steak');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('G', 'Cheese', 3.49, 'Cheddar cheese, aged for flavor');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('H', 'Bread', 1.99, 'Freshly baked whole grain bread');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('I', 'Butter', 2.79, 'Rich and creamy butter');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('J', 'Eggs', 2.99, 'Farm-fresh eggs');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('K', 'Chicken', 8.99, 'Organic chicken pieces');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('L', 'Milk', 2.49, 'Fresh whole milk');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('M', 'Fish', 10.49, 'Fresh salmon fillets');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('N', 'Rice', 1.49, 'Basmati rice, long grain');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('O', 'Drum Set', 100, 'Drum Set');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('P', 'Plant', 6, 'Outdoor Plant');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('Q', 'Potato', 0.39, 'Fresh organic potatoes');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('R', 'Carrot', 0.59, 'Crisp and sweet carrots');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('S', 'Cucumber', 0.49, 'Fresh and crunchy cucumbers');
INSERT INTO storedb.PRODUCTS (sku, name, price, description) VALUES ('T', 'Ice Cream', 3.99, 'Rich and creamy vanilla ice cream');


insert into storedb.specialoffers (sku, product_id, quantity, spec_desc, spec_price) values ('A', 1, 3, 'Buy 3 for ¢G130', 130);
insert into storedb.specialoffers (sku, product_id, quantity, spec_desc, spec_price) values ('B', 2, 2, 'Buy 2 for ¢G45', 45);
insert into storedb.specialoffers (sku, product_id, quantity, spec_desc, spec_price) values ('H', 8, 4, 'Buy 4 for ¢G9.5', 9.5);
insert into storedb.specialoffers (sku, product_id, quantity, spec_desc, spec_price) values ('N', 14, 3, 'Buy 3 for ¢G3', 3);
insert into storedb.specialoffers (sku, product_id, quantity, spec_desc, spec_price) values ('P', 16, 3, 'Buy 3 for ¢G15', 15);
insert into storedb.specialoffers (sku, product_id, quantity, spec_desc, spec_price) values ('Q', 17, 10, 'Buy 10 for ¢G2.5', 2.5);
insert into storedb.specialoffers (sku, product_id, quantity, spec_desc, spec_price) values ('R', 18, 4, 'Buy 4 for ¢G2', 2);
insert into storedb.specialoffers (sku, product_id, quantity, spec_desc, spec_price) values ('T', 20, 3, 'Buy 3 for ¢G9', 9);