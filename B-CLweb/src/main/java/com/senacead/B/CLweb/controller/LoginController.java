package com.senacead.B.CLweb.controller;

import com.senacead.B.CLweb.model.Login;
import com.senacead.B.CLweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String senha,
            @RequestParam String confirmacao
    ) {
        if (!senha.equals(confirmacao)){
            return "redirect:/login";
        }
        
        Login novo = new Login();
        novo.setEmail(email);
        novo.setNomeUsuario(username);
        
        loginService.cadastrar(novo, senha);
        return "redirect:/login";
    }
    
    
    
    @PostMapping("/login")
    public String fazerLogin (@RequestParam String email, @RequestParam String senha){
        boolean autenticado = loginService.autenticar(email, senha);
        
        if (autenticado){
            return "redirect:/boleto";
        }
        return "redirect:/login";
    }
    
    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        
        model.addAttribute("login", new Login());
        
        return "login";
    }

}
