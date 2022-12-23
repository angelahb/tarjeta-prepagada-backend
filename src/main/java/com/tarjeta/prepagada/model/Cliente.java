package com.tarjeta.prepagada.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cuentaNro")
	private Long cuentaNro;
	
	@Column(name="cliente")
	private String cliente;
	
	@Column(name="saldo")
	private Double saldo;
	
	@Column(name="estado")
	private Boolean estado;

	public Long getCuentaNro() {
		return cuentaNro;
	}

	public void setCuentaNro(Long cuentaNro) {
		this.cuentaNro = cuentaNro;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Cliente(Long cuentaNro, String cliente, Double saldo, Boolean estado) {
		super();
		this.cuentaNro = cuentaNro;
		this.cliente = cliente;
		this.saldo = saldo;
		this.estado = estado;
	}

	public Cliente() {

	}

	@Override
	public String toString() {
		return "Cliente [cuentaNro=" + cuentaNro + ", cliente=" + cliente + ", saldo=" + saldo + ", estado=" + estado
				+ ", getCuentaNro()=" + getCuentaNro() + ", getCliente()=" + getCliente() + ", getSaldo()=" + getSaldo()
				+ ", getEstado()=" + getEstado() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}


