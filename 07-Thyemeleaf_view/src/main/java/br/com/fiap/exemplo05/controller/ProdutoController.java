package br.com.fiap.exemplo05.controller;

import br.com.fiap.exemplo05.entity.Produto;
import br.com.fiap.exemplo05.view.ProdutoRepository;
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


    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("prod",repository.findById(codigo));
        return "cadastrar";
    }


///////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("listar")
    public String listarProdutos(Model model){
        model.addAttribute("prod", repository.findAll());
        return "resultado";
    }


////////////////////////////////////////////////////////////////////////////////////////

    /** CADASTRAR **/
    @GetMapping("cadastrar")
    public String cadastrar(Produto produto,Model model)
    {
        model.addAttribute("prod",produto);
        return "cadastrar";
    }

    @PostMapping("cadastrar")
    public String processarForm(Produto produto,Model model) {

        model.addAttribute("prod",produto);
        repository.save(produto);
        return "redirect:/produto/listar";
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

    /** PESQUISAR  POR PREÇO MAIOR QUE ..**/
    @GetMapping("bpreco")
    public String buscarPorPrecoMaiorQue(){
       return "buscar";
    }

    @PostMapping("bpreco")
    public String buscarPorPrecoMaiorQue(double preco, Model model){
       List<Produto> produtos = repository.findByPrecoGreaterThan(preco);
       model.addAttribute("prod",produtos);
       return  "resultado";
    }




////////////////////////////////////////////////////////////////////////////////////////
    /** BUSCAR PRODUTOS NOVOS E ORDENALOS POR NOME EM ORDEM DESC  **/

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
    /**  BUSCAR NOMES E ORDENALOS POR PREÇO EM ORDEM ASC (IGNORANDO CAIXA BAIXA OU ALTA)  **/

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
@GetMapping("home")
public String abrirHome(){
    return "home";
}

}

 /**   @GetMapping("home")
    public String abrirHome(){
        return "template";
    }**/

