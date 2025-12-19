
package com.senacead.B.CLweb.controller;

import com.senacead.B.CLweb.model.Fornecedor;
import com.senacead.B.CLweb.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    FornecedorService fornecedorService;
    
    @GetMapping
    public String listar (Model model){
        model.addAttribute("fornecedor", fornecedorService.listarTodos());
        model.addAttribute("fornecedor", new Fornecedor());
        return "fornecedor";
    }
    
    
    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model){
        model.addAttribute("fornecedor", new Fornecedor());
        return "fornecedor";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("fornecedor") @Valid Fornecedor fornecedor, BindingResult result){
    if (result.hasErrors()){
        return "fornecedor";
    }
    fornecedorService.salvar(fornecedor);
    return "redirect:/fornecedor";
    }
    
   @GetMapping("/atualizar/{id}")
    public String exibirFormularioAtualizar(@PathVariable Long id, Model model){
        Fornecedor fornecedor = fornecedorService.buscarPorId(id);
        model.addAttribute("fornecedor", fornecedor);
        return "fornecedor";
    }
    
    @PostMapping("/atualizar/{id}")  
    public String atualizar(@PathVariable Long id, @ModelAttribute("fornecedor") @Valid Fornecedor fornecedorAtualizado, BindingResult result){
        if(result.hasErrors()){
            return "fornecedor";
        }
        fornecedorService.atualizar(id, fornecedorAtualizado);
        return "redirect:/fornecedor";
    }
    
    @DeleteMapping("/deletar/{id}")
    public String deletar (@PathVariable Long id){
       fornecedorService.deletar(id);
        return "redirect:/boleto";
    }
}
