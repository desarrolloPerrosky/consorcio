package com.farmaciasturno.web.app.pojos;

public class Local {

	private String nombre;
	private String direccion;
	private String telefono;
	private String latitud;
	private String longitud;

	public Local() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Local(String nombre, String direccion, String telefono, String latitud, String longitud) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

}
