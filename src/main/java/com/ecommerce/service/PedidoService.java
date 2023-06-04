package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Pedido;
import com.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {
  
  @Autowired
  private PedidoRepository pedidoRepository;

  public List<Pedido> getAllPedidos() {
    return pedidoRepository.findAll();
  }

  public Pedido getPedidoById(Long id) {
    return pedidoRepository.findById(id).orElse(null);
  }

  public Pedido savePedido(Pedido pedido) {
    return pedidoRepository.save(pedido);
  }

  public void deletePedido(Long id) {
    pedidoRepository.deleteById(id);
  }
}
