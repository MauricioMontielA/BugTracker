package org.maumont.api.dto.usuario;

public class UsuarioRegistoDTO {
	private String username;
	private String email;
	private String password;

	public UsuarioRegistoDTO() {
		
	}

	public UsuarioRegistoDTO(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "UsuarioRegistoDTO [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
