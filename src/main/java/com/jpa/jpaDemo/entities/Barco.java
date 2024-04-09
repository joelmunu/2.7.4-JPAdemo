package com.jpa.jpaDemo.entities;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Validated
@Data
public class Barco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBarco;
	
	@Basic
	@Column(nullable = false)
    private String numeroMatricula;
	
    private String nombre;
	
    private int numeroAmarre;
    private double cuota; 
    
    @OneToOne
    @JoinColumn(
    		name = "salida",
    		referencedColumnName = "idSalida")
    @JsonIgnore
    private Salida salida;
    
    @ManyToOne
    @JoinColumn(
    		name = "idSocio",
    		referencedColumnName = "idSocio")
    @JsonIgnore
    private Socio socio;
}