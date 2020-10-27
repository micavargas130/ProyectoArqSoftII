-- You can use this file to load seed data into the database using SQL statements

insert into SOCIO (NOMBRE, APELLIDO, EMAIL, DNI) values ('Mica', 'Vargas', 'mica.vargas2000@gmail.com', '42444190');
insert into PELICULA (TITULO, SINOPSIS, ANIO, GENERO) values ('Los miserables', 'de Test', '2012', 0);
insert into PELICULA (TITULO, SINOPSIS, ANIO, GENERO) values ('El silencio de los inocentes', 'test2', '2013', 0);
insert into PELICULA (TITULO, SINOPSIS, ANIO, GENERO) values ('Scary Movie', 'test3', '2013', 1);
insert into ALQUILER (FECHA_ALQUILER, SOCIO_ID, PELICULA_ID) values ('2020-03-21 13:20:12', 1, 2);