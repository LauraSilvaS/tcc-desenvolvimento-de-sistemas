package com.senacead.B.CLweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(name = "nome_cliente")
    private String nomeCliente;
     @Column(name = "contato")
    private String contato;
     @Column(name = "pagamento_pendente")
    private double pagamentoPendente;

    public Cliente() {
    }

    public Cliente(Long id, String nomeCliente, String contato, double pagamentoPendente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.contato = contato;
        this.pagamentoPendente = pagamentoPendente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public double getPagamentoPendente() {
        return pagamentoPendente;
    }

    public void setPagamentoPendente(double pagamentoPendente) {
        this.pagamentoPendente = pagamentoPendente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

 
}
