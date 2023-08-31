package org.generation.amorPeludo.service;

import java.util.List;

import org.generation.amorPeludo.model.Productos;
import org.generation.amorPeludo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductosService {
	private final ProductoRepository productoRepository;
	@Autowired
	public ProductosService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	} // Constructor 
	
	
	// MÉTODOS
	
	public List <Productos> getAllProductos() {
		return productoRepository.findAll();
	} //getAllProductos
	
	public Productos getProducto(Long id) {
		return productoRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El producto con el id [" + id
						+ "] no existe")
				);
	} // getProducto

	public Productos delteProducto(Long id) {
		Productos tmp=null;
		if(productoRepository.existsById(id)) {
			tmp= productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}
		return tmp;
	} // deleteProducto

	public Productos addProducto(Productos productos) {
		Productos tmp = null;
		if (productoRepository.findByTittle(productos.getTittle()).isEmpty()) {
			tmp = productoRepository.save(productos);
		}else {
			System.out.println("Ya existe el producto con el nombre [" + productos.getTittle() + "]");
		}//if
		return tmp;
	} // addProducto

	public Productos updateProducto(Long id, String tittle, Double price, String description, String img1, String img2) {
	Productos tmp=null;
	if (productoRepository.existsById(id)) {//found
		tmp=productoRepository.findById(id).get();
		if(tittle!=null) tmp.setTittle(tittle);
		if(price!=null) tmp.setPrice(price);
		if(description!=null) tmp.setDescription(description);
		if(img1!=null) tmp.setImg1(img1);
		if(img2!=null) tmp.setImg2(img2);
		productoRepository.save(tmp);
	}else {
		System.out.println("Update - El producto con el id [" + id
				+ " ] no existe");
	}//else//if
	return tmp;
	}//updateProducto

} // class ProductosService
