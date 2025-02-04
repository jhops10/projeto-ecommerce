package com.jhops10.ecommerce.dao;

import com.jhops10.ecommerce.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CategoriaDAO extends CrudRepository<Categoria, Integer> {

    public List<Categoria> findAllByOrderByNomeAsc();
}
