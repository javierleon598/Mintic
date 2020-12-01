CREATE TABLE transmision(
 transmision_id integer (10) AUTO_INCREMENT PRIMARY KEY,
 usuario_alias varchar(30) NOT NULL,
 contenido_id integer(30) NOT NULL,
 fecha date NOT NULL, 
 hora time NOT NULL,
 foreign key (usuario_alias) references usuario(alias),
 foreign key (contenido_id) references contenido(contenido_id)
);
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("lucky" , 1 , '2017-10-25', '20:00:00');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("lucky",  4 , '2019-03-15', '18:30:00');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("lucky", 9, '2019-05-20', '20:30:00');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("malopez" ,1 , '2018-05-20', '20:30:00');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("malopez" , 9 , '2020-01-20', '20:30:00');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("diva" , 2 ,'2019-05-20', '20:30:00');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("diva" , 3 , '2018-06-22', '21:30:00');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("diva", 6 , '2020-03-17', '15:30:20');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("dreamer" ,6 , '2020-03-17', '15:30:20');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("dreamer",  7, '2020-04-10', '18:30:20');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("ninja", 8 , '2020-02-17', '20:30:20');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("ninja", 9 , '2020-02-20', '16:30:20');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("ninja" , 11, '2020-03-27', '18:30:20');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("rose",  10 , '2020-03-20', '21:30:20');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("green" , 2 , '2020-01-10', '17:30:20');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("green" , 4 ,  '2020-02-15', '20:30:20');
insert into transmision (usuario_alias, contenido_id, fecha, hora) values ("green" , 5 , '2020-03-17', '18:30:20');
