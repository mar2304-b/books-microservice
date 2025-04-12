CREATE DATABASE IF NOT EXISTS booksdb;
USE booksdb;

CREATE TABLE IF NOT EXISTS books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    author VARCHAR(100) NOT NULL,
    pages INT
);

INSERT INTO books (name, author, pages) VALUES
('To Kill a Mockingbird', 'Harper Lee', 281),
('1984', 'George Orwell', 328),
('The Great Gatsby', 'F. Scott Fitzgerald', 180),
('Pride and Prejudice', 'Jane Austen', 279),
('Moby Dick', 'Herman Melville', 635);