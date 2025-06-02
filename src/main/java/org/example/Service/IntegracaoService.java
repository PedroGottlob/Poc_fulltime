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
        System.out.println(">> Iniciando processamento do ID recebido: " + id);
        Long idLong;
        try {
            idLong = Long.parseLong(id);
            System.out.println(">> ID convertido para Long com sucesso: " + idLong);
        } catch (NumberFormatException e) {
            System.err.println(">> ERRO: ID inválido, não é um número: " + id);
            return;
        }

        System.out.println(">> Buscando Evento no MySQL com ID: " + idLong);
        Optional<EventoMySQL> evento = eventoMySQLRepository.findById(idLong);
        if (evento.isPresent()) {
            System.out.println(">> Evento encontrado no MySQL: " + evento.get());
            EventoMongo mongo = new EventoMongo();
            mongo.setIdEvento(evento.get().getIdEvento());
            mongo.setDescricao(evento.get().getDescricao());
            mongo.setPrioridade(evento.get().getPrioridade());
            mongo.setHorario(evento.get().getHorario());
            eventoMongoRepository.save(mongo);
            System.out.println(">> Evento salvo no MongoDB com ID: " + mongo.getIdEvento());
        } else {
            System.out.println(">> Evento não encontrado no MySQL para ID: " + idLong);
        }

        System.out.println(">> Buscando Sistema no MySQL com ID: " + idLong);
        Optional<SistemaMySQL> sistema = sistemaMySQLRepository.findById(idLong);
        if (sistema.isPresent()) {
            System.out.println(">> Sistema encontrado no MySQL: " + sistema.get());
            SistemaMongo mongo = new SistemaMongo();
            mongo.setIdSistema(sistema.get().getIdSistema());
            mongo.setNomeCliente(sistema.get().getNomeCliente());
            mongo.setDescricao(sistema.get().getDescricao());
            sistemaMongoRepository.save(mongo);
            System.out.println(">> Sistema salvo no MongoDB com ID: " + mongo.getIdSistema());
        } else {
            System.out.println(">> Sistema não encontrado no MySQL para ID: " + idLong);
        }

        if (!evento.isPresent() && !sistema.isPresent()) {
            System.out.println(">> Nenhum evento ou sistema encontrado no MySQL com o ID: " + idLong);
        }

        System.out.println(">> Finalizado processamento para o ID: " + idLong);
    }
}
