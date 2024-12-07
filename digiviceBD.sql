-- create database

CREATE DATABASE IF NOT EXISTS digimonDB;
USE digimonDB;

-- create a table
CREATE TABLE IF NOT EXISTS digimon (
  digimon_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  digimon_name VARCHAR(25) NOT NULL,
  first_appearance VARCHAR(45) NOT NULL,
  level VARCHAR(20) NOT NULL,
  type VARCHAR(30) NOT NULL,
  special_attack VARCHAR(55) NOT NULL,
  image_route VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS user(
    user_name VARCHAR(45) PRIMARY KEY NOT NULL,
    user_password VARCHAR(50) NOT NULL
);


INSERT INTO digimon (digimon_name, first_appearance, level, type, special_attack, image_route)
VALUES 
-- Digimon de Taichi
('Koromon', 'Digimon Adventure', 'In Training', 'Data', 'Bubble Blow', 'koromon.jpg'),
('Agumon', 'Digimon Adventure', 'Rookie', 'Vaccine', 'Pepper Breath', 'agumon.jpg'),
('Greymon', 'Digimon Adventure', 'Champion', 'Vaccine', 'Mega Flame', 'greymon.jpg'),

-- Digimon de Yamato
('Tsunomon', 'Digimon Adventure', 'In Training', 'Data', 'Bubble Blow', 'tsunomon.jpg'),
('Gabumon', 'Digimon Adventure', 'Rookie', 'Data', 'Blue Blaster', 'gabumon.jpg'),
('Garurumon', 'Digimon Adventure', 'Champion', 'Data', 'Howling Blaster', 'garurumon.jpg'),

-- Digimon de Sora
('Yokomon', 'Digimon Adventure', 'In Training', 'Data', 'Bubble Blow', 'yokomon.jpg'),
('Biyomon', 'Digimon Adventure', 'Rookie', 'Vaccine', 'Spiral Twister', 'biyomon.jpg'),
('Birdramon', 'Digimon Adventure', 'Champion', 'Vaccine', 'Meteor Wing', 'birdramon.jpg'),

-- Digimon de Koushiro
('Motimon', 'Digimon Adventure', 'In Training', 'Data', 'Bubble Blow', 'motimon.jpg'),
('Tentomon', 'Digimon Adventure', 'Rookie', 'Vaccine', 'Super Shocker', 'tentomon.jpg'),
('Kabuterimon', 'Digimon Adventure', 'Champion', 'Vaccine', 'Electro Shocker', 'kabuterimon.jpg'),

-- Digimon de Mimi
('Tanemon', 'Digimon Adventure', 'In Training', 'Data', 'Bubble Blow', 'tanemon.jpg'),
('Palmon', 'Digimon Adventure', 'Rookie', 'Vaccine', 'Poison Ivy', 'palmon.jpg'),
('Togemon', 'Digimon Adventure', 'Champion', 'Vaccine', 'Needle Spray', 'togemon.jpg'),

-- Digimon de Joe
('Bukamon', 'Digimon Adventure', 'In Training', 'Data', 'Bubble Blow', 'bukamon.jpg'),
('Gomamon', 'Digimon Adventure', 'Rookie', 'Vaccine', 'Marching Fishes', 'gomamon.jpg'),
('Ikkakumon', 'Digimon Adventure', 'Champion', 'Vaccine', 'Harpoon Torpedo', 'ikkakumon.jpg'),

-- Digimon de Takeru
('Tokomon', 'Digimon Adventure', 'In Training', 'Data', 'Bubble Blow', 'tokomon.jpg'),
('Patamon', 'Digimon Adventure', 'Rookie', 'Vaccine', 'Boom Bubble', 'patamon.jpg'),
('Angemon', 'Digimon Adventure', 'Champion', 'Vaccine', 'Hand of Fate', 'angemon.jpg'),

-- Digimon de Hikari
('Nyaromon', 'Digimon Adventure', 'In Training', 'Data', 'Tail Whip', 'nyaromon.jpg'),
('Gatomon', 'Digimon Adventure', 'Rookie', 'Vaccine', 'Cat’s Eye Hypnotism', 'gatomon.jpg'),
('Angewomon', 'Digimon Adventure', 'Champion', 'Vaccine', 'Celestial Arrow', 'angewomon.jpg');

INSERT INTO user(user_name, user_password) VALUES('admin', '1234');
