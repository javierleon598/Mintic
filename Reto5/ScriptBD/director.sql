CREATE TABLE director(
 director_id integer (10) AUTO_INCREMENT PRIMARY KEY,
 nombre varchar(30) NOT NULL, 
 apellido varchar(30) NOT NULL,
 nacionalidad varchar(30) NOT NULL
);

ALTER TABLE director AUTO_INCREMENT = 101;
insert into director(nombre,apellido,nacionalidad) values ("Hayo","Miyazaki", "japones");
insert into director(nombre,apellido,nacionalidad) values ("Joss", "Whedon", "estadounidense");
insert into director(nombre,apellido,nacionalidad) values ("Christopher", "Nolan", "estadounidense");
insert into director(nombre,apellido,nacionalidad) values ("Bong", "Joon-ho", "coreano");
insert into director(nombre,apellido,nacionalidad) values ("Vincent", "Ward", "neozelandes");