package org.maumont.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.maumont.api.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class UserRepository implements Repositorio<Usuario> {
	
	@Autowired
	private JdbcTemplate jdbcTemp;

	RowMapper<Usuario> rowMapper = (rs, rowNum) -> {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt("id_usuario"));
		usuario.setUsername(rs.getString("username"));
		usuario.setEmail(rs.getString("email"));
		usuario.setPassword(rs.getString("password"));
		usuario.setRolId(rs.getInt("rol_id"));
		return usuario;
	};

	public Optional<Usuario> getByEmail(String email) {
		String sql = "SELECT * FROM usuarios WHERE email = ?";
		Usuario usuario = null;
		try {
			usuario = jdbcTemp.queryForObject(sql, rowMapper, email);

		} catch (DataAccessException e) {
			System.out.println("Usuario no encontrado");
		}

		return Optional.ofNullable(usuario);
	}

	@Override
	public List<Usuario> list() {
		String sql = "Select * from usuarios";
		return jdbcTemp.query(sql, rowMapper);
	}
	
	public List<Usuario> listarPorRol(Integer rolId) {
		String sql = "Select * from usuarios where rol_id = ?";
		return jdbcTemp.query(sql, rowMapper,rolId);	
	}

	@Override
	public void create(Usuario usuario) {
		String sql = "INSERT INTO usuarios(username, email, password) values (?,?,?)";
		int insertar = jdbcTemp.update(sql, usuario.getUsername(), usuario.getEmail(), usuario.getPassword());
		if (insertar == 1) {
			System.out.println("Nuevo usuario creado: " + usuario.getUsername());
		}
	}

	@Override
	public void update(Usuario usuario) {
		String sql = "UPDATE usuarios SET username=?, email=?, password=?, rol_id=? WHERE id_usuario = ?";
		
		Integer actualizado = jdbcTemp.update(sql, usuario.getUsername(), usuario.getEmail()
				, usuario.getPassword(), usuario.getRolId(), usuario.getId());
		
		if (actualizado == 1) {
			System.out.println("Se ha actualizado el usuario " + usuario.getUsername());
		}else {
			System.out.println("No se pudo actualizar el usuario " + usuario.getUsername());
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Usuario> getById(int id) {
		String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
		
		Usuario usuario = null;
		try {
			usuario = jdbcTemp.queryForObject(sql, rowMapper, id);

		} catch (DataAccessException e) {
			System.out.println("Usuario no encontrado");
		}

		return Optional.ofNullable(usuario);
	}

}
