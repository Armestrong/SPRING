package br.com.fiap.exemploh2.view;

import br.com.fiap.exemploh2.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository
        extends JpaRepository<Produto,Integer> {

    List<Produto> findByNome (String nome);
    List<Produto> findByCodigo (int codigo);

}