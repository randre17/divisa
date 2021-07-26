package com.moneda.bean;

public class MonedaBean {

	private String divisa;
	private String descripcion;
	private double tipocambio;

	public String getDivisa() {
		return divisa;
	}

	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(double tipocambio) {
		this.tipocambio = tipocambio;
	}

	@Override
	public String toString() {
		return "TipoCambio [divisa=" + divisa + ", descripcion=" + descripcion + ", tipocambio=" + tipocambio + "]";
	}
}