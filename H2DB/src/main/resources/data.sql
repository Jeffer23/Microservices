DROP TABLE IF EXISTS users;
 
CREATE TABLE users (
  user_name VARCHAR(250) PRIMARY KEY,
  password VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS orders;
 
CREATE TABLE orders (
  order_id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  product_id VARCHAR(250) NOT NULL,
  jwt_token VARCHAR(250) NOT NULL,
  transaction_token VARCHAR(250) NOT NULL,
  quantity INT NOT NULL
);
 
INSERT INTO users (user_name, password) VALUES ('jeffer', '123');

