package org.generation.amorPeludo.service;

import java.util.ArrayList;
import java.util.List;

import org.generation.amorPeludo.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductosService {
	public final ArrayList<Productos> lista = new ArrayList <>();
	@Autowired
	public ProductosService() {
		lista.add(new Productos("Alcancía personalizada", 150.00, 
				"Una alcancía adorable y personalizada, diseñada con la imagen de tu mascota, que te inspirará a ahorrar para mimarlo con más cariño.", 
				"/src/img/imgProductos/producto_1A.png", "/src/img/imgProductos/producto_1B.png"));	
		lista.add(new Productos("Collar para recordar", 100.00, 
				"Conmemora a tu mascota con este collar de recuerdo, elije entre una urna para guardar pelito o un dije para almacenar las cenizas de tu compañero más fiel.", 
				"/src/img/imgProductos/producto_2A.png", "/src/img/imgProductos/producto_2B.png"));
		lista.add(new Productos("Urna para pelitos de felicidad", 110.00, 
				"Guarda los preciados pelitos de tu mascota en nuestra hermosa urna de madera personalizable. Cada urna está diseñada con amor para honrar a tu compañero peludo de manera especial.", 
				"/src/img/imgProductos/producto_3A.png", "/src/img/imgProductos/producto_3B.png"));
		lista.add(new Productos("Bordado personalizada", 130.00, 
				"Crea un tributo único para tu mascota. Personaliza con su imagen y/o nombre en un telar artesanal circular de 15 cm. Un recuerdo especial para siempre.", 
				"/src/img/imgProductos/producto_4A.png", "/src/img/imgProductos/producto_4B.png"));
		lista.add(new Productos("Estatuilla de vidrio llena de amor", 180.00, 
				"Captura la esencia de tu compañero peludo. Una exquisita estatuilla de vidrio soplado con el pelo de tu mascota en su interior.", 
				"/src/img/imgProductos/producto_5A.png", "/src/img/imgProductos/producto_5B.png"));
		lista.add(new Productos("Figura con textura felting", 90.00, 
				"Celebra a tu mascota con arte único. Adquiere figuras hechas a mano con la técnica felting, que capturan su personalidad en detalles texturizados.", 
				"/src/img/imgProductos/producto_6A.png", "/src/img/imgProductos/producto_6B.png"));
		lista.add(new Productos("Llavero para recordar", 100.00, 
				"Lleva a tu amado compañero siempre contigo. Un llavero diseñado para guardar un pequeño recuerdo de sus cenizas o pelo, manteniendo su memoria viva en cada paso.", 
				"/src/img/imgProductos/producto_7A.png", "/src/img/imgProductos/producto_7B.png"));
		lista.add(new Productos("Figura de cerámica", 180.00, 
				"Inmortaliza la imagen de tu mascota en una hermosa figura de cerámica, creada con amor y cuidado. Un recuerdo para toda la vida.", 
				"/src/img/imgProductos/producto_8A.png", "/src/img/imgProductos/producto_8B.png"));
		lista.add(new Productos("Cuadro con textura felting", 130.00, 
				"Un retrato único lleno de ternura. Cada detalle de tu mascota se captura con la técnica felting en un cuadro de arte texturizado.", 
				"/src/img/imgProductos/producto_9A.png", "/src/img/imgProductos/producto_9B.png"));
		lista.add(new Productos("Almohada con fotografía impresa", 105.00, 
				"Abraza los recuerdos. Personaliza una suave almohada con la fotografía de tu mascota impresa, para sentir su amor en cada abrazo.", 
				"/src/img/imgProductos/producto_10A.png", "/src/img/imgProductos/producto_10B.png"));
		lista.add(new Productos("Llavero con fotografía", 110.00, 
				"Lleva a tu compañero siempre contigo. Un llavero con la fotografía de tu amada mascota y una placa grabada con su nombre, une lo mejor de dos mundos en un accesorio único.", 
				"/src/img/imgProductos/producto_11A.png", "/src/img/imgProductos/producto_11B.png"));
		lista.add(new Productos("Case con pulsera", 150.00, 
				"Lleva tu amor por tu compañero a todas partes. Un case para celular que puedes personalizar con la imagen de tu mascota y viene con una pulsera a juego.", 
				"/src/img/imgProductos/producto_12A.png", "/src/img/imgProductos/producto_12B.png"));
		
	} // Constructor 
	
	public List <Productos> getAllProductos() {
		return this.lista;
	} //getAllProductos
	
	public Productos getProducto(Long id) {
		Productos tmp=null;
		for (Productos producto : lista) {
			if(producto.getId().equals(id)){
				tmp=producto;
				break;
			}//if
		}//foreach
		return tmp;
	} // getProducto

	public Productos delteProducto(Long id) {
		Productos tmp=null;
		for (Productos producto : lista) {
			if(producto.getId().equals(id)){
				tmp= lista.remove(lista.indexOf(producto));
				break;
			}//if
		}//foreach
		return tmp;
	} // deleteProducto

	public Productos addProducto(Productos producto) {
		lista.add(producto);
		return null;
	} // addProducto

	public Productos updateProducto(Long id,String tittle, Double price, String description, String img1, String img2) {
		
		Productos tmp=null;
		for (Productos producto : lista) {
			if(producto.getId().equals(id)){
				if(tittle!=null) producto.setTittle(tittle);
				if(price!=null) producto.setPrice(price);
				if(description!=null) producto.setDescription(description);
				if(img1!=null) producto.setImg1(img1);
				if(img2!=null) producto.setImg2(img2);
				tmp= producto;
				break;
			}//if
		}//foreach
		return tmp;
	}

} // class ProductosService
