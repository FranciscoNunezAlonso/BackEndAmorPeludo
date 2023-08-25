package org.generation.amorPeludo.service;

import java.util.List;
import org.generation.amorPeludo.model.OrdenDeCompra;
import org.generation.amorPeludo.repository.OrdenDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenDeCompraService {
	private final OrdenDeCompraRepository ordenDeCompraRepository;
	
	@Autowired
	public OrdenDeCompraService( OrdenDeCompraRepository ordenDeCompraRepository) {
		this.ordenDeCompraRepository = ordenDeCompraRepository;
	} // Constructor OrdenDeCompraService

	//MÉTODOS
	
	public List<OrdenDeCompra> getAllOrdenDeCompras() {
		return ordenDeCompraRepository.findAll();
	} // getAllOrdenDeCompras

	public OrdenDeCompra getOrdenDeCompra(Long id) {
		return ordenDeCompraRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("La orden de compra con el id [" + id
						+ "] no existe")
				);
	} // getOrdenDeCompra

	public OrdenDeCompra delteOrdenDeCompra(Long id) {
		OrdenDeCompra tmp = null;
		if(ordenDeCompraRepository.existsById(id)) {
			tmp = ordenDeCompraRepository.findById(id).get();
			ordenDeCompraRepository.deleteById(id);
		}
		return tmp;
	} // deleteOrdenDeCompra

	public OrdenDeCompra addOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
		OrdenDeCompra tmp = null;
			tmp = ordenDeCompraRepository.save(ordenDeCompra);
		return tmp;
	} // addOrdenDeCompra

	public OrdenDeCompra updateOrdenDeCompra(Long id, Long usuario_id, Long productos_id, String fecha, Double total) {
		OrdenDeCompra tmp = null;
			if (ordenDeCompraRepository.existsById(id)) {
				tmp = ordenDeCompraRepository.findById(id).get();
				if (usuario_id != null) tmp.setUsuario_id(usuario_id);
				if (productos_id != null) tmp.setProductos_id(productos_id);
				if (fecha != null) tmp.setFecha(fecha);
				if (total != null) tmp.setTotal(total);
				ordenDeCompraRepository.save(tmp);
			}else {
				System.out.println("Update - La orden de conpra con el id [" + id
						+ " ] no existe");
			} //else // if
		return tmp;
	}//putOrdenDeCompra

}// class OrdenDeCompraService
