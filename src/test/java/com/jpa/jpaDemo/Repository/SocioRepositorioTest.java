package com.jpa.jpaDemo.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.jpaDemo.entities.Socio;
import com.jpa.jpaDemo.repositories.SocioRepositorio;

@SpringBootTest
public class SocioRepositorioTest {
    
    @Autowired
    SocioRepositorio socioRepositorio;

    @Test
    void anyadirSocio(){
        Socio patron =  new Socio();
        patron.setNombre("Test");
        patron.setApellido("Test");
        patron.setDireccion("Test");
        patron.setEmail("Test");
        patron.setTelefono("Test");
        socioRepositorio.save(patron); 
    }

    @Test
    void modificarSocio(){
        Long id = 1L;
        Socio socio = socioRepositorio.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontro el barco con id" + id));
        socio.setNombre("Nuevo Dato");
        socio.setApellido("Nuevo apellido");
        socio.setTelefono("555555555");
        socioRepositorio.save(socio);
    }


    @Test
    void getSocioByName(){

        Socio socio = socioRepositorio.getSocioByName("Nuevo Dato");
        
        socio.toString();

    }

    @Test
    void deleteById(){
        Long id = 1L;
        if (socioRepositorio.existsById(id)) {
            socioRepositorio.deleteById(id);
        }else{throw new IllegalArgumentException("No se pudo encontrar este Id");}
    }
}