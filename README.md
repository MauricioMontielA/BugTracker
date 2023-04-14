# Bug tracker
## Entidades 
- Usuarios
    - id PK
    - username
    - email
    - password
    - role id FK

- Proyectos
    - id PK
    - project name
    - project description
    
- Tickets
    - id PK
    - title ticket
    - ticket description
    - submitter id FK
    - ticket priority id FK
    - ticket status id FK
    - ticket type id FK
    - created
    - updated    
- ticket_proyecto_usuario
    - id PK 
    - usuario_id FK
    - proyecto_id FK
    - ticket_id FK
- Roles
    - id PK
    - nombre
- Tipo de ticket
    - id PK
    - nombre
- Estatus del ticket
    - id PK
    - nombre
- prioridad del ticket
    - id PK
    - nombre
- Historial de cambios por ticket
    - id PK
    - id_ticket fk
    - property
    - old value
    - new value
    - date changed


---

## Roles y sus acciones

- Administrador
    - Crear, editar y eliminar proyectos.
    - Asignacion de proyecto a project managers
    - Gestiona los roles de los usuarios ++
    - Todas las acciones del project manager

- Project Manager
    - Crear y editar tareas
    - Asignar tareas a los desarrolladores
    - Establecer prioridades y plazos para las tareas.
    - Gestionar el progreso del proyecto y el estado de las tareas.

- Developer
    - Recibir tareas asignadas por el Project Manager.
    - Actualizar el estado de la tarea a medida que se completa.

---


---
Que necesito visualizar en cada rol?
- Administrador
    - Todos los tickets por prioridad, tipo, status, etc. 
    - Una lista de todos los usuarios(id,username, email, rol)
    - Una lista de todos los username de los usuarios
    - Una lista de todos los roles 
    - Una lista de todos los proyectos(nombre, descripcion)
    - Cualquier proyecto especifico (nombre, descripcion, lista de usuarios asignados, tickets de ese proyecto)
    - Un ticket especifico(titulo, descripcion, asignador, asignado, nombre proyecto, prioridad, status, tipo, fecha creacion, fecha edicion).
    - Historial de un ticket especifico
    - *QUIZA* comentarios del ticket
    - Lista de todos los tickets
    - Mi perfil de usuario

- Project Manager  
    - Todos los tickets de mis proyectos por prioridad, tipo, status, etc. 
    - Una lista de todos los proyectos(nombre, descripcion) que tengo asignados 
    - Cualquier proyecto especifico que tenga asignado (nombre, descripcion, lista de usuarios asignados, tickets de ese proyecto)
    - Un ticket especifico(titulo, descripcion, asignador, asignado, nombre proyecto, prioridad, status, tipo, fecha creacion, fecha edicion).
    - Historial de un ticket especifico
    - Lista de todos los tickets que he creado 
    - Mi perfil de usuario

- Desarrollador
    - Todos los tickets que se me han asignado por prioridad, tipo, status, etc. 
    - Una lista de todos los proyectos(nombre, descripcion) que tengo asignados 
    - Los tickets de un proyecto especifico que me han sido asignados
    - Un ticket especifico(titulo, descripcion, asignador, asignado, nombre proyecto, prioridad, status, tipo, fecha creacion, fecha edicion).
    - Historial de un ticket especifico
    - Todos los tickets que me han sido asignados
    - Mi perfil de usuario

---
