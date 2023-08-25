package org.generation.amorPeludo.repository;

import java.util.Optional;

import org.generation.amorPeludo.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Productos, Long> {
	Optional <Productos> findByNombre(String tittle);
} // interface ProductoRepository
