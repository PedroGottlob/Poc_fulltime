package org.example.Service;

import org.example.Model.EventoMongo;
import org.example.Model.EventoMySQL;
import org.example.Model.SistemaMongo;
import org.example.Model.SistemaMySQL;
import org.example.Repository.EventoMongoRepository;
import org.example.Repository.EventoMySQLRepository;
import org.example.Repository.SistemaMongoRepository;
import org.example.Repository.SistemaMySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IntegracaoService {

    @Autowired
    private EventoMySQLRepository eventoMySQLRepository;
    @Autowired
    private SistemaMySQLRepository sistemaMySQLRepository;
    @Autowired
    private EventoMongoRepository eventoMongoRepository;
    @Autowired
    private SistemaMongoRepository sistemaMongoRepository;

    public void processarId(String id) {
        System.out.println("Processando ID recebido: " + id);
        Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("ID inválido: " + id);
            return;
        }

        Optional<EventoMySQL> evento = eventoMySQLRepository.findById(idLong);
        if (evento.isPresent()) {
            EventoMongo mongo = new EventoMongo();
            mongo.setIdEvento(evento.get().getIdEvento());
            mongo.setDescricao(evento.get().getDescricao());
            mongo.setPrioridade(evento.get().getPrioridade());
            mongo.setHorario(evento.get().getHorario()); // LocalDateTime
            eventoMongoRepository.save(mongo);
            System.out.println("Evento salvo no MongoDB." + mongo.getIdEvento());
        }

        Optional<SistemaMySQL> sistema = sistemaMySQLRepository.findById(idLong);
        if (sistema.isPresent()) {
            SistemaMongo mongo = new SistemaMongo();
            mongo.setIdSistema(sistema.get().getIdSistema());
            mongo.setNomeCliente(sistema.get().getNomeCliente());
            mongo.setDescricao(sistema.get().getDescricao());
            sistemaMongoRepository.save(mongo);
            System.out.println("Sistema salvo no MongoDB.");
        }

        if (!evento.isPresent() && !sistema.isPresent()) {
            System.out.println("Nenhum evento ou sistema encontrado com ID: " + idLong);
        }
    }
}
