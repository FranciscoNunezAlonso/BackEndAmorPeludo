package org.generation.amorPeludo.model;

public class OrdenDeCompra {

	private Long id;
	private Long usuario_id;
	private Long productos_id;
	private String fecha;
	private Double total;
	private static long totalOrden = 0;
	
	public OrdenDeCompra(Long usuario_id, Long productos_id, String fecha, Double total) {
		super();
		this.usuario_id = usuario_id;
		this.productos_id = productos_id;
		this.fecha = fecha;
		this.total = total;
		
		OrdenDeCompra.totalOrden++;
		this.id=OrdenDeCompra.totalOrden;
	}//constructor OrdenDeCompra

	public OrdenDeCompra() {
		super();
		OrdenDeCompra.totalOrden++;
		this.id=OrdenDeCompra.totalOrden;
	}//constructor vacío OrdenCompra

	public Long getUsuario_id() {
		return usuario_id;
	}// getUsuario

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}//setUsuario

	public Long getProductos_id() {
		return productos_id;
	}//getProductos

	public void setProductos_id(Long productos_id) {
		this.productos_id = productos_id;
	}//setProductos

	public String getFecha() {
		return fecha;
	}//getFecha

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}//setFecha

	public Double getTotal() {
		return total;
	}//getTotal

	public void setTotal(Double total) {
		this.total = total;
	}//setTotal

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "OrdenDeCompra [id=" + id + ", usuario_id=" + usuario_id + ", productos_id=" + productos_id + ", fecha="
				+ fecha + ", total=" + total + "]";
	}//toString
	
}//class OrdenDeCompra
