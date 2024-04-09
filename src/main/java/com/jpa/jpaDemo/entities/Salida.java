package com.jpa.jpaDemo.entities;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Validated
@Data
public class Salida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSalida;
	private String hora;
    private String fecha;
    private String destino;
   
    
    @OneToOne(
    		mappedBy = "salida",
    		fetch = FetchType.EAGER)
    private Barco barco;
    
    
    @JsonIgnore
    @OneToOne
    @JoinColumn(
    		name = "patron",
    		referencedColumnName = "idPatron")
    private Patron patron;
}