package com.jhops10.ecommerce.service.categoria;

import com.jhops10.ecommerce.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    public Categoria criarNova(Categoria categoria);
    public Categoria alterar(Categoria categoria);
    public List<Categoria> listarTudo();
    public void apagar(Integer id);
}
