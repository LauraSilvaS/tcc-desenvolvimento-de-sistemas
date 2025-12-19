
package com.senacead.B.CLweb.controller;

import com.senacead.B.CLweb.model.Cliente;
import com.senacead.B.CLweb.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("cliente", new Cliente());
        return "cliente";
    }
    
     @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente";
    }
    

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult result){
        if (result.hasErrors()){
            return "cliente";
        }
        clienteService.salvar(cliente);
        return "redirect:/cliente";
    }
    
       @GetMapping("/atualizar/{id}")
    public String exibirFormularioAtualizar(@PathVariable Long id, Model model){
        Cliente cliente = clienteService.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "cliente";
    }
    
    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute("cliente") @Valid Cliente clienteAtualizado, BindingResult result){
        if(result.hasErrors()){
            return "cliente";
            
        }
        clienteService.atualizar(id, clienteAtualizado);
        return "redirect:/cliente";
    }
    
    @DeleteMapping("/deletar/{id}")
    public String deletar (@PathVariable Long id){
        clienteService.deletar(id);
         return "redirect:/boleto";
    }
    
   
    
    
 
 
}
