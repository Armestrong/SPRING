package br.com.fiap.exemploh2.view;

import br.com.fiap.exemploh2.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository
        extends JpaRepository<Produto,Integer> {
}