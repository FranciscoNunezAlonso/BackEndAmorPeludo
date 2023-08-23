package org.generation.amorPeludo.model;

public class Usuario {
	private Long id;
	private String email;
	private String nombre;
	private String apellido;
	private String contraseña;
	private String confirmarContraseña;
	private static long total = 0;
	
	public Usuario(String email, String nombre, String apellido, String contraseña, String confirmarContraseña) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.confirmarContraseña = confirmarContraseña;
		Usuario.total++;
		this.id=Usuario.total;
	}//constructor

	
	public Usuario() {
		super();
		Usuario.total++;
		this.id=Usuario.total;
	}//constructorvacío

	
	public String getEmail() {
		return email;
	}//getEmail

	public void setEmail(String email) {
		this.email = email;
	}//setEmail

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getApellido() {
		return apellido;
	}//getApellido

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}//setApellido

	public String getContraseña() {
		return contraseña;
	}//getContraseña

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}//setContraseña

	public String getConfirmarContraseña() {
		return confirmarContraseña;
	}//getConfirmarContraseña

	public void setConfirmarContraseña(String confirmarContraseña) {
		this.confirmarContraseña = confirmarContraseña;
	}//setConfirmarContraseña

	public Long getId() {
		return id;
	}//getId


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", contraseña=" + contraseña + ", confirmarContraseña=" + confirmarContraseña + "]";
	}//toString
	
	
	
}//classUsuario
