package com.jpa.jpaDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.jpaDemo.entities.Socio;
import com.jpa.jpaDemo.services.SocioServicio;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/socios")
public class SocioControlador {
	
	@Autowired
	SocioServicio servicio;

	@GetMapping("/all")
	public List<Socio> allSocio(){
		return servicio.findAll();
	}
	
	@GetMapping("/{idSocio}")
	public ResponseEntity<Socio> findById(@PathVariable long idSocio) {
		return ResponseEntity.ok(servicio.findById(idSocio));
	}
	
	@PostMapping()
	public ResponseEntity<String> postSocio(@RequestBody Socio socio){
		return servicio.crearSocio(socio);
	}
	
	@PutMapping("/{idSocio}")
	public String putMethodName(@PathVariable long idSocio, @RequestBody Socio socio) {
		return servicio.actualizarSocio(idSocio,socio);
	}
	
	@DeleteMapping("/{idSocio}")
	public ResponseEntity<String> borrar(@PathVariable long idSocio) {
		servicio.borrarSocio(idSocio);
		return ResponseEntity.ok("Borrado");
	}
}