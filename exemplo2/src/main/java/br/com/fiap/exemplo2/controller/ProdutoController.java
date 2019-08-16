package br.com.fiap.exemplo2.controller;

import br.com.fiap.exemplo2.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

    @GetMapping("/produto/cadastrar")
    public String abrirFormulario(){
        return "produto/form";
    }

    @PostMapping("/produto/cadastrar")
            public String processarForm(Produto produto){
        System.out.print(produto.getNome() +" "+produto.getPreco());
        return "produto/sucesso";
    }


}
