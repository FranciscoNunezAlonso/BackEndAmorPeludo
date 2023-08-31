package org.generation.amorPeludo.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.generation.amorPeludo.config.JwtFilter;
import org.generation.amorPeludo.model.Token;
import org.generation.amorPeludo.model.Usuario;
import org.generation.amorPeludo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;import io.jsonwebtoken.SignatureAlgorithm;

// controlador REST
@RestController
@RequestMapping (path="/api/login/")
public class loginController {
	
	private final UsuarioService usuarioService;
	
	@Autowired
	public loginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	} // constructor 


	//validar al usuario 
	@PostMapping
	public Token loginUsuario (@RequestBody Usuario usuario) throws ServletException {
		if(usuarioService.validateUsuario(usuario)) {
			return new Token(generateToken(usuario.getEmail()));
		} // if
		throw new ServletException("Nombre de usuario o contraseña incorrectos");
	} // loginUsuario

	private String generateToken (String username){
		Calendar calendar = Calendar.getInstance(); // fecha hora actual
		//calendar.add(Calendar.MINUTE, 30); // producción
		calendar.add(Calendar.HOUR, 48); // pruebas
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date()).setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	} // generateToken

} // loginController

