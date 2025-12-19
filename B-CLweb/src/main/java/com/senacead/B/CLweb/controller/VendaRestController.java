
package com.senacead.B.CLweb.controller;

import com.senacead.B.CLweb.model.Cliente;
import com.senacead.B.CLweb.model.Venda;
import com.senacead.B.CLweb.service.VendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendas")
public class VendaRestController {

    @Autowired
    private VendaService vendaService;
    
     @GetMapping
    public List<Venda> listarTodos() {
        return vendaService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Venda buscarPorId(@PathVariable Long id){
        return vendaService.buscarPorId(id);
    }


    @PostMapping("/{clienteId}")
    public Venda salvar(@PathVariable("clienteId") Long clienteId, @RequestBody Venda venda) {
        return vendaService.salvar(clienteId, venda);
    }
    
     @PutMapping("/{id}/{clienteId}")
    public Venda atualizar(@PathVariable Long id, @PathVariable Long clienteId, @RequestBody Venda venda){
        return vendaService.atualizar(id, clienteId, venda);
    }
   
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        vendaService.deletar(id);
    }
}
