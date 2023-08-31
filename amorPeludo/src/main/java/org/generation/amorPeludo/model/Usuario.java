package org.generation.amorPeludo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id",unique=true, nullable=false)
	private Long id;
	@Column (nullable=false)
	private String email;
	@Column (nullable=false)
	private String nombre;
	@Column (nullable=false)
	private String apellido;
	@Column (nullable=false)
	private String contraseña;
	@Column (nullable=false)
	private String confirmarContraseña;

	
	public Usuario(String email, String nombre, String apellido, String contraseña, String confirmarContraseña) {
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.confirmarContraseña = confirmarContraseña;
	}//constructor

	
	public Usuario() {
	}//constructorvacío

	
	// GETTERS Y SETTERS : 
	
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
