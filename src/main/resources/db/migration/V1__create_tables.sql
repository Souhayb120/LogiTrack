
CREATE TABLE client (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(255),
                        email VARCHAR(255),
                        tel VARCHAR(20)
);

CREATE TABLE produit (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nom VARCHAR(255),
                         categorie VARCHAR(255),
                         prix DOUBLE,
                         quantite_stock INT
);

CREATE TABLE commande (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          date DATE,
                          status VARCHAR(50),
                          client_id INT
);

CREATE TABLE ligne_commande (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                quantite INT,
                                produit_id INT,
                                commande_id INT
);


CREATE TABLE user_entity (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             user_name VARCHAR(255) NOT NULL,
                             email VARCHAR(255) NOT NULL UNIQUE,
                             password VARCHAR(255) NOT NULL,
                             role VARCHAR(50) NOT NULL
);

CREATE TABLE admin (
                       id INT PRIMARY KEY
);

CREATE TABLE manager (
                         id INT PRIMARY KEY
);

CREATE TABLE agent (
                         id INT PRIMARY KEY
);