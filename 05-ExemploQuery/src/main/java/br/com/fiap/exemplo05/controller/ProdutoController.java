package br.com.fiap.exemplo05.controller;

import br.com.fiap.exemplo05.entity.Produto;
import br.com.fiap.exemplo05.view.ProdutoRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

////////////////////////////////////////////////////////////////////////////////////////

    /** CADASTRAR **/
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



////////////////////////////////////////////////////////////////////////////////////////
    /** PESQUISAR  POR NOME**/

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


////////////////////////////////////////////////////////////////////////////////////////

    /** PESQUISAR  POR CODIGO **/
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


////////////////////////////////////////////////////////////////////////////////////////

    /** PESQUISAR  POR PRODUTO NOVO E NOME **/
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


////////////////////////////////////////////////////////////////////////////////////////
  /*
    /* PESQUISAR  POR PREÇO MAIOR QUE
    @GetMapping("churris")
    public String buscarPorPrecoMaiorQue(){
       return "buscar";
    }

    @PostMapping("churris")
    public String buscarPorPrecoMaiorQue(double preco, Model model){
       List<Produto> produtos = repository.findByPrecoMaiorQue(preco);
       model.addAttribute("prod",produtos);
       return  "resultado";
    }
    */



////////////////////////////////////////////////////////////////////////////////////////
    /** PESQUISAR NOVO POR ORDER BY DESC (DESC) **/

    @GetMapping("borderbynovo")
    public String buscarPorNovoOrderByDesc()
    {
        return "buscar";
    }

    @PostMapping("borderbynovo")
    public String buscarPorNovoOrderByDesc(boolean novo, Model model){
        List<Produto> produtos = repository.findByNovoOrderByNomeDesc(novo);
        model.addAttribute("prod",produtos);
        return  "resultado";
    }



////////////////////////////////////////////////////////////////////////////////////////
    /**  buscarPorNomeIgnoreCase **/

    @GetMapping("bnomeignorecase")
    public String buscarPorNomeIgnoreCaseOrderByPrecoAsc()
    {
        return "buscar";
    }

    @PostMapping("bnomeignorecase")
    public String buscarPorNomeIgnoreCaseOrderByPrecoAsc(String nome, Model model){
        List<Produto> produtos = repository.findByNomeIgnoreCaseOrderByPrecoAsc(nome);
        model.addAttribute("prod",produtos);
        return  "resultado";
    }

////////////////////////////////////////////////////////////////////////////////////////


}
