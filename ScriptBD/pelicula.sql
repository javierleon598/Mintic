CREATE TABLE pelicula(
 contenido_id integer (10) PRIMARY KEY,
 anno int(10) NOT NULL,
 resumen varchar(1000),
 director_id integer (10),
 foreign key (director_id) references director(director_id)
);
insert into pelicula values (1 ,"1990","Pelicula de superheroes basada en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, Steve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, hermano de Thor, se apodere de la tierra.", 102);
insert into pelicula values (2 ,"2014","Pelicula de ciencia ficción, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia de un grupo de astronautas que viajan a traves de un agujero de gusano en busca de un nuevo hogar.", 103);
insert into pelicula values (3 ,"2001","Pelicula de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un mundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.", 101);
insert into pelicula values (4 ,"2019","Pelicula de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu humano.", 104);
insert into pelicula values (5 ,"1998", "Pelicula de drama, narra una historia trágica de una familia, donde el padre va en busca de sus esposa al mas allá para recuperarla.", 105);
