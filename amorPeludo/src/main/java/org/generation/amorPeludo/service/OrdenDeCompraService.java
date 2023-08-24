package org.generation.amorPeludo.service;

import java.util.ArrayList;
import java.util.List;

import org.generation.amorPeludo.model.OrdenDeCompra;
import org.springframework.stereotype.Service;

@Service
public class OrdenDeCompraService {
	public final ArrayList<OrdenDeCompra> lista = new ArrayList<>();

	public OrdenDeCompraService() {
		lista.add(new OrdenDeCompra(1L,9L,"2023-06-15",130.00));
		lista.add(new OrdenDeCompra(2L,5L,"2023-07-25",180.00));
		lista.add(new OrdenDeCompra(3L,3L,"2023-07-30",110.00));
		lista.add(new OrdenDeCompra(4L,12L,"2023-08-10",150.00));
		lista.add(new OrdenDeCompra(5L,8L,"2023-08-17",180.00));
		lista.add(new OrdenDeCompra(6L,1L,"2023-08-12",150.00));
	} // Constructor OrdenDeCompraService

	public List<OrdenDeCompra> getAllOrdenDeCompras() {
		return this.lista;
	} // getAllOrdenDeCompras

	public OrdenDeCompra getOrdenDeCompra(Long id) {
		OrdenDeCompra tmp = null;
		for (OrdenDeCompra ordenDeCompra : lista) {
			if (ordenDeCompra.getId().equals(id)) {
				tmp = ordenDeCompra;
				break;
			} // if
		} // foreach
		return tmp;
	} // getOrdenDeCompra

	public OrdenDeCompra delteOrdenDeCompra(Long id) {
		OrdenDeCompra tmp = null;
		for (OrdenDeCompra ordenDeCompra : lista) {
			if (ordenDeCompra.getId().equals(id)) {
				tmp = lista.remove(lista.indexOf(ordenDeCompra));
				break;
			} // if
		} // foreach
		return tmp;
	} // deleteOrdenDeCompra

	public OrdenDeCompra addOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
		lista.add(ordenDeCompra);
		return null;
	} // addOrdenDeCompra

	public OrdenDeCompra updateOrdenDeCompra(Long id, Long usuario_id, Long productos_id, String fecha, Double total) {
		OrdenDeCompra tmp = null;
		for (OrdenDeCompra ordenDeCompra : lista) {
			if (ordenDeCompra.getId().equals(id)) {
				if (usuario_id != null)
					ordenDeCompra.setUsuario_id(usuario_id);
				if (productos_id != null)
					ordenDeCompra.setProductos_id(productos_id);
				if (fecha != null)
					ordenDeCompra.setFecha(fecha);
				if (total != null)
					ordenDeCompra.setTotal(total);
				tmp = ordenDeCompra;
				break;
			} // if
		} // foreach
		return tmp;
	}//putOrdenDeCompra

}// class OrdenDeCompraService
