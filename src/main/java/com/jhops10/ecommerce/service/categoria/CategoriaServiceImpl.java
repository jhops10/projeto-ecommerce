package com.jhops10.ecommerce.service.categoria;

import com.jhops10.ecommerce.dao.CategoriaDAO;
import com.jhops10.ecommerce.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public Categoria criarNova(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public Categoria alterar(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public List<Categoria> listarTudo() {
        return (List<Categoria>) categoriaDAO.findAllByOrderByNomeAsc();
    }

    @Override
    public void apagar(Integer id) {
        categoriaDAO.deleteById(id);
    }
}
