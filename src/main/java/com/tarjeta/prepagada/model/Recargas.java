package com.tarjeta.prepagada.model;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="recargas")
public class Recargas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="recargaNro")
	private Long recargaNro;
	
	@Column(name="cuentaNro")
	private Long cuentaNro;
	
	@Column(name="recarga")
	private Double recarga;

	@Column(name="fecha")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp fecha;

	public Long getRecargaNro() {
		return recargaNro;
	}

	public void setRecargaNro(Long recargaNro) {
		this.recargaNro = recargaNro;
	}

	public Long getCuentaNro() {
		return cuentaNro;
	}

	public void setCuentaNro(Long cuentaNro) {
		this.cuentaNro = cuentaNro;
	}

	public Double getRecarga() {
		return recarga;
	}

	public void setRecarga(Double recarga) {
		this.recarga = recarga;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Recargas(Long recargaNro, Long cuentaNro, Double recarga, Timestamp fecha) {
		super();
		this.recargaNro = recargaNro;
		this.cuentaNro = cuentaNro;
		this.recarga = recarga;
		this.fecha = fecha;
	}

	public Recargas() {

	}

	@Override
	public String toString() {
		return "Recargas [recargaNro=" + recargaNro + ", cuentaNro=" + cuentaNro + ", recarga=" + recarga + ", fecha="
				+ fecha + ", getRecargaNro()=" + getRecargaNro() + ", getCuentaNro()=" + getCuentaNro()
				+ ", getRecarga()=" + getRecarga() + ", getFecha()=" + getFecha() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
