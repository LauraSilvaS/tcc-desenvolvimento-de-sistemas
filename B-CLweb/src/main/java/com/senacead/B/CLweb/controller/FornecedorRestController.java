
package com.senacead.B.CLweb.controller;

import com.senacead.B.CLweb.model.Fornecedor;
import com.senacead.B.CLweb.repository.FornecedorRepository;
import com.senacead.B.CLweb.service.FornecedorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorRestController {
    
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> listarTodos() {
        return fornecedorService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Fornecedor buscarPorId(@PathVariable Long id){
        return fornecedorService.buscarPorId(id);
    }
    
    @PostMapping
    public Fornecedor salvar(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.salvar(fornecedor);
    }

    @PutMapping("/{id}")
    public Fornecedor atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        return fornecedorService.atualizar(id, fornecedor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
       fornecedorService.deletar(id);
    }
}


