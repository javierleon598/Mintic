drop database if exists redflix1;
create database redflix1;
use redflix1;
drop table if exists pelicula;
drop table if exists serie;
drop table if exists director;
drop table if exists transmision;
drop table if exists usuario;

CREATE TABLE pelicula(
	pelicula_id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(50) NOT NULL, 
	resumen VARCHAR(500) NOT NULL, 
	anio INT NOT NULL, 
	nombre_director VARCHAR(100) NOT NULL UNIQUE
	);
INSERT INTO pelicula (titulo, resumen, anio, nombre_director) VALUES 
("Los Vengadores", "Pelicula de superheroes basada en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, Steve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, hermano de Thor, se apodere de la tierra.", 1990, "Joss Whedon"),
("Interestelar", "Pelicula de ciencia ficción, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia de un grupo de astronautas que viajan a traves de un agujero de gusano en busca de un nuevo hogar.", 2014, "Christopher Nolan"),
("El viaje de Chihiro", "Pelicula de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un mundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.", 2001, "Hayo Miyazaki"),
("Parasitos", "Pelicula de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu humano", 2019, "Bong Joon-ho"),
("Mas alla de los sueños", "Pelicula de drama, narra una historia trágica de una familia, donde, padre va en busca de sus esposa al mas allá para recuperarla.", 1998, "Vincent Ward");

CREATE TABLE serie (
	serie_id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(255) NOT NULL, 
	numero_temporadas INT NOT NULL, 
	numero_episodios INT NOT NULL
	);
INSERT INTO serie (titulo, numero_episodios, numero_temporadas) VALUES 
("The walking dead", 153, 11),
("Viaje a las estrellas: la serie original", 80, 3),
("Glow", 30, 3),
("La casa de papel", 31, 4),
("Friends", 236, 10),
("Arrow", 170, 8),
("The big bang theory", 279, 12),
("Vikingos", 79, 6);

CREATE TABLE director (
	director_id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(255) NOT NULL, 
	apellido VARCHAR(255) NOT NULL, 
	nacionalidad VARCHAR(50) NOT NULL
	);
INSERT INTO director (nombre, apellido, nacionalidad) VALUES 
("Hayo", "Miyazaki", "japones"),
("Joss", "Whedon", "estadounidense"),
("Christopher", "Nolan", "estadounidense"),
("Bong", "Joon-ho", "coreano"),
("Vincent", "Ward", "neozelandes");

CREATE TABLE usuario(
	usuario VARCHAR(50) NOT NULL PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL, 
	apellido VARCHAR(50) NOT NULL, 
	email VARCHAR(50) NOT NULL, 
	celular VARCHAR(15) NOT NULL, 	
	contrasena VARCHAR(50) NOT NULL, 
	fecha_nacimiento date NOT NULL
	);
INSERT INTO usuario(usuario, nombre, apellido, email, celular, contrasena, fecha_nacimiento) VALUES 
("lucky", "Pedro", "Perez", "email@gmail.com", "310243445", "123456", "1995-12-05"),
("malopez", "Maria", "Lopez", "email@gmail.com", "310243445", "123456", "1995-12-05"),
("diva", "Ana", "Diaz", "email@gmail.com", "310243445", "123456", "1995-12-05"),
("dreamer", "Luis", "Rojas", "email@gmail.com", "310243445", "123456", "1995-12-05"),
("ninja", "Andres", "Cruz", "email@gmail.com", "310243445", "123456", "1995-12-05"),
("neon", "Nelson", "Ruiz", "email@gmail.com", "310243445", "123456", "1995-12-05"),
("rose", "Claudia", "Mendez", "email@gmail.com", "310243445", "123456", "1995-12-05"),
("green", "Jorge", "Rodriguez", "email@gmail.com", "310243445", "123456", "1995-12-05");

CREATE TABLE transmision(
	transmision_id INT AUTO_INCREMENT PRIMARY KEY,
	usuario VARCHAR(50) NOT NULL,
	contenido VARCHAR(50) NOT NULL,
	fecha_hora DATE NOT NULL,
	foreign key(usuario) references usuario(usuario)
);
INSERT INTO transmision (usuario, contenido, fecha_hora) VALUES 
("lucky", "Los Vengadores", "2017-10-25 20:00:00"),
("lucky", "Parasitos", "2019-03-15 18:30:00"),
("lucky", "La casa de papel", "2019-05-20 20:30:00"),
("malopez", "Los Vengadores", "2018-05-20 20:30:00"),
("malopez", "La casa de papel", "2020-01-20 20:30:00"),
("diva", "Interestelar", "2019-05-20 20:30:00"),
("diva", "El viaje de Chihiro", "2018-06-22 21:30:00"),
("diva", "The walking dead", "2020-03-17 15:30:20"),
("dreamer", "The walking dead", "2020-03-17 15:30:20"),
("dreamer", "Viaje a las estrellas: la serie original", "2020-04-10 18:30:20"),
("ninja", "Glow", "2020-02-17 20:30:20"),
("ninja", "La casa de papel", "2020-02-20 16:30:20"),
("ninja", "Arrow", "2020-03-27 18:30:20"),
("rose", "Friends", "2020-03-20 21:30:20"),
("green", "Interestelar", "2020-01-10 17:30:20"),
("green", "Parasitos",  "2020-02-15 20:30:20"),
("green", "Mas alla de los sueños", "2020-03-17 18:30:20");

SET SQL_SAFE_UPDATES = 0;

UPDATE pelicula SET anio = 2012 WHERE titulo = "Los Vengadores";
UPDATE usuario SET celular = 311567843 WHERE usuario = "ninja";
DELETE FROM transmision WHERE usuario = "green" AND contenido = "Parasitos";