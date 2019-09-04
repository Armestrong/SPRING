package br.com.fiap.exemploh2.controller;


import br.com.fiap.exemploh2.entity.Produto;
import br.com.fiap.exemploh2.view.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    @GetMapping("{codigo}")
    public Produto buscar(@PathVariable int codigo) {
        return repository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @PutMapping("{id}")
    public Produto atualizar(@RequestBody Produto produto,
                             @PathVariable int id) {
        produto.setCodigo(id);
        return repository.save(produto);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo){
        repository.deleteById(codigo);
    }

    ///////////////////////////////////////////////////////////////////
   @GetMapping("pesquisa")
    public List<Produto> buscar(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "false") Boolean novo){
       /* System.out.println(nome);
        System.out.println(novo);
        return repository.findByNome(nome);*/
       return nome!=null?
               repository.findByNomeAndNovo(nome,novo):
               repository.findByNovo(novo);
      // http://localhost:8080/produto/pesquisa?nome=Tenis&novo=false
    }
///////////////////////////////////////////////////////////////////////////////
  /*  @GetMapping("pesquisa")
    public List<Produto> buscar(@RequestParam(required = false) String nome){
        return repository.findByNome(nome);

      //  http://localhost:8080/produto/pesquisa?nome=morango
    }*/


}