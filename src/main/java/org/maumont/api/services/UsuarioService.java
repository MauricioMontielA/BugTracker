package org.maumont.api.services;

import java.util.List;
import java.util.Optional;

import org.maumont.api.dto.usuario.UsuarioActualizarRolDTO;
import org.maumont.api.dto.usuario.UsuarioRegistoDTO;
import org.maumont.api.dto.usuario.UsuarioRetornoUsernameDto;
import org.maumont.api.models.Rol;
import org.maumont.api.models.Usuario;
import org.maumont.api.repositories.RolRepository;
import org.maumont.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RolRepository rolRepository;
	
	public Optional<Usuario> getByEmail(String email){
		Usuario usuario = userRepository.getByEmail(email).orElse(new Usuario());
		Integer id_rol = usuario.getRolId();
		Rol rol = rolRepository.getById(id_rol).orElse(new Rol());
		usuario.setRol(rol.getNombre());
		return Optional.ofNullable(usuario);
	}
	
	public void crearUsuario(UsuarioRegistoDTO usuarioRegistoDTO) {
		Usuario usuario = new Usuario(usuarioRegistoDTO);
		String nuevoPassword = encriptarPassword(usuario.getPassword());
		usuario.setPassword(nuevoPassword);
		userRepository.create(usuario);
	}
	
	public void actualizarUsuario(UsuarioActualizarRolDTO usuarioActualizarRolDTO) {
		Integer idUsuario = usuarioActualizarRolDTO.id_usuario();
		Usuario usuario = userRepository.getById(idUsuario).orElse(new Usuario());
		usuario.setRolId(usuarioActualizarRolDTO.rol_id());
		userRepository.update(usuario);
	}
	
	public List<Usuario> listarUsuarios(){
		return userRepository.list();
	}
	
	public List<UsuarioRetornoUsernameDto> listarUsuariosPorRol(Integer rolId){
		List<UsuarioRetornoUsernameDto> listaUsernameDto = userRepository.listarPorRol(rolId)
				.stream()
				.map(UsuarioRetornoUsernameDto::new)
				.toList();
		return listaUsernameDto;
	}
	
	private String encriptarPassword(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
}
