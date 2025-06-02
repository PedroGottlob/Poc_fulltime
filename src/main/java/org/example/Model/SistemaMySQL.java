package org.example.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sistema_mysql")
public class SistemaMySQL {

    @Id
    @Column(name = "id_sistema")
    private Long id_sistema;

    private String nomeCliente;
    private String descricao;

    public Long getIdSistema() {
        return id_sistema;
    }

    public void setIdSistema(Long idSistema) {
        this.id_sistema = idSistema;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
