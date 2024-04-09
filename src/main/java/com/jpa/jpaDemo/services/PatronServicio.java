package com.jpa.jpaDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.jpaDemo.entities.Patron;
import com.jpa.jpaDemo.repositories.PatronRepositorio;

@Service
public class PatronServicio {
	
	@Autowired
	PatronRepositorio patronRepositorio ;
	
	public Patron findById(Long id) {
		return patronRepositorio.findById(id).get();
	}
	
	public List<Patron> findAll(){
		return patronRepositorio.findAll();
	}
	
	public void updatePatron(Long id,PatronServicio NuevosDatos) {
		
	}
	
	public void subirPatron(Patron patron) {
		patronRepositorio.save(patron);
	}
	
	public void deletePatron(Long id) {
		patronRepositorio.deleteById(id);
	}
}