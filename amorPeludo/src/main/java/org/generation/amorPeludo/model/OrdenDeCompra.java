package org.generation.amorPeludo.model;

import java.sql.Date;

public class OrdenDeCompra {

	private long id;
	private long usuario_id;
	private long productos_id;
	private Date fecha;
	private Double total;
	private static long totalOrden = 0;
	
	public OrdenDeCompra(long usuario_id, long productos_id, Date fecha, Double total) {
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

	public long getUsuario_id() {
		return usuario_id;
	}// getUsuario

	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
	}//setUsuario

	public long getProductos_id() {
		return productos_id;
	}//getProductos

	public void setProductos_id(long productos_id) {
		this.productos_id = productos_id;
	}//setProductos

	public Date getFecha() {
		return fecha;
	}//getFecha

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}//setFecha

	public Double getTotal() {
		return total;
	}//getTotal

	public void setTotal(Double total) {
		this.total = total;
	}//setTotal

	public long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "OrdenDeCompra [id=" + id + ", usuario_id=" + usuario_id + ", productos_id=" + productos_id + ", fecha="
				+ fecha + ", total=" + total + "]";
	}//toString
	
}//class OrdenDeCompra
