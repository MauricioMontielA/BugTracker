package org.maumont.api.repositories;

import java.util.List;
import java.util.Optional;


import org.maumont.api.models.Rol;
import org.maumont.api.models.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Component
public class RolRepository implements Repositorio<Rol> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<Rol> rowMapper = (rs, rowNum) -> {
		System.out.println(rs);
		Rol rol = new Rol();
		rol.setId(rs.getInt("id_rol"));
		rol.setNombre(rs.getString("nombre"));
		
		return rol;
	};

	@Override
	public List<Rol> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Rol t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Rol> getById(int id) {
		String sql = "SELECT * from roles where id_rol = ?";
		Rol rol = null;
		try {
			rol = jdbcTemplate.queryForObject(sql, rowMapper, id);
		} catch (DataAccessException e) {
			System.out.println("Rol no encontrado");
		}
		return Optional.ofNullable(rol);
	}

	@Override
	public void update(Rol t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}



}
