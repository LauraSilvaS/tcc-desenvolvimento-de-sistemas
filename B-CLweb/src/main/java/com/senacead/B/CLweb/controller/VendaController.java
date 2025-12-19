
package com.senacead.B.CLweb.controller;

import com.senacead.B.CLweb.model.Venda;
import com.senacead.B.CLweb.service.ClienteService;
import com.senacead.B.CLweb.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    VendaService vendaService;
    @Autowired
    ClienteService clienteService;
    
    @GetMapping
    public String listar (Model model){
        model.addAttribute("vendas", vendaService.listarTodos());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("venda", new Venda());
        return "venda";
    }
    
    
    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model){
        
        model.addAttribute("venda", new Venda());
        model.addAttribute("cliente", clienteService.listarTodos());
        return "venda";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestParam Long cliente_id,
            @ModelAttribute("venda") @Valid Venda venda,
            BindingResult result){
    if (result.hasErrors()){
        return "venda";
    }
   vendaService.salvar(cliente_id, venda);
    return "redirect:/venda";
    }
    
   @GetMapping("/atualizar/{id}")
    public String exibirFormularioAtualizar(@PathVariable Long id, Model model){
        Venda venda = vendaService.buscarPorId(id);
        model.addAttribute("venda", venda);
        model.addAttribute("cliente", clienteService.listarTodos());
        return "venda";
    }
    
    @PutMapping("/atualizar/{id}")  
    public String atualizar(
            @PathVariable Long id,
             @PathVariable Long clienteId,
            @ModelAttribute("venda") @Valid Venda vendaAtualizada,
            BindingResult result){
        
        if(result.hasErrors()){
            return "venda";
        }
        vendaService.atualizar(id, clienteId, vendaAtualizada);
        return "redirect:/venda";
    }
    
    @DeleteMapping("/deletar/{id}")
    public String deletar (@PathVariable Long id){
        vendaService.deletar(id);
        return "redirect:/venda";
    }
}
