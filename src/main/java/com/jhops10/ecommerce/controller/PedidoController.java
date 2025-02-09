package com.jhops10.ecommerce.controller;

import com.jhops10.ecommerce.model.Pedido;
import com.jhops10.ecommerce.service.pedido.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> inserirNovo(@RequestBody Pedido pedido) {
        Pedido res = pedidoService.criarNovoPedido(pedido);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> recuperarTodos() {
        return ResponseEntity.ok(pedidoService.recuperarTodos());
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> recuperarPeloId(@PathVariable Integer id) {
       Pedido res = pedidoService.recuperarPeloNumero(id);
       if (res != null) {
           return ResponseEntity.ok(res);
       }
       return ResponseEntity.notFound().build();
    }
}
