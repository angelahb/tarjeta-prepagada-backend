package com.tarjeta.prepagada.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarjeta.prepagada.model.Cliente;
import com.tarjeta.prepagada.model.Compras;
import com.tarjeta.prepagada.respository.ClienteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cliente")
public class ClienteController {

	
	private ClienteRepository cliRepository;
	
	public ClienteController(ClienteRepository cliRepository) {
		this.cliRepository = cliRepository;
	}
	
	@RequestMapping(value="/listarClientes", method = RequestMethod.GET)
	public List<Cliente> listarClientes() {
		List<Cliente> listCliente = cliRepository.findAll();
		//System.out.println(listCliente);
		return listCliente;
	}
	
	
	@RequestMapping(value="/guardarCliente", method=RequestMethod.POST)
	public Cliente guardarCliente(@RequestBody Cliente cli) {
		Cliente guardarCli = cliRepository.save(cli);			
		return guardarCli;
	}
	
	@RequestMapping(value="/editarCliente/{cuentaNro}", method = RequestMethod.PUT)
	public Cliente editarCliente(@PathVariable Long cuentaNro, @RequestBody Cliente cli) {
		Cliente editCli = cliRepository.findById(cuentaNro).get();
		editCli.setCliente(cli.getCliente());
		editCli.setSaldo(cli.getSaldo());
		editCli.setEstado(cli.getEstado());
		
		cliRepository.save(editCli);
		return editCli;
	}
	
	@RequestMapping(value="/obtenerCliente/{cuentaNro}", method = RequestMethod.GET)
	public Cliente obtenerCliente(@PathVariable Long cuentaNro) {
		Cliente obtCli = cliRepository.findById(cuentaNro).get();
		return obtCli;
	}
	
	@RequestMapping(value="/eliminarCliente/{cuentaNro}", method = RequestMethod.DELETE)
	public void  eliminarCliente(@PathVariable Long cuentaNro) {
		cliRepository.deleteById(cuentaNro);
	}
}





