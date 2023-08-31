package org.generation.amorPeludo.service;


import java.util.List;
import java.util.Optional;

import org.generation.amorPeludo.model.CambiarContraseña;
import org.generation.amorPeludo.model.Usuario;
import org.generation.amorPeludo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
			// Cifrar la contraseña
			usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
			usuario.setConfirmarContraseña(passwordEncoder.encode(usuario.getConfirmarContraseña()));
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
				//if(tmp.getContraseña().equals(cambiarContraseña.getContraseña())) {
				if (passwordEncoder.matches(cambiarContraseña.getContraseña(), 
						tmp.getContraseña())) {	
			tmp.setContraseña(passwordEncoder.encode(cambiarContraseña.getNuevaContraseña()));
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
	
	public boolean validateUsuario(Usuario usuario) {
		  Optional<Usuario> userByEmail = usuarioRepository.findByEmail(usuario.getEmail());
		  
		  if(userByEmail.isPresent()) {
		   Usuario user = userByEmail.get();
		   if(passwordEncoder.matches(usuario.getContraseña(), user.getContraseña())){
		    return true;
		   } // if matches
		  } // if isPrsente
		  return false;
		 } // validateUsuario
	
}//class UsuarioService
