package org.generation.amorPeludo.controller;

import java.util.List;

import org.generation.amorPeludo.model.CambiarContraseña;
import org.generation.amorPeludo.model.Usuario;
import org.generation.amorPeludo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/usuarios/") // http://localhost:8080/api/usuarios/
public class UsuarioController {

	// CRUD Create - Read - Update - Delete
	// HTTP POST - GET - PUT - DELETE

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}// constructor

	@GetMapping
	public List<Usuario> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}// getAllUsuarios

	@GetMapping(path = "{usrdId}")
	public Usuario getUsuario(@PathVariable("usrdId") Long id) {
		return usuarioService.getUsuario(id);
	}// getUsuario

	@DeleteMapping(path = "{usrdId}")
	public Usuario deleteUsuario(@PathVariable("usrdId") Long id) {
		return usuarioService.delteUsuario(id);
	}// delteUsuario

	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}// addUsuario

	@PutMapping(path = "{usrdId}")
	public Usuario updateUsuario(@PathVariable("usrdId") Long id,
			@RequestBody CambiarContraseña cambiarContraseña ) {
	return usuarioService.updateUsuario(id, cambiarContraseña);
	} // updateUsuario

}// class UsuarioController
