package org.generation.amorPeludo.model;

public class Productos {

	private Long id;
	private String tittle;
	private Double price;
	private String description;
	private String img1;
	private String img2;
	private static long total = 0;
	
	public Productos(String tittle, Double price, String description, String img1, String img2) {
		super();
		this.tittle = tittle;
		this.price = price;
		this.description = description;
		this.img1 = img1;
		this.img2 = img2;
		Productos.total++;
		this.id=Productos.total;	
	} // constructor

	public Productos() {
		super();
		Productos.total++;
		this.id=Productos.total;	
	} // constructor vacio

	public String getTittle() {
		return tittle;
	} //getTittle

	public void setTittle(String tittle) {
		this.tittle = tittle;
	} // setTittle

	public Double getPrice() {
		return price;
	} // getPrice

	public void setPrice(Double price) {
		this.price = price;
	} //setPrice

	public String getDescription() {
		return description;
	} // getDescription

	public void setDescription(String description) {
		this.description = description;
	} //setDescription

	public String getImg1() {
		return img1;
	} // getImg1

	public void setImg1(String img1) {
		this.img1 = img1;
	} //setImg1

	public String getImg2() {
		return img2;
	} //getImg2

	public void setImg2(String img2) {
		this.img2 = img2;
	} //setImg2

	public Long getId() {
		return id;
	} //getId

	@Override
	public String toString() {
		return "Productos [id=" + id + ", tittle=" + tittle + ", price=" + price + ", description=" + description
				+ ", img1=" + img1 + ", img2=" + img2 + "]";
	}
	
	
		
} // class Productos
