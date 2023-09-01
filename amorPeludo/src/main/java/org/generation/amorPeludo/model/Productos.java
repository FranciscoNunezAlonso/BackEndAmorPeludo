package org.generation.amorPeludo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id",unique=true, nullable=false)
	private Long id;
	@Column (nullable=false)
	private String title;
	@Column (nullable = false)
	private Double price;
	@Column (nullable = false)
	private String description;
	@Column (nullable = false)
	private String img1;
	@Column (nullable = false)
	private String img2;

	
	public Productos(String title, Double price, String description, String img1, String img2) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.img1 = img1;
		this.img2 = img2;
	} // constructor

	
	public Productos() {
	} // constructor vacio

	// GETTERS Y SETTERS
	public String getTitle() {
		return title;
	} //getTitle

	public void setTitle(String title) {
		this.title = title;
	} // setTitle

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
		return "Productos [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description
				+ ", img1=" + img1 + ", img2=" + img2 + "]";
	}//toString
	
		
} // class Productos
