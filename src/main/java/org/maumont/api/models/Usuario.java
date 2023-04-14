package org.maumont.api.models;

import org.maumont.api.dto.usuario.UsuarioRegistoDTO;

public class Usuario {
	private Integer id;
	private String username;
	private String email;
	private String password;
	private Integer rolId;
	private String rol;

	public Usuario(UsuarioRegistoDTO usuarioRegistoDTO) {
		this.username = usuarioRegistoDTO.getUsername();
		this.email = usuarioRegistoDTO.getEmail();
		this.password = usuarioRegistoDTO.getPassword();
	}

	public Usuario() {

	}

	public Usuario(Integer id, String username, String email, String password, String rol) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", rolId=" + rolId + ", rol=" + rol + "]";
	}

}
