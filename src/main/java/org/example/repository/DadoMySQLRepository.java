package org.example.repository;

import org.example.model.DadoMySQL;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DadoMySQLRepository extends JpaRepository<DadoMySQL, Long> {

}
