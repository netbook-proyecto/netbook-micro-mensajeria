package com.example.micro_mensajeria.gestionMensajeria.model.entities;

import lombok.Data;
import java.time.LocalDate;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "mensajeria")
public class Mensajeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private Integer idMensaje;

    @Column(name = "correo_emisor", nullable = false)
    private String correoEmisor;

    @Column(name = "correo_receptor", nullable = false)
    private String correoReceptor;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDate fechaEnvio;

    @Column(name = "asunto", nullable = false)
    private String asunto;

    @Column(name = "cuerpo_mensaje", nullable = false, length = 2000)
    private String cuerpoMensaje;

    @Column(name = "estado_lectura", nullable = false)
    private String estadoLectura;

}