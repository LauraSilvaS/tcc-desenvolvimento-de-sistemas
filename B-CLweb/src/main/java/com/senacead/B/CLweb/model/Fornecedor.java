
package com.senacead.B.CLweb.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @Column(name = "nome_fornecedor")
    private String nomeFornecedor;
    @Column(name = "contato")
    private String contato;
    @Column(name = "observacoes")
    private String observacoes;
    
    public Fornecedor() {
    }

    public Fornecedor(Long id, String nomeFornecedor, String contato, String observacoes) {
        this.id = id;
        this.nomeFornecedor = nomeFornecedor;
        this.contato = contato;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

  
    
   
    
    
    
}
