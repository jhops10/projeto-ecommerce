package com.jhops10.ecommerce.service.usuario;

import com.jhops10.ecommerce.dao.UsuarioDAO;
import com.jhops10.ecommerce.model.Usuario;
import com.jhops10.ecommerce.security.ECToken;
import com.jhops10.ecommerce.security.ECTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario cadastrarNovo(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(usuario.getSenha());
        usuario.setSenha(novaSenha);
        return usuarioDAO.save(usuario);
    }

    @Override
    public Usuario alterarDados(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(usuario.getSenha());
        usuario.setSenha(novaSenha);
        return usuarioDAO.save(usuario);
    }

    @Override
    public ECToken fazerLogin(String login, String senha) {
        Usuario res = usuarioDAO.findByLogin(login);
        if (res != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(senha, res.getSenha())) {
                return ECTokenUtil.generateToken(res);
            }
        }
        return null;
    }
}
