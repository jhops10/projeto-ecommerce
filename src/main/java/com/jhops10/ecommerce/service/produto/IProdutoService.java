package com.jhops10.ecommerce.service.produto;

import com.jhops10.ecommerce.model.Categoria;
import com.jhops10.ecommerce.model.Produto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProdutoService {
    public Produto cadastrarNovo(Produto produto);
    public Produto buscarPeloId(Integer id);
    public Produto alterarProduto(Produto produto);
    public Page<Produto> recuperarTodos(Integer numPagina);
    public List<Produto> recuperarPorPalavraChave(String palavraChave);
    public List<Produto> buscarPorCategoria(Categoria categoria);

}
