package com.bcopstein.CtrlCorredorV1.controller;

import com.bcopstein.CtrlCorredorV1.business_logic.*;
import com.bcopstein.CtrlCorredorV1.reporitory.Corredor;
import com.bcopstein.CtrlCorredorV1.reporitory.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ctrlCorridas")
public class CtrlCorridasControler {
    private ServicoEstatisticas servicoEstatisticas;
    private ServicoEventos servicoEventos;
    private ServicoCorredor servicoCorredor;

    @Autowired
    public CtrlCorridasControler(ServicoEstatisticas servicoEstatisticas,
                                 ServicoEventos servicoEventos,
                                 ServicoCorredor servicoCorredor) {
        this.servicoEstatisticas = servicoEstatisticas;
        this.servicoEventos = servicoEventos;
        this.servicoCorredor = servicoCorredor;
    }

    @GetMapping("/corredor")
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        return servicoCorredor.consultaCorredor();
    }

    @PostMapping("/corredor")
    @CrossOrigin(origins = "*")
    public boolean cadastraCorredor(@RequestBody final Corredor corredor) {
        servicoCorredor.cadastraCorredor(corredor);
        return true;
    }

    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return servicoEventos.consultaEventos();
    }

    @PostMapping("/eventos") // adiciona evento no único corredor
    @CrossOrigin(origins = "*")
    public boolean cadastraEvento(@RequestBody final Evento evento) {
        servicoEventos.cadastraEvento(evento);
        return true;
    }

    @GetMapping("/estatisticas")
    @CrossOrigin(origins = "*")
    public EstastisticasDTO estatisticas(@RequestParam final int distancia) {
        return servicoEstatisticas.estatisticas(distancia);
    }

    @GetMapping("/aumentoPerformance")
    @CrossOrigin(origins = "*")
    public PerformanceDTO aumentoPerformance(@RequestParam final int distancia,
                                             @RequestParam final int ano) {
        return servicoEstatisticas.aumentoPerformance(distancia, ano);
    }
}
