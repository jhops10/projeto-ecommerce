package com.jhops10.ecommerce.service.produto;

import com.jhops10.ecommerce.model.Categoria;
import com.jhops10.ecommerce.model.Produto;

import java.util.List;

public interface IProdutoService {
    public Produto cadastrarNovo(Produto produto);
    public Produto buscarPeloId(Integer id);
    public Produto alterarProduto(Produto produto);
    public List<Produto> recuperarTodos();
    public List<Produto> recuperarPorPalavraChave(String palavraChave);
    public List<Produto> buscarPorCategoria(Categoria categoria);

}
