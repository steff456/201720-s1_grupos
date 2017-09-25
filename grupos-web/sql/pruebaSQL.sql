delete from GrupoEntity_NoticiaEntity;
delete from GrupoEntity_BlogEntity;
delete from GrupoEntity_CategoriaEntity;
delete from GrupoEntity_UsuarioEntity;
delete from GrupoEntity_EventoEntity;

delete from UsuarioEntity_BlogEntity;
delete from UsuarioEntity_EventoEntity;
delete from UsuarioEntity_GrupoEntity;
delete from UsuarioEntity_PatrocinioEntity;
delete from UsuarioEntity_TarjetaEntity;

delete from BlogEntity_MultimediaEntity;
delete from BlogEntity_ComentarioEntity;

delete from NoticiaEntity_ComentarioEntity;
delete from CalificacionEntity; 
delete from BlogEntity;

delete from GrupoEntity;
delete from CategoriaEntity;
delete from NoticiaEntity_MultimediaEntity;

delete from PatrocinioEntity;
delete from ComentarioEntity;
delete from CalificacionEntity;
delete from NoticiaEntity;
delete from ComentarioEntity;
delete from MultimediaEntity;
delete from UsuarioEntity;
delete from TarjetaEntity;
delete from EventoEntity;



insert into CategoriaEntity (id, tipo, descripcion, rutaIcono) values (10,'Videojuegos', 'La mejor categoria', 'videojuegos.png');
insert into CategoriaEntity (id, tipo, descripcion, rutaIcono) values (11,'Ciencia', 'La segunda mejor categoria', 'ciencia.png');

insert into TarjetaEntity(numero, banco, dinerodisponible, maxcupo) values (1,'Caja social',100,1000);
insert into TarjetaEntity(numero, banco, dinerodisponible, maxcupo) values (2,'Caja social',102,1200);
insert into TarjetaEntity(numero, banco, dinerodisponible, maxcupo) values (3,'Caja social',120,1300);
insert into TarjetaEntity(numero, banco, dinerodisponible, maxcupo) values (4,'Caja social',130,1400);
insert into TarjetaEntity(numero, banco, dinerodisponible, maxcupo) values (5,'Caja social',140,1100);

insert into EmpresaEntity(nit,logo,nombre) values (1,'hola.png','Hola');
insert into EmpresaEntity(nit,logo,nombre) values (2,'empresa.png','Empresa');

--INFORMACIÖN USUARIO
insert into UsuarioEntity(id, nombre, apellido, password,email) values (1,'Sergio','Guzmán','hola','hola@uniandes.edu.co');
insert into UsuarioEntity(id, nombre, apellido, password,email) values (11,'DE','Rd','Hola','xd@uniandes.edu.co');
insert into UsuarioEntity(id, nombre, apellido, password,email,empresa_nit) values (3,'DE','Rd','Hola','x@uniandes.edu.co',1);
insert into UsuarioEntity(id, nombre, apellido, password,email,empresa_nit) values (2,'DE','Rd','Hola','d@uniandes.edu.co',2);


--INFORMACIÓN USUARIO TARJETA

insert into UsuarioEntity_TarjetaEntity(UsuarioEntity_Id, Tarjetas_numero) values (2,1);
insert into UsuarioEntity_TarjetaEntity(UsuarioEntity_Id, Tarjetas_numero) values (2,2);
insert into UsuarioEntity_TarjetaEntity(UsuarioEntity_Id, Tarjetas_numero) values (3,3);
insert into UsuarioEntity_TarjetaEntity(UsuarioEntity_Id, Tarjetas_numero) values (3,4);
insert into UsuarioEntity_TarjetaEntity(UsuarioEntity_Id, Tarjetas_numero) values (3,5);


--INFORMACIÓN PATROCINIO
insert into PatrocinioEntity(Id, Pago, usuario_Id) values (1,800.0,3);
insert into PatrocinioEntity(Id, Pago, usuario_Id) values (1,800.0,2);

--INFORMACIÓN BLOG



insert into GrupoEntity (id, nombre, descripcion) values (10,'GrupoPrueba1', 'Este grupo es el numero uno');
insert into GrupoEntity (id, nombre, descripcion) values (11,'GrupoPrueba2', 'Este grupo es el numero dos');


insert into BlogEntity (id,titulo,contenido,grupo_id) values (1,'Blog','Contenido',10);
insert into BlogEntity (id,titulo,contenido,grupo_id) values (2,'B','Content',10);
insert into BlogEntity(id,titulo,contenido,grupo_id) values (3,'¿Cómo hago el punto 10 de SQL?','No sé',11);
insert into BlogEntity(id,titulo,contenido,grupo_id) values (4,'HOLA','Qué hace',11);

insert into CalificacionEntity(id,calificacion,fecha,blog_id,calificador_id) values (1,2.0,'2017-09-20',1,11);

--INFORMACIÓN MULTIMEDIA
insert into MultimediaEntity (nombre,descripcion,link) values ('GATO','G','abc');
insert into MultimediaEntity (nombre,descripcion,link) values ('PERRO','G','dfdf');

--INFORMACiÓN EVENTO
insert into EventoEntity(1,'2017-08-07','2017-08-08','Evento');
insert into EventoEntity(2,'2017-08-08','2017-08-09','Evento');
insert into EventoEntity(3,'2017-08-09','2017-08-10','Evento');

insert into LugarEntity(1,20,'Dirección','Lugar');
insert into LugarEntity(2,20,'Dirección1','Lugar');
insert into LugarEntity(3,20,'Dirección2','Lugar');

--INFORMACIÓN NOTICIA
insert into NoticiaEntity (id,titulo,informacion,autor_id) values (1,'Titulo','Info',1);
insert into NoticiaEntity (id,titulo,informacion,autor_id) values (2,'Tit3lo','Irfo',11);
insert into NoticiaEntity (id,titulo,informacion,autor_id) values (3,'Nueva','Irfo',11);
insert into NoticiaEntity (id,titulo,informacion,autor_id) values (4,'New','Irfo',11);


insert into GrupoEntity_NoticiaEntity(grupoentity_id,noticiasgrupo_id) values (10,1);
insert into GrupoEntity_NoticiaEntity(grupoentity_id,noticiasgrupo_id) values (11,2);
insert into GrupoEntity_NoticiaEntity(grupoentity_id,noticiasgrupo_id) values (10,3);


--INFORMACION NOTICIAENTITY_MULTIMEDIAENTITY
insert into NoticiaEntity_MultimediaEntity(noticiaentity_id,multimedia_link) values (2,'abc');
insert into NoticiaEntity_MultimediaEntity(noticiaentity_id,multimedia_link) values (2,'dfdf');
insert into NoticiaEntity_MultimediaEntity(noticiaentity_id,multimedia_link) values (1,'abc');

insert into BlogEntity_MultimediaEntity(blogentity_id,multimedia_link) values (2,'abc');
insert into BlogEntity_MultimediaEntity(blogentity_id,multimedia_link) values (2,'dfdf');
insert into BlogEntity_MultimediaEntity(blogentity_id,multimedia_link) values (1,'abc');
