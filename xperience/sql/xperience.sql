CREATE TABLE historia_usuario(
	id INTEGER NOT NULL
		GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	titulo VARCHAR(250) NOT NULL,
	descripcion VARCHAR(1000) NOT NULL,
	fecha DATE NOT NULL,
	prioridad INT,
	esfuerzo INT,
	estatus INT NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO historia_usuario(titulo, descripcion, fecha, estatus)
VALUES('titulo 1', 'descripcion 1', current_date, 0);
INSERT INTO historia_usuario(titulo, descripcion, fecha, estatus)
VALUES('titulo 2', 'descripcion 2', current_date, 0);
INSERT INTO historia_usuario(titulo, descripcion, fecha, estatus)
VALUES('titulo 3', 'descripcion 3', current_date, 0);

SELECT * FROM historia_usuario;


