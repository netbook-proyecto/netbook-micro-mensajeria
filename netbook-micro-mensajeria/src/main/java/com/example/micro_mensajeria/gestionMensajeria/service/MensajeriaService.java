package com.example.micro_mensajeria.gestionMensajeria.service;

import com.example.micro_mensajeria.gestionMensajeria.model.entities.Mensajeria;
import com.example.micro_mensajeria.gestionMensajeria.model.requests.ActualizarMensajeriaRequest;
import com.example.micro_mensajeria.gestionMensajeria.model.requests.RegistrarMensajeriaRequest;
import com.example.micro_mensajeria.gestionMensajeria.repository.MensajeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return mensajeriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensaje no encontrado"));
    }

    public List<Mensajeria> listarRecibidosPor(String correoReceptor) {
        return mensajeriaRepository.findByCorreoReceptor(correoReceptor);
    }

    public List<Mensajeria> listarEnviadosPor(String correoEmisor) {
        return mensajeriaRepository.findByCorreoEmisor(correoEmisor);
    }

    public Mensajeria registrarMensajeria(RegistrarMensajeriaRequest request) {
        Mensajeria nuevaMensajeria = new Mensajeria();

        nuevaMensajeria.setCorreoEmisor(request.getCorreoEmisor());
        nuevaMensajeria.setCorreoReceptor(request.getCorreoReceptor());
        nuevaMensajeria.setAsunto(request.getAsunto());
        nuevaMensajeria.setCuerpoMensaje(request.getCuerpoMensaje());
        nuevaMensajeria.setFechaEnvio(LocalDate.now());
        nuevaMensajeria.setEstadoLectura("NO_LEIDO");

        return mensajeriaRepository.save(nuevaMensajeria);
    }

    public Mensajeria actualizarMensajeria(Integer id, ActualizarMensajeriaRequest request) {
        Mensajeria mensajeriaExistente = obtenerMensajeriaPorId(id);

        mensajeriaExistente.setAsunto(request.getAsunto());
        mensajeriaExistente.setCuerpoMensaje(request.getCuerpoMensaje());
        mensajeriaExistente.setEstadoLectura(request.getEstadoLectura());

        return mensajeriaRepository.save(mensajeriaExistente);
    }

    public void eliminarMensajeria(Integer id) {
        mensajeriaRepository.deleteById(id);
    }
}