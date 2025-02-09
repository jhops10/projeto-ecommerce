package com.jhops10.ecommerce.dao;

import com.jhops10.ecommerce.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

    public Usuario findByLogin(String login);
}
