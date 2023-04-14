package org.maumont.api.models;

public class EntidadCatalogo {
	private Integer id;
	private String nombre;

	public EntidadCatalogo(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public EntidadCatalogo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
