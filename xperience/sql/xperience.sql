CREATE TABLE historia_usuario(
	id INTEGER NOT NULL
		GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	titulo VARCHAR(250) NOT NULL,
	descripcion VARCHAR(1000) NOT NULL,
	fecha DATE NOT NULL,
	prioridad INT,
	esfuerzo INT,
	orden INT,
	estatus INT NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO historia_usuario(titulo, descripcion, fecha, estatus)
VALUES('titulo 1', 'descripcion 1', current_date, 0);
INSERT INTO historia_usuario(titulo, descripcion, fecha, estatus)
VALUES('titulo 2', 'descripcion 2', current_date, 0);
INSERT INTO historia_usuario(titulo, descripcion, fecha, estatus)
VALUES('titulo 3', 'descripcion 3', current_date, 0);

-- SELECT * FROM historia_usuario;

CREATE TABLE sprint(
	id INTEGER NOT NULL
		GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre VARCHAR(250) NOT NULL,	
	fecha_ini DATE NOT NULL,
	fecha_fin DATE NOT NULL,	 
	esfuerzo_total INT,
	
	PRIMARY KEY(id)
);


CREATE TABLE sprint_historia_usuario_rel (
	id_sprint INT,
	id_historia INT,
	PRIMARY KEY(id_sprint,id_historia)
);

ALTER TABLE sprint_historia_usuario_rel
ADD FOREIGN KEY (id_sprint) 
REFERENCES sprint(id);

ALTER TABLE sprint_historia_usuario_rel
ADD FOREIGN KEY (id_historia) 
REFERENCES historia_usuario(id);


drop table actividad;
CREATE TABLE actividad(
	id INTEGER NOT NULL
		GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	titulo VARCHAR(250), -- NOT NULL DEFAULT '',
	descripcion VARCHAR(1000), -- NOT NULL DEFAULT '',
	prioridad INT DEFAULT 0,
	esfuerzo INT DEFAULT 0,
	estatus INT, -- NOT NULL DEFAULT 0,
	historia_usuario_id INT, -- NOT NULL DEFAULT 0,
	usuario_id INT, -- NOT NULL DEFAULT 0,
	PRIMARY KEY(id)
);

ALTER TABLE historia_usuario ADD COLUMN orden INT;

CREATE TABLE proyecto(
	id INTEGER NOT NULL
		GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	titulo VARCHAR(250) NOT NULL,
	descripcion VARCHAR(1000) NOT NULL,
	jefe_proyecto VARCHAR(250) NOT NULL,
	fecha_inicio DATE,
	fecha_fin DATE,
	estatus int not null,
	PRIMARY KEY(id)
);

INSERT INTO proyecto(titulo, descripcion, jefe_proyecto, fecha_inicio, fecha_fin, estatus)
VALUES('titulo 1', 'descripcion 1', 'Jefe 1', current_date, current_date, 0);
INSERT INTO proyecto(titulo, descripcion, jefe_proyecto, fecha_inicio, fecha_fin, estatus)
VALUES('titulo 2', 'descripcion 2', 'Jefe 2', current_date, current_date, 0);
INSERT INTO proyecto(titulo, descripcion, jefe_proyecto, fecha_inicio, fecha_fin, estatus)
VALUES('titulo 3', 'descripcion 3', 'Jefe 3', current_date, current_date, 0);


