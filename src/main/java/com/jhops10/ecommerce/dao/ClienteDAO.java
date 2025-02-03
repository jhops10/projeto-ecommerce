package com.jhops10.ecommerce.dao;

import com.jhops10.ecommerce.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

    public Cliente findByTelefone(String telefone);
}
