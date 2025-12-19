
package com.senacead.B.CLweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

 @Controller
public class EsqueciMinhaSenhaController {
   
    @RequestMapping("/login/esqueciminhasenha")
    public String preferencias() {
        return "esqueciminhasenha";
    }
}
