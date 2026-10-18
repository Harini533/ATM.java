CREATE DATABASE atm_database1S;

USE atm_database1;

CREATE TABLE users (

    card_number VARCHAR(16) PRIMARY KEY,
    pin VARCHAR(4),
    account_holder VARCHAR(50),
    account_type VARCHAR(20),
    balance DECIMAL(10,2)

);

CREATE TABLE transactions (

    id INT AUTO_INCREMENT PRIMARY KEY,
    card_number VARCHAR(16),
    transaction_type VARCHAR(20),
    amount DECIMAL(10,2),
    balance_after DECIMAL(10,2),
    transaction_date DATETIME DEFAULT CURRENT_TIMESTAMP

);

INSERT INTO users
(card_number,pin,account_holder,account_type,balance)
VALUES
('1234567890123456','9228','Harini K','Savings',25000);

CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    card_number VARCHAR(16),
    transaction_type VARCHAR(20),
    amount DECIMAL(10,2),
    balance_after DECIMAL(10,2),
    transaction_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM users;



SHOW TABLES;
