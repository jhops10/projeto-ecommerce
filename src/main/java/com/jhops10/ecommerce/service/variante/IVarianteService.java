package com.jhops10.ecommerce.service.variante;

import com.jhops10.ecommerce.model.Produto;
import com.jhops10.ecommerce.model.Variante;

import java.util.List;

public interface IVarianteService {

    public Variante adicionarNova(Variante variante);
    public Variante alterarDados(Variante variante);
    public List<Variante> recuperarPorProduto(Produto produto);
    public Variante recuperarPeloId(Integer id);
}
