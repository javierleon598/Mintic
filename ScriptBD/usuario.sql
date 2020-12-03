CREATE TABLE usuario(
 alias varchar(30) NOT NULL PRIMARY KEY,
 nomnbre varchar(30) NOT NULL,
 apellido varchar(30) NOT NULL,
 fecha_nacimiento date NOT NULL,
 celular varchar(30) NOT NULL,
 email varchar(30) NOT NULL,
 contrasena varchar(30) NOT NULL,
 UNIQUE(alias)
);
insert into usuario values ("lucky","Pedro", "Perez", '2017-10-25', "3162121253", "lucky@hotmail.com","lucky");
insert into usuario values ("malopez", "Maria", "Lopez", '2018-11-25', "316225323", "malopez@hotmail.com","malopez");
insert into usuario values ("diva", "Ana", "Diaz", '2007-10-10', "315260302", "diva@gmail","diva");
insert into usuario values ("dreamer", "Luis", "Rojas", '2018-10-01', "316785951", "dreamer@hotmail.com","dreamer");
insert into usuario values ("ninja", "Andres", "Cruz", '2001-08-25', "3102365820", "ninja@gmail","ninja");
insert into usuario values ("neon", "Nelson", "Ruiz", '2002-01-15', "3025632523", "neon@gmail","neon");
insert into usuario values ("rose", "Claudia", "Mendez", '1984-05-16', "3130120587", "rose@hotmail.com","rose");
insert into usuario values ("green", "Jorge", "Rodriguez", '1970-04-05', "3172552162", "green@gmail","green");
