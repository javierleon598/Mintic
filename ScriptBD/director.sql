CREATE TABLE director(
 director_id integer (10) PRIMARY KEY,
 nombre varchar(30) NOT NULL, 
 apellido varchar(30) NOT NULL,
 nacionalidad varchar(30) NOT NULL
);
insert into director values (101, "Hayo","Miyazaki", "japones");
insert into director values (102, "Joss", "Whedon", "estadounidense");
insert into director values (103, "Christopher", "Nolan", "estadounidense");
insert into director values (104, "Bong", "Joon-ho", "coreano");
insert into director values (105, "Vincent", "Ward", "neozelandes");