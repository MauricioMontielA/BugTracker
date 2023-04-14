CREATE TABLE usuarios_por_proyecto(
  id_asignacion INT NOT NULL AUTO_INCREMENT,
  proyecto_id INT NOT NULL,
  asignado_a_usuario_id INT NOT NULL,
  FOREIGN KEY(asignado_a_usuario_id) REFERENCES usuarios(id_usuario),
  FOREIGN KEY(proyecto_id) REFERENCES proyectos(id_proyecto),
  PRIMARY KEY(id_asignacion)
);