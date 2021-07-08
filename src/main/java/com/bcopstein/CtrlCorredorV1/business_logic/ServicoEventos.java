package com.bcopstein.CtrlCorredorV1.business_logic;

import com.bcopstein.CtrlCorredorV1.reporitory.Evento;
import com.bcopstein.CtrlCorredorV1.reporitory.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoEventos {
    private EventoRepository eventoRepository;

    @Autowired
    public ServicoEventos(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }


    public List<Evento> consultaEventos() {
        return eventoRepository.consultaEventos();
    }

    public void cadastraEvento(Evento evento) {
        eventoRepository.cadastraEvento(evento);
    }
}
