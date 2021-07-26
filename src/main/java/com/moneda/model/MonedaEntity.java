package com.moneda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_CAMBIO")
public class MonedaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "divisa")
	private String divisa;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "tipocambio")
	private double tipocambio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return "TipoCambio [id=" + id + ", divisa=" + divisa + ", descripcion=" + descripcion + ", tipocambio="
				+ tipocambio + "]";
	}
}