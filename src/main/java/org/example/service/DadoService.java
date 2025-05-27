package org.example.service;

import org.example.model.DadoMongo;
import org.example.model.DadoMySQL;
import org.example.repository.DadoMongoRepository;
import org.example.repository.DadoMySQLRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadoService {

    private final DadoMySQLRepository dadoMySQLRepository;
    private final DadoMongoRepository dadoMongoRepository;

    public DadoService(DadoMySQLRepository dadoMySQLRepository, DadoMongoRepository dadoMongoRepository) {
        this.dadoMySQLRepository = dadoMySQLRepository;
        this.dadoMongoRepository = dadoMongoRepository;
    }

    public void sincronizarDados() {
        List<DadoMySQL> dadosMySQL = dadoMySQLRepository.findAll();

        for (DadoMySQL dadoMySQL : dadosMySQL) {
            DadoMongo dadoMongo = new DadoMongo();
            dadoMongo.setId(String.valueOf(dadoMySQL.getId()));
            dadoMongo.setNome(dadoMySQL.getNome());
            dadoMongo.setEmail(dadoMySQL.getEmail());

            dadoMongoRepository.save(dadoMongo);
        }

        System.out.println("✅ Dados sincronizados do MySQL para o MongoDB.");
    }
}
