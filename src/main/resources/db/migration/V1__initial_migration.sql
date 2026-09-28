CREATE TABLE users (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       PRIMARY KEY (id)
);

CREATE TABLE addresses (
                           id BIGINT NOT NULL AUTO_INCREMENT,
                           street VARCHAR(255) NOT NULL,
                           city VARCHAR(255),
                           zip VARCHAR(255),
                           user_id BIGINT NOT NULL,
                           PRIMARY KEY (id),
                           FOREIGN KEY (user_id) REFERENCES users(id)
);