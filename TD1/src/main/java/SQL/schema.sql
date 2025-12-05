CREATE TABLE Product (
    id INT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    creation_datetime TIMESTAMP NOT NULL
);

CREATE TABLE Product_category (
    id INT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Product(id)
);