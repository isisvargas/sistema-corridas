package com.bcopstein.CtrlCorredorV1.reporitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EventoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE eventos("
                + "id int, nome VARCHAR(255), dia int, mes int, ano int, distancia int, horas int, minutos int, segundos int,PRIMARY KEY(id))");

        Evento evento1 = new Evento(1, "Poa Day Run", 28, 11, 2019, 42, 2, 35, 32);
        this.cadastraEvento(evento1);

        Evento evento2 = new Evento(2, "SP Maraton", 27, 11, 2020, 5, 0, 35, 32);
        this.cadastraEvento(evento2);

        Evento evento3 = new Evento(3, "PR Maraton", 27, 11, 2019, 42, 1, 10, 32);
        this.cadastraEvento(evento3);
    }

    public List<Evento> consultaEventos() {
        List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos",
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
        return resp;
    }

    public List<Evento> consultaEventosPorDistancia(int distancia) {
        List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos WHERE distancia = " + distancia,
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
        return resp;
    }

    public List<Evento> consultaEventosPorDistanciaEAno(int distancia, int ano) {
        List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos WHERE distancia = " + distancia + " AND ano = " + ano,
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
        return resp;
    }

    public void cadastraEvento(Evento evento) {
        this.jdbcTemplate.update(
                "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)",
                evento.getId(), evento.getNome(), evento.getDia(), evento.getMes(), evento.getAno(),
                evento.getDistancia(), evento.getHoras(), evento.getMinutos(), evento.getSegundos());
    }
}
