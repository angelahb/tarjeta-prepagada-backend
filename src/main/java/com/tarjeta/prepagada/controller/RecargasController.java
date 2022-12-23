package com.tarjeta.prepagada.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarjeta.prepagada.model.Cliente;
import com.tarjeta.prepagada.model.Recargas;
import com.tarjeta.prepagada.model.Respuesta;
import com.tarjeta.prepagada.respository.ClienteRepository;
import com.tarjeta.prepagada.respository.RecargasRepository;

@RestController
@RequestMapping("/recargas")
public class RecargasController {
	
	private RecargasRepository recRepository;
	private ClienteRepository cliRepository;
	
	public RecargasController(RecargasRepository recRepository, ClienteRepository cliRepository) {
		this.recRepository = recRepository;
		this.cliRepository = cliRepository; 
	}
	
	@RequestMapping(value="/listarRecargas", method = RequestMethod.GET)
	public List<Recargas> listarRecargas(){
		List<Recargas> listRecargas = recRepository.findAll();
		//System.out.println(listRecargas);
		return listRecargas;
	}
	
	@RequestMapping(value="/guardarRecarga", method = RequestMethod.POST)
	public Respuesta guardarRecarga(@RequestBody Recargas rec) {
		
		Respuesta respuesta = new Respuesta(null, null);
		
		Date date = new Date();
		Timestamp timestamp2  = new Timestamp(date.getTime());
		rec.setFecha(timestamp2);
		
		Cliente editCli = cliRepository.findById(rec.getCuentaNro()).get();		
		Boolean estado = editCli.getEstado();
		Double recarga = rec.getRecarga();
		Double saldoCuenta = editCli.getSaldo();

		if (estado == true ) {
			Recargas guardaRecarga = recRepository.save(rec);
			
			editCli.setSaldo(recarga + saldoCuenta);
			
			cliRepository.save(editCli);
			respuesta.setRespuesta("Recarga satisfactoria, Nuevo Saldo: " + saldoCuenta);
			respuesta.setFlag(true);
		} else {
			respuesta.setRespuesta("Cliente inactivo, no se pudo realizar la recarga");
			respuesta.setFlag(false);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/historicoRecargas/{cuentaNro}", method = RequestMethod.GET)
	public List<Recargas> historicoRecargas(@PathVariable Long cuentaNro) {
		List<Recargas> obtRecargas = recRepository.findBycuentaNro(cuentaNro);
		return obtRecargas;
	}
}
