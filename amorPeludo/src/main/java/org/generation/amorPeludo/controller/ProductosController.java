package org.generation.amorPeludo.controller;
import java.util.List;

import org.generation.amorPeludo.model.Productos;
import org.generation.amorPeludo.service.ProductosService;
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
@RequestMapping(path="/api/productos/") // http://localhost:8080/api/productos/
public class ProductosController {
	
	private final ProductosService productosService;
	
	@Autowired
	public ProductosController(ProductosService productosService) {
		super();
		this.productosService = productosService;
	}// constructor

	@GetMapping
	public List<Productos> getAllProducts(){
		return productosService.getAllProductos();
	}// getAllProducts
	
	@GetMapping(path="{prodId}")
	public Productos getProduct(@PathVariable ("prodId") Long id){
		return productosService.getProducto(id);
	}// getProduct
	
	@DeleteMapping (path="{prodId}")
	public Productos deleteProduct(@PathVariable ("prodId") Long id){
		return productosService.delteProducto(id);
	}// deleteProducut
	
	@PostMapping
	public Productos addProduct(@RequestBody Productos producto) {
		return productosService.addProducto(producto);
	}//addProduct
	
	@PutMapping(path="{prodId}")
	public Productos updateProduct(@PathVariable("prodId") Long id,
		@RequestParam (required=false) String tittle,
		@RequestParam(required=false) Double price,
		@RequestParam(required=false) String description,
		@RequestParam(required=false) String img1,
		@RequestParam(required=false) String img2) {
			return productosService.updateProducto(id, tittle, price, description, img1, img2);		
	} // updateProduct

} // class ProductosController
