package com.example.micro_mensajeria.gestionMensajeria.model.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarMensajeriaRequest {
    
    @NotBlank(message = "El asunto no puede estar vacío")
    private String asunto;

    @NotBlank(message = "El cuerpo del mensaje no puede estar vacío")
    private String cuerpoMensaje;

    @NotBlank(message = "El estado de lectura no puede estar vacío")
    private String estadoLectura;    
}
