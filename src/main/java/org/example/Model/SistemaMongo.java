package org.example.Model;

// SistemaMongo.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sistema")
public class SistemaMongo {

    @Id
    private Long idSistema;
    private String nomeCliente;
    private String descricao;

    public Long getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Long idSistema) {
        this.idSistema = idSistema;
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
