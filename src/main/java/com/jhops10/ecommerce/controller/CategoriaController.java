package com.jhops10.ecommerce.controller;

import com.jhops10.ecommerce.model.Categoria;
import com.jhops10.ecommerce.service.categoria.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> recuperarTodas() {
        return ResponseEntity.ok(categoriaService.listarTudo());
    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> adicionarNova(@RequestBody Categoria categoria) {
        Categoria result = categoriaService.criarNova(categoria);
        if (result != null) {
            return ResponseEntity.status(201).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria, @PathVariable Integer id) {
        categoria.setId(id);
        try {
            Categoria result = categoriaService.alterar(categoria);
            if (result != null) {
                return ResponseEntity.ok(result);
            }

        } catch (Exception ex) {
            System.out.println("LOG - Erro ao atualizar " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> removerCategoria(@PathVariable Integer id) {
        categoriaService.apagar(id);
        return ResponseEntity.ok("Removed");
    }


}
