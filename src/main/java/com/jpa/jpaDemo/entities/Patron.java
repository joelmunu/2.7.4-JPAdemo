package com.jpa.jpaDemo.entities;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Validated
@Data
public class Patron {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPatron;
	
	@Basic
	@Column(nullable = false)
    private String nombre;
	
	@Column(nullable = false)
    private String apellido;
	
    private String direccion;
	
    @Column(nullable = false)
    private String telefono;
    
    private String email;
    
    @JsonIgnore
    @OneToOne(
    		mappedBy = "patron")
    private Salida salida;
}