DROP TABLE IF EXISTS users, pets;

CREATE TABLE users(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256),
    age INT,
    pet_id BIGINT
);

CREATE TABLE pets(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    species VARCHAR(256)
);

ALTER TABLE users add foreign key (pet_id) references pets(id);