package com.jhops10.ecommerce.service.usuario;

import com.jhops10.ecommerce.model.Usuario;
import com.jhops10.ecommerce.security.ECToken;

public interface IUsuarioService {

    public Usuario cadastrarNovo(Usuario usuario);
    public Usuario alterarDados(Usuario usuario);
    public ECToken fazerLogin(String login, String senha);
}
