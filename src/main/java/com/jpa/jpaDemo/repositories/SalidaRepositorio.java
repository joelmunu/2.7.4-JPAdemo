package com.jpa.jpaDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.jpaDemo.entities.Salida;

@Repository
public interface SalidaRepositorio extends JpaRepository<Salida, Long>{

    @Query("select c from Salida c where c.destino = ?1")
    Salida getSalidaByDestino(String destino);
}