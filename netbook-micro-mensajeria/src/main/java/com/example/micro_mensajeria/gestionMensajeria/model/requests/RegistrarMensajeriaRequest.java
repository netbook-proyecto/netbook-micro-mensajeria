package com.example.micro_mensajeria.gestionMensajeria.model.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegistrarMensajeriaRequest {

    @NotBlank(message = "El correo del emisor no puede estar vacío")
    private String correoEmisor;

    @NotBlank(message = "El correo del receptor no puede estar vacío")
    private String correoReceptor;

    @NotBlank(message = "El asunto no puede estar vacío")
    private String asunto;

    @NotBlank(message = "El cuerpo del mensaje no puede estar vacío")
    private String cuerpoMensaje;
}