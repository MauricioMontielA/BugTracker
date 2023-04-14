package org.maumont.api.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
//@PreAuthorize(".hasRole('ADMINISTRADOR')")
public class RolesController {
	
	@GetMapping("/saludar")
	public String saludoAdmin() {
		return "Hola admin";
	}
	
}
