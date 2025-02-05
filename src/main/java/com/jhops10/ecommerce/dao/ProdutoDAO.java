package com.jhops10.ecommerce.dao;

import com.jhops10.ecommerce.model.Categoria;
import com.jhops10.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

    public List<Produto> findByNomeContaining(String palavraChave);
    public List<Produto> findByOrderByNomeAsc();
    public List<Produto> findByCategoriasContaining(Categoria categoria);
}
