package br.com.fiap.exemplo05.controller;

import br.com.fiap.exemplo05.entity.Produto;
import br.com.fiap.exemplo05.view.ProdutoRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    /* CADASTRAR */
    @GetMapping("cadastrar")
    public String cadastrar() {
        return "cadastrar";
    }

    @PostMapping("cadastrar")
    public String processarForm(Produto produto) {
        repository.save(produto);
        //model.addAttribute("produto",produto);
        return "sucesso";
    }

    /* PESQUISAR  POR NOME*/
   @GetMapping("bnome")
    public String buscarPorNome(){
        return "buscar";
    }

    @PostMapping("bnome")
    public String buscarPorNome(String nome,Model model){
        List<Produto> produtos = repository.findByNome(nome);
        model.addAttribute("prod",produtos);
        return "resultado";
    }

    @GetMapping("bcd")
    public String buscarPorCodigo(){

        return "buscar";
    }

    @PostMapping("bcd")
    public String buscarPorCodigo(int codigo,Model model){
        List<Produto> produtos = repository.findByCodigo(codigo);
        model.addAttribute("prod",produtos);
        return "resultado";
    }

    @GetMapping("bnomeenovo")
    public String buscarPorNomeAndNovo(){
       return "buscar";
    }

    @PostMapping("bnomeenovo")
    public String buscarPorNomeAndNovo(String nome,boolean novo,Model model){
      List<Produto> produtos = repository.findByNomeAndNovo(nome, novo);
      model.addAttribute("prod",produtos);
       return "resultado";
    }

    @GetMapping()
    public String buscarPorPrecoMaiorQue(){
       return "buscar";
    }

    @PostMapping()
    public String buscarPorPrecoMaiorQue(double preco, Model model){
       List<Produto> produtos = repository.fingByPrecoMaiorQue(preco);
       model.addAttribute("prod",produtos);
       return  "resultado";
    }




}
