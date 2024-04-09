package com.jpa.jpaDemo.entities;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Validated
@Data
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSocio;
	
	@Basic
	@Column(nullable = false)
    private String nombre;
	
	@Column(nullable = false)
    private String apellido;
	
    private String direccion;
	
    @Column(nullable = false)
    private String telefono;
    
    private String email;
    
    @OneToMany(
    		cascade = CascadeType.ALL,
    		fetch = FetchType.EAGER)
    private List<Barco> barcos;
}