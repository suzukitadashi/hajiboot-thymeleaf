CREATE TABLE users (userid VARCHAR(100) NOT NULL PRIMARY KEY, encoded_password VARCHAR(255), username varchar(100));
INSERT INTO users (userid, encoded_password, username) VALUES ('user1', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/, 'TEST1');
INSERT INTO users (userid, encoded_password, username) VALUES ('user2', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/, 'TEST2');

CREATE TABLE customers (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(30), last_name VARCHAR(30),userid VARCHAR(100) NOT NULL DEFAULT 'user1');
ALTER TABLE customers ADD CONSTRAINT FK_CUSTOMERS_USERNAME FOREIGN KEY (userid) REFERENCES users;
INSERT INTO customers(first_name, last_name, userid) VALUES('Nobita','Nobi', 'user1');
INSERT INTO customers(first_name, last_name, userid) VALUES('Takeshi','Goda', 'user1');
INSERT INTO customers(first_name, last_name, userid) VALUES('Suneo','Honekawa', 'user1');
INSERT INTO customers(first_name, last_name, userid) VALUES('Shizuka','Minamoto', 'user1');