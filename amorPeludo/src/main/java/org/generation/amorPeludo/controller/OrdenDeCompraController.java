package org.generation.amorPeludo.controller;

import java.util.List;

import org.generation.amorPeludo.model.OrdenDeCompra;
import org.generation.amorPeludo.service.OrdenDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//CRUD  Create - Read - Update - Delete
//HTTP  POST    - GET -  PUT   - DELETE

@RestController
@RequestMapping(path="/api/ordenDeCompra/") // http://localhost:8080/api/ordenDeCompra/
public class OrdenDeCompraController {
	
	private final OrdenDeCompraService ordenDeCompraService;
	
	@Autowired
	public OrdenDeCompraController(OrdenDeCompraService ordenDeCompraService) {
		super();
		this.ordenDeCompraService = ordenDeCompraService;
	}// constructor

	@GetMapping
	public List<OrdenDeCompra> getAllOrdenDeCompras(){
		return ordenDeCompraService.getAllOrdenDeCompras();
	}// getAllOrdenDeCompras
	
	@GetMapping(path="{ordId}")
	public OrdenDeCompra getOrdenDeCompra(@PathVariable ("ordId") Long id){
		return ordenDeCompraService.getOrdenDeCompra(id);
	}// getOrdenDeCompra
	
	@DeleteMapping (path="{ordId}")
	public OrdenDeCompra deleteOrdenDeCompra(@PathVariable ("ordId") Long id){
		return ordenDeCompraService.delteOrdenDeCompra(id);
	}// deleteOrdenDeCompra
	
	@PostMapping
	public OrdenDeCompra addOrdenDeCompra(@RequestBody OrdenDeCompra ordenDeCompra) {
		return ordenDeCompraService.addOrdenDeCompra(ordenDeCompra);
	}//addOrdenDeCompra
	
	@PutMapping(path="{ordId}")
	public OrdenDeCompra updateOrdenDeCompra(@PathVariable("ordId") Long id,
		@RequestParam (required=false) Long usuario_id,
		@RequestParam(required=false) Long productos_id,
		@RequestParam(required=false) String fecha,
		@RequestParam(required=false) Double total) {
			return ordenDeCompraService.updateOrdenDeCompra(id, usuario_id, productos_id, fecha, total);		
	} // updateProduct

} // class ProductosController
