package com.bcopstein.CtrlCorredorV1.business_logic;

import com.bcopstein.CtrlCorredorV1.reporitory.Evento;
import com.bcopstein.CtrlCorredorV1.reporitory.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class ServicoEstatisticas {
    private EventoRepository eventoRepository;

    @Autowired
    public ServicoEstatisticas(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }


    public EstastisticasDTO estatisticas(int distancia) {
        List<Evento> eventos = eventoRepository.consultaEventosPorDistancia(distancia);

        int totalCorridas = eventos.size();
        List<Double> temposEmMinuto = eventos.stream()
                .map(it -> getTimeInSeconds(it) / 60)
                .collect(Collectors.toList());
        double media = temposEmMinuto.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);

        return new EstastisticasDTO(
                totalCorridas,
                media,
                0,
                desvioPadrao(temposEmMinuto)
        );
    }

    public PerformanceDTO aumentoPerformance(int distancia,  int ano) {
        List<Evento> eventos = eventoRepository.consultaEventosPorDistanciaEAno(distancia, ano);

        eventos.sort(Comparator.comparing(Evento::getAno)
                .thenComparing(Evento::getMes)
                .thenComparing(Evento::getDia));

        List<AumentoPerformance> analisePerformance = new ArrayList<>();
        for (int i = 0; i < eventos.size()-1; i++) {
            double ganhoPerformance = getTimeInSeconds(eventos.get(i+1)) - getTimeInSeconds(eventos.get(i));
            analisePerformance.add(new AumentoPerformance(
                    eventos.get(i).getNome(),
                    eventos.get(i+1).getNome(),
                    ganhoPerformance));
        }
        if(analisePerformance.size() > 0) {
            AumentoPerformance melhorGanho = analisePerformance
                    .stream()
                    .max(Comparator.comparing(AumentoPerformance::getAumentoPerformance))
                    .orElseThrow(NoSuchElementException::new);

            return new PerformanceDTO(
                    melhorGanho.getProvaAnterior(),
                    melhorGanho.getProvaSeguinte(),
                    melhorGanho.getAumentoPerformance()
            );
        }
        return new PerformanceDTO(null, null, 0);
    }

    private static double getTimeInSeconds(Evento evento) {
        return ((evento.getHoras()*60)*60) + (evento.getMinutos()*60) + evento.getSegundos();
    }

    private static double desvioPadrao(List<Double> numeros) {
        double media = numeros.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double mediaDesvios = numeros.stream().mapToDouble(i -> Math.pow(i - media, 2)).average().orElse(0);
        return Math.sqrt(mediaDesvios);
    }
}
