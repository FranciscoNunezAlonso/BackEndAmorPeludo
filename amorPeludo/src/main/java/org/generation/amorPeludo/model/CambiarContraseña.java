package org.generation.amorPeludo.model;

public class CambiarContraseña {

	private String contraseña;
	private String nuevaContraseña;
	
	public CambiarContraseña(String contraseña, String nuevaContraseña) {
		this.contraseña = contraseña;
		this.nuevaContraseña = nuevaContraseña;
	} // constructor
	
	public CambiarContraseña() {} // constructor vacio 

	
	// GETTERS Y SETTERS :
	
	public String getContraseña() {
		return contraseña;
	} // getContraseña

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	} // setContraseña

	public String getNuevaContraseña() {
		return nuevaContraseña;
	} // getNuevaContraseña

	public void setNuevaContraseña(String nuevaContraseña) {
		this.nuevaContraseña = nuevaContraseña;
	} //  setNuevaContraseña

	@Override
	public String toString() {
		return "CambiarContraseña [contraseña=" + contraseña + ", nuevaContraseña=" + nuevaContraseña + "]";
	} // toString
	
	
	
} // class Cambiar Contraseña
