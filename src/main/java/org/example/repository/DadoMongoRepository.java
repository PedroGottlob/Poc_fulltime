package org.example.repository;

import org.example.model.DadoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DadoMongoRepository extends MongoRepository<DadoMongo, String> {
}