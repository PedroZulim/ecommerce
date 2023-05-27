package com.ecommerce.model;

import java.util.List;

public class Pedido {
  private Long id;
  private Cliente cliente;
  private List<ItemPedido> itens;

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public Cliente getCliente() {
      return cliente;
  }

  public void setCliente(Cliente cliente) {
      this.cliente = cliente;
  }

  public List<ItemPedido> getItens() {
      return itens;
  }

  public void setItens(List<ItemPedido> itens) {
      this.itens = itens;
  }
}