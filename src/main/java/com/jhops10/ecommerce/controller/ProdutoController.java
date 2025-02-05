package com.jhops10.ecommerce.controller;

import com.jhops10.ecommerce.model.Categoria;
import com.jhops10.ecommerce.model.Produto;
import com.jhops10.ecommerce.service.produto.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private IProdutoService produtoService;

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> recuperarTodos() {
        return ResponseEntity.ok(produtoService.recuperarTodos());
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> recuperarPeloId(@PathVariable Integer id) {
        Produto result = produtoService.buscarPeloId(id);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/search")
    public ResponseEntity<List<Produto>> recuperarPorPalavraChave(@RequestParam(name = "key") String key) {
        List<Produto> lista = produtoService.recuperarPorPalavraChave(key);
        if (lista.size() > 0) {
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/categoria/{id}")
    public ResponseEntity<List<Produto>> recuperarPorCategoria(@PathVariable Integer id) {
        Categoria categ = new Categoria();
        categ.setId(id);
        return ResponseEntity.ok(produtoService.buscarPorCategoria(categ));
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> cadastrarNovo(@RequestBody Produto produto) {
        Produto result = produtoService.cadastrarNovo(produto);
        if (result != null) {
            return ResponseEntity.status(201).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> alterarProduto(@RequestBody Produto produto, @PathVariable Integer id) {
        produto.setId(id);
        try {
            Produto result = produtoService.alterarProduto(produto);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        } catch (Exception ex) {
            System.out.println("LOG - Erro ao atualizar " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
