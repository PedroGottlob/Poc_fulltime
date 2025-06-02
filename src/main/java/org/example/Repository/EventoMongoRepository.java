package org.example.Repository;



import org.example.Model.EventoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoMongoRepository extends MongoRepository<EventoMongo, Long> {
}
