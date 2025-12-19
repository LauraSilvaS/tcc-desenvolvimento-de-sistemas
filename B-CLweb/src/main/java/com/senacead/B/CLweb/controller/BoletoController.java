package com.senacead.B.CLweb.controller;

import com.senacead.B.CLweb.model.Boleto;
import com.senacead.B.CLweb.service.BoletoService;
import com.senacead.B.CLweb.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boleto")
public class BoletoController {

    @Autowired
    BoletoService boletoService;

    @Autowired
    FornecedorService fornecedorService;

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("boletos", boletoService.listarTodos());
        model.addAttribute("fornecedores", fornecedorService.listarTodos());
        model.addAttribute("boleto", new Boleto());
        return "boleto";
    }

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {

        model.addAttribute("boleto", new Boleto());
        model.addAttribute("fornecedor", fornecedorService.listarTodos());
        return "boleto";
    }

    // CADASTRAR
    @PostMapping("/cadastrar")
    public String cadastrar(
            @RequestParam Long fornecedor_id,
            @ModelAttribute("boleto") @Valid Boleto boleto,
            BindingResult result) {

        if (result.hasErrors()) {

            return "boleto";
        }

        boletoService.salvar(fornecedor_id, boleto);
        return "redirect:/boleto";
    }

    // EXIBIR FORMULÁRIO DE ATUALIZAÇÃO
    @GetMapping("/atualizar/{id}")
    public String exibirFormularioAtualizar(@PathVariable Long id, Model model) {
        Boleto boleto = boletoService.buscarPorId(id);
        model.addAttribute("boleto", boleto);
        model.addAttribute("fornecedor", fornecedorService.listarTodos());
        return "boleto";
    }

    // ATUALIZAR
    @PostMapping("/atualizar/{id}")
    public String atualizar(
            @PathVariable Long id,
            @ModelAttribute("boleto") @Valid Boleto boletoAtualizado,
            BindingResult result ) {
        
        if (result.hasErrors()) {
            return "boleto";
        }
        boletoService.atualizar(id, boletoAtualizado);
        return "redirect:/boleto";
    }

    // EXCLUIR
    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        boletoService.deletar(id);
        return "redirect:/boleto";
    }
}
