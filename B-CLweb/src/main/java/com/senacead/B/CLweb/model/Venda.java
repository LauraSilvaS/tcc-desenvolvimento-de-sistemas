package com.senacead.B.CLweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @Column(name = "status")
    private String status;
    @Column(name = "data_venda")
    private String dataVenda;
    @Column(name = "valor_total")
    private double valorTotal;
    @Column(name = "modo_pagamento")
    private String modoPagamento;
    @Column(name = "pendente")
    private String pendente;
    @Column(name = "nome_cliente")
    private String nomeCliente;

    public Venda() {
    }

    public Venda(Long id, Cliente cliente, String status, String dataVenda, double valorTotal, String modoPagamento, String pendente, String nomeCliente) {
        this.id = id;
        this.cliente = cliente;
        this.status = status;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.modoPagamento = modoPagamento;
        this.pendente = pendente;
        this.nomeCliente = nomeCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getModoPagamento() {
        return modoPagamento;
    }

    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    public String getPendente() {
        return pendente;
    }

    public void setPendente(String pendente) {
        this.pendente = pendente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}
