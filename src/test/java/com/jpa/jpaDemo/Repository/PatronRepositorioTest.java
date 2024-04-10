package com.jpa.jpaDemo.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.jpaDemo.entities.Patron;
import com.jpa.jpaDemo.repositories.PatronRepositorio;

@SpringBootTest
public class PatronRepositorioTest {

    @Autowired
    PatronRepositorio patronRepositorio;

    @Test
    void anyadirPatron(){
        Patron patron =  new Patron();
        patron.setNombre("test");
        patron.setApellido("test");
        patron.setDireccion("test");
        patron.setEmail("test@gmail.com");
        patron.setTelefono("11111111");
        patronRepositorio.save(patron);
        
    }

    @Test
    void deleteById(){
        Long id = 1L;
        if (patronRepositorio.existsById(id)) {
            patronRepositorio.deleteById(id);
        }else{throw new IllegalArgumentException("No se pudo encontrar este Id");}
    }
}