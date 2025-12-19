
package com.senacead.B.CLweb.controller;

import com.senacead.B.CLweb.model.ItemVenda;
import com.senacead.B.CLweb.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemVendaController {
        @Autowired
    ItemVendaService itemVendaService;
    
    @GetMapping("/itemVenda")
    public String itensVenda(Model model){
        model.addAttribute("itemVenda", itemVendaService.listarTodos());
        return "itemVenda";
    }
    
    @DeleteMapping("/itemVenda/deletar/{id}")
    @ResponseBody
    public void deletar (@PathVariable(value="id")Long id){
        itemVendaService.deletar(id);
    }
    
    @GetMapping("/itemVenda/cadastrar")
    public String exibirFormularioCadastro(Model model){
        model.addAttribute("itemVenda", new ItemVenda());
        return "itemVenda";
    }
    
    @PostMapping("/itemVenda/cadastrar")
    public String cadastrar(@ModelAttribute ItemVenda itemVenda, BindingResult result){
    if (result.hasErrors()){
        return "itemVenda";
    }
    itemVendaService.salvar(itemVenda);
    return "redirect:/itemVenda";
    }
    
   @GetMapping("/itemVenda/atualizar/{id}")
    public String exibirFormularioAtualizar(@PathVariable(value="id") Long id, Model model){
       ItemVenda itemVenda = itemVendaService.buscarPorId(id);
        model.addAttribute("itemVenda", itemVenda);
        return "itemVenda";
    }
    
    @PostMapping("itemVenda/atualizar/{id}")  
    public String atualizar(@PathVariable Long id, @ModelAttribute("itemVenda")ItemVenda itemVendaAtualizado, BindingResult result){
        if(result.hasErrors()){
            return "itemVenda";
        }
        itemVendaService.atualizar(id, itemVendaAtualizado);
        return "redirect:/itemVenda";
    }
    
    
}
