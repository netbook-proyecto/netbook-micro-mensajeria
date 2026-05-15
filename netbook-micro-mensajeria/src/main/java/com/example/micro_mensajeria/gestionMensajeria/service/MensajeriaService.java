package com.example.micro_mensajeria.gestionMensajeria.service;

import com.example.micro_mensajeria.gestionMensajeria.model.entities.Mensajeria;
import com.example.micro_mensajeria.gestionMensajeria.model.requests.ActualizarMensajeriaRequest;
import com.example.micro_mensajeria.gestionMensajeria.model.requests.RegistrarMensajeriaRequest;
import com.example.micro_mensajeria.gestionMensajeria.repository.MensajeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MensajeriaService {

    @Autowired
    private MensajeriaRepository mensajeriaRepository;

    public List<Mensajeria> obtenerTodasLasMensajerias() {
        return mensajeriaRepository.findAll();
    }

    public Mensajeria obtenerMensajeriaPorId(Integer id) {
        return mensajeriaRepository.findById(id).orElse(null);
    }

    public Mensajeria registrarMensajeria(RegistrarMensajeriaRequest request) {
        Mensajeria nuevaMensajeria = new Mensajeria();
        
        nuevaMensajeria.setFechaEnvio(LocalDate.now()); 
        nuevaMensajeria.setEstadoLectura("NO_LEIDO"); 
        nuevaMensajeria.setAsunto(request.getAsunto());
        nuevaMensajeria.setCuerpoMensaje(request.getCuerpoMensaje());

        return mensajeriaRepository.save(nuevaMensajeria);
    }

    public Mensajeria actualizarMensajeria(Integer id, ActualizarMensajeriaRequest request) {
        Mensajeria mensajeriaExistente = obtenerMensajeriaPorId(id);
        
        if (mensajeriaExistente != null) {
            mensajeriaExistente.setAsunto(request.getAsunto());
            mensajeriaExistente.setCuerpoMensaje(request.getCuerpoMensaje());
            mensajeriaExistente.setEstadoLectura(request.getEstadoLectura());
            
            return mensajeriaRepository.save(mensajeriaExistente);
        }
        
        throw new RuntimeException("Mensajeria no encontrada");
    }

    public void eliminarMensajeria(Integer id) {
        mensajeriaRepository.deleteById(id);
    }
}