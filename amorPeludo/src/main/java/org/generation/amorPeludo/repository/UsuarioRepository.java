package org.generation.amorPeludo.repository;


import java.util.Optional;

import org.generation.amorPeludo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional <Usuario> findByEmail(String email);
} // Interface UsuarioRepository
