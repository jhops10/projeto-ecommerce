package com.jhops10.ecommerce.dao;

import com.jhops10.ecommerce.model.Produto;
import com.jhops10.ecommerce.model.Variante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VarianteDAO extends CrudRepository<Variante, Integer> {

    public List<Variante> findByProduto(Produto produto);

}
