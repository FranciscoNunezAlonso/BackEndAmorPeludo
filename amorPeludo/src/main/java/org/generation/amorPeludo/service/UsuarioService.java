package org.generation.amorPeludo.service;

import java.util.ArrayList;
import java.util.List;

import org.generation.amorPeludo.model.Productos;
import org.generation.amorPeludo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	public final ArrayList<Usuario> lista = new ArrayList <>();
	@Autowired
	public UsuarioService () {
		lista.add(new Usuario ("tolumes.daniela@gmail.com", "Daniela", "Heredia", "Pa$$w0rd", "Pa$$w0rd"));
		lista.add(new Usuario ("anacristina.cortezjardon@gmail.com", "Ana", "Cortez", "Pa$$w0rd1", "Pa$$w0rd1"));
		lista.add(new Usuario ("francisco.nunez.alonso@outlook.com.mx", "Francisco", "Núñez", "Pa$$w0rd3", "Pa$$w0rd3"));
		lista.add(new Usuario ("sotochavezjoseluis3@gmail.com", "Luis", "Soto", "Pa$$w0rd4", "Pa$$w0rd4"));
		lista.add(new Usuario ("dominique.marinvic@gmail.com", "Dominique", "Marin", "Pa$$w0rd5", "Pa$$w0rd5"));
	}//constructor
	
	public List <Usuario> getAllUsuarios() {
		return this.lista;
	} //getAllUsuarios
	
	public Usuario getUsuario(Long id) {
		Usuario tmp=null;
		for (Usuario usuario : lista) {
			if(usuario.getId().equals(id)){
				tmp=usuario;
				break;
			}//if
		}//foreach
		return tmp;
	} // getUsuario

	public Usuario delteUsuario(Long id) {
		Usuario tmp=null;
		for (Usuario usuario : lista) {
			if(usuario.getId().equals(id)){
				tmp= lista.remove(lista.indexOf(usuario));
				break;
			}//if
		}//foreach
		return tmp;
	} // delteUsuario

	public Usuario addUsuario(Usuario usuario) {
		lista.add(usuario);
		return null;
	} // addUsuario

	public Usuario updateUsuario(Long id, String email, String nombre, String apellido, String contraseña, String confirmarContraseña) {
		
		Usuario tmp=null;
		for (Usuario usuario : lista) {
			if(usuario.getId().equals(id)){
				if(email!=null) usuario.setEmail(email);
				if(nombre!=null) usuario.setNombre(nombre);
				if(apellido!=null) usuario.setApellido(apellido);
				if(contraseña!=null) usuario.setContraseña(contraseña);
				if(confirmarContraseña!=null) usuario.setConfirmarContraseña(confirmarContraseña);
				tmp= usuario;
				break;
			}//if
		}//foreach
		return tmp;
	}
	
	
}//class UsuarioService
