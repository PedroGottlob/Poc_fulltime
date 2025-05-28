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
        Optional<EventoMySQL> evento = eventoMySQLRepository.findById(id);
        if (evento.isPresent()) {
            EventoMongo mongo = new EventoMongo();
            mongo.setIdEvento(evento.get().getIdEvento());
            mongo.setDescricao(evento.get().getDescricao());
            mongo.setPrioridade(evento.get().getPrioridade());
            mongo.setHorario(evento.get().getHorario());
            eventoMongoRepository.save(mongo);
            System.out.println("Evento salvo no MongoDB.");
        }

        Optional<SistemaMySQL> sistema = sistemaMySQLRepository.findById(id);
        if (sistema.isPresent()) {
            SistemaMongo mongo = new SistemaMongo();
            mongo.setIdSistema(sistema.get().getIdSistema());
            mongo.setNomeCliente(sistema.get().getNomeCliente());
            mongo.setDescricao(sistema.get().getDescricao());
            sistemaMongoRepository.save(mongo);
            System.out.println("Sistema salvo no MongoDB.");
        }

        if (!evento.isPresent() && !sistema.isPresent()) {
            System.out.println("Nenhum evento ou sistema encontrado com ID: " + id);
        }
    }
}
