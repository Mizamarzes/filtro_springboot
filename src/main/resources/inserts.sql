INSERT INTO modelo(nombre, descripcion) VALUES("Honda", "La mejor");

INSERT INTO marca(nombre) VALUES("BMX");

INSERT INTO bicicletas(modelo, marca, precio, stock) VALUES
(1, 1, 24.00, 4);

INSERT INTO ventas(fecha, cliente_id) VALUES
("2023-04-03", NULL);

INSERT INTO detalles_ventas(venta_id, bicicleta_id, cantidad, precio_unitario) VALUES
(1, 2, 1, 20.00);