package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Cliente;
import com.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {
  
  @Autowired
  private ClienteRepository clienteRepository;

  public List<Cliente> getAllClientes() {
    return clienteRepository.findAll();
  }

  public Cliente getClienteById(Long id) {
    return clienteRepository.findById(id).orElse(null);
  }

  public Cliente saveCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  public void deleteCliente(Long id) {
    clienteRepository.deleteById(id);
  }
}