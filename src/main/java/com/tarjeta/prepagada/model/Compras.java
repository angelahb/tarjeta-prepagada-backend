package com.tarjeta.prepagada.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compras")
public class Compras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="compraNro")
	private Long compraNro;
	
	@Column(name="cuentaNro")
	private Long cuentaNro;
	
	@Column(name="compra")
	private Double compra;

	public Long getCompraNro() {
		return compraNro;
	}

	public void setCompraNro(Long compraNro) {
		this.compraNro = compraNro;
	}

	public Long getCuentaNro() {
		return cuentaNro;
	}

	public void setCuentaNro(Long cuentaNro) {
		this.cuentaNro = cuentaNro;
	}

	public Double getCompra() {
		return compra;
	}

	public void setCompra(Double compra) {
		this.compra = compra;
	}

	public Compras(Long compraNro, Long cuentaNro, Double compra) {
		super();
		this.compraNro = compraNro;
		this.cuentaNro = cuentaNro;
		this.compra = compra;
	}

	public Compras() {

	}

	@Override
	public String toString() {
		return "Compras [compraNro=" + compraNro + ", cuentaNro=" + cuentaNro + ", compra=" + compra
				+ ", getCompraNro()=" + getCompraNro() + ", getCuentaNro()=" + getCuentaNro() + ", getCompra()="
				+ getCompra() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
