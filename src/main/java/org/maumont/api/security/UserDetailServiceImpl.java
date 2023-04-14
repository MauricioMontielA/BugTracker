package org.maumont.api.security;

import org.maumont.api.models.Usuario;
import org.maumont.api.repositories.Repositorio;
import org.maumont.api.repositories.UserRepository;
import org.maumont.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	UsuarioService service;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = service
		.getByEmail(email)
		.orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + " no existe"));
		
		return new UserDetailsImpl(usuario);
	}
	
	

}
