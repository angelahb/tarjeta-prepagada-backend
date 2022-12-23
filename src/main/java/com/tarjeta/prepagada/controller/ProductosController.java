package com.tarjeta.prepagada.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarjeta.prepagada.model.Productos;
import com.tarjeta.prepagada.respository.ProductosRepository;



@RestController
@RequestMapping("/productos")
public class ProductosController {

	private ProductosRepository prodRepository;
	
	public ProductosController(ProductosRepository prodRepository) {
		this.prodRepository = prodRepository;
	}
	
	@RequestMapping(value="/listarProductos", method = RequestMethod.GET)
	public List<Productos> listarProductos(){
		List<Productos> listProductos = prodRepository.findAll();
		//System.out.println(listProductos);
		return listProductos;
	}
	
	@RequestMapping(value = "/guardarProducto", method = RequestMethod.POST)
	public Productos guardarProducto(@RequestBody Productos prod) {
		Productos guardarProd = prodRepository.save(prod);
		return guardarProd;
	}
	
	@RequestMapping(value="/editarProducto/{productoNro}", method = RequestMethod.PUT)
	public Productos editarProducto(@PathVariable Long productoNro, @RequestBody Productos prod) {
		Productos editProd = prodRepository.findById(productoNro).get();
		editProd.setProducto(prod.getProducto());
		editProd.setPrecio(prod.getPrecio());
		editProd.setCantidad(prod.getCantidad());
		
		prodRepository.save(editProd);
		return editProd;
	}
	
	@RequestMapping(value="/obtenerProducto/{productoNro}", method = RequestMethod.GET)
	public Productos obtenerProducto(@PathVariable Long productoNro) {
		Productos obtenerProd = prodRepository.findById(productoNro).get();
		return obtenerProd;
	}
	
	@RequestMapping(value="/eliminarProducto/{productoNro}", method = RequestMethod.DELETE)
	public void eliminarProducto(@PathVariable Long productoNro) {
		prodRepository.deleteById(productoNro);
	}
	
}


