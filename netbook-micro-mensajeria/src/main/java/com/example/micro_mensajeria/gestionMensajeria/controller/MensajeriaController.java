package com.example.micro_mensajeria.gestionMensajeria.controller;

import com.example.micro_mensajeria.gestionMensajeria.model.entities.Mensajeria;
import com.example.micro_mensajeria.gestionMensajeria.model.requests.ActualizarMensajeriaRequest;
import com.example.micro_mensajeria.gestionMensajeria.model.requests.RegistrarMensajeriaRequest;
import com.example.micro_mensajeria.gestionMensajeria.service.MensajeriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensajerias")
public class MensajeriaController {

    @Autowired
    private MensajeriaService mensajeriaService;

    @GetMapping
    public List<Mensajeria> obtenerTodasLasMensajerias() {
        return mensajeriaService.obtenerTodasLasMensajerias();
    }

    @GetMapping("/{id}")
    public Mensajeria obtenerMensajeriaPorId(@PathVariable Integer id) {
        return mensajeriaService.obtenerMensajeriaPorId(id);
    }

    @PostMapping
    public Mensajeria registrarMensajeria(@RequestBody RegistrarMensajeriaRequest request) {
        return mensajeriaService.registrarMensajeria(request);
    }

    @PutMapping("/{id}")
    public Mensajeria actualizarMensajeria(@PathVariable Integer id, @RequestBody ActualizarMensajeriaRequest request) {
        return mensajeriaService.actualizarMensajeria(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void eliminarMensajeria(@PathVariable Integer id) {
        mensajeriaService.eliminarMensajeria(id);
    }
}