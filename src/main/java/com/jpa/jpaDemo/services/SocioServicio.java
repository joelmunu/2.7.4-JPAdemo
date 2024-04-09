package com.jpa.jpaDemo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jpa.jpaDemo.entities.Socio;
import com.jpa.jpaDemo.repositories.SocioRepositorio;

@Service
public class SocioServicio {
	
	@Autowired
	SocioRepositorio socioRepositorio ;
	
	public Socio findById(Long id) {
		return socioRepositorio.findById(id).get();
	}
	
	public List<Socio> findAll(){
		return socioRepositorio.findAll();
	}
	
	public ResponseEntity<String> crearSocio(Socio socio) {
		socioRepositorio.save(socio);
		return ResponseEntity.status(HttpStatus.CREATED).body("Se ha creado el socio");
	}
	
	public String actualizarSocio(Long id,Socio NuevosDatos) {
		try {
			Socio socio = socioRepositorio.findById(id).get();
			StringBuilder datoModificado = new StringBuilder();

		if (!(NuevosDatos.getApellido().isEmpty() || NuevosDatos.getApellido()== null)) {
			socio.setApellido(NuevosDatos.getApellido());
			datoModificado.append("modificado apellido ");
			System.out.println("1");
		}

		if (!(NuevosDatos.getNombre().isEmpty() || NuevosDatos.getNombre()== null)) {
			socio.setNombre(NuevosDatos.getNombre());
			datoModificado.append("modificado nombre ");
			System.out.println("2");
		}

		if (!(NuevosDatos.getDireccion().isEmpty() || NuevosDatos.getDireccion()== null)) {
			socio.setDireccion(NuevosDatos.getDireccion());
			datoModificado.append("modificado direccion ,");
			System.out.println("3");
		}

		if (!(NuevosDatos.getTelefono().isEmpty() || NuevosDatos.getTelefono()== null)) {
			socio.setTelefono(NuevosDatos.getTelefono());
			datoModificado.append("modificado direccion ,");
			System.out.println("4");
		}

		if (!(NuevosDatos.getEmail().isEmpty() || NuevosDatos.getEmail()== null)) {
			socio.setEmail(NuevosDatos.getEmail());
			datoModificado.append("modificado direccion ,");
			System.out.println("5");
		}
		
		socioRepositorio.save(socio);
		return datoModificado.toString();
		} catch (Exception e) {
			return e.getMessage() + "error";
		}
	}
	
	public void borrarSocio(Long id) {
		socioRepositorio.deleteById(id);
	}
}