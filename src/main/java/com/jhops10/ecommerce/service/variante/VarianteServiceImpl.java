package com.jhops10.ecommerce.service.variante;

import com.jhops10.ecommerce.dao.VarianteDAO;
import com.jhops10.ecommerce.model.Produto;
import com.jhops10.ecommerce.model.Variante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VarianteServiceImpl implements IVarianteService {

    @Autowired
    private VarianteDAO varianteDAO;


    @Override
    public Variante adicionarNova(Variante variante) {
        return varianteDAO.save(variante);
    }

    @Override
    public Variante alterarDados(Variante variante) {
        return varianteDAO.save(variante);
    }

    @Override
    public List<Variante> recuperarPorProduto(Produto produto) {
        return varianteDAO.findByProduto(produto);
    }

    @Override
    public Variante recuperarPeloId(Integer id) {
        return varianteDAO.findById(id).orElse(null);
    }
}
