package org.maumont.api.controllers;

import java.util.List;

import org.maumont.api.dto.usuario.UsuarioActualizarRolDTO;
import org.maumont.api.dto.usuario.UsuarioRegistoDTO;
import org.maumont.api.models.Usuario;
import org.maumont.api.repositories.Repositorio;
import org.maumont.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/registro")
	public ResponseEntity registrar(@RequestBody UsuarioRegistoDTO usuarioRegistoDTO) {
		usuarioService.crearUsuario(usuarioRegistoDTO);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/asignar-rol")
	@PreAuthorize(".hasRole('ADMINISTRADOR')")
	public ResponseEntity asignarRol(@RequestBody UsuarioActualizarRolDTO usuarioActualizarRolDTO) {
		usuarioService.actualizarUsuario(usuarioActualizarRolDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity getUsuarios() {
		return ResponseEntity.ok(usuarioService.listarUsuarios());
	}
	
	@GetMapping("/obtener-project-manager")
	public ResponseEntity getProjectManagers() {
		return ResponseEntity.ok(usuarioService.listarUsuariosPorRol(2));
	}
	
	@GetMapping("/obtener-devs")
	public ResponseEntity getDevs() {
		return ResponseEntity.ok(usuarioService.listarUsuariosPorRol(3));
	}
	
}
