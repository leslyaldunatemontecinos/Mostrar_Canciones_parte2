CREATE DATABASE canciones_db;

USE canciones_db;

CREATE TABLE canciones(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    artista VARCHAR(255),
    album VARCHAR(255),
	genero VARCHAR(255),
	idioma VARCHAR(255),
	created_at DATETIME,
    updated_at DATETIME );
    
INSERT INTO canciones (titulo, artista, album, genero, idioma, created_at)
VALUES ('Bohemian Rhapsody', 'Queen', 'A Night at the Opera', 'Rock', 'Ingles', NOW()),
	   ('Imagine', 'John Lennon', 'Imagine', 'Pop', 'Ingles', NOW()),
       ('Hotel California', 'Eagles', 'Hotel California', 'Rock', 'Ingles', NOW());

USE canciones_db;
SELECT * FROM artistas;
INSERT INTO artistas (nombre,apellido,biografia, created_at, updated_at)
VALUES 	('Jon', 'Bon Jovi', 'Leyenda del Rock', NOW(), NOW()),
		('Michael', 'Jackson', 'El Rey del Pop', NOW(), NOW()),
        ('Madonna', 'Ciccone', 'La Reina del Pop', NOW(), NOW()),
        ('Shakira', 'Mebarak', 'Icono del pop latino', NOW(), NOW());
        
        SELECT * FROM artistas ORDER BY id DESC;

    