
package com.senacead.B.CLweb.controller;

import com.senacead.B.CLweb.model.Produto;
import com.senacead.B.CLweb.service.FornecedorService;
import com.senacead.B.CLweb.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    ProdutoService produtoService;
    
    @Autowired
    FornecedorService fornecedorService;
    
    @GetMapping
    public String listar (Model model){
        model.addAttribute("produtos", produtoService.listarTodos());
        model.addAttribute("fornecedores", fornecedorService.listarTodos());
        model.addAttribute("produto", new Produto());
        return "produto";
    }
    
    
    
    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model){
        model.addAttribute("produto", new Produto());
        model.addAttribute("fornecedor", fornecedorService.listarTodos());
        return "produto";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrar( 
            @RequestParam Long fornecedor_id,
            @ModelAttribute("produto") @Valid Produto produto,
            BindingResult result){
        
    if (result.hasErrors()){
        return "produto";
    }
    produtoService.salvar(fornecedor_id, produto);
    return "redirect:/produto";
    }
    
   @GetMapping("/atualizar/{id}")
    public String exibirFormularioAtualizar(@PathVariable Long id, Model model){
        Produto produto = produtoService.buscarPorId(id);
        model.addAttribute("produto", produto);
         model.addAttribute("fornecedor", fornecedorService.listarTodos());
        return "produto";
    }
    
    @PutMapping("/atualizar/{id}")  
    public String atualizar(
            @PathVariable Long id, 
            @ModelAttribute("produto")@Valid Produto produtoAtualizado, 
            BindingResult result){
        
        if(result.hasErrors()){
            return "produto";
        }
        produtoService.atualizar(id, produtoAtualizado);
        return "redirect:/produto";
    }
    
    @DeleteMapping("/deletar/{id}")
    public String deletar (@PathVariable Long id){
        produtoService.deletar(id);
        return "redirect:/fornecedor";
    }
}
