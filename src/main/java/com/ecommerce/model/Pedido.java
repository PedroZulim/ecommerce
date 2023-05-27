package com.ecommerce.Model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pedido {
    private Long id;
    private Cliente cliente;
    private List<ItemPedido> itens;
}