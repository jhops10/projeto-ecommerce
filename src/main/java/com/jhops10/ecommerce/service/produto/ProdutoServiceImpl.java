package com.jhops10.ecommerce.service.produto;

import com.jhops10.ecommerce.dao.ProdutoDAO;
import com.jhops10.ecommerce.model.Categoria;
import com.jhops10.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoDAO produtoDAO;

    private static final int PAGE_SIZE = 5;

    @Override
    public Produto cadastrarNovo(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public Produto buscarPeloId(Integer id) {
        return produtoDAO.findById(id).orElse(null);
    }

    @Override
    public Produto alterarProduto(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public Page<Produto> recuperarTodos(Integer numPagina) {

        Pageable pageable = PageRequest.of(numPagina-1, PAGE_SIZE);
        return produtoDAO.findByOrderByNomeAsc(pageable);
    }

    @Override
    public List<Produto> recuperarPorPalavraChave(String palavraChave) {
        return produtoDAO.findByNomeContaining(palavraChave);
    }

    @Override
    public List<Produto> buscarPorCategoria(Categoria categoria) {
        return produtoDAO.findByCategoriasContaining(categoria);
    }
}
