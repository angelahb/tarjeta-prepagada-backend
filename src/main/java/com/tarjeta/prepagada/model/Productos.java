package com.tarjeta.prepagada.model;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productoNro")
	private Long productoNro;
	
	@Column(name="producto")
	private String producto;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="precio")
	private Double precio;

	public Long getProductoNro() {
		return productoNro;
	}

	public void setProductoNro(Long productoNro) {
		this.productoNro = productoNro;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Productos(Long productoNro, String producto, Integer cantidad, Double precio) {
		super();
		this.productoNro = productoNro;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public Productos() {

	}

	@Override
	public String toString() {
		return "Productos [productoNro=" + productoNro + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", getProductoNro()=" + getProductoNro() + ", getProducto()=" + getProducto()
				+ ", getCantidad()=" + getCantidad() + ", getPrecio()=" + getPrecio() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
