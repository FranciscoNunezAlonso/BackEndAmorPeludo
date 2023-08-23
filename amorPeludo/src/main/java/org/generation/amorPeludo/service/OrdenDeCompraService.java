package org.generation.amorPeludo.service;

import java.util.ArrayList;
import java.util.List;

import org.generation.amorPeludo.model.OrdenDeCompra;
import org.generation.amorPeludo.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenDeCompraService {
	public final ArrayList<OrdenDeCompra> lista = new ArrayList<>();

	@Autowired
	public OrdenDeCompraService() {
		lista.add(new OrdenDeCompra("2023-06-15", "%Y-%m-%d", 130.00));	// +++++++++++++++++++++++++++++++++++++ AQUÍ VAMOS +++++++++++++++++++++++++++++++++++++++++++++++++++++
		
	} // Constructor OrdenDeCompraService

	public List<OrdenDeCompra> getAllProductos() {
		return this.lista;
	} // getAllProductos

	public Productos getProducto(Long id) {
		Productos tmp = null;
		for (Productos producto : lista) {
			if (producto.getId().equals(id)) {
				tmp = producto;
				break;
			} // if
		} // foreach
		return tmp;
	} // getProducto

	public Productos delteProducto(Long id) {
		Productos tmp = null;
		for (Productos producto : lista) {
			if (producto.getId().equals(id)) {
				tmp = lista.remove(lista.indexOf(producto));
				break;
			} // if
		} // foreach
		return tmp;
	} // deleteProducto

	public Productos addProducto(Productos producto) {
		lista.add(producto);
		return null;
	} // addProducto

	public Productos updateProducto(Long id, String tittle, Double price, String description, String img1,
			String img2) {

		Productos tmp = null;
		for (Productos producto : lista) {
			if (producto.getId().equals(id)) {
				if (tittle != null)
					producto.setTittle(tittle);
				if (price != null)
					producto.setPrice(price);
				if (description != null)
					producto.setDescription(description);
				if (img1 != null)
					producto.setImg1(img1);
				if (img2 != null)
					producto.setImg2(img2);
				tmp = producto;
				break;
			} // if
		} // foreach
		return tmp;
	}

}// class OrdenDeCompraService
