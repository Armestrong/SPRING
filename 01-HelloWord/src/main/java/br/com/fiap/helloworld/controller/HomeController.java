package br.com.fiap.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String exibirHome(){
        return "pagina-home";
    }
}
