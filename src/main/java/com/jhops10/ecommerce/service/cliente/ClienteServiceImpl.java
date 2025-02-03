package com.jhops10.ecommerce.service.cliente;

import com.jhops10.ecommerce.dao.ClienteDAO;
import com.jhops10.ecommerce.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteDAO clienteDAO;


    @Override
    public Cliente cadastrarNovoCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Cliente alterarCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Cliente recuperarClientePeloId(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public Cliente recuperarClientePeloTelefone(String telefone) {
        return clienteDAO.findByTelefone(telefone);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return (List<Cliente>) clienteDAO.findAll();
    }
}
