Drop table serie;
CREATE TABLE serie(
 contenido_id integer (10) PRIMARY KEY,
 numero_temporadas integer(10) NOT NULL default 1, 
 numero_episodios integer(10) NOT NULL default 1
 
);

insert into serie values (6, 11, 153);
insert into serie values (7, 3, 80);
insert into serie values (8, 3, 30);
insert into serie values (9, 4, 31);
insert into serie values (10, 10, 236);
insert into serie values (11, 8, 170);
insert into serie values (12, 12, 279);
insert into serie values (13, 6, 79);
