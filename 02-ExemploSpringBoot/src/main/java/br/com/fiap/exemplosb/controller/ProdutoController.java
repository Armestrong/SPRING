package br.com.fiap.exemplosb.controller;

import br.com.fiap.exemplosb.bean.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//  --- ENTRANDO NO FORM  ------

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @GetMapping("cadastrar")
    public String abrirFormulario() {
        return "produto/form";
    }

    ///  ----- RECEBENDO PARÂMETROS DA VIEW & ENVIANDO PARA DE VOLTA PARA A WEB --------

    @PostMapping("cadastrar")
    public String processarForm(Produto produto, Model model){
        model.addAttribute("prod",produto);
        return "produto/sucesso";
    }


/** ///  ----- RECEBENDO PARÂMETROS DA VIEW & PRINTANDO NO CONSOLE CHUMBADO--------

 @PostMapping("/produto/cadastrar")
 public String processarForm(String nome, double preco){
 System.out.print(nome + " " + preco);
 return "produto/sucesso";
 }

 ///  ----- RECEBENDO PARÂMETROS DA VIEW & PRINTANDO NO CONSOLE PEGANDO PELO ATRIBUTO --------
 @PostMapping("/produto/cadastrar")
 public String processarForm(Produto produto){
 System.out.print(produto.getNome() + " " + produto.getPreco());
 return "produto/sucesso";
 } **/




}
