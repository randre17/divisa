package com.moneda.ws.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneda.bean.MonedaBean;
import com.moneda.bean.ResponseBean;
import com.moneda.bean.User;
import com.moneda.exception.RecordNotFoundException;
import com.moneda.model.MonedaEntity;
import com.moneda.service.MonedaService;

@RestController
@RequestMapping("/divisa/v1")
public class MonedaRestService {
	@Autowired
	MonedaService service;

	@GetMapping
	public ResponseEntity<List<MonedaEntity>> getDivisas() {
		System.out.println("Inicio - getDivisas");
		List<MonedaEntity> list = service.obtenerDivisas();
		return new ResponseEntity<List<MonedaEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MonedaEntity> getDivisaById(@PathVariable("id") Long id) throws RecordNotFoundException {
		System.out.println("Inicio - getDivisaById: " + id);
		MonedaEntity entity = service.obtenerDivisaId(id);
		return new ResponseEntity<MonedaEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/registro")
	public ResponseEntity<MonedaEntity> createUpdateDivisa(@Valid @RequestBody MonedaEntity moneda) throws RecordNotFoundException {
		System.out.println("Inicio - createUpdateDivisa");
		MonedaEntity updated = service.crearActualizarDivisa(moneda);
		return new ResponseEntity<MonedaEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{id}")
	public HttpStatus deleteDivisaById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.eliminarDivisaId(id);
		return HttpStatus.OK;
	}

	@GetMapping("cambiodivisas/origen/{origen}/destino/{destino}/monto/{monto}")
	public ResponseEntity<ResponseBean> getDivisaByTipoCambio(@PathVariable(value = "origen") Integer origen,
			@PathVariable(value = "destino") Integer destino, @PathVariable(value = "monto") double monto)
			throws Exception {
		ResponseBean response = service.obtenerTipoCambio(origen, destino, monto);
		return new ResponseEntity<ResponseBean>(response, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/agregarmonedas")
	public ResponseEntity<Integer> createDivisaList(@Valid @RequestBody List<MonedaEntity> lstMoneda)
			throws RecordNotFoundException {
		int updated = service.crearListaDivisas(lstMoneda);
		return new ResponseEntity<Integer>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
//	@PostMapping("user")
//	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
//		
//		String token = getJWTToken(username);
//		User user = new User();
//		user.setUser(username);
//		user.setToken(token);		
//		return user;
//		
//	}

}