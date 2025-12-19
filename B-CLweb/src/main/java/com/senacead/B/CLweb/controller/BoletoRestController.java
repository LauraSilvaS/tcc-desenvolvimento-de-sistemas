package com.senacead.B.CLweb.controller;


import com.senacead.B.CLweb.model.Boleto;

import com.senacead.B.CLweb.repository.BoletoRepository;
import com.senacead.B.CLweb.service.BoletoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boletos")
public class BoletoRestController {

    @Autowired
    private BoletoService boletoService;
    
     @GetMapping
    public List<Boleto> listarTodos() {
        return boletoService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Boleto buscarPorId(@PathVariable Long id){
        return boletoService.buscarPorId(id);
    }


    @PostMapping("/{fornecedorId}")
    public Boleto salvar(@PathVariable("fornecedorId") Long fornecedorId, @RequestBody Boleto boleto) {
        return boletoService.salvar(fornecedorId, boleto);
    }
    
     @PutMapping("/{id}/{fornecedorId}")
    public Boleto atualizar(@PathVariable Long id, @RequestBody Boleto boleto){
        return boletoService.atualizar(id, boleto);
    }
   
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        boletoService.deletar(id);
    }
}
