package com.jhops10.ecommerce.service.pedido;

import com.jhops10.ecommerce.model.Pedido;

import java.util.List;

public interface IPedidoService {

    public Pedido criarNovoPedido(Pedido pedido);
    public Pedido alterarDados(Pedido pedido);
    public List<Pedido> recuperarTodos();
    public Pedido recuperarPeloNumero(Integer numPedido);
    public List<Pedido> recuperarPorStatus(Integer status);

}
