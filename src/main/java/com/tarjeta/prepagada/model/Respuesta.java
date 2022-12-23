package com.tarjeta.prepagada.model;

public class Respuesta {

	private String respuesta;
	private Boolean flag;
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public Respuesta(String respuesta, Boolean flag) {
		super();
		this.respuesta = respuesta;
		this.flag = flag;
	} 

}
