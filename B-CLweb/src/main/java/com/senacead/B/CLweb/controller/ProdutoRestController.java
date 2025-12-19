/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senacead.B.CLweb.controller;


import com.senacead.B.CLweb.model.Produto;
import com.senacead.B.CLweb.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoRestController {

    @Autowired
    private ProdutoService produtoService;
    
     @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }


    @PostMapping("/{fornecedorId}")
    public Produto salvar(@PathVariable("fornecedorId") Long fornecedorId, @RequestBody Produto produto) {
        return produtoService.salvar(fornecedorId, produto);
    }
    
     @PutMapping("/{id}/{fornecedorId}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto){
        return produtoService.atualizar(id, produto);
    }
   
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
}