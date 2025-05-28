package org.example.Repository;

import org.example.Model.EventoMySQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoMySQLRepository extends JpaRepository<EventoMySQL, String> {
}
