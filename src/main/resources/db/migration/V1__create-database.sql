CREATE TABLE roles(
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY(id_rol)
);

CREATE TABLE ticket_prioridades(
  id_prioridad INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY(id_prioridad)
);

CREATE TABLE ticket_estatus(
  id_estatus INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY(id_estatus)
);

CREATE TABLE ticket_tipos(
  id_tipo INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY(id_tipo)
);

CREATE TABLE usuarios(
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(60) NOT NULL UNIQUE,
  password VARCHAR(200) NOT NULL,
  rol_id INT,
  FOREIGN KEY(rol_id) REFERENCES roles(id_rol),
  PRIMARY KEY(id_usuario)
);

CREATE TABLE proyectos(
  id_proyecto INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  descripcion VARCHAR(200),
  encargado_proyecto_id INT,
  FOREIGN KEY(encargado_proyecto_id) REFERENCES usuarios(id_usuario),
  PRIMARY KEY(id_proyecto)
);

CREATE TABLE tickets(
  id_ticket INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(100) NOT NULL,
  descripcion VARCHAR(300) NOT NULL,
  asignado_por_id INT NOT NULL,
  prioridad_id INT NOT NULL,
  estatus_id INT NOT NULL,
  tipo_ticket_id INT NOT NULL,
  creacion_fecha DATE NOT NULL,
  edicion_fecha DATE,
  FOREIGN KEY(asignado_por_id) REFERENCES usuarios(id_usuario),
  FOREIGN KEY(prioridad_id) REFERENCES ticket_prioridades(id_prioridad),
  FOREIGN KEY(estatus_id) REFERENCES ticket_estatus(id_estatus),
  FOREIGN KEY(tipo_ticket_id) REFERENCES ticket_tipos(id_tipo),
  PRIMARY KEY(id_ticket)
);

CREATE TABLE historial_cambios_ticket(
  id_historial INT NOT NULL AUTO_INCREMENT,
  ticket_id INT NOT NULL,
  propiedad VARCHAR(100) NOT NULL,
  valor_anterior VARCHAR(300) NOT NULL,
  valor_nuevo VARCHAR(300) NOT NULL,
  fecha_cambio DATE NOT NULL,
  FOREIGN KEY(ticket_id) REFERENCES tickets(id_ticket),
  PRIMARY KEY(id_historial)
);

CREATE TABLE ticket_usuario_proyecto_asignacion(
  id_asignacion INT NOT NULL AUTO_INCREMENT,
  ticket_id INT NOT NULL,
  asignado_a_usuario_id INT NOT NULL,
  proyecto_id INT NOT NULL,
  FOREIGN KEY(ticket_id) REFERENCES tickets(id_ticket),
  FOREIGN KEY(asignado_a_usuario_id) REFERENCES usuarios(id_usuario),
  FOREIGN KEY(proyecto_id) REFERENCES proyectos(id_proyecto),
  PRIMARY KEY(id_asignacion)
);

INSERT INTO roles (nombre) VALUES 
('ROLE_ADMINISTRADOR'),
('ROLE_PROJECT_MANAGER'),
('ROLE_DESARROLLADOR'),
('N/A');

INSERT INTO ticket_prioridades (nombre) VALUES 
('Bloqueador'),
('Urgente'),
('Alta'),
('Media'),
('Baja');

INSERT INTO ticket_estatus (nombre) VALUES 
('Asignado'),
('En progreso'),
('Resuelto'),
('Cerrado'),
('Reabierto');

INSERT INTO ticket_tipos (nombre) VALUES 
('Reporte de error'),
('Nueva funcionalidad'),
('Tarea'),
('Mejora'),
('Solicitud de soporte'),
('Problema de documentacion'),
('Test');

INSERT INTO usuarios (username, email, password, rol_id) VALUES 
('Mauricio admin', 'maumont714@gmail.com', '$2a$10$RFUbgppu/iZiefms0RKodO3ELkxDcPd7el8x5SUoInhb5agWTOMUa', 1);