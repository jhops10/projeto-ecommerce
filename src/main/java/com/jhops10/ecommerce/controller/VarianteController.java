package com.jhops10.ecommerce.controller;

import com.jhops10.ecommerce.model.Produto;
import com.jhops10.ecommerce.model.Variante;
import com.jhops10.ecommerce.service.variante.IVarianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VarianteController {

    @Autowired
    private IVarianteService varianteService;

    @GetMapping("/variantes")
    public ResponseEntity<List<Variante>> recuperarPeloProduto(@RequestParam(name = "idproduto") Integer idproduto) {
        Produto prod = new Produto();
        prod.setId(idproduto);
        return ResponseEntity.ok(varianteService.recuperarPorProduto(prod));
    }

    @GetMapping("/variantes/{id}")
    public ResponseEntity<Variante> recuperarPorId(@PathVariable Integer id) {
        Variante v = varianteService.recuperarPeloId(id);
        if (v != null) {
            return ResponseEntity.ok(v);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/variantes")
    public ResponseEntity<Variante> adicionar(@RequestBody Variante variante) {
        Variante v = varianteService.adicionarNova(variante);
        if (v != null) {
            return ResponseEntity.ok(v);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("variantes/{id}")
    public ResponseEntity<Variante> modificar(@RequestBody Variante variante, @PathVariable Integer id) {
        variante.setId(id);
        try {
            Variante v = varianteService.alterarDados(variante);
            if (v != null) {
                return ResponseEntity.ok(v);
            }
        } catch (Exception ex) {
            System.out.println("LOG - Erro ao atualizar " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }


}
