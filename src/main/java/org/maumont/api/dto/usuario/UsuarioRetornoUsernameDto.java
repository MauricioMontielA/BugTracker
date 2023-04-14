package org.maumont.api.dto.usuario;

import org.maumont.api.models.Usuario;

public record UsuarioRetornoUsernameDto(String username, Integer id_usuario) {

	public UsuarioRetornoUsernameDto(Usuario usuario) {
		this(usuario.getUsername(), usuario.getId());
	}
}
