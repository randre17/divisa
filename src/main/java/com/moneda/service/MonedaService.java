package com.moneda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moneda.bean.MonedaBean;
import com.moneda.bean.ResponseBean;
import com.moneda.exception.RecordNotFoundException;
import com.moneda.model.MonedaEntity;
import com.moneda.repository.MonedaRepository;

@Service
public class MonedaService {

	@Autowired
	MonedaRepository repository;

	public List<MonedaEntity> obtenerDivisas() {
		List<MonedaEntity> lstDivisas = repository.findAll();
		if (lstDivisas.size() > 0) {
			return lstDivisas;
		} else {
			return new ArrayList<MonedaEntity>();
		}
	}

	public MonedaEntity obtenerDivisaId(Long id) throws RecordNotFoundException {
		Optional<MonedaEntity> divisa = repository.findById(id);
		if (divisa.isPresent()) {
			return divisa.get();
		} else {
			throw new RecordNotFoundException("No existen divisas");
		}
	}

	public MonedaEntity crearActualizarDivisa(MonedaEntity entity) throws RecordNotFoundException {
		Optional<MonedaEntity> divisa = repository.findById(entity.getId());
		int count = repository.findAll().size();
		if (divisa.isPresent()) {
			MonedaEntity moneda = divisa.get();
			moneda.setDivisa(entity.getDivisa());
			moneda.setDescripcion(entity.getDescripcion());
			moneda.setTipocambio(entity.getTipocambio());
			moneda = repository.save(moneda);
			return moneda;
		} else {
			entity.setId(new Long(count) + 1);
			entity = repository.save(entity);
			return entity;
		}
	}

	public void eliminarDivisaId(Long id) throws RecordNotFoundException {
		Optional<MonedaEntity> moneda = repository.findById(id);
		if (moneda.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No existe divisa");
		}
	}

	public ResponseBean obtenerTipoCambio(Integer origen, Integer destino, double monto) {

		ResponseBean response = null;
		try {
			MonedaEntity monedaOrigen = obtenerDivisaId(new Long(origen));
			MonedaEntity monedaDestino = obtenerDivisaId(new Long(destino));

			response = new ResponseBean();
			response.setMonedaDestino(monedaDestino.getDivisa());
			response.setMonedaOrigen(monedaOrigen.getDivisa());
			response.setMontoOrigen(monto);

			Double montoTipoCambio = (monto * monedaDestino.getTipocambio()) / monedaOrigen.getTipocambio();
			montoTipoCambio = Math.round(montoTipoCambio * 1000000.0) / 1000000.0;
			response.setMontoAlCambio(montoTipoCambio);

			Double tipoCambio = monedaDestino.getTipocambio() / monedaOrigen.getTipocambio();
			tipoCambio = Math.round(tipoCambio * 1000000.0) / 1000000.0;
			response.setTipoCambio(tipoCambio);

			ObjectMapper mapperJson = new ObjectMapper();
			System.out.println(mapperJson.writeValueAsString(response));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	public int crearListaDivisas(List<MonedaEntity> list) throws RecordNotFoundException {
		MonedaEntity moneda = null;
		int contador = 0;
		System.out.println("Se tiene: " + list.size() + ", monedas para agregar");
		for (int i = 0; i < list.size(); i++) {
			int count = repository.findAll().size();
			list.get(i).setId(new Long(count) + 1);
			moneda = new MonedaEntity();
			moneda = repository.save(list.get(i));
			contador++;
		}
		return contador;

	}
}