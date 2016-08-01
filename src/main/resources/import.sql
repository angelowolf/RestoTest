INSERT INTO EstadoPedido (id,nombre) VALUES (1,'cancelada');
INSERT INTO EstadoPedido (id,nombre) VALUES (2,'entregada');
INSERT INTO EstadoPedido (id,nombre) VALUES (3,'iniciada');
INSERT INTO EstadoPedido (id,nombre) VALUES (4,'preparando');
INSERT INTO EstadoPedido (id,nombre) VALUES (5,'retirada');
INSERT INTO EstadoPedido (id,nombre) VALUES (6,'terminada');

INSERT INTO CategoriaInsumo(nombre) VALUES ('Elaborado');
INSERT INTO CategoriaInsumo(nombre) VALUES ('Almacen');
INSERT INTO CategoriaInsumo(nombre) VALUES ('Carniceria');
INSERT INTO CategoriaInsumo(nombre) VALUES ('Verduleria');

INSERT INTO CategoriaReceta(nombre) VALUES ('Salsa');
INSERT INTO CategoriaReceta(nombre) VALUES ('Ensalada');
INSERT INTO CategoriaReceta(nombre) VALUES ('Minuta');
INSERT INTO CategoriaReceta(nombre) VALUES ('Guarnicion');
INSERT INTO CategoriaReceta(nombre) VALUES ('Trago');
INSERT INTO CategoriaReceta(nombre) VALUES ('Picada');
INSERT INTO CategoriaReceta(nombre) VALUES ('Postre');
INSERT INTO CategoriaReceta(nombre) VALUES ('Infusion');
INSERT INTO CategoriaReceta(nombre) VALUES ('Entrada');
INSERT INTO CategoriaReceta(nombre) VALUES ('Pizza');
INSERT INTO CategoriaReceta(nombre) VALUES ('Agregado');

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Tomate','Kilogramos',NOW(),1,4);
insert into InsumoBruto(id,precioUnidad) values(1,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',1);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Acelga','Kilogramos',NOW(),2,4);
insert into InsumoBruto(id,precioUnidad) values(2,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',2);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Cebolla','Kilogramos',NOW(),3,4);
insert into InsumoBruto(id,precioUnidad) values(3,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',3);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Banana','Kilogramos',NOW(),4,4);
insert into InsumoBruto(id,precioUnidad) values(4,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',4);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Berenjena','Kilogramos',NOW(),5,4);
insert into InsumoBruto(id,precioUnidad) values(5,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',5);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Lechuga','Kilogramos',NOW(),6,4);
insert into InsumoBruto(id,precioUnidad) values(6,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',6);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Huevo','Kilogramos',NOW(),7,4);
insert into InsumoBruto(id,precioUnidad) values(7,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',7);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Manzana','Kilogramos',NOW(),8,4);
insert into InsumoBruto(id,precioUnidad) values(8,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',8);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Sandia','Kilogramos',NOW(),9,4);
insert into InsumoBruto(id,precioUnidad) values(9,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',9);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Melon','Kilogramos',NOW(),10,4);
insert into InsumoBruto(id,precioUnidad) values(10,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',10);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Champiñon','Kilogramos',NOW(),11,4);
insert into InsumoBruto(id,precioUnidad) values(11,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',11);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Coco','Kilogramos',NOW(),12,4);
insert into InsumoBruto(id,precioUnidad) values(12,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',12);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Naranja','Kilogramos',NOW(),13,4);
insert into InsumoBruto(id,precioUnidad) values(13,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',13);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Mandarina','Kilogramos',NOW(),14,4);
insert into InsumoBruto(id,precioUnidad) values(14,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',14);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Espinaca','Kilogramos',NOW(),15,4);
insert into InsumoBruto(id,precioUnidad) values(15,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',15);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Remolacha','Kilogramos',NOW(),16,4);
insert into InsumoBruto(id,precioUnidad) values(16,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',16);

insert into Stock(cantidadActual,cantidadMinima) values(10,50);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Zanahoria','Kilogramos',NOW(),17,4);
insert into InsumoBruto(id,precioUnidad) values(17,38);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',17);

insert into Stock(cantidadActual,cantidadMinima) values(2,10);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Papa','Kilogramos',NOW(),18,4);
insert into InsumoBruto(id,precioUnidad) values(18,5);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',18);

insert into Stock(cantidadActual,cantidadMinima) values(30,150);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Coca Cola','Unidad',NOW(),19,2);
insert into InsumoBruto(id,precioUnidad) values(19,15);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',19);

insert into Stock(cantidadActual,cantidadMinima) values(30,150);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Pan Rallado','Kilogramos',NOW(),20,2);
insert into InsumoBruto(id,precioUnidad) values(20,15);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',20);

insert into Stock(cantidadActual,cantidadMinima) values(30,150);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Bife','Kilogramos',NOW(),21,4);
insert into InsumoBruto(id,precioUnidad) values(21,15);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',12);

insert into Stock(cantidadActual,cantidadMinima) values(30,150);
insert into Insumo(nombre,unidadMedida,fechaAlta,id_stock,id_categoria) values('Milanesa','Unidad',NOW(),22,1);
insert into InsumoElaborado(id) values(22);
insert into DetalleInsumoElaborado(cantidad,id_insumoBruto,id_insumoElaborado) values(1,4,22);
insert into DetalleInsumoElaborado(cantidad,id_insumoBruto,id_insumoElaborado) values(0.05,20,22);
insert into DetalleInsumoElaborado(cantidad,id_insumoBruto,id_insumoElaborado) values(0.1,21,22);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(10,10,NOW(),'Ajuste',22);

insert into Usuario(nombre,apellido,nick,clave,fechaBaja,telefono,direccion,documento,fechaalta,preguntaSecreta,respuestaSecreta) values('Juan','Lopez','admin','21232f297a57a5a743894a0e4a801fc3',null,3548451345,'calle sin numero',324231423,'2016-01-01','¿Cuál era la marca de tu primer auto?','Fiat');
insert into Rol_Usuario(id,roles) values(1,'Usuario');
insert into Rol_Usuario(id,roles) values(1,'Mozo');
insert into Rol_Usuario(id,roles) values(1,'Cocina');
insert into Rol_Usuario(id,roles) values(1,'Caja');
insert into Rol_Usuario(id,roles) values(1,'Mesa');
insert into Rol_Usuario(id,roles) values(1,'Stock');
insert into Usuario(nombre,apellido,nick,clave,fechaBaja,telefono,direccion,documento,fechaalta) values('Mozero','De La Olla','mozo','126f8d4532191178216b1be0d199af87',null,3124325,'calle sin numero',85673245,'2016-01-02');
insert into Rol_Usuario(id,roles) values(2,'Cocina');
insert into Rol_Usuario(id,roles) values(2,'Stock');
insert into Usuario(nombre,apellido,nick,clave,fechaBaja,telefono,direccion,documento,fechaalta) values('Barrero','De La Barra','barra','97c1fad8d8d23747d6184693dffab860',null,1235435612,'calle sin numero',5642523,'2016-01-03');
insert into Rol_Usuario(id,roles) values(3,'Mozo');





insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(50,60,'2016-08-2 00:00:00','Reposicion',1);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(-20,40,'2016-08-3 05:00:00','Venta',1);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(-10,30,'2016-08-3 07:00:00','Confeccion',1);
insert into DetalleStock(cantidad,total,fecha,tipoMovimiento,id_stock) values(5,35,'2016-08-4 00:00:00','Reposicion',1);



insert into Receta(nombre,id_categoria,fechaAlta,fechaBaja) values ('Milanesa a la napolitana',3,NOW(),null);
insert into Receta(nombre,id_categoria,fechaAlta,fechaBaja) values ('Milanesa a la suiza',3,NOW(),null);
insert into Receta(nombre,id_categoria,fechaAlta,fechaBaja) values ('Milanesa caballo',3,NOW(),null);