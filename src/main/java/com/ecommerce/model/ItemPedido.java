package com.ecommerce.model;

public class ItemPedido {
  private Long id;
  private Produto produto;
  private int quantidade;

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public Produto getProduto() {
      return produto;
  }

  public void setProduto(Produto produto) {
      this.produto = produto;
  }

  public int getQuantidade() {
      return quantidade;
  }

  public void setQuantidade(int quantidade) {
      this.quantidade = quantidade;
  }
}
