package br.com.fiap.exemplo05.view;

import br.com.fiap.exemplo05.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository
        extends JpaRepository<Produto,Integer> {

    List<Produto> findByNome(String nome);
    List<Produto> findByCodigo(int codigo);
    List<Produto> findByNomeAndNovo(String nome, boolean novo);
   // List<Produto> findByPrecoMaiorQue(double preco);
    List<Produto> findByNovoOrderByNomeDesc(boolean novo);
    List<Produto> findByNomeIgnoreCaseOrderByPrecoAsc(String nome);

}