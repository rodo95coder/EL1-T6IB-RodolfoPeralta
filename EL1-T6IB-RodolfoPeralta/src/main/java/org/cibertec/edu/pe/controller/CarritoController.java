package org.cibertec.edu.pe.controller;
import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.ICarritoService;
import org.cibertec.edu.pe.modelo.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CarritoController {
	
	@Autowired
	private ICarritoService servicio;
	
	// Método para Listar
	@GetMapping("/listar")	// http://localhost:8080/listar
	public String Listado(Model m) {
		List<Carrito> lista = servicio.Listar();
		m.addAttribute("Carrito", lista);
		return "listado";	// listado.html
	}
	
	// Método para Buscar
	@GetMapping("/ver/{id}") // http://localhost:8080/ver/1
	public String Buscar(@PathVariable String id,Model m) {
		Optional<Carrito> ObjC = servicio.Buscar(id);
		m.addAttribute("colaborador", ObjC);
		return "ver";		// ver.html
	}
	
	// Método para insertar
	@GetMapping("/nuevo")
	public String agregar(Model m) {
		m.addAttribute("colaborador",new Carrito());
		return "form";		// form.html
	}
	
	// Método para salvar
	@PostMapping("/salvar")
	public String salvar(@Validated Carrito ObjC, Model m) {
		servicio.Grabar(ObjC);
		return "redirect:/listar";
	}
	
	// Método para editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable String id, Model m) {
		Optional<Carrito> ObjC = servicio.Buscar(id);
		m.addAttribute("colaborador", ObjC);
		return "form";		// form.html
	}
	
	// Método para eliminar
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable String id, Model m) {
		servicio.Suprimir(id);
		return "redirect:/listar";		// form.html
	}
}
