package org.generation.amorPeludo.service;


import java.util.List;

import org.generation.amorPeludo.model.CambiarContraseña;
import org.generation.amorPeludo.model.Usuario;
import org.generation.amorPeludo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService (UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}//constructor
	
	// MÉTODOS
	
	public List <Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	} //getAllUsuarios
	
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El Usuario con el id [" + id
						+ "] no existe")
				);
	} // getUsuario

	public Usuario delteUsuario(Long id) {
		Usuario tmp=null;
		if(usuarioRepository.existsById(id)) {
			tmp= usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		} //if
		return tmp;	
	} // delteUsuario

	public Usuario addUsuario(Usuario usuario) {
		Usuario tmp=null;
		if(usuarioRepository.findByEmail(usuario.getEmail()).isEmpty()){
			tmp = usuarioRepository.save(usuario);
		}else {
			System.out.println("Ya existe el usuario con el email ["
					+ usuario.getEmail() + "]");
		}
		return tmp;
	} // addUsuario

	public Usuario updateUsuario(Long id, CambiarContraseña cambiarContraseña) {
		Usuario tmp=null;
		if(usuarioRepository.existsById(id)){
			tmp= usuarioRepository.findById(id).get();
			if(cambiarContraseña.getContraseña()!=null && 
					cambiarContraseña.getNuevaContraseña()!=null) {
				if(tmp.getContraseña().equals(cambiarContraseña.getContraseña())) {
					tmp.setContraseña(cambiarContraseña.getNuevaContraseña());
					usuarioRepository.save(tmp);
				} else{
					tmp=null;
				} // else
			} // if !=null
		}else {
			System.out.println("Update - El Usuario con el id [" + id 
					+ "] no existe");
		}// else if
		return tmp;
	} // updateUsuario
	
	
}//class UsuarioService
