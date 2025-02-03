package com.jhops10.ecommerce.service.cliente;

import com.jhops10.ecommerce.model.Cliente;

import java.util.List;

public interface IClienteService {

    public Cliente cadastrarNovoCliente(Cliente cliente);
    public Cliente alterarCliente(Cliente cliente);
    public Cliente recuperarClientePeloId(Integer id);
    public Cliente recuperarClientePeloTelefone(String telefone);
    public List<Cliente> recuperarTodos();
}
