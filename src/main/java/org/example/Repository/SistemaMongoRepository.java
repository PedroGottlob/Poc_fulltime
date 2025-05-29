package org.example.Repository;

import org.example.Model.SistemaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaMongoRepository extends MongoRepository<SistemaMongo, Long> {
}
