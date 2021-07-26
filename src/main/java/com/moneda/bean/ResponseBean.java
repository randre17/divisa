package com.moneda.bean;

public class ResponseBean {

	private double montoOrigen;
	private double montoAlCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;

	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public String getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	public double getMontoOrigen() {
		return montoOrigen;
	}
	public void setMontoOrigen(double montoOrigen) {
		this.montoOrigen = montoOrigen;
	}
	public double getMontoAlCambio() {
		return montoAlCambio;
	}
	public void setMontoAlCambio(double montoAlCambio) {
		this.montoAlCambio = montoAlCambio;
	}
	public double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	@Override
    public String toString() {
        return "TipoCambio [monedaOrigen=" + monedaOrigen + ", monedaDestino=" + monedaDestino +
                ", montoAlCambio=" + montoAlCambio + ", montoOrigen=" + montoOrigen + ", tipoCambio=" + tipoCambio  + "]";
    }
}