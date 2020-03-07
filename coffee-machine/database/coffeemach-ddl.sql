

create table receta (idreceta BIGINT primary key, nombre varchar(300) not null, precio numeric(20,5) not null);

​

create table ingrediente (idingrediente BIGINT primary key, nombre varchar(300) not null);

​

create table receta_ingrediente (idreceta BIGINT not null, idingrediente BIGINT not null, unidades BIGINT not null, constraint fk_receta_ing_recetas foreign key (idreceta) references receta (idreceta), constraint fk_receta_ing_ingre foreign key (idingrediente) references ingrediente (idingrediente));

​

create table ventas (consecutivo BIGINT primary key, idmaquina BIGINT not null, valor numeric(20,5) not null, fecha_inicial date not null, fecha_final date not null);

​

create table ventas_receta (consecutivo BIGINT primary key, id_receta BIGINT not null, consecutivo_ventas BIGINT not null, constraint fk_ven_rece_recetas foreign key (id_receta) references receta (idreceta), constraint fk_ven_rece_ventas foreign key (consecutivo_ventas) references ventas (consecutivo));

​

create table alarma (idalarma BIGINT primary key, nombre varchar(300) not null);

​

create table maquina (idmaquina BIGINT primary key, ubicacion varchar(300) not null);

​

create table alarma_maquina (id_alarma BIGINT not null,id_maquina BIGINT not null,fecha_inicial date not null, fecha_final date, consecutivo BIGINT primary key, constraint fk_alar_maq_alarma foreign key (id_alarma) references alarma (idalarma), constraint fk_alar_maq_maquina foreign key (id_maquina) references maquina (idmaquina));

​

create table operadores (idoperador BIGINT primary key,nombre varchar(300) not null, correo varchar(300) not null, contrasena varchar(300) not null);

​

create table asignacion_maquina (id_operador BIGINT not null, id_maquina BIGINT not null, constraint fk_asig_maq_operador foreign key (id_operador) references operadores (idoperador), constraint fk_asig_maq_maquina foreign key (id_maquina) references maquina (idmaquina));

​

create sequence consecalarma minvalue 1 maxvalue 2147483647 start with 13 increment by 1;

​

create sequence consecutivo minvalue 1 maxvalue 2147483647 start with 20 increment by 1;

​

create sequence consecutivo1 minvalue 1 maxvalue 2147483647 start with 20 increment by 1;

​

create sequence seq_ingredientes minvalue 1 maxvalue 2147483647 start with 5 increment by 1;

​

create sequence seq_alarmas minvalue 1 maxvalue 2147483647 start with 13 increment by 1;


