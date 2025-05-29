package org.example.Repository;



import org.example.Model.SistemaMySQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaMySQLRepository extends JpaRepository<SistemaMySQL, Long> {
}