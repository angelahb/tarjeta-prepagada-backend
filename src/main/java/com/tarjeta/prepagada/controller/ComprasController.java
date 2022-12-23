package com.tarjeta.prepagada.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarjeta.prepagada.model.Cliente;
import com.tarjeta.prepagada.model.Compras;
import com.tarjeta.prepagada.model.Respuesta;
import com.tarjeta.prepagada.respository.ClienteRepository;
import com.tarjeta.prepagada.respository.ComprasRepository;

@RestController
@RequestMapping(value = "compras")
public class ComprasController {

	private ComprasRepository compRepository;
	private ClienteRepository cliRepository;
	
	public ComprasController(ComprasRepository compRepository, ClienteRepository cliRepository) {
		this.compRepository = compRepository;
		this.cliRepository = cliRepository;
	}
	
	@RequestMapping(value="/listarCompras", method = RequestMethod.GET)
	public List<Compras> listarCompras(){
		List<Compras> listComprass = compRepository.findAll();
		return listComprass;
	}
	
	@RequestMapping(value="/guardarCompras", method = RequestMethod.POST)
	public Respuesta guardarCompras(@RequestBody Compras comp) {

		Respuesta respuesta = new Respuesta(null, null);
		
		Cliente editCli = cliRepository.findById(comp.getCuentaNro()).get();
		Double compra = comp.getCompra();
		Double saldoCuenta = editCli.getSaldo();
		
		if (saldoCuenta >= compra) {
			Compras guardaCompra = compRepository.save(comp);
			editCli.setSaldo(saldoCuenta - compra);			
			cliRepository.save(editCli);
			respuesta.setRespuesta("Compra Aprobada");
			respuesta.setFlag(true);
		}else {
			respuesta.setRespuesta("Saldo Insuficiente");
			respuesta.setFlag(false);
		}

		
		return respuesta;
	}
	
	@RequestMapping(value="/historicoCompras/{cuentaNro}")
	public List<Compras> historicoCompras(@PathVariable Long cuentaNro){
		List<Compras> obtCompras = compRepository.findBycuentaNro(cuentaNro);
		return obtCompras;
	}
	
}
