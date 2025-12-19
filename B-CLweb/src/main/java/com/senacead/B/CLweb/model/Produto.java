
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
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne 
    @JoinColumn(name="fornecedor_id")
    @JsonIgnore
    private Fornecedor fornecedor;

    @Column(name = "nome_produto")
    private String nomeProduto;
     @Column(name = "estoque")
    private int estoque;
      @Column(name = "categoria")
    private String categoria;
       @Column(name = "preco_compra")
    private double precoCompra;
        @Column(name = "preco_venda")
    private double precoVenda;
    
    @Column(name = "data_validade")
    private String dataValidade;
     @Column(name = "codigo_barras")
    private String codigoBarras;
   
     @Column(name = "nome_fornecedor")
    private String nomeFornecedor;
     
    public Produto() {
    }

    public Produto(Long id, Fornecedor fornecedor, String nomeProduto, int estoque, String categoria, double precoCompra, double precoVenda, String dataValidade, String codigoBarras, String nomeFornecedor) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.nomeProduto = nomeProduto;
        this.estoque = estoque;
        this.categoria = categoria;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.dataValidade = dataValidade;
        this.codigoBarras = codigoBarras;
        this.nomeFornecedor = nomeFornecedor;
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

    


   

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

   

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

  

   
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    

   

    public static ArrayList<Produto> listaProduto = new ArrayList();
}
