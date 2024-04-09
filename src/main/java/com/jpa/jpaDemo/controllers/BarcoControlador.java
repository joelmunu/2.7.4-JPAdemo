package com.jpa.jpaDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.jpaDemo.entities.Barco;
import com.jpa.jpaDemo.services.BarcoServicio;

@RestController
@RequestMapping("/barcos")
public class BarcoControlador {
		
	@Autowired
	BarcoServicio servicio;
	
	@GetMapping("/all")
	public List<Barco> allBarco(){
		return servicio.findAll();
	}
	
	@GetMapping("/{idBarco}")
	public ResponseEntity<Barco> findById(@PathVariable long idBarco) {
		return ResponseEntity.ok(servicio.findById(idBarco));
	}
	
	@PostMapping()
	public ResponseEntity<String> postBarco(@RequestBody Barco barco){
		return servicio.crearBarco(barco);
	}
	
	@DeleteMapping("/{idBarco}")
	public ResponseEntity<String> borrar(@PathVariable long idBarco) {
		servicio.deleteBarco(idBarco);
		return ResponseEntity.ok("Borrado");
	}
	
	@PutMapping("/asignarSocio/{idBarco}/{idSocio}")
	public String asignarSocio(@PathVariable long idBarco , @PathVariable long idSocio) {
		return servicio.asignarSocio(idBarco, idSocio);
	}
	
	@PutMapping("/{idBarco}")
	public String modificarBarco(@PathVariable long idBarco,@RequestBody Barco barco) {
		return servicio.actualizarBarco(idBarco, barco);
	}
	
	@PutMapping("/crearSalida/{idBarco}/{idSalida}")
	public String crearSalidar(@PathVariable long idBarco , @PathVariable long idSalida) {
		return servicio.crearSalida(idBarco, idSalida);
	}
}