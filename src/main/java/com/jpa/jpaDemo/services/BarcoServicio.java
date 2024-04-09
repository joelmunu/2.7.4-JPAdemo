package com.jpa.jpaDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jpa.jpaDemo.entities.Barco;
import com.jpa.jpaDemo.entities.Salida;
import com.jpa.jpaDemo.entities.Socio;
import com.jpa.jpaDemo.repositories.BarcoRepositorio;
import com.jpa.jpaDemo.repositories.SalidaRepositorio;
import com.jpa.jpaDemo.repositories.SocioRepositorio;

@Service
public class BarcoServicio {
	
	@Autowired
	SocioRepositorio socioRepositorio;
	
	@Autowired
	BarcoRepositorio barcoRepositorio ;
	
	@Autowired
	SalidaRepositorio salidaRepositorio ;

	public Barco findById(Long id) {
		return barcoRepositorio.findById(id).get();
	}
	
	public List<Barco> findAll(){
		return barcoRepositorio.findAll();
	}
	
	public ResponseEntity<String> crearBarco(Barco barco) {
		barcoRepositorio.save(barco);
		return ResponseEntity.status(HttpStatus.CREATED).body("Se ha creado el barco");
	}
	
	public String actualizarBarco(Long id,Barco NuevosDatos) {
		try {
			Barco barco = barcoRepositorio.findById(id).get();
			StringBuilder datoModificado = new StringBuilder();

		if ((NuevosDatos.getNumeroMatricula()!= null)) {
			barco.setNumeroMatricula(NuevosDatos.getNumeroMatricula());
			datoModificado.append("Se ha modificado la matricula");
			System.out.println("1");
		}

		if (!(NuevosDatos.getNombre().isEmpty() || NuevosDatos.getNombre()== null)) {
			barco.setNombre(NuevosDatos.getNombre());
			datoModificado.append("Se ha modificado el nombre ");
			System.out.println("2");
		}

		if (NuevosDatos.getSocio()!= null) {
			barco.setSocio(NuevosDatos.getSocio());
			datoModificado.append("Se ha modificado el socio ,");
			System.out.println("3");
		}

		if (NuevosDatos.getSalida()!= null) {
			barco.setSalida(NuevosDatos.getSalida());
			datoModificado.append("Se ha modificado la salida ");
			System.out.println("4");
		}
		
		barcoRepositorio.save(barco);
		return datoModificado.toString();
		} catch (Exception e) {
			return e.getMessage() + "error";
		}
	}
	
	public void deleteBarco(Long id) {
		Barco barco = barcoRepositorio.findById(id).get();
		barco.setSocio(null);
		barcoRepositorio.save(barco);
		barcoRepositorio.deleteById(id);
	}
	
	public String asignarSocio(Long idBarco,Long IdSocio) {
		try {
			Barco barco = barcoRepositorio.findById(idBarco).get();
			Socio socio = socioRepositorio.findById(IdSocio).get();
			barco.setSocio(socio);
			barcoRepositorio.save(barco);
			return "OK";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String crearSalida(Long idBarco,Long idSalida) {
		try {
			Barco barco = barcoRepositorio.findById(idBarco).get();
		    Salida salida = salidaRepositorio.findById(idSalida).get();
		    barco.setSalida(salida);
		    barcoRepositorio.save(barco);
		    return "Se ha creado la salida";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}