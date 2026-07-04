package com.example.micro_mensajeria.gestionMensajeria.repository;

import com.example.micro_mensajeria.gestionMensajeria.model.entities.Mensajeria;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface MensajeriaRepository extends JpaRepository<Mensajeria, Integer> {

    List<Mensajeria> findByCorreoReceptor(String correoReceptor);

    List<Mensajeria> findByCorreoEmisor(String correoEmisor);

}