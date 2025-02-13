package com.jhops10.ecommerce.controller;

import com.jhops10.ecommerce.model.Usuario;
import com.jhops10.ecommerce.security.ECToken;
import com.jhops10.ecommerce.service.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> cadastrarNovo(@RequestBody Usuario usuario) {
        Usuario result = usuarioService.cadastrarNovo(usuario);
        if (result != null) {
            return ResponseEntity.status(201).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<ECToken> realizarLogin(@RequestBody Usuario usuario) {
        ECToken token = usuarioService.fazerLogin(usuario.getLogin(), usuario.getSenha());
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> alterarDados(@RequestBody Usuario usuario, @PathVariable Integer id) {
        usuario.setIdUsuario(id);
        try {
            Usuario res = usuarioService.alterarDados(usuario);
            if (res != null) {
                return ResponseEntity.ok(res);
            }

        } catch (Exception ex) {
            System.out.println("LOG - Erro ao atualizar " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }


}
