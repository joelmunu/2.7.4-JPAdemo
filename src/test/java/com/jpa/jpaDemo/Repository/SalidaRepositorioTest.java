package com.jpa.jpaDemo.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.jpaDemo.entities.Salida;
import com.jpa.jpaDemo.repositories.SalidaRepositorio;

@SpringBootTest
public class SalidaRepositorioTest {

    @Autowired
    SalidaRepositorio salidaRepositorio;

    @Test
    void anyadirSalida(){
        Salida salida =  new Salida();
        salida.setHora("2 am");
        salida.setDestino("Singapur");
        salida.setFecha("22 abil");
        salidaRepositorio.save(salida);
        
    }

    @Test
    void deleteById(){
        Long id = 1L;
        if (salidaRepositorio.existsById(id)) {
            salidaRepositorio.deleteById(id);
        }else{throw new IllegalArgumentException("No se pudo encontrar este Id");}
    }
}